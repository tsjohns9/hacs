package hacs;

import java.text.DateFormat;
import java.util.Date;

/**
 * @author Zahra Falah
 */

public class Assignment {

	protected Date dueDate = new Date();
	protected String assignmentSpec;
	protected SolutionList solutionList = new SolutionList();
	protected Solution suggestSolution = new Solution();
	private String assignmentName;


	public Assignment() {
	}

	public String getAssignmentName() {
		return assignmentName;
	}

	public void setAssignmentName(String name) {
		this.assignmentName = name;
	}

	public void setDueDate(Date theDueDate) {
		this.dueDate = theDueDate;
	}

	public String getAssignmentSpec() {
		return this.assignmentSpec;
	}

	public void setAssignmentSpec(String spec) {
		this.assignmentSpec = spec;
	}

	public boolean isOverDue() {
		Date today;
		today = new Date();
		return today.after(this.dueDate);
	}

	public void addSolution(Solution theSolution) {
		solutionList.add(theSolution);
	}

	public SolutionList getSolutionList() {
		return solutionList;
	}

	public Solution getSolution(String studentName) {
		SolutionIterator Iterator = getSolutionIterator();
		return (Solution) Iterator.next(studentName);
	}

	public Solution getSuggestedSolution() {
		return suggestSolution;
	}

	public SolutionIterator getSolutionIterator() {
		return new SolutionIterator(solutionList);
	}

	public String toString() {
		return assignmentName;
	}

	public String getDueDateString() {
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
		return dateFormat.format(dueDate);
	}

	public void accept(NodeVisitor visitor) {
		visitor.visitAssignment(this);
	}
}