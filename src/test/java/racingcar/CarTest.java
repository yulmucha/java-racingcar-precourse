package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    void 전진_정지() {
        Car car = new Car(new CarName("yul"));
        assertThat(car.getDistance()).isEqualTo(0);

        car.drive(3);
        assertThat(car.getDistance()).isEqualTo(0);

        car.drive(0);
        assertThat(car.getDistance()).isEqualTo(0);

        car.drive(4);
        assertThat(car.getDistance()).isEqualTo(1);

        car.drive(9);
        assertThat(car.getDistance()).isEqualTo(2);
    }
}
