package racingcar.exception;

public class DuplicateCarNameException extends IllegalArgumentException {

    public DuplicateCarNameException() {
        super("자동차 이름에 중복은 허용되지 않습니다.");
    }
}
