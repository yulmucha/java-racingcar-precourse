package racingcar;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static racingcar.Constants.*;

public class GameController {

    private final UserInterface userInterface;

    public GameController(UserInterface userInterface) {
        this.userInterface = userInterface;
    }

    public void run() {
        Cars cars = new Cars(createCarList(getCarNames()));

        DriveNumber driveNumber = getDriveNumber();
        for (int i = 0; i < driveNumber.getValue(); i++) {
            cars.driveAll(createRandomNumbers(cars.getList().size()));
            printCars(cars);
        }

        userInterface.printWinners(cars.getWinners());
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
        return readLine().split(NAME_SEPARATOR);
    }

    private DriveNumber getDriveNumber() {
        DriveNumber driveNumber;
        while (true) {
            try {
                driveNumber = new DriveNumber(readDriveNumber());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
            return driveNumber;
        }
    }

    private String readDriveNumber() {
        userInterface.printDriveNumberPrompt();
        return readLine();
    }

    public List<Car> createCarList(CarNames carNames) {
        ArrayList<Car> cars = new ArrayList<>();
        for (CarName carName : carNames.getList()) {
            cars.add(new Car(carName, new Distance(INITIAL_DISTANCE)));
        }

        return cars;
    }

    public List<Integer> createRandomNumbers(int carListSize) {
        List<Integer> randomNumbers = new ArrayList<>();
        for (int j = 0; j < carListSize; j++) {
            randomNumbers.add(pickNumberInRange(RANDOM_MIN, RANDOM_MAX));
        }

        return randomNumbers;
    }

    private void printCars(Cars cars) {
        for (Car car : cars.getList()) {
            userInterface.printCar(car.getName(), car.getDistance());
        }
    }
}
