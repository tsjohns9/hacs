package hacs;

import javax.swing.*;


/**
 * @author Zahra Falah
 */

abstract public class AssignmentMenu extends JDialog {
	public AssignmentMenu() {
		setModal(true);
		setSize(Numbers.n575, Numbers.n330);
	}

	abstract void showMenu(Assignment assignment, Person person);
}