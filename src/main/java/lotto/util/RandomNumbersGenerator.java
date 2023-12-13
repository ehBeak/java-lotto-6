package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.function.Supplier;

public class RandomNumbersGenerator implements Supplier<List<Integer>> {

    @Override
    public List<Integer> get() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
