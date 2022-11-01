package hacs;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Zahra Falah
 */

public class ListIterator implements Iterator<Object> {
	ArrayList<Object> list;
	int currentNumber = -1;

	public ListIterator(ArrayList<Object> list) {
		this.list = list;
	}

	public boolean hasNext() {
		return currentNumber < list.size() - 1;
	}

	public Object next() {
		if (hasNext()) {
			currentNumber++;
			return list.get(currentNumber);
		} else {
			return null;
		}
	}

	public void remove() {
		list.remove(currentNumber);
		currentNumber--;
	}
}