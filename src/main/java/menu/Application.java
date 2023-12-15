package menu;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Coach coach1 = new Coach("AA");
        Coach coach2 = new Coach("BB");
        for (int i = 0; i < 5; i++) {
            MenuRecommend.recommendMenu(List.of(coach1, coach2));
        }

        System.out.println(coach1.getEatenMenus());
        System.out.println(coach2.getEatenMenus());
    }
}
