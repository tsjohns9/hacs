import hacs.*;
import junit.framework.Assert;
import org.junit.Test;

public class TestInstructor {
	private Assert Assertions;

	@Test
	public void testInstructorCreateCourseMenu() {

		Instructor instructor = new Instructor();
		Course course = new Course("CSE", CourseLevel.COURSE_LEVEL.HighLevel);

		CourseMenu menu = instructor.createCourseMenu(course, CourseLevel.COURSE_LEVEL.HighLevel);
		HighLevelCourseMenu high = (HighLevelCourseMenu)menu;
		Assertions.assertNotNull(high);

		menu = instructor.createCourseMenu(course, CourseLevel.COURSE_LEVEL.LowLevel);
		LowLevelCourseMenu low = (LowLevelCourseMenu) menu;
		Assertions.assertNotNull(low);

	}
}
