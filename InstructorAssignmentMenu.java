package hacs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.DateFormat;

/**
 * @author Zahra Falah
 */

public class InstructorAssignmentMenu extends AssignmentMenu {
	JComboBox comboSolutionList = new JComboBox();
	JTextField assignmentName = new JTextField();
	JTextField textFieldDueDate = new JTextField();
	JTextField suggestedSolution = new JTextField();
	JLabel jLabel1 = new JLabel();
	JLabel jLabel2 = new JLabel();
	JLabel suggestedSolutionLabel = new JLabel();
	JButton buttonGrade = new JButton();
	JButton buttonReport = new JButton();
	JButton buttonClose = new JButton();
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

		jLabel1.setBounds(new Rectangle(Numbers.n25, Numbers.n31, Numbers.n118, Numbers.n18));

		this.getContentPane().setLayout(null);
		assignmentName.setText("jTextField1");

		assignmentName.setBounds(new Rectangle(Numbers.n192, Numbers.n22, Numbers.n341, Numbers.n22));

		jLabel2.setText("Due Date");

		jLabel2.setBounds(new Rectangle(Numbers.n28, Numbers.n90, Numbers.n113, Numbers.n18));

		textFieldDueDate.setText("tbDueDate");

		textFieldDueDate.setBounds(new Rectangle(Numbers.n195, Numbers.n87, Numbers.n337, Numbers.n22));

		suggestedSolutionLabel.setText("Suggested Solution");

		suggestedSolutionLabel.setBounds(new Rectangle(Numbers.n28, Numbers.n151, Numbers.n118, Numbers.n18));

		suggestedSolution.setText("jTextField2");

		suggestedSolution.setBounds(new Rectangle(Numbers.n197, Numbers.n149, Numbers.n339, Numbers.n22));

		buttonGrade.setText("Grade");

		buttonGrade.setBounds(new Rectangle(Numbers.n458, Numbers.n199, Numbers.n79, Numbers.n29));

		buttonGrade.addActionListener(e -> buttonGrade(e));
		buttonReport.setText("Report");

		buttonReport.setBounds(new Rectangle(Numbers.n365, Numbers.n249, Numbers.n79, Numbers.n29));

		buttonReport.addActionListener(e -> buttonReport(e));
		buttonClose.setText("Close");

		buttonClose.setBounds(new Rectangle(Numbers.n86, Numbers.n253, Numbers.n79, Numbers.n29));

		buttonClose.addActionListener(e -> buttonClose(e));

		comboSolutionList.setBounds(new Rectangle(Numbers.n32, Numbers.n204, Numbers.n413, Numbers.n22));

		this.getContentPane().add(jLabel1, null);
		this.getContentPane().add(assignmentName, null);
		this.getContentPane().add(jLabel2, null);
		this.getContentPane().add(textFieldDueDate, null);
		this.getContentPane().add(suggestedSolutionLabel, null);
		this.getContentPane().add(suggestedSolution, null);
		this.getContentPane().add(buttonClose, null);
		this.getContentPane().add(comboSolutionList, null);
		this.getContentPane().add(buttonGrade, null);
		this.getContentPane().add(buttonReport, null);
	}

	public void showMenu(Assignment assignment, Person person) {
		theAssignment = assignment;
		assignmentName.setText(theAssignment.getAssignmentName());

		DateFormat theDateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
		textFieldDueDate.setText(theDateFormat.format(theAssignment.dueDate));
		suggestedSolution.setText(theAssignment.suggestSolution.getSolutionFileName());
		refreshSolutionList();
		show();
	}

	void buttonClose(ActionEvent e) {
		theAssignment.setAssignmentName(assignmentName.getText());
		DateFormat tempDateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
		try {
			theAssignment.dueDate = tempDateFormat.parse(textFieldDueDate.getText());
		} catch (Exception ignored) {
		}
		theAssignment.suggestSolution.setSolutionFileName(suggestedSolution.getText());
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
			Solution theSolution = (Solution) iterator.next();
			comboSolutionList.addItem(theSolution);
		}
	}
}