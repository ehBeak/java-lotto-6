package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.factory.LotteriesFactory;
import lotto.model.Lotteries;
import lotto.util.LottoIssueNumberCalculator;
import lotto.util.validation.UserInputValidator;

public class InputView {

    public static final String INPUT_LOTTO_PRICE = "구입금액을 입력해 주세요.";

    private final LotteriesFactory lotteriesFactory;

    public InputView() {
        this.lotteriesFactory = new LotteriesFactory();
    }

    public Lotteries inputLottoPrice() {
        System.out.println(INPUT_LOTTO_PRICE);
        String userInput = Console.readLine();
        int lottoPrice = UserInputValidator.validateLottoPrice(userInput);
        int countIssuedLotto = LottoIssueNumberCalculator.countIssuedLotto(lottoPrice);
        return lotteriesFactory.creatLotteries(countIssuedLotto);
    }
}
