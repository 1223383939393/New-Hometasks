import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class RPS {
    private final String FILE_NAME = "rps_score.txt";
    private Random random = new Random();

    public void startMenu(Scanner in) {
        while (true) {
            System.out.println("\n--- Камень-ножницы-бумага ---");
            System.out.println("1. Играть");
            System.out.println("2. Счет");
            System.out.println("0. Назад в главное меню");
            System.out.print("Ваш выбор: ");

            String choice = in.nextLine().trim();
            switch (choice) {
                case "1":
                    playRoundMatch(in);
                    break;
                case "2":
                    showScores();
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Неверный ввод! Введите 1, 2 или 0.");
            }
        }
    }

    private void playRoundMatch(Scanner in) {
        int playerWins = 0;
        int compWins = 0;
        String[] options = {"камень", "ножницы", "бумага"};

        System.out.println("\nИгра идет до 3 побед!");

        while (playerWins < 3 && compWins < 3) {
            System.out.println("\nСчет: Игрок " + playerWins + " : " + compWins + " Компьютер");
            System.out.print("Выберите (1 - Камень, 2 - Ножницы, 3 - Бумага): ");
            String input = in.nextLine().trim().toLowerCase();

            int playerChoice = -1;
            if (input.equals("1") || input.equals("камень")) playerChoice = 0;
            else if (input.equals("2") || input.equals("ножницы")) playerChoice = 1;
            else if (input.equals("3") || input.equals("бумага")) playerChoice = 2;

            if (playerChoice == -1) {
                System.out.println("Ошибка ввода! Введите 1, 2, 3 или слово (камень/ножницы/бумага).");
                continue;
            }

            int compChoice = random.nextInt(3);
            System.out.println("Вы выбрали: " + options[playerChoice]);
            System.out.println("Компьютер выбрал: " + options[compChoice]);

            if (playerChoice == compChoice) {
                System.out.println("Ничья в раунде!");
            } else if ((playerChoice == 0 && compChoice == 1) ||
                       (playerChoice == 1 && compChoice == 2) ||
                       (playerChoice == 2 && compChoice == 0)) {
                System.out.println("Вы выиграли раунд!");
                playerWins++;
            } else {
                System.out.println("Компьютер выиграл раунд!");
                compWins++;
            }
        }

        String winner = (playerWins == 3) ? "Игрок" : "Компьютер";
        String resultLine = "Победил: " + winner + " | Итоговый счет (Игрок : Компьютер) -> " + playerWins + " : " + compWins;

        System.out.println("\n===============================");
        System.out.println("ИГРА ОКОНЧЕНА! " + resultLine);
        System.out.println("===============================");

        saveScore(resultLine);
    }

    private void saveScore(String record) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(record);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Не удалось сохранить счет в файл: " + e.getMessage());
        }
    }

    private void showScores() {
        File file = new File(FILE_NAME);
        if (!file.exists() || file.length() == 0) {
            System.out.println("Счет пуст. Сыграйте хотя бы одну игру!");
            return;
        }

        System.out.println("\n=== История сыгранных игр ===");
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            int gameNum = 1;
            boolean hasLines = false;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    System.out.println(gameNum + ". " + line);
                    gameNum++;
                    hasLines = true;
                }
            }
            if (!hasLines) {
                System.out.println("Счет пуст.");
            }
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла счета: " + e.getMessage());
        }
    }
}
