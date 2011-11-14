package org.ericminio.kata.potter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.ericminio.kata.potter.discounts.DiscountForFive;
import org.ericminio.kata.potter.discounts.DiscountForFour;
import org.ericminio.kata.potter.discounts.DiscountForThree;
import org.ericminio.kata.potter.discounts.DiscountForTwo;
import org.ericminio.kata.potter.discounts.NoDiscount;
import org.ericminio.kata.potter.policies.SingleDiscountPolicy;
import org.ericminio.kata.potter.policies.ThreeAndTwoDiscountPolicy;

public class Library {

	private List<Pricer> pricers;
	
	public Library() {
		pricers = new ArrayList<Pricer>();
		pricers.add(new NoDiscount());
		pricers.add(new SingleDiscountPolicy(new DiscountForTwo()));
		pricers.add(new SingleDiscountPolicy(new DiscountForThree()));
		pricers.add(new SingleDiscountPolicy(new DiscountForFour()));
		pricers.add(new SingleDiscountPolicy(new DiscountForFive()));
		pricers.add(new ThreeAndTwoDiscountPolicy());
	}

	public Double priceOf(Basket basket) {
		List<Double> prices = tryAllDiscountPolicies(basket);
		return Collections.min(prices);
	}

	protected List<Double> tryAllDiscountPolicies(Basket basket) {
		List<Double> prices = new ArrayList<Double>();
		for (Pricer pricer : pricers) {
			prices.add(pricer.priceOf(copy(basket)));
		}
		return prices;
	}

	protected Basket copy(Basket basket) {
		return (Basket) basket.clone();
	}
	
}
