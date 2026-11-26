import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class BlueWaveCalculator extends JFrame implements ActionListener {

    JTextField num1, num2;
    JLabel resultLabel;
    JButton addBtn, subBtn, mulBtn, divBtn, clearBtn;

    Color darkBlue = new Color(20, 55, 105);
    Color blue = new Color(40, 110, 200);
    Color lightBlue = new Color(230, 242, 255);
    Color white = Color.WHITE;

    BlueWaveCalculator() {

        setTitle("BlueWave Calculator");
        setSize(480, 520);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Main Panel
        JPanel mainPanel = new JPanel(new BorderLayout(15, 15));
        mainPanel.setBackground(lightBlue);
        mainPanel.setBorder(
            BorderFactory.createEmptyBorder(20, 25, 20, 25)
        );

        // Header
        JPanel header = new JPanel(new GridLayout(2, 1));
        header.setBackground(darkBlue);

        JLabel title = new JLabel("BlueWave Calculator",
                SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 25));
        title.setForeground(white);

        JLabel subtitle = new JLabel(
                "Simple Calculations, Beautiful Results",
                SwingConstants.CENTER);
        subtitle.setFont(new Font("Arial", Font.PLAIN, 13));
        subtitle.setForeground(white);

        header.add(title);
        header.add(subtitle);

        mainPanel.add(header, BorderLayout.NORTH);

        // Center Panel
        JPanel center = new JPanel(new BorderLayout(12, 15));
        center.setBackground(lightBlue);

        // Number Input Panel
        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 12, 12));
        inputPanel.setBackground(lightBlue);

        JLabel label1 = new JLabel("First Number:");
        JLabel label2 = new JLabel("Second Number:");

        label1.setFont(new Font("Arial", Font.BOLD, 15));
        label2.setFont(new Font("Arial", Font.BOLD, 15));

        num1 = new JTextField();
        num2 = new JTextField();

        styleField(num1);
        styleField(num2);

        inputPanel.add(label1);
        inputPanel.add(num1);
        inputPanel.add(label2);
        inputPanel.add(num2);

        center.add(inputPanel, BorderLayout.NORTH);

        // Operation Buttons
        JPanel buttonPanel = new JPanel(new GridLayout(2, 2, 12, 12));
        buttonPanel.setBackground(lightBlue);

        addBtn = new JButton("Addition (+)");
        subBtn = new JButton("Subtraction (-)");
        mulBtn = new JButton("Multiplication (*)");
        divBtn = new JButton("Division (/)");

        styleButton(addBtn);
        styleButton(subBtn);
        styleButton(mulBtn);
        styleButton(divBtn);

        buttonPanel.add(addBtn);
        buttonPanel.add(subBtn);
        buttonPanel.add(mulBtn);
        buttonPanel.add(divBtn);

        center.add(buttonPanel, BorderLayout.CENTER);

        // Result Panel
        JPanel resultPanel = new JPanel(new BorderLayout(10, 10));
        resultPanel.setBackground(white);
        resultPanel.setBorder(
            BorderFactory.createEmptyBorder(12, 12, 12, 12)
        );

        resultLabel = new JLabel("Result: ", SwingConstants.CENTER);
        resultLabel.setFont(new Font("Arial", Font.BOLD, 20));
        resultLabel.setForeground(darkBlue);

        clearBtn = new JButton("CLEAR ALL");
        styleButton(clearBtn);

        resultPanel.add(resultLabel, BorderLayout.CENTER);
        resultPanel.add(clearBtn, BorderLayout.SOUTH);

        center.add(resultPanel, BorderLayout.SOUTH);

        mainPanel.add(center, BorderLayout.CENTER);

        add(mainPanel);

        // Event Handling
        addBtn.addActionListener(this);
        subBtn.addActionListener(this);
        mulBtn.addActionListener(this);
        divBtn.addActionListener(this);
        clearBtn.addActionListener(this);

        setVisible(true);
    }

    // Text Field Styling
    void styleField(JTextField field) {
        field.setFont(new Font("Arial", Font.PLAIN, 17));
        field.setBackground(white);
        field.setForeground(darkBlue);
        field.setBorder(
            BorderFactory.createLineBorder(blue, 2)
        );
    }

    // Button Styling
    void styleButton(JButton button) {
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBackground(blue);
        button.setForeground(white);
        button.setFocusPainted(false);
        button.setBorder(
            BorderFactory.createEmptyBorder(12, 8, 12, 8)
        );
    }

    // Button Click Operations
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == clearBtn) {
            num1.setText("");
            num2.setText("");
            resultLabel.setText("Result: ");
            resultLabel.setForeground(darkBlue);
            return;
        }

        try {

            double a = Double.parseDouble(num1.getText());
            double b = Double.parseDouble(num2.getText());
            double answer = 0;

            if (e.getSource() == addBtn) {
                answer = a + b;
            }
            else if (e.getSource() == subBtn) {
                answer = a - b;
            }
            else if (e.getSource() == mulBtn) {
                answer = a * b;
            }
            else if (e.getSource() == divBtn) {

                if (b == 0) {
                    resultLabel.setForeground(Color.RED);
                    resultLabel.setText("Cannot divide by zero!");
                    return;
                }

                answer = a / b;
            }

            DecimalFormat df = new DecimalFormat("0.########");
            resultLabel.setForeground(darkBlue);
            resultLabel.setText("Result: " + df.format(answer));

        }
        catch (NumberFormatException ex) {
            resultLabel.setForeground(Color.RED);
            resultLabel.setText("Please enter valid numbers!");
        }
    }

    // Main Method
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new BlueWaveCalculator();
        });
    }
}