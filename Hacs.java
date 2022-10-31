package hacs;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 *
 * @author Zahra Falah
 * @version 2.0
 * <p>
 * Update to Java 8
 */

public class Hacs {

	static Facade facade = new Facade();

	public Hacs() {
	}

	public static void main(String[] args) {
		UserInfoItem userinfoitem = new UserInfoItem();
		facade.createCourseList();
		while (true) {
			boolean bExit;
			bExit = facade.login(userinfoitem);
			if (bExit) {
				break;
			}

			facade.CreateUser(userinfoitem);
			facade.attachCourseToUser();

			// if this is a student, then remind him of the due date
			if (userinfoitem.userType == UserInfoItem.USER_TYPE.Student) {
				facade.Remind();
			}

			boolean btnLogout = false;
			while (!btnLogout) {
				btnLogout = facade.selectCourse();
				if (btnLogout) {
					break;
				}
				btnLogout = facade.courseOperation();
			}
		}
	}
}