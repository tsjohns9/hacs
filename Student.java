package hacs;

/**
 * @author Zahra Falah
 */

public class Student extends Person {

	public Student() {
		type = UserInfoItem.USER_TYPE.Student;
	}

	public CourseMenu createCourseMenu(Course course, CourseLevel.COURSE_LEVEL level) {
		// 0: Highlevel
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