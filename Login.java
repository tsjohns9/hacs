package hacs;

import hacs.UserInfoItem.USER_TYPE;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 *
 * @author Zahra Falah
 * @version 2.0
 * <p>
 * Update to Java 8
 */

public class Login extends JDialog {

	boolean exit = false;
	JLabel jLabel1 = new JLabel();
	JLabel jLabel2 = new JLabel();
	JButton loginButton = new JButton();
	JButton buttonExit = new JButton();
	JTextField userNameText = new JTextField();
	JPasswordField passwordText = new JPasswordField();
	JRadioButton studentRadio = new JRadioButton();
	JRadioButton instructorRadio = new JRadioButton();
	ButtonGroup buttonGroup1 = new ButtonGroup();

	private String userBox = null;
	private USER_TYPE userType = USER_TYPE.Student;

	public Login() {
		try {
			jbInit();
			setSize(Numbers.n300, Numbers.n300);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void jbInit() {
		this.getContentPane().setLayout(null);
		jLabel1.setText("UserName");
		jLabel1.setBounds(new Rectangle(Numbers.n26, Numbers.n52, Numbers.n80, Numbers.n18));
		jLabel2.setText("Password");
		jLabel2.setBounds(new Rectangle(Numbers.n23, Numbers.n119, Numbers.n80, Numbers.n18));
		loginButton.setText("Login");
		loginButton.setBounds(new Rectangle(Numbers.n31, Numbers.n212, Numbers.n85, Numbers.n28));
		loginButton.addActionListener(e -> loginButton(e));
		buttonExit.setText("Exit");
		buttonExit.setBounds(new Rectangle(Numbers.n180, Numbers.n211, Numbers.n97, Numbers.n28));
		buttonExit.addActionListener(e -> buttonExit(e));
		userNameText.setBounds(new Rectangle(Numbers.n119, Numbers.n52, Numbers.n144, Numbers.n22));
		passwordText.setBounds(new Rectangle(Numbers.n118, Numbers.n119, Numbers.n147, Numbers.n22));
		studentRadio.setSelected(true);
		studentRadio.setText("Student");
		studentRadio.setBounds(new Rectangle(Numbers.n37, Numbers.n164, Numbers.n103, Numbers.n26));
		instructorRadio.setText("Instructor");
		instructorRadio.setBounds(new Rectangle(Numbers.n177, Numbers.n162, Numbers.n103, Numbers.n26));
		this.getContentPane().add(jLabel1, null);
		this.getContentPane().add(jLabel2, null);
		this.getContentPane().add(loginButton, null);
		this.getContentPane().add(buttonExit, null);
		this.getContentPane().add(userNameText, null);
		this.getContentPane().add(passwordText, null);
		this.getContentPane().add(studentRadio, null);
		this.getContentPane().add(instructorRadio, null);
		buttonGroup1.add(studentRadio);
		buttonGroup1.add(instructorRadio);
	}

	void loginButton(ActionEvent e) {
		BufferedReader file;
		exit = false;
		System.out.println("login clicked");
		try {
			if (studentRadio.isSelected()) {
				userType = USER_TYPE.Student;
				file = new BufferedReader(new FileReader("StuInfo.txt"));
			} else {
				userType = USER_TYPE.Instructor;
				file = new BufferedReader(new FileReader("InsInfo.txt"));
			}
			userBox = userNameText.getText();
			String PasswordBox = new String(passwordText.getPassword());
			String LoginName = null;
			String aline = null, UserName = null, Password = null;
			while ((aline = file.readLine()) != null) {
				UserName = getUserName(aline);
				Password = getPassword(aline);
				if (UserName.compareTo(userBox) == 0 && Password.compareTo(PasswordBox) == 0)
					LoginName = UserName;
			}
			if (LoginName != null) {
				this.hide();
			}
		} catch (Exception ignored) {
		}

	}

	/*
	 * get the user name from str UserName:Password
	 */
	private String getUserName(String str) {
		int Sep = str.lastIndexOf(':');
		return str.substring(0, Sep);
	}

	/*
	 * get the password from str UserName:Password
	 */
	private String getPassword(String str) {
		int Sep = str.lastIndexOf(':');
		return str.substring(Sep + 1);
	}

	/* after login get the UserName of the login interface */
	public String getUserName() {
		return userBox;
	}

	/* after login get the userType of the login interface */
	public USER_TYPE getUserType() {
		return userType;
	}

	public boolean isExit() {
		return exit;
	}

	void buttonExit(ActionEvent e) {
		exit = true;
		hide();
	}
}