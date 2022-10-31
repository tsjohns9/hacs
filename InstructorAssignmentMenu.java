package hacs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.DateFormat;

/**
 * Title:        HACS
 * Description:
 * Copyright:    Copyright (c) 2002
 * Company:      msu
 *
 * @author Zahra Falah
 * @version 1.0
 */

public class InstructorAssignmentMenu extends AssignmentMenu {
	JComboBox comboSolutionList = new JComboBox();
	JTextField assignmentName = new JTextField();
	JTextField textFieldDueDate = new JTextField();
	JTextField suggestedSolution = new JTextField();
	JLabel jLabel1 = new JLabel();
	JLabel jLabel2 = new JLabel();
	JLabel jLabel3 = new JLabel();
	JButton buttonGrade = new JButton();
	JButton buttonReport = new JButton();
	JButton buttonClose = new JButton();
	// class AssignmentMenu
	private final boolean bSubmit = false;
	private Solution theSolution;
	private Assignment theAssignment;

	public InstructorAssignmentMenu() {
		try {
			jbInit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void jbInit() {
		jLabel1.setText("Assignment Name");

		int x1 = 25, y31 = 31, width1 = 118, height18 = 18;
		jLabel1.setBounds(new Rectangle(x1, y31, width1, height18));

		this.getContentPane().setLayout(null);
		assignmentName.setText("jTextField1");

		int x2 = 192, width2 = 341, height22 = 22;
		assignmentName.setBounds(new Rectangle(x2, y31, width2, height22));

		jLabel2.setText("Due Date");

		int x28 = 28, y3 = 90, width3 = 113;
		jLabel2.setBounds(new Rectangle(x28, y3, width3, height18));

		textFieldDueDate.setText("tbDueDate");

		int x4 = 195, y4 = 87, width4 = 337;
		textFieldDueDate.setBounds(new Rectangle(x4, y4, width4, height22));

		jLabel3.setText("Suggested Solution");

		int y5 = 151, width5 = 118;
		jLabel3.setBounds(new Rectangle(x28, y5, width5, height18));

		suggestedSolution.setText("jTextField2");

		int x6 = 197, y6 = 149, width6 = 339;
		suggestedSolution.setBounds(new Rectangle(x6, y6, width6, height22));

		buttonGrade.setText("Grade");

		int x7 = 458, y7 = 199, width79 = 79, height29 = 29;
		buttonGrade.setBounds(new Rectangle(x7, y7, width79, height29));

		buttonGrade.addActionListener(e -> buttonGrade(e));
		buttonReport.setText("Report");

		int x8 = 365, y8 = 249;
		buttonReport.setBounds(new Rectangle(x8, y8, width79, height29));

		buttonReport.addActionListener(e -> buttonReport(e));
		buttonClose.setText("Close");

		int x9 = 86, y9 = 253;
		buttonClose.setBounds(new Rectangle(x9, y9, width79, height29));

		buttonClose.addActionListener(e -> buttonClose(e));

		int x10 = 32, y10 = 204, width10 = 413;
		comboSolutionList.setBounds(new Rectangle(x10, y10, width10, height22));

		this.getContentPane().add(jLabel1, null);
		this.getContentPane().add(assignmentName, null);
		this.getContentPane().add(jLabel2, null);
		this.getContentPane().add(textFieldDueDate, null);
		this.getContentPane().add(jLabel3, null);
		this.getContentPane().add(suggestedSolution, null);
		this.getContentPane().add(buttonClose, null);
		this.getContentPane().add(comboSolutionList, null);
		this.getContentPane().add(buttonGrade, null);
		this.getContentPane().add(buttonReport, null);
	}

	public void showMenu(Assignment assignment, Person person) {
		theAssignment = assignment;
		assignmentName.setText(theAssignment.assignmentName);

		DateFormat theDateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
		textFieldDueDate.setText(theDateFormat.format(theAssignment.dueDate));
		suggestedSolution.setText(theAssignment.suggestSolution.solutionFileName);
		refreshSolutionList();
		show();
	}

	void buttonClose(ActionEvent e) {
		theAssignment.assignmentName = assignmentName.getText();
		DateFormat tempDateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
		try {
			theAssignment.dueDate = tempDateFormat.parse(textFieldDueDate.getText());
		} catch (Exception ignored) {
		}
		theAssignment.suggestSolution.solutionFileName = suggestedSolution.getText();
		hide();
	}

	void buttonGrade(ActionEvent e) {
		Solution theSolution = (Solution) comboSolutionList.getSelectedItem();
		if (theSolution == null)
			return;
		SolutionGradingDlg dlg = new SolutionGradingDlg();
		dlg.show(theSolution);
		refreshSolutionList();
	}

	void buttonReport(ActionEvent e) {
		SolutionIterator iterator = new SolutionIterator(theAssignment.solutionList);
		while (iterator.hasNext()) {
			Solution sol = (Solution) iterator.next();
			sol.setReported(true);
		}
		refreshSolutionList();
	}

	private void refreshSolutionList() {
		comboSolutionList.removeAllItems();
		SolutionIterator iterator = new SolutionIterator(theAssignment.solutionList);
		while (iterator.hasNext()) {
			theSolution = (Solution) iterator.next();
			comboSolutionList.addItem(theSolution);
		}
	}
}