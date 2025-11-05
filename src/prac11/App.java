package prac11;

import java.time.LocalDate;
import java.time.format.FormatStyle;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // === Тест Задания 1 ===
        Task1 t1 = new Task1("Иванов", new Date(System.currentTimeMillis() - 36_000_00L)); // «получено» ~час назад
        t1.printReport();

        // === Тест Задания 2 ===
        // Можно передать строку датой через аргументы, иначе спросим в консоли.
        String inputDateTime;
        if (args.length > 0) {
            inputDateTime = String.join(" ", args);
        } else {
            System.out.println("Введите дату/время для сравнения (напр. 2025-11-05 10:30 или 05.11.2025):");
            Scanner sc = new Scanner(System.in);
            inputDateTime = sc.nextLine();
            sc.close();
        }
        Task2.compareWithNow(inputDateTime);

        // === Тест Задания 3 ===
        Student s = new Student(
                "Максим",
                "Казаку",
                "Информатика и вычислительная техника",
                2,
                "ПВБО-01-24",
                LocalDate.of(2006, 7, 14)
        );

        System.out.println("=== Задание 3 ===");
        System.out.println("toString():");
        System.out.println(s);

        System.out.println("\nФорматы даты рождения:");
        System.out.println("Короткий: " + s.getBirthDateFormatted(FormatStyle.SHORT, new Locale("ru", "RU")));
        System.out.println("Средний:  " + s.getBirthDateFormatted(FormatStyle.MEDIUM, new Locale("ru", "RU")));
        System.out.println("Полный*:  " + s.getBirthDateFormatted(FormatStyle.FULL, new Locale("ru", "RU")));
        System.out.println("Шаблон:   " + s.getBirthDateFormatted("dd.MM.yyyy"));
    }
}

