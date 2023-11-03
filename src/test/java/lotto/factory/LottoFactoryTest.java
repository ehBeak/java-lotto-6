package lotto.factory;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoFactoryTest {

    @DisplayName("정수 리스트를 입력 받으면 그 값을 Lotto 객체로 변환한다.")
    @Test
    void convertToLotto() {
        //given
        LottoFactory lottoFactory = new LottoFactory(() -> List.of(1, 2, 3, 4, 5, 6));

        //when
        Lotto lotto = lottoFactory.createLotto();

        //then
        assertThat(lotto)
                .isNotNull()
                .isInstanceOf(Lotto.class);
    }
}