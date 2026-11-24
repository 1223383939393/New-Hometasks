import mylibrary.ArrayUtils;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = { };
        try {
            System.out.println("ввод первого массива");
            int us = in.nextInt();
            int[] arrTask = new int[us];
            for(int i = 0; i < arrTask.length; i++) {
                arrTask[i] = in.nextInt();
            }
            System.out.println("суммма");
            System.out.println(ArrayUtils.sum(arrTask));

            System.out.println("среднее");
            System.out.println(ArrayUtils.average(arrTask));

            System.out.println("максимальное");
            System.out.println(ArrayUtils.max(arrTask));

            System.out.println("минимальное");
            System.out.println(ArrayUtils.min(arrTask));

            System.out.println("обратный массив");
            ArrayUtils.print(ArrayUtils.reverse(arrTask));

            System.out.println("проверка на наличие числа в массиве");
            int value = in.nextInt();
            System.out.println(ArrayUtils.contains(arrTask, value));

            System.out.println("счетчик четных");
            System.out.println(ArrayUtils.countEven(arrTask));

            System.out.println("дубликат");
            ArrayUtils.print(ArrayUtils.copy(arrTask));

            System.out.println("ввод второго массива");
            int user = in.nextInt();
            int[] arrTask2 = new int[us];
            for(int i = 0; i < arrTask2.length; i++) {
                arrTask2[i] = in.nextInt();
            }

            System.out.println("объединение массива");
            ArrayUtils.print(ArrayUtils.merge(arrTask, arrTask2));

            System.out.println("вывод изначального массива");
            ArrayUtils.print(arrTask);
        }
        catch (Exception e) {
            System.out.print(e);
        }

    }
}