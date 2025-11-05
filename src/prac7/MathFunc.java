package prac7;

public class MathFunc implements MathCalculable {

    @Override
    public double pow(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    @Override
    public double absComplex(double re, double im) {
        return Math.hypot(re, im);
    }

    public double circleLength(double radius) {
        if (radius < 0) {
            throw new IllegalArgumentException("Радиус должен быть неотрицательным");
        }
        return 2 * MathCalculable.PI * radius;
    }
}
