package test;

import static org.junit.Assert.*;

import omenCards.Bite;
import omenCards.Book;
import omenCards.CrystalBall;
import omenCards.Dog;
import omenCards.Girl;
import omenCards.HolySymbol;
import omenCards.Madman;
import omenCards.Mask;
import omenCards.Medallion;
import omenCards.OmenCard;
import omenCards.Ring;
import omenCards.Skull;
import omenCards.Spear;
import omenCards.SpiritBoard;

import org.junit.Test;

public class TestOmenCard {

	private OmenCard card;

	@Test
	public void CrystalBallOmenInit() {
		card = new CrystalBall("Crystal Ball",
				"Hazy images appear in the glass.");
		assertEquals("Crystal Ball", card.getName());
		assertEquals("Hazy images appear in the glass.", card.getQuote());
	}

	@Test
	public void BookInit() {
		card = new Book("Book",
				"A diary or lab notes? Ancient script or modern ravings?");
		assertEquals("Book", card.getName());
		assertEquals("A diary or lab notes? Ancient script or modern ravings?",
				card.getQuote());
	}

	@Test
	public void RingInit() {
		card = new Ring("Ring",
				"A battered ring with an incomprehensible inscription.");
		assertEquals("Ring", card.getName());
		assertEquals("A battered ring with an incomprehensible inscription.",
				card.getQuote());

	}

	@Test
	public void MadmanInit() {
		card = new Madman("Madman", "COMPANION A raving, frothing madman");
		assertEquals("Madman", card.getName());
		assertEquals("COMPANION A raving, frothing madman", card.getQuote());
	}

	@Test
	public void SpearInit() {
		card = new Spear("Spear", "A weapon pulsing with power.");
		assertEquals("Spear", card.getName());
		assertEquals("A weapon pulsing with power.", card.getQuote());
	}

	@Test
	public void SpiritBoardInit() {
		card = new SpiritBoard("Spirit Board",
				"A board with letters and numbers to call the dead");
		assertEquals("Spirit Board", card.getName());
		assertEquals("A board with letters and numbers to call the dead",
				card.getQuote());
	}

	@Test
	public void MaskInit() {
		card = new Mask("Mask", "A somber mask to hide your intentions.");
		assertEquals("Mask", card.getName());
		assertEquals("A somber mask to hide your intentions.", card.getQuote());
	}

	@Test
	public void MedallionInit() {
		card = new Medallion("Medallion",
				"A medallion inscribed with a pentagram.");
		assertEquals("Medallion", card.getName());
		assertEquals("A medallion inscribed with a pentagram.", card.getQuote());
	}

	@Test
	public void GirlInit() {
		card = new Girl("Girl", "COMPANION A girl.Trapped.Alone.You free her!");
		assertEquals("Girl", card.getName());
		assertEquals("COMPANION A girl.Trapped.Alone.You free her!",
				card.getQuote());
	}

	@Test
	public void BiteInit() {
		card = new Bite("Bite",
				"A growl, the scent of death.Pain.Darkness.Gone.");
		assertEquals("Bite", card.getName());
		assertEquals("A growl, the scent of death.Pain.Darkness.Gone.",
				card.getQuote());
	}

	@Test
	public void SkullInit() {
		card = new Skull("Skull", "A skull, cracked and missing teeth.");
		assertEquals("Skull", card.getName());
		assertEquals("A skull, cracked and missing teeth.", card.getQuote());
	}

	@Test
	public void HolySymbolInit() {
		card = new HolySymbol("Holy Symbol",
				"A symbol of calm in an unsettling world.");
		assertEquals("Holy Symbol", card.getName());
		assertEquals("A symbol of calm in an unsettling world.",
				card.getQuote());
	}

	@Test
	public void DogInit() {
		card = new Dog("Dog",
				"COMPANION This mangy dog seems friendly. At least you hope it is.");
		assertEquals("Dog", card.getName());
		assertEquals(
				"COMPANION This mangy dog seems friendly. At least you hope it is.",
				card.getQuote());

	}
}
