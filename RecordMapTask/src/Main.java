import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

void main() {
    Scanner in = new Scanner(System.in);
//   ## ПЕРВОЕ ЗАДАНИЕ
//    record Paint(int x, int y) {}
//    Paint p1 = new Paint(3, 5);
//    Paint p2 = new Paint(4,9);
//
//    System.out.println("X первого " + p1.x);
//    System.out.println("X второго " + p2.x);
//    System.out.println("Y первого " + p1.y);
//    System.out.println("Y второго " + p2.y);
//    System.out.println(p1);
//    System.out.println(p2);

//   ## ВТОРОЕ ЗАДАНИЕ
//    record Student(String name, int age) {}
//
//    Student s1 = new Student("Аня", 20);
//    Student s2 = new Student("Аня", 20);
//    Student s3 = new Student("Иван", 22);
//
//    System.out.println("Первое равно второму? " + s1.equals(s2));
//    System.out.println("Первое равно третьему? " + s1.equals(s3));

    //   ## ТРЕТЬЕ ЗАДАНИЕ
//    record Student(String name, int age) {}
//
//    String[] names = new String[0];
//    int[] ages = new int[0];
//    String a = " ";
//    int b = 0;
//    Byte count = 0;
//
//    while (count != 3) {
//        a = in.nextLine();
//        b = in.nextInt();
//        if (b < 16 && b > 70) {
//            b = in.nextInt();
//        }
//        else {
//            for (int i = 0; i < ages.length; i++) {
//                ages[i] = b;
//            }
//            for (int i = 0; i < names.length; i++) {
//                names[i] = a;
//            }
//        }
//        count++;
//    }
//    for (int i = 0; i < names.length; i++) {
//
//    }
//    System.out.println(s1);
//    System.out.println(s2);
//    System.out.println(s3);
//    System.out.println("Первое равно второму? " + s1.equals(s2));
//    System.out.println("Первое равно третьему? " + s1.equals(s3));

    //   ## ЧЕТВЕРТОЕ ЗАДАНИЕ
//    Map<String, String> Book = new HashMap<>();
//    Book.put("Аня", "+7-999-111-22-33");
//    Book.put("Иван", "+7-999-222-33-44");
//    Book.put("Оля", "+7-999-333-44-55");
//
//    System.out.println(Book);
//    System.out.println(Book.get("Аня"));
//    System.out.println(Book.containsKey("Петя"));
//    System.out.println(Book.size());

    //   ## ПЯТОЕ ЗАДАНИЕ
//    Map<String, String> Book = new HashMap<>();
//    System.out.println("Введите количество");
//    int a = in.nextInt();
//    in.nextLine();
//
//    String name;
//    String num;
//    for (int i = 0; i < a; i++) {
//        System.out.println("Введите имя");
//        name = in.nextLine();
//        System.out.println("Введите номер");
//        num = in.nextLine();
//        Book.put(name, num);
//        System.out.println(i);
//    }
//    System.out.println(Book);
//    System.out.println(Book.get("Аня"));
//    System.out.println(Book.containsKey("Петя"));
//    System.out.println(Book.size());

    //   ## ШЕСТОЕ ЗАДАНИЕ
    Map<String, Integer> Store = new HashMap<>();
    Store.put("Хлеб", 40);
    Store.put("Молоко", 80);
    Store.put("Сыр", 350);
    Store.put("Масло", 200);
    int min = 0;

    for (String key : Store.keySet()) {
        System.out.println(key + " - " + Store.get(key));
    }
    for (Integer val : Store.values()) {

    }
}

