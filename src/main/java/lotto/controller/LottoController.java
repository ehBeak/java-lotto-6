package lotto.controller;

import java.util.Map;
import lotto.model.Lotteries;
import lotto.model.Lotto;
import lotto.model.PrizeLotto;
import lotto.model.WinningRule;
import lotto.util.ProfitCalculator;
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
        outputView.printLottoCount(lotteries.getIssuedLotteries());
        outputView.printLotteriesNumber(lotteries.getIssuedLottoNumbers());
        Lotto lotto = inputView.inputPrizeLottoNumbers();
        PrizeLotto prizeLotto = inputView.inputBonusNumber(lotto);
        Map<WinningRule, Long> countResult = WinningRule.countResult(prizeLotto, lotteries);
        outputView.printPrizeResult(countResult);
        Double profitRate = ProfitCalculator.calculateProfit(countResult, lotteries.getIssuedLotteries());
        outputView.printProfitRate(profitRate);
    }
}
