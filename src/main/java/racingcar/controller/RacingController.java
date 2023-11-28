package racingcar.controller;

import racingcar.dto.CarDto;
import racingcar.model.vo.Cars;
import racingcar.model.vo.TrialNumber;
import racingcar.util.InputConverter;
import racingcar.util.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Cars cars = initCars();
        TrialNumber trialNumber = initTrialNumber();
        startRacing(trialNumber, cars);
        showWinners(cars);
    }

    private void showWinners(Cars cars) {
        // TODO : 우승자 출력
    }

    private void startRacing(TrialNumber trialNumber, Cars cars) {
        outputView.printResultMessage();
        for (int count = 0; count < trialNumber.getNumber(); count++) {
            cars.playEachSession();
            outputView.printEachResult(CarDto.createCarsDto(cars));
        }
    }

    private Cars initCars() {
        String carNames = inputView.inputCarNames();
        InputValidator.validateCarNames(carNames);
        return Cars.create(InputConverter.stringToListByDelimiter(carNames));
    }

    private TrialNumber initTrialNumber() {
        String trialNumber = inputView.inputTrialNumber();
        InputValidator.validateTrialNumber(trialNumber);
        return new TrialNumber(InputConverter.stringToInteger(trialNumber));
    }
}
