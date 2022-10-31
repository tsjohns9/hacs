import hacs.*;
import junit.framework.Assert;
import org.junit.Test;

import java.text.DateFormat;
import java.util.Date;

public class TestAssignment {
	private Assert Assertions;

	@Test
	public void testAssignmentGetDueDateString() {
		Assignment asn = new Assignment();

		Date dueDate = new Date();
		asn.setDueDate(dueDate);

		// create a date with the same format that the isOverDue method uses
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
		String expected = dateFormat.format(dueDate);
		Assertions.assertEquals(expected, asn.getDueDateString());
		Assertions.assertTrue(asn.isOverDue());
	}

	@Test
	public void testAssignmentAddSolution() {
		// Test that an assignment can have more than one solution in the solutionList
		Assignment asn = new Assignment();
		Solution sol = new Solution();
		asn.addSolution(sol);
		SolutionList solList = asn.getSolutionList();
		Assertions.assertEquals(1, solList.size());


		sol = new Solution();
		asn.addSolution(sol);
		Assertions.assertEquals(2, solList.size());
	}

	@Test
	public void testGetSolution() {
		Assignment asn = new Assignment();
		Solution sol = new Solution();
		asn.addSolution(sol);
		sol =	asn.getSolution("abc");
		Assertions.assertNull(sol);
	}

	@Test
	public void getSuggestedSolution() {
		Assignment asn = new Assignment();
		Solution sol = new Solution();
		asn.addSolution(sol);
		sol =	asn.getSuggestedSolution();
		Assertions.assertNotNull(sol);
	}

	@Test
	public void testAccept() {
		Assignment asn = new Assignment();
		Solution sol = new Solution();
		Reminder reminder = new Reminder();
		ReminderVisitor visitor = new ReminderVisitor(reminder);
		asn.accept(visitor);
		java.awt.List list = reminder.getListUpcoming();
		Assertions.assertEquals(1, list.getItems().length);
	}

	@Test
	public void testAssignmentName() {
		String assignment1 = "Assignment1";
		Assignment asn = new Assignment();
		asn.setAssignmentName(assignment1);
		String name = asn.getAssignmentName();
		Assertions.assertEquals(assignment1, name);
		Assertions.assertEquals(assignment1, asn.toString());
	}

	@Test
	public void testSetAssignmentSpec() {
		Assignment asn = new Assignment();
		String spec1 = "Spec1";
		asn.setAssignmentSpec(spec1);
		String name = asn.getAssignmentSpec();
		Assertions.assertEquals(spec1, name);
	}
}
