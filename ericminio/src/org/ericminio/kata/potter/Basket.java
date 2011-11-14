package org.ericminio.kata.potter;

import java.util.ArrayList;
import java.util.List;

public class Basket extends ArrayList<Book> {

	public void remove(List<Book> books) {
		for (Book book : books) {
			this.remove(book);
		}
	}

	public List<Book> tryToSelectDifferent(int count) {
		List<Book> selection = new ArrayList<Book>();
		for (Book book : this) {
			if (!selection.contains(book)) {
				selection.add(book);
				if (selection.size() == count ) {
					break;
				}
			}
		}
		return selection;
	}
}
