package lotto.constants;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.NoSuchElementException;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoPrizeTest {

    //given
    static Stream<Arguments> generateArgument() {
        return Stream.of(
                Arguments.of(false, 6, LottoPrize.FIRST_PRIZE),
                Arguments.of(true, 5, LottoPrize.SECOND_PRIZE),
                Arguments.of(false, 5, LottoPrize.THIRD_PRIZE),
                Arguments.of(false, 4, LottoPrize.FOURTH_PRIZE),
                Arguments.of(false, 3, LottoPrize.FIFTH_PRIZE)
        );
    }

    @DisplayName("보너스 넘버 일치여부와 일치하는 당첨번호에 따라 당첨 종류를 반환한다.")
    @ParameterizedTest
    @MethodSource("generateArgument")
    void findLottoPrize(Boolean bonus, Integer matchNumber, LottoPrize result) {
        //when
        LottoPrize lottoPrize = LottoPrize.valueOf(bonus, matchNumber);

        //then
        assertThat(lottoPrize).isEqualTo(result);
    }

    @DisplayName("일치하는 당첨 번호와 보너스가 기준보다 낮으면 예외를 발생시킨다.")
    @Test
    void notFindLottoPrizeThrowNoSuchElementException() {
        //given
        Boolean bonusNumber = true;
        Integer matchNumber = 2;

        //when, then
        assertThatThrownBy(
                () -> LottoPrize.valueOf(bonusNumber, matchNumber))
                .isInstanceOf(NoSuchElementException.class)
                .hasMessage("[ERROR] 보너스 넘버와 로또에 맞는 등수가 없습니다.");
    }

}