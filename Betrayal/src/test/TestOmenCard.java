package test;

import static org.junit.Assert.*;

import omenCards.Book;
import omenCards.CrystalBall;
import omenCards.Madman;
import omenCards.OmenCard;
import omenCards.Ring;

import org.junit.Test;

public class TestOmenCard {
	
	private OmenCard card;

	@Test
	public void CrystalBallOmenInit() {
		card = new CrystalBall("Crystal Ball", "Hazy images appear in the glass.");
		assertEquals("Crystal Ball", card.getName());
		assertEquals("Hazy images appear in the glass.", card.getQuote());
	}

	@Test
	public void BookInit(){
		card = new Book("Book", "A diary or lab notes? Ancient script or modern ravings?");
		assertEquals("Book", card.getName());
		assertEquals("A diary or lab notes? Ancient script or modern ravings?", card.getQuote());
	}
	
	@Test 
	public void RingInit(){
		card = new Ring("Ring","A battered ring with an incomprehensible inscription.");
		assertEquals("Ring", card.getName());
		assertEquals("A battered ring with an incomprehensible inscription.", card.getQuote());
		
	}
	
	@Test
	public void MadmanInit(){
		card = new Madman("Madman", "COMPANION A raving, frothing madman");
		assertEquals("Madman", card.getName());
		assertEquals("COMPANION A raving, frothing madman", card.getQuote());
	}
}
