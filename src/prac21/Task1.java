package prac21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task1 {
    public static <T> List<T> arrayToList(T[] array) {
        return new ArrayList<>(Arrays.asList(array));
    }

    public static List<Integer> intArrayToList(int[] array) {
        List<Integer> list = new ArrayList<>(array.length);
        for (int value : array) {
            list.add(value); // автоупаковка int → Integer
        }
        return list;
    }

    public static List<Long> longArrayToList(long[] array) {
        List<Long> list = new ArrayList<>(array.length);
        for (long value : array) {
            list.add(value); // автоупаковка long → Long
        }
        return list;
    }
}

