package test;

import static org.junit.Assert.*;

import org.junit.Test;

import characters.FatherRhinehardt;
import eventCards.AngryBeing;
import eventCards.EventCard;
import eventCards.Rotten;

public class TestEventCard {

	private EventCard card;
	private characters.Character character = new FatherRhinehardt();
	private String rottenDes = "The smell in this room, it's horrible. Smells like death, like blood. A slaughterhouse smell.";
	private String angryBeingDes = "It emerges from the slime on the wall next to you.";
	
	@Test
	public void testRottenInit(){
		card = new Rotten("Rotten", rottenDes, character);
		assertEquals("Rotten", card.getName());
		assertEquals(rottenDes, card.getDescription());
	}
	
	@Test
	public void testRottenHappen5OrGreater(){
		card = new Rotten("Rotten", rottenDes, character);
		// Test to be removed
		assertEquals(character, card.getCharacter());
		card.happen(5);
		assertEquals(5, card.getCharacter().getCurrentKnowledge());
		card.happen(6);	
		assertEquals(6, card.getCharacter().getCurrentKnowledge());
	}
	
	@Test
	public void testRottenHappen2To4(){
		card = new Rotten("Rotten", rottenDes, character);
		
		card.happen(4);
		assertEquals(3, card.getCharacter().getCurrentKnowledge());
		card.happen(2);
		assertEquals(3, card.getCharacter().getCurrentKnowledge());
		card.happen(3);
		assertEquals(1, card.getCharacter().getCurrentKnowledge());
	}
	
	@Test 
	public void testRottenHappen1(){
		card = new Rotten("Rotten", rottenDes, character);
		
		card.happen(1);
		assertEquals(3, card.getCharacter().getCurrentKnowledge());
	}
	
	@Test
	public void testRottenHappen0(){
		card = new Rotten("Rotten", rottenDes, character);
		
		card.happen(5);
		card.happen(0);
		assertEquals(1, card.getCharacter().getCurrentKnowledge());
	}
	
	@Test
	public void testAngryBeingInit(){
		card = new AngryBeing("Angry Being", angryBeingDes, character);
		assertEquals("Angry Being", card.getName());
		assertEquals(angryBeingDes, card.getDescription());
	}
	
	@Test
	public void testAngryBeingHappen5OrGreater(){
		card = new AngryBeing("Angry Being", angryBeingDes, character);
		// Test to be removed
		assertEquals(character, card.getCharacter());
		card.happen(5);
		assertEquals(5, card.getCharacter().getCurrentKnowledge());
		card.happen(6);	
		assertEquals(6, card.getCharacter().getCurrentKnowledge());
	}
	
	@Test
	public void testAngryBeingHappen2To4(){
		card = new AngryBeing("Angry Being", angryBeingDes, character);
		
		card.happen(4);
		assertEquals(3, card.getCharacter().getCurrentKnowledge());
		card.happen(2);
		assertEquals(3, card.getCharacter().getCurrentKnowledge());
		card.happen(3);
		assertEquals(1, card.getCharacter().getCurrentKnowledge());
	}
	
	@Test 
	public void testAngryBeingHappen1Or0(){
		card = new AngryBeing("Angry Being", angryBeingDes, character);
		
		card.happen(1);
		assertEquals(3, card.getCharacter().getCurrentKnowledge());
		card.happen(5);
		card.happen(0);
		assertEquals(1, card.getCharacter().getCurrentKnowledge());
	}

}
