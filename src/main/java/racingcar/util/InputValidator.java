package racingcar.util;

public class InputValidator {

    private InputValidator() {
    }

    public static void validateCarNames(String carNames) {
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateTrialNumber(String trialNumber) {
        if (trialNumber.isEmpty()) {
            throw new IllegalArgumentException();
        }
        if (!isNumeric(trialNumber)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isNumeric(String trialNumber) {
        try {
            Integer.valueOf(trialNumber);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
