import java.io.*;
import java.util.*;

public class Sea {
    private static final int SIZE = 5;
    private static final String FILE_NAME = "sea_score.txt";
    private final Random random = new Random();

    // 0 - пусто, 1 - корабль, 2 - мимо (#), 3 - ранен (!), 4 - убит (V)
    private int[][] playerBoard = new int[SIZE][SIZE];
    private int[][] botBoard = new int[SIZE][SIZE];
    private List<List<int[]>> playerShips = new ArrayList<>();
    private List<List<int[]>> botShips = new ArrayList<>();

    public void start(Scanner in) {
        System.out.println("=== МОРСКОЙ БОЙ 2.0 ===");
        showScore();

        placeBotShips();
        placePlayerShips(in);

        int playerShots = 0;
        while (true) {
            printBoards();

            // Ход игрока
            System.out.print("Ваш выстрел (например, 2А): ");
            int[] shot = parseCoord(in.nextLine());
            if (shot == null) {
                System.out.println("Неверные координаты! Используйте цифры 1-5 и буквы А-Д.");
                continue;
            }
            int r = shot[0], c = shot[1];
            if (botBoard[r][c] >= 2) {
                System.out.println("Вы уже стреляли в эту клетку!");
                continue;
            }

            playerShots++;
            processShot(botBoard, botShips, r, c, "Вы");
            if (allDestroyed(botShips)) {
                printBoards();
                System.out.println("ПОБЕДА! Вы уничтожили все корабли компьютера за " + playerShots + " выстрелов!");
                saveScore("Победа игрока (выстрелов: " + playerShots + ")");
                break;
            }

            // Ход компьютера
            int br, bc;
            do {
                br = random.nextInt(SIZE);
                bc = random.nextInt(SIZE);
            } while (playerBoard[br][bc] >= 2);

            char rowLetter = "АБВГД".charAt(br);
            System.out.println("Компьютер стреляет в " + (bc + 1) + rowLetter + ":");
            processShot(playerBoard, playerShips, br, bc, "Компьютер");

            if (allDestroyed(playerShips)) {
                printBoards();
                System.out.println("ПОРАЖЕНИЕ! Компьютер уничтожил ваш флот.");
                saveScore("Победа компьютера");
                break;
            }
        }

        System.out.println("\nОбновлённый счёт:");
        showScore();
    }

    private void placePlayerShips(Scanner in) {
        System.out.println("Расставьте свои корабли (правило: между кораблями минимум 1 клетка, даже по диагонали).");
        int[] sizes = {1, 2, 2};
        for (int s : sizes) {
            while (true) {
                printBoards();
                if (s == 1) {
                    System.out.print("Введите координату однопалубного корабля (например, 1А): ");
                    int[] p = parseCoord(in.nextLine());
                    if (p != null && canPlace(playerBoard, List.of(p))) {
                        List<int[]> ship = List.of(p);
                        playerBoard[p[0]][p[1]] = 1;
                        playerShips.add(ship);
                        break;
                    }
                } else {
                    System.out.print("Введите 2 соседние координаты для двухпалубного корабля через пробел (например, 3Б 3В): ");
                    String[] parts = in.nextLine().trim().split("\\s+");
                    if (parts.length == 2) {
                        int[] p1 = parseCoord(parts[0]);
                        int[] p2 = parseCoord(parts[1]);
                        if (p1 != null && p2 != null && isAdjacent(p1, p2) && canPlace(playerBoard, List.of(p1, p2))) {
                            List<int[]> ship = List.of(p1, p2);
                            playerBoard[p1[0]][p1[1]] = 1;
                            playerBoard[p2[0]][p2[1]] = 1;
                            playerShips.add(ship);
                            break;
                        }
                    }
                }
                System.out.println("Нельзя поставить корабль сюда! Проверьте формат и расстояние до других кораблей.");
            }
        }
    }

    private void placeBotShips() {
        int[] sizes = {1, 2, 2};
        for (int s : sizes) {
            while (true) {
                int r = random.nextInt(SIZE);
                int c = random.nextInt(SIZE);
                List<int[]> cells = new ArrayList<>();
                cells.add(new int[]{r, c});
                if (s == 2) {
                    boolean horiz = random.nextBoolean();
                    int nr = horiz ? r : r + 1;
                    int nc = horiz ? c + 1 : c;
                    if (nr >= SIZE || nc >= SIZE) continue;
                    cells.add(new int[]{nr, nc});
                }
                if (canPlace(botBoard, cells)) {
                    for (int[] cell : cells) {
                        botBoard[cell[0]][cell[1]] = 1;
                    }
                    botShips.add(cells);
                    break;
                }
            }
        }
    }

    private boolean canPlace(int[][] board, List<int[]> cells) {
        for (int[] cell : cells) {
            int r = cell[0], c = cell[1];
            for (int dr = -1; dr <= 1; dr++) {
                for (int dc = -1; dc <= 1; dc++) {
                    int nr = r + dr, nc = c + dc;
                    if (nr >= 0 && nr < SIZE && nc >= 0 && nc < SIZE) {
                        if (board[nr][nc] == 1) return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean isAdjacent(int[] p1, int[] p2) {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]) == 1;
    }

    private void processShot(int[][] board, List<List<int[]>> ships, int r, int c, String who) {
        if (board[r][c] == 1) {
            board[r][c] = 3;
            for (List<int[]> ship : ships) {
                boolean belongs = false;
                boolean sunk = true;
                for (int[] cell : ship) {
                    if (cell[0] == r && cell[1] == c) belongs = true;
                    if (board[cell[0]][cell[1]] != 3) sunk = false;
                }
                if (belongs) {
                    if (sunk) {
                        for (int[] cell : ship) board[cell[0]][cell[1]] = 4;
                        System.out.println(who + ": УНИЧТОЖИЛ (V)!");
                    } else {
                        System.out.println(who + ": ПОПАЛ (!)!");
                    }
                    return;
                }
            }
        } else {
            board[r][c] = 2;
            System.out.println(who + ": мимо (#).");
        }
    }

    private boolean allDestroyed(List<List<int[]>> ships) {
        int totalDecks = 0;
        for (List<int[]> s : ships) totalDecks += s.size();
        int destroyedDecks = 0;
        int[][] targetBoard = (ships == botShips) ? botBoard : playerBoard;
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                if (targetBoard[r][c] == 4) destroyedDecks++;
            }
        }
        return destroyedDecks == totalDecks;
    }

    private void printBoards() {
        String letters = "АБВГД";
        System.out.println("\n   ВАШЕ ПОЛЕ           ПОЛЕ КОМПЬЮТЕРА");
        System.out.println("  1 2 3 4 5             1 2 3 4 5");
        for (int r = 0; r < SIZE; r++) {
            System.out.print(letters.charAt(r) + " ");
            for (int c = 0; c < SIZE; c++) {
                System.out.print(symbol(playerBoard[r][c], true) + " ");
            }
            System.out.print("          " + letters.charAt(r) + " ");
            for (int c = 0; c < SIZE; c++) {
                System.out.print(symbol(botBoard[r][c], false) + " ");
            }
            System.out.println();
        }
    }

    private char symbol(int val, boolean showShips) {
        return switch (val) {
            case 1 -> showShips ? 'К' : '.';
            case 2 -> '#';
            case 3 -> '!';
            case 4 -> 'V';
            default -> '.';
        };
    }

    private int[] parseCoord(String input) {
        if (input == null) return null;
        String s = input.trim().toUpperCase();
        if (s.length() != 2) return null;
        char c1 = s.charAt(0), c2 = s.charAt(1);
        int col = -1, row = -1;
        String letters = "АБВГД";
        String engLetters = "ABVGD";

        if (Character.isDigit(c1)) {
            col = c1 - '1';
            row = Math.max(letters.indexOf(c2), engLetters.indexOf(c2));
        } else if (Character.isDigit(c2)) {
            col = c2 - '1';
            row = Math.max(letters.indexOf(c1), engLetters.indexOf(c1));
        }
        if (row >= 0 && row < SIZE && col >= 0 && col < SIZE) {
            return new int[]{row, col};
        }
        return null;
    }

    private void saveScore(String result) {
        try (FileWriter fw = new FileWriter(FILE_NAME, true)) {
            fw.write(result + "\n");
        } catch (IOException e) {
            System.out.println("Ошибка записи счёта: " + e.getMessage());
        }
    }

    private void showScore() {
        File file = new File(FILE_NAME);
        if (!file.exists() || file.length() == 0) {
            System.out.println("История игр: счет пуст.");
            return;
        }
        System.out.println("--- История сыгранных игр ---");
        try (Scanner fileScanner = new Scanner(file)) {
            int gameNum = 1;
            while (fileScanner.hasNextLine()) {
                System.out.println(gameNum++ + ". " + fileScanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("История игр: счет пуст.");
        }
        System.out.println("-----------------------------");
    }
}
