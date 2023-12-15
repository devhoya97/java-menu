package menu;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Coach coach1 = new Coach("AA");
        Coach coach2 = new Coach("BB");
        for (int i = 0; i < 5; i++) {
            MenuRecommend.recommendMenu(List.of(coach1, coach2));
        }

        System.out.println(coach1.getMenus());
        System.out.println(coach2.getMenus());
    }
}
