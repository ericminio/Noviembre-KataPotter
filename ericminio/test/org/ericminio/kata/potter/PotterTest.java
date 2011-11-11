package org.ericminio.kata.potter;

import static org.ericminio.kata.potter.Baskets.aBasketWithBook;
import static org.ericminio.kata.potter.Baskets.aBasketWithBooks;
import static org.ericminio.kata.potter.Baskets.anEmptyBasket;
import static org.ericminio.kata.potter.PriceFixture.priceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class PotterTest {

	@Test
	public void thePriceOfAnEmptyBasketIs0() {
		assertThat(priceOf(anEmptyBasket()), is(0));
	}
	
	@Test
	public void thePriceOfOneBookIs8() {
		assertThat(priceOf(aBasketWithBook("volume 1")), is(8));
	}
	
	@Test
	public void thePriceOfTwoSameBooksIs16() {
		assertThat(priceOf(aBasketWithBooks("v1", "v1")), is(16));
	}

}
