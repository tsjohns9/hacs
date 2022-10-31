package hacs;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * @author Zahra Falah
 */

public class Facade {
	ClassCourseList courseList;
	Person person;
	private Course selectedCourse = null;
	private CourseLevel.COURSE_LEVEL courseLevel = CourseLevel.COURSE_LEVEL.HighLevel;

	public Facade() {
	}

	public Person getPerson() {
		return person;
	}

	public boolean login(UserInfoItem userinfoItem) {
		Login login = new Login();
		login.setModal(true);
		login.show();
		userinfoItem.userName = login.getUserName();
		userinfoItem.userType = login.getUserType();
		return login.isExit();
	}

	void addAssignment(Course course) {
		AssignmentMenu theAssignmentMenu;
		if (person.type == UserInfoItem.USER_TYPE.Student) {
			theAssignmentMenu = new StudentAssignmentMenu();
		} else {
			theAssignmentMenu = new InstructorAssignmentMenu();
		}
		Assignment assignment = new Assignment();
		theAssignmentMenu.showMenu(assignment, person);
		course.addAssignment(assignment);
	}

	void viewAssignment(Assignment assignment) {
		AssignmentMenu assignmentMenu;
		if (person.type == UserInfoItem.USER_TYPE.Student) {
			assignmentMenu = new StudentAssignmentMenu();
		} else {
			assignmentMenu = new InstructorAssignmentMenu();
		}

		if (assignment != null) {
			assignmentMenu.showMenu(assignment, person);
		} else {
			System.out.println("no assignment selected");
		}
	}

	void gradeSolution(Solution solution) {
		SolutionMenu solutionMenu = new SolutionMenu();
		solutionMenu.ShowMenu(solution);
	}

	public void reportSolutions(Assignment assignment) {
		Solution theSolution;
		SolutionIterator theSolutionIterator;
		theSolutionIterator = assignment.getSolutionIterator();
		theSolution = (Solution) theSolutionIterator.next();
		while (theSolution != null) {
			theSolution.setReported(true);
			theSolution = (Solution) theSolutionIterator.next();
		}
	}

	public void submitSolution(Assignment assignment, Solution solution) {
		assignment.addSolution(solution);
	}

	void remind() {
		Reminder theReminder = new Reminder();
		theReminder.showReminder(person.getCourseList());
	}

	public void createUser(UserInfoItem userinfoitem) {
		if (userinfoitem.userType == UserInfoItem.USER_TYPE.Student) {
			person = new Student();
		} else {
			person = new Instructor();
		}
		person.userName = userinfoitem.userName;
	}

	/*
	 * create a course list and initialize it with the file CourseInfo.txt
	 */
	public void createCourseList() {
		courseList = new ClassCourseList();
		courseList.initializeFromFile("CourseInfo.txt");
	}

	public void attachCourseToUser() {
		BufferedReader file;
		try {
			file = new BufferedReader(new FileReader("UserCourse.txt"));
			String line, strUserName, strCourseName;

			while ((line = file.readLine()) != null) {
				strUserName = getUserName(line);
				strCourseName = getCourseName(line);

				if (strUserName.compareTo(person.userName) == 0) {
					selectedCourse = findCourseByCourseName(strCourseName);

					if (selectedCourse != null) {
						person.addCourse(selectedCourse);
					}
				}
			}
		} catch (Exception ignored) {
		}
	}

	/*
	 * get the username from str UserName:CourseName
	 */
	private String getUserName(String str) {
		int Sep = str.lastIndexOf(':');
		return str.substring(0, Sep);
	}

	/*
	 * get the CourseName from str UserName:CourseName
	 */
	private String getCourseName(String str) {
		int Sep = str.lastIndexOf(':');
		return str.substring(Sep + 1);
	}

	public boolean selectCourse() {
		CourseSelectDlg theDlg = new CourseSelectDlg();
		selectedCourse = theDlg.showDlg(person.courseList);
		person.currentCourse = selectedCourse;
		courseLevel = theDlg.courseLevel;
		return theDlg.isLogout();
	}

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