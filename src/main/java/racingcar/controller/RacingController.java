package racingcar.controller;

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
