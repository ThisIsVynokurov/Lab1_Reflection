package Task1;

import javax.swing.*;
import java.awt.*;

import static Task1.Task1.*;

public class GUIforTask1 {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Аналізатор класу");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        JTextField enterClassName = new JTextField(30);
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Введіть повне ім'я класу:"));
        inputPanel.add(enterClassName);

        JTextArea getResult = new JTextArea();
        getResult.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(getResult);

        JPanel buttonsPanel = new JPanel();

        JButton analyzeBtn = new JButton("Аналіз");
        analyzeBtn.addActionListener(e -> {
            String className = enterClassName.getText();
            String result = analyzeClass(className);
            getResult.setText(result);
        });

        JButton clearAllBtn = new JButton("Очистити");
        clearAllBtn.addActionListener(e -> {
            enterClassName.setText("");
            getResult.setText("");
        });

        JButton completeBtn = new JButton("Завершити");
        completeBtn.addActionListener(e -> System.exit(0));

        buttonsPanel.add(analyzeBtn);
        buttonsPanel.add(clearAllBtn);
        buttonsPanel.add(completeBtn);

        frame.getContentPane().add(inputPanel, BorderLayout.NORTH);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        frame.getContentPane().add(buttonsPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}