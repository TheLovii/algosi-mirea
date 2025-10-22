package prac6;

public class App {
    public static void main(String[] args) throws Exception {
        MovableCircle a = new MovableCircle(0, 0, 1, 1, 5);
        a.moveDown();
        a.print();

        MovableRectangle b = new MovableRectangle(0, 0, 3, 3, 2, 1);
        b.moveLeft();
        b.print();
    }
}
