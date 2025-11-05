package prac12;

public class StringManipulator {

    public static void main(String[] args) {
        String str = "I like Java!!!";
        
        // 2. Распечатать последний символ строки.
        System.out.println("Последний символ: " + str.charAt(str.length() - 1));

        // 3. Проверить, заканчивается ли строка подстрокой "!!!".
        System.out.println("Заканчивается ли строка '!!!'? " + str.endsWith("!!!"));

        // 4. Проверить, начинается ли строка подстрокой "I like".
        System.out.println("Начинается ли строка с 'I like'? " + str.startsWith("I like"));

        // 5. Проверить, содержит ли строка подстроку "Java".
        System.out.println("Содержит ли строка 'Java'? " + str.contains("Java"));

        // 6. Найти позицию подстроки "Java" в строке.
        System.out.println("Позиция подстроки 'Java': " + str.indexOf("Java"));

        // 7. Заменить все символы "а" на "о".
        System.out.println("Строка после замены 'a' на 'o': " + str.replace('a', 'o'));

        // 8. Преобразовать строку в верхний регистр.
        System.out.println("Строка в верхнем регистре: " + str.toUpperCase());

        // 9. Преобразовать строку в нижний регистр.
        System.out.println("Строка в нижнем регистре: " + str.toLowerCase());

        // 10. Вырезать строку "Java" с помощью метода substring.
        System.out.println("Вырезанная подстрока 'Java': " + str.substring(str.indexOf("Java"), str.indexOf("Java") + 4));
    }
}

