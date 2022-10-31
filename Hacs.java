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
		// String strUsername;
		// String strUserType = null;
		UserInfoItem userinfoitem = new UserInfoItem();
		facade.createCourseList();
		while (true) {
			boolean bExit;
			bExit = facade.login(userinfoitem);
			if (bExit)
				break;
			// userinfoitem.strUserName = "Inst1";
			// userinfoitem.UserType = 1;
			facade.CreateUser(userinfoitem);
			facade.attachCourseToUser();
			// if is a student remind him of the due date
			if (userinfoitem.userType == UserInfoItem.USER_TYPE.Student)
				facade.Remind();
			boolean bLogout = false;
			while (!bLogout) {
				bLogout = facade.selectCourse();
				if (bLogout)
					break;
				bLogout = facade.courseOperation();
			}
		}
	}
}