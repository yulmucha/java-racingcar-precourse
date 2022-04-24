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

    public CarName getName() {
        return name;
    }

    public void drive(int value) {
        if (value >= 4) {
            distance++;
        }
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(name.getValue() + " : ");
        for (int i = 0; i < distance; i++) {
            builder.append("-");
        }
        return builder.toString();
    }
}
