package org.ericminio.kata.potter.discounts;


import static org.ericminio.kata.potter.builders.BasketBuilder.aBasket;
import static org.ericminio.kata.potter.data.Books.volume1;
import static org.ericminio.kata.potter.data.Books.volume2;
import static org.ericminio.kata.potter.data.Books.volume3;
import static org.ericminio.kata.potter.data.Books.volume4;
import static org.ericminio.kata.potter.data.Books.volume5;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.ericminio.kata.potter.discounts.DiscountForFive;
import org.junit.Before;
import org.junit.Test;

public class DiscountForFiveTest {

	private DiscountForFive discount;
	
	@Before
	public void setUp() throws Exception {
		discount = new DiscountForFive();
	}

	@Test
	public void discountDoesNotApplyOnABasketWithLessThanFourDifferentBooks() {
		assertFalse(discount.hasEnoughDifferentBooks(aBasket().with(4, volume1()).build())); 
		assertTrue(discount.hasEnoughDifferentBooks(aBasket().with(volume1()).and(volume2()).and(volume3()).and(volume4()).and(volume5()).build()));
	}
	

}
