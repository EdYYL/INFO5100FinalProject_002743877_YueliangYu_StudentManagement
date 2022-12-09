package Course;

import java.awt.Font;

import com.borland.jbcl.layout.XYLayout;

import db.dbConn;

import com.borland.jbcl.layout.*;
import stuManager.MainFrame;

import javax.swing.*;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import java.util.*;
import java.awt.*;

/**
 * 

 * Description: Course Management
 * 

 */

public class CourseManager extends JFrame {
	XYLayout xYLayout1 = new XYLayout();
	JLabel jLabel1 = new JLabel();
	JScrollPane jScrollPane1 = new JScrollPane();
	JButton jButton1 = new JButton();
	JButton jButton2 = new JButton();
	XYLayout xYLayout2 = new XYLayout();
	JTable jTable1 = new JTable();
	ButtonGroup buttonGroup1 = new ButtonGroup();
	dbConn sta = new dbConn();
	String sql;
	Object[][] arrData = {};
	String[] arrField = { "course number", "major", "course name", "course credit" };
	DefaultTableModel model = new DefaultTableModel();
	int intRow;
	static int find;
	JOptionPane jOptionPane1 = new JOptionPane();
	JButton jButton6 = new JButton();

	public CourseManager() {
		try {
			jbInit();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	private void jbInit() throws Exception {
		getContentPane().setLayout(xYLayout1);
		jLabel1.setFont(new java.awt.Font("Dialog", Font.BOLD, 20));
		jLabel1.setText("Course Management");
		jScrollPane1.setBorder(BorderFactory.createEtchedBorder());
		jButton1.setFont(new java.awt.Font("Dialog", Font.PLAIN, 18));
		jButton1.setText("Update");
		jButton1.addActionListener(new CourseF_jButton1_actionAdapter(this));
		jButton2.setFont(new java.awt.Font("Dialog", Font.PLAIN, 18));
		jButton2.setText("Exit");
		jButton2.addActionListener(new CourseF_jButton2_actionAdapter(this));
		xYLayout1.setWidth(550);
		xYLayout1.setHeight(560);
		this.setTitle("Course Management");
		jButton6.setFont(new java.awt.Font("Dialog", Font.PLAIN, 18));
		jButton6.setText("Delete");
		jButton6.addActionListener(new CourseF_jButton6_actionAdapter(this));
		jScrollPane1.getViewport().add(jTable1);
		this.getContentPane().add(jLabel1, new XYConstraints(208, 13, 135, 43));
		this.getContentPane().add(jButton1, new XYConstraints(74, 480, 100, -1));
		this.getContentPane().add(jButton2, new XYConstraints(374, 480, 100, -1));
		this.getContentPane().add(jScrollPane1, new XYConstraints(18, 60, 490, 400));
		this.getContentPane().add(jButton6, new XYConstraints(224, 480, 100, -1));


		// admin:1
		if (MainFrame.level.equals("1")) {
			// full authority
		}
		// normal user:2
		else if (MainFrame.level.equals("2")) {
			// hide some functions
			jButton1.setVisible(false);
			jButton6.setVisible(false);
		}

		sql = "select * from tb_cource ";
		UpdateRecord();

	}

	// search
	public void UpdateRecord() {
		Object[][] arrTmp = {};
		Vector vec = new Vector(1, 1);
		model = new DefaultTableModel(arrTmp, arrField);
		jTable1 = new JTable(model);
		jScrollPane1.getViewport().add(jTable1, null);
		try {
			ResultSet rs = sta.getRs(sql);
			int i = 1;
			while (rs.next()) {
				vec = new Vector();
				vec.add(String.valueOf(rs.getString("courceId")));
				vec.add(String.valueOf(rs.getString("courceSpecName")));
				vec.add(String.valueOf(rs.getString("courceName")));
				vec.add(String.valueOf(rs.getString("courceHour")));
				model.addRow(vec);
			}
			rs.close();
		} catch (Exception ce) {
			System.out.println(ce);
		}
		jScrollPane1.getHorizontalScrollBar();
		jTable1.setGridColor(Color.blue);
		jTable1.setDragEnabled(true);
		jTable1.setSelectionForeground(Color.red);
		jTable1.setSelectionBackground(Color.green);
		jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jTable1.setRowSelectionAllowed(true);
		jTable1.setShowVerticalLines(true);

	}


	public void getM() {
		intRow = jTable1.getSelectedRow();
		if (intRow == -1) {
			jOptionPane1.showMessageDialog(this, "Please select the course£¡", "notice", JOptionPane.INFORMATION_MESSAGE, null);
			return;
		}
		try {
			find = Integer.parseInt(model.getValueAt(intRow, 0).toString());
			System.out.println(find);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


	public void jButton2_actionPerformed(ActionEvent e) {
		this.dispose();
	}


	public void jButton1_actionPerformed(ActionEvent e) {
		getM();
		if (find > 0) {
			CourseChange siadd = new CourseChange(find);
			siadd.setLocation(400, 200);
			siadd.setSize(465, 310);
			siadd.setVisible(true);
			siadd.setResizable(false);
			siadd.validate();
			this.dispose();
		}
	}

	// É¾³ý
	public void jButton6_actionPerformed(ActionEvent e) {
		getM();
		if (intRow == -1) {
			jOptionPane1.showMessageDialog(this, "Please select the course£¡", "notice", JOptionPane.INFORMATION_MESSAGE, null);
		}
		try {
			sta.getUpdate("delete from tb_cource where courceId='" + Integer.valueOf(find) + "'");
			jOptionPane1.showMessageDialog(this, "Delete successfully£¡", "notice", JOptionPane.INFORMATION_MESSAGE, null);
		} catch (Exception ce) {
			System.out.println(ce.getMessage());
		}
		UpdateRecord();
	}
}

class CourseF_jButton1_actionAdapter implements ActionListener {
	private CourseManager adaptee;

	CourseF_jButton1_actionAdapter(CourseManager adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.jButton1_actionPerformed(e);
	}
}

class CourseF_jButton6_actionAdapter implements ActionListener {
	private CourseManager adaptee;

	CourseF_jButton6_actionAdapter(CourseManager adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.jButton6_actionPerformed(e);
	}
}

class CourseF_jButton2_actionAdapter implements ActionListener {
	private CourseManager adaptee;

	CourseF_jButton2_actionAdapter(CourseManager adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.jButton2_actionPerformed(e);
	}
}
