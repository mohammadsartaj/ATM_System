package Bank_application;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class CheckBalance extends JFrame implements ActionListener {
	JButton backButton;
	JLabel textShow;
	String accNum;
	
	CheckBalance(String accNum){
		super("Bank Management System");
		this.accNum=accNum;
		JPanel contentPanel = new JPanel();
        contentPanel.setLayout(null);
        contentPanel.setOpaque(false);
        contentPanel.setBounds(0, 0, 850, 480);
        add(contentPanel);
		
        JLabel title = new JLabel("Your Current Balance:");
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setForeground(Color.WHITE);
        title.setBounds(250, 100, 400, 30);
        add(title);
        
        textShow = new JLabel();
        textShow.setFont(new Font("Arial", Font.BOLD, 28));
        textShow.setForeground(Color.YELLOW);
        textShow.setBounds(300, 160, 400, 40);
        add(textShow);

		
		backButton = new JButton("Back");
        backButton.setBounds(375, 270, 100, 35);
        backButton.addActionListener(this);
        contentPanel.add(backButton);
		
		ImageIcon iii1=new ImageIcon(ClassLoader.getSystemResource("Icons/backbg.png"));
		Image iii2=iii1.getImage().getScaledInstance(850, 480, Image.SCALE_DEFAULT);
		ImageIcon iii3=new ImageIcon(iii2);
		JLabel iiimage=new JLabel(iii3);
		iiimage.setBounds(0, 0, 850, 480);
		add(iiimage);
		
		setLayout(null);
		setSize(850,480);
		setLocation(450,200);
		fetchBalanceFromDB();
		setVisible(true);
	}
	void fetchBalanceFromDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/atmdb", "root", "");
            Statement stmt = conn.createStatement();

            String query = "SELECT Balance FROM accounts WHERE Acc_Num='" + accNum + "'";
            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) {
                double balance = rs.getDouble("Balance");
                textShow.setText("₹ " + String.format("%.2f", balance));
            } else {
                textShow.setText("Account not found!");
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception ex) {
            textShow.setText("Error fetching balance.");
            ex.printStackTrace();
        }
    }

	@Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            dispose();
            new UserMenu(accNum); // Make sure this exists
        }
    }
	public static void main(String[]ai) {
		new CheckBalance("");
	}
}
