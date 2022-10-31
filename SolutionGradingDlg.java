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

public class SolutionGradingDlg extends JDialog {
	Solution theSolution;
	JLabel jLabel1 = new JLabel();
	JTextField textFieldGrade = new JTextField();
	JButton buttonOK = new JButton();
	JLabel labelSolutionFileName = new JLabel();

	public SolutionGradingDlg() {
		try {
			jbInit();
			setSize(316, 186);
			setModal(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void jbInit() {
		jLabel1.setText("Solution File Name");
		jLabel1.setBounds(new Rectangle(23, 30, 121, 18));
		this.getContentPane().setLayout(null);
		textFieldGrade.setBounds(new Rectangle(25, 66, 100, 22));
		buttonOK.setText("OK");
		buttonOK.setBounds(new Rectangle(217, 67, 79, 29));
		buttonOK.addActionListener(e -> okButtonAction(e));
		labelSolutionFileName.setBounds(new Rectangle(212, 34, 163, 18));
		this.getContentPane().add(jLabel1, null);
		this.getContentPane().add(textFieldGrade, null);
		this.getContentPane().add(labelSolutionFileName, null);
		this.getContentPane().add(buttonOK, null);
	}

	void show(Solution solution) {
		theSolution = solution;
		textFieldGrade.setText("" + theSolution.getGradeInt());
		labelSolutionFileName.setText(theSolution.solutionFileName);
		show();
	}

	void okButtonAction(ActionEvent e) {
		theSolution.grade = Integer.parseInt(textFieldGrade.getText());
		hide();
	}

}