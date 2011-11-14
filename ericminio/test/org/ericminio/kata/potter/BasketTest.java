package org.ericminio.kata.potter;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import static org.ericminio.kata.potter.builders.BasketBuilder.aBasket;
import static org.ericminio.kata.potter.builders.BookBuilder.aBook;
import static org.ericminio.kata.potter.data.Books.volume1;
import static org.ericminio.kata.potter.data.Books.volume2;
import static org.ericminio.kata.potter.data.Books.volume3;

public class BasketTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void canRemoveSeveralBooks() {
		Basket basket = aBasket().with(volume1()).and(volume2()).and(volume3()).build();
		basket.remove(aBasket().with(volume1()).and(volume2()).build());
		assertThat(basket.size(), is(1));
		assertThat(basket.contains(volume3()), is(true));
	}
	
	@Test
	public void canSelect2DifferentBooksFromTheBasket() {
		Basket basket = aBasket().with(volume1()).and(volume2()).and(volume3()).build();
		List<Book> selection = basket.tryToSelectDifferent(2);
		assertFalse(selection.get(0) == selection.get(1));
	}
	
	@Test
	public void canSelect3DifferentBooksFromTheBasket() {
		Basket basket = aBasket().with(volume1()).and(volume2()).and(volume3()).build();
		List<Book> selection = basket.tryToSelectDifferent(3);
		assertFalse(selection.get(0) == selection.get(1));
		assertFalse(selection.get(1) == selection.get(2));
	}
	
	@Test
	public void canNotSelectTwoDifferentBookWithABasketWithTwotimesTheSameBook() {
		Basket basket = aBasket().with(2, volume1()).build();
		List<Book> selection = basket.tryToSelectDifferent(2);
		assertThat(selection.size(), is(1));
	}
}
