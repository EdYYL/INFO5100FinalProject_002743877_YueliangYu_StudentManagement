package Course;

import java.awt.Font;
import javax.swing.JFrame;
import com.borland.jbcl.layout.XYLayout;

import db.dbConn;

import com.borland.jbcl.layout.*;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;

/**
 * 

 * Description: Course update
 * 

 */

public class CourseChange extends JFrame {
	XYLayout xYLayout1 = new XYLayout();
	JLabel jLabel1 = new JLabel();
	JLabel jLabel2 = new JLabel();
	JLabel jLabel3 = new JLabel();
	JLabel jLabel5 = new JLabel();
	JTextField jTextField1 = new JTextField();
	JComboBox jComboBox1 = new JComboBox();
	JTextField jTextField2 = new JTextField();
	JButton jButton1 = new JButton();
	JButton jButton3 = new JButton();
	dbConn sta = new dbConn();
	JOptionPane jOptionPane1 = new JOptionPane();
	int csid;
	int kefind;

	public CourseChange(int find) {
		kefind = find;
		try {
			jbInit();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	private void jbInit() throws Exception {
		getContentPane().setLayout(xYLayout1);
		xYLayout1.setWidth(500);
		xYLayout1.setHeight(350);
		jLabel1.setFont(new java.awt.Font("新宋体", Font.BOLD, 20));
		jLabel1.setText("Course Update ");
		jButton3.addActionListener(new CourseManager_jButton3_actionAdapter(this));
		jButton1.addActionListener(new CourseManager_jButton1_actionAdapter(this));
		jTextField2.setFont(new java.awt.Font("Dialog", Font.PLAIN, 16));
		jComboBox1.setFont(new java.awt.Font("Dialog", Font.PLAIN, 16));
		jTextField1.setFont(new java.awt.Font("Dialog", Font.PLAIN, 16));
		jButton3.setFont(new java.awt.Font("Dialog", Font.PLAIN, 16));
		jButton3.setText("Exit");
		jButton1.setFont(new java.awt.Font("Dialog", Font.PLAIN, 16));
		jButton1.setText("Update");
		jLabel5.setFont(new java.awt.Font("Dialog", Font.PLAIN, 16));
		jLabel5.setText("Credit：");
		jLabel3.setFont(new java.awt.Font("Dialog", Font.PLAIN, 16));
		jLabel3.setText("major：");
		this.getContentPane().add(jComboBox1, new XYConstraints(200, 130, 140, 30));
		this.getContentPane().add(jTextField2, new XYConstraints(200, 180, 140, 30));
		this.getContentPane().add(jLabel2, new XYConstraints(85, 80, 80, 30));
		this.getContentPane().add(jLabel5, new XYConstraints(85, 180, 80, 30));
		this.getContentPane().add(jLabel3, new XYConstraints(85, 130, 80, 30));
		this.getContentPane().add(jTextField1, new XYConstraints(200, 80, 140, 30));
		this.getContentPane().add(jLabel1, new XYConstraints(158, 21, -1, 49));
		this.getContentPane().add(jButton1, new XYConstraints(130, 230, 90, 30));
		this.getContentPane().add(jButton3, new XYConstraints(295, 230, 90, 30));
		jLabel2.setFont(new java.awt.Font("Dialog", Font.PLAIN, 16));
		jLabel2.setText("Course Name：");
		this.setTitle("Course Update and Delete");
		jComboBox1.addItem("Select");
		// 选择专业
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
		setF();
	}

	// show default value
	public void setF() {
		if (kefind < 0)
			return;
		else {
			try {
				ResultSet rs = sta.getRs("select * from tb_cource where courceId='" + Integer.valueOf(kefind) + "'");
				while (rs.next()) {
					jComboBox1.setSelectedItem(String.valueOf(rs.getString("courceSpecName")));
					jTextField1.setText(rs.getString("courceName").trim());
					jTextField2.setText(rs.getString("courceHour").trim());
				}
				rs.close();
			} catch (Exception ce) {
				System.out.println("++++++++" + ce);
			}
		}
	}

	// exit
	public void jButton3_actionPerformed(ActionEvent e) {
		this.dispose();
	}

	// update
	public void jButton1_actionPerformed(ActionEvent e) {
		String keCName, zyName, tName, xueFen;
		keCName = jTextField1.getText().trim();
		zyName = String.valueOf(jComboBox1.getSelectedItem());
		xueFen = jTextField2.getText().trim();
		try {
			sta.getUpdate("update tb_cource set courceSpecName='" + zyName + "', courceName='" + keCName
					+ "',courceHour='" + Float.valueOf(xueFen) + "' where courceId='" + kefind + "'");
			jOptionPane1.showMessageDialog(this, "Update successfully！", "notice", JOptionPane.INFORMATION_MESSAGE, null);
		} catch (Exception a) {
			System.out.println(a.getMessage());
		}
	}
}

class CourseManager_jButton1_actionAdapter implements ActionListener {
	private CourseChange adaptee;

	CourseManager_jButton1_actionAdapter(CourseChange adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.jButton1_actionPerformed(e);
	}
}

class CourseManager_jButton3_actionAdapter implements ActionListener {
	private CourseChange adaptee;

	CourseManager_jButton3_actionAdapter(CourseChange adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.jButton3_actionPerformed(e);
	}
}
