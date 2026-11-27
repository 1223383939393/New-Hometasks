import javax.swing.*; // Импортируем компоненты библиотеки Swing
import java.awt.*; // Импортируем менеджеры расположения из AWT

public class Main {


    void task1() {
        JFrame frame = new JFrame("Задание 1 и Сафаров"); // Создаём главное окно Swing с заголовком
        frame.setSize(400, 300); // Задаём размеры окна в пикселях
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Указываем, что при закрытии окна программа должна завершиться
        frame.setLayout(new FlowLayout()); // Устанавливаем потоковый менеджер расположения элементов
        JLabel label = new JLabel("Текст, который нельзя менять и он слева"); // Создаем текст который нельзя менять
        frame.add(label); // Добавляем его в наше окно
        frame.setLocation(0, 0);
        frame.setVisible(true); // Отображаем окно пользователю
    }
    void task2() {
        JFrame frame = new JFrame("Задание 2 и Сафаров");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JLabel label = new JLabel("Текст, который нельзя менять и он фиолетовый");
        label.setForeground(Color.pink); 

        JTextField textField = new JTextField(13);
        frame.setLocation(900, 500);
        frame.add(label);
        frame.add(textField);
        frame.setLocationRelativeTo(label);
        frame.pack();
        frame.setVisible(true);
    }
    void task3() {
        JFrame frame = new JFrame("Задание 3 и Сафаров");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JTextArea area1 = new JTextArea(5, 7);
        area1.setEditable(false);
        frame.add(area1);

        JTextArea area = new JTextArea(5, 7);
        frame.add(area);

        JButton btn = new JButton("Не нажимай");
        btn.setBackground(Color.ORANGE);
        frame.add(btn);

        JCheckBox check = new JCheckBox("Согласен");
        frame.add(check);

        frame.getContentPane().setBackground(Color.CYAN);
        frame.setBounds(1200, 500, 400, 300);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("Задание 3 и Сафаров");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JTextArea area1 = new JTextArea(5, 7);
        area1.setText("Место для текста в высоту моего имени и в ширину моей фамилии");
        area1.setEditable(false);
        frame.add(area1);

        JTextArea area = new JTextArea(5, 7);
        frame.add(area);

        JButton btn = new JButton("Не нажимай");
        btn.setBackground(Color.ORANGE);
        frame.add(btn);

        JCheckBox check = new JCheckBox("Согласен");
        frame.add(check);

        frame.getContentPane().setBackground(Color.CYAN);
        frame.setBounds(1200, 500, 400, 300);
        frame.setVisible(true);
    }
}

