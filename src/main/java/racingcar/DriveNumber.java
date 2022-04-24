package racingcar;

public class DriveNumber {
    private final int value;

    public DriveNumber(int value) {
        validateRange(value);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    private void validateRange(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 음수일 수 없습니다.");
        }
    }
}
