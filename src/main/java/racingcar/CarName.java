package racingcar;

public class CarName {
    private final String value;

    public CarName(String name) {
        validateNameLength(name);
        this.value = name;
    }

    public String getValue() {
        return value;
    }

    private void validateNameLength(String name) {
        if (name.length() > Constants.NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자 이하만 가능합니다.");
        }
    }
}
