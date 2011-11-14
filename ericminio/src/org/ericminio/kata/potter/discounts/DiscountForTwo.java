package org.ericminio.kata.potter.discounts;

import java.util.List;

import org.ericminio.kata.potter.Basket;
import org.ericminio.kata.potter.Book;
import org.ericminio.kata.potter.Discount;

public class DiscountForTwo implements Discount {

	public boolean hasEnoughDifferentBooks(Basket basket) {
		return basket.tryToSelectDifferent(2).size() == 2;
	}

	public List<Book> selectBooks(Basket basket) {
		return basket.tryToSelectDifferent(2);
	}

	public Double priceOf(Basket basket) {
		return 2 * 8 * 0.95;
	}

}
