import java.util.Scanner;

void main() {
    Scanner in = new Scanner(System.in);
    while (true) {
        System.out.println("============================");
        System.out.println("Выберите игру:");
        System.out.println("1. Угадай число");
        System.out.println("2. Камень-ножницы-бумага");
        System.out.println("3. Морской бой");
        System.out.println("0. Выход");
        System.out.println("============================");
        try {
            int gameInp = in.nextInt();
            in.nextLine(); // очистка буфера после ввода числа

            switch (gameInp) {
                case 1: {
                    Numbers num = new Numbers();
                    while (true) {
                        System.out.println("Введите число:");
                        try {
                            int user = in.nextInt();
                            in.nextLine();
                            boolean win = num.check(user);
                            if (win) {
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
                    RPS rps = new RPS();
                    rps.start(in);
                    break;
                }
                case 3: {
                    Sea sea = new Sea();
                    sea.start(in);
                    break;
                }
                case 0: {
                    System.out.println("Выход из программы...");
                    return;
                }
                default:
                    System.out.println("Введи норм число");
            }
        } catch (Exception e) {
            System.out.println("Не то ввел");
            in.nextLine(); // чтобы не ушло в бесконечный цикл при вводе букв
        }
    }
}
