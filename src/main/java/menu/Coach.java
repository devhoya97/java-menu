package menu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Coach {
    private final String name;
    private final List<String> eatenMenus = new ArrayList<>();
    private final List<String> bannedMenus = new ArrayList<>();

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

    public void addBannedMenu(String bannedMenu) {
        if (bannedMenu.isEmpty()) {
            return;
        }
        validateBannedMenu(bannedMenu);
        bannedMenus.add(bannedMenu);
    }

    private void validateBannedMenu(String bannedMenu) {
        if (!MenuBoard.doesHaveMenu(bannedMenu) || bannedMenus.contains(bannedMenu)) {
            throw new IllegalArgumentException("유효하지 않은 메뉴입니다.");
        }
    }

    public boolean addMenu(String menu) {
        if (eatenMenus.contains(menu) || bannedMenus.contains(menu)) {
            return false;
        }
        return eatenMenus.add(menu);
    }

    public List<String> getEatenMenus() {
        return Collections.unmodifiableList(eatenMenus);
    }

    public String getName() {
        return name;
    }
}
