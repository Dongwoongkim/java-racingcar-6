package racingcar.model.vo;

public class Name {

    private static final Integer MAX_LENGTH = 5;

    private final String name;

    public Name(String name) {
        validate(name);
        this.name = name;
    }

    private static void validate(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException();
        }
        if (isOverMaxLength(name)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isOverMaxLength(String name) {
        return name.length() >= MAX_LENGTH;
    }

    public String get() {
        return name;
    }
}
