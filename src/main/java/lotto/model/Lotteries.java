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

    public List<List<String>> getIssuedLottoNumbers() {
        return lotteries.stream()
                .map(Lotto::getLottoNumbers)
                .toList();
    }

    public List<Lotto> getLotteries() {
        return lotteries;
    }
}
