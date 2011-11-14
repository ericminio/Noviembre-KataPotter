package org.ericminio.kata.potter.discounts;

import static org.ericminio.kata.potter.builders.BasketBuilder.aBasket;
import static org.ericminio.kata.potter.data.Books.volume1;
import static org.ericminio.kata.potter.data.Books.volume2;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.ericminio.kata.potter.Basket;
import org.ericminio.kata.potter.Book;
import org.ericminio.kata.potter.discounts.NoDiscount;
import org.junit.Before;
import org.junit.Test;

public class NoDiscountTest {

	private NoDiscount noDiscount;
	@Before
	public void setUp() throws Exception {
		noDiscount = new NoDiscount();
	}
	
	@Test public void
	everyBasketMatch() {
		assertTrue(noDiscount.hasEnoughDifferentBooks(aBasket().build()));
	}
	
	@Test public void
	priceOnlyDependsOnTheSizeOfTheBasket() {
		assertThat(noDiscount.priceOf(aBasket().with(volume1()).build()), is(8.0));
		assertThat(noDiscount.priceOf(aBasket().with(volume1()).and(volume2()).build()), is(2 * 8.0));
	}
	
	@Test public void
	discountConcernsAlltheBasket() {
		Basket basket = aBasket().with(volume1()).and(volume2()).build();
		List<Book> selection = noDiscount.selectBooks(basket);
		assertTrue(selection.contains(volume1()));
		assertTrue(selection.contains(volume1()));
		assertThat(selection.size(), is(2));
	}

}
