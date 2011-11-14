package org.ericminio.kata.potter;

import java.util.List;

public interface Discount extends Pricer {
	
	public boolean hasEnoughDifferentBooks(Basket basket);

	public List<Book> selectBooks(Basket basket);

}
