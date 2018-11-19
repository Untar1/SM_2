package his.implementation;

import com.google.common.base.Function;
import com.google.common.base.Strings;
import his.sequence.diagrams.Boundary;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
                    } else {
                        System.out.println("Input did not pass validation, try again.");
                    }
                } else {
                    return line;
                }
            }
        }
    }

    default LocalDateTime getDate(Scanner sc, String message, DateTimeFormatter format) {
        return LocalDateTime.parse(getNotBlankLine(sc, message, line -> {
            try {
                return line != null && LocalDateTime.parse(line, format) != null;
            } catch (Exception e) {
                return false;
            }
        }), format);
    }

    default String getNotBlankLine(Scanner sc, String message) {
        return getNotBlankLine(sc, message, null);
    }

    default Scanner systemIn() {
        return new Scanner(System.in);
    }

    default DateTimeFormatter getFormat() {
        return DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
    }

    void setBoundary(Boundary boundary);
}
