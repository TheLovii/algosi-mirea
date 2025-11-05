package prac12;

public class Person {
    private String firstName;
    private String lastName;
    private String patronymic;

    public Person(String firstName, String lastName, String patronymic) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
    }

    public String getFullName() {
        StringBuilder fullName = new StringBuilder(lastName);
        
        if (firstName != null && !firstName.isEmpty()) {
            fullName.append(" ").append(firstName.charAt(0)).append(".");
        }
        
        if (patronymic != null && !patronymic.isEmpty()) {
            fullName.append(" ").append(patronymic.charAt(0)).append(".");
        }
        
        return fullName.toString();
    }

    public static void main(String[] args) {
        Person person1 = new Person("Иван", "Иванов", "Иванович");
        Person person2 = new Person(null, "Петров", null);

        System.out.println(person1.getFullName());  // Иванов И.И.
        System.out.println(person2.getFullName());  // Петров
    }
}

