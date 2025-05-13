package Bank_application;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ViewAllAccounts extends JFrame implements ActionListener{
	JTable table;
	DefaultTableModel model;
	JButton backButton;
	public ViewAllAccounts() {
//		super("Admin");
		setTitle("Bank Account Data");
		String col[]= {"Account Number","Name","Balance"};
		model = new DefaultTableModel(col, 0);
        table = new JTable(model);
        table.setShowGrid(true);
        table.setGridColor(Color.BLACK);
        table.setRowHeight(25);
        table.setIntercellSpacing(new Dimension(1, 1));

        // Add solid outer border to cover missing grid lines
        table.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        setSize(850, 480);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(450, 200);

        fetchDataFromDatabase();
        backButton = new JButton("Back");
        backButton.setBounds(350, 200, 140, 60);
        backButton.setBackground(Color.RED);
        backButton.setFont(new Font("Arial", Font.BOLD, 28));
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(this);
        add(backButton);

//        add(new JScrollPane(table), BorderLayout.CENTER);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(20, 20, 0, 20)); // left & right padding
        add(scrollPane, BorderLayout.CENTER);
        setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==backButton) {
			dispose();
            new AdminMenu();
		}
	}
	public void fetchDataFromDatabase() {
		try {
			System.out.println("tryinng to connect");
			Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/atmdb", "root", "");
            String q="select Acc_Num,Name,Balance from accounts";
            Statement stmt = conn.createStatement();
            ResultSet rs=stmt.executeQuery(q);
            
            while(rs.next()) {
            	String acc_num=rs.getString("Acc_Num");
            	String name=rs.getString("Name");
            	String Balance=rs.getString("Balance");
            	model.addRow(new Object[] {acc_num,name,Balance});
            }
            rs.close();
            stmt.close();
            conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[]ai) {
		new ViewAllAccounts();
	}
}
