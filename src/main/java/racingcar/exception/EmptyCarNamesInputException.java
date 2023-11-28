package racingcar.exception;

public class EmptyCarNamesInputException extends IllegalArgumentException {

    public EmptyCarNamesInputException() {
        super("레이싱 게임에 참가할 자동차의 이름을 입력해주세요.");
    }
}
