package prac21;

public class Task2<T> {
    private Object[] data;
    private int size;

    public Task2() {
        this.data = new Object[10]; // начальная ёмкость
        this.size = 0;
    }

    // добавить элемент в конец
    public void add(T element) {
        ensureCapacity();
        data[size++] = element;
    }

    // 3. вернуть элемент по индексу
    public T get(int index) {
        checkIndex(index);
        @SuppressWarnings("unchecked")
        T element = (T) data[index];
        return element;
    }

    public int size() {
        return size;
    }

    // заменить элемент по индексу
    public void set(int index, T element) {
        checkIndex(index);
        data[index] = element;
    }

    private void ensureCapacity() {
        if (size == data.length) {
            Object[] newData = new Object[data.length * 2];
            System.arraycopy(data, 0, newData, 0, data.length);
            data = newData;
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", size: " + size);
        }
    }
}

