package prac23;

public class ArrayQueueModule {
    private static final int INITIAL_CAPACITY = 16;
    private static Object[] elements = new Object[INITIAL_CAPACITY];
    private static int head = 0;
    private static int size = 0;

    private static void ensureCapacity(int capacity) {
        if (capacity <= elements.length) {
            return;
        }
        int newCapacity = Math.max(capacity, elements.length * 2);
        Object[] newElements = new Object[newCapacity];
        // копируем элементы в правильном порядке
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[(head + i) % elements.length];
        }
        elements = newElements;
        head = 0;
    }

    public static void enqueue(Object element) {
        if (element == null) {
            throw new IllegalArgumentException("element must not be null");
        }
        ensureCapacity(size + 1);
        int tail = (head + size) % elements.length;
        elements[tail] = element;
        size++;
    }

    public static Object element() {
        if (size == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        return elements[head];
    }

    public static Object dequeue() {
        if (size == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        Object result = elements[head];
        elements[head] = null; // помогаем GC
        head = (head + 1) % elements.length;
        size--;
        return result;
    }

    public static int size() {
        return size;
    }


    public static boolean isEmpty() {
        return size == 0;
    }


    public static void clear() {
        for (int i = 0; i < size; i++) {
            elements[(head + i) % elements.length] = null;
        }
        head = 0;
        size = 0;
    }
}
