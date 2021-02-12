package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.utils.RandomUtils;
import racingcar.view.OutputView;

public class Cars {

    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        validateCarNamesDuplicate(cars);
        this.cars = cars;
    }

    public List<Car> getWinners() {
        List<Car> winners = new ArrayList<>();

        cars.stream()
            .filter(it -> it.isWinner(getMaxDistance()))
            .forEach(winners::add);
        return Collections.unmodifiableList(winners);
    }

    public void move() {
        for (Car car : cars) {
            car.move(RandomUtils.getRandomNumber());
            OutputView.printCarInformation(car);
        }
    }

    private int getMaxDistance() {
        int maxDistance = 0;
        for (Car car : cars) {
            maxDistance = Math.max(maxDistance, car.getDistance());
        }
        return maxDistance;
    }

    private void validateCarNamesDuplicate(List<Car> cars) {
        Set<Car> set = new HashSet<>(cars);
        if (cars.size() > set.size()) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 중복이 불가능합니다.");
        }
    }

}


