package racingcar.domain;

import java.util.Objects;

public class Car {

    private static final int MOVE_POINT_NUMBER = 4;
    private static final int DEFAULT_POSITION = 0;
    private final Name name;
    private Position position;

    public Car(String name) {
        this(name, DEFAULT_POSITION);
    }

    public Car(String name, int position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    public void move(final int randomNumber) {
        if (checkMoveCondition(randomNumber)) {
            position = position.move();
        }
    }

    private boolean checkMoveCondition(final int randomNumber) {
        return (randomNumber >= MOVE_POINT_NUMBER);
    }

    public boolean isWinner(final int maxPosition) {
        return position.isSamePosition(maxPosition);
    }

    public String getName() {
        return this.name.getValue();
    }

    public int getDistance() {
        return position.getValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return Objects.equals(name, car.name) && Objects
            .equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
