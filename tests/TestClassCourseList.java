import hacs.ClassCourseList;
import hacs.Course;
import junit.framework.Assert;
import org.junit.Test;

public class TestClassCourseList {

	private Assert Assertions;

	@Test
	public void testinitializeFromFile() {
		ClassCourseList courseList = new ClassCourseList();
		courseList.initializeFromFile("CourseInfo.txt");
		Assertions.assertEquals(2, courseList.size());
	}

	@Test
	public void testFindCourseByName() {
		ClassCourseList courseList = new ClassCourseList();
		courseList.initializeFromFile("CourseInfo.txt");

		Course course = courseList.findCourseByCourseName("SER 515");
		Assertions.assertEquals("SER 515", course.toString());

		course = courseList.findCourseByCourseName("SER 1111");
		Assertions.assertNull(course);
	}
}
