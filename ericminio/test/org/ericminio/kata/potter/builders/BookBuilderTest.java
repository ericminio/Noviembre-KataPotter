package org.ericminio.kata.potter.builders;

import static org.ericminio.kata.potter.builders.BookBuilder.aBook;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class BookBuilderTest {

	@Test
	public void buildABookWithTheGivenName() {
		assertThat(aBook().withTitle("toto").build().title(), is("toto"));
	}
	
	@Test
	public void canBuildABookWithoutGivingATitle() {
		assertThat(aBook().build().title(), is(""));
	}

}
