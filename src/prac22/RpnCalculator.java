package prac22;

// File: RpnCalculator.java
public class RpnCalculator {

    /**
     * Вычисляет значение выражения в обратной польской нотации.
     * Пример: "2 3 4 * +" -> 14.0
     */
    public double evaluate(String expression) {
        if (expression == null || expression.trim().isEmpty()) {
            throw new IllegalArgumentException("Пустое выражение");
        }

        String[] tokens = expression.trim().split("\\s+");
        ArrayStack stack = new ArrayStack(tokens.length);

        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];

            if ("+".equals(token)) {
                double b = stack.pop();
                double a = stack.pop();
                stack.push(a + b);
            } else if ("-".equals(token)) {
                double b = stack.pop();
                double a = stack.pop();
                stack.push(a - b);
            } else if ("*".equals(token)) {
                double b = stack.pop();
                double a = stack.pop();
                stack.push(a * b);
            } else if ("/".equals(token)) {
                double b = stack.pop();
                double a = stack.pop();
                if (b == 0.0) {
                    throw new ArithmeticException("Деление на ноль");
                }
                stack.push(a / b);
            } else {
                // пробуем разобрать как число
                try {
                    double value = Double.parseDouble(token);
                    stack.push(value);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Неизвестный токен: '" + token + "'");
                }
            }
        }

        if (stack.size() != 1) {
            throw new IllegalStateException(
                    "Некорректное выражение: после вычисления в стеке осталось "
                            + stack.size() + " элементов(а)"
            );
        }

        return stack.pop();
    }
}
