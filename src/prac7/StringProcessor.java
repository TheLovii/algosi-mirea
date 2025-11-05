package prac7;

public interface StringProcessor {
    /**
     * Подсчитать количество символов в строке.
     * @param s исходная строка (не null)
     * @return количество символов
     * @throws IllegalArgumentException если s == null
     */
    int count(String s);

    /**
     * Вернуть строку, составленную из символов исходной строки,
     * расположенных на нечетных позициях (1, 3, 5, ...).
     * (Т.е. индексы 0, 2, 4, ... в нумерации Java.)
     * @param s исходная строка (не null)
     * @return новая строка из символов на нечетных позициях
     * @throws IllegalArgumentException если s == null
     */
    String oddChars(String s);

    /**
     * Инвертировать (развернуть) строку.
     * @param s исходная строка (не null)
     * @return развернутая строка
     * @throws IllegalArgumentException если s == null
     */
    String invert(String s);
}

