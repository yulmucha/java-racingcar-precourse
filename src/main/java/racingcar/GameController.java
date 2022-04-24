package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    public void run() {
        List<CarName> names = getNames();

        ArrayList<Car> cars = new ArrayList<>();

        for (CarName name : names) {
            cars.add(new Car(name));
        }

        int driveNumber = readDriveNumber();

        for (int i = 0; i < driveNumber; i++) {
            for (Car car : cars) {
                car.drive();
            }
        }

        printWinners(cars);
    }

    private List<CarName> getNames() {
        List<CarName> names = new ArrayList<>();
        while (true) {
            try {
                for (String name : readNames()) {
                    names.add(new CarName(name));
                }
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

    private void validateLength(String[] names) {
        for (String name : names) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("[ERROR] 이름은 5자 이하만 가능합니다.");
            }
        }
    }

    public void printWinners(List<Car> cars) {
        int max = 0;
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
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
