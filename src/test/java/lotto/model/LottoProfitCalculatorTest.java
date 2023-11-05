package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import lotto.constants.LottoPrize;
import lotto.utils.LottoProfitCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoProfitCalculatorTest {

    @DisplayName("사용자의 당첨 내역과 지불 금액을 제공하면, 수익률을 제공한다.")
    @Test
    void calculateProfit() {

        //given
        Map<LottoPrize, Long> winningCountPerLottoPrize = new HashMap<>();
        winningCountPerLottoPrize.put(LottoPrize.FIRST_PRIZE, 0L);
        winningCountPerLottoPrize.put(LottoPrize.SECOND_PRIZE, 0L);
        winningCountPerLottoPrize.put(LottoPrize.THIRD_PRIZE, 0L);
        winningCountPerLottoPrize.put(LottoPrize.FOURTH_PRIZE, 0L);
        winningCountPerLottoPrize.put(LottoPrize.FIFTH_PRIZE, 1L);
        Integer purchaseMoney = 8000;

        //when
        Double lottoProfitPercentage =
                LottoProfitCalculator.findLottoProfitPercentage(winningCountPerLottoPrize, purchaseMoney);

        //then
        assertThat(lottoProfitPercentage).isEqualTo(62.5);
    }

}