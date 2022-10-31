import hacs.ClassCourseList;
import hacs.CourseIterator;
import junit.framework.Assert;
import org.junit.Test;

public class TestCourseIterator {
	private Assert Assertions;

	@Test
	public void testCourseIterator() {
		ClassCourseList courseList = new ClassCourseList();
		courseList.initializeFromFile("CourseInfo.txt");

		CourseIterator iterator = new CourseIterator(courseList);

		Assertions.assertEquals(2, courseList.size());
		Assertions.assertTrue(iterator.hasNext());

		Assertions.assertNotNull(iterator.next());
		Assertions.assertNotNull(iterator.next());
		Assertions.assertNull(iterator.next());
		iterator.remove();
		Assertions.assertEquals(1, courseList.size());
	}

	@Test
	public void testCourseIteratorNext() {
		ClassCourseList courseList = new ClassCourseList();
		courseList.initializeFromFile("CourseInfo.txt");

		CourseIterator iterator = new CourseIterator(courseList);

		Object item = iterator.next("SER 515");
		Assertions.assertNotNull(item);

		item = iterator.next("abc123");
		Assertions.assertNull(item);
	}
}
