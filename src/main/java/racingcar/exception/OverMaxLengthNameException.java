package racingcar.exception;

public class OverMaxLengthNameException extends IllegalArgumentException {

    public OverMaxLengthNameException(Integer maxLength) {
        super("자동차의 최대 길이는 " + maxLength + "입니다");
    }
}
