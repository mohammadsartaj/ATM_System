package Bank_application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class Signup extends JFrame implements ActionListener{
	JTextField textName,accNumber,pin,location,balance;
	JButton b3;
	Random rm=new Random();
	long first4=(rm.nextLong() % 9000L)+1000L;
	String first=" "+Math.abs(first4);
	
	Signup(){
		super("Application form");
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Icons/bank.png"));
		Image i2=i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(25, 10, 100, 100);
		add(image);
		
		JLabel label1=new JLabel("Application FORM No."+first);
		label1.setBounds(160,20,600,40);
		label1.setFont(new Font("Raleway",Font.BOLD,38));
		add(label1);
		
		JLabel label2=new JLabel("Page 1");
		label2.setBounds(330,70,600,30);
		label2.setFont(new Font("Raleway",Font.BOLD,22));
		add(label2);
		
		JLabel label3=new JLabel("Personal Details");
		label3.setBounds(290,90,600,30);
		label3.setFont(new Font("Raleway",Font.BOLD,22));
		add(label3);
		
		JLabel labelName=new JLabel("Name");
		labelName.setFont(new Font("Raleway",Font.BOLD,20));
		labelName.setBounds(100,190,100,30);
		add(labelName);
		
		textName=new JTextField();
		textName.setFont(new Font("Raleway",Font.BOLD,14));
		textName.setBounds(300,190,400,50);
		add(textName);
		
		JLabel labelacc =new JLabel("Account No.");
		labelacc.setFont(new Font("Raleway",Font.BOLD,20));
		labelacc.setBounds(100,290,100,30);
		add(labelacc);
		
		accNumber=new JTextField();
		accNumber.setFont(new Font("Raleway",Font.BOLD,14));
		accNumber.setBounds(300,290,400,50);
		add(accNumber);
		
		JLabel labelpin=new JLabel("Pin");
		labelpin.setFont(new Font("Raleway",Font.BOLD,20));
		labelpin.setBounds(100,390,100,30);
		add(labelpin);
		
		pin=new JTextField();
		pin.setFont(new Font("Raleway",Font.BOLD,14));
		pin.setBounds(300,390,400,50);
		add(pin);
		
		JLabel labellocation=new JLabel("Location");
		labellocation.setFont(new Font("Raleway",Font.BOLD,20));
		labellocation.setBounds(100,490,100,30);
		add(labellocation);
		
		location=new JTextField();
		location.setFont(new Font("Raleway",Font.BOLD,14));
		location.setBounds(300,490,400,50);
		add(location);
		
		JLabel labelbal=new JLabel("Balance");
		labelbal.setFont(new Font("Raleway",Font.BOLD,20));
		labelbal.setBounds(100,590,100,30);
		add(labelbal);
		
		balance=new JTextField();
		balance.setFont(new Font("Raleway",Font.BOLD,14));
		balance.setBounds(300,590,400,50);
		add(balance);
		
		b3=new JButton("USER SIGN In");
		b3.setFont(new Font("Arial",Font.BOLD,18));
		b3.setForeground(Color.WHITE);
		b3.setBackground(Color.BLUE);
		b3.setBounds(280, 650, 290, 50);
		b3.addActionListener(this);
		add(b3);
		
		
		getContentPane().setBackground(new Color(222,255,228));
		setLayout(null);
		setSize(850,800);
		setLocation(360,40);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			if(e.getSource()==b3) {
				String name=textName.getText();
				String accNum=accNumber.getText();
				String Pin=pin.getText();
				String loc=location.getText();
				String bal=balance.getText();
				if(name.equals("")||accNum.equals("")||Pin.equals("")||loc.equals("")||bal.equals("")) {
					JOptionPane.showMessageDialog(null, "Please enter all the values");
				}
				else {
					try {
					Class.forName("com.mysql.cj.jdbc.Driver");
		            java.sql.Connection conn = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/atmdb", "root", "");
		            java.sql.Statement stmt = conn.createStatement();
		            String query="INSERT INTO accounts (Name,Acc_Num, Pin, Location, Balance) VALUES (?,?,?,?,?)";
		            PreparedStatement pst = conn.prepareStatement(query);
		            pst.setString(1, name);
		            pst.setString(2, accNum);
		            pst.setString(3, Pin);
		            pst.setString(4, loc);
		            pst.setString(5, bal);
//				     java.sql.ResultSet rs=stmt.executeQuery(query);
		             int rs = pst.executeUpdate();
				     if(rs>0) {
				    	 JOptionPane.showMessageDialog(null, "Successfully Created A Account");
			             setVisible(false);
			             dispose();
			             new UserMenu(accNum);
				     }
				     else {
				    	 JOptionPane.showMessageDialog(null,"Error while featching the data or no data found");
				     }
				        pst.close();
			            stmt.close();
			            conn.close();
				}
				catch (Exception ex) {
		            ex.printStackTrace();
		        }
				}
			}
			else {
				System.out.println("Not available Button!");
			}
			
		}
		catch(Exception E) {
			E.printStackTrace();
		}
		
	}
	public static void main(String[]ai) {
		new Signup();
	}
}
