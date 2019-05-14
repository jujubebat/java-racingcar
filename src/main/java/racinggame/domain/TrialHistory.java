package racinggame.domain;

import java.util.*;

public class TrialHistory {
    private HashMap<String, Integer> trialHistory = new LinkedHashMap<>();

    public TrialHistory(List<Car> cars) {
        for (Car car : cars) {
            trialHistory.putAll(car.makeCarHistory());
        }
    }

    public List<String> findWinners() {
        List<String> winners = new ArrayList<>();
        int maxCarPosition = getMaxCarPosition();

        for (String carName : trialHistory.keySet()) {
            if (trialHistory.get(carName) == maxCarPosition) {
                winners.add(carName);
            }
        }
        return winners;
    }

    private int getMaxCarPosition() {
        int maxCarPosition = 0;

        for (String carName : trialHistory.keySet()) {
            maxCarPosition = Math.max(trialHistory.get(carName), maxCarPosition);
        }
        return maxCarPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrialHistory that = (TrialHistory) o;
        return Objects.equals(trialHistory, that.trialHistory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trialHistory);
    }

    @Override
    public String toString() {
        StringBuilder history = new StringBuilder();

        for (String carName : trialHistory.keySet()) {
            history.append(carName).append(" : ");
            for (int i = 0; i < trialHistory.get(carName); i++) {
                history.append('-');
            }
            history.append('\n');
        }
        return history.toString();
    }
}