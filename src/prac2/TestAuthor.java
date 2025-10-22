package prac2;

public class TestAuthor {
    public static void main(String[] args) throws Exception {
        Author a = new Author("bublik", "bublik@goole.com", 'м');
        System.out.println("Имя: " + a.getName() + "\nEmail: " + a.getEmail());
        a.setEmail("bublikov@mail.ru");
        System.out.println("Email после смены: " + a.getEmail());
    }
}