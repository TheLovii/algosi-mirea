package prac6;
public class MovablePoint implements Movable, Printable {
    public MovablePoint(int x, int y, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }
    @Override
    public void moveUp() {
        this.y += this.ySpeed;
    }
    @Override
    public void moveDown() {
        this.y -= this.ySpeed;
    }
    @Override
    public void moveLeft() {
        this.x -= this.xSpeed;
    }
    @Override
    public void moveRight() {
        this.x += this.xSpeed;
    }
    @Override
    public String toString() {
        return "x: " + this.x + "\ny: " + this.y + "\nxSpeed: " + this.xSpeed + "\nySpeed: " + this.ySpeed;
    }
    @Override
    public void print() {
        System.out.println(this.toString());
    }

    private int x, y, xSpeed, ySpeed;
}