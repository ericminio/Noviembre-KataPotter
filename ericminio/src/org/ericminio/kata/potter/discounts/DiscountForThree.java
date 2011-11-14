package org.ericminio.kata.potter.discounts;

import java.util.List;

import org.ericminio.kata.potter.Basket;
import org.ericminio.kata.potter.Book;
import org.ericminio.kata.potter.Discount;


public class DiscountForThree implements Discount {

	public boolean hasEnoughDifferentBooks(Basket basket) {
		return basket.tryToSelectDifferent(3).size() == 3;
	}

	public List<Book> selectBooks(Basket basket) {
		return basket.tryToSelectDifferent(3);
	}

	public Double priceOf(Basket basket) {
		return 3 * 8 * 0.9;
	}
	
}
