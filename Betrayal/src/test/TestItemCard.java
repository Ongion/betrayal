package test;

import static org.junit.Assert.*;
import itemCards.AngelFeather;
import itemCards.ItemCard;

import org.junit.Test;

public class TestItemCard {
	private ItemCard card;

	@Test
	public void TestAngelFeatherInit() {
		card = new AngelFeather("Angel Feather", "A perfect feather fluttering in your hand.");
		assertEquals("Angel Feather", card.getName());
		assertEquals("A perfect feather fluttering in your hand.", card.getDescription());
	}

}
