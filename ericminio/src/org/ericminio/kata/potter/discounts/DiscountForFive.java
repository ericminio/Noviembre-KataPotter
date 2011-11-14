package org.ericminio.kata.potter.discounts;

import java.util.List;

import org.ericminio.kata.potter.Basket;
import org.ericminio.kata.potter.Book;
import org.ericminio.kata.potter.Discount;

public class DiscountForFive implements Discount {

	public boolean hasEnoughDifferentBooks(Basket basket) {
		return basket.tryToSelectDifferent(5).size() == 5;
	}

	public List<Book> selectBooks(Basket basket) {
		return basket.tryToSelectDifferent(5);
	}

	public Double priceOf(Basket basket) {
		return 5*8*0.75;
	}

}
