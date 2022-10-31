package hacs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Date;

/**
 * @author Zahra Falah
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
		jLabel1.setBounds(new Rectangle(Numbers.n20, Numbers.n36, Numbers.n91, Numbers.n18));
		this.getContentPane().setLayout(null);
		assignmentNameLabel.setText("jLabel2");
		assignmentNameLabel.setBounds(new Rectangle(Numbers.n258, Numbers.n35, Numbers.n282, Numbers.n18));
		jLabel3.setText("Due Date");
		jLabel3.setBounds(new Rectangle(Numbers.n21, Numbers.n81, Numbers.n92, Numbers.n18));
		dueDateLabel.setText("jLabel4");
		dueDateLabel.setBounds(new Rectangle(Numbers.n254, Numbers.n82, Numbers.n294, Numbers.n18));
		jLabel5.setText("Solution");
		jLabel5.setBounds(new Rectangle(Numbers.n24, Numbers.n128, Numbers.n93, Numbers.n18));
		solutionTextField.setText("jTextField1");
		solutionTextField.setBounds(new Rectangle(Numbers.n251, Numbers.n127, Numbers.n211, Numbers.n22));
		jLabel6.setText("Suggested Solution");
		jLabel6.setBounds(new Rectangle(Numbers.n24, Numbers.n174, Numbers.n117, Numbers.n18));
		jLabel7.setText("Grade");
		jLabel7.setBounds(new Rectangle(Numbers.n23, Numbers.n224, Numbers.n41, Numbers.n18));
		suggestedSolutionLabel.setText("jLabel8");
		suggestedSolutionLabel.setBounds(new Rectangle(Numbers.n259, Numbers.n169, Numbers.n201, Numbers.n18));
		gradeLabel.setText("jLabel9");
		gradeLabel.setBounds(new Rectangle(Numbers.n258, Numbers.n226, Numbers.n41, Numbers.n18));
		submitBtn.setText("Submit");
		submitBtn.setBounds(new Rectangle(Numbers.n476, Numbers.n124, Numbers.n79, Numbers.n29));
		submitBtn.addActionListener(e -> submitBtnAction(e));
		cancelBtn.setText("Cancel");
		cancelBtn.setBounds(new Rectangle(Numbers.n475, Numbers.n164, Numbers.n79, Numbers.n29));
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
	 * check if the student has already had a solution or not. if not, create a new
	 * solution for the student. After showing the solution attach the solution;
	 */
	public void showMenu(Assignment assignment, Person person) {
		SolutionIterator solutionIterator = assignment.getSolutionIterator();
		Solution solution = (Solution) solutionIterator.next(person.userName);
		if (solution == null) {
			solutionTextField.setText("");
			gradeLabel.setText("-1");
		} else {
			solutionTextField.setText(solution.solutionFileName);
			gradeLabel.setText(solution.getGradeString());
		}

		assignmentNameLabel.setText(assignment.getAssignmentName());
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