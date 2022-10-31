package hacs;

import java.util.Date;

/**
 * @author Zahra Falah
 */

public class Solution {
	String author = "";
	String solutionFileName = "";
	Date submitDate = new Date();
	int grade;
	boolean reported = false;

	public Solution() {
	}

	@Override
	public String toString() {
		String string;
		string = author + "  " + solutionFileName + " Grade=" + getGradeInt() + "  ";
		if (isReported())
			string += "reported";
		else
			string += "not reported";

		return (string);
	}

	String getGradeString() {
		if (isReported())
			return "" + grade;
		else
			return "-1";
	}

	int getGradeInt() {
		return grade;
	}

	public boolean isReported() {
		return reported;
	}

	public void setReported(boolean reported) {
		this.reported = reported;
	}
}