package racingcar.model;

import racingcar.model.vo.Name;

public class Car {

    private static final Integer START_POINT = 0;

    private final Name name;
    private Distance distance;

    private Car(String name) {
        this.name = new Name(name);
        this.distance = new Distance(START_POINT);
    }

    public static Car create(String name) {
        return new Car(name);
    }

    public void play() {
        // TODO : 난수 생성기에 의해 출발/정지 기능 구현
    }

    public Name getName() {
        return name;
    }

    public Distance getDistance() {
        return distance;
    }
}
