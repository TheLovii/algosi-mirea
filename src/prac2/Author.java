package prac2;

public class Author {
    public Author(String name, String email, char gender) throws IllegalArgumentException {
        if (gender != 'м' && gender != 'ж') {
            throw new IllegalArgumentException("Нет гендера кроме М или Ж.");
        }
        this.gender = gender;
        this.name = name;
        this.email = email;
    }
    public String getName() {return name;}
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    public char getGender() {return gender;}

    @Override
    public String toString() {
        return "Имя: " + name + "\nEmail: " + email + "\nПол: " + gender;
    }
    private String name, email;
    private char gender;
}
