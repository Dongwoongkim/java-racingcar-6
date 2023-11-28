package racingcar.model;

public class Distance {

    private static final Integer THRESHOLD = 4;
    private Integer distance;

    public Distance(final Integer distance) {
        this.distance = distance;
    }

    public Integer get() {
        return distance;
    }

    public void addIfOverThreshold(final NumberGenerator numberGenerator) {
        if (numberGenerator.pickNumber() >= THRESHOLD) {
            this.distance++;
        }
    }
}
