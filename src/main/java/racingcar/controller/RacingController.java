package racingcar.controller;

import java.util.List;
import racingcar.dto.CarDto;
import racingcar.model.Cars;
import racingcar.model.vo.TrialNumber;
import racingcar.util.InputConverter;
import racingcar.util.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Cars cars = initCars();
        TrialNumber trialNumber = initTrialNumber();
        startRacing(trialNumber, cars);
        showWinners(cars);
    }

    private void showWinners(final Cars cars) {
        List<String> winners = cars.getWinnerNames();
        outputView.printWinners(winners);
    }

    private void startRacing(final TrialNumber trialNumber, final Cars cars) {
        outputView.printResultMessage();
        for (int count = 0; count < trialNumber.getNumber(); count++) {
            cars.playEachSession();
            outputView.printEachResult(CarDto.createCarsDto(cars));
        }
    }

    private Cars initCars() {
        String carNames = inputView.inputCarNames();
        InputValidator.validateCarNames(carNames);
        return Cars.createWithNames(InputConverter.stringToListByDelimiter(carNames));
    }

    private TrialNumber initTrialNumber() {
        String trialNumber = inputView.inputTrialNumber();
        InputValidator.validateTrialNumber(trialNumber);
        return new TrialNumber(InputConverter.stringToInteger(trialNumber));
    }
}
