package racingcar;

public class Car {

    private CarName name;
    private int distance = 0;

    public int getDistance() {
        return distance;
    }

    public Car(CarName name) {
        this.name = name;
    }

    public String getName() {
        return name.getValue();
    }

    public void drive(int value) {
        if (value >= Constants.THRESHOLD) {
            distance++;
        }
    }
}
