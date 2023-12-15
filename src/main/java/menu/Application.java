package menu;

import java.util.List;
import menu.view.InputView;
import menu.view.OutputView;

public class Application {
    public static void main(String[] args) {
        OutputView.printStart();
        List<Coach> coaches = InputView.readCoaches();
        InputView.addCoachesBannedMenus(coaches, MenuRecommend.getMenus());
        for (int weekDayCount = 0; weekDayCount < 5; weekDayCount++) {
            MenuRecommend.recommendMenu(coaches);
        }
        OutputView.printResult(MenuRecommend.getCategoryHistories(), coaches);
        OutputView.printEnd();
    }
}
