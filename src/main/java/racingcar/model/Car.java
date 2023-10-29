package racingcar.model;

import racingcar.vo.CarDistance;
import racingcar.vo.CarName;

public class Car {

    private static final Integer INIT_DISTANCE = 0;

    private final CarName carName;
    private CarDistance carDistance;

    public Car(final CarName carName) {
        this.carName = carName;
        this.carDistance = new CarDistance(INIT_DISTANCE);
    }

    public void changeState() {
        Integer previousDistance = this.carDistance.distance();
        this.carDistance = new CarDistance(previousDistance + ActionType.getRandomAction());
    }

    public CarName getCarName() {
        return carName;
    }

    public CarDistance getCarDistance() {
        return carDistance;
    }
}
