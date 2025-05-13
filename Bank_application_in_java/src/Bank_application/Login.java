package Bank_application;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Login extends JFrame implements ActionListener{
	JLabel label1,label2,label3;
	JTextField textFiled2;
	JPasswordField passwordField3;
	
	JButton b1,b2,b3;
	Login(){
		super("Bank Management System");
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Icons/bank.png"));
		Image i2=i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(350, 10, 100, 100);
		add(image);
		
		ImageIcon ii1=new ImageIcon(ClassLoader.getSystemResource("Icons/card.png"));
		Image ii2=ii1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		ImageIcon ii3=new ImageIcon(ii2);
		JLabel iimage=new JLabel(ii3);
		iimage.setBounds(630, 350, 100, 100);
		add(iimage);
		
		label1=new JLabel("WELCOME TO ATM");
		label1.setForeground(Color.WHITE);
		label1.setFont(new Font("AvantGrade",Font.BOLD,38));
		label1.setBounds(230, 125, 450, 40);
		add(label1);
		
		label2=new JLabel("Card No:");
		label2.setFont(new Font("Ralway",Font.BOLD,28));
		label2.setForeground(Color.WHITE);
		label2.setBounds(150, 190, 375, 30);
		add(label2);
		
		textFiled2=new JTextField(15);
		textFiled2.setBounds(325, 190, 230, 30);
		textFiled2.setFont(new Font("Arial",Font.BOLD,14));
		add(textFiled2);
		
		label3=new JLabel("PIN: ");
		label3.setFont(new Font("Ralway",Font.BOLD,28));
		label3.setForeground(Color.WHITE);
		label3.setBounds(152, 250, 375, 30);
		add(label3);
		
		passwordField3=new JPasswordField(15);
		passwordField3.setBounds(325, 250, 230, 30);
		passwordField3.setFont(new Font("Arial",Font.BOLD,14));
		add(passwordField3);
		
		b1=new JButton("SIGN In");
		b1.setFont(new Font("Arial",Font.BOLD,14));
		b1.setForeground(Color.WHITE);
		b1.setBackground(Color.GREEN);
		b1.setBounds(300, 300, 100, 30);
		b1.addActionListener(this);
		add(b1);
		
		b2=new JButton("CLEAR");
		b2.setFont(new Font("Arial",Font.BOLD,14));
		b2.setForeground(Color.WHITE);
		b2.setBackground(Color.RED);
		b2.setBounds(430, 300, 100, 30);
		b2.addActionListener(this);
		add(b2);
		
		b3=new JButton("SIN UP");
		b3.setFont(new Font("Arial",Font.BOLD,14));
		b3.setForeground(Color.WHITE);
		b3.setBackground(Color.BLUE);
		b3.setBounds(300, 350, 230, 30);
		b3.addActionListener(this);
		add(b3);
		
		
		ImageIcon iii1=new ImageIcon(ClassLoader.getSystemResource("Icons/backbg.png"));
		Image iii2=iii1.getImage().getScaledInstance(850, 480, Image.SCALE_DEFAULT);
		ImageIcon iii3=new ImageIcon(iii2);
		JLabel iiimage=new JLabel(iii3);
		iiimage.setBounds(0, 0, 850, 480);
		add(iiimage);
		
		setLayout(null);
		setSize(850,480);
		setLocation(450,200);
		setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			if(e.getSource()==b1) {
				
				String cardNo = textFiled2.getText();
			    String pin = String.valueOf(passwordField3.getPassword());

			    if (cardNo.equals("") || pin.equals("")) {
			        JOptionPane.showMessageDialog(null, "Please enter both Card Number and PIN.");
			    } else {
			        try {
			            // Make sure your DB credentials are correct
			            Class.forName("com.mysql.cj.jdbc.Driver");
			            java.sql.Connection conn = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/atmdb", "root", "");
			            java.sql.Statement stmt = conn.createStatement();

			            String query = "SELECT * FROM accounts WHERE Acc_Num='" + cardNo + "' AND Pin='" + pin + "'";
			            java.sql.ResultSet rs = stmt.executeQuery(query);

			            if (rs.next()) {
			                // Credentials matched
			                String accNum = rs.getString("Acc_Num"); // assuming the table has 'acc_number' column
			                JOptionPane.showMessageDialog(null, "Login Successful!");
			                setVisible(false);
//			                new UserInfo(accNum); // Pass the account number
			                dispose();
			                new UserMenu(accNum); // Pass the account number
			            } else {
			                JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN.");
			            }

			            rs.close();
			            stmt.close();
			            conn.close();

			        } catch (Exception ex) {
			            ex.printStackTrace();
			        }
			    }
			}
			else if(e.getSource()==b2) {
				textFiled2.setText("");
				passwordField3.setText(""); 
			}
			else if(e.getSource()==b3){
				new Signup();
			}
		}
		catch(Exception E) {
			E.printStackTrace();
		}
		
	}
	public static void main(String[]ai) {
		new Login();
	}
}
