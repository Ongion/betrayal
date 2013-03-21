package test;

import static org.junit.Assert.*;
import itemCards.AdrenalineShot;
import itemCards.AngelFeather;
import itemCards.ItemCard;
import itemCards.Revolver;

import org.junit.Test;

public class TestItemCard {
	private ItemCard angelFeatherCard = new AngelFeather("Angel Feather",
			"A perfect feather fluttering in your hand.");
	private ItemCard adrenalineShotCard = new AdrenalineShot("Adrenaline Shot", "A syringe containing a strange fluorescent liquid.");
	private ItemCard revolverCard = new Revolver("Revolver","WEAPON An old, potent-looking weapon.");	
	private ItemCard puzzleBoxCard = new PuzzleBox("Puzzle Box", "There must be a way to open it.");
	
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
	
	@Test
	public void TestRevolverInit(){
		assertEquals("Revolver", revolverCard.getName());
		assertEquals("WEAPON An old, potent-looking weapon.", revolverCard.getDescription());
	}
	
	@Test
	public void TestPuzzleBoxInit(){
		assertEquals("Puzzle Box", puzzleBoxCard.getName());
		assertEquals("There must be a way to open it.", puzzleBoxCard.getDescription());
	}
}
