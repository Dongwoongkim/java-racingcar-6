package racingcar.exception;

public class NonNumericTrialNumberInputException extends IllegalArgumentException {

    public NonNumericTrialNumberInputException() {
        super("시도 횟수에 문자가 포함되어 있습니다.");
    }
}
