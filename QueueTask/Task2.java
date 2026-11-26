import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите количество игроков N и счет K: ");
        int n = in.nextInt();
        int k = in.nextInt();

        Queue<String> players = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            players.offer(String.valueOf((char) ('A' + i)));
        }

        while (players.size() > 1) {
            System.out.print("Считаем: ");
            for (int i = 0; i < k - 1; i++) {
                String p = players.poll();
                System.out.print(p + ", ");
                players.offer(p);
            }
            String eliminated = players.poll();
            System.out.println(eliminated + " -> " + eliminated + " выбывает");
            System.out.println("Осталось: " + players);
        }

        System.out.println("Победитель: " + players.peek());
    }
}
