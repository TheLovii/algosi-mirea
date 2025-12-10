package prac27;

import java.util.PriorityQueue;

public class hashtab {

    private static final int TABLE_SIZE = 128; // размер таблицы

    // Элемент списка (цепочка) в одной ячейке хеш-таблицы
    private static class Node {
        String key;
        int value;
        Node next;

        Node(String key, int value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    // Собственно таблица: массив цепочек
    private static Node[] table;

    // Хеш-функция по строковому ключу
    public static int hashtabHash(String key) {
        int hash = 0;
        for (int i = 0; i < key.length(); i++) {
            hash = (hash * 31 + key.charAt(i)) % TABLE_SIZE;
        }
        if (hash < 0) hash += TABLE_SIZE;
        return hash;
    }

    // Инициализация таблицы
    public static void hashtabInit() {
        table = new Node[TABLE_SIZE];
    }

    // Добавление (или обновление) элемента по ключу
    public static void hashtabAdd(String key, int value) {
        int index = hashtabHash(key);
        Node current = table[index];

        while (current != null) {
            if (current.key.equals(key)) {
                current.value = value;
                return;
            }
            current = current.next;
        }

        // иначе добавим новый элемент в цепочку (в начало списка)
        Node newNode = new Node(key, value, table[index]);
        table[index] = newNode;
    }

    // Поиск элемента по ключу, возвращает значение или null
    public static Integer hashtabLookup(String key) {
        int index = hashtabHash(key);
        Node current = table[index];

        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    // Удаление элемента по ключу
    public static void hashtabDelete(String key) {
        int index = hashtabHash(key);
        Node current = table[index];
        Node prev = null;

        while (current != null) {
            if (current.key.equals(key)) {
                if (prev == null) {
                    table[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    // Вспомогательный метод для красивого вывода содержимого таблицы
    public static void hashtabPrintAll() {
        System.out.println("Содержимое хеш-таблицы:");
        for (int i = 0; i < TABLE_SIZE; i++) {
            Node current = table[i];
            if (current != null) {
                System.out.print("[" + i + "]: ");
                while (current != null) {
                    System.out.print("(" + current.key + " -> " + current.value + ") ");
                    current = current.next;
                }
                System.out.println();
            }
        }
        System.out.println();
    }


    public static void main(String[] args) {
        // ----- Задание 2: создать словарь из 10 элементов -----
        hashtabInit();

        hashtabAdd("one", 1);
        hashtabAdd("two", 2);
        hashtabAdd("three", 3);
        hashtabAdd("four", 4);
        hashtabAdd("five", 5);
        hashtabAdd("six", 6);
        hashtabAdd("seven", 7);
        hashtabAdd("eight", 8);
        hashtabAdd("nine", 9);
        hashtabAdd("ten", 10);

        hashtabPrintAll();

        // ----- Задание 3: поиск элемента и удаление -----
        String keyToFind = "five";
        System.out.println("Поиск ключа \"" + keyToFind + "\"");
        Integer value = hashtabLookup(keyToFind);
        if (value != null) {
            System.out.println("Найдено: " + keyToFind + " -> " + value);
        } else {
            System.out.println("Ключ \"" + keyToFind + "\" не найден");
        }

        System.out.println("\nУдаляем ключ \"" + keyToFind + "\"");
        hashtabDelete(keyToFind);

        System.out.println("Повторный поиск ключа \"" + keyToFind + "\" после удаления:");
        value = hashtabLookup(keyToFind);
        if (value != null) {
            System.out.println("Найдено: " + keyToFind + " -> " + value);
        } else {
            System.out.println("Ключ \"" + keyToFind + "\" не найден (успешно удалён)");
        }

        System.out.println();
        hashtabPrintAll();

        // ----- Задание 4: очередь с приоритетом из 10 элементов -----
        System.out.println("Демонстрация очереди с приоритетом (PriorityQueue):");

        PriorityQueue<Integer> pq = new PriorityQueue<>(); // min-heap по умолчанию

        // Добавим 10 элементов с разными "приоритетами" (значения — приоритеты)
        int[] priorities = { 50, 10, 70, 30, 20, 90, 40, 80, 60, 0 };
        for (int p : priorities) {
            pq.add(p);
        }

        System.out.println("Извлекаем несколько элементов по приоритету (от меньшего к большему):");
        for (int i = 0; i < 5 && !pq.isEmpty(); i++) {
            int head = pq.poll(); // извлечение элемента с наименьшим значением
            System.out.println("  Извлечён элемент: " + head);
        }

        System.out.println("\nОставшиеся элементы в очереди (в порядке извлечения):");
        while (!pq.isEmpty()) {
            System.out.print(pq.poll() + " ");
        }
        System.out.println();
    }
}

