package lotto.validation;

import java.util.Arrays;
import java.util.List;

public class LottoNumberValidator {

    private static final String BLANK_NOT_ALLOWED = "공백으로만 이루어진 문자열을 입력할 수 없습니다.";
    private static final String EMPTY_NOT_ALLOWED = "빈 문자열을 입력할 수 없습니다.";
    private static final String START_WITH_DELIMITER_NOT_ALLOWED = "구분자인 %s로 시작하는 문자열을 입력할 수 없습니다.";
    private static final String ENDS_WITH_DELIMITER_NOT_ALLOWED = "구분자인 %s로 끝나는 문자열을 입력할 수 없습니다.";
    private static final String ONLY_NUMBER_OR_DELIMITER_ALLOWED = "구분자 %s와 숫자로 구성된 문자열만을 입력할 수 있습니다.";
    private static final String CONSECUTIVE_DELIMITER_NOT_ALLOWED = "구분자 %s를 연속해서 입력할 수 없습니다.";

    private static final String DELIMITER = ",";
    private static final String CONSECUTIVE_DELIMITER = DELIMITER + DELIMITER;
    private static final String LOTTO_NUMBERS_PATTERN = "[0-9,]+";

    public List<String> validateLottNumbers(String lottoNumbers) {
        validateEmpty(lottoNumbers);
        validateBlank(lottoNumbers);
        validateOnlyNumberAndDelimiter(lottoNumbers);
        validateDelimiterAtBothEnds(lottoNumbers);
        validateConsecutiveDelimiter(lottoNumbers);

        return Arrays.asList(lottoNumbers.split(DELIMITER));
    }

    private void validateEmpty(String lottoNumbers) {
        if (lottoNumbers.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_NOT_ALLOWED);
        }
    }

    private void validateBlank(String lottoNumbers) {
        if (lottoNumbers.isBlank()) {
            throw new IllegalArgumentException(BLANK_NOT_ALLOWED);
        }
    }

    private void validateOnlyNumberAndDelimiter(String lottoNumbers) {
        if (lottoNumbers.matches(LOTTO_NUMBERS_PATTERN)) {
            throw new IllegalArgumentException(String.format(ONLY_NUMBER_OR_DELIMITER_ALLOWED, DELIMITER));
        }
    }

    private void validateDelimiterAtBothEnds(String lottoNumbers) {
        validateStartWithDelimiter(lottoNumbers);
        validateEndsWithDelimiter(lottoNumbers);
    }

    private void validateStartWithDelimiter(String lottoNumbers) {
        if (lottoNumbers.startsWith(DELIMITER)) {
            throw new IllegalArgumentException(String.format(START_WITH_DELIMITER_NOT_ALLOWED, DELIMITER));
        }
    }

    private void validateEndsWithDelimiter(String lottoNumbers) {
        if (lottoNumbers.endsWith(DELIMITER)) {
            throw new IllegalArgumentException(String.format(ENDS_WITH_DELIMITER_NOT_ALLOWED, DELIMITER));
        }
    }

    private void validateConsecutiveDelimiter(String lottoNumbers) {
        if (lottoNumbers.contains(CONSECUTIVE_DELIMITER)) {
            throw new IllegalArgumentException(String.format(CONSECUTIVE_DELIMITER_NOT_ALLOWED, DELIMITER));
        }
    }
}