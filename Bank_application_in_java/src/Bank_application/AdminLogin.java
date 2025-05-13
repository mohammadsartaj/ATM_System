package Bank_application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminLogin extends JFrame implements ActionListener{
	JButton lb;
	JLabel pin;
	JPasswordField pinField;
	private final String admin_pin="1234";

	AdminLogin() {

		super("Admin Login Page!");

		pin = new JLabel("Enter the Admin Pin:");
		pin.setForeground(Color.WHITE);
		pin.setFont(new Font("AvantGrade", Font.BOLD, 28));
		pin.setBounds(150, 190, 375, 30);
		add(pin);
		
		pinField=new JPasswordField(5);
		pinField.setBounds(425,180,230,50);
		pinField.setFont(new Font("Arial",Font.BOLD,14));
		add(pinField);
		
		lb=new JButton("SIGN IN");
		lb.setFont(new Font("Arial",Font.BOLD,25));
		lb.setForeground(Color.BLACK);
		lb.setBackground(Color.GREEN);
		lb.setBounds(300, 300, 300, 60);
		lb.addActionListener(this);
		add(lb);
		

		ImageIcon iii1 = new ImageIcon(ClassLoader.getSystemResource("Icons/backbg.png"));
		Image iii2 = iii1.getImage().getScaledInstance(850, 480, Image.SCALE_DEFAULT);
		ImageIcon iii3 = new ImageIcon(iii2);
		JLabel iiimage = new JLabel(iii3);
		iiimage.setBounds(0, 0, 850, 480);
		add(iiimage);

		setLayout(null);
		setSize(850, 480);
		setLocation(450, 200);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String pin=String.valueOf(pinField.getPassword());
		if(pin.equals("")) {
			JOptionPane.showMessageDialog(null, "Please enter the PIN.");
		}
		else {
			try {
				if(pin.equals(admin_pin)) {
					JOptionPane.showMessageDialog(null, "Login Successful as Admin!");
					setVisible(false);
					new AdminMenu();
				}
				else {
					JOptionPane.showMessageDialog(null, "Incorrect pin!");
				}
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	public static void main(String[]ai) {
		new AdminLogin();
	}
}
