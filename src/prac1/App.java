package prac1;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        task6();
    }
    public static void task3() {
        int[] numbers = {1, 2, 3, 4, 5};
        int summa = 0, m = 0;
        for (int x : numbers) summa += x;
        m = summa / numbers.length;
        System.out.println(m);
    }
    public static void task4() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите количество элементов массива: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Введите " + n + " элементов:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();

        int summa = 0, min_elem = arr[0], max_elem = arr[0], i = 0;
        while (i < arr.length) {
            summa += arr[i];
            if (arr[i] > max_elem) max_elem = arr[i];
            if (arr[i] < min_elem) min_elem = arr[i];
            ++i;
        }
        System.out.println("Сумма посчитанная с помощью while: " + summa);
        summa = i = 0;
        do {
            summa += arr[i];
            ++i;
        } while (i < arr.length);
        System.out.println(
            "Сумма посчитанная с помощью do while: " + summa + '\n' + 
            "Максимальный элемент: " + max_elem + "\nМинимальный элемент: " + min_elem
        );
    }
    public static void task5(String[] args) {
        System.out.println("Аргументы командной строки: ");
        for (String arg : args) System.out.println(arg);
    }
    public static void task6() {
        double sum = 0.0;

        System.out.println("Первые 10 чисел гармонического ряда:");
        for (int i = 1; i <= 10; i++) {
            sum += 1.0 / i;
            System.out.printf("H%-2d = %.4f%n", i, sum);
        }
    }
    public static void task7(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        System.out.println(result);
    }
}
