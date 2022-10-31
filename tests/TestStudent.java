import hacs.*;
import org.junit.Test;
import junit.framework.Assert;

public class TestStudent {
	private Assert Assertions;

	@Test
	public void testStudentCreateCourseMenu() {
		Student student = new Student();
		Course course = new Course("course-name", CourseLevel.COURSE_LEVEL.HighLevel);

		// method returns a different CourseMenu class depending on the value of level.
		// type cast to check that the correct class was made.
		CourseMenu menu = student.createCourseMenu(course, CourseLevel.COURSE_LEVEL.HighLevel);
		HighLevelCourseMenu highLevelMenu = (HighLevelCourseMenu) menu;
		Assertions.assertNotNull(highLevelMenu);

		menu = student.createCourseMenu(course, CourseLevel.COURSE_LEVEL.LowLevel);
		LowLevelCourseMenu lowLevelMenu = (LowLevelCourseMenu) menu;
		Assertions.assertNotNull(lowLevelMenu);
	}
}
