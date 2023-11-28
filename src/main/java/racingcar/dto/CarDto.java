package racingcar.dto;

import java.util.List;
import racingcar.model.Cars;

public class CarDto {

    private String name;
    private Integer distance;

    private CarDto(final String name, final Integer distance) {
        this.name = name;
        this.distance = distance;
    }

    public static List<CarDto> createCarsDto(final Cars cars) {
        return cars.getCars()
                .stream()
                .map(car -> CarDto.create(car.getName(), car.getDistance()))
                .toList();
    }

    public static CarDto create(final String name, final Integer distance) {
        return new CarDto(name, distance);
    }

    public String getName() {
        return name;
    }

    public Integer getDistance() {
        return distance;
    }
}
