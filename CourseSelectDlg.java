package hacs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 *
 * @author Zahra Falah
 * @version 1.0
 */

public class CourseSelectDlg extends JDialog {
	// 0 HighLevel presentation 1 LowLevel Experiment
	ClassCourseList courseList;
	Course selectedCourse;
	int courseLevel = 0;
	boolean logout = false;
	JComboBox courseNameComboBox = new JComboBox();
	JRadioButton highLevelRadio = new JRadioButton();
	JRadioButton lowLevelRadio = new JRadioButton();
	JLabel jLabel1 = new JLabel();
	JButton okButton = new JButton();
	ButtonGroup buttonGroup1 = new ButtonGroup();
	JButton buttonLogout = new JButton();

	public CourseSelectDlg() {
		try {
			jbInit();
			int width = 420, height = 238;
			setSize(width, height);
			setModal(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void jbInit() {
		this.getContentPane().setLayout(null);

		int x1 = 155, y1 = 41, width1 = 203, height1 = 22;
		courseNameComboBox.setBounds(new Rectangle(x1, y1, width1, height1));

		highLevelRadio.setText("HighLevel");

		int x2 = 50, y2 = 87, width2 = 103, height2 = 26;
		highLevelRadio.setBounds(new Rectangle(x2, y2, width2, height2));

		lowLevelRadio.setToolTipText("");
		lowLevelRadio.setSelected(true);
		lowLevelRadio.setText("LowLevel");

		int x3 = 236, y3 = 88, width3 = 103, height3 = 26;
		lowLevelRadio.setBounds(new Rectangle(x3, y3, width3, height3));

		jLabel1.setText("CourseName");

		int x4 = 39, y4 = 44, width4 = 85, height4 = 18;
		jLabel1.setBounds(new Rectangle(x4, y4, width4, height4));

		okButton.setText("OK");

		int x5 = 78, y5 = 139, width5 = 79, height5 = 29;
		okButton.setBounds(new Rectangle(x5, y5, width5, height5));

		okButton.addActionListener(e -> okButtonAction(e));
		buttonLogout.setText("Logout");

		int x6 = 224, y6 = 140, width6 = 73, height6 = 31;
		buttonLogout.setBounds(new Rectangle(x6, y6, width6, height6));

		buttonLogout.addActionListener(e -> buttonLogout(e));
		this.getContentPane().add(courseNameComboBox, null);
		this.getContentPane().add(jLabel1, null);
		this.getContentPane().add(highLevelRadio, null);
		this.getContentPane().add(lowLevelRadio, null);
		this.getContentPane().add(okButton, null);
		this.getContentPane().add(buttonLogout, null);
		buttonGroup1.add(highLevelRadio);
		buttonGroup1.add(lowLevelRadio);
	}

	/*
	 * show the theCourseList in a combox Show the Course type selection button
	 * return the pointer pointing to the Course object return the Course Type
	 */

	public Course showDlg(ClassCourseList courseList) {
		this.courseList = courseList;
		CourseIterator theIterator = new CourseIterator(this.courseList);
		Course theCourse;
		// end of the list
		while ((theCourse = (Course) theIterator.next()) != null) {
			courseNameComboBox.addItem(theCourse);
		}
		show();
		return selectedCourse;
	}

	void okButtonAction(ActionEvent e) {
		selectedCourse = (Course) courseNameComboBox.getSelectedItem();
		if (highLevelRadio.isSelected())
			// highlevel course: 0
			courseLevel = 0;
		else
			// lowlevel course: 1
			courseLevel = 1;
		hide();
	}

	public boolean isLogout() {
		return logout;
	}

	void buttonLogout(ActionEvent e) {
		logout = true;
		hide();
	}
}