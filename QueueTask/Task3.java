import java.util.ArrayDeque;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Task3 {
    static class Task {
        String name;
        int ticks;

        Task(String name, int ticks) {
            this.name = name;
            this.ticks = ticks;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите количество задач N: ");
        int n = in.nextInt();

        Queue<Task> queue = new ArrayDeque<>();
        Map<String, Integer> finishTimes = new LinkedHashMap<>();

        System.out.println("Введите имя задачи и количество тиков (например: A 3):");
        for (int i = 0; i < n; i++) {
            String name = in.next();
            int ticks = in.nextInt();
            queue.offer(new Task(name, ticks));
            finishTimes.put(name, 0);
        }

        int currentTick = 0;
        while (!queue.isEmpty()) {
            currentTick++;
            Task current = queue.poll();
            current.ticks--;

            if (current.ticks == 0) {
                System.out.println("Тик " + currentTick + ": " + current.name + " -> " + current.name + " завершена");
                finishTimes.put(current.name, currentTick);
            } else {
                System.out.println("Тик " + currentTick + ": " + current.name);
                queue.offer(current);
            }
        }

        System.out.println("\nЗавершение:");
        for (Map.Entry<String, Integer> entry : finishTimes.entrySet()) {
            System.out.println(entry.getKey() + ": тик " + entry.getValue());
        }
    }
}
