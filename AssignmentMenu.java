package hacs;

import javax.swing.*;


/**
 * Title:        HACS
 * Description:
 * Copyright:    Copyright (c) 2002
 * Company:      msu
 *
 * @author Zahra Falah
 * @version 1.0
 */

abstract public class AssignmentMenu extends JDialog {
	public AssignmentMenu() {
		setModal(true);
		setSize(Numbers.n575, Numbers.n330);
	}

	abstract void showMenu(Assignment assignment, Person person);
}