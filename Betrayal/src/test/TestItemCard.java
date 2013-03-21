package test;

import static org.junit.Assert.*;
import itemCards.AdrenalineShot;
import itemCards.AngelFeather;
import itemCards.ItemCard;

import org.junit.Test;

public class TestItemCard {
	private ItemCard angelFeatherCard = new AngelFeather("Angel Feather",
			"A perfect feather fluttering in your hand.");
	private ItemCard adrenalineShotCard = new AdrenalineShot("Adrenaline Shot", "A syringe containing a strange fluorescent liquid.");
	
	@Test
	public void TestAngelFeatherInit() {
		assertEquals("Angel Feather", angelFeatherCard.getName());
		assertEquals("A perfect feather fluttering in your hand.",
				angelFeatherCard.getDescription());
	}

	@Test
	public void TestAdrenalineShotInit(){
		assertEquals("Adrenaline Shot", adrenalineShotCard.getName());
		assertEquals("A syringe containing a strange fluorescent liquid.", adrenalineShotCard.getDescription());
	}
}
