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

	private void jbInit() throws Exception {
		jLabel1.setText("Assignment Name");
		jLabel1.setBounds(new Rectangle(25, 31, 118, 18));
		this.getContentPane().setLayout(null);
		assignmentName.setText("jTextField1");
		assignmentName.setBounds(new Rectangle(192, 31, 341, 22));
		jLabel2.setText("Due Date");
		jLabel2.setBounds(new Rectangle(28, 90, 113, 18));
		textFieldDueDate.setText("tbDueDate");
		textFieldDueDate.setBounds(new Rectangle(195, 87, 337, 22));
		jLabel3.setText("Suggested Solution");
		jLabel3.setBounds(new Rectangle(28, 151, 118, 18));
		suggestedSolution.setText("jTextField2");
		suggestedSolution.setBounds(new Rectangle(197, 149, 339, 22));
		buttonGrade.setText("Grade");
		buttonGrade.setBounds(new Rectangle(458, 199, 79, 29));
		buttonGrade.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonGrade(e);
			}
		});
		buttonReport.setText("Report");
		buttonReport.setBounds(new Rectangle(365, 249, 79, 29));
		buttonReport.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonReport(e);
			}
		});
		buttonClose.setText("Close");
		buttonClose.setBounds(new Rectangle(86, 253, 79, 29));
		buttonClose.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonClose(e);
			}
		});
		comboSolutionList.setBounds(new Rectangle(32, 204, 413, 22));
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
		Solution theSolution;
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
		} catch (Exception ee) {
		}
		;
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
		SolutionIterator iter = new SolutionIterator(theAssignment.solutionList);
		while (iter.hasNext()) {
			Solution asolution = (Solution) iter.next();
			asolution.setReported(true);
		}
		refreshSolutionList();
	}

	private void refreshSolutionList() {
		comboSolutionList.removeAllItems();
		SolutionIterator SolIter = new SolutionIterator(theAssignment.solutionList);
		while (SolIter.hasNext()) {
			theSolution = (Solution) SolIter.next();
			comboSolutionList.addItem(theSolution);
		}
	}
}