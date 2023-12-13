package lotto.view;

public class OutputView {

    private static final String LOTTO_COUNT_MESSAGE = "%s개를 구매했습니다.";

    public void printLottoCount(int lottoCount) {
        System.out.println(String.format(LOTTO_COUNT_MESSAGE, lottoCount));
    }
}
