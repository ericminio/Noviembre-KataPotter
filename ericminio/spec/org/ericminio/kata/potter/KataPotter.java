package org.ericminio.kata.potter;

import static org.ericminio.kata.potter.PriceFixture.priceOf;
import static org.ericminio.kata.potter.builders.BasketBuilder.aBasket;
import static org.ericminio.kata.potter.data.Baskets.anEmptyBasket;
import static org.ericminio.kata.potter.data.Books.volume1;
import static org.ericminio.kata.potter.data.Books.volume2;
import static org.ericminio.kata.potter.data.Books.volume3;
import static org.ericminio.kata.potter.data.Books.volume4;
import static org.ericminio.kata.potter.data.Books.volume5;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class KataPotter {

	@Test
	public void basicCases() {
		assertThat(priceOf(anEmptyBasket()), is(0.0));
		assertThat(priceOf(aBasket().with(volume1())), is(8.0));
		assertThat(priceOf(aBasket().with(volume2())), is(8.0));
		assertThat(priceOf(aBasket().with(volume3())), is(8.0));
		assertThat(priceOf(aBasket().with(volume4())), is(8.0));
		assertThat(priceOf(aBasket().with(volume5())), is(8.0));
		assertThat(priceOf(aBasket().with(2, volume1())), is(2*8.0));
		assertThat(priceOf(aBasket().with(3, volume2())), is(3*8.0));
	}
	
	@Test
	public void simpleDiscounts() {
		assertThat(priceOf(aBasket().with(volume1()).and(volume2())), is(2*8*0.95));
		assertThat(priceOf(aBasket().with(volume1()).and(volume2()).and(volume3())), is(3*8*0.9));
		assertThat(priceOf(aBasket().with(volume1()).and(volume2()).and(volume3()).and(volume4())), is(4*8*0.8));
		assertThat(priceOf(aBasket().with(volume1()).and(volume2()).and(volume3()).and(volume4()).and(volume5())), is(5*8*0.75));
	}
	
	@Test
	public void kataPotter() {
		assertThat(priceOf(aBasket().with(2, volume1()).and(2, volume2()).and(2, volume3()).and(volume4()).and(volume5())), is(51.2));
	}
}
