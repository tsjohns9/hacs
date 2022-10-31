import hacs.*;
import junit.framework.Assert;
import org.junit.Test;

public class TestFacade {
	private Assert Assertions;

	@Test
	public void testFacadeReportSolutions() {
		Facade facade = new Facade();
		Assignment assignment = new Assignment();
		Solution sol = new Solution();
		facade.submitSolution(assignment, sol);
		Assertions.assertFalse(sol.isReported());
		facade.reportSolutions(assignment);
		Assertions.assertTrue(sol.isReported());
	}

	@Test
	public void testFacadeCreateUser() {
		Facade facade = new Facade();
		UserInfoItem info = new UserInfoItem("student-name", UserInfoItem.USER_TYPE.Student);
		facade.createUser(info);

		Assertions.assertEquals(UserInfoItem.USER_TYPE.Student, facade.getPerson().getUserType());

		info = new UserInfoItem("instructor-name", UserInfoItem.USER_TYPE.Instructor);
		facade.createUser(info);
		Assertions.assertEquals(UserInfoItem.USER_TYPE.Instructor, facade.getPerson().getUserType());
	}


	@Test
	public void testFacadeAttachCourseToUser() {
		Facade facade = new Facade();
		UserInfoItem info = new UserInfoItem("pepe", UserInfoItem.USER_TYPE.Student);
		facade.createCourseList();
		facade.createUser(info);
		facade.attachCourseToUser();
		Person person = facade.getPerson();
		Assertions.assertEquals(2, person.getCourseList().size());

		// expect no courses since instructor name is not in the course list
		facade = new Facade();
		info = new UserInfoItem("instructor-name", UserInfoItem.USER_TYPE.Instructor);
		facade.createUser(info);
		facade.createCourseList();
		facade.attachCourseToUser();
		person = facade.getPerson();
		Assertions.assertEquals(0, person.getCourseList().size());
	}

}
