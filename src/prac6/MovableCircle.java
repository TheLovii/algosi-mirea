package prac6;
public class MovableCircle implements Movable, Printable {
    public MovableCircle(int x, int y, int xSpeed, int ySpeed, int radius) {
        this.center = new MovablePoint(x, y, xSpeed, ySpeed);
        this.radius = radius;
    }

    @Override
    public void moveUp() {
        this.center.moveUp();
    }
    @Override
    public void moveDown() {
        this.center.moveDown();
    }
    @Override
    public void moveLeft() {
        this.center.moveLeft();
    }
    @Override
    public void moveRight() {
        this.center.moveRight();
    }
    @Override
    public String toString() {
        return "center:\n" + center.toString() + "\nradius: " + radius;
    }
    @Override
    public void print() {
        System.out.println(this.toString());
    }

    private int radius;
    private MovablePoint center;
}
