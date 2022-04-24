package racingcar;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    void 전진_정지() {
        List<Car> carList = Arrays.asList(
                new Car(new CarName("yul")),
                new Car(new CarName("dd")),
                new Car(new CarName("iu")));
        Cars cars = new Cars(carList);

        cars.driveAll(Arrays.asList(2,4,3));

        assertThat(cars.getList().get(0).getDistance()).isEqualTo(0);
        assertThat(cars.getList().get(1).getDistance()).isEqualTo(1);
        assertThat(cars.getList().get(2).getDistance()).isEqualTo(0);
    }

    @Test
    void 최종_우승자() {
        List<Car> carList = Arrays.asList(
                new Car(new CarName("yul")),
                new Car(new CarName("dd")),
                new Car(new CarName("iu")));
        Cars cars = new Cars(carList);

        cars.driveAll(Arrays.asList(2,4,3));

        assertThat(cars.getWinners()).containsExactly("dd");
    }
}
