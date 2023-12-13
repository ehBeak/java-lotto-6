package lotto.model;

import java.util.List;

public class Lotteries {

    private final List<Lotto> lotteries;

    public Lotteries(List<Lotto> lotteries) {
        this.lotteries = lotteries;
    }

    public int getIssuedLotteries() {
        return lotteries.size();
    }
}
