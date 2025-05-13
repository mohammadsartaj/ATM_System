package Bank_application;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class AdminMenu extends JFrame implements ActionListener{
	JButton vb,db,lb;
	public AdminMenu() {
		setTitle("Admin Menu");
		
		JLabel label1=new JLabel("WELCOME TO ADMIN ACCOUNT MENU");
		label1.setBounds(160,20,600,40);
		label1.setFont(new Font("Raleway",Font.BOLD,25));
		add(label1);
		vb=new JButton("View Accounts");
		vb.setFont(new Font("Arial",Font.BOLD,18));
		vb.setForeground(Color.WHITE);
		vb.setBackground(Color.BLUE);
		vb.setBounds(180, 150, 190, 50);
		vb.addActionListener(this);
		add(vb);
		
		db=new JButton("Delet Account");
		db.setFont(new Font("Arial",Font.BOLD,18));
		db.setForeground(Color.WHITE);
		db.setBackground(Color.BLUE);
		db.setBounds(390, 150, 190, 50);
//		b3.addActionListener(this);
		db.addActionListener(this);
		add(db);
		
		lb=new JButton("LogOut");
		lb.setFont(new Font("Arial",Font.BOLD,18));
		lb.setForeground(Color.WHITE);
		lb.setBackground(Color.RED);
		lb.setBounds(390, 250, 190, 50);
//		b3.addActionListener(this);
		lb.addActionListener(this);
		add(lb);
		
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
        if (e.getSource() == vb) {
            dispose();
            new ViewAllAccounts(); // Make sure this exists
        }
        else if(e.getSource()==lb) {
        	dispose();
        	new AdminMenu();
        }
        else if(e.getSource()==db) {
        	dispose();
        	new DeletAccount();
        }
        
    }
	public static void main(String[]ai) {
		new AdminMenu();
	}
}
