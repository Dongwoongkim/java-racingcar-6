package racingcar.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Cars {

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
        if (duplicateNameContains(names)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean duplicateNameContains(final List<String> names) {
        Set<String> distinctNames = new HashSet<>(names);
        return names.size() != distinctNames.size();
    }

    public void playEachSession() {
        cars.forEach(car -> car.play());
    }

    public List<String> getWinnerNames() {
        int maxDistance = getMaxDistance();
        return findWinner(maxDistance);
    }

    private List<String> findWinner(final int maxDistance) {
        List<String> winners = new ArrayList<>();
        cars.forEach(car -> {
            if (car.getDistance() == maxDistance) {
                winners.add(car.getName());
            }
        });
        return winners;
    }

    private int getMaxDistance() {
        return cars.stream()
                .mapToInt(car -> car.getDistance())
                .max()
                .orElse(0);
    }

    public List<Car> getCars() {
        return cars;
    }
}
