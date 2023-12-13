package lotto.util.validation;

import static lotto.exception.ErrorMessage.INVALID_LOTTO_NUMBERS_FORMAT;
import static lotto.exception.ErrorMessage.INVALID_PRICE;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lotto.exception.ExceptionWithMessage;

public class UserInputValidator {

    private static final int ZERO = 0;
    private static final int LOTTO_PRICE = 1000;
    private static final String DELIMITER = ",";
    private static final String LOTTO_NUMBERS_PATTERN = "^[0-9,]*$";

    public static int validateLottoPrice(String lottoPrice) {
        int lottoPriceNumber = validateNumber(lottoPrice);
        validatePositiveNumber(lottoPriceNumber);
        validateMultipleOfThousand(lottoPriceNumber);
        return lottoPriceNumber;
    }

    public static List<String> validateLottoNumbers(String lottoNumbers) {
        validateStartWithDelimiter(lottoNumbers);
        validateConsecutiveDelimiter(lottoNumbers);
        validateLottoNumbersFormat(lottoNumbers);
        return Arrays.asList(lottoNumbers.split(DELIMITER));
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

    private static void validateStartWithDelimiter(String lottoNumbers) {
        if (lottoNumbers.startsWith(DELIMITER) || lottoNumbers.endsWith(DELIMITER)) {
            throw new ExceptionWithMessage(INVALID_LOTTO_NUMBERS_FORMAT.toString());
        }
    }

    private static void validateConsecutiveDelimiter(String lottoNumbers) {
        if (lottoNumbers.contains(DELIMITER + DELIMITER)) {
            throw new ExceptionWithMessage(INVALID_LOTTO_NUMBERS_FORMAT.toString());
        }
    }

    private static void validateLottoNumbersFormat(String lottoNumbers) {
        Pattern pattern = Pattern.compile(LOTTO_NUMBERS_PATTERN);
        Matcher matcher = pattern.matcher(lottoNumbers);
        if (!matcher.matches()) {
            throw new ExceptionWithMessage(INVALID_LOTTO_NUMBERS_FORMAT.toString());
        }
    }
}
