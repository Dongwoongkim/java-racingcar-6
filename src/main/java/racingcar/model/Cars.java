package racingcar.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars create(List<String> names) {
        validate(names);
        List<Car> cars = names.stream()
                .map(name -> Car.create(name))
                .collect(Collectors.toList());
        return new Cars(cars);
    }

    private static void validate(List<String> names) {
        if (duplicateNameContains(names)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean duplicateNameContains(List<String> names) {
        Set<String> distinctNames = new HashSet<>(names);
        return names.size() != distinctNames.size();
    }

    public void playEachSession() {
        cars.forEach(car -> car.play());
    }

    public List<Car> getCars() {
        return cars;
    }
}
