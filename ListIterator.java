package hacs;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 *
 * @author Zahra Falah
 * @version 2.0 use <e> notation
 */

public class ListIterator implements Iterator<Object> {
	ArrayList<Object> list;
	int currentNumber = -1;

	public ListIterator() {
	}

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
	}
}