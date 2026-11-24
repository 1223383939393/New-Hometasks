import java.util.Random;

public class Numbers {
    Random random = new Random();
    private int randNum = random.nextInt(1000, 10000);
    private boolean state = false;

    public boolean check(int j) {
        int num1 = j % 10;
        int num2 = j / 10;
        int num3 = num2 % 10;
        int num4 = num2 / 10;
        int num5 = num4 % 10;
        int num6 = num4 / 10;
        int[] inpArr = {num1, num3, num5, num6};

        int tan1 = randNum % 10;
        int tan2 = randNum / 10;
        int tan3 = tan2 % 10;
        int tan4 = tan2 / 10;
        int tan5 = tan4 % 10;
        int tan6 = tan4 /10;
        int[] ranArr = {tan1, tan3, tan5, tan6};

        if(j == randNum) {
            state = true;
            System.out.println("Угадал число: " + randNum);
            return state;
        }
        else {
            System.out.println("Догадка: " + j);
            System.out.print("Угадал: ");
            for(int i = 0; i < inpArr.length; i++) {
                if(inpArr[i] == ranArr[i]) {
                    System.out.print(inpArr[i]);
                }
                else {
                    System.out.print("*");
                }
            }
            System.out.println();
            System.out.print("Числа есть, но не на своем месте: ");
            for(int i = 0; i < inpArr.length; i++) {
                for(int k = 0; k < ranArr.length; k++) {
                    if (inpArr[i] == ranArr[j]) {
                        if(i == j) {
                            continue;
                        }
                        else{
                            System.out.print(inpArr[i] + " ");
                        }
                    }
                }
            }
            System.out.println();
        }
        return state;
    }
}
