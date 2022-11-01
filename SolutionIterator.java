package hacs;

import java.util.Iterator;

/**
 * @author Zahra Falah
 */

public class SolutionIterator implements Iterator {
	SolutionList solutionlist;

	// CurrentSolutionNumber: point to the location before the first element
	int currentSolutionNumber = -1;

	public SolutionIterator(SolutionList list) {
		solutionlist = list;
		moveToHead();
	}

	public void moveToHead() {
		// CurrentSolutionNumber: point to the location before the first element
		currentSolutionNumber = -1;
	}

	public boolean hasNext() {
		return currentSolutionNumber < solutionlist.size() - 1;
	}

	public Object next() {
		if (hasNext()) {
			currentSolutionNumber++;
			return solutionlist.get(currentSolutionNumber);
		} else {
			return null;
		}
	}

	public Object next(String UserName) {
		Solution theSolution;
		theSolution = (Solution) next();
		while (theSolution != null) {
			if (UserName.compareTo(theSolution.getAuthor()) == 0) {
				return theSolution;
			}
			theSolution = (Solution) next();
		}
		return null;
	}

	public void remove() {
		solutionlist.remove(currentSolutionNumber);
	}

}