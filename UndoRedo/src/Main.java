import java.util.Scanner;
import java.util.Stack;

Scanner in = new Scanner(System.in);
Stack<String> history = new Stack<>();
Stack<String> undoList = new Stack<>();

void doAction(String action) {
    history.push(action);
    undoList.clear();
}

void undo() {
    if(!history.isEmpty()) {
        String event = history.pop();
        undoList.push(event);
    }
    else {
        System.out.println("Пусто");
    }
}

void redo() {
    if(!history.isEmpty()) {
        String event = undoList.pop();
        history.push(event);
    }
    else {
        System.out.println("Пусто");
    }
}
void print() {
    for(String action : history) {
        System.out.println(action);
    }
}

void main() {
    while(true) {
        System.out.println("1-ввод\n2-отмена\n3-вернуть отмененное действие\n4-вывод");

        System.out.println("Введите действие");

        int user = in.nextInt();
        in.nextLine();
        switch (user) {
            case 0: {
                return;
            }
            case 1: {
                System.out.println("Введите буквы");
                String inp = in.nextLine();
                doAction(inp);
                break;
            }
            case 2: {
                System.out.println("отменяем последнее действие");
                undo();
                break;
            }
            case 3: {
                System.out.println("возвращаем последнее действие");
                redo();
                break;
            }
            case 4: {
                System.out.println("выводим все действия");
                print();
                break;
            }
            default: {
                System.out.println("неправильный ввод");
                break;
            }
        }
    }
}


