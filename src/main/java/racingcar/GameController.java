package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    public void run() {
        ArrayList<Car> carList = new ArrayList<>();
        for (CarName carName : getCarNames().getList()) {
            carList.add(new Car(carName));
        }
        Cars cars = new Cars(carList);

        int driveNumber = readDriveNumber();
        for (int i = 0; i < driveNumber; i++) {
            List<Integer> randomNumbers = new ArrayList<>();
            for (int j = 0; j < cars.getList().size(); j++) {
                randomNumbers.add(Randoms.pickNumberInRange(0, 9));
            }
            cars.driveAll(randomNumbers);
        }

        printWinners(cars);
    }

    private CarNames getCarNames() {
        CarNames names;
        while (true) {
            try {
                names = new CarNames(readNames());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
            return names;
        }
    }

    private String[] readNames() {
        System.out.println("경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine().split(",");
    }

    private int readDriveNumber() {
        System.out.println("시도할 횟수");
        return Integer.valueOf(Console.readLine());
    }

    public void printWinners(Cars cars) {
        int max = 0;
        List<String> winners = new ArrayList<>();
        for (Car car : cars.getList()) {
            if (max < car.getDistance()) {
                max = car.getDistance();
                winners.clear();
                winners.add(car.getName().getValue());
                continue;
            }

            if (max == car.getDistance()) {
                winners.add(car.getName().getValue());
            }
        }

        System.out.print("최종 우승자: ");
        System.out.println(String.join(", ", winners));
    }
}
