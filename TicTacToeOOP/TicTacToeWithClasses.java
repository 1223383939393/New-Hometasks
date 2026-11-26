import java.util.Scanner;

class BoardContainer {
    char[][] cells = new char[3][3];
}

class GameLogic {
    BoardContainer board = new BoardContainer();
    Scanner scanner = new Scanner(System.in);
    char currentPlayer = 'X';

    void start() {
        init();
        while (true) {
            print();
            inputMove();
            if (hasWon()) {
                print();
                System.out.println("Победил игрок " + currentPlayer + "!");
                break;
            }
            if (isDraw()) {
                print();
                System.out.println("Ничья!");
                break;
            }
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
    }

    void init() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board.cells[i][j] = '-';
            }
        }
    }

    void print() {
        System.out.println("  1 2 3");
        for (int i = 0; i < 3; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board.cells[i][j] + " ");
            }
            System.out.println();
        }
    }

    void inputMove() {
        while (true) {
            System.out.print("Игрок " + currentPlayer + ", введите строку и столбец (1-3): ");
            if (!scanner.hasNextInt()) {
                System.out.println("Некорректный ввод!");
                scanner.next();
                continue;
            }
            int r = scanner.nextInt();
            if (!scanner.hasNextInt()) {
                System.out.println("Некорректный ввод!");
                scanner.next();
                continue;
            }
            int c = scanner.nextInt();

            if (r >= 1 && r <= 3 && c >= 1 && c <= 3 && board.cells[r - 1][c - 1] == '-') {
                board.cells[r - 1][c - 1] = currentPlayer;
                break;
            }
            System.out.println("Неверные координаты или клетка занята!");
        }
    }

    boolean hasWon() {
        char[][] c = board.cells;
        for (int i = 0; i < 3; i++) {
            if (c[i][0] == currentPlayer && c[i][1] == currentPlayer && c[i][2] == currentPlayer) return true;
            if (c[0][i] == currentPlayer && c[1][i] == currentPlayer && c[2][i] == currentPlayer) return true;
        }
        return (c[0][0] == currentPlayer && c[1][1] == currentPlayer && c[2][2] == currentPlayer) ||
               (c[0][2] == currentPlayer && c[1][1] == currentPlayer && c[2][0] == currentPlayer);
    }

    boolean isDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.cells[i][j] == '-') return false;
            }
        }
        return true;
    }
}

public class TicTacToeWithClasses {
    public static void main(String[] args) {
        GameLogic game = new GameLogic();
        game.start();
    }
}
