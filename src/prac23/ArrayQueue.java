package prac23;

import java.util.Arrays;

public class ArrayQueue extends AbstractQueue implements Queue {
    private static final int INITIAL_CAPACITY = 16;
    private Object[] elements = new Object[INITIAL_CAPACITY];
    private int head = 0;

    private void ensureCapacity(int capacity) {
        if (capacity <= elements.length) {
            return;
        }
        int newCapacity = Math.max(capacity, elements.length * 2);
        Object[] newElements = new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[(head + i) % elements.length];
        }
        elements = newElements;
        head = 0;
    }

    @Override
    public void enqueue(Object element) {
        if (element == null) {
            throw new IllegalArgumentException("element must not be null");
        }
        ensureCapacity(size + 1);
        int tail = (head + size) % elements.length;
        elements[tail] = element;
        size++;
    }

    @Override
    public Object element() {
        if (size == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        return elements[head];
    }

    @Override
    public Object dequeue() {
        if (size == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        Object result = elements[head];
        elements[head] = null;
        head = (head + 1) % elements.length;
        size--;
        return result;
    }

    @Override
    public void clear() {
        Arrays.fill(elements, null);
        head = 0;
        size = 0;
    }
}

