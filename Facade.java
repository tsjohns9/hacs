package hacs;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 *
 * @author Zahra Falah
 * @version 2.0
 * <p>
 * Update to Jave 8
 */

public class Facade {
	public UserInfoItem.USER_TYPE userType;
	ClassCourseList courseList;
	Person person;
	private Course selectedCourse = null;
	private int courseLevel = 0;

	public Facade() {
	}

	static public boolean login(UserInfoItem userinfoItem) {
		Login login = new Login();
		login.setModal(true);
		login.show();
		userinfoItem.userName = login.getUserName();
		userinfoItem.userType = login.getUserType();
		return login.isExit();
	}

	//functions for CourseMenu
	/*
	 * When click the add button of the CourseMenu , call this function this
	 * function will new an assignment fill the required infomation this function
	 * will call InstructorAssignmentMenu or StudentAssignmentMenu according to the
	 * type of the user it will not update the course menu. the coursemenu need to
	 * refreshed outside the function
	 */

	void addAssignment(Course course) {
		AssignmentMenu theAssignmentMenu;
		// student
		if (person.type == UserInfoItem.USER_TYPE.Student) {
			theAssignmentMenu = new StudentAssignmentMenu();
		} else {
			theAssignmentMenu = new InstructorAssignmentMenu();
		}
		Assignment assignment = new Assignment();
		theAssignmentMenu.showMenu(assignment, person);
		course.addAssignment(assignment);
	}

	/*
	 * When click the view button of the CourseMenu , call this function and pass
	 * the pointer of the Assignment and the person pointer to this function this
	 * function will new an assignment fill the required infomation this function
	 * will call InstructorAssignmentMenu or StudentAssignmentMenu according to the
	 * type of the user
	 */
	void viewAssignment(Assignment assignment) {
		AssignmentMenu assignmentMenu;
		// student
		if (person.type == UserInfoItem.USER_TYPE.Student) {
			assignmentMenu = new StudentAssignmentMenu();
		} else {
			assignmentMenu = new InstructorAssignmentMenu();
		}

		assignmentMenu.showMenu(assignment, person);
	}

	// functions for InstructorAssignmentMenu
	/*
	 * this function will grade the give Solution: theSolution this function calls
	 */

	void gradeSolution(Solution solution) {
		SolutionMenu solutionMenu = new SolutionMenu();
		solutionMenu.ShowMenu(solution);
	}

	void reportSolutions(Assignment assignment) {
		Solution theSolution;
		SolutionIterator theSolutionIterator;
		theSolutionIterator = assignment.getSolutionIterator();
		theSolution = (Solution) theSolutionIterator.next();
		while (theSolution != null) {
			theSolution.setReported(true);
			theSolution = (Solution) theSolutionIterator.next();
		}
	}

	// functions for StudentAssignmentMenu
	void SubmitSolution(Assignment assignment, Solution solution) {
		assignment.addSolution(solution);
	}

	void Remind() {
		Reminder theReminder = new Reminder();
		theReminder.showReminder(person.getCourseList());
	}

	void CreateUser(UserInfoItem userinfoitem) {
		// student
		if (userinfoitem.userType == UserInfoItem.USER_TYPE.Student) {
			person = new Student();
		} else {
			person = new Instructor();
		}
		person.userName = userinfoitem.userName;
	}

	/*
	 * create a course list and intitialize it with the file CourseInfo.txt
	 */
	void createCourseList() {
		courseList = new ClassCourseList();
		courseList.initializeFromFile("CourseInfo.txt");
	}

	/*
	 * call this function after create user, create courselist read the
	 * UserCourse.txt file match the coursename with theCouresList attach the
	 * Matched course object to the new create user Facade.thePerson.CourseList
	 */
	void attachCourseToUser() {
		BufferedReader file;
		try {
			file = new BufferedReader(new FileReader("UserCourse.txt"));
			String aline, strUserName, strCourseName;
			// not the EOF
			while ((aline = file.readLine()) != null) {
				strUserName = getUserName(aline);
				strCourseName = getCourseName(aline);
				// the UserName mateches
				if (strUserName.compareTo(person.userName) == 0) {
					selectedCourse = findCourseByCourseName(strCourseName);
					// Find the Course in the CourseList--->attach
					if (selectedCourse != null) {
						person.addCourse(selectedCourse);
					}
				}
			}
		} catch (Exception ignored) {
		}
	}

	/*
	 * get the user name from aline UserName:CourseName
	 */
	private String getUserName(String aline) {
		int Sep = aline.lastIndexOf(':');
		return aline.substring(0, Sep);
	}

	/*
	 * get the CourseName from aline UserName:CourseName
	 */
	private String getCourseName(String aline) {
		int Sep = aline.lastIndexOf(':');
		return aline.substring(Sep + 1, aline.length());
	}

	/*
	 * show the course selection dlg, show the course attatched to theperson and
	 * return the selected course and assign the course to the class member
	 * theSelecteCourse, the Course Level to CourseLevel CourseLeve=0 High,
	 * CourseLeve=1 Low
	 */
	public boolean selectCourse() {
		CourseSelectDlg theDlg = new CourseSelectDlg();
		selectedCourse = theDlg.showDlg(person.courseList);
		person.currentCourse = selectedCourse;
		courseLevel = theDlg.courseLevel;
		return theDlg.isLogout();
	}

	/*
	 * call the thePerson.CreateCourseMenu according to the really object(student or
	 * instructor) and the nCourseLevel it will call different menu creater and show
	 * the menu;
	 */

	public boolean courseOperation() {
		person.createCourseMenu(selectedCourse, courseLevel);
		// 0: logout 1 select another course
		return person.showMenu();
	}

	/*
	 * find the course in theCourseList that matches strCourseName 1 create a
	 * CourseIterator for the List 2 Find the Course with the Iterator return the
	 * pointer of the Course if not fine, return null;
	 */
	private Course findCourseByCourseName(String strCourseName) {
		CourseIterator Iterator = new CourseIterator(courseList);
		return (Course) Iterator.next(strCourseName);
	}

}