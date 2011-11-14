package org.ericminio.kata.potter.data;

import static org.ericminio.kata.potter.builders.BookBuilder.aBook;

import org.ericminio.kata.potter.Book;

public class Books {

	public static Book volume1() {
		return aBook().withTitle("Wizard school").build();
	}
	public static Book volume2() {
		return aBook().withTitle("Secret chamber").build();
	}
	public static Book volume3() {
		return aBook().withTitle("Azkabhan prisoner").build();
	}
	public static Book volume4() {
		return aBook().withTitle("Goblet of fire").build();
	}
	public static Book volume5() {
		return aBook().withTitle("Phoenix order").build();
	}
	public static Book volume6() {
		return aBook().withTitle("Half blood prince").build();
	}
}
