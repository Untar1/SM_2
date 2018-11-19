package his.implementation;

import com.google.common.base.Function;
import com.google.common.base.Strings;

import java.util.Scanner;

public interface Action {

    void setContext();

    void execute();

    String description();

    default String getNotBlankLine(Scanner sc, String message, Function<String, Boolean> validator) {
        while (true) {
            System.out.println(message);
            String line = sc.next();
            if (!Strings.isNullOrEmpty(line)) {
                if (validator != null) {
                    Boolean apply = validator.apply(line);
                    if (apply != null && apply) {
                        return line;
                    }
                } else {
                    return line;
                }
            }
        }
    }

    default String getNotBlankLine(Scanner sc, String message) {
        return getNotBlankLine(sc, message, null);
    }

    default Scanner systemIn() {
        return new Scanner(System.in);
    }
}
