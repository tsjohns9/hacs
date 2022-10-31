package hacs;

import java.util.Iterator;

/**
 * @author Zahra Falah
 */

public class CourseIterator implements Iterator {
	ClassCourseList courseList;
	int currentCourseNumber = -1;


	public CourseIterator(ClassCourseList courseList) {
		this.courseList = courseList;
	}

	public boolean hasNext() {
		if (currentCourseNumber >= courseList.size() - 1)
			return false;
		else
			return true;
	}

	public Object next() {
		if (hasNext()) {
			currentCourseNumber++;
			return courseList.get(currentCourseNumber);
		} else {
			return null;
		}
	}

	public void remove() {
		courseList.remove(currentCourseNumber);
	}

	// the next Course that fits the given CourseName
	public Object next(String CourseName) {
		Course theCourse;
		theCourse = (Course) next();
		while (theCourse != null) {
			if (CourseName.compareTo(theCourse.toString()) == 0) {
				return theCourse;
			}
			theCourse = (Course) next();
		}
		return null;
	}

}