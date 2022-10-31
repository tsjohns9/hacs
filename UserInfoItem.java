package hacs;

/**
 * @author Zahra Falah
 */

public class UserInfoItem {
	String userName;
	// 0 : Student, 1: Instructor
	USER_TYPE userType;

	UserInfoItem() {
	}

	public UserInfoItem(String userName, USER_TYPE userType) {
		this.userName = userName;
		this.userType = userType;
	}

	public void setUserType(USER_TYPE userType) {
		this.userType = userType;
	}

	public enum USER_TYPE {Student, Instructor}
}