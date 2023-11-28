package racingcar.exception;

public class EmptyNameException extends IllegalArgumentException {

    public EmptyNameException() {
        super("자동차 이름에 빈 값이 포함되어 있습니다.");
    }
}
