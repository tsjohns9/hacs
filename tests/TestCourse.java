import hacs.*;
import junit.framework.Assert;
import org.junit.Test;

public class TestCourse {
	private Assert Assertions;

	@Test
	public void testCourseAssignmentList() {
		Course course = new Course("course-name", CourseLevel.COURSE_LEVEL.HighLevel);
		Assignment asn = new Assignment();
		course.addAssignment(asn);
		Assertions.assertEquals(1, course.assignmentList.size());
	}

	@Test
	public void testCourseName() {
		Course course = new Course("course-name", CourseLevel.COURSE_LEVEL.HighLevel);
		Assertions.assertEquals("course-name", course.toString());
	}

	@Test
	public void testCourseAccept() {
		Course course = new Course("course-name", CourseLevel.COURSE_LEVEL.HighLevel);
		course.addAssignment(new Assignment());
		Reminder reminder = new Reminder();
		ReminderVisitor reminderVisitor = new ReminderVisitor(reminder);
		course.accept(reminderVisitor);
		java.awt.List list = reminder.getListUpcoming();
		Assertions.assertEquals(1, list.getItems().length);
	}
}
