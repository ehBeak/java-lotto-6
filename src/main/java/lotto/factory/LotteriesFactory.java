package lotto.factory;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotteries;
import lotto.model.Lotto;

public class LotteriesFactory {

    private final LottoFactory lottoFactory;

    public LotteriesFactory() {
        this.lottoFactory = new LottoFactory();
    }

    public Lotteries creatLotteries(int issuedLottoCount) {
        List<Lotto> lotteries = new ArrayList<>();
        while (issuedLottoCount-- > 0) {
            Lotto lotto = lottoFactory.createLotto();
            lotteries.add(lotto);
        }
        return new Lotteries(lotteries);
    }
}
