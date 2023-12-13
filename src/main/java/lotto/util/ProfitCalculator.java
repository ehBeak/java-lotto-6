package lotto.util;

import java.util.Map;
import lotto.model.WinningRule;

public class ProfitCalculator {

    public static Double calculateProfit(Map<WinningRule, Long> countResult, int lotteriesCount) {
        Integer totalPrizeAmount = calculateTotalPrizeAmount(countResult);
        Integer purchaseAmount = calculatePurchaseAmount(lotteriesCount);
        return ((double) totalPrizeAmount / (double) purchaseAmount) * 100.0;
    }

    private static Integer calculateTotalPrizeAmount(Map<WinningRule, Long> countResult) {
        Integer totalPrizeAmount = 0;
        for (WinningRule key : WinningRule.values()) {
            totalPrizeAmount += countResult.get(key).intValue() * key.getPrizeAmount();
        }
        return totalPrizeAmount;
    }

    private static Integer calculatePurchaseAmount(int lotteriesCount) {
        return lotteriesCount * 1000;
    }


}
