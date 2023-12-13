package lotto.model;

import static lotto.exception.ErrorMessage.DUPLICATED_NOT_ALLOWED;
import static lotto.exception.ErrorMessage.INVALID_BONUS_NUMBER;
import static lotto.exception.ErrorMessage.INVALID_LOTTO_NUMBERS_FORMAT;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.ExceptionWithMessage;

public class Lotto {

    private static final int MAX_NUMBER = 45;
    private static final int MIN_NUMBER = 1;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicated(numbers);
        validateNumbersRange(numbers);
        this.numbers = numbers;
    }

    public Boolean containsNumber(Integer number) {
        return numbers.contains(number);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new ExceptionWithMessage(INVALID_LOTTO_NUMBERS_FORMAT.toString());
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

    public List<Integer> getNumbers() {
        return numbers;
    }
}
