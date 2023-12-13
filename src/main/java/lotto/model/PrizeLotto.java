package lotto.model;

public class PrizeLotto {

    private final Lotto prizeLotto;
    private final Integer bonusNumber;

    public PrizeLotto(Lotto prizeLotto, Integer bonusNumber) {
        this.prizeLotto = prizeLotto;
        this.bonusNumber = bonusNumber;
    }
}
