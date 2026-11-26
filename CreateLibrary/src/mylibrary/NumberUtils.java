package mylibrary;

public class NumberUtils {

    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static int lcm(int a, int b) {
        if (a == 0 || b == 0) return 0;
        return Math.abs(a * b) / gcd(a, b);
    }

    public static long factorial(int n) {
        if (n < 0) throw new IllegalArgumentException("Число должно быть >= 0");
        long res = 1;
        for (int i = 2; i <= n; i++) {
            res *= i;
        }
        return res;
    }

    public static int sumDigits(int n) {
        n = Math.abs(n);
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public static int countDigits(int n) {
        if (n == 0) return 1;
        n = Math.abs(n);
        int count = 0;
        while (n > 0) {
            count++;
            n /= 10;
        }
        return count;
    }

    public static int reverseNumber(int n) {
        int sign = n < 0 ? -1 : 1;
        n = Math.abs(n);
        int reversed = 0;
        while (n > 0) {
            reversed = reversed * 10 + n % 10;
            n /= 10;
        }
        return reversed * sign;
    }

    public static boolean isArmstrong(int n) {
        if (n < 0) return false;
        int original = n;
        int digits = countDigits(n);
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += Math.pow(digit, digits);
            n /= 10;
        }
        return sum == original;
    }

    public static String toBinary(int n) {
        if (n == 0) return "0";
        StringBuilder sb = new StringBuilder();
        int num = Math.abs(n);
        while (num > 0) {
            sb.append(num % 2);
            num /= 2;
        }
        if (n < 0) sb.append("-");
        return sb.reverse().toString();
    }
}
