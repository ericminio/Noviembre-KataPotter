package org.ericminio.kata.potter.builders;

import static org.ericminio.kata.potter.builders.BasketBuilder.aBasket;
import static org.ericminio.kata.potter.builders.BookBuilder.aBook;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.ericminio.kata.potter.Book;
import org.junit.Test;

public class BasketBuilderTest {

	@Test
	public void canContainOneBook() {
		Book first = aBook().build();
		assertThat(aBasket().with(first).build()
					.contains(first), is(true));
	}
	
	@Test
	public void canContainTwoBooks() {
		Book first = aBook().build();
		Book second = aBook().build();
		assertThat(aBasket().with(first)
							.and(second).build()
					.contains(second), is(true));
	}
	
}
