package org.ericminio.kata.potter.policies;

import org.ericminio.kata.potter.Basket;
import org.ericminio.kata.potter.Discount;
import org.ericminio.kata.potter.DiscountPolicy;

public class SingleDiscountPolicy extends DiscountPolicy {

	protected Discount discount;
	
	public SingleDiscountPolicy(Discount discount) {
		this.discount = discount;
	}

	public Double priceOf(Basket basket) {
		Double price = 0.0;
		price += applyDiscountWhileThereAreEnoughBooks(discount, basket);
		price += applyFullPriceForRemainingBooks(basket);
		return price;
	}

}