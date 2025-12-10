package prac26;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList<E> implements Iterable<E> {

    private Object[] elements;
    private int size;

    public MyArrayList() {
        this.elements = new Object[10];
        this.size = 0;
    }

    public void add(E element) {
        ensureCapacity();
        elements[size++] = element;
    }

    public E get(int index) {
        checkIndex(index);
        @SuppressWarnings("unchecked")
        E value = (E) elements[index];
        return value;
    }

    public int size() {
        return size;
    }

    private void ensureCapacity() {
        if (size == elements.length) {
            Object[] newArr = new Object[elements.length * 2];
            System.arraycopy(elements, 0, newArr, 0, elements.length);
            elements = newArr;
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index = " + index);
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new MyArrayListIterator();
    }

    // Внутренний класс-итератор
    private class MyArrayListIterator implements Iterator<E> {
        private int cursor = 0;
        private boolean canRemove = false;

        @Override
        public boolean hasNext() {
            return cursor < size;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            @SuppressWarnings("unchecked")
            E value = (E) elements[cursor++];
            canRemove = true;
            return value;
        }

        @Override
        public void remove() {
            if (!canRemove) {
                throw new IllegalStateException("Нельзя удалить до вызова next()");
            }
            // сдвигаем элементы влево
            int removeIndex = cursor - 1;
            int numMoved = size - removeIndex - 1;
            if (numMoved > 0) {
                System.arraycopy(elements, removeIndex + 1, elements, removeIndex, numMoved);
            }
            elements[--size] = null;  // на всякий случай освобождаем ссылку
            cursor--;                 // курсор тоже двигаем назад
            canRemove = false;
        }
    }

    // Пример использования
    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        for (String s : list) {
            System.out.println(s);
        }

        System.out.println("Удаляем через итератор:");
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String value = it.next();
            if ("B".equals(value)) {
                it.remove();
            }
        }

        for (String s : list) {
            System.out.println(s); // A, C
        }
    }
}
