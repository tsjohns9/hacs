package hacs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 *
 * @author Zahra Falah
 * @version 2.0 update to Java 8
 */

public class ClassCourseList extends ArrayList<Course> {

	public ClassCourseList() {
	}

	// initialize the list by reading from the file.
	void initializeFromFile(String fileName) {
		try {
			BufferedReader file;
			String strCourseName = null;
			file = new BufferedReader(new FileReader(fileName));
			while ((strCourseName = file.readLine()) != null) {
				Course theCourse;
				theCourse = new Course(strCourseName, CourseLevel.COURSE_LEVEL.LowLevel);
				add(theCourse);
			}
		} catch (Exception ignored) {
		}
	}

	Course findCourseByCourseName(String courseName) {
		for (Course course : this) {
			Course theCourse;
			theCourse =  course;
			if (theCourse.courseName.compareTo(courseName) == 0)
				return theCourse;
		}
		return null;
	}

}