package Course;

import java.awt.Dimension;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import javax.swing.JLabel;
import javax.swing.JTextField;

import db.dbConn;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 

 * Description: input course
 * 

 */

public class CourseAddFrame extends JFrame {
	JPanel contentPane;
	JLabel jLabel1 = new JLabel();
	int FS, spid, FC;
	JLabel jLabel3 = new JLabel();
	JLabel jLabel4 = new JLabel();
	String IS;
	JTextField jTextField2 = new JTextField();
	JTextField jTextField3 = new JTextField();
	JButton jButton1 = new JButton();
	JButton jButton2 = new JButton();
	JOptionPane jOptionPane1 = new JOptionPane();
	JLabel jLabel6 = new JLabel();
	JComboBox jComboBox1 = new JComboBox();
	dbConn sta = new dbConn();

	public CourseAddFrame() {
		try {
			jbInit();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	private void jbInit() throws Exception {
		contentPane = (JPanel) getContentPane();
		contentPane.setLayout(null);
		setSize(new Dimension(482, 300));
		setTitle("Add Course");
		jLabel1.setFont(new java.awt.Font("Dialog", Font.PLAIN, 20));
		jLabel1.setText("Add Course");
		jLabel1.setBounds(new Rectangle(178, 17, 126, 25));
		jLabel3.setFont(new java.awt.Font("Dialog", Font.PLAIN, 16));
		jLabel3.setText("Course Name£º");
		jLabel3.setBounds(new Rectangle(75, 70, 81, 21));
		jLabel4.setFont(new java.awt.Font("Dialog", Font.PLAIN, 16));
		jLabel4.setText("Credit£º");
		jLabel4.setBounds(new Rectangle(75, 170, 77, 21));
		jTextField2.setFont(new java.awt.Font("Dialog", Font.PLAIN, 16));
		jTextField2.setBorder(BorderFactory.createLoweredBevelBorder());
		jTextField2.setText("");
		jTextField2.setBounds(new Rectangle(190, 70, 184, 26));
		jTextField3.setFont(new java.awt.Font("Dialog", Font.PLAIN, 18));
		jTextField3.setBorder(BorderFactory.createLoweredBevelBorder());
		jTextField3.setText("");
		jTextField3.setBounds(new Rectangle(190, 170, 94, 26));
		jButton1.setBounds(new Rectangle(103, 240, 90, 29));
		jButton1.setFont(new java.awt.Font("Dialog", Font.PLAIN, 16));
		jButton1.setBorder(BorderFactory.createRaisedBevelBorder());
		jButton1.setText("Submit");
		jButton1.addActionListener(new CourseAddFrame_jButton1_actionAdapter(this));
		jButton2.setBounds(new Rectangle(277, 240, 90, 29));
		jButton2.setFont(new java.awt.Font("Dialog", Font.PLAIN, 16));
		jButton2.setBorder(BorderFactory.createRaisedBevelBorder());
		jButton2.setText("Exit");
		jButton2.addActionListener(new CourseAddFrame_jButton2_actionAdapter(this));
		jOptionPane1.setBounds(new Rectangle(75, 261, 262, 90));
		jOptionPane1.setLayout(null);
		jLabel6.setFont(new java.awt.Font("Dialog", Font.PLAIN, 16));
		jLabel6.setText("major£º");
		jLabel6.setBounds(new Rectangle(75, 120, 82, 21));
		jComboBox1.setFont(new java.awt.Font("Dialog", Font.PLAIN, 16));
		jComboBox1.setBounds(new Rectangle(190, 120, 160, 25));
		contentPane.add(jLabel1);
		contentPane.add(jButton1);
		contentPane.add(jButton2);
		contentPane.add(jOptionPane1);
		contentPane.add(jTextField3);
		contentPane.add(jLabel4);
		contentPane.add(jLabel3);
		contentPane.add(jTextField2);
		contentPane.add(jComboBox1);
		contentPane.add(jLabel6);
		jComboBox1.addItem("Select");

		try {
			ResultSet rs = sta.getRs("select * from tb_spec");
			while (rs.next()) {
				String xibu = rs.getString("specName");
				jComboBox1.addItem(xibu);
			}
			rs.close();
		} catch (Exception ce) {
			System.out.println("++++++++" + ce);
		}
	}


	public void InC() {

		if (jTextField2.getText().length() == 0) {
			jOptionPane1.showMessageDialog(this, "The course name cannot be empty£¡", "notice", JOptionPane.INFORMATION_MESSAGE, null);
		} else if (jComboBox1.getSelectedIndex() == 0) {
			jOptionPane1.showMessageDialog(this, "Please select the department£¡", "notice", JOptionPane.INFORMATION_MESSAGE, null);
		} else if (jTextField3.getText().length() == 0) {
			jOptionPane1.showMessageDialog(this, "The course credit cannot be empty£¡", "notice", JOptionPane.INFORMATION_MESSAGE, null);
		} else {
			try {
				boolean name = false;
				ResultSet rs = sta.getRs("select courceName from tb_cource");
				while (rs.next()) {
					if (jTextField2.getText().trim().equals(rs.getString("courceName").trim())) {
						name = true;
					}
				}
				if (name) {
					jOptionPane1.showMessageDialog(this, "The course name has already existed£¡", "notice", JOptionPane.INFORMATION_MESSAGE, null);
				} else {
					sta.getUpdate("insert into tb_cource (courceName,courceHour,courceSpecName) values ('"
							+ jTextField2.getText().trim() + "','" + Float.valueOf(jTextField3.getText().trim()) + "','"
							+ String.valueOf(jComboBox1.getSelectedItem()) + "')");
					jOptionPane1.showMessageDialog(this, "Submit successfully£¡", "notice", JOptionPane.INFORMATION_MESSAGE, null);
				}
				rs.close();
			} catch (Exception ce) {
				System.out.println("--------" + ce);
			}
		}
	}

	public void jButton1_actionPerformed(ActionEvent e) {
		InC();
	}

	public void jButton2_actionPerformed(ActionEvent e) {
		this.dispose();
	}
}

class CourseAddFrame_jButton1_actionAdapter implements ActionListener {
	private CourseAddFrame adaptee;

	CourseAddFrame_jButton1_actionAdapter(CourseAddFrame adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.jButton1_actionPerformed(e);
	}
}

class CourseAddFrame_jButton2_actionAdapter implements ActionListener {
	private CourseAddFrame adaptee;

	CourseAddFrame_jButton2_actionAdapter(CourseAddFrame adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.jButton2_actionPerformed(e);
	}
}
