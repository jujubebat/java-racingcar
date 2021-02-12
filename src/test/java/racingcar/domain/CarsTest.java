package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {

    @BeforeEach
    public void setUp() {
    }

    @Test
    @DisplayName("우승자 선정이 잘 되는지 테스트")
    public void check_get_winners() {
        Cars cars = new Cars(
            Arrays.asList(
                new Car("test1", 7),
                new Car("test2", 11),
                new Car("test3", 4)
            )
        );

        assertThat(cars.getWinners().get(0).getName()).isEqualTo("test2");
    }

    @Test
    @DisplayName("자동차 이름 중복 예외 발생 테스트")
    public void check_name_duplicate_exception() {
        List<Car> cars = Arrays.asList(
            new Car("test1"),
            new Car("test1"),
            new Car("test3")
        );

        assertThatThrownBy(() -> new Cars(cars))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] 자동차 이름은 중복이 불가능합니다.");
    }

}