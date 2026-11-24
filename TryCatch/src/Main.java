import java.util.Scanner;
//
//public class Main {
//    Scanner in = new Scanner(String[] args);
//    public static void main(String[] args) {
//
//    }
//
//}
void main() {
    task6();
}
void task1() {
    Scanner scanner = new Scanner(System.in);
    try {
        System.out.println("ВВЕДИТЕ ОЦЕНКУ");
        int a = scanner.nextInt();
        if(a <= 100 && a >= 90) {
            System.out.println("A");
        } else if (a <= 89 && a >= 80) {
            System.out.println("B");
        } else if (a <= 79 && a >= 70) {
            System.out.println("C");
        }
        else if (a <= 69 && a >= 60) {
            System.out.println("D");
        } else if (a <= 59 && a >= 0) {
            System.out.println("F");
        } else {
            System.out.println("Ошибка числа");
        }

    }
    catch (Exception oi) {
        System.out.println("Ошибка ввода");
    }
}
void task2() {
    Scanner scanner = new Scanner(System.in);
    try {
        System.out.println("ВВЕДИТЕ СТРОКУ");
        String a = scanner.nextLine();
        String c = a.replaceAll("\\d", "");
        char[] ac = c.toCharArray();
        Set<Character> set = new LinkedHashSet<>();
        for (int i = 0; i < ac.length; i++) {
            set.add(ac[i]);
        }
        for (Character lang : set) {
            System.out.print(lang);
        }
    }
    catch (Exception e) {
        System.out.println("Ошибка ввода");
    }
}
void task3() {
    Scanner scanner = new Scanner(System.in);
    try {
        System.out.println("Enter a:");
        double a = scanner.nextDouble();

        System.out.println("Enter b:");
        double b = scanner.nextDouble();

        System.out.println("Enter c:");
        double c = scanner.nextDouble();

        if (a == 0)
        {
            System.out.println("This is not a square equation");
        }
        else
        {
            double D = (b * b) - (4 * a * c);
            System.out.printf("D: %.2f", D);
            System.out.println();

            if (D > 0)
                System.out.println("Two roots");
            else if (D == 0)
                System.out.println("One root");
            else
                System.out.println("No roots");
        }
    }
    catch (Exception e) {
        System.out.println("Ошибка");
    }
    finally {
        System.out.println("Завершено");
    }
}
void task4() {
    String[] a = {"10", "abc", "20", "xyz", "30"};
    for (int i = 0; i < a.length; i++) {
        try {
            Integer.parseInt(a[i]);
        }
        catch (NumberFormatException io) {
            System.out.println("попалась строка");
            a[i] = null;
            continue;
        }
    }
    for (int i = 0; i < a.length; i++) {
        System.out.println(a[i]);
    }
}
void task5() {
    Scanner scanner = new Scanner(System.in);
    while(true) {
        try {
            System.out.println("Enter first number:");
            double num1 = scanner.nextDouble();
            scanner.nextLine();

            System.out.println("Enter second number:");
            double num2 = scanner.nextDouble();
            scanner.nextLine();

            System.out.println("Enter operation (+, -, *, /):");
            String r = scanner.nextLine();

            double res = 0;


            switch (r)
            {
                case "+":
                    res = num1 + num2;
                    System.out.println("res: " + res);
                    break;
                case "-":
                    res = num1 - num2;
                    System.out.println("res: " + res);
                    break;
                case "*":
                    res = num1 * num2;
                    System.out.println("res: " + res);
                    break;
                case "/":
                    if (num2 == 0)
                    {
                        System.out.println("Dividing by zero is prohibited");

                    }
                    else
                    {
                        res = num1 / num2;
                        System.out.println("res: " + res);
                    }
                    break;
                default:
                    System.out.println("Wrong operation");
                    break;
            }

        }
        catch (InputMismatchException e) {
            System.out.println("Введено не число! Попробуйте снова.");
            scanner.nextLine(); // Очищаем буфер от неправильного ввода
            continue;
        }
        catch (ArithmeticException a) {
            System.out.println("Деление на ноль");
            continue;
        }
        catch (NumberFormatException n) {
            System.out.println("Введен номер неправильно");
            continue;
        }
        catch (Exception e) {
            System.out.println("ошибка");
            continue;
        }
    }
}
void task6() {
    Scanner scanner = new Scanner(System.in);
    try {
        System.out.println("Enter numbers:");
        String num1 = scanner.nextLine();

        String[] arr = num1.split(" ");
        for (int i = 0; i < arr.length; i++) {
            try {
                Integer.parseInt(arr[i]);
            } catch (NumberFormatException e) {
                throw new NumberFormatException("Элемент '" + arr[i] + "' не является числом");
            }
        }
        System.out.println("Enter index:");
        int num2 = scanner.nextInt();
        System.out.println(arr[num2]);
    }
    catch (NumberFormatException n) {
        System.out.println("введите нормальное число");
    }
    catch (ArrayIndexOutOfBoundsException a) {
        System.out.println("введите нормальный индекс");
    }
}