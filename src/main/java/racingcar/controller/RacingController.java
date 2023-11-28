package racingcar.controller;

import racingcar.model.vo.CarNames;
import racingcar.model.vo.TrialNumber;
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
        CarNames carNames = initCarNames();
        TrialNumber trialNumber = initTrialNumber();
    }

    private TrialNumber initTrialNumber() {
        String trialNumber = inputView.inputTrialNumber();
        InputValidator.validateTrialNumber(trialNumber);
        return new TrialNumber();
    }

    private CarNames initCarNames() {
        String carNames = inputView.inputCarNames();
        InputValidator.validateCarNames(carNames);
        return new CarNames();
    }
}
