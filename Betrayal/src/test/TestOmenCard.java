package test;

import static org.junit.Assert.*;

import omenCards.CrystalBall;
import omenCards.OmenCard;

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
	}
}
