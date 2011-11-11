package org.ericminio.kata.potter;

import java.util.List;

public class Library {

	public Integer priceOf(List<Book> basket) {
		return 8 * basket.size();
	}

}
