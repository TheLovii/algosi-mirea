package prac28;


public class DoubleHashTable<V> {

    private static class Node<V> {
        final double key;
        V value;
        Node<V> next;

        Node(double key, V value, Node<V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private Node<V>[] table;
    private int size;

    @SuppressWarnings("unchecked")
    public DoubleHashTable(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be > 0");
        }
        // массив списков
        this.table = (Node<V>[]) new Node[capacity];
    }

    /*
    Хеш-функция для ключа double.
     Использует двоичное представление числа и смешивание битов.
    */
    private int hash(double key) {
        long bits = Double.doubleToLongBits(key);
        bits ^= (bits >>> 32); // смешиваем старшие и младшие биты
        int h = (int) (bits & 0x7fffffff); // делаем неотрицательным
        return h % table.length;
    }

    // Поместить значение по ключу (добавить или перезаписать).
    public void put(double key, V value) {
        int index = hash(key);
        Node<V> current = table[index];

        // проверяем, есть ли уже такой ключ
        for (Node<V> n = current; n != null; n = n.next) {
            if (Double.compare(n.key, key) == 0) {
                // перезаписываем значение
                n.value = value;
                return;
            }
        }

        table[index] = new Node<>(key, value, current);
        size++;
    }

    public V get(double key) {
        int index = hash(key);
        for (Node<V> n = table[index]; n != null; n = n.next) {
            if (Double.compare(n.key, key) == 0) {
                return n.value;
            }
        }
        return null;
    }

    public boolean remove(double key) {
        int index = hash(key);
        Node<V> prev = null;
        Node<V> cur = table[index];

        while (cur != null) {
            if (Double.compare(cur.key, key) == 0) {
                if (prev == null) {
                    table[index] = cur.next;
                } else {
                    prev.next = cur.next;
                }
                size--;
                return true;
            }
            prev = cur;
            cur = cur.next;
        }
        return false;
    }


    public boolean containsKey(double key) {
        return get(key) != null;
    }

    public int size() {
        return size;
    }
}

