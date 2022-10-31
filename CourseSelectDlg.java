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
	ClassCourseList courseList;
	Course selectedCourse;
	CourseLevel.COURSE_LEVEL courseLevel = CourseLevel.COURSE_LEVEL.HighLevel;
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
			setSize(Numbers.n420, Numbers.n238);
			setModal(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void jbInit() {
		this.getContentPane().setLayout(null);

		courseNameComboBox.setBounds(new Rectangle(Numbers.n155, Numbers.n41, Numbers.n203, Numbers.n22));

		highLevelRadio.setText("HighLevel");

		highLevelRadio.setBounds(new Rectangle(Numbers.n50, Numbers.n87, Numbers.n103, Numbers.n26));

		lowLevelRadio.setToolTipText("");
		lowLevelRadio.setSelected(true);
		lowLevelRadio.setText("LowLevel");

		lowLevelRadio.setBounds(new Rectangle(Numbers.n236, Numbers.n88, Numbers.n103, Numbers.n26));

		jLabel1.setText("CourseName");

		jLabel1.setBounds(new Rectangle(Numbers.n39, Numbers.n44, Numbers.n85, Numbers.n18));

		okButton.setText("OK");

		okButton.setBounds(new Rectangle(Numbers.n78, Numbers.n139, Numbers.n79, Numbers.n29));

		okButton.addActionListener(e -> okButtonAction(e));
		buttonLogout.setText("Logout");

		buttonLogout.setBounds(new Rectangle(Numbers.n224, Numbers.n140, Numbers.n73, Numbers.n31));

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
			courseLevel = CourseLevel.COURSE_LEVEL.HighLevel;
		else
			// lowlevel course: 1
			courseLevel = CourseLevel.COURSE_LEVEL.LowLevel;
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