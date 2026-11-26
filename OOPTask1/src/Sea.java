import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Sea {
    private final int SIZE = 5;
    private char[][] viewBoard = new char[SIZE][SIZE]; // Поле для отображения игроку
    private int[][] shipIdBoard = new int[SIZE][SIZE]; // 0 - пусто, 1..3 - ID кораблей
    private List<int[]>[] ships = new ArrayList[4];    // Координаты палуб каждого корабля
    private int shotsCount = 0;
    private int shipsRemaining = 3;
    private Random random = new Random();

    public Sea() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                viewBoard[i][j] = '.';
                shipIdBoard[i][j] = 0;
            }
        }
        for (int i = 1; i <= 3; i++) {
            ships[i] = new ArrayList<>();
        }
        placeAllShips();
    }

    private void placeAllShips() {
        // Размещаем два двухпалубных (ID 1 и 2) и один однопалубный (ID 3)
        placeShip(1, 2);
        placeShip(2, 2);
        placeShip(3, 1);
    }

    private void placeShip(int shipId, int length) {
        while (true) {
            boolean horizontal = random.nextBoolean();
            int r = random.nextInt(SIZE);
            int c = random.nextInt(SIZE);

            if (canPlace(r, c, length, horizontal)) {
                for (int i = 0; i < length; i++) {
                    int nr = horizontal ? r : r + i;
                    int nc = horizontal ? c + i : c;
                    shipIdBoard[nr][nc] = shipId;
                    ships[shipId].add(new int[]{nr, nc});
                }
                break;
            }
        }
    }

    private boolean canPlace(int r, int c, int length, boolean horizontal) {
        for (int i = 0; i < length; i++) {
            int nr = horizontal ? r : r + i;
            int nc = horizontal ? c + i : c;

            if (nr >= SIZE || nc >= SIZE) return false;

            // Проверяем саму клетку и всех соседей вокруг (чтобы корабли не слипались)
            for (int dr = -1; dr <= 1; dr++) {
                for (int dc = -1; dc <= 1; dc++) {
                    int checkR = nr + dr;
                    int checkC = nc + dc;
                    if (checkR >= 0 && checkR < SIZE && checkC >= 0 && checkC < SIZE) {
                        if (shipIdBoard[checkR][checkC] != 0) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public void play(Scanner in) {
        System.out.println("\n=== МОРСКОЙ БОЙ (5x5) ===");
        System.out.println("Компьютер спрятал 3 корабля (один 1-палубный и два 2-палубных).");
        System.out.println("Формат ввода координат: 2А или А2 (буквы А-Д, цифры 1-5).");

        printBoard();

        while (shipsRemaining > 0) {
            System.out.print("Ваш выстрел: ");
            String input = in.nextLine().trim().toUpperCase();

            int[] coords = parseCoords(input);
            if (coords == null) {
                System.out.println("Некорректные координаты! Используйте буквы А, Б, В, Г, Д и цифры 1-5 (например: 2А).");
                continue;
            }

            int r = coords[0];
            int c = coords[1];

            if (viewBoard[r][c] != '.') {
                System.out.println("Вы уже стреляли в эту клетку! Выберите другую.");
                continue;
            }

            shotsCount++;
            int hitShipId = shipIdBoard[r][c];

            if (hitShipId == 0) {
                viewBoard[r][c] = '#';
                System.out.println("мимо");
            } else {
                viewBoard[r][c] = '!';
                System.out.println("попал");

                if (isShipDestroyed(hitShipId)) {
                    for (int[] cell : ships[hitShipId]) {
                        viewBoard[cell[0]][cell[1]] = 'V';
                    }
                    shipsRemaining--;
                    System.out.println("Корабль уничтожен!");
                }
            }

            printBoard();
        }

        System.out.println("Победа! Все корабли уничтожены!");
        System.out.println("Количество выстрелов: " + shotsCount);
    }

    private boolean isShipDestroyed(int shipId) {
        for (int[] cell : ships[shipId]) {
            if (viewBoard[cell[0]][cell[1]] != '!' && viewBoard[cell[0]][cell[1]] != 'V') {
                return false;
            }
        }
        return true;
    }

    private int[] parseCoords(String input) {
        if (input.length() != 2) return null;

        char ch1 = input.charAt(0);
        char ch2 = input.charAt(1);

        int row = -1;
        int col = -1;

        if (Character.isDigit(ch1) && Character.isLetter(ch2)) {
            col = ch1 - '1';
            row = letterToRow(ch2);
        } else if (Character.isLetter(ch1) && Character.isDigit(ch2)) {
            row = letterToRow(ch1);
            col = ch2 - '1';
        }

        if (row >= 0 && row < SIZE && col >= 0 && col < SIZE) {
            return new int[]{row, col};
        }
        return null;
    }

    private int letterToRow(char ch) {
        // Поддержка и русских букв (А-Д), и похожих латинских на случай раскладки (A, B, C, D, E)
        switch (ch) {
            case 'А': case 'A': return 0;
            case 'Б': case 'B': return 1;
            case 'В': case 'C': return 2;
            case 'Г': case 'D': return 3;
            case 'Д': case 'E': return 4;
            default: return -1;
        }
    }

    private void printBoard() {
        char[] rowLetters = {'А', 'Б', 'В', 'Г', 'Д'};
        System.out.println("\n  1 2 3 4 5");
        for (int i = 0; i < SIZE; i++) {
            System.out.print(rowLetters[i] + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(viewBoard[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
