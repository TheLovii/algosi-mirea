package prac25;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTasks {
    private static final Pattern TARGET_STRING_PATTERN =
            Pattern.compile("^abcdefghijklmnopqrstuv18340$");

    private static final Pattern PRICE_PATTERN =
            Pattern.compile("\\b\\d+(?:\\.\\d{2})?\\s+(?:USD|RUB|EU)\\b");

    private static final Pattern DIGIT_NOT_FOLLOWED_BY_PLUS_PATTERN =
            Pattern.compile("\\d(?!\\+)");


    private static final Pattern DATE_PATTERN = Pattern.compile(
            "^(?:" +
                    // 29 февраля в високосный год
                    "29/02/(?:(?:19|[2-9]\\d)(?:0[48]|[2468][048]|[13579][26]))" +
                    "|" +
                    // 01–28 февраля — любой год 1900–9999
                    "(?:0[1-9]|1\\d|2[0-8])/02/(?:19\\d{2}|[2-9]\\d{3})" +
                    "|" +
                    // 31-е число только для 31-дневных месяцев
                    "31/(?:01|03|05|07|08|10|12)/(?:19\\d{2}|[2-9]\\d{3})" +
                    "|" +
                    // 1–30 число для месяцев 31-дневных
                    "(?:0[1-9]|[12]\\d|30)/(?:01|03|05|07|08|10|12)/(?:19\\d{2}|[2-9]\\d{3})" +
                    "|" +
                    // 1–30 число для месяцев с 30 днями
                    "(?:0[1-9]|[12]\\d|30)/(?:04|06|09|11)/(?:19\\d{2}|[2-9]\\d{3})" +
                    ")$"
    );

    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@" +
                    "(?:(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,}|localhost)$"
    );

    private static final Pattern STRONG_PASSWORD_PATTERN = Pattern.compile(
            "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)[A-Za-z0-9_]{8,}$"
    );

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("=== Демонстрация задач по регулярным выражениям ===");
        System.out.println();

        // 1. Консольное приложение для манипуляции строкой: разбиваем строку по regex
        System.out.println("1) Разбиение строки по регулярному выражению.");
        System.out.print("Введите строку: ");
        String input = in.nextLine();
        System.out.print("Введите регулярное выражение для split (например, \\s+): ");
        String splitRegex = in.nextLine();
        String[] parts = splitString(input, splitRegex);
        System.out.println("Результат разбиения:");
        for (int i = 0; i < parts.length; i++) {
            System.out.printf("  [%d]: \"%s\"%n", i, parts[i]);
        }
        System.out.println();

        // 2. Проверка строки "abcdefghijklmnopqrstuv18340"
        System.out.println("2) Проверка строки \"abcdefghijklmnopqrstuv18340\":");
        System.out.println("   abcdefghijklmnopqrstuv18340 -> " +
                isTargetString("abcdefghijklmnopqrstuv18340"));
        System.out.println("   abcdefghijklmnoasdfasdpqrstuv18340 -> " +
                isTargetString("abcdefghijklmnopqrstuv18340abc"));
        System.out.println();

        // 3. Извлечение цен
        System.out.println("3) Извлечение цен (USD, RUB, EU) из текста:");
        String priceText = "Тут цены: 25.98 USD, 100 RUB, 44 ERR, 0.004 EU, 5 EU.";
        System.out.println("   Текст: " + priceText);
        List<String> prices = extractPrices(priceText);
        System.out.println("   Найдены корректные цены:");
        for (String p : prices) {
            System.out.println("     " + p);
        }
        System.out.println();

        // 4. Есть ли цифра, за которой не стоит '+'
        System.out.println("4) Есть ли цифры, за которыми не стоит знак '+':");
        String expr1 = "(1 + 8) - 9 / 4.";
        String expr2 = "6 / 5 - 2 * 9 .";
        System.out.println("   \"" + expr1 + "\" -> " + hasDigitNotFollowedByPlus(expr1));
        System.out.println("   \"" + expr2 + "\" -> " + hasDigitNotFollowedByPlus(expr2));
        System.out.println();

        // 5. Дата dd/mm/yyyy
        System.out.println("5) Проверка дат:");
        String[] dates = {
                "29/02/2000",  // ok
                "30/04/2003",  // ok
                "01/01/2003",  // ok
                "29/02/2001",  // bad
                "30-04-2003",  // bad
                "1/1/1899"     // bad
        };
        for (String d : dates) {
            System.out.println("   " + d + " -> " + isValidDate(d));
        }
        System.out.println();

        // 6. E-mail
        System.out.println("6) Проверка e-mail адресов:");
        String[] emails = {
                "user@example.com",
                "root@localhost",
                "myhost@@@com.ru",
                "@my.ru",
                "Julia String"
        };
        for (String e : emails) {
            System.out.println("   \"" + e + "\" -> " + isValidEmail(e));
        }
        System.out.println();

        // 7. Пароль
        System.out.println("7) Проверка надёжности пароля:");
        String[] passwords = {
                "F032_Password", // ok
                "TrySpy1",       // короткий
                "TrySpy1_",      // ok
                "smart_pass",    // нет цифры и заглавной
                "A007"           // короткий
        };
        for (String p : passwords) {
            System.out.println("   \"" + p + "\" -> " + isStrongPassword(p));
        }
    }

    // === 1. Разбиение строки по regex ===
    public static String[] splitString(String input, String regex) {
        if (regex == null || regex.isEmpty()) {
            // если пользователь не ввёл шаблон — разбиваем по пробелам
            regex = "\\s+";
        }
        return input.split(regex);
    }

    // === 2. Проверка строки "abcdefghijklmnopqrstuv18340" ===
    public static boolean isTargetString(String s) {
        return TARGET_STRING_PATTERN.matcher(s).matches();
    }

    // === 3. Извлечение цен ===
    public static List<String> extractPrices(String text) {
        List<String> result = new ArrayList<>();
        Matcher m = PRICE_PATTERN.matcher(text);
        while (m.find()) {
            result.add(m.group());
        }
        return result;
    }

    // === 4. Есть ли цифры, за которыми НЕ стоит '+' ===
    public static boolean hasDigitNotFollowedByPlus(String text) {
        return DIGIT_NOT_FOLLOWED_BY_PLUS_PATTERN.matcher(text).find();
    }

    // === 5. Дата dd/mm/yyyy ===
    public static boolean isValidDate(String s) {
        return DATE_PATTERN.matcher(s).matches();
    }

    // === 6. E-mail ===
    public static boolean isValidEmail(String s) {
        return EMAIL_PATTERN.matcher(s).matches();
    }

    // === 7. Надёжный пароль ===
    public static boolean isStrongPassword(String s) {
        return STRONG_PASSWORD_PATTERN.matcher(s).matches();
    }
}
