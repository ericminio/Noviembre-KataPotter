package org.ericminio.kata.potter.discounts;


import static org.ericminio.kata.potter.builders.BasketBuilder.aBasket;
import static org.ericminio.kata.potter.data.Books.volume1;
import static org.ericminio.kata.potter.data.Books.volume2;
import static org.ericminio.kata.potter.data.Books.volume3;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.ericminio.kata.potter.Basket;
import org.ericminio.kata.potter.Book;
import org.ericminio.kata.potter.discounts.DiscountForThree;
import org.junit.Before;
import org.junit.Test;

public class DiscountForThreeTest {

	private DiscountForThree discount;
	
	@Before
	public void setUp() throws Exception {
		discount = new DiscountForThree();
	}
	
	@Test
	public void discountDoesNotApplyOnABasketWithLessThanThreeBooks() {
		assertFalse(discount.hasEnoughDifferentBooks(aBasket().with(volume1()).build())); 
		assertFalse(discount.hasEnoughDifferentBooks(aBasket().with(volume1()).and(volume2()).build()));
		assertTrue(discount.hasEnoughDifferentBooks(aBasket().with(volume1()).and(volume2()).and(volume3()).build()));
	}
	
	@Test
	public void discountOnlyApplyWithThreeDifferentBooks() {
		assertFalse(discount.hasEnoughDifferentBooks(aBasket().with(3, volume1()).build()));
	}
	
	@Test
	public void canSelectInABasketWithThreeDifferentTitles() {
		Basket basket = aBasket().with(volume1()).and(volume2()).and(volume3()).build();
		List<Book> selection = discount.selectBooks(basket);
		assertTrue(selection.contains(volume1()));
		assertTrue(selection.contains(volume2()));
		assertTrue(selection.contains(volume3()));
		assertThat(selection.size(), is(3));
	}
	


}
