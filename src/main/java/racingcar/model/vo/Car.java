package racingcar.model.vo;

public class Car {

    private static final Integer START_POINT = 0;
    private static final Integer MAX_LENGTH = 5;

    private final String name;
    private final Integer distance;

    private Car(String name) {
        this.name = name;
        this.distance = START_POINT;
    }

    public static Car create(String name) {
        validate(name);
        return new Car(name);
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

    public void play() {
        // TODO : 난수 생성기에 의해 출발/정지 기능 구현
    }

    public String getName() {
        return name;
    }

    public Integer getDistance() {
        return distance;
    }
}
