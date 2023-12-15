package menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public enum MenuBoard {
    JAPANESE("일식", Arrays.asList(
            "규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼")),
    KOREAN("한식", Arrays.asList(
            "김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음")),
    CHINESE("중식", Arrays.asList(
            "깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채")),
    ASIAN("아시안", Arrays.asList(
            "팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜")),
    WESTERN("양식", Arrays.asList(
            "라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"));

    private final String category;
    private final List<String> categoryMenus;

    MenuBoard(String category, List<String> categoryMenus) {
        this.category = category;
        this.categoryMenus = categoryMenus;
    }

    public String getCategory() {
        return category;
    }

    public List<String> getCategoryMenus() {
        return Collections.unmodifiableList(categoryMenus);
    }

    public boolean contains(String menu) {
        return categoryMenus.contains(menu);
    }

    public static boolean doesHaveMenu(String menu) {
        for (MenuBoard categoryMenuBoard : MenuBoard.values()) {
            if (categoryMenuBoard.contains(menu)) {
                return true;
            }
        }
        return false;
    }

    public static List<String> categories() {
        List<String> categories = new ArrayList<>();
        for (MenuBoard categoryMenuBoard : MenuBoard.values()) {
            categories.add(categoryMenuBoard.category);
        }
        return Collections.unmodifiableList(categories);
    }

    public static MenuBoard findByCategory(String category) {
        for (MenuBoard categoryMenuBoard : MenuBoard.values()) {
            if (Objects.equals(categoryMenuBoard.category, category)) {
                return categoryMenuBoard;
            }
        }
        throw new IllegalArgumentException("유효하지 않은 카테고리입니다.");
    }
}
