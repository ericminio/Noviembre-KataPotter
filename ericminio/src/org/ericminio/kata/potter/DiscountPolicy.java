package org.ericminio.kata.potter;

import java.util.List;

import org.ericminio.kata.potter.discounts.NoDiscount;

public abstract class DiscountPolicy implements Pricer {

	public DiscountPolicy() {
		super();
	}

	protected Double applyFullPriceForRemainingBooks(Basket basket) {
		return new NoDiscount().priceOf(basket);
	}

	protected Double applyDiscountWhileThereAreEnoughBooks(Discount discount, Basket basket) {
		Double price = 0.0;
		while (discount.hasEnoughDifferentBooks(basket)) {
			price += discount.priceOf(basket);
			List<Book> selection = discount.selectBooks(basket);
			basket.remove(selection);
		}
		return price;
	}

}