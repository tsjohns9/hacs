package hacs;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 *
 * @author Zahra Falah
 * @version 1.0
 */

public class Instructor extends Person {
	public Instructor() {
		type = UserInfoItem.USER_TYPE.Instructor;
	}

	public CourseMenu createCourseMenu(Course theCourse, CourseLevel.COURSE_LEVEL theLevel) {
		// 0: Highlevel defined in CourseSeletDlg.
		if (theLevel == CourseLevel.COURSE_LEVEL.HighLevel) {
			theCourseMenu = new HighLevelCourseMenu();
			// 1: LowLevel
		} else {
			theCourseMenu = new LowLevelCourseMenu();
		}
		return theCourseMenu;
	}

	public boolean showMenu() {
		super.showMenu();
		showAddButton();
		showViewButtons();
		showComboBoxes();
		showRadios();
		show();
		return ifLogout();
	}
}