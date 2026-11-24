import java.util.Random;

public class Numbers {
    Random random = new Random();
    private int randNum = random.nextInt(1, 101);
    private int count = 0;
    private boolean checkin = false;

    public boolean check(int j) {
        int diff = Math.abs(randNum - j);
        count++;
        if (diff == 0) {
            checkin = true;
            System.out.println("Ура победа");
            System.out.println("Количество попыток: " + count);
            return checkin;
        } else if (diff <= 5) {
            System.out.println("горячо");

            return checkin;
        } else if (diff <= 10) {
            System.out.println("тепло");

            return checkin;
        }
        else {
            System.out.println("холодно");

            return checkin;
        }

    }
}
