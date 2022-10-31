package hacs;

import java.util.Calendar;
import java.util.Date;

/**
 * @author Zahra Falah
 */

/*
 * Iterates the course list attached to a student and in turn, and then iterate the assignments of a course.
 * After Function Visit(CourseList) it will point to the location before the fist class.
 * hasNext will return if there is another item. the next() will return the next Item Assignment;
 */

public class ReminderVisitor extends NodeVisitor {

	Reminder reminder;

	public ReminderVisitor(Reminder reminder) {
		this.reminder = reminder;
	}

	public void visitFacade(Facade facade) {
		CourseIterator courseList = new CourseIterator(facade.courseList);
		while (courseList.hasNext()) {
			Course course = (Course) courseList.next();
			course.accept(this);
		}
	}

	public void visitCourse(Course course) {
		for (Assignment assignment : course.assignmentList) {
			assignment.accept(this);
		}
	}

	public void visitAssignment(Assignment assignment) {
		Date today = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(today);
		int ntoday = calendar.get(Calendar.DAY_OF_YEAR);
		calendar.setTime(assignment.dueDate);
		int nDueDate = calendar.get(Calendar.DAY_OF_YEAR);

		// upcoming
		if (nDueDate <= (ntoday + 1) && nDueDate >= ntoday) {
			reminder.listUpcoming.add("today is " + today + " " + assignment.getAssignmentName() + " Due Date is "
					+ assignment.getDueDateString());
		}
		if (nDueDate < ntoday) {
			reminder.listOverdue.add(assignment.getAssignmentName() + " Due Date is " + assignment.getDueDateString());
		}

	}

}