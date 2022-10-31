import hacs.Course;
import hacs.CourseMenu;
import hacs.Student;
import org.junit.Test;
import junit.framework.Assert;

public class TestStudent {
	private Assert Assertions;

	@Test
	public void testStudentCreateCourseMenu() {
		Student student = new Student();
		Course course = new Course("course-name", 500);
		CourseMenu menu = student.createCourseMenu(course, 0);
		Assertions.assertNotNull(menu);

		menu = student.createCourseMenu(course, 1);
		Assertions.assertNotNull(menu);
	}
}
