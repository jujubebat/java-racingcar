package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {

    @Test
    @DisplayName("우승자 선정이 잘 되는지 테스트")
    public void check_get_winners() {
        List<Name> names = Arrays.asList(
            new Name("test1"),
            new Name("test2"),
            new Name("test3")
        );

        List<Position> positions = Arrays.asList(
            new Position(8),
            new Position(1),
            new Position(3)
        );
        Cars cars = new Cars(names, positions);
        assertThat(cars.getWinners().get(0).getName()).isEqualTo("test1");
    }

}