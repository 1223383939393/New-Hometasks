import java.util.Scanner;
import java.util.Queue;
import java.util.ArrayDeque;

Scanner in = new Scanner(System.in);
Queue<String> elevatorQueue = new ArrayDeque<>();
int k = in.nextInt();
int n = in.nextInt();
int u = 1;
int c = 0;
boolean elevLeft = false;
void main() {
    while (u < 20) {
        elevatorQueue.offer("П" + u);

        if(elevatorQueue.size() == k && !elevLeft) {

            System.out.printf("Минута %d: \n", u);
            System.out.printf("пришел %s \n", elevatorQueue.peek());
            System.out.println("лифт уехал с " + elevatorQueue);
            while(!elevatorQueue.isEmpty()) {
                elevatorQueue.remove();
            }
            System.out.println("в очереди " + elevatorQueue.size());
            System.out.println();
            elevLeft = true;
            c++;
        }
        else {
            if(elevLeft) {
                c++;
            }
            System.out.printf("Минута %d: пришел %s, в очереди %d", u, elevatorQueue.peek(), elevatorQueue.size());
            System.out.println();
        }
        if (c == n) {
            elevLeft = false;
            c = 0;
        }
        u++;
    }

}
