package prac4;

public class Manager extends Employer {
    private double averageSum; // средняя сумма выплат от продаж

    public Manager(String firstName, String lastName, double income, double averageSum) {
        super(firstName, lastName, income);
        this.averageSum = averageSum;
    }

    @Override
    public double getIncome() {
        return super.getIncome() + averageSum * 12; // базовый доход + продажи
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " (Manager), income: " + getIncome();
    }
}