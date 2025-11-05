package prac11;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class Student {
    private String name;
    private String surname;
    private String major; // Специальность
    private int course;   // Курс
    private String group; // Группа
    private LocalDate birthDate;

    public Student(String name, String surname, String major, int course, String group, LocalDate birthDate) {
        this.name = name;
        this.surname = surname;
        this.major = major;
        this.course = course;
        this.group = group;
        this.birthDate = birthDate;
    }

    // Геттеры/сеттеры
    public String getName() { return name; }
    public String getSurname() { return surname; }
    public String getMajor() { return major; }
    public int getCourse() { return course; }
    public String getGroup() { return group; }
    public LocalDate getBirthDate() { return birthDate; }

    public void setName(String name) { this.name = name; }
    public void setSurname(String surname) { this.surname = surname; }
    public void setMajor(String major) { this.major = major; }
    public void setCourse(int course) { this.course = course; }
    public void setGroup(String group) { this.group = group; }
    public void setBirthDate(LocalDate birthDate) { this.birthDate = birthDate; }

    public String getBirthDateFormatted(FormatStyle style, Locale locale) {
        if (birthDate == null) return "—";
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(style).withLocale(locale);
        return birthDate.format(formatter);
    }

    public String getBirthDateFormatted(String pattern) {
        if (birthDate == null) return "—";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return birthDate.format(formatter);
    }

    @Override
    public String toString() {
        String bday = getBirthDateFormatted(FormatStyle.MEDIUM, new Locale("ru", "RU"));
        return "Student{" +
                "Имя='" + name + '\'' +
                ", Фамилия='" + surname + '\'' +
                ", Специальность='" + major + '\'' +
                ", Курс=" + course +
                ", Группа='" + group + '\'' +
                ", Дата рождения=" + bday +
                '}';
    }
}

