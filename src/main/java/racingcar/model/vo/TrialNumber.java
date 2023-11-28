package racingcar.model.vo;

public class TrialNumber {

    private static final Integer MIN_TRIAL_NUMBER = 1;

    private final Integer number;

    public TrialNumber(Integer number) {
        validate(number);
        this.number = number;
    }

    private void validate(Integer number) {
        if (isLessThanMinTrialNumber(number)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isLessThanMinTrialNumber(Integer number) {
        return number < MIN_TRIAL_NUMBER;
    }
}
