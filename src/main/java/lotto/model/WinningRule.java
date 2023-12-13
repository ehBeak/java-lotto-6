package lotto.model;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.BiPredicate;

public enum WinningRule {

    FIFTH_PRIZE((bonusMatch, count) -> bonusMatch.equals(false) && (count.equals(3L)), 5_000, 3),
    FOURTH_PRIZE((bonusMatch, count) -> bonusMatch.equals(false) && (count.equals(4L)), 50_000, 4),
    THIRD_PRIZE((bonusMatch, count) -> bonusMatch.equals(false) && (count.equals(5L)), 1_500_000, 5),
    SECOND_PRIZE((bonusMatch, count) -> bonusMatch.equals(true) && (count.equals(5L)), 30_000_000, 5),
    FIRST_PRIZE((bonusMatch, count) -> bonusMatch.equals(false) && (count.equals(6L)), 2_000_000_000, 6);

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
