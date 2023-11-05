package lotto.view;

import static java.lang.String.format;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.UserLotteries;

public class OutputView {

    private static final String PURCHASED_LOTTO_COUNT_MESSAGE_TEMPLATE = "%s개를 구매했습니다.";
    private static final String LOTTO_RESULT_MESSAGE = "당첨 통계";
    private static final String LOTTO_RESULT_LINE_MESSAGE = "---";

    public void printPurchasedCountMessage(Integer purchasedLottoCount) {
        System.out.println(format(PURCHASED_LOTTO_COUNT_MESSAGE_TEMPLATE, purchasedLottoCount));
    }

    public void printUserLotteries(UserLotteries userLotteries) {
        List<Lotto> lotteries = userLotteries.getLotteries();
        lotteries.forEach(this::printLotto);
    }

    private void printLotto(Lotto lotto) {
        System.out.println(lotto.getNumbers());
    }

    public void printLottoResultMessage() {
        System.out.println(LOTTO_RESULT_MESSAGE);
        System.out.println(LOTTO_RESULT_LINE_MESSAGE);
    }
}
