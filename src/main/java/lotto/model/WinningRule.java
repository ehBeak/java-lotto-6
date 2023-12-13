package lotto.model;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.BiPredicate;

public enum WinningRule {

    FIRST_PRIZE((bonusMatch, count) -> bonusMatch.equals(false) && (count.equals(6L)), 2_000_000_000),
    SECOND_PRIZE((bonusMatch, count) -> bonusMatch.equals(true) && (count.equals(5L)), 30_000_000),
    THIRD_PRIZE((bonusMatch, count) -> bonusMatch.equals(false) && (count.equals(5L)), 1_500_000),
    FOURTH_PRIZE((bonusMatch, count) -> bonusMatch.equals(false) && (count.equals(4L)), 50_000),
    FIFTH_PRIZE((bonusMatch, count) -> bonusMatch.equals(false) && (count.equals(3L)), 5_000),
    NONE((bonusMatch, count) -> bonusMatch.equals(false) && (count.equals(0)), 5_000);

    private final BiPredicate<Boolean, Long> biPredicate;
    private final Integer prizeAmount;

    WinningRule(BiPredicate biPredicate, Integer prizeAmount) {
        this.biPredicate = biPredicate;
        this.prizeAmount = prizeAmount;
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
}
