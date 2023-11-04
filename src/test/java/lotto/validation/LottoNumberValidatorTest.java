package lotto.validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberValidatorTest {

    @DisplayName("빈 문자열을 입력하면 에외를 발생시킨다.")
    @Test
    void emptyStringThrowIllegalArgumentException() {
        //given
        LottoNumberValidator lottoNumberValidator = new LottoNumberValidator();

        //when, then
        assertThatThrownBy(() -> lottoNumberValidator.validateLottNumbers(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("빈 문자열을 입력할 수 없습니다.");
    }

    @DisplayName("공백으로된 문자열을 입력하면 예외를 발생시킨다.")
    @Test
    void blankStringThrowException() {
        //given
        LottoNumberValidator lottoNumberValidator = new LottoNumberValidator();

        //when, then
        assertThatThrownBy(() -> lottoNumberValidator.validateLottNumbers("  "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("공백으로만 이루어진 문자열을 입력할 수 없습니다.");
    }

    @DisplayName("숫자와 구분자로만 이루어지지 않은 문자열을 입력하면 예외를 발생시킨다.")
    @Test
    void onlyNotNumberAndDelimiterThrowIllegalArgumentException() {
        //given
        LottoNumberValidator lottoNumberValidator = new LottoNumberValidator();

        //when, then
        assertThatThrownBy(() -> lottoNumberValidator.validateLottNumbers("123.324.324"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구분자 ,와 숫자로 구성된 문자열만을 입력할 수 있습니다.");
    }

    @DisplayName("구분자로 시작하는 문자열을 입력하면 예외를 발생시킨다.")
    @Test
    void startsWithDelimiterThrowIllegalArgumentException() {
        //given
        LottoNumberValidator lottoNumberValidator = new LottoNumberValidator();

        //when, then
        assertThatThrownBy(() -> lottoNumberValidator.validateLottNumbers(",1,3,2,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구분자인 ,로 시작하는 문자열을 입력할 수 없습니다.");
    }

    @DisplayName("구분자로 끝나는 문자열을 입력하면 예외를 발생시킨다.")
    @Test
    void endsWithDelimiterThrowIllegalArgumentException() {
        //given
        LottoNumberValidator lottoNumberValidator = new LottoNumberValidator();

        //when, then
        assertThatThrownBy(() -> lottoNumberValidator.validateLottNumbers("1,3,4,2,5,6,"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구분자인 ,로 끝나는 문자열을 입력할 수 없습니다.");
    }

    @DisplayName("연속적인 구분자가 있는 문자열을 입력하면 예외를 발생시킨다.")
    @Test
    void consecutiveDelimiterThrowIllegalArgumentException() {
        //given
        LottoNumberValidator lottoNumberValidator = new LottoNumberValidator();

        //when, then
        assertThatThrownBy(() -> lottoNumberValidator.validateLottNumbers("24,,53,6,,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구분자 ,를 연속해서 입력할 수 없습니다.");
    }

}