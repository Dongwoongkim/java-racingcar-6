package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Field;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.vo.CarDistance;
import racingcar.vo.CarName;

class RacingGameTest {

    private List<CarName> carNames;
    private Cars cars;
    private Referee referee;
    private RacingGame racingGame;

    @BeforeEach
    void init() {
        carNames = List.of(new CarName("Car1"), new CarName("Car2"));
        cars = new Cars(carNames);
        referee = new Referee();
        racingGame = new RacingGame(cars, referee);
    }

    @DisplayName("자동차들이 이동한 거리는 1 증가하거나 증가하지 않는다.")
    @Test
    void playOneStep_test() {
        // given
        List<Car> carList = cars.getCarList();

        for (int i = 0; i < 1000; i++) {
            // when
            racingGame.playOneStep();
            Integer distanceOfCar1 = carList.get(0).getCarDistance().distance();
            Integer distanceOfCar2 = carList.get(1).getCarDistance().distance();

            // then
            assertTrue(distanceOfCar1 == carList.get(0).getCarDistance().distance()
                    || distanceOfCar1 == carList.get(0).getCarDistance().distance() + 1);
            assertTrue(distanceOfCar2 == carList.get(1).getCarDistance().distance()
                    || distanceOfCar1 == carList.get(1).getCarDistance().distance() + 1);
        }
    }

    @DisplayName("레이싱 게임의 우승자의 이름을 리턴한다.")
    @Test
    void getWinner_test() throws Exception {
        // given
        Car car = cars.getCarList().get(0);

        Field carDistance = Car.class.getDeclaredField("carDistance");
        carDistance.setAccessible(true);
        carDistance.set(car, new CarDistance(1));

        // when
        List<CarName> winners = racingGame.getWinners();

        // then
        assertTrue(!winners.isEmpty());
        assertEquals(winners.get(0).name(), "Car1");
    }
}
