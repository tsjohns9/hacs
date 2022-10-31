import hacs.Course;
import hacs.CourseLevel;
import hacs.CourseMenu;
import hacs.Student;
import org.junit.Test;
import junit.framework.Assert;

public class TestStudent {
	private Assert Assertions;

	@Test
	public void testStudentCreateCourseMenu() {
		Student student = new Student();
		Course course = new Course("course-name", CourseLevel.COURSE_LEVEL.HighLevel);
		CourseMenu menu = student.createCourseMenu(course, CourseLevel.COURSE_LEVEL.HighLevel);
		Assertions.assertNotNull(menu);

		menu = student.createCourseMenu(course, CourseLevel.COURSE_LEVEL.LowLevel);
		Assertions.assertNotNull(menu);
	}
}
