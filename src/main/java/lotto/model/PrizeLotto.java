package lotto.model;

import static lotto.exception.ErrorMessage.INVALID_BONUS_NUMBER;

import lotto.exception.ExceptionWithMessage;

public class PrizeLotto {

    private final Lotto prizeLotto;
    private final Integer bonusNumber;

    public PrizeLotto(Lotto prizeLotto, Integer bonusNumber) {
        validateDuplicateNumber(prizeLotto, bonusNumber);
        this.prizeLotto = prizeLotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicateNumber(Lotto prizeLotto, Integer bonusNumber) {
        if (prizeLotto.containsNumber(bonusNumber)) {
            throw new ExceptionWithMessage(INVALID_BONUS_NUMBER.toString());
        }
    }
}
