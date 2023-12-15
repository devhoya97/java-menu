package menu;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Coach {
    private final String name;
    private final List<String> menus = new ArrayList<>();

    public Coach(String name) {
        String trimmedName = name.trim();
        validateName(trimmedName);
        this.name = trimmedName;
    }

    private void validateName(String trimmedName) {
        if (trimmedName.length() < 2 || trimmedName.length() > 4) {
            throw new IllegalArgumentException("코치 이름은 2~4글자만 가능합니다.");
        }
    }

    public boolean addMenu(String menu) {
        if (menus.contains(menu)) {
            return false;
        }
        return menus.add(menu);
    }

    public List<String> getMenus() {
        return Collections.unmodifiableList(menus);
    }

    public String getName() {
        return name;
    }
}
