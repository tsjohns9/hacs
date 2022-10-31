package hacs;

import java.util.ArrayList;

/**
 * @author Zahra Falah
 */

public class Course {
	public ArrayList<Assignment> assignmentList = new ArrayList<>();
	String courseName;
	int numberOfAssignments;
	CourseLevel.COURSE_LEVEL courseLevel;


	public Course(String courseName, CourseLevel.COURSE_LEVEL courseLevel) {
		this.courseName = courseName;

		// 0 HighLeve presentation    1  LowLevel Experiment
		this.courseLevel = courseLevel;
		this.numberOfAssignments = 0;
	}

	public void addAssignment(Assignment assignment) {
		assignmentList.add(assignment);
	}

	public String toString() {
		return courseName;
	}

	public void accept(NodeVisitor visitor) {
		visitor.visitCourse(this);
	}

}