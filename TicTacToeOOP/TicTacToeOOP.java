import java.util.Scanner;

class Player {
    private final String name;
    private final char symbol;

    public Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }
}

class Board {
    private final char[][] grid;
    private static final int SIZE = 3;

    public Board() {
        grid = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                grid[i][j] = '-';
            }
        }
    }

    public boolean placeMark(int row, int col, char symbol) {
        if (row < 1 || row > SIZE || col < 1 || col > SIZE) {
            return false;
        }
        if (grid[row - 1][col - 1] != '-') {
            return false;
        }
        grid[row - 1][col - 1] = symbol;
        return true;
    }

    public boolean checkWin(char symbol) {
        for (int i = 0; i < SIZE; i++) {
            if (grid[i][0] == symbol && grid[i][1] == symbol && grid[i][2] == symbol) return true;
            if (grid[0][i] == symbol && grid[1][i] == symbol && grid[2][i] == symbol) return true;
        }
        return (grid[0][0] == symbol && grid[1][1] == symbol && grid[2][2] == symbol) ||
               (grid[0][2] == symbol && grid[1][1] == symbol && grid[2][0] == symbol);
    }

    public boolean isFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (grid[i][j] == '-') return false;
            }
        }
        return true;
    }

    public void display() {
        System.out.println("  1 2 3");
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}

class Game {
    private final Board board;
    private final Player player1;
    private final Player player2;
    private Player currentPlayer;
    private final Scanner scanner;

    public Game() {
        this.board = new Board();
        this.player1 = new Player("Игрок 1", 'X');
        this.player2 = new Player("Игрок 2", 'O');
        this.currentPlayer = player1;
        this.scanner = new Scanner(System.in);
    }

    public void play() {
        while (true) {
            board.display();
            processTurn();

            if (board.checkWin(currentPlayer.getSymbol())) {
                board.display();
                System.out.println("Победил " + currentPlayer.getName() + " (" + currentPlayer.getSymbol() + ")!");
                break;
            }

            if (board.isFull()) {
                board.display();
                System.out.println("Ничья!");
                break;
            }

            switchPlayer();
        }
    }

    private void processTurn() {
        while (true) {
            System.out.print(currentPlayer.getName() + " (" + currentPlayer.getSymbol() + "), введите строку и столбец (1-3): ");
            if (!scanner.hasNextInt()) {
                System.out.println("Ошибка: нужно ввести число!");
                scanner.next();
                continue;
            }
            int row = scanner.nextInt();

            if (!scanner.hasNextInt()) {
                System.out.println("Ошибка: нужно ввести два числа!");
                scanner.next();
                continue;
            }
            int col = scanner.nextInt();

            if (board.placeMark(row, col, currentPlayer.getSymbol())) {
                break;
            } else {
                System.out.println("Недопустимый ход! Проверьте координаты (1-3) или занятость клетки.");
            }
        }
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }
}

public class TicTacToeOOP {
    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }
}
