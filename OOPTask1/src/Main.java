import java.util.Scanner;


void main() {
    Scanner in = new Scanner(System.in);
    while (true) {
        System.out.println("============================");
        System.out.println("Выберите игру:");
        System.out.println("1.Угадай число");
        System.out.println("0. Выход");
        System.out.println("============================");
        try {
            int gameInp = in.nextInt();
            switch (gameInp) {
                case 1: {
                    Numbers num = new Numbers();
                    while(true) {

                        System.out.println("Введите число");
                        try {
                            int user = in.nextInt();
                            boolean shi = num.check(user);
                            if(shi) {
                                break;
                            }
                        }
                        catch (Exception e) {
                            System.out.println("Введите число нормально");
                            in.nextLine();
                            continue;
                        }
                    }
                    break;
                }
                case 0: {
                    return;
                }
                default:
                    System.out.println("Введи норм число");
                    in.nextLine();
            }

        }
        catch (Exception e) {
            System.out.println("Не то ввел");
        }
    }
}
