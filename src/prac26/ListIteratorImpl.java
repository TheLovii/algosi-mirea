package prac26;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class ListIteratorImpl<E> implements Iterator<E> {

    private final List<E> list;
    private int currentIndex = 0;
    private boolean canRemove = false;

    public ListIteratorImpl(List<E> list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < list.size();
    }

    @Override
    public E next() {
        if (!hasNext()) {
            throw new NoSuchElementException("Нет следующего элемента");
        }
        E value = list.get(currentIndex);
        currentIndex++;
        canRemove = true;
        return value;
    }

    @Override
    public void remove() {
        if (!canRemove) {
            throw new IllegalStateException("Нельзя удалить элемент до вызова next()");
        }
        // удаляем предыдущий элемент (который только что вернул next)
        list.remove(--currentIndex);
        canRemove = false;
    }

    // Пример использования
    public static void main(String[] args) {
        List<Integer> nums = java.util.Arrays.asList(10, 20, 30, 40);
        Iterator<Integer> it = new ListIteratorImpl<>(nums);

        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}

