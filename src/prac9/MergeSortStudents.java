package prac9;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class MergeSortStudents {

    public static List<Student> mergeSort(List<Student> src, Comparator<Student> cmp) {
        if (src == null || src.size() <= 1) return src;
        return mergeSortRec(new ArrayList<>(src), cmp);
    }

    private static List<Student> mergeSortRec(List<Student> a, Comparator<Student> cmp) {
        int n = a.size();
        if (n <= 1) return a;

        int mid = n / 2;
        List<Student> left = mergeSortRec(new ArrayList<>(a.subList(0, mid)), cmp);
        List<Student> right = mergeSortRec(new ArrayList<>(a.subList(mid, n)), cmp);

        return merge(left, right, cmp);
    }

    private static List<Student> merge(List<Student> left, List<Student> right, Comparator<Student> cmp) {
        List<Student> res = new ArrayList<>(left.size() + right.size());
        int i = 0, j = 0;
        while (i < left.size() && j < right.size()) {
            if (cmp.compare(left.get(i), right.get(j)) <= 0) {
                res.add(left.get(i++));
            } else {
                res.add(right.get(j++));
            }
        }
        while (i < left.size()) res.add(left.get(i++));
        while (j < right.size()) res.add(right.get(j++));
        return res;
    }

    public static List<Student> mergeTwoAndSort(List<Student> a, List<Student> b, Comparator<Student> cmp) {
        List<Student> combined = new ArrayList<>(a.size() + b.size());
        combined.addAll(a);
        combined.addAll(b);
        return mergeSort(combined, cmp);
    }

    public static Comparator<Student> byIdAscending() {
        return Comparator.comparingInt(Student::getiDNumber);
    }
}
