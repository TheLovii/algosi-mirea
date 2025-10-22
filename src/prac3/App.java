package prac3;

import java.util.Random;

public class App {
    public static void main(String[] args) {

    }
    public static void random_task() {
        Random rand = new Random();

        int[] arr = new int[4];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(90) + 10; // [10;99]
        }

        System.out.print("Массив: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        boolean flag = true;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] <= arr[i - 1]) {
                flag = false;
                break;
            }
        }

        if (flag) {
            System.out.println("Массив является строго возрастающей последовательностью.");
        } else {
            System.out.println("Массив НЕ является строго возрастающей последовательностью.");
        }
    }
    public static void obolochki_task() {
        Double d1 = Double.valueOf(10.5);
        Double d2 = Double.valueOf("20.25");
        
        String str = "45.67";
        double parsed = Double.parseDouble(str);

        Double dObj = Double.valueOf(99.99);
        byte b = dObj.byteValue();
        short s = dObj.shortValue();
        int i = dObj.intValue();
        long l = dObj.longValue();
        float f = dObj.floatValue();
        double d = dObj.doubleValue();

        System.out.println("Объект Double: " + dObj);

        String dStr = Double.toString(3.14);

        System.out.println("d1 = " + d1);
        System.out.println("d2 = " + d2);
        System.out.println("Строка \"" + str + "\" -> double = " + parsed);

        System.out.println("Преобразования объекта Double:");
        System.out.println("byte = " + b);
        System.out.println("short = " + s);
        System.out.println("int = " + i);
        System.out.println("long = " + l);
        System.out.println("float = " + f);
        System.out.println("double = " + d);

        System.out.println("Литерал double -> String: " + dStr);
    }
}
    


