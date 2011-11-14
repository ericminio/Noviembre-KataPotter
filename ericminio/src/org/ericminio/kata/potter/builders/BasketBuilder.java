package org.ericminio.kata.potter.builders;

import org.ericminio.kata.potter.Basket;
import org.ericminio.kata.potter.Book;


public class BasketBuilder {

	private Basket basket;
	
	private BasketBuilder() {
		basket = new Basket();
	}
	
	public static BasketBuilder aBasket() {
		return new BasketBuilder();
	}

	public BasketBuilder with(Book book) {
		basket.add(book);
		return this;
	}

	public BasketBuilder and(Book book) {
		return with(book);
	}

	public Basket build() {
		return basket;
	}

	public BasketBuilder with(int count, Book book) {
		for (int i=0; i<count; i++) {
			with(book);
		}
		return this;
	}

	public BasketBuilder and(int count, Book book) {
		return with(count, book);
	}
}
