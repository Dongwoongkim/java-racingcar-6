package racingcar.model.vo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Cars {

    private final List<Name> carNames;

    private Cars(List<Name> carNames) {
        this.carNames = carNames;
    }

    public static Cars create(List<String> names) {
        validate(names);
        List<Name> carNames = names.stream()
                .map(name -> Name.create(name))
                .collect(Collectors.toList());
        return new Cars(carNames);
    }

    private static void validate(List<String> names) {
        if (duplicateNameContains(names)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean duplicateNameContains(List<String> names) {
        Set<String> distinctNames = new HashSet<>(names);
        return names.size() != distinctNames.size();
    }
}
