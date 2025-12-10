package prac21;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Task4 {
    public static List<String> saveDirectoryContents(String directoryPath) {
        File dir = new File(directoryPath);
        List<String> items = new ArrayList<>();

        if (!dir.isDirectory()) {
            System.out.println("Указанный путь не является каталогом: " + directoryPath);
            return items;
        }

        File[] files = dir.listFiles();
        if (files == null) {
            System.out.println("Не удалось прочитать содержимое каталога.");
            return items;
        }

        for (File f : files) {
            items.add(f.getName());
        }

        // выводим первые 5 элементов
        System.out.println("Первые 5 элементов каталога:");
        int limit = Math.min(5, items.size());
        for (int i = 0; i < limit; i++) {
            System.out.println(items.get(i));
        }

        return items;
    }
}
