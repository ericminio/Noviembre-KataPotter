package org.ericminio.kata.potter.builders;

import org.ericminio.kata.potter.Book;

public class BookBuilder {

	private String title;
	
	private BookBuilder() {
		this.title = "";
	}
	
	public static BookBuilder aBook() {
		return new BookBuilder(); 
	}
	
	public BookBuilder withTitle(String title) {
		this.title = title;
		return this;
	}
	
	public Book build() {
		return new Book() {
			public String title() {
				return BookBuilder.this.title;
			}
			public boolean equals(Object o) {
				return ((Book)o).title().equalsIgnoreCase(this.title());
			}
		};
	}
}
