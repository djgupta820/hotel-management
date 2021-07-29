package hotelManagement;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;
import net.proteanit.sql.DbUtils;


public class detailed extends JFrame
{
	
	private static final long serialVersionUID = 1L;

	detailed()
	{
		new JFrame();
		setTitle("Detailed Information");
		setLocation(0,0);
		setSize(1200, 800);
		setVisible(true);
		setLayout(null);
		JLabel ds = new JLabel("Guest Detailed information");
		ds.setFont(new Font("Times New Roman", Font.BOLD, 25));
		ds.setForeground(Color.red);
		ds.setBounds(400, 10, 400, 30);
		add(ds);
		
		JTable jt1 = new JTable();
		jt1.setAutoResizeMode( JTable.AUTO_RESIZE_OFF);
		jt1.setRowHeight(25);
		jt1.setBackground(Color.black);
		jt1.setForeground(Color.LIGHT_GRAY);
		jt1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		
		JScrollPane jsp1 = new JScrollPane(jt1, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp1.setBounds(10, 70, 1200, 580);
		add(jsp1);
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn1 = DriverManager.getConnection("jdbc:mysql://localhost:3310/hotelmanagement", "root", "root");
			
			String sql = "Select * from check_in";
			PreparedStatement ps = conn1.prepareStatement(sql);
			
			ResultSet rs1 = ps.executeQuery();
			jt1.setModel(DbUtils.resultSetToTableModel(rs1));
			jt1.getColumnModel().getColumn(0).setPreferredWidth(150);
			jt1.getColumnModel().getColumn(1).setPreferredWidth(150);
			jt1.getColumnModel().getColumn(2).setPreferredWidth(150);
			jt1.getColumnModel().getColumn(3).setPreferredWidth(150);
			jt1.getColumnModel().getColumn(4).setPreferredWidth(150);
			jt1.getColumnModel().getColumn(5).setPreferredWidth(250);
			jt1.getColumnModel().getColumn(6).setPreferredWidth(150);
			jt1.getColumnModel().getColumn(7).setPreferredWidth(250);
			jt1.getColumnModel().getColumn(8).setPreferredWidth(150);
			jt1.getColumnModel().getColumn(9).setPreferredWidth(150);
			jt1.getColumnModel().getColumn(10).setPreferredWidth(150);
			jt1.getColumnModel().getColumn(11).setPreferredWidth(150);
			jt1.getColumnModel().getColumn(12).setPreferredWidth(150);
			jt1.getColumnModel().getColumn(13).setPreferredWidth(150);
			jt1.getColumnModel().getColumn(14).setPreferredWidth(150);
			jt1.getColumnModel().getColumn(15).setPreferredWidth(150);
			jt1.getColumnModel().getColumn(16).setPreferredWidth(150);
			jt1.getColumnModel().getColumn(17).setPreferredWidth(150);
			jt1.getColumnModel().getColumn(18).setPreferredWidth(150);
			jt1.getColumnModel().getColumn(19).setPreferredWidth(200);
			conn1.close();
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, "Error Occured\n"+ ex);
			System.out.println(ex);
		}
		
		JButton btnref = new JButton("Refresh");
		btnref.setBounds(400, 670, 100, 25);
		add(btnref);
		btnref.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn1 = DriverManager.getConnection("jdbc:mysql://localhost:3310/hotelmanagement", "root", "root");
					
					String sql = "Select * from check_in";
					PreparedStatement ps = conn1.prepareStatement(sql);
					
					ResultSet rs1 = ps.executeQuery();
					jt1.setModel(DbUtils.resultSetToTableModel(rs1));
					jt1.getColumnModel().getColumn(0).setPreferredWidth(150);
					jt1.getColumnModel().getColumn(1).setPreferredWidth(150);
					jt1.getColumnModel().getColumn(2).setPreferredWidth(150);
					jt1.getColumnModel().getColumn(3).setPreferredWidth(150);
					jt1.getColumnModel().getColumn(4).setPreferredWidth(150);
					jt1.getColumnModel().getColumn(5).setPreferredWidth(250);
					jt1.getColumnModel().getColumn(6).setPreferredWidth(150);
					jt1.getColumnModel().getColumn(7).setPreferredWidth(250);
					jt1.getColumnModel().getColumn(8).setPreferredWidth(150);
					jt1.getColumnModel().getColumn(9).setPreferredWidth(150);
					jt1.getColumnModel().getColumn(10).setPreferredWidth(150);
					jt1.getColumnModel().getColumn(11).setPreferredWidth(150);
					jt1.getColumnModel().getColumn(12).setPreferredWidth(150);
					jt1.getColumnModel().getColumn(13).setPreferredWidth(150);
					jt1.getColumnModel().getColumn(14).setPreferredWidth(150);
					jt1.getColumnModel().getColumn(15).setPreferredWidth(150);
					jt1.getColumnModel().getColumn(16).setPreferredWidth(150);
					jt1.getColumnModel().getColumn(17).setPreferredWidth(150);
					jt1.getColumnModel().getColumn(18).setPreferredWidth(150);
					jt1.getColumnModel().getColumn(19).setPreferredWidth(200);
					conn1.close();
					JOptionPane.showMessageDialog(null, "Done!");
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, "Error Occured\n" + ex);
				}
			}
		});
		
		JButton btnback = new JButton("Back");
		btnback.setBounds(500, 670, 100, 25);
		add(btnback);
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				setVisible(false);
				
			}
		});
	
		JLabel srch = new JLabel("Search");
		srch.setBounds(1220,90,100,12);
		add(srch);
		
		JLabel nsrch = new JLabel("Search By Name ");
		nsrch.setBounds(1220,110,200, 12);
		add(nsrch);
		
		JTextField tf1 = new JTextField();
		tf1.setBounds(1220,130, 100, 20);
		add(tf1);
		
		JButton btnnsrch = new JButton("Search");
		btnnsrch.setBounds(1220, 160, 100, 20);
		add(btnnsrch);
		btnnsrch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3310/hotelmanagement","root","root");
					
					String sql = "SELECT * FROM check_in WHERE FIRST_NAME = '" + tf1.getText() + "'";
					
					PreparedStatement ps = conn.prepareStatement(sql);
					
					ResultSet rs = ps.executeQuery();
					jt1.setModel(DbUtils.resultSetToTableModel(rs));
					jt1.getColumnModel().getColumn(0).setPreferredWidth(150);
					jt1.getColumnModel().getColumn(1).setPreferredWidth(150);
					jt1.getColumnModel().getColumn(2).setPreferredWidth(150);
					jt1.getColumnModel().getColumn(3).setPreferredWidth(150);
					jt1.getColumnModel().getColumn(4).setPreferredWidth(150);
					jt1.getColumnModel().getColumn(5).setPreferredWidth(250);
					jt1.getColumnModel().getColumn(6).setPreferredWidth(150);
					jt1.getColumnModel().getColumn(7).setPreferredWidth(250);
					jt1.getColumnModel().getColumn(8).setPreferredWidth(150);
					jt1.getColumnModel().getColumn(9).setPreferredWidth(150);
					jt1.getColumnModel().getColumn(10).setPreferredWidth(150);
					jt1.getColumnModel().getColumn(11).setPreferredWidth(150);
					jt1.getColumnModel().getColumn(12).setPreferredWidth(150);
					jt1.getColumnModel().getColumn(13).setPreferredWidth(150);
					jt1.getColumnModel().getColumn(14).setPreferredWidth(150);
					jt1.getColumnModel().getColumn(15).setPreferredWidth(150);
					jt1.getColumnModel().getColumn(16).setPreferredWidth(150);
					jt1.getColumnModel().getColumn(17).setPreferredWidth(150);
					jt1.getColumnModel().getColumn(18).setPreferredWidth(150);
					jt1.getColumnModel().getColumn(19).setPreferredWidth(200);
					conn.close();
					JOptionPane.showMessageDialog(null, "Done!");
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, "Error Occured\n" + ex.getMessage());
				}
			}
		});
		
		JLabel rsrch = new JLabel("Search By Room Number ");
		rsrch.setBounds(1220,190,250,12);
		add(rsrch);
		
		JTextField tf2 = new JTextField();
		tf2.setBounds(1220, 210, 100, 20);
		add(tf2);
		
		JButton btnrsrch = new JButton("Search");
		btnrsrch.setBounds(1220, 250, 100, 20);
		add(btnrsrch);
		btnrsrch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3310/hotelmanagement","root","root");
					
					String sql = "SELECT * FROM check_in WHERE room_number = " + tf2.getText();
					
					PreparedStatement ps = conn.prepareStatement(sql);
					
					ResultSet rs = ps.executeQuery();
					jt1.setModel(DbUtils.resultSetToTableModel(rs));
					jt1.getColumnModel().getColumn(0).setPreferredWidth(150);
					jt1.getColumnModel().getColumn(1).setPreferredWidth(150);
					jt1.getColumnModel().getColumn(2).setPreferredWidth(150);
					jt1.getColumnModel().getColumn(3).setPreferredWidth(150);
					jt1.getColumnModel().getColumn(4).setPreferredWidth(150);
					jt1.getColumnModel().getColumn(5).setPreferredWidth(250);
					jt1.getColumnModel().getColumn(6).setPreferredWidth(150);
					jt1.getColumnModel().getColumn(7).setPreferredWidth(250);
					jt1.getColumnModel().getColumn(8).setPreferredWidth(150);
					jt1.getColumnModel().getColumn(9).setPreferredWidth(150);
					jt1.getColumnModel().getColumn(10).setPreferredWidth(150);
					jt1.getColumnModel().getColumn(11).setPreferredWidth(150);
					jt1.getColumnModel().getColumn(12).setPreferredWidth(150);
					jt1.getColumnModel().getColumn(13).setPreferredWidth(150);
					jt1.getColumnModel().getColumn(14).setPreferredWidth(150);
					jt1.getColumnModel().getColumn(15).setPreferredWidth(150);
					jt1.getColumnModel().getColumn(16).setPreferredWidth(150);
					jt1.getColumnModel().getColumn(17).setPreferredWidth(150);
					jt1.getColumnModel().getColumn(18).setPreferredWidth(150);
					jt1.getColumnModel().getColumn(19).setPreferredWidth(200);
					conn.close();
					JOptionPane.showMessageDialog(null, "Done!");
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, "Error Occured\n" + ex.getMessage());
				}
			}
		});
		
		JButton btnclr = new JButton("Clear");
		btnclr.setBounds(1220, 270, 100, 20);
		add(btnclr);
		btnclr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				tf1.setText("");
				tf2.setText("");
			}
		});
	}

	public static void main(String[] args) 
	{
		new detailed();
	}

}
