package racingcar;

public class Distance {
    private int value;

    public Distance(int distance) {
        validateDistanceRange(distance);
        this.value = distance;
    }

    public int getValue() {
        return value;
    }

    public void validateDistanceRange(int distance) {
        if (distance < 0) {
            throw new IllegalArgumentException("[ERROR] 이동 거리는 음수가 될 수 없습니다.");
        }
    }

    public void increment() {
        value++;
    }
}
