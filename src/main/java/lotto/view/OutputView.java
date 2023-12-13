package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.model.WinningRule;

public class OutputView {

    private static final String LOTTO_COUNT_MESSAGE = "%s개를 구매했습니다.";
    private static final String LOTTO_FORMAT = "[%s]";
    private static final String PRIZE_RESULT_MESSAGE = "\n당첨 통계\n---";
    private static final String PRIZE_RESULT_FORMAT = "%s - %d개";
    private static final String PROFIT_RATE_FORMAT = "총 수익률은 %.2f%입니다.";

    public void printLottoCount(int lottoCount) {
        System.out.println(String.format(LOTTO_COUNT_MESSAGE, lottoCount));
    }

    public void printLotteriesNumber(List<List<String>> lotteriesNumbers) {
        lotteriesNumbers.forEach(lottoNumbers -> System.out.println(
                String.format(LOTTO_FORMAT, String.join(", ", lottoNumbers))));
    }

    public void printPrizeResult(Map<WinningRule, Long> countResult) {
        System.out.println(PRIZE_RESULT_MESSAGE);
        for (WinningRule key : countResult.keySet()) {
            System.out.println(String.format(PRIZE_RESULT_FORMAT, key.toString(), countResult.get(key)));
        }
    }

    public void printProfitRate(Double profitRate) {
        System.out.println(String.format(PROFIT_RATE_FORMAT, profitRate));
    }
}
