package prac11;

import java.util.Date;

public class Task1 {
    private final String developerSurname;
    private final Date receivedAt;   // дата/время получения задания
    private final Date submittedAt;  // дата/время сдачи (текущее)

    public Task1(String developerSurname, Date receivedAt) {
        this.developerSurname = developerSurname;
        this.receivedAt = receivedAt;
        this.submittedAt = new Date();
    }

    public void printReport() {
        System.out.println("=== Задание 1 ===");
        System.out.println("Фамилия разработчика: " + developerSurname);
        System.out.println("Дата и время получения задания: " + receivedAt);
        System.out.println("Дата и время сдачи задания:    " + submittedAt);
        System.out.println();
    }
}
