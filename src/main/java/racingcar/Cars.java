package racingcar;

import java.util.List;

public class Cars {
    private final List<Car> list;

    public Cars(List<Car> carList) {
        this.list = carList;
    }

    public List<Car> getList() {
        return list;
    }

    public void driveAll(List<Integer> randomNumbers) {
        for (int i = 0; i < list.size(); i++) {
            list.get(i).drive(randomNumbers.get(i));
        }
    }
}
