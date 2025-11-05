package prac7;

public class ProcessStrings implements StringProcessor {

    @Override
    public int count(String s) {
        requireNonNull(s);
        return s.length();
    }

    @Override
    public String oddChars(String s) {
        requireNonNull(s);
        StringBuilder sb = new StringBuilder(s.length());
        for (int i = 0; i < s.length(); i += 2) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    @Override
    public String invert(String s) {
        requireNonNull(s);
        return new StringBuilder(s).reverse().toString();
    }

    private static void requireNonNull(String s) {
        if (s == null) throw new IllegalArgumentException("Строка не должна быть null");
    }
}
