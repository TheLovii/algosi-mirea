package prac4;

public class App{
    public static void main(String[] args) {
        Employer e = new Manager("Ivan", "Petrov", 3000, 500);

        System.out.println("Полиморфизм: " + e.getIncome());

        // Массив сотрудников
        Employer[] staff = {
                new Employer("Alex", "Ivanov", 2500),
                new Manager("Maria", "Smirnova", 3200, 700),
                new Employer("Oleg", "Kuznetsov", 2800),
                new Manager("Anna", "Popova", 4000, 1200)
        };

        // Вызов метода getIncome для каждого
        System.out.println("\nСписок сотрудников:");
        for (Employer emp : staff) {
            System.out.println(emp);
        }
    }
}