package lotto.view;

import java.util.List;

public class OutputView {

    private static final String LOTTO_COUNT_MESSAGE = "%s개를 구매했습니다.";
    private static final String LOTTO_FORMAT = "[%s]";

    public void printLottoCount(int lottoCount) {
        System.out.println(String.format(LOTTO_COUNT_MESSAGE, lottoCount));
    }

    public void printLotteriesNumber(List<List<String>> lotteriesNumbers) {
        lotteriesNumbers.forEach(lottoNumbers -> System.out.println(
                String.format(LOTTO_FORMAT, String.join(", ", lottoNumbers))));
    }
}
