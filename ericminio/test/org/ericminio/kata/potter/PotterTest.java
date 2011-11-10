package org.ericminio.kata.potter;


import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class PotterTest {

	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void priceOfEmptyBasketIs0() {
		assertThat(priceOf(emptyBasket()), is(0));
	}

	private Integer priceOf(List<Book> basket) {
		return new Library().priceOf(basket);
	}

	private List<Book> emptyBasket() {
		return new ArrayList<Book>();
	}

}
