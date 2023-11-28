package racingcar.exception;

public class LessThanMinTrialNumberException extends IllegalArgumentException {

    public LessThanMinTrialNumberException(Integer minTrialNumber) {
        super(minTrialNumber + " 이상의 정수 값을 입력하셔야 합니다.");
    }
}
