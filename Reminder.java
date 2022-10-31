package hacs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * @author Zahra Falah
 */

public class Reminder extends JDialog {
	JLabel upcomingAssignmentsLabel = new JLabel();
	JLabel overdueAssignmentsLabel = new JLabel();
	java.awt.List listUpcoming = new java.awt.List();
	java.awt.List listOverdue = new java.awt.List();
	Button buttonOK = new Button();

	public Reminder() {
		try {
			jbInit();
			setModal(true);
			setSize(Numbers.n400, Numbers.n386);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public java.awt.List getListUpcoming() {
		return listUpcoming;
	}

	private void jbInit() {
		upcomingAssignmentsLabel.setText("Upcoming assignments");
		upcomingAssignmentsLabel.setBounds(new Rectangle(Numbers.n38, Numbers.n40, Numbers.n159, Numbers.n17));
		this.getContentPane().setLayout(null);
		overdueAssignmentsLabel.setText("OverDue Assignments");
		overdueAssignmentsLabel.setBounds(new Rectangle(Numbers.n39, Numbers.n160, Numbers.n161, Numbers.n17));
		listUpcoming.setBounds(new Rectangle(Numbers.n29, Numbers.n65, Numbers.n340, Numbers.n79));
		listOverdue.setBounds(new Rectangle(Numbers.n31, Numbers.n187, Numbers.n337, Numbers.n85));
		buttonOK.setLabel("OK");
		buttonOK.setBounds(new Rectangle(Numbers.n149, Numbers.n308, Numbers.n67, Numbers.n37));
		buttonOK.addActionListener(e -> okButtonAction(e));
		this.getContentPane().add(upcomingAssignmentsLabel, null);
		this.getContentPane().add(overdueAssignmentsLabel, null);
		this.getContentPane().add(listUpcoming, null);
		this.getContentPane().add(listOverdue, null);
		this.getContentPane().add(buttonOK, null);
	}

	void showReminder(ClassCourseList list) {
		ReminderVisitor visitor = new ReminderVisitor(this);
		visitor.visitFacade(Hacs.facade);
		show();
	}

	void okButtonAction(ActionEvent e) {
		hide();
	}
}