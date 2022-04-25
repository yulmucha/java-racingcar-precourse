package racingcar;

import static racingcar.Constants.DRIVE_NUMBER_NEGATIVE_EXCEPTION_MESSAGE;

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
            throw new IllegalArgumentException(DRIVE_NUMBER_NEGATIVE_EXCEPTION_MESSAGE);
        }
    }
}
