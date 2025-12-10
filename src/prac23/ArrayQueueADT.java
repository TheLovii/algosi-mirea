package prac23;


public class ArrayQueueADT {
    private Object[] elements;
    private int head;
    private int size;

    public ArrayQueueADT() {
        this.elements = new Object[16];
        this.head = 0;
        this.size = 0;
    }

    private static void ensureCapacity(ArrayQueueADT queue, int capacity) {
        if (capacity <= queue.elements.length) {
            return;
        }
        int newCapacity = Math.max(capacity, queue.elements.length * 2);
        Object[] newElements = new Object[newCapacity];
        for (int i = 0; i < queue.size; i++) {
            newElements[i] = queue.elements[(queue.head + i) % queue.elements.length];
        }
        queue.elements = newElements;
        queue.head = 0;
    }

    public static void enqueue(ArrayQueueADT queue, Object element) {
        if (queue == null) {
            throw new IllegalArgumentException("queue must not be null");
        }
        if (element == null) {
            throw new IllegalArgumentException("element must not be null");
        }
        ensureCapacity(queue, queue.size + 1);
        int tail = (queue.head + queue.size) % queue.elements.length;
        queue.elements[tail] = element;
        queue.size++;
    }

    public static Object element(ArrayQueueADT queue) {
        if (queue == null) {
            throw new IllegalArgumentException("queue must not be null");
        }
        if (queue.size == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        return queue.elements[queue.head];
    }

    public static Object dequeue(ArrayQueueADT queue) {
        if (queue == null) {
            throw new IllegalArgumentException("queue must not be null");
        }
        if (queue.size == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        Object result = queue.elements[queue.head];
        queue.elements[queue.head] = null;
        queue.head = (queue.head + 1) % queue.elements.length;
        queue.size--;
        return result;
    }

    public static int size(ArrayQueueADT queue) {
        if (queue == null) {
            throw new IllegalArgumentException("queue must not be null");
        }
        return queue.size;
    }

    public static boolean isEmpty(ArrayQueueADT queue) {
        if (queue == null) {
            throw new IllegalArgumentException("queue must not be null");
        }
        return queue.size == 0;
    }

    public static void clear(ArrayQueueADT queue) {
        if (queue == null) {
            throw new IllegalArgumentException("queue must not be null");
        }
        for (int i = 0; i < queue.size; i++) {
            queue.elements[(queue.head + i) % queue.elements.length] = null;
        }
        queue.head = 0;
        queue.size = 0;
    }
}

