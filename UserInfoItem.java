package hacs;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 *
 * @author Zahra Falah
 * @version 2.0
 * <p>
 * Update to Java 8
 */

public class UserInfoItem {
	String userName;
	// 0 : Student, 1: Instructor
	USER_TYPE userType;

	public enum USER_TYPE {Student, Instructor}
}