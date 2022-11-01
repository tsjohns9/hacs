package hacs;

import java.util.Date;

/**
 * @author Zahra Falah
 */

public class Solution {
	private String author = "";

	private String solutionFileName = "";
	Date submitDate = new Date();
	private int grade;
	boolean reported = false;

	public Solution() {
	}

	public String getSolutionFileName() {
		return solutionFileName;
	}

	public void setSolutionFileName(String solutionFileName) {
		this.solutionFileName = solutionFileName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		String string;
		string = author + " " + solutionFileName + " Grade=" + getGradeInt() + " ";
		if (isReported())
			string += "reported";
		else
			string += "not reported";

		return string;
	}

	public String getGradeString() {
		if (isReported())
			return "" + grade;
		else
			return "-1";
	}

	public void setGradeInt(int grade){
		this.grade = grade;
	}


	public int getGradeInt() {
		return grade;
	}

	public boolean isReported() {
		return reported;
	}

	public void setReported(boolean reported) {
		this.reported = reported;
	}
}