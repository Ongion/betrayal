package test;

import org.junit.Test;

import characters.FatherRhinehardt;
import eventCards.EventCard;
import eventCards.Rotten;

public class TestEventCard {

	private EventCard card;
	private characters.Character character = new FatherRhinehardt();
	
	@Test
	public void testRottenInit(){
		card = new Rotten("Rotten", "The smell in this room, it's horrible. Smells like death, like blood. A slaughterhouse smell.", character);
		
	}
}
