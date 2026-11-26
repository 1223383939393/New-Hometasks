import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите время обслуживания X и длительность симуляции N: ");
        int x = in.nextInt();
        int n = in.nextInt();

        Queue<String> queue = new ArrayDeque<>();
        int timeLeft = 0;
        int served = 0;

        for (int minute = 1; minute <= n; minute++) {
            String newCustomer = "П" + minute;
            queue.offer(newCustomer);
            System.out.println("Минута " + minute + ": пришёл " + newCustomer);

            if (timeLeft == 0 && !queue.isEmpty()) {
                String current = queue.poll();
                System.out.println("Минута " + minute + ": обслуживается " + current);
                timeLeft = x;
                served++;
            }

            if (timeLeft > 0) {
                timeLeft--;
            }
        }

        System.out.println("Обслужено: " + served);
        System.out.println("Осталось в очереди: " + queue.size());
    }
}
