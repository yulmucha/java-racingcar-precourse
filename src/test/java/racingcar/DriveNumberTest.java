package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class DriveNumberTest {

    @Test
    void 생성() {
        DriveNumber driveNumber = new DriveNumber(5);
        assertThat(driveNumber.getValue()).isEqualTo(5);
    }

    @Test
    void 생성_예외() {
        assertThatThrownBy(() -> {
            DriveNumber driveNumber = new DriveNumber(-1);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 시도 횟수는 음수일 수 없습니다.");
    }
}
