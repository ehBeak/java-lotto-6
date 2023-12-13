package lotto.exception;

public enum ErrorMessage {

    INVALID_PRICE("1000원 단위의 양수만 입력할 수 있습니다."),
    POSITIVE_NUMBER_ALLOWED("양수만 입력할 수 있습니다."),
    NUMBER_ALLOWED("숫자만 입력할 수 있습니다."),
    INVALID_LOTTO_NUMBERS_FORMAT("유효하지 않은 로또 번호입력 형식입니다."),
    INVALID_BONUS_NUMBER("유효하지 않은 보너스 번호입니다."),
    ERROR_MESSAGE("[ERROR]");

    ErrorMessage(String message) {
        this.message = message;
    }

    private final String message;

    @Override
    public String toString() {
        return String.join(" ", ERROR_MESSAGE.message, message);
    }
}
