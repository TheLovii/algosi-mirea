package prac2;

public class TestBall {
    public static void main(String[] args) {
        // Создание объектов
        Ball b1 = new Ball(1.0, 2.0);
        Ball b2 = new Ball();

        // Вывод начальных координат
        System.out.println("b1: " + b1);
        System.out.println("b2: " + b2);

        // Тест геттеров и сеттеров
        b2.setX(5.0);
        b2.setY(7.0);
        System.out.println("b2 после установки координат: " + b2);

        // Тест setXY
        b1.setXY(3.0, 4.0);
        System.out.println("b1 после setXY: " + b1);

        // Тест move
        b1.move(2.0, -1.0);
        System.out.println("b1 после move: " + b1);
    }
}
