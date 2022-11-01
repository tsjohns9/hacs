package hacs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * @author Zahra Falah
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
			setSize(Numbers.n316, Numbers.n186);
			setModal(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void jbInit() {
		jLabel1.setText("Solution File Name");
		jLabel1.setBounds(new Rectangle(Numbers.n23, Numbers.n30, Numbers.n121, Numbers.n18));
		this.getContentPane().setLayout(null);
		textFieldGrade.setBounds(new Rectangle(Numbers.n25, Numbers.n66, Numbers.n100, Numbers.n22));
		buttonOK.setText("OK");
		buttonOK.setBounds(new Rectangle(Numbers.n217, Numbers.n67, Numbers.n79, Numbers.n29));
		buttonOK.addActionListener(e -> okButtonAction(e));
		labelSolutionFileName.setBounds(new Rectangle(Numbers.n212, Numbers.n34, Numbers.n163, Numbers.n18));
		this.getContentPane().add(jLabel1, null);
		this.getContentPane().add(textFieldGrade, null);
		this.getContentPane().add(labelSolutionFileName, null);
		this.getContentPane().add(buttonOK, null);
	}

	void show(Solution solution) {
		theSolution = solution;
		textFieldGrade.setText("" + theSolution.getGradeInt());
		labelSolutionFileName.setText(theSolution.getSolutionFileName());
		show();
	}

	void okButtonAction(ActionEvent e) {
		theSolution.setGradeInt(Integer.parseInt(textFieldGrade.getText()));
		hide();
	}

}