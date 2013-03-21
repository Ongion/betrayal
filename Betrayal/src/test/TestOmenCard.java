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
	}

}
