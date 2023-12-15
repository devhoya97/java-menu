package menu;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private final List<String> menus = new ArrayList<>();

    public boolean addMenu(String menu) {
        if (menus.contains(menu)) {
            return false;
        }
        return menus.add(menu);
    }
}
