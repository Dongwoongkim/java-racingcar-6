package racingcar.model;

import racingcar.model.vo.Name;

public class Car {

    private static final Integer START_POINT = 0;

    private final Name name;
    private Distance distance;

    private Car(final String name) {
        this.name = new Name(name);
        this.distance = new Distance(START_POINT);
    }

    public static Car createWithName(final String name) {
        return new Car(name);
    }

    public void updateDistance() {
        distance.addIfOverThreshold(new RandomNumberGenerator());
    }

    public String getName() {
        return name.get();
    }

    public Integer getDistance() {
        return distance.get();
    }
}
