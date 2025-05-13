package Bank_application;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class DeletAccount extends JFrame implements ActionListener {
	JLabel label;
    JTextField accNumField;
    JButton Delet, backButton;

	public DeletAccount() {
		setTitle("Admin Remove Account");
		setLayout(null);
		label = new JLabel("Enter Account Number :");
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setBounds(250, 100, 300, 30);
        add(label);
        
        accNumField = new JTextField();
        accNumField.setBounds(250, 150, 300, 30);
        add(accNumField);
        
        Delet = new JButton("Withdraw");
        Delet.setBounds(250, 200, 140, 30);
        Delet.setBackground(Color.GREEN);
        Delet.setForeground(Color.WHITE);
        Delet.addActionListener(this);
        add(Delet);
        
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
		if(e.getSource()==Delet) {
			String accNum=accNumField.getText().trim();
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/atmdb", "root", "");
                String q = "DELETE FROM accounts WHERE Acc_Num = ?";
                PreparedStatement pstmt = conn.prepareStatement(q);
                pstmt.setString(1, accNum);
                int rowsAffected = pstmt.executeUpdate();
                if (rowsAffected > 0) {
                	JOptionPane.showMessageDialog(null, "Account "+accNum+" deleted Successful.");
                    System.out.println("Account " + accNum + " deleted successfully.");
                    accNumField.setText("");
                } else {
                	JOptionPane.showMessageDialog(null, "Account "+accNum+" not found.");
                    System.out.println("Account " + accNum + " not found.");
                    accNumField.setText("");
                }

                pstmt.close();
                conn.close();
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		else {
			dispose();
            new AdminMenu();
		}
	}
	public static void main(String[]ai) {
		new DeletAccount();
	}
}
