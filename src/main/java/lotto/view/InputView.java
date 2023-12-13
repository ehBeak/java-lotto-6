package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.factory.LotteriesFactory;
import lotto.factory.LottoFactory;
import lotto.model.Lotteries;
import lotto.model.Lotto;
import lotto.model.PrizeLotto;
import lotto.util.LottoIssueNumberCalculator;
import lotto.util.validation.UserInputValidator;

public class InputView {

    public static final String INPUT_LOTTO_PRICE = "구입금액을 입력해 주세요.";
    public static final String INPUT_PRIZE_LOTTO_NUMBER = "\n당첨 번호를 입력해 주세요.";
    public static final String INPUT_BONUS_NUMBER = "\n보너스 번호를 입력해 주세요.";

    private final LotteriesFactory lotteriesFactory;
    private final LottoFactory lottoFactory;

    public InputView() {
        this.lotteriesFactory = new LotteriesFactory();
        this.lottoFactory = new LottoFactory();
    }

    public Lotteries inputLottoPrice() {
        System.out.println(INPUT_LOTTO_PRICE);
        String userInput = Console.readLine();
        int lottoPrice = UserInputValidator.validateLottoPrice(userInput);
        int countIssuedLotto = LottoIssueNumberCalculator.countIssuedLotto(lottoPrice);
        return lotteriesFactory.creatLotteries(countIssuedLotto);
    }

    public Lotto inputPrizeLottoNumbers() {
        System.out.println(INPUT_PRIZE_LOTTO_NUMBER);
        String userInput = Console.readLine();
        List<String> lottoNumbers = UserInputValidator.validateLottoNumbers(userInput);
        return lottoFactory.createPrizeLotto(lottoNumbers);
    }

    public PrizeLotto inputBonusNumber(Lotto prizeLotto) {
        System.out.println(INPUT_BONUS_NUMBER);
        String userInput = Console.readLine();
        int bonusNumber = UserInputValidator.validateBonusNumber(userInput);
        return new PrizeLotto(prizeLotto, bonusNumber);
    }
}
