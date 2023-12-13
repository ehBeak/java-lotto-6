package lotto.factory;

import java.util.List;
import lotto.model.Lotto;
import lotto.util.RandomNumbersGenerator;

public class LottoFactory {

    private final RandomNumbersGenerator randomNumbersGenerator;

    public LottoFactory() {
        this.randomNumbersGenerator = new RandomNumbersGenerator();
    }

    public Lotto createLotto() {
        List<Integer> randomNumbers = randomNumbersGenerator.get();
        randomNumbers.sort(null);
        return new Lotto(randomNumbers);
    }
}
