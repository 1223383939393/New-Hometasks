
import java.util.Scanner;

public class Main {

    public static void task1() {

        Scanner in = new Scanner(System.in);
        String correctPassword = "a2s3d4";

        System.out.print("Введите пароль: ");
        String input = in.nextLine();

        if (input.equals(correctPassword)) {
            System.out.println("Пароль верный");
        } else {
            System.out.println("Пароль неверный");
        }
    }

    public static void task2() {

        Scanner in = new Scanner(System.in);

        System.out.print("Введите строку: ");
        String s = in.nextLine();

        int length = s.length();
        char first = s.charAt(0);
        char last = s.charAt(length - 1);

        System.out.println("Длина строки: " + length);
        System.out.println("Первый символ: " + first);
        System.out.println("Последний символ: " + last);
    }

    public static void task3() {

        Scanner in = new Scanner(System.in);

        System.out.print("Введите строку: ");
        String s = in.nextLine();

        System.out.println("Верхний регистр: " + s.toUpperCase());
        System.out.println("Нижний регистр: " + s.toLowerCase());
    }

    public static void task4() {

        Scanner in = new Scanner(System.in);

        System.out.print("Введите строку: ");
        String s = in.nextLine();

        String trimmed = s.trim();

        System.out.println("[" + trimmed + "]");
    }

    public static void task5() {

        Scanner in = new Scanner(System.in);

        System.out.print("Введите строку: ");
        String s = in.nextLine().toLowerCase();

        String vowelsRu = "аеёиоуыэюя";
        String vowelsEn = "aeiou";
        String vowels = vowelsRu + vowelsEn;

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (vowels.indexOf(ch) >= 0) {
                count++;
            }
        }

        System.out.println("Количество гласных: " + count);
    }

    public static void main(String[] args) {

        task1();
        task2();
        task3();
        task4();
        task5();
    }
}