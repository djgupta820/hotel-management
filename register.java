package hotelManagement;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class register extends JFrame implements ActionListener 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JLabel l1,l2,l3,l4,l5,l6,l7, l8, l9, lblr, pinfo, einfo;
	private static JButton b1,b2,b3,b4;
	private static JTextField t1,t2,t3,t4,t5,t6;
	private static JTextArea ta;
	private static JPasswordField pf1, pf2;

	register()
	{
	new JFrame("Register");

	setVisible(true);
	setSize(800,500);
	setBackground(Color.gray);
	setLocation(400,100);
	setLayout(null);
	setTitle("Member - Registration");
	Image ic = Toolkit.getDefaultToolkit().getImage("iconhotel.png");
	setIconImage(ic);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	JPanel p = new JPanel();
	JPanel p1 = new JPanel();

	p.setBackground(Color.gray);
	p.setVisible(true);
	p.setLayout(null);
	setResizable(false);
	p.setBounds(20,70,350,300);

	p1.setBackground(Color.gray);
	p1.setVisible(true);
	p1.setLayout(null);
	p1.setBounds(400,70,350,300);

	lblr = new JLabel("REGISTRATION");
	lblr.setFont(new Font("Times New Roman", Font.BOLD,25));
	lblr.setForeground(Color.red);
	lblr.setBounds(300,10,200,50);
	add(lblr);

	pinfo = new JLabel("Personal Information");
	pinfo.setBounds(50,20,300,25);
	pinfo.setFont(new Font("Algerian", Font.BOLD, 22));
	pinfo.setForeground(Color.blue);
	p.add(pinfo);

	l1 = new JLabel("First Name");
	l1.setBounds(50,70,100,20);
	p.add(l1);

	t1 = new JTextField();
	t1.setBounds(150,70,150,20);
	p.add(t1);

	l2 = new JLabel("Last Name");
	l2.setBounds(50,100,100,20);
	p.add(l2);

	t2 = new JTextField();
	t2.setBounds(150,100,150,20);
	p.add(t2);

	l3 = new JLabel("Phone Number");
	l3.setBounds(50,130,100,20);
	p.add(l3);

	t3 = new JTextField();
	t3.setBounds(150,130,150,20);
	p.add(t3);

	l4 = new JLabel("Address");
	l4.setBounds(50,190,100,20);
	p.add(l4);

	ta = new JTextArea(5,8);
	ta.setBounds(150,160,150,80);
	p.add(ta);

	b1 = new JButton("Clear");
	b1.setBounds(140,260,80,30);
	b1.addActionListener(this);			//ActionListener
	p.add(b1);

	einfo = new JLabel("EMPLOYEE INFORMATION");
	einfo.setFont(new Font("Algerian", Font.BOLD, 22));
	einfo.setBounds(50,20,300,25);
	einfo.setForeground(Color.blue);
	p1.add(einfo);

	l5 = new JLabel("Emp. ID");
	l5.setBounds(50,70,100,20);
	p1.add(l5);

	t4 = new JTextField();
	t4.setBounds(150,70,150,20);
	p1.add(t4);

	l6 = new JLabel("Work Phn. no. ");
	l6.setBounds(50,100,100,20);
	p1.add(l6);

	t5 = new JTextField();
	t5.setBounds(150,100,150,20);
	p1.add(t5);

	l7 = new JLabel("Select Username");
	l7.setBounds(50,130,120,20);
	p1.add(l7);

	t6 = new JTextField();
	t6.setBounds(150,130,150,20);
	p1.add(t6);

	l8 = new JLabel("Password");
	l8.setBounds(50,160,120,20);
	p1.add(l8);

	pf1 = new JPasswordField();
	pf1.setEchoChar('*');
	pf1.setBounds(150,160,150,20);
	p1.add(pf1);

	l9 = new JLabel("Password");
	l9.setBounds(50,190,120,20);
	p1.add(l9);

	pf2 = new JPasswordField();
	pf2.setEchoChar('*');
	pf2.setBounds(150,190,150,20);
	p1.add(pf2);

	b2 = new JButton("Clear");
	b2.setBounds(140,260,80,30);
	b2.addActionListener(this);			//ActionListener
	p1.add(b2);

	b3 = new JButton("Register");
	b3.setBounds(250,400,100,30);
	b3.addActionListener(this);			//ActionListener
	add(b3);

	b4 = new JButton("Cancel");
	b4.setBounds(400,400,100,30);
	b4.addActionListener(this);			//ActionListener
	add(b4);

	add(p);
	add(p1);
	}

	public void actionPerformed(ActionEvent e)
	{
	if(e.getSource() == b1)
	{
	t1.setText(" ");
	t2.setText(" ");
	t3.setText(" ");
	ta.setText(" ");
	}

	if(e.getSource() == b2)
	{
	t4.setText("");
	t5.setText("");
	t6.setText("");
	pf1.setText("");
	pf2.setText("");
	}

	if(e.getSource() == b3)
	{
		String fname = t1.getText();
		String lname = t2.getText();
		String phn = t3.getText();
		String add = ta.getText();
		int empID = Integer.parseInt(t4.getText());
		String wphn = t5.getText();
		String usern = t6.getText();
		String psswd = pf1.getText();
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3310/hotelmanagement", "root", "root");
			Statement stmt = conn.createStatement();
			
			String sql = "INSERT INTO USERS VALUES ('"+fname+"','"+lname+"','"+phn+"','"+add+"',"+empID+",'"+wphn+"','"+usern+"','"+psswd+"'"+")";
			stmt.executeUpdate(sql);
			
			JOptionPane.showMessageDialog(null, "Registration Successfull!");
			conn.close();
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, "Error Occured\n"+ex.getMessage());
		}
	
	}

	if(e.getSource() == b4)
	{
	this.dispose();
	new login();
	}
	}

	public static void main(String[] args) {
		
		new register();

	}

}
