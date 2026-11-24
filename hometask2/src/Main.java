

import java.util.Scanner;

public class Main {

    public static void task1() {
        // Задача 1: Переворот строки
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите строку: ");
        String s = scanner.nextLine();

        String reversed = new StringBuilder(s).reverse().toString();

        System.out.println("Строка в обратном порядке: " + reversed);
    }

    public static void task2() {
        // Задача 2: Палиндром (игнорируя регистр и пробелы)
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите строку: ");
        String s = scanner.nextLine();

        String normalized = s.replaceAll("\\s+", "").toLowerCase();
        String reversed = new StringBuilder(normalized).reverse().toString();

        if (normalized.equals(reversed)) {
            System.out.println("Строка — палиндром");
        } else {
            System.out.println("Строка — не палиндром");
        }
    }

    public static void task3() {
        // Задача 3: Посчитать количество слов в строке
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите строку: ");
        String s = scanner.nextLine();

        String[] words = s.trim().split("\\s+");
        int count = words.length;

        // Если строка пустая или только пробелы
        if (s.trim().isEmpty()) {
            count = 0;
        }

        System.out.println("Количество слов: " + count);
    }

    public static void task4() {
        // Задача 4: Замена символа: "а" → "о", "н" → "е"
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите строку: ");
        String s = scanner.nextLine();

        String result = s.replace("а", "о").replace("н", "е");

        System.out.println("Результат: " + result);
    }

    public static void task5() {
        // Задача 5: Убрать повторяющиеся символы, оставить первое вхождение
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите строку: ");
        String s = scanner.nextLine();

        StringBuilder result = new StringBuilder();
        boolean[] seen = new boolean[Character.MAX_VALUE];

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!seen[ch]) {
                seen[ch] = true;
                result.append(ch);
            }
        }

        System.out.println("Результат: " + result.toString());
    }

    public static void task6() {
        // Задача 6: Анаграммы (не учитывая регистр)
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите первую строку: ");
        String s1 = scanner.nextLine().toLowerCase().replaceAll("\\s+", "");

        System.out.print("Введите вторую строку: ");
        String s2 = scanner.nextLine().toLowerCase().replaceAll("\\s+", "");

        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();

        java.util.Arrays.sort(arr1);
        java.util.Arrays.sort(arr2);

        if (java.util.Arrays.equals(arr1, arr2)) {
            System.out.println("Строки — анаграммы");
        } else {
            System.out.println("Строки — не анаграммы");
        }
    }

    public static void task7() {
        // Задача 7: Первая буква каждого слова заглавная, остальные маленькие
        String s = "съешь еЩё этих мЯгких фраНцузских бУлок, Да выпей же чаю";

        String[] words = s.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.isEmpty()) {
                continue;
            }
            String capitalized = word.substring(0, 1).toUpperCase() +
                    word.substring(1).toLowerCase();
            result.append(capitalized);
            if (i < words.length - 1) {
                result.append(" ");
            }
        }

        System.out.println("Результат: " + result.toString());
    }

    public static void task8() {
        // Задача 8: Сжать строку: "aaaaabbc" → "a5b2c1"
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите строку: ");
        String s = scanner.nextLine();

        if (s.isEmpty()) {
            System.out.println("Результат: \"\"");
            return;
        }

        StringBuilder result = new StringBuilder();
        char current = s.charAt(0);
        int count = 1;

        for (int i = 1; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == current) {
                count++;
            } else {
                result.append(current).append(count);
                current = ch;
                count = 1;
            }
        }
        result.append(current).append(count);

        System.out.println("Результат: " + result.toString());
    }

    public static void main(String[] args) {

        task1();
        task2();
        task3();
        task4();
        task5();
        task6();
        task7();
        task8();
    }
}