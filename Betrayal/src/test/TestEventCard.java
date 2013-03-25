package test;

import static org.junit.Assert.*;

import itemCards.ItemCard;

import java.util.ArrayList;
import java.util.Locale;

import omenCards.OmenCard;

import org.junit.Before;
import org.junit.Test;

import rooms.Room;
import Game.Game;
import Game.Player;

import eventCards.AngryBeing;
import eventCards.CreepyCrawlies;
import eventCards.EventCard;
import eventCards.Funeral;
import eventCards.NightView;
import eventCards.Rotten;

public class TestEventCard {

	private EventCard card;
	private characters.Character character = new characters.Character(0,new Locale("en"));
	private String rottenDes = "The smell in this room, it's horrible. Smells like death, like blood. A slaughterhouse smell.";
	private String angryBeingDes = "It emerges from the slime on the wall next to you.";
	private String creepyCrawliesDes = "A thousand bugs spill out on your skin, under your clothes, and in your hair.";
	private String nightViewDes = "You see a vision of a ghostly couple walking the grounds, silently strolling in their wedding best";
	private String funeralDes ="You see an open coffin. You're inside it.";
	private ArrayList<Room> rooms = new ArrayList<Room>();
	private ArrayList<EventCard> events = new ArrayList<EventCard>();
	private ArrayList<ItemCard> items = new ArrayList<ItemCard>();
	private ArrayList<OmenCard> omens = new ArrayList<OmenCard>();
	private ArrayList<Player> players = new ArrayList<Player>();
	private Game game;
	
	@Before
	public void setUp(){
		game = new Game(null, rooms, events, omens, items, players);
	}
	
	@Test
	public void testRottenInit(){
		card = new Rotten("Rotten", rottenDes, character, game);
		assertEquals("Rotten", card.getName());
		assertEquals(rottenDes, card.getDescription());
	}
	
	@Test
	public void testRottenHappen5OrGreater(){
		card = new Rotten("Rotten", rottenDes, character, game);
		// Test to be removed
		assertEquals(character, card.getCharacter());
		card.happen(5);
		assertEquals(7, card.getCharacter().getCurrentSanity());
		card.happen(6);	
		assertEquals(7, card.getCharacter().getCurrentSanity());
	}
	
	@Test
	public void testRottenHappen2To4(){
		card = new Rotten("Rotten", rottenDes, character, game);
		
		card.happen(4);
		assertEquals(2, card.getCharacter().getCurrentMight());
		card.happen(2);
		assertEquals(1, card.getCharacter().getCurrentMight());
		card.happen(5);
		card.happen(3);
		assertEquals(1, card.getCharacter().getCurrentMight());
	}
	
	@Test 
	public void testRottenHappen1(){
		card = new Rotten("Rotten", rottenDes, character, game);
		
		card.happen(1);
		assertEquals(2, card.getCharacter().getCurrentMight());
		assertEquals(3, card.getCharacter().getCurrentSpeed());
	}
	
	@Test
	public void testRottenHappen0(){
		card = new Rotten("Rotten", rottenDes, character, game);
		
		card.happen(0);
		assertEquals(3, card.getCharacter().getCurrentKnowledge());
		assertEquals(3, card.getCharacter().getCurrentSpeed());
		assertEquals(2, card.getCharacter().getCurrentMight());
		assertEquals(5, card.getCharacter().getCurrentSanity());
	}
	
	@Test
	public void testAngryBeingInit(){
		card = new AngryBeing("Angry Being", angryBeingDes, character, game);
		assertEquals("Angry Being", card.getName());
		assertEquals(angryBeingDes, card.getDescription());
	}
	
	@Test
	public void testAngryBeingHappen5OrGreater(){
		card = new AngryBeing("Angry Being", angryBeingDes, character, game);
		// Test to be removed
		assertEquals(character, card.getCharacter());
		card.happen(5);
		assertEquals(4, card.getCharacter().getCurrentSpeed());
		card.happen(6);	
		assertEquals(5, card.getCharacter().getCurrentSpeed());
	}
	
	@Test
	public void testAngryBeingHappen2To4(){
		card = new AngryBeing("Angry Being", angryBeingDes, character, game);
		
		card.happen(4);
		assertEquals(3, card.getCharacter().getCurrentKnowledge());
		card.happen(2);
		assertEquals(3, card.getCharacter().getCurrentKnowledge());
		card.happen(3);
		assertEquals(1, card.getCharacter().getCurrentKnowledge());
	}
	
	@Test 
	public void testAngryBeingHappen1Or0(){
		card = new AngryBeing("Angry Being", angryBeingDes, character, game);
		
		card.happen(1);
		assertEquals(3, card.getCharacter().getCurrentKnowledge());
		assertEquals(2, card.getCharacter().getCurrentMight());
		card.happen(0);
		assertEquals(3, card.getCharacter().getCurrentKnowledge());
		assertEquals(1, card.getCharacter().getCurrentMight());
	}

	public void testCreepyCrawliesInit(){
		card = new CreepyCrawlies("Creepy Crawlies", creepyCrawliesDes, character, game);
		assertEquals("Creepy Crawlies", card.getName());
		assertEquals(creepyCrawliesDes, card.getDescription());
	}
	
	@Test
	public void testCreepyCrawliesHappen5OrGreater(){
		card = new CreepyCrawlies("Creepy Crawlies", creepyCrawliesDes, character, game);
		// Test to be removed
		assertEquals(character, card.getCharacter());
		card.happen(5);
		assertEquals(7, card.getCharacter().getCurrentSanity());
		card.happen(6);	
		assertEquals(7, card.getCharacter().getCurrentSanity());
	}
	
	@Test
	public void testCreepyCrawlies1To4(){
		card = new CreepyCrawlies("Angry Being", angryBeingDes, character, game);
		
		card.happen(4);
		assertEquals(5, card.getCharacter().getCurrentSanity());
		card.happen(2);
		assertEquals(5, card.getCharacter().getCurrentSanity());
		card.happen(3);
		assertEquals(4, card.getCharacter().getCurrentSanity());
		card.happen(1);
		assertEquals(3, card.getCharacter().getCurrentSanity());
	}
	
	@Test 
	public void testCreepyCrawliesHappen0(){
		card = new CreepyCrawlies("Creepy Crawlies", creepyCrawliesDes, character, game);
		
		card.happen(0);
		assertEquals(5, card.getCharacter().getCurrentSanity());
	}

	public void testNightViewInit(){
		card = new NightView("Night View", nightViewDes, character, game);
		assertEquals("Night View", card.getName());
		assertEquals(nightViewDes, card.getDescription());
	}
	
	@Test
	public void testNightViewHappen5OrGreater(){
		card = new NightView("Night View", nightViewDes, character, game);
		
		// Test to be removed
		assertEquals(character, card.getCharacter());
		card.happen(5);
		assertEquals(5, card.getCharacter().getCurrentKnowledge());
		card.happen(6);	
		assertEquals(6, card.getCharacter().getCurrentKnowledge());
	}
	
	@Test
	public void testNightViewLessThan5(){
		card = new NightView("Night View", nightViewDes, character, game);
		
		
		card.happen(4);
		assertEquals(4, card.getCharacter().getCurrentKnowledge());
		card.happen(2);
		assertEquals(4, card.getCharacter().getCurrentKnowledge());
		card.happen(3);
		assertEquals(4, card.getCharacter().getCurrentKnowledge());
		card.happen(1);
		assertEquals(4, card.getCharacter().getCurrentKnowledge());
		card.happen(0);
		assertEquals(4, card.getCharacter().getCurrentKnowledge());
	}
	
	public void testFuneralInit(){
		card = new Funeral("Night View", funeralDes, character, game);
		assertEquals("Funeral", card.getName());
		assertEquals(funeralDes, card.getDescription());
	}
	
	@Test
	public void testFuneral4OrGreater(){
		card = new Funeral("Night View", funeralDes, character, game);
		
		// Test to be removed
		assertEquals(character, card.getCharacter());
		card.happen(4);
		assertEquals(7, card.getCharacter().getCurrentSanity());
		card.happen(5);	
		assertEquals(7, card.getCharacter().getCurrentSanity());
	}
	
	@Test
	public void testFuneral2Or3(){
		card = new Funeral("Night View", funeralDes, character, game);
		
		card.happen(3);
		assertEquals(5, card.getCharacter().getCurrentSanity());
		card.happen(2);
		assertEquals(5, card.getCharacter().getCurrentSanity());
	}

	@Test
	public void testFuneral0Or1(){
		card = new Funeral("Night View", funeralDes, character, game);
		
		card.happen(1);
		assertEquals(5, card.getCharacter().getCurrentSanity());
		assertEquals(2, card.getCharacter().getCurrentMight());
		card.happen(0);
		assertEquals(5, card.getCharacter().getCurrentSanity());
		assertEquals(1, card.getCharacter().getCurrentMight());
	}
}
