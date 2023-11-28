package racingcar.util;

import racingcar.exception.EmptyCarNamesInputException;
import racingcar.exception.EmptyTrialNumberInputException;
import racingcar.exception.NonNumericTrialNumberInputException;

public class InputValidator {

    private InputValidator() {
    }

    public static void validateCarNames(final String carNames) {
        if (carNames.isEmpty()) {
            throw new EmptyCarNamesInputException();
        }
    }

    public static void validateTrialNumber(final String trialNumber) {
        if (trialNumber.isEmpty()) {
            throw new EmptyTrialNumberInputException();
        }
        if (!isNumeric(trialNumber)) {
            throw new NonNumericTrialNumberInputException();
        }
    }

    private static boolean isNumeric(final String trialNumber) {
        try {
            Integer.valueOf(trialNumber);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
