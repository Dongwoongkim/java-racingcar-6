package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.dto.CarDto;

public class OutputView {

    public void printResultMessage() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void printEachResult(List<CarDto> carsDto) {
        carsDto.forEach(carDto ->
                System.out.println(carDto.getName() + " : " + "-".repeat(carDto.getDistance())));
        System.out.println();
    }

    public void printWinners(List<String> winnerNames) {
        String winners = winnerNames.stream()
                .collect(Collectors.joining(", "));
        System.out.print("최종 우승자 : " + winners);
    }
}
