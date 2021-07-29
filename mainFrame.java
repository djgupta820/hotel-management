package hotelManagement;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import javax.swing.border.Border;
import net.proteanit.sql.DbUtils;

public class mainFrame extends JFrame implements WindowListener
{
	private static final long serialVersionUID = 1L;
		static int rmno = 100;
		JLabel l1,l2,lblImg, lblhead, uicon, uname;
	    JButton btnexit,btnchkin,btnchkout,btnlgout,btnlist;
	    JPanel gst = new JPanel();
	    JPanel rmgst = new JPanel();
	    JPanel lstgst = new JPanel();
	    JPanel crooms = new JPanel();
	    
	    void addPanelVisible()
	    {
	        rmgst.setVisible(false);
	        lstgst.setVisible(false);
	        crooms.setVisible(false);
	        gst.setVisible(true);
	    }
	
	    void removePanelVisible()
	    {
	        lstgst.setVisible(false);
	        crooms.setVisible(false);
	        gst.setVisible(false);
	        rmgst.setVisible(true);
	    }
	
	    void listPanelVisible()
	    {
	        gst.setVisible(false);
	        rmgst.setVisible(false);
	        crooms.setVisible(false);
	        lstgst.setVisible(true);
	    }
	
	    void checkRoomPanelVisible()
	    {
	        gst.setVisible(false);
	        rmgst.setVisible(false);
	        lstgst.setVisible(false);
	        crooms.setVisible(true);
	    }
	
	    public void displayLabel()
	    {
	        l1.setVisible(true);
	        l2.setVisible(true);
	        lblImg.setVisible(true);
	    }
	
	    public void hideLabel()
	    {
	        l1.setVisible(false);
	        l2.setVisible(false);
	        lblImg.setVisible(false);
	    }
	   
	
	    public void addGuest()					//Adding an user
	    {
	        JLabel lbladgst, lblfname, lbllname,lblmname,lblgen,lbladdr,lbldob,lblcnn,lblmail,lblpno,lblnat;
	        JTextField txtfname,txtmname,txtlname,txtcnn,txtmail,txtdob,txtpno,txtnat;
	        JLabel rt, payment, nom, nof, noc, smk, dis, lmop;
	        JTextField tnom, tnof, tnoc, pay, disc;
	        JTextArea taddr, ginfo;
	        JComboBox cb1, rmtype, smok, mop;
	        JButton btnadd, btnclear, btncancel;
	
	        hideLabel();
	        addPanelVisible();
	        Border blackLine = BorderFactory.createLineBorder(Color.black);
	        gst.setLayout(null);
	        gst.setBackground(new Color(51,204,255));
	        gst.setBounds(80,100,1250,550);
	        gst.setBorder(blackLine);
	        this.add(gst);
	
	        lblhead = new JLabel("CHECK-IN");
	        lblhead.setFont(new Font("algerian", Font.BOLD, 30));
	        lblhead.setBounds(450,20,300,40);
	        lblhead.setForeground(new Color(102,102,102));
	        gst.add(lblhead);
	
	        ImageIcon adusr = new ImageIcon("imgs/add-friend.png");
	        Image img = adusr.getImage();
	        Image newimg = img.getScaledInstance(200,200,Image.SCALE_SMOOTH);
	        adusr = new ImageIcon(newimg);
	
	        lbladgst = new JLabel(adusr);
	        lbladgst.setBounds(20,100,250,250);
	        lbladgst.setBorder(blackLine);
	        gst.add(lbladgst);
	
	        JPanel perinfo = new JPanel();			// panel for persional information
	        perinfo.setLayout(new GridLayout(10,3));
	        perinfo.setBackground(new Color(51,204,255));
	        perinfo.setBounds(270,70,300,350);
	        gst.add(perinfo);
	
	        lblfname = new JLabel("First Name", JLabel.CENTER);
	        txtfname = new JTextField(30);
	        perinfo.add(lblfname);
	        perinfo.add(txtfname);
	
	        lblmname = new JLabel("Middel Name", JLabel.CENTER);
	        txtmname = new JTextField(30);
	        perinfo.add(lblmname);
	        perinfo.add(txtmname);
	
	        lbllname = new JLabel("Las Name", JLabel.CENTER);
	        txtlname = new JTextField(30);
	        perinfo.add(lbllname);
	        perinfo.add(txtlname);
	
	        lblgen = new JLabel("Gender", JLabel.CENTER);
	        cb1 = new JComboBox();
	        cb1.addItem("Male");
	        cb1.addItem("Female");
	        cb1.addItem("Other");
	        perinfo.add(lblgen);
	        perinfo.add(cb1);
	
	        lbldob = new JLabel("Date of Birth", JLabel.CENTER);
	        txtdob = new JTextField();
	        perinfo.add(lbldob);
	        perinfo.add(txtdob);
	
	        lbladdr = new JLabel("Address", JLabel.CENTER);
	        taddr = new JTextArea(5,10);
	        perinfo.add(lbladdr);
	        perinfo.add(taddr);
	
	        lblcnn = new JLabel("Contact No.", JLabel.CENTER);
	        txtcnn = new JTextField(30);
	        perinfo.add(lblcnn);
	        perinfo.add(txtcnn);
	
	        lblmail = new JLabel("Email", JLabel.CENTER);
	        txtmail = new JTextField(30);
	        perinfo.add(lblmail);
	        perinfo.add(txtmail);
	
	        lblnat = new JLabel("Nationality", JLabel.CENTER);
	        txtnat = new JTextField(30);
	        perinfo.add(lblnat);
	        perinfo.add(txtnat);
	
	        lblpno = new JLabel("Passport No.", JLabel.CENTER);
	        txtpno = new JTextField(30);
	        perinfo.add(lblpno);
	        perinfo.add(txtpno);
	
	        JPanel rinfo = new JPanel();			//Panel for registeration info
	        rinfo.setLayout(new GridLayout(8,2));
	        rinfo.setBackground(new Color(51,204,255));
	        rinfo.setBounds(590,70,300,350);
	        gst.add(rinfo);
	
	        rt = new JLabel("Room Type", JLabel.CENTER);
	        rinfo.add(rt);
	
	        rmtype = new JComboBox();
	        rmtype.addItem("Single");
	        rmtype.addItem("Double");
	        rmtype.addItem("Family");
	        rinfo.add(rmtype);
	
	        smk = new JLabel("Smoking", JLabel.CENTER);
	        rinfo.add(smk);
	
	        smok = new JComboBox();
	        smok.addItem("Yes");
	        smok.addItem("No");
	        rinfo.add(smok);
	
	        nom = new JLabel("No. of Male", JLabel.CENTER);
	        tnom = new JTextField();
	        rinfo.add(nom);
	        rinfo.add(tnom);
	
	        nof = new JLabel("No. of Female", JLabel.CENTER);
	        tnof = new JTextField();
	        rinfo.add(nof);
	        rinfo.add(tnof);
	
	        noc = new JLabel("No. of Children", JLabel.CENTER);
	        tnoc = new JTextField();
	        rinfo.add(noc);
	        rinfo.add(tnoc);
	
	        lmop = new JLabel("Mode of Payment", JLabel.CENTER);
	        rinfo.add(lmop);
	
	        mop = new JComboBox();
	        mop.addItem("Cash");
	        mop.addItem("Credit Card");
	        mop.addItem("Debit Card");
	        mop.addItem("Check");
	        rinfo.add(mop);
	
	        dis = new JLabel("Discount", JLabel.CENTER);
	        rinfo.add(dis);
	
	        disc = new JTextField();
	        disc.setEditable(false);
	        rinfo.add(disc);
	
	        payment = new JLabel("Total Payment", JLabel.CENTER);
	        rinfo.add(payment);
	        pay = new JTextField();
	        pay.setEditable(false);
	        rinfo.add(pay);
	
	        btnadd = new JButton("Add");
	        btnadd.setFont(new Font("verdana", Font.BOLD, 15));
	        btnadd.setBackground(Color.black);
	        btnadd.setForeground(Color.gray);
	        btnadd.setBounds(500,470,110,40);
	        gst.add(btnadd);
	
	        btnclear = new JButton("Clear");
	        btnclear.setFont(new Font("verdana", Font.BOLD, 15));
	        btnclear.setBackground(Color.black);
	        btnclear.setForeground(Color.gray);
	        btnclear.setBounds(600,470,110,40);
	        gst.add(btnclear);
	        
	        JPanel gstinfo = new JPanel();			//Panel for showing information
	        gstinfo.setBounds(910,70,310,400);
	        gst.add(gstinfo);
	        
	        ginfo = new JTextArea(19,18);
	        ginfo.setEditable(false);
	        ginfo.setFont(new Font("verdana", Font.BOLD, 15));
	        ginfo.setText("Customer Information");
	        
	        JScrollPane jsp = new JScrollPane(ginfo, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
	        gstinfo.add(jsp);
	        
	        
	        
	        btnadd.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e)
	        	{
	        		double amt, p, disct;
	        		
	        		String fname = txtfname.getText();
	        		String mname = txtmname.getText();
	        		String lname = txtlname.getText();
	        		String cnn = txtcnn.getText();
	        		String mail = txtmail.getText();
	        		String dob = txtdob.getText();
	        		String nat = txtnat.getText();
	        		String passport = txtpno.getText();
	        		String nom = tnom.getText();
	        		String nof = tnof.getText();
	        		String noc = tnoc.getText();
	     	        String add = taddr.getText();
	     	        String gen = (String) cb1.getSelectedItem();
	     	        String rmtp =  (String) rmtype.getSelectedItem();
	     	        String smk = (String)smok.getSelectedItem();
	     	        String mopay = (String) mop.getSelectedItem();
	     	        LocalDateTime now = LocalDateTime.now();
	     			DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
	     			String datetime = now.format(format);
	     	        
	     			
	     	        if(rmtp == "Single")
	     	        {
	     	        	amt = 1000;
	     	        }
	     	        else if(rmtp == "Double")
	     	        {
	     	        	amt = 1700;
	     	        }
	     	        else
	     	        {
	     	        	amt = 2300;
	     	        }
	     	        
	     	        if(smk == "Yes")
	     	        {
	     	        	amt += 500;
	     	        }
	     	        
	     	       p = amt;
	     	       
	     	        if(mopay == "Credit Card" || mopay == "Debit Card")
	     	        {
	     	        	disct = (double) (p * 2)/100;
	     	        }
	     	        else
	     	        {
	     	        	disct = (double) 0;
	     	        }
	     	        
	     	       p = amt-disct;
	     	       
	     	       pay.setText(Double.toString(p));
	     	       
	     	       disc.setText(Double.toString(disct));
	     	        
	     	        
	     	        try
	     	        {
	     	        	Class.forName("com.mysql.cj.jdbc.Driver");
	     	        	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3310/hotelmanagement", "root", "root");
	     	        	
	     	        	Statement stmt = conn.createStatement();
	     	        	String sql = "INSERT INTO CHECK_IN VALUES('" +fname + "','" + mname + "','" + lname + "','" + gen + "','" + dob + "','" + add + "','" + cnn + "','" + mail + "','" + nat + "','" + passport + "','" + rmtp + "','" + smk + "'," + nom + ","+ nof + ","+ noc +",'" + mopay + "'," + disct + "," + p + ","+ rmno + ",'"+ datetime + "')";
	     	        	
	     	        	stmt.executeUpdate(sql);
	     	        	
	     	        	JOptionPane.showMessageDialog(null,"Check-In Successfull !");
	     	        	conn.close();
	     	        	rmno ++;
	     	        }
	     	        catch(Exception ex)
	     	        {
	     	        	JOptionPane.showMessageDialog(null, "Error Occured !!\n" + ex.getMessage());
	     	        	ex.printStackTrace();
	     	        }
	     	        
	     	        try {
						Thread.sleep(2000);
						String info = "     Customer Information\n\n" + "\n Room Number : " + rmno+"\n" + "\n First Name : " + fname+"\n" + "\n Middle Name : " + mname+"\n" + " Last Name : " +  lname +"\n"+ "\n Gender : " + gen +"\n"+ "\n Contact Number : " + cnn +"\n"+ "\n Address : " + add +"\n"+ "\n Email : " + mail +"\n"+ "\n Date of Birth : " + dob +"\n"+ "\n Passport Number : " + passport +"\n"+ "\n Nationality : " + nat +"\n" + "\n Number of Males : " + nom +"\n"+ "\n Number of Females : " + nof +"\n"+ "\n Number of children : "  + noc +"\n"+ "\n Mode of Payment : " + mopay +"\n"+ "\n Room Type : " + rmtp +"\n"+ "\n Smoking : " + smk +"\n"+ "\n Discount : " + disct +"\n"+ "\n Total Payment : " + p +"\n"+ "\n Check in Date and Time : " + datetime + "\n";
						ginfo.setText(info);
						
	     	        } catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	     	        
	        	}
	        });
	        
	        btnclear.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e)
	        	{
	    	        txtfname.setText("");
	    	        txtmname.setText("");
	    	        txtlname.setText("");
	    	        txtcnn.setText("");
	    	        txtmail.setText("");
	    	        txtdob.setText("");
	    	        txtpno.setText("");
	    	        txtnat.setText("");
	    	        tnom.setText("");
	    	        tnof.setText("");
	    	        tnoc.setText("");
	    	        pay.setText(""); 
	    	        disc.setText("");
	    	        taddr.setText("");
	    	        cb1.setSelectedIndex(0); 
	    	        rmtype.setSelectedIndex(0);
	    	        smok.setSelectedIndex(0);
	    	        mop.setSelectedIndex(0);
	    	        ginfo.setText("");
	        	}
	        });
	        
	        
	
	        btncancel = new JButton("Cancel");
	        btncancel.setFont(new Font("verdana", Font.BOLD, 15));
	        btncancel.setBackground(Color.black);
	        btncancel.setForeground(Color.gray);
	        btncancel.setBounds(710,470,110,40);
	        
	        btncancel.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e)
	        	{
	        		gst.setVisible(false);
	        		displayLabel();
	        	}
	        });
	        
	        gst.add(btncancel);
	
	    }
	
	    public void removeGuest()					//Remove a guest
	    {
	
	        JLabel lblst, lblimg;
	        JLabel fn,mn,ln,g,dob,ad,cn,nat,psno,tr,sm,nom,nof,noc,mop,disc,tp,chkdt,lfn,lmn,lln,lg,ldob,lad,lcn,lnat,lpsno,ltr,lsm,lnom,lnof,lnoc,lmop,ldisc,ltp,lchkdt,rm, lrm, mail, lmail;
	        JTextField txts;
	        JButton btnsrch, btnremove, btncancel, btnclear;
	        JTextArea tainfo;
	
	        hideLabel();
	        removePanelVisible();
	        Border blackLine = BorderFactory.createLineBorder(Color.black);
	        rmgst.setLayout(null);
	        //gst.setBackground(Color.gray);
	        rmgst.setBackground(new Color(51,204,255));
	        rmgst.setBounds(80,100,1250,550);
	        rmgst.setBorder(blackLine);
	        add(rmgst);
	
	        lblhead = new JLabel("CHECK-OUT");
	        lblhead.setFont(new Font("algerian", Font.BOLD, 30));
	        lblhead.setBounds(500,20,300,40);
	        lblhead.setForeground(new Color(102,102,102));
	        rmgst.add(lblhead);
	
	        ImageIcon img = new ImageIcon("imgs/remove-user.png");
	        Image image = img.getImage();
	        Image newimg = image.getScaledInstance(150,150,Image.SCALE_SMOOTH);
	        img = new ImageIcon(newimg);
	
	        lblimg = new JLabel(img);
	        lblimg.setBounds(20,70,170,170);
	        lblimg.setBorder(blackLine);
	        rmgst.add(lblimg);
	
	        JPanel p1 = new JPanel();		//Panel for search type
	        p1.setLayout(new GridLayout(3,1));
	        p1.setSize(100,100);
	        p1.setBounds(20,250,170,100);
	        rmgst.add(p1);
	
	        lblst = new JLabel("Enter Room No.", JLabel.CENTER);
	        p1.add(lblst);
	        txts = new JTextField();
	        p1.add(txts);
	
	        btnsrch = new JButton("Find");
	        p1.add(btnsrch);
		
		JPanel infopane = new JPanel();
		infopane.setLayout(new GridLayout(10,4));
		infopane.setBackground(new Color(51,204,255));
		infopane.setBounds(220,70,1000,400);
		rmgst.add(infopane);
		
		Font lf = new Font("Verdana", Font.BOLD, 15);
		rm = new JLabel("Room Number");
		rm.setFont(lf);
		fn = new JLabel("First Name");
		fn.setFont(lf);
		mn = new JLabel("Middle Name");
		mn.setFont(lf);
		ln = new JLabel("Last Name");
		ln.setFont(lf);
		g = new JLabel("Gender");
		g.setFont(lf);
		dob = new JLabel("Date of Birth");
		dob.setFont(lf);
		mail = new JLabel("Email");
		mail.setFont(lf);
		ad = new JLabel("Address");
		ad.setFont(lf);
		cn = new JLabel("Contact Number");
		cn.setFont(lf);
		nat = new JLabel("Nationality");
		nat.setFont(lf);
		psno = new JLabel("Passport Number");
		psno.setFont(lf);
		tr = new JLabel("Room type");
		tr.setFont(lf);
		sm = new JLabel("Smoking");
		sm.setFont(lf);
		nom = new JLabel("Number of Male");
		nom.setFont(lf);
		nof = new JLabel("Number of Female");
		nof.setFont(lf);
		noc = new JLabel("Number of Female");
		noc.setFont(lf);
		mop = new JLabel("Mode of Payment");
		mop.setFont(lf);
		disc = new JLabel("Discount");
		disc.setFont(lf);
		tp = new JLabel("Total Paid");
		tp.setFont(lf);
		chkdt = new JLabel("Check-In Date/Time");
		chkdt.setFont(lf);
		
	lrm = new JLabel("");
	lrm.setForeground(Color.red);
	lfn = new JLabel("");
	lfn.setForeground(Color.red);
	lmn = new JLabel("");
	lmn.setForeground(Color.red);
	lln = new JLabel("");
	lln.setForeground(Color.red);
	lg = new JLabel("");
	lg.setForeground(Color.red);
	ldob = new JLabel("");
	ldob.setForeground(Color.red);
	lmail = new JLabel("");
	lmail.setForeground(Color.red);
	lad = new JLabel("");
	lad.setForeground(Color.red);
	lcn = new JLabel("");
	lcn.setForeground(Color.red);
	lnat = new JLabel("");
	lnat.setForeground(Color.red);
	lpsno = new JLabel("");
	lpsno.setForeground(Color.red);
	ltr = new JLabel("");
	ltr.setForeground(Color.red);
	lsm = new JLabel("");
	lsm.setForeground(Color.red);
	lnom = new JLabel("");
	lnom.setForeground(Color.red);
	lnof = new JLabel("");
	lnof.setForeground(Color.red);
	lnoc = new JLabel("");
	lnoc.setForeground(Color.red);
	lmop = new JLabel("");
	lmop.setForeground(Color.red);
	ldisc = new JLabel("");
	ldisc.setForeground(Color.red);
	ltp = new JLabel("");
	ltp.setForeground(Color.red);
	lchkdt = new JLabel("");
	lchkdt.setForeground(Color.red);
	
	infopane.add(rm);
	infopane.add(lrm);
	infopane.add(fn);
	infopane.add(lfn);
	infopane.add(mn);
	infopane.add(lmn);
	infopane.add(ln);
	infopane.add(lln);
	infopane.add(g);
	infopane.add(lg);
	infopane.add(dob);
	infopane.add(ldob);
	infopane.add(ad);
	infopane.add(lad);
	infopane.add(cn);
	infopane.add(lcn);
	infopane.add(mail);
	infopane.add(lmail);
	infopane.add(nat);
	infopane.add(lnat);
	infopane.add(psno);
	infopane.add(lpsno);
	infopane.add(tr);
	infopane.add(ltr);
	infopane.add(sm);
	infopane.add(lsm);
	infopane.add(nom);
	infopane.add(lnom);
	infopane.add(nof);
	infopane.add(lnof);
	infopane.add(noc);
	infopane.add(lnoc);
	infopane.add(mop);
	infopane.add(lmop);
	infopane.add(disc);
	infopane.add(ldisc);
	infopane.add(tp);
	infopane.add(ltp);
	infopane.add(chkdt);
	infopane.add(lchkdt);
	
	btnsrch.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e)
    	{
    		int roomno = Integer.parseInt(txts.getText());
    		
    		try 
    		{
    			Class.forName("com.mysql.cj.jdbc.Driver");
    			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3310/hotelmanagement", "root", "root");
    			
    			Statement stmt = conn.createStatement();
    			
    			String sql = "SELECT * FROM CHECK_IN WHERE ROOM_NUMBER = " + roomno;
    			ResultSet rs = stmt.executeQuery(sql);
    			
    			while (rs.next()) 
    			{
    				lfn.setText(rs.getString("first_name"));
    				lmn.setText(rs.getString("middle_name"));
    				lln.setText(rs.getString("last_name"));
    				lg.setText(rs.getString("gender"));
    				ldob.setText(rs.getString("date_of_birth"));
    				lad.setText(rs.getString("address"));
    				lcn.setText(rs.getString("contact_number"));
    				lnat.setText(rs.getString("nationality"));
    				lpsno.setText(rs.getString("passport_number"));
    				ltr.setText(rs.getString("room_type"));
    				lsm.setText(rs.getString("smoking"));
    				lnom.setText(rs.getString("number_of_males"));
    				lnof.setText(rs.getString("number_of_females"));
    				lnoc.setText(rs.getString("number_of_children"));
    				lmop.setText(rs.getString("mode_of_payment"));
    				ldisc.setText(rs.getString("discount"));
    				ltp.setText(rs.getString("total_payment"));
    				lchkdt.setText(rs.getString("check_in_datetime"));
    				lmail.setText(rs.getString("email"));
    				lrm.setText(rs.getString("room_number"));
    			}
    			
    			JOptionPane.showMessageDialog(null,"Found");
    			conn.close();
    		}
    		catch(Exception ex) 
    		{
    			JOptionPane.showMessageDialog(null, "Error Occured\n" + ex.getMessage());
    		}
    	}
    });
	
	        btnremove = new JButton("Check-Out");
	        btnremove.setBounds(400,490,120,30);
	        btnremove.setFont(new Font("verdana", Font.BOLD, 15));
	        btnremove.setBackground(Color.black);
	        btnremove.setForeground(Color.gray);
	        rmgst.add(btnremove);
	        
	        btnremove.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e)
	        	{
	        		int roomno = Integer.parseInt(txts.getText());
	        		try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3310/hotelmanagement", "root", "root");
						
						Statement stmt = conn.createStatement();
						String sql = "DELETE FROM check_in where room_number = " + roomno;
						
						stmt.executeUpdate(sql);
						
						JOptionPane.showMessageDialog(null, "Check-out successfull !");
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, "Error Occured\n" + e1.getMessage());
					}
	        	}
	        });
	
			btncancel = new JButton("Cancel");
			btncancel.setBounds(520,490,120,30);
			btncancel.setFont(new Font("verdana", Font.BOLD, 15));
			btncancel.setBackground(Color.black);
			btncancel.setForeground(Color.gray);
			rmgst.add(btncancel);
			
			btncancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{
					rmgst.setVisible(false);
					displayLabel();
				}
			});
		
			btnclear = new JButton("Clear");
			btnclear.setBounds(620, 490, 120, 30);
			btnclear.setFont(new Font("Verdana", Font.BOLD, 15));
			btnclear.setForeground(Color.gray);
			btnclear.setBackground(Color.black);
			rmgst.add(btnclear);
			
			btnclear.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{
					lfn.setText("");
					lmn.setText("");
					lln.setText("");
					lg.setText("");
					ldob.setText("");
					lad.setText("");
					lcn.setText("");
					lnat.setText("");
					lpsno.setText("");
					ltr.setText("");
					lsm.setText("");
					lnom.setText("");
					lnof.setText("");
					lnoc.setText("");
					lmop.setText("");
					ldisc.setText("");
					ltp.setText("");
					lchkdt.setText("");
					lrm.setText("");
					lmail.setText("");
					txts.setText("");
				}
			});
	    }
	
	    public void listGuest()						//Guest-List
	    {
	        JLabel lblrmn, lblnm;
	        JTextField t1,t2;
	        JButton btnsrch1, btnsrch2, btnback, btndetail, btnrefresh;
	
	        hideLabel();
	        listPanelVisible();
	        Border blackLine = BorderFactory.createLineBorder(Color.black);
	        lstgst.setLayout(null);
	        lstgst.setBackground(new Color(51,204,255));
	        lstgst.setBounds(80,100,1250,550);
	        lstgst.setBorder(blackLine);
	        this.add(lstgst);
	
	        lblhead = new JLabel("Guest-List");
	        lblhead.setFont(new Font("algerian", Font.BOLD, 30));
	        lblhead.setBounds(550,20,300,40);
	        lblhead.setForeground(new Color(102,102,102));
	        lstgst.add(lblhead);
	        
	        JPanel tab = new JPanel();
	        tab.setLayout(new GridLayout(1,1));
	        tab.setBounds(240,70,950,400);
	        lstgst.add(tab);
	
	        //Creating Table
	        //For Table heading and content
	       
	        String[] heading = {"First Name", "Last Name", "Date of Birth", "Contact No.", "Address", "Room Number", "Check-In Date/Time"};
	        String[][] content = {
	        {"", "", "","", "","",""}
	        };
	
	        JTable jt = new JTable(content, heading);
	        jt.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
			jt.getColumnModel().getColumn(0).setPreferredWidth(150);
			jt.getColumnModel().getColumn(1).setPreferredWidth(150);
			jt.getColumnModel().getColumn(2).setPreferredWidth(150);
			jt.getColumnModel().getColumn(3).setPreferredWidth(150);
			jt.getColumnModel().getColumn(4).setPreferredWidth(150);
			jt.getColumnModel().getColumn(5).setPreferredWidth(150);
			jt.getColumnModel().getColumn(6).setPreferredWidth(150);
		
			jt.setAutoResizeMode( JTable.AUTO_RESIZE_OFF);
			jt.setRowHeight(25);
	        jt.setBounds(240,70,800,400);
	
	        JScrollPane jsp = new JScrollPane(jt, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
	        tab.add(jsp);
	
	        JPanel srch = new JPanel();
	        srch.setLayout(new GridLayout(8,1));
	        srch.setBounds(20,70,200,300);
	        srch.setBorder(blackLine);
	        srch.setBackground(Color.black);
	        lstgst.add(srch);
	
	        JLabel head = new JLabel("Search", JLabel.CENTER);
	        head.setFont(new Font("verdana", Font.BOLD, 15));
	        head.setForeground(Color.blue);
	        srch.add(head);
	
	        lblrmn = new JLabel("Enter Room No.", JLabel.CENTER);
	        lblrmn.setForeground(Color.gray);
	        srch.add(lblrmn);
	        t1 = new JTextField();
	        t1.setFont(new Font("verdana", Font.BOLD, 15));
	        srch.add(t1);
	
	        btnsrch1 = new JButton("Search");
	        btnsrch1.setForeground(Color.gray);
	        btnsrch1.setBackground(Color.black);
	        btnsrch1.setFont(new Font("verdana", Font.BOLD, 15));
	        srch.add(btnsrch1);
	        btnsrch1.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e)
	        	{
	        		try
	        		{
	        			Class.forName("com.mysql.cj.jdbc.Driver");
	        			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3310/hotelmanagement", "root", "root");
	        			
	        			String sql = "SELECT first_name, last_name, date_of_birth, contact_number, address, room_number, check_in_datetime from check_in where room_number = " + t1.getText();
	        			PreparedStatement ps = conn.prepareStatement(sql);
	        			
	        			ResultSet rs = ps.executeQuery();
	        			jt.setModel(DbUtils.resultSetToTableModel(rs));
	        			
	        			jt.getColumnModel().getColumn(0).setPreferredWidth(150);
						jt.getColumnModel().getColumn(1).setPreferredWidth(150);
						jt.getColumnModel().getColumn(2).setPreferredWidth(150);
						jt.getColumnModel().getColumn(3).setPreferredWidth(150);
						jt.getColumnModel().getColumn(4).setPreferredWidth(150);
						jt.getColumnModel().getColumn(5).setPreferredWidth(150);
						jt.getColumnModel().getColumn(6).setPreferredWidth(150);
					
						jt.setAutoResizeMode( JTable.AUTO_RESIZE_OFF);
						jt.setRowHeight(25);
						jt.setBackground(Color.black);
						jt.setForeground(Color.LIGHT_GRAY);
						
	        		}
	        		catch(Exception ex)
	        		{
	        			JOptionPane.showMessageDialog(null, ex);
	        		}
	        	}
	        });
	
	        JLabel or = new JLabel("OR", JLabel.CENTER);
	        or.setForeground(Color.gray);
	        srch.add(or);
	
	        lblnm = new JLabel("Name", JLabel.CENTER);
	        lblnm.setForeground(Color.gray);
	        srch.add(lblnm);
	        t2 = new JTextField();
	        t2.setFont(new Font("verdana", Font.BOLD, 15));
	        srch.add(t2);
	
	        btnsrch2 = new JButton("Search");
	        btnsrch2.setForeground(Color.gray);
	        btnsrch2.setBackground(Color.black);
	        btnsrch2.setFont(new Font("verdana", Font.BOLD, 15));
	        srch.add(btnsrch2);
	        
	        btnsrch2.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e)
	        	{
	        		try
	        		{
	        			Class.forName("com.mysql.cj.jdbc.Driver");
	        			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3310/hotelmanagement", "root", "root");
	        			
	        			String sql = "SELECT first_name, last_name, date_of_birth, contact_number, address, room_number, check_in_datetime from check_in where first_name = '" + t2.getText() + "'";
	        			PreparedStatement ps = conn.prepareStatement(sql);
	        			
	        			ResultSet rs = ps.executeQuery();
	        			jt.setModel(DbUtils.resultSetToTableModel(rs));
	        			
	        			jt.getColumnModel().getColumn(0).setPreferredWidth(150);
						jt.getColumnModel().getColumn(1).setPreferredWidth(150);
						jt.getColumnModel().getColumn(2).setPreferredWidth(150);
						jt.getColumnModel().getColumn(3).setPreferredWidth(150);
						jt.getColumnModel().getColumn(4).setPreferredWidth(150);
						jt.getColumnModel().getColumn(5).setPreferredWidth(150);
						jt.getColumnModel().getColumn(6).setPreferredWidth(150);
					
						jt.setAutoResizeMode( JTable.AUTO_RESIZE_OFF);
						jt.setRowHeight(25);
						jt.setBackground(Color.black);
						jt.setForeground(Color.LIGHT_GRAY);
						
	        		}
	        		catch(Exception ex)
	        		{
	        			JOptionPane.showMessageDialog(null, ex);
	        		}
	        	}
	        });
	
		Font bf = new Font("Verdana", Font.BOLD, 15);
		
		btnrefresh = new JButton("Refresh");
		btnrefresh.setFont(bf);
		btnrefresh.setForeground(Color.gray);
		btnrefresh.setBackground(Color.black);
		btnrefresh.setBounds(500, 500, 100, 30);
		
		btnrefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3310/hotelmanagement", "root", "root");
					
					String sql = "SELECT first_name, last_name, date_of_birth, contact_number, address, room_number, check_in_datetime from check_in";
					PreparedStatement pst = conn.prepareStatement(sql);
					
					ResultSet rs = pst.executeQuery(sql);
					
					jt.setModel(DbUtils.resultSetToTableModel(rs));
					jt.getColumnModel().getColumn(0).setPreferredWidth(150);
					jt.getColumnModel().getColumn(1).setPreferredWidth(150);
					jt.getColumnModel().getColumn(2).setPreferredWidth(150);
					jt.getColumnModel().getColumn(3).setPreferredWidth(150);
					jt.getColumnModel().getColumn(4).setPreferredWidth(150);
					jt.getColumnModel().getColumn(5).setPreferredWidth(150);
					jt.getColumnModel().getColumn(6).setPreferredWidth(150);
				
					jt.setAutoResizeMode( JTable.AUTO_RESIZE_OFF);
					jt.setRowHeight(25);
					jt.setBackground(Color.black);
					jt.setForeground(Color.LIGHT_GRAY);
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, "Error Occured\n" + e1.getMessage());
				}
			}
		});
	
		btndetail = new JButton("Detailed");
		btndetail.setFont(bf);
		btndetail.setForeground(Color.gray);
		btndetail.setBackground(Color.black);
		btndetail.setBounds(600,500,120,30);
		
		btndetail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				new detailed();
			}
		});
	
		btnback = new JButton("Back");
		btnback.setFont(bf);
		btnback.setForeground(Color.gray);
		btnback.setBackground(Color.black);
		btnback.setBounds(720,500,100,30);
		
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				lstgst.setVisible(false);
				displayLabel();
			}
		});
		
		JButton btnclr = new JButton("Clear");
		btnclr.setFont(bf);
		btnclr.setForeground(Color.gray);
		btnclr.setBackground(Color.black);
		btnclr.setBounds(820,500,100,30);
		btnclr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				t1.setText("");
				t2.setText("");
			}
		});
		
		lstgst.add(btnrefresh);
		lstgst.add(btndetail);
		lstgst.add(btnback);
		lstgst.add(btnclr);
	    }
	
	    void checkRooms()							//Checking rooms for availability
	    {
	        JLabel lblhd, lblsrch;
	        JTextField txtsrch;
	        JButton btnsrch, btnref, btnback;
	
	        hideLabel();
	        checkRoomPanelVisible();
	        Border grayLine = BorderFactory.createLineBorder(Color.gray);
	        crooms.setLayout(null);
	        crooms.setBackground(new Color(39, 197, 252));
	        crooms.setBounds(80,100,1250,550);
	        crooms.setBorder(grayLine);
	        this.add(crooms);
	
	        lblhd = new JLabel("Check Rooms Availability");
	        lblhd.setFont(new Font("algerian", Font.BOLD, 30));
	        lblhd.setForeground(Color.gray);
	        lblhd.setBounds(400,20,450,40);
	        crooms.add(lblhd);
	
	        JPanel srch = new JPanel();
	        srch.setLayout(new GridLayout(3,1));
	        srch.setBounds(20,70,200,100);
	        srch.setBorder(grayLine);
	        srch.setBackground(Color.black);
	        crooms.add(srch);
	        
	        JPanel tablePane = new JPanel();
			tablePane.setLayout(new GridLayout(1,1));
			tablePane.setBounds(250, 70, 800,400);
			crooms.add(tablePane);
	        
	        //For Table
			JTable avroom = new JTable();
			avroom.setFont(new Font("Times New Roman", Font.BOLD, 15));
			avroom.setRowHeight(25);
			JScrollPane js = new JScrollPane(avroom, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
			tablePane.add(js);
	
	        lblsrch = new JLabel("Search by Room Type");
	        lblsrch.setForeground(Color.gray);
	        txtsrch = new JTextField();
	        txtsrch.setForeground(Color.gray);
	        txtsrch.setFont(new Font("verdana", Font.PLAIN, 13));
	        srch.add(lblsrch);
	        srch.add(txtsrch);
	
	        btnsrch = new JButton("Search");
	        btnsrch.setForeground(Color.gray);
	        btnsrch.setFont(new Font("verdana", Font.PLAIN, 15));
	        btnsrch.setBackground(Color.black);
	        srch.add(btnsrch);
	        btnsrch.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e)
	        	{
	        		try
	        		{
	        			Class.forName("com.mysql.cj.jdbc.Driver");
	        			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3310/hotelmanagement","root", "root");
	        			
	        			String sql = "Select * from available_rooms where room_type = '" + txtsrch.getText() + "'";
	        			PreparedStatement ps = conn.prepareStatement(sql);
	        			
	        			ResultSet rs = ps.executeQuery();
	        			avroom.setModel(DbUtils.resultSetToTableModel(rs));
	        			
	        			avroom.getColumnModel().getColumn(0).setPreferredWidth(270);
						avroom.getColumnModel().getColumn(1).setPreferredWidth(270);
						avroom.getColumnModel().getColumn(2).setPreferredWidth(270);
						
					
						avroom.setAutoResizeMode( JTable.AUTO_RESIZE_OFF);
						avroom.setRowHeight(25);
						avroom.setBackground(Color.black);
						avroom.setForeground(Color.LIGHT_GRAY);
	        		}
	        		catch(Exception ex)
	        		{
	        			JOptionPane.showMessageDialog(null, "Error Occured\n" + ex.getMessage());
	        		}
	        	}
	        });
	
	        btnref = new JButton("Refresh");
	        btnref.setBackground(Color.black);
	        btnref.setForeground(Color.gray);
	        btnref.setBounds(500,500,100,30);
	        crooms.add(btnref);
	        btnref.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e)
	        	{
	        		try 
	        		{
	        			Class.forName("com.mysql.cj.jdbc.Driver");
	        			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3310/hotelmanagement", "root", "root");
	        			
	        			String sql = "SELECT * FROM available_rooms";
	        			PreparedStatement ps = conn.prepareStatement(sql);
	        			
	        			ResultSet rs = ps.executeQuery();
	        			avroom.setModel(DbUtils.resultSetToTableModel(rs));
	        			
						avroom.getColumnModel().getColumn(0).setPreferredWidth(270);
						avroom.getColumnModel().getColumn(1).setPreferredWidth(270);
						avroom.getColumnModel().getColumn(2).setPreferredWidth(270);
						
					
						avroom.setAutoResizeMode( JTable.AUTO_RESIZE_OFF);
						avroom.setRowHeight(25);
						avroom.setBackground(Color.black);
						avroom.setForeground(Color.LIGHT_GRAY);
	        		}
	        		catch(Exception ex)
	        		{
	        			JOptionPane.showMessageDialog(null, "Error Occured\n" + ex.getMessage());
	        		}
	        	}
	        });
	
	        btnback = new JButton("Back");
	        btnback.setBackground(Color.black);
	        btnback.setForeground(Color.gray);
	        btnback.setBounds(600,500,100,30);
	        crooms.add(btnback);
	        btnback.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e)
	        	{
	        		crooms.setVisible(false);
					displayLabel();
	        	}
	        });
	    }
	
	    mainFrame()
	    {
	        new JFrame();
	        setTitle("Management");
	        setLocation(-5,1);
	        setSize(1370,730);
	        setVisible(true);
	        setLayout(null);
	
	        Border blueLine = BorderFactory.createLineBorder(Color.blue);
	
	        JPanel usrpane = new JPanel();
	        usrpane.setBounds(0,0,1370,90);
	        usrpane.setLayout(null);
	        usrpane.setVisible(true);
	        usrpane.setBackground(Color.black);
	
	        ImageIcon usricon = new ImageIcon("imgs/user_.png");
	        Image usrimage = usricon.getImage();
	        Image newimg = usrimage.getScaledInstance(70,70,Image.SCALE_SMOOTH);
	        usricon = new ImageIcon(newimg);
	
	        uicon = new JLabel(usricon);
	        uicon.setBounds(900,2,90,90);
	        usrpane.add(uicon);
	
	        uname = new JLabel(login.sendname);
	        uname.setFont(new Font("verdana", Font.BOLD, 40));
	        uname.setForeground(new Color(255,153,0));
	        uname.setBounds(1000,15,350,50);
	        usrpane.add(uname);
	        add(usrpane);
	        
	        JLabel ufname = new JLabel(login.fname + " " + login.lname);
	        ufname.setBounds(1100, 60, 200, 25);
	        ufname.setFont(new Font("Verdana", Font.BOLD, 20));
	        ufname.setForeground(Color.blue);
	        usrpane.add(ufname);
	        
	        JPanel sBar = new JPanel();
	        sBar.setSize(70,150);
	        sBar.setLayout(new GridLayout(5,1));
	        sBar.setBounds(0,150,70,400);
	        add(sBar);
	
	        ImageIcon pic1 = new ImageIcon("imgs/check.png");
	        Image image1 = pic1.getImage();
	        Image newImg1 = image1.getScaledInstance(50,50,Image.SCALE_SMOOTH);
	        pic1 = new ImageIcon(newImg1);
	
	        ImageIcon pic2 = new ImageIcon("imgs/remove-user.png");
	        Image image2 = pic2.getImage();
	        Image newImg2 = image2.getScaledInstance(50,50,Image.SCALE_SMOOTH);
	        pic2 = new ImageIcon(newImg2);
	
	        ImageIcon pic3 = new ImageIcon("imgs/log-out.png");
	        Image image3 = pic3.getImage();
	        Image newImg3 = image3.getScaledInstance(50,50,Image.SCALE_SMOOTH);
	        pic3 = new ImageIcon(newImg3);
	
	        ImageIcon pic4 = new ImageIcon("imgs/exit.png");
	        Image image4 = pic4.getImage();
	        Image newImg4 = image4.getScaledInstance(50,50,Image.SCALE_SMOOTH);
	        pic4 = new ImageIcon(newImg4);
	
	        ImageIcon pic5 = new ImageIcon("imgs/user.png");
	        Image image5 = pic5.getImage();
	        Image newImg5 = image5.getScaledInstance(50,50,Image.SCALE_SMOOTH);
	        pic5 = new ImageIcon(newImg5);
	
	        btnchkin = new JButton(pic1);
	        btnchkin.setToolTipText("Check-In");
		btnchkin.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				addGuest();
			}
		});
	
	        btnchkout = new JButton(pic2);
	        btnchkout.setToolTipText("Check-Out");
		btnchkout.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				removeGuest();
			}
		});
	
	        btnlist = new JButton(pic5);
	        btnlist.setToolTipText("Guest-List");
		btnlist.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				listGuest();
			}
		});
	
	        btnlgout = new JButton(pic3);
	        btnlgout.setToolTipText("Logout");
		btnlgout.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				dispose();
				new login();
			}
		});
	
	        btnexit = new JButton(pic4);
	        btnexit.setToolTipText("Exit");
		btnexit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
	
	        sBar.add(btnchkin);
	        sBar.add(btnchkout);
	        sBar.add(btnlist);
	        sBar.add(btnlgout);
	        sBar.add(btnexit);
	
	        l1 = new JLabel("HOTEL");
	        l1.setFont(new Font("Times New Roman", Font.BOLD, 70));
	        l1.setForeground(Color.red);
	        l1.setBounds(420,250,500,80);
	        l2 = new JLabel("MANAGEMENT");
	        l2.setFont(new Font("Times New Roman", Font.BOLD, 70));
	        l2.setForeground(Color.red);
	        l2.setBounds(320,370,550,80);
	        add(l1);
	        add(l2);
	
	        ImageIcon pic = new ImageIcon("imgs/hotel.png");
	        Image img = pic.getImage();
	        Image newimg_ = img.getScaledInstance(200,200,Image.SCALE_SMOOTH);
	        pic = new ImageIcon(newimg_);
	
	        lblImg = new JLabel(pic);
	        lblImg.setBounds(850,150,400,400);
	        add(lblImg);
	
	        //Creating  Menu
	        MenuBar main = new MenuBar();
	        setMenuBar(main);
	
	        Menu home = new Menu("Home");
	        Menu guest = new Menu("Guest");
	        Menu rooms = new Menu("Rooms");
	        main.add(home);
	        main.add(guest);
	        main.add(rooms);
	
	        //Home Menu Items
	        MenuItem logout = new MenuItem("Logout");
	        logout.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
				{
					dispose();
					new login();
				}
		});
	
	        MenuItem line = new MenuItem("-");
	        MenuItem exit = new MenuItem("Exit");
	        exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		});
	    
	        MenuItem reg = new MenuItem("Register");
	        reg.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e)
	        	{
	        		dispose();
	        		new register();
	        	}
	        });
	        home.add(reg);
	        home.add(logout);
	        home.add(line);
	        home.add(exit);
	
	        //Guest Menu Items
	        MenuItem add = new MenuItem("Check-In");
		add.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				addGuest();
			}
		});
	
	        MenuItem remove = new MenuItem("Check-Out");
		remove.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				removeGuest();
			}
		});
	
	        MenuItem list = new MenuItem("Guest-List");
		list.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				listGuest();
			}
		});
		
		MenuItem allgst = new MenuItem("All-Guests");
		allgst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				new allguests();
			}
		});
	
	        guest.add(add);
	        guest.add(remove);
	        guest.add(list);
	        guest.add(allgst);
	
	        //Rooms Menu Items
	        MenuItem chkav = new MenuItem("Availability");
		chkav.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				checkRooms();
			}
		});
	
	        rooms.add(chkav);
		addWindowListener(this);
	    }
		
	
	public void windowClosing(WindowEvent arg0) {  
		
		System.exit(0);
	   
	}  
	
	public void windowDeiconified(WindowEvent arg0)
	{  
		JOptionPane.showMessageDialog(null, "Welcome Back");
	}  
	
	public void windowClosed(WindowEvent arg0) {  }  
	public void windowDeactivated(WindowEvent arg0) {  }  
	public void windowActivated(WindowEvent e){  }
	public void windowIconified(WindowEvent arg0) {  }  
	public void windowOpened(WindowEvent arg0) {  }  


	public static void main(String[] args) {
		
		new mainFrame();
	}

}
