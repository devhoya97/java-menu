package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import menu.Coach;

public class InputView {
    private static final String DELIMITER = ",";
    public static List<Coach> readCoaches() {
        System.out.println("\n코치의 이름을 입력해 주세요. (, 로 구분)");
        while (true) {
            try {
                List<String> coachNames = getTrimmedSplitInput();
                return coachNames.stream()
                        .map(Coach::new)
                        .collect(Collectors.toList());
            } catch (IllegalArgumentException illegalArgumentException) {
                OutputView.printErrorMessage(illegalArgumentException.getMessage());
            }
        }
    }

    private static List<String> getTrimmedSplitInput() {
        List<String> splitInput = Arrays.asList(Console.readLine().split(DELIMITER));
        return splitInput.stream()
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private static void validateSize(List<String> coachNames) {
        if (coachNames.size() < 2 || coachNames.size() > 5) {
            throw new IllegalArgumentException("코치는 최소 2명, 최대 5명까지 입력받을 수 있습니다.");
        }
    }
}
