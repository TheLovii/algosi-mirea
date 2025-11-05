package prac10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortingStudentsByGPA {

    // "Поле как массив объектов Student с названием iDNumber"
    private final List<Student> iDNumber = new ArrayList<>();

    public static void main(String[] args) {
        SortingStudentsByGPA app = new SortingStudentsByGPA();

        // 1) Заполнение массива
        app.setArray(sampleStudentsA());
        System.out.println("== Исходный список A ==");
        app.outArray();

        // 2) Быстрая сортировка по GPA (убывание)
        app.quickSort(StudentComparators.BY_GPA_DESC);
        System.out.println("\n== После quickSort по GPA (desc) ==");
        app.outArray();

        // 3) Сортировка слиянием по другому полю (фамилия+имя)
        app.mergeSortInPlace(StudentComparators.BY_LASTNAME_FIRSTNAME);
        System.out.println("\n== После mergeSort по Фамилии, затем Имени ==");
        app.outArray();

        // 4) Демонстрация объединения двух списков данных о студентах в один отсортированный
        List<Student> listA = sampleStudentsA();
        List<Student> listB = sampleStudentsB();

        // Отсортируем оба списка по GPA убыв. (как будто пришли уже отсортированными)
        quickSortStatic(listA, StudentComparators.BY_GPA_DESC);
        quickSortStatic(listB, StudentComparators.BY_GPA_DESC);

        List<Student> merged = mergeTwoSortedLists(listA, listB, StudentComparators.BY_GPA_DESC);
        System.out.println("\n== Объединение двух списков в один отсортированный по GPA (desc) ==");
        merged.forEach(System.out::println);

        // 5) Пример сортировки по альтернативному полю
        quickSortStatic(merged, StudentComparators.BY_COURSE_GROUP);
        System.out.println("\n== Тот же объединённый список, но отсортирован по (курс, группа) ==");
        merged.forEach(System.out::println);
    }

    /* ===================== Требуемые методы класса ===================== */

    // (1) setArray(): заполнение массива
    public void setArray(List<Student> data) {
        iDNumber.clear();
        iDNumber.addAll(data);
    }

    // (2) quicksort(): быстрая сортировка, реализующая Comparator (по умолчанию — по GPA desc)
    public void quickSort(Comparator<Student> cmp) {
        quickSortInternal(iDNumber, 0, iDNumber.size() - 1, cmp);
    }

    // Доп. статичная версия — удобно для примеров
    public static void quickSortStatic(List<Student> list, Comparator<Student> cmp) {
        quickSortInternal(list, 0, list.size() - 1, cmp);
    }

    private static void quickSortInternal(List<Student> list, int left, int right, Comparator<Student> cmp) {
        if (left >= right) return;
        int i = left, j = right;
        Student pivot = list.get(left + (right - left) / 2);
        while (i <= j) {
            while (cmp.compare(list.get(i), pivot) < 0) i++;
            while (cmp.compare(list.get(j), pivot) > 0) j--;
            if (i <= j) {
                Collections.swap(list, i, j);
                i++; j--;
            }
        }
        if (left < j)  quickSortInternal(list, left, j, cmp);
        if (i < right) quickSortInternal(list, i, right, cmp);
    }

    // (2) Дополнительно: сортировка слиянием (merge sort)
    public void mergeSortInPlace(Comparator<Student> cmp) {
        List<Student> sorted = mergeSortMakeNew(iDNumber, cmp);
        iDNumber.clear();
        iDNumber.addAll(sorted);
    }

    private static List<Student> mergeSortMakeNew(List<Student> src, Comparator<Student> cmp) {
        if (src.size() <= 1) return new ArrayList<>(src);
        int mid = src.size() / 2;
        List<Student> left = mergeSortMakeNew(src.subList(0, mid), cmp);
        List<Student> right = mergeSortMakeNew(src.subList(mid, src.size()), cmp);
        return mergeTwoSortedLists(left, right, cmp);
    }

    // (3) outArray(): вывод массива студентов
    public void outArray() {
        for (Student s : iDNumber) {
            System.out.println(s);
        }
    }

    // (4) Возможность сортировать по другому полю — универсальный метод
    public void sortBy(Comparator<Student> cmp, boolean useQuickSort) {
        if (useQuickSort) quickSort(cmp);
        else mergeSortInPlace(cmp);
    }

    /* ===================== Объединение двух списков ===================== */

    // Объединяет ДВА УЖЕ ОТСОРТИРОВАННЫХ списка по заданному компаратору (линейное слияние)
    public static List<Student> mergeTwoSortedLists(List<Student> a, List<Student> b, Comparator<Student> cmp) {
        List<Student> res = new ArrayList<>(a.size() + b.size());
        int i = 0, j = 0;
        while (i < a.size() && j < b.size()) {
            if (cmp.compare(a.get(i), b.get(j)) <= 0) {
                res.add(a.get(i++));
            } else {
                res.add(b.get(j++));
            }
        }
        while (i < a.size()) res.add(a.get(i++));
        while (j < b.size()) res.add(b.get(j++));
        return res;
    }

    /* ===================== Тестовые данные ===================== */

    private static List<Student> sampleStudentsA() {
        List<Student> list = new ArrayList<>();
        list.add(new Student("Ivan", "Petrov", "CS", 2, "B-21", 4.5));
        list.add(new Student("Maria", "Sidorova", "Math", 1, "M-11", 5.0));
        list.add(new Student("Olga", "Ivanova", "CS", 3, "B-31", 3.8));
        list.add(new Student("Petr", "Smirnov", "SE", 2, "SE-22", 4.2));
        list.add(new Student("Dmitry", "Volkov", "CS", 4, "B-41", 3.9));
        return list;
    }

    private static List<Student> sampleStudentsB() {
        List<Student> list = new ArrayList<>();
        list.add(new Student("Anna", "Kuznetsova", "Math", 1, "M-12", 4.9));
        list.add(new Student("Sergey", "Lebedev", "SE", 2, "SE-21", 4.1));
        list.add(new Student("Nikita", "Morozov", "CS", 3, "B-32", 4.7));
        list.add(new Student("Elena", "Popova", "CS", 4, "B-42", 3.6));
        return list;
    }
}

