package prac4;

public class Employer {
    protected String firstName;
    protected String lastName;
    protected double income; // месячная зарплата

    public Employer(String firstName, String lastName, double income) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.income = income;
    }

    // Метод для расчёта годового дохода
    public double getIncome() {
        return income * 12; // оклад × 12 месяцев
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + ", income: " + getIncome();
    }
}