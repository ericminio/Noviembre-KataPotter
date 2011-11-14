package org.ericminio.kata.potter.discounts;

import static org.ericminio.kata.potter.builders.BasketBuilder.aBasket;
import static org.ericminio.kata.potter.data.Books.volume1;
import static org.ericminio.kata.potter.data.Books.volume2;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.ericminio.kata.potter.Basket;
import org.ericminio.kata.potter.Book;
import org.ericminio.kata.potter.discounts.DiscountForTwo;
import org.junit.Before;
import org.junit.Test;

public class DiscountForTwoTest {

	private DiscountForTwo discount;
	
	@Before
	public void setUp() throws Exception {
		discount = new DiscountForTwo();
	}
	
	@Test
	public void discountDoesNotApplyOnABasketWithOnlyOneBook() {
		assertFalse(discount.hasEnoughDifferentBooks(aBasket().with(volume1()).build())); 
	}
	
	@Test
	public void discountAppliesOnABasketWithTwoBooks() {
		assertTrue(discount.hasEnoughDifferentBooks(aBasket().with(volume1()).and(volume2()).build())); 
	}
	
	@Test
	public void discountDoesNotApplyOnABasketWithTwoTimesTheSameBook() {
		assertFalse(discount.hasEnoughDifferentBooks(aBasket().with(2, volume1()).build()));
	}
	
	@Test
	public void canSelectInABasketWithTwoDifferentTitles() {
		Basket basket = aBasket().with(volume1()).and(volume2()).build();
		List<Book> selection = discount.selectBooks(basket);
		assertTrue(selection.contains(volume1()));
		assertTrue(selection.contains(volume2()));
		assertThat(selection.size(), is(2));
	}
	
	@Test
	public void canSelectInABasketWithDuplications() {
		Basket basket = aBasket().with(2, volume1()).and(volume2()).build();
		List<Book> selection = discount.selectBooks(basket);
		assertTrue(selection.contains(volume1()));
		assertTrue(selection.contains(volume2()));
		assertThat(selection.size(), is(2));
	}
	
}
