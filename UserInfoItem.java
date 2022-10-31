package hacs;

/**
 * @author Zahra Falah
 */

public class UserInfoItem {
	String userName;
	// 0 : Student, 1: Instructor
	USER_TYPE userType;

	public enum USER_TYPE {Student, Instructor}
}