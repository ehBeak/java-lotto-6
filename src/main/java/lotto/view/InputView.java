package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.validation.UserInputValidator;

public class InputView {

    public static final String INPUT_LOTTO_PRICE = "구입금액을 입력해 주세요.";

    public void inputLottoPrice() {
        System.out.println(INPUT_LOTTO_PRICE);
        String lottoPrice = Console.readLine();
        UserInputValidator.validateLottoPrice(lottoPrice);
    }
}
