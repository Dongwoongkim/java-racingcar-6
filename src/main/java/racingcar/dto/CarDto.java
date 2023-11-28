package racingcar.dto;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Cars;
import racingcar.model.Distance;
import racingcar.model.vo.Name;

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

    public static CarDto create(Name name, Distance distance) {
        return new CarDto(name.get(), distance.get());
    }

    public String getName() {
        return name;
    }

    public Integer getDistance() {
        return distance;
    }
}
