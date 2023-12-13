package lotto.controller;

import lotto.model.Lotteries;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void generateLotto() {
        Lotteries lotteries = inputView.inputLottoPrice();
    }
}
