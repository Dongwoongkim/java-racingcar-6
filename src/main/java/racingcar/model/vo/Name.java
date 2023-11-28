package racingcar.model.vo;

import racingcar.exception.EmptyNameException;
import racingcar.exception.OverMaxLengthNameException;

public class Name {

    private static final Integer MAX_LENGTH = 5;

    private final String name;

    public Name(final String name) {
        validate(name);
        this.name = name;
    }

    private static void validate(final String name) {
        if (name.isEmpty()) {
            throw new EmptyNameException();
        }
        if (isOverMaxLength(name)) {
            throw new OverMaxLengthNameException(MAX_LENGTH);
        }
    }

    private static boolean isOverMaxLength(final String name) {
        return name.length() > MAX_LENGTH;
    }

    public String get() {
        return name;
    }
}
