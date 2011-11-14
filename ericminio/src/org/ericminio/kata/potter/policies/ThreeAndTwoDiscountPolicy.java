package org.ericminio.kata.potter.policies;

import org.ericminio.kata.potter.Basket;
import org.ericminio.kata.potter.DiscountPolicy;
import org.ericminio.kata.potter.discounts.DiscountForThree;
import org.ericminio.kata.potter.discounts.DiscountForTwo;

public class ThreeAndTwoDiscountPolicy extends DiscountPolicy {

	public Double priceOf(Basket basket) {
		Double price = 0.0;
		price += applyDiscountWhileThereAreEnoughBooks(new DiscountForThree(), basket);
		price += applyDiscountWhileThereAreEnoughBooks(new DiscountForTwo(), basket);
		price += applyFullPriceForRemainingBooks(basket);
		return price;
	}

}
