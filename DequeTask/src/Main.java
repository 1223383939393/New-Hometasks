import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Scanner;

Scanner in = new Scanner(System.in);
void main() {

}
void task1() {
    try {
        System.out.println("Введите строку");
        String userInp = in.nextLine().toLowerCase().strip();

    } catch (Exception e) {
        System.out.println(e.toString());
    }
}