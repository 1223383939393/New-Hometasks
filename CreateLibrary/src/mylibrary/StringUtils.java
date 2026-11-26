package mylibrary;

import java.util.Arrays;

public class StringUtils {

    public static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    public static boolean isPalindrome(String s) {
        String clean = s.replaceAll("[^a-zA-Zа-яА-ЯёЁ0-9]", "").toLowerCase();
        return clean.equals(reverse(clean));
    }

    public static int countVowels(String s) {
        String vowels = "aeiouyаеёиоуыэюяAEIOUYАЕЁИОУЫЭЮЯ";
        int count = 0;
        for (char c : s.toCharArray()) {
            if (vowels.indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }

    public static int countWords(String s) {
        String trimmed = s.trim();
        if (trimmed.isEmpty()) return 0;
        return trimmed.split("\\s+").length;
    }

    public static String capitalize(String s) {
        if (s == null || s.isEmpty()) return s;
        return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
    }

    public static String truncate(String s, int max) {
        if (s.length() > max) {
            return s.substring(0, max);
        } else if (s.length() < max) {
            StringBuilder sb = new StringBuilder(s);
            while (sb.length() < max) {
                sb.append(".");
            }
            return sb.toString();
        }
        return s;
    }

    public static String removeSpaces(String s) {
        return s.replace(" ", "");
    }

    public static boolean isAnagram(String a, String b) {
        String cleanA = a.replaceAll("[^a-zA-Zа-яА-ЯёЁ0-9]", "").toLowerCase();
        String cleanB = b.replaceAll("[^a-zA-Zа-яА-ЯёЁ0-9]", "").toLowerCase();
        if (cleanA.length() != cleanB.length()) return false;
        char[] arrA = cleanA.toCharArray();
        char[] arrB = cleanB.toCharArray();
        Arrays.sort(arrA);
        Arrays.sort(arrB);
        return Arrays.equals(arrA, arrB);
    }

    public static String repeat(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(s);
        }
        return sb.toString();
    }
}
