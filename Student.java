package hacs;

/**
 * Title: HACS Description: CSE870 Homework 3: Implementing Design Patterns
 * Copyright: Copyright (c) 2002 Company: Department of Computer Science and
 * Engineering, Michigan State University
 *
 * @author Zahra Falah
 * @version 1.0
 */

public class Student extends Person {

	public Student() {
		type = UserInfoItem.USER_TYPE.Student;
	}

	public CourseMenu createCourseMenu(Course course, CourseLevel.COURSE_LEVEL level) {

		// 0: Highlevel defined in CourseSelectDlg.
		if (level == CourseLevel.COURSE_LEVEL.HighLevel) {
			theCourseMenu = new HighLevelCourseMenu();
			// 1: LowLevel
		} else {
			theCourseMenu = new LowLevelCourseMenu();
		}
		return theCourseMenu;
	}

	@Override
	public boolean showMenu() {
		super.showMenu();
		showViewButtons();
		showComboBoxes();
		showRadios();
		show();
		return ifLogout();
	}
}