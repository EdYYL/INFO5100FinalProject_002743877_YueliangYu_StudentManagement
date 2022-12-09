package User;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import javax.swing.JLabel;
import javax.swing.JTextField;

import db.dbConn;

import javax.swing.*;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 

 * Description: Add user
 * 

 */

public class UserAddFrame extends JFrame {
	JPanel contentPane;
	String level;
	JLabel jLabel1 = new JLabel();
	JLabel jLabel2 = new JLabel();
	JLabel jLabel3 = new JLabel();
	JLabel jLabel4 = new JLabel();
	JTextField jTextField1 = new JTextField();
	JPasswordField jPasswordField1 = new JPasswordField();
	JPasswordField jPasswordField2 = new JPasswordField();
	JButton jButton1 = new JButton();
	JButton jButton2 = new JButton();
	JOptionPane jOptionPane1 = new JOptionPane();

	public UserAddFrame() {
		try {
			jbInit();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	private void jbInit() throws Exception {
		contentPane = (JPanel) getContentPane();
		contentPane.setLayout(null);
		setSize(new Dimension(469, 315));
		setTitle("Add User");
		jLabel1.setFont(new java.awt.Font("Dialog", Font.BOLD, 23));
		jLabel1.setText("Add User");
		jLabel1.setBounds(new Rectangle(134, 12, 198, 27));
		jLabel2.setFont(new java.awt.Font("Dialog", Font.PLAIN, 18));
		jLabel2.setText("Username:");
		jLabel2.setBounds(new Rectangle(90, 66, 68, 22));
		jLabel3.setFont(new java.awt.Font("Dialog", Font.PLAIN, 18));
		jLabel3.setText("Password:");
		jLabel3.setBounds(new Rectangle(90, 118, 75, 27));
		jLabel4.setFont(new java.awt.Font("Dialog", Font.PLAIN, 18));
		jLabel4.setText("Confirm pwd:");
		jLabel4.setBounds(new Rectangle(84, 167, 89, 29));
		jTextField1.setFont(new java.awt.Font("Dialog", Font.PLAIN, 13));
		jTextField1.setBorder(BorderFactory.createLoweredBevelBorder());
		jTextField1.setBounds(new Rectangle(191, 65, 155, 24));
		jPasswordField1.setBorder(BorderFactory.createLoweredBevelBorder());
		jPasswordField1.setBounds(new Rectangle(191, 119, 155, 24));
		jPasswordField2.setBorder(BorderFactory.createLoweredBevelBorder());
		jPasswordField2.setText("");
		jPasswordField2.setBounds(new Rectangle(191, 169, 155, 24));
		jButton1.setBounds(new Rectangle(99, 225, 89, 25));
		jButton1.setFont(new java.awt.Font("Dialog", Font.PLAIN, 13));
		jButton1.setBorder(BorderFactory.createRaisedBevelBorder());
		jButton1.setText("Submit");
		jButton1.addActionListener(new AddAdminFrame_jButton1_actionAdapter(this));
		jButton2.setBounds(new Rectangle(267, 225, 89, 25));
		jButton2.setFont(new java.awt.Font("Dialog", Font.PLAIN, 13));
		jButton2.setBorder(BorderFactory.createRaisedBevelBorder());
		jButton2.setText("Exit");
		jButton2.addActionListener(new AddAdminFrame_jButton2_actionAdapter(this));
		jOptionPane1.setBounds(new Rectangle(0, 233, 262, 90));
		jOptionPane1.setLayout(null);
		contentPane.add(jLabel2);
		contentPane.add(jLabel3);
		contentPane.add(jLabel4);
		contentPane.add(jTextField1);
		contentPane.add(jPasswordField2);
		contentPane.add(jPasswordField1);
		contentPane.add(jButton1);
		contentPane.add(jButton2);
		contentPane.add(jLabel1);
		contentPane.add(jOptionPane1);
	}

	// exit
	public void jButton2_actionPerformed(ActionEvent e) {
		this.dispose();
	}

	// add
	public void jButton1_actionPerformed(ActionEvent e) {
		boolean zhi = false;

		if (jTextField1.getText().length() == 0) {
			jOptionPane1.showMessageDialog(this, "The username cannot be empty！", "Notice", JOptionPane.INFORMATION_MESSAGE, null);
		} else if (jPasswordField2.getText().trim().equals(jPasswordField1.getText().trim())) {
			zhi = true;
		} else {
			jOptionPane1.showMessageDialog(this, "Wrong password！", "Notice", JOptionPane.INFORMATION_MESSAGE, null);
		}
		if (zhi) {
			try {

				boolean name = false;
				dbConn conn = new dbConn();
				ResultSet rs = conn.getRs("select userName from tb_user");
				while (rs.next()) {
					if (jTextField1.getText().trim().equals(rs.getString("userName").trim())) {
						name = true;
					}
				}
				if (name) {
					jOptionPane1.showMessageDialog(this, "This username already exists！", "Notice", JOptionPane.INFORMATION_MESSAGE, null);
				} else {
					// 不存在则添加
					conn.getUpdate("insert into tb_user (userName,userPwd,userType) values ('"
							+ jTextField1.getText().trim() + "','" + jPasswordField2.getText().trim() + "','2')");
					jOptionPane1.showMessageDialog(this, "Add successfully！", "Notice", JOptionPane.INFORMATION_MESSAGE, null);
				}
				rs.close();
			} catch (Exception ce) {
				System.out.println(ce);
			}
		}
	}
}

class AddAdminFrame_jButton1_actionAdapter implements ActionListener {
	private UserAddFrame adaptee;

	AddAdminFrame_jButton1_actionAdapter(UserAddFrame adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.jButton1_actionPerformed(e);
	}
}

class AddAdminFrame_jButton2_actionAdapter implements ActionListener {
	private UserAddFrame adaptee;

	AddAdminFrame_jButton2_actionAdapter(UserAddFrame adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.jButton2_actionPerformed(e);
	}
}
