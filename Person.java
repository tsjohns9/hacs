package hacs;

import java.util.Iterator;

/**
 * Title: HACS Description: CSE870 Homework 3: Implementing Design Patterns
 * Copyright: Copyright (c) 2002 Company: Department of Computer Science and
 * Engineering, Michigan State University
 *
 * @author Zahra Falah
 * @version 1.0
 */

abstract public class Person {
	UserInfoItem.USER_TYPE type = UserInfoItem.USER_TYPE.Student;
	String userName;
	ClassCourseList courseList;
	CourseMenu theCourseMenu;
	Course currentCourse;
	Assignment currentAssignment;

	public Person() {
		courseList = new ClassCourseList();
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

	// show the assignment list
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