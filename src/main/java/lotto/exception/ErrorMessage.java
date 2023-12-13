package lotto.exception;

public enum ErrorMessage {

    INVALID_PRICE("1000원 단위의 양수만 입력할 수 있습니다."),
    INVALID_LOTTO_NUMBERS_FORMAT("유효하지 않은 로또 번호입력 형식입니다."),
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
