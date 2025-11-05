package prac10;

import java.util.Comparator;

public final class StudentComparators {
    private StudentComparators() {}

    // По среднему баллу (убывание)
    public static final Comparator<Student> BY_GPA_DESC =
            (a, b) -> Double.compare(b.getGpa(), a.getGpa());

    // По фамилии, затем имени (возрастание)
    public static final Comparator<Student> BY_LASTNAME_FIRSTNAME =
            Comparator.comparing(Student::getLastName)
                      .thenComparing(Student::getFirstName);

    // Пример альтернативного критерия: курс (возр.), затем группа (строчно)
    public static final Comparator<Student> BY_COURSE_GROUP =
            Comparator.comparingInt(Student::getCourse)
                      .thenComparing(Student::getGroup);
}

