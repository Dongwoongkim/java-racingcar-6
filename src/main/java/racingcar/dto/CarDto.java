package racingcar.dto;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Cars;

public class CarDto {

    private String name;
    private Integer distance;

    private CarDto(String name, Integer distance) {
        this.name = name;
        this.distance = distance;
    }

    public static List<CarDto> createCarsDto(Cars cars) {
        return cars.getCars()
                .stream()
                .map(car -> CarDto.create(car.getName(), car.getDistance()))
                .collect(Collectors.toList());
    }

    public static CarDto create(String name, Integer distance) {
        return new CarDto(name, distance);
    }

    public String getName() {
        return name;
    }

    public Integer getDistance() {
        return distance;
    }
}
