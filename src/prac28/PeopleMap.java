package prac28;

import java.util.HashMap;
import java.util.Map;

public class PeopleMap {
    public static Map<String, String> createMap() {
        Map<String, String> map = new HashMap<>();

        map.put("Иванов",  "Иван");
        map.put("Петров",  "Пётр");
        map.put("Сидоров", "Иван");   // имя "Иван" повторяется
        map.put("Кузнецов","Алексей");
        map.put("Смирнов", "Алексей");// имя "Алексей" повторяется
        map.put("Соколов", "Дмитрий");
        map.put("Попов",   "Иван");   // ещё раз "Иван"
        map.put("Лебедев", "Сергей");
        map.put("Козлов",  "Павел");
        map.put("Новиков", "Дмитрий");// имя "Дмитрий" повторяется

        return map;
    }

    public static int getSameFirstNameCount(Map<String, String> map) {
        Map<String, Integer> counts = new HashMap<>();

        // считаем, сколько раз встречается каждое имя (значение)
        for (String firstName : map.values()) {
            counts.put(firstName, counts.getOrDefault(firstName, 0) + 1);
        }

        int result = 0;
        for (int c : counts.values()) {
            if (c > 1) {
                result += c; // считаем людей, а не число самих имён
            }
        }
        return result;
    }


    public static int getSameLastNameCount(Map<String, String> map) {
        Map<String, Integer> counts = new HashMap<>();

        for (String lastName : map.keySet()) {
            counts.put(lastName, counts.getOrDefault(lastName, 0) + 1);
        }

        int result = 0;
        for (int c : counts.values()) {
            if (c > 1) {
                result += c;
            }
        }
        return result;
    }
}

