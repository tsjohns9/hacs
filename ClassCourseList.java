package hacs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * @author Zahra Falah
 */

public class ClassCourseList extends ArrayList<Course> {

	public ClassCourseList() {
	}

	// initialize the list by reading from the file.
	public void initializeFromFile(String fileName) {
		try {
			BufferedReader file;
			String strCourseName;
			file = new BufferedReader(new FileReader(fileName));
			while ((strCourseName = file.readLine()) != null) {
				Course theCourse;
				theCourse = new Course(strCourseName, CourseLevel.COURSE_LEVEL.LowLevel);
				add(theCourse);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Course findCourseByCourseName(String courseName) {
		for (Course course : this) {
			Course theCourse;
			theCourse =  course;
			if (theCourse.courseName.compareTo(courseName) == 0)
				return theCourse;
		}
		return null;
	}

}