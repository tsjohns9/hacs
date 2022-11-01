import hacs.Solution;
import junit.framework.Assert;
import org.junit.Test;

public class TestSolution {
	private Assert Assertions;
	@Test
	public void testGetGradeString(){
		Solution solution = new Solution();
		String sol= solution.getGradeString();
		Assertions.assertEquals("-1", sol);

		solution.setReported(true);
		solution.setGradeInt(1);
		sol = solution.getGradeString();
		Assertions.assertEquals("1", sol);

	}

	@Test
	public void testToString(){
		Solution solution = new Solution();
		solution.setAuthor("Pepe");
		solution.setGradeInt(1);
		solution.setSolutionFileName("FileName");
		String sol = solution.toString();
		Assertions.assertEquals("Pepe FileName Grade=1 not reported", sol);

		solution.setReported(true);
		sol = solution.toString();
		Assertions.assertEquals("Pepe FileName Grade=1 reported", sol);


		Assertions.assertEquals("Pepe", solution.getAuthor());
		Assertions.assertEquals("FileName", solution.getSolutionFileName());
	}

	@Test
	public void testGetGradeInt(){
		Solution solution = new Solution();
		solution.setGradeInt(1);
		int sol = solution.getGradeInt();

		Assertions.assertEquals(1, sol);


	}


}
