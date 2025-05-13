package Bank_application;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Profile_page extends JFrame implements ActionListener{
	JLabel label1,label2,label3;
	JTextField textFiled2;
	JPasswordField passwordField3;
	
	JButton b1,b2,b3;
	Profile_page(){
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
		
		
		
		
		
		b1=new JButton("CREAT ACCOUNT");
		b1.setFont(new Font("Arial",Font.BOLD,18));
		b1.setForeground(Color.WHITE);
		b1.setBackground(Color.BLUE);
		b1.setBounds(80, 250, 290, 60);
		b1.addActionListener(this);
		add(b1);
		
		b2=new JButton("ADMIN SIGNIn");
		b2.setFont(new Font("Arial",Font.BOLD,18));
		b2.setForeground(Color.WHITE);
		b2.setBackground(Color.BLUE);
		b2.setBounds(380, 250, 290, 60);
		b2.addActionListener(this);
		add(b2);
		
		
		
		b3=new JButton("USER SIGNIN");
		b3.setFont(new Font("Arial",Font.BOLD,18));
		b3.setForeground(Color.WHITE);
		b3.setBackground(Color.BLUE);
		b3.setBounds(280, 350, 290, 60);
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
		        if (e.getSource() == b2) {
		        	dispose();
		            new AdminLogin();
		        } else if (e.getSource() == b3) {
		        	dispose();
		            new Login();
		        }
		        else {
		        	dispose();
		        	new Signup();
		        }
		    } catch (Exception ex) {
		        ex.printStackTrace();
		    }
		
	}
	public static void main(String[]ai) {
		new Profile_page();
	}
}
