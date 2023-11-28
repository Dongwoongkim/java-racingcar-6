package racingcar.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import racingcar.exception.DuplicateCarNameException;

public class Cars {

    private static final Integer START_POINT = 0;

    private final List<Car> cars;

    private Cars(final List<Car> cars) {
        this.cars = cars;
    }

    public static Cars create(final List<String> names) {
        validate(names);
        List<Car> cars = names.stream()
                .map(name -> Car.create(name))
                .collect(Collectors.toList());
        return new Cars(cars);
    }

    private static void validate(final List<String> names) {
        if (containDuplicateName(names)) {
            throw new DuplicateCarNameException();
        }
    }

    private static boolean containDuplicateName(final List<String> names) {
        Set<String> distinctNames = new HashSet<>(names);
        return names.size() != distinctNames.size();
    }

    public void playEachSession() {
        cars.forEach(car -> car.updateDistance());
    }

    public List<String> getWinnerNames() {
        int maxDistance = getMaxDistance();
        return findWinner(maxDistance);
    }

    private List<String> findWinner(final int maxDistance) {
        return cars.stream()
                .filter(car -> car.getDistance().equals(maxDistance))
                .map(Car::getName)
                .toList();
    }

    private int getMaxDistance() {
        return cars.stream()
                .mapToInt(car -> car.getDistance())
                .max()
                .orElse(START_POINT);
    }

    public List<Car> getCars() {
        return cars;
    }
}
