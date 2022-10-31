package hacs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Iterator;


/**
 * Title:        HACS
 * Description:
 * Copyright:    Copyright (c) 2002
 * Company:      msu
 *
 * @author Zahra Falah
 * @version 1.0
 */

abstract public class CourseMenu extends JDialog {
	Course course;
	boolean bLogout = true;

	JRadioButton assignmentRadio = new JRadioButton();
	JComboBox assignmentComboBox = new JComboBox();
	JButton assignmentViewButton = new JButton();
	JButton assignmentAddButton = new JButton();
	JRadioButton optionRadio = new JRadioButton();
	JLabel assignmentContentLabel = new JLabel();
	JComboBox optionCombo = new JComboBox();
	JButton optionViewButton = new JButton();
	JButton optionAddButton = new JButton();
	JButton buttonChangeCourse = new JButton();
	JButton buttonLogout = new JButton();

	public CourseMenu() {
		try {
			jbInit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		setModal(true);
		setSize(Numbers.n503, Numbers.n294);
	}

	private void jbInit() {
		buttonChangeCourse.setText("ChangeCourse");

		buttonChangeCourse.setBounds(new Rectangle(Numbers.n101, Numbers.n211, Numbers.n73, Numbers.n37));

		buttonChangeCourse.addActionListener(e -> buttonChangeCourse(e));
		this.getContentPane().setLayout(null);
		this.setTitle("");
		buttonLogout.setText("Logout");

		buttonLogout.setBounds(new Rectangle(Numbers.n267, Numbers.n215, Numbers.n73, Numbers.n37));

		buttonLogout.addActionListener(e -> buttonLogout(e));
		this.getContentPane().add(buttonChangeCourse, null);
		this.getContentPane().add(buttonLogout, null);
	}

  /* when the add button is pressed, call add assignment
  function of facade, after that refresh window
  */

  /* when the add button is pressed, call ViewAssignment
  function of facade, after that refresh window
  */

	abstract void showMenu(Course theCourse);

	abstract void showAddButtons();

	abstract void showViewButtons();

	abstract void showRadios();

	abstract void showComboBoxes();

	abstract void showLabel();

	void assignmentAddButton(ActionEvent e) {
		Hacs.facade.addAssignment(course);
		refresh();
	}

	void assignmentViewButton(ActionEvent e) {
		Assignment assignment = (Assignment) assignmentComboBox.getSelectedItem();
		Hacs.facade.viewAssignment(assignment);
	}

	void refresh() {
		assignmentComboBox.removeAllItems();
		for (Assignment assignment : course.assignmentList) {
			assignmentComboBox.addItem(assignment);
		}
	}

	void buttonChangeCourse(ActionEvent e) {
		bLogout = false;
		hide();
	}

	void buttonLogout(ActionEvent e) {
		bLogout = true;
		hide();
	}

	boolean ifLogout() {
		return bLogout;
	}
}