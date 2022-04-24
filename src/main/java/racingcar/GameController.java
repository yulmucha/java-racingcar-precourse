package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    private final UserInterface userInterface;

    public GameController(UserInterface userInterface) {
        this.userInterface = userInterface;
    }

    public void run() {
        Cars cars = new Cars(createCarList(getCarNames()));

        int driveNumber = readDriveNumber();
        for (int i = 0; i < driveNumber; i++) {
            cars.driveAll(createRandomNumbers(cars.getList().size()));
            for (Car car : cars.getList()) {
                userInterface.printCar(car.getName().getValue(), car.getDistance());
            }
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
        userInterface.printCarNamesPrompt();
        return Console.readLine().split(",");
    }

    private int readDriveNumber() {
        userInterface.printDriveNumberPrompt();
        return Integer.valueOf(Console.readLine());
    }

    public List<Car> createCarList(CarNames carNames) {
        ArrayList<Car> cars = new ArrayList<>();
        for (CarName carName : carNames.getList()) {
            cars.add(new Car(carName));
        }

        return cars;
    }

    public List<Integer> createRandomNumbers(int carListSize) {
        List<Integer> randomNumbers = new ArrayList<>();
        for (int j = 0; j < carListSize; j++) {
            randomNumbers.add(Randoms.pickNumberInRange(0, 9));
        }

        return randomNumbers;
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

        userInterface.printWinners(winners);
    }
}
