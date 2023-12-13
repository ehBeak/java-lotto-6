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

    public Lotto createPrizeLotto(List<String> LottoNumbers) {
        List<Integer> prizeLottoNumbers =
                LottoNumbers.stream()
                        .map(Integer::parseInt)
                        .toList();
        return new Lotto(prizeLottoNumbers);
    }
}
