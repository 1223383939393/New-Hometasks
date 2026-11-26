import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Numbers {
    private int randNum;
    private int[] ranArr = new int[4];
    private boolean state = false;

    public Numbers() {
        // Генерируем 4-значное число с неповторяющимися цифрами
        List<Integer> digits = new ArrayList<>();
        for (int i = 0; i <= 9; i++) {
            digits.add(i);
        }
        Collections.shuffle(digits);
        if (digits.get(0) == 0) {
            Collections.swap(digits, 0, 1); // первая цифра не 0
        }
        for (int i = 0; i < 4; i++) {
            ranArr[i] = digits.get(i);
        }
        randNum = ranArr[0] * 1000 + ranArr[1] * 100 + ranArr[2] * 10 + ranArr[3];
    }

    public boolean check(int j) {
        if (j < 1000 || j > 9999) {
            System.out.println("Введите строго 4-значное число!");
            return false;
        }

        // Разбиваем по порядку слева направо
        int[] inpArr = {
            j / 1000,
            (j / 100) % 10,
            (j / 10) % 10,
            j % 10
        };

        if (j == randNum) {
            state = true;
            System.out.println("Угадал число: " + randNum);
            return state;
        } else {
            System.out.println("Догадка: " + j);
            System.out.print("Угадал: ");
            for (int i = 0; i < inpArr.length; i++) {
                if (inpArr[i] == ranArr[i]) {
                    System.out.print(inpArr[i]);
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();

            System.out.print("Числа есть, но не на своем месте: ");
            List<Integer> almost = new ArrayList<>();
            for (int i = 0; i < inpArr.length; i++) {
                if (inpArr[i] == ranArr[i]) continue;
                for (int k = 0; k < ranArr.length; k++) {
                    if (i != k && inpArr[i] == ranArr[k] && !almost.contains(inpArr[i])) {
                        almost.add(inpArr[i]);
                    }
                }
            }
            if (almost.isEmpty()) {
                System.out.println("нет.");
            } else {
                for (int i = 0; i < almost.size(); i++) {
                    System.out.print(almost.get(i) + (i < almost.size() - 1 ? ", " : ".\n"));
                }
            }
        }
        return state;
    }
}
