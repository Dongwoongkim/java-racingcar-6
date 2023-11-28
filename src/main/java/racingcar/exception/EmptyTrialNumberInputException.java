package racingcar.exception;

public class EmptyTrialNumberInputException extends IllegalArgumentException {

    public EmptyTrialNumberInputException() {
        super("시도 횟수에 빈 값은 허용되지 않습니다.");
    }
}
