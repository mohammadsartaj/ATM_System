package Bank_application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Withdraw extends JFrame implements ActionListener {
    String accNum;
    JLabel label;
    JTextField amountField;
    JButton withdrawButton, backButton;

    public Withdraw(String accNum) {
        this.accNum = accNum;

        setTitle("Withdraw Funds");
        setLayout(null);

        label = new JLabel("Enter Amount to Withdraw:");
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setBounds(250, 100, 300, 30);
        add(label);

        amountField = new JTextField();
        amountField.setBounds(250, 150, 300, 30);
        add(amountField);

        withdrawButton = new JButton("Withdraw");
        withdrawButton.setBounds(250, 200, 140, 30);
        withdrawButton.setBackground(Color.GREEN);
        withdrawButton.setForeground(Color.WHITE);
        withdrawButton.addActionListener(this);
        add(withdrawButton);

        backButton = new JButton("Back");
        backButton.setBounds(410, 200, 140, 30);
        backButton.setBackground(Color.RED);
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(this);
        add(backButton);

        ImageIcon bgIcon = new ImageIcon(ClassLoader.getSystemResource("Icons/backbg.png"));
        Image bgImage = bgIcon.getImage().getScaledInstance(850, 480, Image.SCALE_DEFAULT);
        JLabel bg = new JLabel(new ImageIcon(bgImage));
        bg.setBounds(0, 0, 850, 480);
        add(bg);

        setSize(850, 480);
        setLocation(450, 200);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == withdrawButton) {
            String amountText = amountField.getText().trim();
            try {
                if (amountText.isEmpty()) {
                    throw new NumberFormatException("Amount cannot be empty.");
                }

                double withdrawAmount = Double.parseDouble(amountText);
                if (withdrawAmount <= 0) {
                    throw new NumberFormatException("Amount must be greater than zero.");
                }

                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/atmdb", "root", "");
                Statement stmt = conn.createStatement();

                ResultSet rs = stmt.executeQuery("SELECT Balance FROM accounts WHERE Acc_Num='" + accNum + "'");
                if (rs.next()) {
                    double currentBalance = rs.getDouble("Balance");

                    if (withdrawAmount > currentBalance) {
                        throw new InsufficientFundsException("Insufficient Balance.");
                    }

                    double newBalance = currentBalance - withdrawAmount;

                    stmt.executeUpdate("UPDATE accounts SET Balance=" + newBalance + " WHERE Acc_Num='" + accNum + "'");
                    JOptionPane.showMessageDialog(null, "Withdrawal Successful. New Balance: ₹" + newBalance);
                    amountField.setText("");
                }

                rs.close();
                stmt.close();
                conn.close();

            } catch (InsufficientFundsException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Transaction Error", JOptionPane.ERROR_MESSAGE);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid Amount: " + ex.getMessage(), "Input Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Database Error", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == backButton) {
            dispose();
            new UserMenu(accNum);
        }
    }
    public static void main(String[]ai) {
    	new Withdraw("");
    }
}
