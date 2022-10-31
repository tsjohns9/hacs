package hacs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Date;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 *
 * @author Zahra Falah
 * @version 1.0
 */

public class StudentAssignmentMenu extends AssignmentMenu {

	JLabel assignmentNameLabel = new JLabel();
	JLabel dueDateLabel = new JLabel();
	JTextField solutionTextField = new JTextField();
	JLabel suggestedSolutionLabel = new JLabel();
	JLabel gradeLabel = new JLabel();
	JButton submitBtn = new JButton();
	JButton cancelBtn = new JButton();
	JLabel jLabel1 = new JLabel();
	JLabel jLabel3 = new JLabel();
	JLabel jLabel5 = new JLabel();
	JLabel jLabel6 = new JLabel();
	JLabel jLabel7 = new JLabel();
	private boolean boolSubmit = false;

	public StudentAssignmentMenu() {
		try {
			jbInit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void jbInit() {
		jLabel1.setText("Assignment : ");
		jLabel1.setBounds(new Rectangle(20, 36, 91, 18));
		this.getContentPane().setLayout(null);
		assignmentNameLabel.setText("jLabel2");
		assignmentNameLabel.setBounds(new Rectangle(258, 35, 282, 18));
		jLabel3.setText("Due Date");
		jLabel3.setBounds(new Rectangle(21, 81, 92, 18));
		dueDateLabel.setText("jLabel4");
		dueDateLabel.setBounds(new Rectangle(254, 82, 294, 18));
		jLabel5.setText("Solution");
		jLabel5.setBounds(new Rectangle(24, 128, 93, 18));
		solutionTextField.setText("jTextField1");
		solutionTextField.setBounds(new Rectangle(251, 127, 211, 22));
		jLabel6.setText("Suggested Solution");
		jLabel6.setBounds(new Rectangle(24, 174, 117, 18));
		jLabel7.setText("Grade");
		jLabel7.setBounds(new Rectangle(23, 224, 41, 18));
		suggestedSolutionLabel.setText("jLabel8");
		suggestedSolutionLabel.setBounds(new Rectangle(259, 169, 201, 18));
		gradeLabel.setText("jLabel9");
		gradeLabel.setBounds(new Rectangle(258, 226, 41, 18));
		submitBtn.setText("Submit");
		submitBtn.setBounds(new Rectangle(476, 124, 79, 29));
		submitBtn.addActionListener(e -> submitBtnAction(e));
		cancelBtn.setText("Cancel");
		cancelBtn.setBounds(new Rectangle(475, 164, 79, 29));
		cancelBtn.addActionListener(e -> cancelBtnAction(e));
		this.getContentPane().add(jLabel1, null);
		this.getContentPane().add(jLabel3, null);
		this.getContentPane().add(jLabel5, null);
		this.getContentPane().add(jLabel6, null);
		this.getContentPane().add(assignmentNameLabel, null);
		this.getContentPane().add(dueDateLabel, null);
		this.getContentPane().add(solutionTextField, null);
		this.getContentPane().add(jLabel7, null);
		this.getContentPane().add(suggestedSolutionLabel, null);
		this.getContentPane().add(gradeLabel, null);
		this.getContentPane().add(submitBtn, null);
		this.getContentPane().add(cancelBtn, null);
	}

	/*
	 * check if the student has already had a solution or not. if not , create a new
	 * solution for the student. after showing the solution attatch the soluiton;
	 */
	public void showMenu(Assignment assignment, Person person) {
		SolutionIterator theIter = assignment.getSolutionIterator();
		Solution solution = (Solution) theIter.next(person.userName);
		if (solution == null) {
			solutionTextField.setText("");
			gradeLabel.setText("-1");
		} else {
			solutionTextField.setText(solution.solutionFileName);
			gradeLabel.setText(solution.getGradeString());
		}

		assignmentNameLabel.setText(assignment.assignmentName);
		dueDateLabel.setText(assignment.dueDate.toString());
		suggestedSolutionLabel.setText(assignment.suggestSolution.solutionFileName);

		show();

		if (boolSubmit) {
			if (solution == null) {
				solution = new Solution();
				assignment.addSolution(solution);
			}
			solution.author = person.userName;
			solution.solutionFileName = solutionTextField.getText();
			solution.submitDate = new Date();
		}
	}

	void submitBtnAction(ActionEvent e) {
		boolSubmit = true;
		hide();
	}

	void cancelBtnAction(ActionEvent e) {
		boolSubmit = false;
		hide();
	}

}