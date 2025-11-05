import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 1) Создаёт массив Student и сортирует его по iDNumber вставками.
 * 2) Сортирует список студентов по GPA по убыванию с помощью quicksort (SortingStudentsByGPA).
 * 3) Объединяет два списка студентов и выдаёт один отсортированный (merge sort).
 */
public class App {

    public static void main(String[] args) {
        // ---------- 1. Сортировка вставками по iDNumber (массив) ----------
        Student[] arr = new Student[] {
                new Student("Alice", 104, 4.2),
                new Student("Bob",   101, 3.8),
                new Student("Cara",  109, 4.7),
                new Student("Dan",   103, 3.2),
                new Student("Eve",   102, 4.9)
        };

        System.out.println("До insertion sort по id:");
        printArray(arr);

        insertionSortById(arr);

        System.out.println("\nПосле insertion sort по id (по возрастанию):");
        printArray(arr);

        // ---------- 2. Быстрая сортировка списка по GPA (убывание) ----------
        List<Student> listByGpa = new ArrayList<>(Arrays.asList(
                new Student("Nick",   210, 3.4),
                new Student("Olga",   205, 4.5),
                new Student("Peter",  207, 3.9),
                new Student("Quinn",  206, 4.5),
                new Student("Riley",  203, 4.0)
        ));

        System.out.println("\nДо quicksort по GPA (убывание):");
        listByGpa.forEach(System.out::println);

        SortingStudentsByGPA gpaComparator = new SortingStudentsByGPA();
        gpaComparator.quickSort(listByGpa);

        System.out.println("\nПосле quicksort по GPA (убывание):");
        listByGpa.forEach(System.out::println);

        List<Student> groupA = Arrays.asList(
                new Student("Sasha",  330, 4.1),
                new Student("Tanya",  318, 3.6),
                new Student("Umar",   327, 4.8)
        );
        List<Student> groupB = Arrays.asList(
                new Student("Vera",   322, 3.9),
                new Student("Walt",   335, 3.1),
                new Student("Yana",   319, 4.3)
        );

        // Объединим и отсортируем по id (возрастание) через merge sort:
        List<Student> mergedById = MergeSortStudents.mergeTwoAndSort(groupA, groupB, MergeSortStudents.byIdAscending());

        System.out.println("\nСлияние двух списков и merge sort по id (возрастание):");
        mergedById.forEach(System.out::println);

        // (дополнительно) Можно отсортировать и по GPA по убыванию, передав соответствующий компаратор:
        List<Student> mergedByGpaDesc = MergeSortStudents.mergeTwoAndSort(groupA, groupB, new SortingStudentsByGPA());
        System.out.println("\nСлияние двух списков и merge sort по GPA (убывание):");
        mergedByGpaDesc.forEach(System.out::println);
    }

    // --------- Вставки по iDNumber (возрастание) ---------
    private static void insertionSortById(Student[] a) {
        for (int i = 1; i < a.length; i++) {
            Student key = a[i];
            int j = i - 1;
            while (j >= 0 && a[j].getiDNumber() > key.getiDNumber()) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
    }

    private static void printArray(Student[] a) {
        for (Student s : a) System.out.println(s);
    }
}
