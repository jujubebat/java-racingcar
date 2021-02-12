package racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.TryNumber;

public class InputView {

    private static final String CAR_NAME_DELIMITER = ",";

    private InputView() {
    }

    public static Cars getCars(final Scanner scanner) {
        OutputView.printCarNameReadMessage();
        try {
            String inputValue = scanner.nextLine();
            List<String> names = Arrays.asList(inputValue.split(CAR_NAME_DELIMITER));
            List<Car> cars = names.stream().map(Car::new).collect(Collectors.toList());
            return new Cars(cars);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getCars(scanner);
        }
    }

    public static TryNumber getTryNumber(final Scanner scanner) {
        OutputView.printAttemptNumberReadMessage();
        try {
            String inputValue = scanner.nextLine();
            return new TryNumber(Integer.parseInt(inputValue));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getTryNumber(scanner);
        }
    }

}
