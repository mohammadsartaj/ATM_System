package Bank_application;

import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;

public class UserInfo extends JFrame implements ActionListener {
    private JLabel titleLabel, nameLabel, accNumLabel, balanceLabel, accTypeLabel, contactLabel;
    private JButton backButton;
    private String accNum;

    public UserInfo(String accNum) {
        super("User Details Page");
        this.accNum = accNum;

        setSize(850, 480);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(null);
        contentPanel.setOpaque(false);
        contentPanel.setBounds(0, 0, 850, 480);
        add(contentPanel);

        titleLabel = new JLabel("User Information", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBounds(250, 30, 350, 30);
        contentPanel.add(titleLabel);

        nameLabel = new JLabel("Name: ", SwingConstants.CENTER);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 20));
        
        nameLabel.setBounds(275, 90, 300, 25);
        contentPanel.add(nameLabel);

        accNumLabel = new JLabel("Account Number: ", SwingConstants.CENTER);
        accNumLabel.setFont(new Font("Arial", Font.BOLD, 20));
        accNumLabel.setBounds(275, 120, 300, 25);
        contentPanel.add(accNumLabel);

        balanceLabel = new JLabel("Balance: ₹", SwingConstants.CENTER);
        balanceLabel.setBounds(275, 150, 300, 25);
        balanceLabel.setFont(new Font("Arial", Font.BOLD, 20));
        contentPanel.add(balanceLabel);

        accTypeLabel = new JLabel("Account Type: ", SwingConstants.CENTER);
        accTypeLabel.setBounds(275, 180, 300, 25);
        accTypeLabel.setFont(new Font("Arial", Font.BOLD, 20));
        contentPanel.add(accTypeLabel);

        contactLabel = new JLabel("Contact: ", SwingConstants.CENTER);
        contactLabel.setBounds(275, 210, 300, 25);
        contactLabel.setFont(new Font("Arial", Font.BOLD, 20));
        contentPanel.add(contactLabel);

        backButton = new JButton("Back");
        backButton.setBounds(375, 270, 100, 35);
        backButton.addActionListener(this);
        contentPanel.add(backButton);

        // Background
        ImageIcon backgroundIcon = new ImageIcon(ClassLoader.getSystemResource("Icons/backbg.png"));
        Image scaledImg = backgroundIcon.getImage().getScaledInstance(850, 480, Image.SCALE_SMOOTH);
        JLabel backgroundLabel = new JLabel(new ImageIcon(scaledImg));
        backgroundLabel.setBounds(0, 0, 850, 480);
        add(backgroundLabel);
        getContentPane().setComponentZOrder(backgroundLabel, getContentPane().getComponentCount() - 1);

        fetchUserData();
//        showAllAccounts();
        setVisible(true);
    }

    private void fetchUserData() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/atmdb", "root", "");
            String query = "SELECT Name, Acc_Num, Pin, Location, Balance FROM accounts WHERE Acc_Num = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, accNum);

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                nameLabel.setText("Name: " + rs.getString("Name"));
                accNumLabel.setText("Account Number: " + rs.getString("Acc_Num"));
                balanceLabel.setText("Balance: ₹" + rs.getString("Balance"));
                accTypeLabel.setText("Pin: " + rs.getString("Pin"));
                contactLabel.setText("Location: " + rs.getString("Location"));
            } else {
                JOptionPane.showMessageDialog(this, "User not found for Account Number: " + accNum);
            }

            rs.close();
            pst.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading user info.");
        }
    }
    
    public void showAllAccounts() {
        try {
            // Connect to the database
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/atmdb", "root", "");

            // SQL query to get all users
            String query = "SELECT * FROM accounts";
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();

            // You can log the data here (optional)
            while (rs.next()) {
                String name = rs.getString("Name");
                String accNum = rs.getString("Acc_Num");
                String balance = rs.getString("Balance");
                String pin = rs.getString("Pin");
                String location = rs.getString("Location");

//                System.out.println("User: " + name + ", Account: " + accNum + ", Balance: ₹" + balance);
            }

            // Close connection
            rs.close();
            pst.close();
            con.close();

            // Show a message to the user
            JOptionPane.showMessageDialog(null, "Accounts fetched successfully, but not displayed.");

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error fetching accounts.");
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            dispose();
            new UserMenu(accNum); // Make sure this exists
        }
    }

    public static void main(String[] args) {
        // Just for testing
        new UserInfo("");  // Replace with an existing account number in your DB
    }
}

