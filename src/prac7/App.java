package prac7;

public class App {
    public static void main(String[] args) {
        test_task_4();
        test_task_5_6();
    }

    public static void test_task_4() {
        MathFunc mf = new MathFunc();

        double p = mf.pow(2, 10);
        double mod = mf.absComplex(3, 4);
        double len = mf.circleLength(5);

        System.out.println("2^10 = " + p);
        System.out.println("|3 + 4i| = " + mod);
        System.out.println("Длина окружности (r=5): " + len);

        System.out.println("PI из интерфейса: " + MathCalculable.PI + '\n');
    }

    public static void test_task_5_6() {
        StringProcessor sp = new ProcessStrings();

        String s1 = "Пример: ABCdef123";
        String s2 = "";
        String s3 = "a";

        System.out.println("s1 = " + s1);
        System.out.println("count(s1)    = " + sp.count(s1));
        System.out.println("oddChars(s1) = " + sp.oddChars(s1));
        System.out.println("invert(s1)   = " + sp.invert(s1));
        System.out.println();

        System.out.println("s2 = \"" + s2 + "\"");
        System.out.println("count(s2)    = " + sp.count(s2));
        System.out.println("oddChars(s2) = \"" + sp.oddChars(s2) + "\"");
        System.out.println("invert(s2)   = \"" + sp.invert(s2) + "\"");
        System.out.println();

        System.out.println("s3 = " + s3);
        System.out.println("count(s3)    = " + sp.count(s3));
        System.out.println("oddChars(s3) = " + sp.oddChars(s3));
        System.out.println("invert(s3)   = " + sp.invert(s3));
    }
}


