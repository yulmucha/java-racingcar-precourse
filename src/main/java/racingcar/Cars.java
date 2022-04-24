package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> list;

    public Cars(CarNames names) {
        ArrayList<Car> cars = new ArrayList<>();
        for (CarName name : names.getList()) {
            cars.add(new Car(name));
        }
        this.list = cars;
    }

    public List<Car> getList() {
        return list;
    }

    public void driveAll() {
        for (Car car : list) {
            car.drive();
        }
    }
}
