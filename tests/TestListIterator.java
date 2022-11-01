import hacs.ListIterator;
import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class TestListIterator {
	private Assert Assertions;
	@Test
	public void testListIterator(){
		ArrayList<Object> testList = new ArrayList<>();
		testList.add("item1");
		testList.add("item2");
		testList.add("item3");
		ListIterator iterator = new ListIterator(testList);

		Assertions.assertTrue(iterator.hasNext());
		Object iter = iterator.next();
		Assertions.assertNotNull(iter);
		iter = iterator.next();
		iter = iterator.next();
		iter = iterator.next();

		Assertions.assertNull(iter);
		iterator.remove();
		Assertions.assertEquals(2, testList.size());

		iterator.remove();
		iterator.remove();
		Assertions.assertEquals(0, testList.size());
		Assertions.assertFalse(iterator.hasNext());
	}
}
