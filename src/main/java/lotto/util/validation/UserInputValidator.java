package lotto.util.validation;

import static lotto.exception.ErrorMessage.INVALID_PRICE;

import lotto.exception.ExceptionWithMessage;

public class UserInputValidator {

    private static final int ZERO = 0;
    private static final int LOTTO_PRICE = 1000;

    public static void validateLottoPrice(String lottoPrice) {
        int lottoPriceNumber = validateNumber(lottoPrice);
        validatePositiveNumber(lottoPriceNumber);
        validateMultipleOfThousand(lottoPriceNumber);
    }

    private static int validateNumber(String lottoPrice) {
        try {
            return Integer.parseInt(lottoPrice);
        } catch (NumberFormatException e) {
            throw new ExceptionWithMessage(INVALID_PRICE.toString());
        }
    }

    private static void validatePositiveNumber(int lottoPriceNumber) {
        if (lottoPriceNumber <= ZERO) {
            throw new ExceptionWithMessage(INVALID_PRICE.toString());
        }
    }

    private static void validateMultipleOfThousand(int lottoPriceNumber) {
        if (lottoPriceNumber % LOTTO_PRICE != 0) {
            throw new ExceptionWithMessage(INVALID_PRICE.toString());
        }
    }
}
