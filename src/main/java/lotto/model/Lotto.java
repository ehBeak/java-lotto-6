package lotto.model;

import static lotto.exception.ErrorMessage.DUPLICATED_NOT_ALLOWED;
import static lotto.exception.ErrorMessage.INVALID_BONUS_NUMBER;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.ExceptionWithMessage;

public class Lotto {
    /*
    제공된 Lotto 클래스를 활용해 구현해야 한다.
    numbers의 접근 제어자인 private을 변경할 수 없다.
    Lotto에 필드(인스턴스 변수)를 추가할 수 없다.
    Lotto의 패키지 변경은 가능하다.
     */
    private static final int MAX_NUMBER = 45;
    private static final int MIN_NUMBER = 1;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicated(numbers);
        validateNumbersRange(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicated(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>(numbers);
        if (numberSet.size() != numbers.size()) {
            throw new ExceptionWithMessage(DUPLICATED_NOT_ALLOWED.toString());
        }
    }

    private void validateNumbersRange(List<Integer> numbers) {
        numbers.forEach(this::validateNumberRange);
    }

    private void validateNumberRange(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new ExceptionWithMessage(INVALID_BONUS_NUMBER.toString());
        }
    }

    public List<String> getLottoNumbers() {
        return numbers.stream()
                .map(String::valueOf)
                .toList();
    }
}
