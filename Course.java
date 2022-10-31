package hacs;

import java.util.ArrayList;

/**
 * Title:        HACS
 * Description:  CSE870 Homework 3:  Implementing Design Patterns
 * Copyright:    Copyright (c) 2002
 * Company:      Department of Computer Science and Engineering, Michigan State University
 *
 * @author Zahra Falah
 * @version 2.0
 * Update to Java 8
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

	void accept(NodeVisitor visitor) {
		visitor.visitCourse(this);
	}

}