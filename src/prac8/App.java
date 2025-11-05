package prac8;
import java.util.Scanner;

public class App {
    private static final Scanner SC = new Scanner(System.in);

    public static void main(String[] args) {
        // 11) Количество единиц до двух подряд идущих нулей
        // System.out.println(countOnesUntilDoubleZero());

        // 12) Вывести нечётные числа до нуля (функция сама печатает)
        // printOddNumbersUntilZero();

        // 13) Вывести элементы с нечётными номерами до нуля (функция сама печатает)
        // printElementsAtOddPositions();

        // 14) Цифры числа слева направо (без строк/массивов)
        // printDigitsLeftToRight();
    }

    /* ===================== 11. Количество единиц ===================== */
    public static int countOnesUntilDoubleZero() {
        int x = SC.nextInt();

        if (x == 0) {
            int y = SC.nextInt();     // смотрим следующее
            if (y == 0) return 0;     // два нуля подряд — конец
            // y не ноль — учитываем его и продолжаем рекурсию
            return (y == 1 ? 1 : 0) + countOnesUntilDoubleZero();
        } else {
            // обычный элемент
            return (x == 1 ? 1 : 0) + countOnesUntilDoubleZero();
        }
    }

    /* ===================== 12. Нечётные числа последовательности ===================== */
    public static void printOddNumbersUntilZero() {
        int x = SC.nextInt();
        if (x == 0) return;
        if ((x & 1) == 1) {
            System.out.println(x);
        }
        printOddNumbersUntilZero();
    }

    /* ===================== 13. Члены с нечётными номерами ===================== */
    public static void printElementsAtOddPositions() {
        int first = SC.nextInt();
        if (first == 0) return;
        System.out.println(first);

        int second = SC.nextInt();
        if (second == 0) return;

        printElementsAtOddPositions();
    }

    /* ===================== 14. Цифры числа слева направо ===================== */
    public static void printDigitsLeftToRight() {
        long n = SC.nextLong();
        printDigitsRec(n);
    }

    // Вспомогательная рекурсивная функция с параметром.
    private static void printDigitsRec(long n) {
        if (n < 10) {
            System.out.println(n);
        } else {
            printDigitsRec(n / 10);
            System.out.println(n % 10);
        }
    }
}
