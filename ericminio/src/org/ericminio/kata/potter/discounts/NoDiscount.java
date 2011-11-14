package org.ericminio.kata.potter.discounts;

import java.util.ArrayList;
import java.util.List;

import org.ericminio.kata.potter.Basket;
import org.ericminio.kata.potter.Book;
import org.ericminio.kata.potter.Discount;

public class NoDiscount implements Discount {

	public boolean hasEnoughDifferentBooks(Basket basket) {
		return true;
	}

	public Double priceOf(Basket basket) {
		return 8.0 * basket.size();
	}

	public List<Book> selectBooks(Basket basket) {
		List<Book> selection = new ArrayList<Book>();
		for (Book book : basket) {
			selection.add(book);
		}
		return selection;
	}

}
