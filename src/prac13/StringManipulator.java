package prac13;

import java.util.Scanner;
import java.util.regex.*;

public class StringManipulator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Ввод строки
        System.out.println("Введите строку:");
        String inputString = scanner.nextLine();

        // 2. Пример 1: Разбиение строки по пробелам
        String[] words = inputString.split("\\s+");
        System.out.println("Разделенные слова:");
        for (String word : words) {
            System.out.println(word);
        }

        // 3. Пример 2: Проверка на строку "abcdefghijklmnopqrstuv18340"
        if (isValidString(inputString)) {
            System.out.println("Строка соответствует шаблону: abcdefghijklmnopqrstuv18340");
        } else {
            System.out.println("Строка не соответствует шаблону.");
        }

        // 4. Пример 3: Извлечение цен из текста
        System.out.println("Введите текст с ценами:");
        String priceText = scanner.nextLine();
        extractPrices(priceText);
        scanner.close();
    }

    // Метод для проверки, соответствует ли строка шаблону "abcdefghijklmnopqrstuv18340"
    public static boolean isValidString(String input) {
        String regex = "^abcdefghijklmnopqrstuv18340$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    // Метод для извлечения цен в USD, RUB, EU
    public static void extractPrices(String input) {
        String regex = "\\b([0-9]+(?:\\.[0-9]{1,2})?)\\s*(USD|RUB|EU)\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        System.out.println("Извлеченные цены:");
        while (matcher.find()) {
            String price = matcher.group(1);
            String currency = matcher.group(2);
            System.out.println("Цена: " + price + " " + currency);
        }
    }
}
