package org.ericminio.kata.potter;

import java.util.List;

public class PriceFixture {

	public static Integer priceOf(List<Book> basket) {
		return new Library().priceOf(basket);
	}
}
