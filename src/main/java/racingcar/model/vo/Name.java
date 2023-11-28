package racingcar.model.vo;

public class Name {

    private static final Integer MAX_LENGTH = 5;

    private final String name;

    private Name(String name) {
        this.name = name;
    }

    public static Name create(String name) {
        validate(name);
        return new Name(name);
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
}
