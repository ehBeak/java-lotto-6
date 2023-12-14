package lotto.model;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import java.util.function.BiPredicate;
import lotto.exception.ExceptionWithMessage;

public enum WinningRule {

    FIFTH_PRIZE((bonusMatch, count) -> count == 3, 5_000, 3),
    FOURTH_PRIZE((bonusMatch, count) -> count == 4, 50_000, 4),
    THIRD_PRIZE((bonusMatch, count) -> !bonusMatch && count == 5, 1_500_000, 5),
    SECOND_PRIZE((bonusMatch, count) -> bonusMatch && count == 5, 30_000_000, 5),
    FIRST_PRIZE((bonusMatch, count) -> count == 6, 2_000_000_000, 6);

    private final BiPredicate<Boolean, Long> biPredicate;
    private final Integer prizeAmount;
    private final Integer matchNumberCount;

    WinningRule(BiPredicate<Boolean, Long> biPredicate, Integer prizeAmount, Integer matchNumberCount) {
        this.biPredicate = biPredicate;
        this.prizeAmount = prizeAmount;
        this.matchNumberCount = matchNumberCount;
    }

    public static Map<WinningRule, Long> countResult(PrizeLotto prizeLotto, Lotteries lotteries) {
        EnumMap<WinningRule, Long> prizeResult = new EnumMap<>(WinningRule.class);

        for (WinningRule winningRule : WinningRule.values()) {
            long count = lotteries.getLotteries()
                    .stream()
                    .filter(lotto -> isMatch(prizeLotto, winningRule, lotto))
                    .count();
            prizeResult.put(winningRule, count);
        }
        return prizeResult;
    }

    public static WinningRule valueOf(Boolean hasBonusNumber, Long countMatchNumber) {
        return Arrays.stream(WinningRule.values())
                .filter(lottoPrize -> lottoPrize.biPredicate.test(hasBonusNumber, countMatchNumber))
                .findAny()
                .orElseThrow(() -> new ExceptionWithMessage("[ERROR] 보너스 넘버와 로또에 맞는 등수가 없습니다."));
    }

    private static boolean isMatch(PrizeLotto prizeLotto, WinningRule winningRule, Lotto lotto) {
        return winningRule.biPredicate.test(prizeLotto.isMatchBonus(lotto), prizeLotto.countMatchNumber(lotto));
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(matchNumberCount).append("개 일치");
        if (this == SECOND_PRIZE) {
            stringBuilder.append(", 보너스 볼 일치");
        }
        stringBuilder.append(" (").append(String.format("%,d", prizeAmount)).append("원)");

        return stringBuilder.toString();
    }

    public Integer getPrizeAmount() {
        return prizeAmount;
    }
}
