package racingcar;

import java.util.ArrayList;
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

    public List<String> getWinners() {
        int maxDistance = 0;
        List<String> winners = new ArrayList<>();
        for (Car car : list) {
            maxDistance = addWinner(car, maxDistance, winners);
        }

        return winners;
    }

    private int addWinner(Car car, int maxDistance, List<String> winners) {
        if (maxDistance < car.getDistance()) {
            maxDistance = car.getDistance();
            winners.clear();
            winners.add(car.getName());
            return maxDistance;
        }

        if (maxDistance == car.getDistance()) {
            winners.add(car.getName());
        }

        return maxDistance;
    }
}
