package prac28;

import java.util.HashSet;
import java.util.TreeSet;

public class SetConverter {

    /*
    Преобразует HashSet в TreeSet.
    Элементы должны быть сравнимыми (Comparable),
    поэтому вводим ограничение T extends Comparable.
    */
    public static <T extends Comparable<? super T>> TreeSet<T> toTreeSet(HashSet<T> hashSet) {
        return new TreeSet<>(hashSet);
    }
    /*
    Для теста:
    HashSet<String> hs = new HashSet<>();
    hs.add("bbb");
    hs.add("aaa");
    hs.add("ccc");
    TreeSet<String> ts = SetConverter.toTreeSet(hs);
    */
}
