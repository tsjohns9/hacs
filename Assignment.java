package hacs;

/**
 * Title:        HACS
 * Description:  CSE870 Homework 3:  Implementing Design Patterns
 * Copyright:    Copyright (c) 2002
 * Company:      Department of Computer Science and Engineering, Michigan State University
 *
 * @author Zahra Falah
 * @version 1.0
 */

import java.text.DateFormat;
import java.util.Date;

public class Assignment {

	protected String assignmentName;
	protected String assignmentFileName;
	protected Date dueDate = new Date();
	protected String assignmentSpec;
	protected SolutionList solutionList = new SolutionList();
	protected Solution suggestSolution = new Solution();


	public Assignment() {
	}

	public void setDueDate(Date theDueDate) {
		this.dueDate = theDueDate;
	}

	public void setAssignmentSpec(String spec) {
		this.assignmentSpec = spec;
	}

	public boolean isOverDue() {
		Date today;
		today = new Date();
		return today.after(this.dueDate);
	}

	public Solution addSolution() {
		return new Solution();
	}

	public void addSolution(Solution theSolution) {
		solutionList.add(theSolution);
	}

	public void submitSolution() {
	}

	public void getSolutionList() {
	}

	/* return the solution of the give name
	 */
	public Solution getSolution(String studentname) {
		SolutionIterator Iterator = (SolutionIterator) solutionList.iterator();
		return (Solution) Iterator.next(studentname);
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