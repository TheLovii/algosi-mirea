package prac11;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Task2 {
    private static final ZoneId ZONE = ZoneId.systemDefault();

    /**
     * Сравнивает текущие дату/время с введёнными пользователем.
     * Поддерживаемые форматы:
     *  - "yyyy-MM-dd HH:mm"
     *  - "yyyy-MM-dd"
     *  - "dd.MM.yyyy HH:mm"
     *  - "dd.MM.yyyy"
     */
    public static void compareWithNow(String userInput) {
        System.out.println("=== Задание 2 ===");
        if (userInput == null || userInput.isEmpty()) {
            System.out.println("Пустой ввод — нечего сравнивать.\n");
            return;
        }

        ZonedDateTime now = ZonedDateTime.now(ZONE);
        ZonedDateTime userDateTime = parseUserDateTime(userInput);

        if (userDateTime == null) {
            System.out.println("Не удалось распознать дату/время. Попробуйте форматы:");
            System.out.println("yyyy-MM-dd HH:mm | yyyy-MM-dd | dd.MM.yyyy HH:mm | dd.MM.yyyy\n");
            return;
        }

        System.out.println("Текущее системное дата/время: " + now);
        System.out.println("Введённые дата/время:        " + userDateTime);

        int cmp = userDateTime.compareTo(now);
        if (cmp < 0) {
            System.out.println("Результат: введённый момент РАНЬШЕ текущего.\n");
        } else if (cmp > 0) {
            System.out.println("Результат: введённый момент ПОЗЖЕ текущего.\n");
        } else {
            System.out.println("Результат: моменты совпадают.\n");
        }
    }

    private static ZonedDateTime parseUserDateTime(String s) {
        String[] patterns = {
            "yyyy-MM-dd HH:mm",
            "yyyy-MM-dd",
            "dd.MM.yyyy HH:mm",
            "dd.MM.yyyy"
        };

        for (String p : patterns) {
            try {
                DateTimeFormatter f = DateTimeFormatter.ofPattern(p);
                if (p.contains("HH")) {
                    LocalDateTime ldt = LocalDateTime.parse(s, f);
                    return ldt.atZone(ZONE);
                } else {
                    LocalDate ld = LocalDate.parse(s, f);
                    return ZonedDateTime.of(ld, LocalTime.MIDNIGHT, ZONE);
                }
            } catch (DateTimeParseException ignored) { }
        }
        return null;
    }
}

