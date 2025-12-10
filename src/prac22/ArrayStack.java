package prac22;

public class ArrayStack {
    private final double[] data;
    private int sp; // stack pointer: указывает на СВОБОДНУЮ позицию (кол-во элементов в стеке)

    public ArrayStack(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Размер стека должен быть положительным");
        }
        this.data = new double[capacity];
        this.sp = 0;
    }

    public void push(double value) {
        if (sp >= data.length) {
            throw new IllegalStateException("Стек переполнен, невозможно выполнить PUSH");
        }
        data[sp++] = value;
    }

    public double pop() {
        if (sp <= 0) {
            throw new IllegalStateException("Невозможно выполнить POP для пустого стека");
        }
        return data[--sp];
    }

    public int size() {
        return sp;
    }

    public boolean isEmpty() {
        return sp == 0;
    }

    public void clear() {
        sp = 0;
    }
}

