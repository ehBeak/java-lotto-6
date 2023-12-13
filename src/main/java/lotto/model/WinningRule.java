package lotto.model;

public enum WinningRule {

    FIRST_PRIZE(6, false, 2_000_000_000),
    SECOND_PRIZE(5, true, 30_000_000),
    THIRD_PRIZE(5, false, 1_500_000),
    FOURTH_PRIZE(4, false, 50_000),
    FIFTH_PRIZE(3, false, 5_000),
    NONE(0, false, 0);

    private final int matchingNumberCount;
    private final boolean isMatchingBonus;
    private final Integer prizeAmount;

    WinningRule(int matchingNumberCount, boolean isMatchingBonus, Integer prizeAmount) {
        this.matchingNumberCount = matchingNumberCount;
        this.isMatchingBonus = isMatchingBonus;
        this.prizeAmount = prizeAmount;
    }
}
