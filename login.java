package hotelManagement;

import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.border.Border;
import java.sql.*;

public class login extends JFrame implements ActionListener 
{

	private static final long serialVersionUID = 1L;
	static JLabel user,pass, lblicon, lblusr;
	static JTextField usrtxt;
	static JPasswordField passtxt;
	static JButton btnlog, btnclr,btnext, btnreg;
	public static String sendname;
	public static String fname, lname;
	
	login()
	{
	new JFrame();
	setTitle("Login");
	setSize(680,380);
	setLocation(400,200);
	setLayout(null);
	setVisible(true);
	setResizable(false);
	setBackground(new Color(255,255,153));
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	Border blueLine = BorderFactory.createLineBorder(Color.blue);

	JPanel logp = new JPanel();
	logp.setLayout(null);
	logp.setBounds(20,20,600,300);
	logp.setBorder(blueLine);
	logp.setBackground(new Color(153,153,153));
	logp.setFont(new Font("verdana", Font.BOLD, 40));
	add(logp);

	lblusr = new JLabel("Memeber Login");
	lblusr.setFont(new Font("Times New Roman", Font.BOLD, 35));
	lblusr.setBounds(220,20,350,40);
	logp.add(lblusr);

	ImageIcon pic = new ImageIcon("imgs/login.png");
	Image image = pic.getImage();
	Image newimg = image.getScaledInstance(120,120,Image.SCALE_SMOOTH);
	pic = new ImageIcon(newimg);

	lblicon = new JLabel(pic);
	lblicon.setBounds(20,40,150,150);
	logp.add(lblicon);

	user = new JLabel("Username");
	user.setBounds(200,80,100,30);
	usrtxt = new JTextField();
	usrtxt.setBounds(330,80,200,30);
	logp.add(user);
	logp.add(usrtxt);

	pass = new JLabel("Password");
	pass.setBounds(200,130,100,30);
	passtxt = new JPasswordField();
	passtxt.setEchoChar('*');
	passtxt.setBounds(330,130,200,30);
	logp.add(pass);
	logp.add(passtxt);

	btnreg = new JButton("Register");
	btnreg.setBounds(170,220,90,25);
	btnreg.addActionListener(this);			//ActionListener

	btnlog = new JButton("Login");
	btnlog.setBounds(90,220,80,25);
	btnlog.addActionListener(this);			//ActionListener

	btnclr = new JButton("Clear");
	btnclr.setBounds(300,220,80,25);
	btnclr.addActionListener(this);			//ActionListener

	btnext = new JButton("Exit");
	btnext.setBounds(430,220,80,25);
	btnext.addActionListener(this);			//ActionListener

	logp.add(btnreg);
	logp.add(btnlog);
	logp.add(btnclr);
	logp.add(btnext);

	}

	public void actionPerformed(ActionEvent e)
	{
	if(e.getSource() == btnlog)
	{
	String usr = usrtxt.getText();
	String pss = passtxt.getText();
	sendname = usr;
	
	try
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3310/hotelmanagement", "root", "root");
		
		/*PreparedStatement ps1 = conn.prepareStatement("Select First_Name, Last_Name from users where username = ?");
		ps1.setString(1, usr);*/
		String sql = "Select first_name, last_Name from users where username = '" + usr + "'";
		Statement stmt = conn.createStatement();
		ResultSet rs1 = stmt.executeQuery(sql);
		while(rs1.next())
		{
			fname = rs1.getString("first_name");
			lname = rs1.getString("Last_Name");
		}
		
		
		PreparedStatement ps = conn.prepareStatement("select  first_name from users where username = ? and password = ?");
		ps.setString(1, usr);
		ps.setString(2, pss);
		ResultSet rs = ps.executeQuery();
		
		if(rs.next())
		{
			JOptionPane.showMessageDialog(null, "Login Successfull !!");
			this.dispose();
			new mainFrame();
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Invalid Credentials\n Try Again ");
		}
				
	}
	catch(Exception ex)
	{
		JOptionPane.showMessageDialog(null, "Error Occured While Login\n" + ex.getMessage());
	}
	}

	if(e.getSource() == btnreg)
	{
	this.dispose();
	new register();
	}

	if(e.getSource() == btnclr)
	{
	usrtxt.setText("");
	passtxt.setText("");
	}

	if(e.getSource() == btnext)
	{
	System.exit(0);
	}
	}
	
	public static void main(String[] args) {
		
		new login();

	}

}
