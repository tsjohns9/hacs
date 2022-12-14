package hacs;

import java.awt.*;

/**
 * @author Zahra Falah
 */

public class LowLevelCourseMenu extends CourseMenu {

	public LowLevelCourseMenu() {
	}

	void showMenu(Course theCourse) {
		show();
	}

	void showAddButtons() {
		assignmentAddButton.addActionListener(e -> assignmentAddButton(e));
		assignmentAddButton.setText("Add");
		assignmentAddButton.setBounds(new Rectangle(Numbers.n389, Numbers.n54, Numbers.n79, Numbers.n29));
		optionAddButton.setText("Add");
		optionAddButton.setBounds(new Rectangle(Numbers.n390, Numbers.n125, Numbers.n79, Numbers.n29));
		this.getContentPane().add(assignmentAddButton, null);
		this.getContentPane().add(optionAddButton, null);
	}

	void showRadios() {
		assignmentRadio.setText("Assignment");
		assignmentRadio.setBounds(new Rectangle(Numbers.n21, Numbers.n55, Numbers.n103, Numbers.n26));
		this.getContentPane().add(assignmentRadio, null);
		optionRadio.setText("LowLevelExperiment");
		optionRadio.setBounds(new Rectangle(Numbers.n21, Numbers.n128, Numbers.n103, Numbers.n26));
		this.getContentPane().add(optionRadio, null);
	}

	void showComboBoxes() {
		assignmentComboBox.setBounds(new Rectangle(Numbers.n140, Numbers.n57, Numbers.n126, Numbers.n22));
		optionCombo.setBounds(new Rectangle(Numbers.n137, Numbers.n127, Numbers.n126, Numbers.n22));
		this.getContentPane().add(assignmentComboBox, null);
		this.getContentPane().add(optionCombo, null);
		refresh();
	}

	void showViewButtons() {
		assignmentViewButton.setText("View");
		assignmentViewButton.setBounds(new Rectangle(Numbers.n290, Numbers.n54, Numbers.n79, Numbers.n29));
		assignmentViewButton.addActionListener(e -> assignmentViewButton(e));
		optionViewButton.setText("View");
		optionViewButton.setBounds(new Rectangle(Numbers.n290, Numbers.n124, Numbers.n79, Numbers.n29));
		this.getContentPane().add(assignmentViewButton, null);
		this.getContentPane().add(optionViewButton, null);
	}

	void showLabel() {
		assignmentContentLabel.setText("AssigmentContent");
		assignmentContentLabel.setBounds(new Rectangle(Numbers.n23, Numbers.n186, Numbers.n432, Numbers.n99));
		this.getContentPane().add(assignmentContentLabel, null);
	}
}