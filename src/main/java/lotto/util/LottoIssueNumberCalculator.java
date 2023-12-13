package lotto.util;

public class LottoIssueNumberCalculator {

    private static final int LOTTO_PRICE = 1000;

    public static int countIssuedLotto(int lottoPrice) {
        return lottoPrice / LOTTO_PRICE;
    }
}
