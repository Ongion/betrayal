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

	private OmenCard crystalBallCard = new CrystalBall("Crystal Ball",
			"Hazy images appear in the glass.");
	private OmenCard bookCard = new Book("Book",
			"A diary or lab notes? Ancient script or modern ravings?");
	private OmenCard ringCard = new Ring("Ring",
			"A battered ring with an incomprehensible inscription.");
	private OmenCard madmanCard = new Ring("Madman",
			"COMPANION A raving, frothing madman");
	private OmenCard spearCard = new Spear("Spear",
			"A weapon pulsing with power.");
	private OmenCard spiritBoardCard = new SpiritBoard("Spirit Board",
			"A board with letters and numbers to call the dead");
	private OmenCard maskCard = new Mask("Mask",
			"A somber mask to hide your intentions.");
	private OmenCard medallionCard = new Medallion("Medallion",
			"A medallion inscribed with a pentagram.");
	private OmenCard girlCard = new Girl("Girl",
			"COMPANION A girl.Trapped.Alone.You free her!");
	private OmenCard biteCard = new Bite("Bite",
			"A growl, the scent of death.Pain.Darkness.Gone.");
	private OmenCard skullCard = new Skull("Skull",
			"A skull, cracked and missing teeth.");
	private OmenCard holySymbolCard = new HolySymbol("Holy Symbol",
			"A symbol of calm in an unsettling world.");
	private OmenCard dogCard = new Dog("Dog",
			"COMPANION This mangy dog seems friendly. At least you hope it is.");

	@Test
	public void CrystalBallOmenInit() {
		assertEquals("Crystal Ball", crystalBallCard.getName());
		assertEquals("Hazy images appear in the glass.",
				crystalBallCard.getQuote());
	}

	@Test
	public void IsHauntRollWithCrystalBall() {
		assertTrue(crystalBallCard.isHauntRoll());
	}

	@Test
	public void MakeAHauntRollWithCrystalBall() {
		assertTrue(crystalBallCard.makeHauntRoll());
	}

	@Test
	public void BookInit() {
		assertEquals("Book", bookCard.getName());
		assertEquals("A diary or lab notes? Ancient script or modern ravings?",
				bookCard.getQuote());
	}

	@Test
	public void RingInit() {
		assertEquals("Ring", ringCard.getName());
		assertEquals("A battered ring with an incomprehensible inscription.",
				ringCard.getQuote());
	}

	@Test
	public void MadmanInit() {
		assertEquals("Madman", madmanCard.getName());
		assertEquals("COMPANION A raving, frothing madman",
				madmanCard.getQuote());
	}

	@Test
	public void SpearInit() {
		assertEquals("Spear", spearCard.getName());
		assertEquals("A weapon pulsing with power.", spearCard.getQuote());
	}

	@Test
	public void SpiritBoardInit() {
		assertEquals("Spirit Board", spiritBoardCard.getName());
		assertEquals("A board with letters and numbers to call the dead",
				spiritBoardCard.getQuote());
	}

	@Test
	public void MaskInit() {
		assertEquals("Mask", maskCard.getName());
		assertEquals("A somber mask to hide your intentions.",
				maskCard.getQuote());
	}

	@Test
	public void MedallionInit() {
		assertEquals("Medallion", medallionCard.getName());
		assertEquals("A medallion inscribed with a pentagram.",
				medallionCard.getQuote());
	}

	@Test
	public void GirlInit() {
		assertEquals("Girl", girlCard.getName());
		assertEquals("COMPANION A girl.Trapped.Alone.You free her!",
				girlCard.getQuote());
	}

	@Test
	public void BiteInit() {
		assertEquals("Bite", biteCard.getName());
		assertEquals("A growl, the scent of death.Pain.Darkness.Gone.",
				biteCard.getQuote());
	}

	@Test
	public void SkullInit() {
		assertEquals("Skull", skullCard.getName());
		assertEquals("A skull, cracked and missing teeth.",
				skullCard.getQuote());
	}

	@Test
	public void HolySymbolInit() {
		assertEquals("Holy Symbol", holySymbolCard.getName());
		assertEquals("A symbol of calm in an unsettling world.",
				holySymbolCard.getQuote());
	}

	@Test
	public void DogInit() {
		assertEquals("Dog", dogCard.getName());
		assertEquals(
				"COMPANION This mangy dog seems friendly. At least you hope it is.",
				dogCard.getQuote());

	}
}
