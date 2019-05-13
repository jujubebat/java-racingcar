package view;

import model.LapRecord;
import model.Winners;

public class OutputView {
    private static final String WINNER_MESSAGE = "%s가 최종 우승했습니다.";

    public static void printGameResult(LapRecord lapRecord){
        System.out.println("실행 결과");
        System.out.print(lapRecord.toString());
    }

    public static void printWinners(Winners winners) {
        System.out.println(String.format(WINNER_MESSAGE, winners.toString()));
    }
}