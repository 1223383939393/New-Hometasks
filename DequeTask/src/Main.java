import java.util.Deque;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

Scanner in = new Scanner(System.in);

void main() {
    task1();
    task2();
    task3();
}

void task1() {
    try {
        System.out.println("=== Задача 1: Палиндром ===");
        System.out.println("Введите строку:");
        String userInp = in.nextLine().toLowerCase().replace(" ", "");

        Deque<Character> deque = new ArrayDeque<>();
        for (char c : userInp.toCharArray()) {
            deque.offerLast(c);
        }

        boolean isPalindrome = true;
        while (deque.size() > 1) {
            if (!deque.pollFirst().equals(deque.pollLast())) {
                isPalindrome = false;
                break;
            }
        }

        System.out.println(isPalindrome);
    } catch (Exception e) {
        System.out.println(e.toString());
    }
}

void task2() {
    try {
        System.out.println("\n=== Задача 2: Переворот первых K элементов ===");
        System.out.println("Введите количество элементов очереди:");
        int n = in.nextInt();

        Deque<Integer> queue = new ArrayDeque<>();
        System.out.println("Введите элементы очереди:");
        for (int i = 0; i < n; i++) {
            queue.offerLast(in.nextInt());
        }

        System.out.println("Введите K:");
        int k = in.nextInt();

        if (k < 0 || k > n) {
            System.out.println("Некорректное значение K");
            return;
        }

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            stack.push(queue.pollFirst());
        }

        while (!stack.isEmpty()) {
            queue.offerLast(stack.pop());
        }

        for (int i = 0; i < n - k; i++) {
            queue.offerLast(queue.pollFirst());
        }

        System.out.println("Результат: " + queue);
    } catch (Exception e) {
        System.out.println(e.toString());
    }
}

void task3() {
    try {
        System.out.println("\n=== Задача 3: Разница max и min в окне ===");
        System.out.println("Введите количество элементов:");
        int n = in.nextInt();

        int[] arr = new int[n];
        System.out.println("Введите элементы:");
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        System.out.println("Введите размер окна K:");
        int k = in.nextInt();

        Deque<Integer> maxDeque = new ArrayDeque<>();
        Deque<Integer> minDeque = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            while (!maxDeque.isEmpty() && maxDeque.peekFirst() < i - k + 1) {
                maxDeque.pollFirst();
            }
            while (!minDeque.isEmpty() && minDeque.peekFirst() < i - k + 1) {
                minDeque.pollFirst();
            }

            while (!maxDeque.isEmpty() && arr[maxDeque.peekLast()] <= arr[i]) {
                maxDeque.pollLast();
            }
            while (!minDeque.isEmpty() && arr[minDeque.peekLast()] >= arr[i]) {
                minDeque.pollLast();
            }

            maxDeque.offerLast(i);
            minDeque.offerLast(i);

            if (i >= k - 1) {
                int diff = arr[maxDeque.peekFirst()] - arr[minDeque.peekFirst()];
                result.add(diff);
            }
        }

        System.out.println("Ответ: " + result);
    } catch (Exception e) {
        System.out.println(e.toString());
    }
}
