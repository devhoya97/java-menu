package menu.view;

import java.util.List;
import java.util.StringJoiner;
import menu.Coach;

public class OutputView {
    private static final String DELIMITER = " | ";
    private static final String BASKET_START = "[ ";
    private static final String BASKET_END = " ]";
    public static void printStart() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }

    public static void printResult(List<String> categories, List<Coach> coaches) {
        System.out.println("\n메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        printCategories(categories);
        for (Coach coach : coaches) {
            printCoachMenus(coach);
        }
    }

    private static void printCategories(List<String> categories) {
        StringJoiner sj = new StringJoiner(DELIMITER, BASKET_START, BASKET_END);
        sj.add("카테고리");
        for (String category : categories) {
            sj.add(category);
        }
        System.out.println(sj);
    }

    private static void printCoachMenus(Coach coach) {
        StringJoiner sj = new StringJoiner(DELIMITER, BASKET_START, BASKET_END);
        sj.add(coach.getName());
        for (String eatenMenu : coach.getEatenMenus()) {
            sj.add(eatenMenu);
        }
        System.out.println(sj);
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println("[ERROR] " + errorMessage);
    }

    public static void printEnd() {
        System.out.println("추천을 완료했습니다.");
    }
}
