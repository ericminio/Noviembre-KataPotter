package org.ericminio.kata.potter.policies;

import static org.ericminio.kata.potter.builders.BasketBuilder.aBasket;
import static org.ericminio.kata.potter.data.Books.volume1;
import static org.ericminio.kata.potter.data.Books.volume2;
import static org.ericminio.kata.potter.data.Books.volume3;
import static org.ericminio.kata.potter.data.Books.volume4;
import static org.ericminio.kata.potter.data.Books.volume5;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class ThreeAndTwoDiscountPolicyTest {

	private ThreeAndTwoDiscountPolicy discount;
	
	@Before
	public void setUp() throws Exception {
		discount = new ThreeAndTwoDiscountPolicy();
	}

	@Test
	public void chainThreeAndTwoDiscounts() {
		assertThat(discount.priceOf(aBasket().with(volume1()).and(volume2())
				.and(volume3()).and(volume4()).and(volume5()).build()), is(3*8*0.9 + 2*8*0.95));
	}
	

}
