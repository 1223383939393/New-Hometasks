import java.util.Scanner;

public class TicTacToeProcedural {
    static char[][] board = new char[3][3];
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initBoard();
        char currentPlayer = 'X';
        boolean gameEnded = false;

        while (!gameEnded) {
            printBoard();
            makeMove(currentPlayer);

            if (checkWin(currentPlayer)) {
                printBoard();
                System.out.println("Победил игрок " + currentPlayer + "!");
                gameEnded = true;
            } else if (isBoardFull()) {
                printBoard();
                System.out.println("Ничья!");
                gameEnded = true;
            } else {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }
    }

    static void initBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    static void printBoard() {
        System.out.println("  1 2 3");
        for (int i = 0; i < 3; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void makeMove(char player) {
        while (true) {
            System.out.print("Игрок " + player + ", введите строку (1-3) и столбец (1-3): ");
            if (!scanner.hasNextInt()) {
                System.out.println("Ошибка: введите числа!");
                scanner.next();
                continue;
            }
            int row = scanner.nextInt();

            if (!scanner.hasNextInt()) {
                System.out.println("Ошибка: введите два числа!");
                scanner.next();
                continue;
            }
            int col = scanner.nextInt();

            if (row < 1 || row > 3 || col < 1 || col > 3) {
                System.out.println("Ошибка: координаты должны быть от 1 до 3!");
            } else if (board[row - 1][col - 1] != '-') {
                System.out.println("Ошибка: клетка уже занята!");
            } else {
                board[row - 1][col - 1] = player;
                break;
            }
        }
    }

    static boolean checkWin(char player) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) return true;
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) return true;
        }
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) return true;
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) return true;
        return false;
    }

    static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') return false;
            }
        }
        return true;
    }
}
