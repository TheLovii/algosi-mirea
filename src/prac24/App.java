package prac24;

public class App {
    public static void main(String[] args) {
        ComplexAbstractFactory factory = new ConcreteFactory();

        Complex z0 = factory.createComplex();          // 0 + 0i
        Complex z1 = factory.createComplex(3, 4);      // 3 + 4i

        System.out.println("z0 = " + z0);
        System.out.println("z1 = " + z1);
    }
}
