package prac9;

import java.util.Comparator;
import java.util.List;
import java.util.Collections;

public class SortingStudentsByGPA implements Comparator<Student> {

    @Override
    public int compare(Student a, Student b) {
        // По убыванию: большее GPA должно быть "меньше" в понятиях сортировки
        return Double.compare(b.getGpa(), a.getGpa());
    }

    public void quickSort(List<Student> list) {
        if (list == null || list.size() < 2) return;
        quickSort(list, 0, list.size() - 1);
    }

    private void quickSort(List<Student> a, int lo, int hi) {
        if (lo >= hi) return;

        int i = lo, j = hi;
        Student pivot = a.get(lo + (hi - lo) / 2);

        while (i <= j) {
            while (compare(a.get(i), pivot) < 0) i++;
            while (compare(a.get(j), pivot) > 0) j--;
            if (i <= j) {
                Collections.swap(a, i, j);
                i++; j--;
            }
        }
        if (lo < j) quickSort(a, lo, j);
        if (i < hi) quickSort(a, i, hi);
    }
}
