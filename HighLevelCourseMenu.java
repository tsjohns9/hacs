package hacs;

/**
 * Title:        HACS
 * Description:
 * Copyright:    Copyright (c) 2002
 * Company:      msu
 *
 * @author Zahra Falah
 * @version 1.0
 */

import java.awt.*;
import java.awt.event.ActionEvent;

public class HighLevelCourseMenu extends CourseMenu {

	/*
	 * JButton AssignmentAddButton = new JButton(); JRadioButton OptionRadio = new
	 * JRadioButton(); JComboBox OptionCombo = new JComboBox(); JButton
	 * OptionViewButton = new JButton(); JButton OptionAddButton = new JButton();
	 */

	public HighLevelCourseMenu() {
	}

	void showMenu(Course theCourse) {
		showViewButtons();
		showRadios();
		showComboBoxes();
		show();
	}

	void showAddButtons() {
		assignmentAddButton.addActionListener(e -> assignmentAddButton(e));
		assignmentAddButton.setText("Add");

		int x1 = 389, y1 = 54, width1 = 79, height1 = 29;
		assignmentAddButton.setBounds(new Rectangle(x1, y1, width1, height1));
		optionAddButton.setText("Add");

		int x2 = 390, y2 = 125;
		optionAddButton.setBounds(new Rectangle(x2, y1, width1, height1));

		this.getContentPane().add(assignmentAddButton, null);
		this.getContentPane().add(optionAddButton, null);
	}

	void showRadios() {
		assignmentRadio.setText("Assignment");

		int x1 = 21, y1 = 55, width1 = 103, height1 = 26;
		assignmentRadio.setBounds(new Rectangle(x1, y1, width1, height1));

		this.getContentPane().add(assignmentRadio, null);
		optionRadio.setText("HighLevel Presentation");

		int y2 = 128;
		optionRadio.setBounds(new Rectangle(x1, y2, width1, height1));
		this.getContentPane().add(optionRadio, null);
	}

	void showComboBoxes() {
		int x1 = 140, y1 = 57, width1 = 126, height1 = 22;
		assignmentComboBox.setBounds(new Rectangle(x1, y1, width1, height1));

		int x2 = 137, y2 = 127;
		optionCombo.setBounds(new Rectangle(x2, y2, width1, height1));
		this.getContentPane().add(assignmentComboBox, null);
		this.getContentPane().add(optionCombo, null);
		refresh();
	}

	void showViewButtons() {
		assignmentViewButton.setText("View");

		int x1 = 290, y1 = 54, width1 = 79, height1 = 29;
		assignmentViewButton.setBounds(new Rectangle(x1, y1, width1, height1));
		assignmentViewButton.addActionListener(e -> assignmentViewButton(e));
		optionViewButton.setText("View");

		int y2 = 124;
		optionViewButton.setBounds(new Rectangle(x1, y2, width1, height1));
		this.getContentPane().add(assignmentViewButton, null);
		this.getContentPane().add(optionViewButton, null);
	}

	void showLabel() {
		assignmentContentLabel.setText("AssigmentContent");
		int x1 = 23, y1 = 186, width1 = 432, height1 = 99;
		assignmentContentLabel.setBounds(new Rectangle(x1, y1, width1, height1));
		this.getContentPane().add(assignmentContentLabel, null);
	}
}