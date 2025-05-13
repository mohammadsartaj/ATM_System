package Bank_application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserMenu extends JFrame implements ActionListener {
	JButton cb,db,wb,lb,ub;
	String accNum;
	
	
	public UserMenu(String accNum){
		super("User Menu");
		this.accNum=accNum;
		JLabel label1=new JLabel("WELCOME TO YOUR ACCOUNT MENU");
		label1.setBounds(160,20,600,40);
		label1.setFont(new Font("Raleway",Font.BOLD,25));
		add(label1);
		cb=new JButton("Check Balance");
		cb.setFont(new Font("Arial",Font.BOLD,18));
		cb.setForeground(Color.WHITE);
		cb.setBackground(Color.BLUE);
		cb.setBounds(180, 150, 190, 50);
		cb.addActionListener(this);
		add(cb);
		
		db=new JButton("Deposit");
		db.setFont(new Font("Arial",Font.BOLD,18));
		db.setForeground(Color.WHITE);
		db.setBackground(Color.BLUE);
		db.setBounds(390, 150, 190, 50);
//		b3.addActionListener(this);
		db.addActionListener(this);
		add(db);
		
		wb=new JButton("WithDraw");
		wb.setFont(new Font("Arial",Font.BOLD,18));
		wb.setForeground(Color.WHITE);
		wb.setBackground(Color.BLUE);
		wb.setBounds(180, 250, 190, 50);
//		b3.addActionListener(this);
		wb.addActionListener(this);
		add(wb);
		
		lb=new JButton("LogOut");
		lb.setFont(new Font("Arial",Font.BOLD,18));
		lb.setForeground(Color.WHITE);
		lb.setBackground(Color.RED);
		lb.setBounds(390, 250, 190, 50);
//		b3.addActionListener(this);
		lb.addActionListener(this);
		add(lb);
		
		ub=new JButton("User Info");
		ub.setFont(new Font("Arial",Font.BOLD,18));
		ub.setForeground(Color.WHITE);
		ub.setBackground(Color.BLUE);
		ub.setBounds(190, 350, 190, 50);
//		b3.addActionListener(this);
		ub.addActionListener(this);
		add(ub);
		
		
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
	        if (e.getSource() == cb) {
	            dispose();
	            new CheckBalance(accNum); // Make sure this exists
	        }
	        else if(e.getSource()==lb) {
	        	dispose();
	        	new Profile_page();
	        }
	        else if(e.getSource()==db) {
	        	dispose();
	        	new Deposit(accNum);
	        }
	        else if(e.getSource()==ub) {
	        	dispose();
	        	new UserInfo(accNum);
	        }
	        else {
	        	dispose();
	        	new Withdraw(accNum);
	        }
	    }
	public static void main(String[]ai) {
		new UserMenu("");
	}

}
