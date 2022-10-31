package hacs;

/**
 * @author Zahra Falah
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