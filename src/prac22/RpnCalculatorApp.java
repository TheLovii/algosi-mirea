package prac22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RpnCalculatorApp {
    public static void main(String[] args) throws IOException {
        RpnCalculator calculator = new RpnCalculator();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("RPN-калькулятор. Введите выражение в ОПН (пустая строка = выход).");
        System.out.println("Пример: 2 3 4 * +");

        while (true) {
            System.out.print("> ");
            String line = reader.readLine();
            if (line == null || line.trim().isEmpty()) {
                System.out.println("Выход.");
                break;
            }

            try {
                double result = calculator.evaluate(line);
                System.out.println("Результат: " + result);
            } catch (Exception e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }
    }
}

