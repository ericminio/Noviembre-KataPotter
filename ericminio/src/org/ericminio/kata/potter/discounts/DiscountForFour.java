package org.ericminio.kata.potter.discounts;

import java.util.List;

import org.ericminio.kata.potter.Basket;
import org.ericminio.kata.potter.Book;
import org.ericminio.kata.potter.Discount;

public class DiscountForFour implements Discount {

	public boolean hasEnoughDifferentBooks(Basket basket) {
		return basket.tryToSelectDifferent(4).size() == 4;
	}

	public List<Book> selectBooks(Basket basket) {
		return basket.tryToSelectDifferent(4);
	}

	public Double priceOf(Basket basket) {
		return 4*8*0.8;
	}

}
