import java.util.Scanner;

void main() {
    Scanner in = new Scanner(System.in);
    while (true) {
        System.out.println("============================");
        System.out.println("Выберите игру:");
        System.out.println("1. Угадай число 2.0");
        System.out.println("2. Морской бой 2.0");
        System.out.println("0. Выход");
        System.out.println("============================");
        try {
            int gameInp = in.nextInt();
            in.nextLine(); // очистка буфера

            switch (gameInp) {
                case 1: {
                    Numbers num = new Numbers();
                    while (true) {
                        System.out.println("Введите 4-значное число:");
                        try {
                            int user = in.nextInt();
                            in.nextLine();
                            boolean shi = num.check(user);
                            if (shi) {
                                break;
                            }
                        } catch (Exception e) {
                            System.out.println("Введите число нормально");
                            in.nextLine();
                        }
                    }
                    break;
                }
                case 2: {
                    Sea sea = new Sea();
                    sea.start(in);
                    break;
                }
                case 0: {
                    return;
                }
                default:
                    System.out.println("Введи норм число");
            }
        } catch (Exception e) {
            System.out.println("Не то ввел");
            in.nextLine();
        }
    }
}
