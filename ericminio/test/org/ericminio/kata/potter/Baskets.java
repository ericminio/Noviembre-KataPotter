package org.ericminio.kata.potter;

import java.util.ArrayList;
import java.util.List;

public class Baskets {

	public static List<Book> anEmptyBasket() {
		return new ArrayList<Book>();
	}
	
	public static List<Book> aBasketWithBook(final String title) {
		List<Book> basket = new ArrayList<Book>();
		basket.add(aBookWithTitle(title));
		return basket;
	}

	public static List<Book> aBasketWithBooks(final String... titles) {
		List<Book> basket = new ArrayList<Book>();
		for (String title : titles) {
			basket.add(aBookWithTitle(title));
		}
		return basket;
	}

	protected static Book aBookWithTitle(final String title) {
		return new Book() {
			public String title() {
				return title;
			}
		};
	}

	
}
