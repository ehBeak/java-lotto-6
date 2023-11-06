package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.model.LottoPrize;
import lotto.factory.LottoFactory;
import lotto.factory.UserLotteriesFactory;
import lotto.factory.WinningLottoFactory;
import lotto.model.LottoNumbersGenerator;
import lotto.utils.LottoProfitCalculator;
import lotto.model.UserLotteries;
import lotto.model.WinningLotto;
import lotto.utils.UsersPrizeLottoCounter;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoDrawController {

    private final InputView inputView;
    private final OutputView outputView;
    private final UserLotteriesFactory userLotteriesFactory;
    private final LottoFactory lottoFactory;
    private final WinningLottoFactory winningLottoFactory;

    public LottoDrawController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoFactory = new LottoFactory(new LottoNumbersGenerator());
        this.userLotteriesFactory = new UserLotteriesFactory(lottoFactory);
        this.winningLottoFactory = new WinningLottoFactory(lottoFactory);
    }

    public void startDraw() {
        Integer purchaseAmount = inputView.getPurchaseAmount();
        Integer countOfPurchasedLotto = UserLotteriesFactory.calculateCountOfPurchasedLotto(purchaseAmount);
        UserLotteries userLotteries = userLotteriesFactory.createFromPurchaseAmount(purchaseAmount);

        showUserLottoDetails(countOfPurchasedLotto, userLotteries);
        WinningLotto winningLotto = createWinningLotto();

        Map<LottoPrize, Long> winningCountPerLottoPrize = UsersPrizeLottoCounter.countPrizeLotto(winningLotto, userLotteries);
        Double lottoProfitPercentage =
                LottoProfitCalculator.findLottoProfitPercentage(winningCountPerLottoPrize, purchaseAmount);

        showDrawResult(winningCountPerLottoPrize, lottoProfitPercentage);
    }

    private void showUserLottoDetails(Integer countOfPurchasedLotto, UserLotteries userLotteries) {
        outputView.printPurchasedCountMessage(countOfPurchasedLotto);
        outputView.printUserLotteries(userLotteries);
    }

    private WinningLotto createWinningLotto() {
        List<String> drawnNumbers = inputView.getDrawnNumbers();
        Integer bonusNumber = inputView.getBonusNumber(drawnNumbers);
        return winningLottoFactory.createWinningLotto(drawnNumbers, bonusNumber);
    }

    public void showDrawResult(Map<LottoPrize, Long> winningCountPerLottoPrize, Double lottoProfitPercentage) {
        outputView.printLottoResultMessage();
        outputView.printLottoResult(winningCountPerLottoPrize);
        outputView.printLottoTotalProfit(lottoProfitPercentage);
    }

}