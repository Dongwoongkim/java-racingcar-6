package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class InputConverter {

    private static final String DELIMITER = ",";

    private InputConverter() {
    }

    public static Integer stringToInteger(String input) {
        return Integer.valueOf(input);
    }

    public static List<String> stringToListByDelimiter(String carNames) {
        return Arrays.stream(carNames.split(DELIMITER))
                .map(String::trim)
                .toList();
    }
}
