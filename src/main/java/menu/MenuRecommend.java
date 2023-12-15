package menu;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuRecommend {
    private static final Map<String, List<String>> menus = new HashMap<>();
    private static final List<String> categories = Arrays.asList("", "일식", "한식", "중식", "아시안", "양식");
    static {
        menus.put(categories.get(1), Arrays.asList("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼"));
        menus.put(categories.get(2), Arrays.asList("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음"));
        menus.put(categories.get(3), Arrays.asList("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채"));
        menus.put(categories.get(4), Arrays.asList("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜"));
        menus.put(categories.get(5), Arrays.asList("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"));
    }

    private static final List<String> categoryHistories = new ArrayList<>();

    public static void recommendMenu(List<Coach> coaches) {
        String category = selectCategory();
        String menu = Randoms.shuffle(menus.get(category)).get(0);
    }

    private static String selectCategory() {
        while (true) {
            String category = categories.get(Randoms.pickNumberInRange(1, 5));
            if (Collections.frequency(categoryHistories, category) >= 2) {
                continue;
            }
            categoryHistories.add(category);
            return category;
        }
    }
}
