package prac26;

import java.util.Stack;

public class Exercise1 {
    // Инвертирует массив "на месте" с использованием стека
    public static void reverse(int[] array) {
        Stack<Integer> stack = new Stack<>();

        // Кладём все элементы в стек
        for (int value : array) {
            stack.push(value);
        }

        // Достаём их обратно в массив (получится инверсия)
        int index = 0;
        while (!stack.isEmpty()) {
            array[index++] = stack.pop();
        }
    }

    // Пример использования
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        reverse(arr);
        for (int v : arr) {
            System.out.print(v + " "); // 5 4 3 2 1
        }
    }
}

