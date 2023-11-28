package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator implements NumberGenerator {

    @Override
    public Integer pickNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
