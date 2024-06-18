import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class caculator extends JFrame {
    private int num1, num2;
    private String operator;
    private JLabel label2;

    public caculator() {
        setTitle("계산기");
        setSize(510, 550);

        JPanel resultPanel = new JPanel();
        resultPanel.setBounds(0, 0, 500, 40);
        JLabel label1 = new JLabel("계산 결과 : ");
        label1.setFont(new Font("함초롬돋움", Font.BOLD, 20));
        label2 = new JLabel("");
        label2.setFont(new Font("함초롬돋움", Font.BOLD, 20));
        resultPanel.add(label1);
        resultPanel.add(label2);
        resultPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        add(resultPanel);

        JButton btn1 = new JButton("7");
        JButton btn2 = new JButton("8");
        JButton btn3 = new JButton("9");
        JButton plus = new JButton("+");
        JButton btn5 = new JButton("4");
        JButton btn6 = new JButton("5");
        JButton btn7 = new JButton("6");
        JButton minus = new JButton("-");
        JButton btn9 = new JButton("1");
        JButton btn10 = new JButton("2");
        JButton btn11 = new JButton("3");
        JButton mult = new JButton("*");
        JButton btn13 = new JButton("0");
        JButton btn14 = new JButton("AC");
        JButton result = new JButton("=");
        JButton div = new JButton("/");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));

        panel.add(btn1);
        panel.add(btn2);
        panel.add(btn3);
        panel.add(plus);
        panel.add(btn5);
        panel.add(btn6);
        panel.add(btn7);
        panel.add(minus);
        panel.add(btn9);
        panel.add(btn10);
        panel.add(btn11);
        panel.add(mult);
        panel.add(btn13);
        panel.add(btn14);
        panel.add(result);
        panel.add(div);

        panel.setBounds(0, 50, 500, 450);
        add(panel);

        btn1.addActionListener(new NumberActionListener());
        btn2.addActionListener(new NumberActionListener());
        btn3.addActionListener(new NumberActionListener());
        btn5.addActionListener(new NumberActionListener());
        btn6.addActionListener(new NumberActionListener());
        btn7.addActionListener(new NumberActionListener());
        btn9.addActionListener(new NumberActionListener());
        btn10.addActionListener(new NumberActionListener());
        btn11.addActionListener(new NumberActionListener());
        btn13.addActionListener(new NumberActionListener());

        plus.addActionListener(new OperatorActionListener());
        minus.addActionListener(new OperatorActionListener());
        mult.addActionListener(new OperatorActionListener());
        div.addActionListener(new OperatorActionListener());
        result.addActionListener(new ResultActionListener());
        btn14.addActionListener(new ClearActionListener());

        JMenuBar menuBar = new JMenuBar();
        JMenu menu1 = new JMenu("File");
        menuBar.add(menu1);
        JMenu menu2 = new JMenu("Edit");
        menuBar.add(menu2);
        JMenu menu3 = new JMenu("Help");
        menuBar.add(menu3);
        setJMenuBar(menuBar);

        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private class NumberActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String value = ((JButton) e.getSource()).getText();
            label2.setText(label2.getText() + value);
        }
    }

    private class OperatorActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            num1 = Integer.parseInt(label2.getText());
            operator = ((JButton) e.getSource()).getText();
            label2.setText("");
        }
    }

    private class ResultActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            num2 = Integer.parseInt(label2.getText());
            int result = 0;
            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    result = num1 / num2;
                    break;
            }
            label2.setText(String.valueOf(result));
        }
    }

    private class ClearActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            label2.setText("");
            num1 = 0;
            num2 = 0;
            operator = "";
        }
    }

    public static void main(String[] args) {
        new caculator();
    }
}
