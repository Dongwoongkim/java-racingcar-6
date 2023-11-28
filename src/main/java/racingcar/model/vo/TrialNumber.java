package racingcar.model.vo;

import racingcar.exception.LessThanMinTrialNumberException;

public class TrialNumber {

    private static final Integer MIN_TRIAL_NUMBER = 1;

    private final Integer number;

    public TrialNumber(final Integer number) {
        validate(number);
        this.number = number;
    }

    private void validate(final Integer number) {
        if (isLessThanMinTrialNumber(number)) {
            throw new LessThanMinTrialNumberException(MIN_TRIAL_NUMBER);
        }
    }

    private boolean isLessThanMinTrialNumber(final Integer number) {
        return number < MIN_TRIAL_NUMBER;
    }

    public Integer getNumber() {
        return number;
    }
}
