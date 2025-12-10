package prac21;

public class Task3 {
    public static <T> T getElement(T[] array, int index) {
        if (index < 0 || index >= array.length) {
            throw new IndexOutOfBoundsException("Index: " + index + ", length: " + array.length);
        }
        return array[index];
    }
}
