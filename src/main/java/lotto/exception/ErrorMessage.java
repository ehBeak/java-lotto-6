package lotto.exception;

public enum ErrorMessage {

    INVALID_PRICE("1000원 단위의 양수만 입력할 수 있습니다."),
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
