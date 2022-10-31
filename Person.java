package hacs;

import java.util.Iterator;

/**
 * @author Zahra Falah
 */

abstract public class Person {
	UserInfoItem.USER_TYPE type = UserInfoItem.USER_TYPE.Student;
	String userName;
	ClassCourseList courseList;
	CourseMenu theCourseMenu;
	Course currentCourse;

	public Person() {
		courseList = new ClassCourseList();
	}

	public UserInfoItem.USER_TYPE getUserType() {
		return type;
	}

	abstract public CourseMenu createCourseMenu(Course theCourse, CourseLevel.COURSE_LEVEL courseLevel);

	public void showAddButton() {
		theCourseMenu.showAddButtons();
	}

	public void showViewButtons() {
		theCourseMenu.showViewButtons();
	}

	public void showComboBoxes() {
		theCourseMenu.showComboBoxes();
	}

	public void showRadios() {
		theCourseMenu.showRadios();
	}

	public void show() {
		theCourseMenu.show();
	}

	public boolean ifLogout() {
		return theCourseMenu.ifLogout();
	}

	public boolean showMenu() {
		Iterator<Assignment> assignmentIterator = currentCourse.assignmentList.iterator();
		theCourseMenu.course = currentCourse;
		Assignment theAssignment;
		while (assignmentIterator.hasNext()) {
			theAssignment = assignmentIterator.next();
			theCourseMenu.assignmentComboBox.addItem(theAssignment);
		}
		return false;
	}

	public ClassCourseList getCourseList() {
		return courseList;
	}

	public void addCourse(Course theCourse) {
		courseList.add(theCourse);
	}
}