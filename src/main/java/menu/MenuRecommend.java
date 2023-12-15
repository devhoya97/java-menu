package menu;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MenuRecommend {

    private static final List<String> categoryHistories = new ArrayList<>();

    public static void recommendMenu(List<Coach> coaches) {
        String category = selectCategory();
        for (Coach coach : coaches) {
            addMenu(category, coach);
        }
    }

    private static String selectCategory() {
        while (true) {
            String category = MenuBoard.categories().get(Randoms.pickNumberInRange(1, 5) - 1);
            if (Collections.frequency(categoryHistories, category) >= 2) {
                continue;
            }
            categoryHistories.add(category);
            return category;
        }
    }

    private static void addMenu(String category, Coach coach) {
        while (true) {
            String menu = Randoms.shuffle(MenuBoard.findByCategory(category).getCategoryMenus()).get(0);
            if (coach.addMenu(menu)) {
                return;
            }
        }
    }

    public static List<String> getCategoryHistories() {
        return Collections.unmodifiableList(categoryHistories);
    }
}
