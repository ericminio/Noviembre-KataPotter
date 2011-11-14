package org.ericminio.kata.potter;

import org.ericminio.kata.potter.builders.BasketBuilder;


public class PriceFixture {

	public static Double priceOf(BasketBuilder basketBuilder) {
		return new Library().priceOf(basketBuilder.build());
	}
}
