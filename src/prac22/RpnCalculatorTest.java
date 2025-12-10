package prac22;

// File: RpnCalculatorTest.java

public class RpnCalculatorTest {

    private static int tests = 0;
    private static int passed = 0;

    public static void main(String[] args) {
        RpnCalculator calc = new RpnCalculator();

        checkEquals(calc, "2 3 +", 5.0);
        checkEquals(calc, "2 3 4 * +", 14.0);
        checkEquals(calc, "5 1 2 + 4 * + 3 -", 14.0); // классический пример из Википедии
        checkEquals(calc, "10 2 /", 5.0);
        checkEquals(calc, "3 4 -", -1.0);

        // --- Негативные тесты калькулятора ---
        checkThrows(() -> calc.evaluate("1 2 + *"),
                IllegalStateException.class,
                "Недостаточно аргументов для операций (POP на пустом стеке)");

        checkThrows(() -> calc.evaluate("1 2"),   // после парсинга в стеке 2 элемента
                IllegalStateException.class,
                "Лишние элементы в стеке после вычисления");

        checkThrows(() -> calc.evaluate("10 0 /"),
                ArithmeticException.class,
                "Деление на ноль");

        checkThrows(() -> calc.evaluate("abc 1 +"),
                IllegalArgumentException.class,
                "Неизвестный токен");

        checkThrows(() -> calc.evaluate(""),
                IllegalArgumentException.class,
                "Пустое выражение");

        // --- Негативные тесты стека (дурак-программист) ---
        ArrayStack stack = new ArrayStack(2);
        checkThrows(stack::pop,
                IllegalStateException.class,
                "POP на пустом стеке");

        // проверка переполнения
        checkThrows(() -> {
                    stack.push(1.0);
                    stack.push(2.0);
                    stack.push(3.0); // третий элемент в стек размером 2
                },
                IllegalStateException.class,
                "Переполнение стека");

        System.out.printf("Тестов пройдено: %d/%d%n", passed, tests);
    }

    private static void checkEquals(RpnCalculator calc, String expr, double expected) {
        tests++;
        try {
            double actual = calc.evaluate(expr);
            if (Math.abs(actual - expected) < 1e-9) {
                passed++;
                System.out.println("[OK] " + expr + " = " + actual);
            } else {
                System.out.println("[FAIL] " + expr + " ожидается " + expected + ", получено " + actual);
            }
        } catch (Exception e) {
            System.out.println("[FAIL] " + expr + " выбросил исключение: " + e);
        }
    }

    private static void checkThrows(Runnable action,
                                   Class<? extends Throwable> expectedException,
                                   String description) {
        tests++;
        try {
            action.run();
            System.out.println("[FAIL] Ожидалось исключение " + expectedException.getSimpleName()
                    + " (" + description + "), но ничего не было выброшено");
        } catch (Throwable e) {
            if (expectedException.isInstance(e)) {
                passed++;
                System.out.println("[OK] Брошено ожидаемое исключение "
                        + expectedException.getSimpleName() + " (" + description + "): " + e.getMessage());
            } else {
                System.out.println("[FAIL] Ожидалось исключение " + expectedException.getSimpleName()
                        + " (" + description + "), но было: " + e);
            }
        }
    }
}

