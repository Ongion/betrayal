package test;

import static org.junit.Assert.*;

import itemCards.AdrenalineShot;
import itemCards.AngelFeather;
import itemCards.ItemCard;
import itemCards.PuzzleBox;
import itemCards.Revolver;

import java.util.ArrayList;
import java.util.Locale;

import omenCards.Book;
import omenCards.CrystalBall;
import omenCards.OmenCard;
import omenCards.Ring;

import org.junit.Before;
import org.junit.Test;

import rooms.FoyerRoom;
import rooms.OrganRoomRoom;
import rooms.Room;
import Game.Game;
import Game.Player;

import eventCards.AngryBeing;
import eventCards.CreepyCrawlies;
import eventCards.Debris;
import eventCards.EventCard;
import eventCards.Funeral;
import eventCards.HangedMen;
import eventCards.Mirror2;
import eventCards.NightView;
import eventCards.Rotten;
import eventCards.Skeletons;
import eventCards.SomethingHidden;
import eventCards.SomethingSlimy;
import eventCards.TheVoice;

public class TestEventCard {

	private EventCard card;
	private Game game;
	private characters.Character character = new characters.Character(0,new Locale("en"));
	private String rottenDes = "The smell in this room, it's horrible. Smells like death, like blood. A slaughterhouse smell.";
	private String angryBeingDes = "It emerges from the slime on the wall next to you.";
	private String creepyCrawliesDes = "A thousand bugs spill out on your skin, under your clothes, and in your hair.";
	private String nightViewDes = "You see a vision of a ghostly couple walking the grounds, silently strolling in their wedding best";
	private String funeralDes ="You see an open coffin. You're inside it.";
	private String somethingSlimyDes = "What's around your ankle? A bug? A tentacle? A dead hand clawing?";
	private String mirror2Des = "There is an old mirror in this room. Your frightened reflection " +
			"moves on its own. You realize it is you from another time. Your reflection writes on the mirror: \n" +
			"pleh lliw siht \n Then it hands you an item through the mirror. Draw an item card.";
	private String skeletonsDes = "Mother and child, still embracing";
	private String theVoiceDes = "\"I'm under the floor, buried under the floor...\" \n The" +
			"voice whispers once, then is gone.";
	private String somethingHiddenDes = "There's someting odd about this room, but what? It's " +
			"tickling the back of your mind";
	private String hangedMenDes = "A breeze chills the room. Before you, three men hang from frayed ropes. They stare at you with " +
			"cold, dead eyes. The trio swing silently, then fade into dust that falls to the ground. You start to choke.";
	private String debrisDes = "Plaster falls from the walls and ceiling.";
	
	private EventCard angryBeing = new AngryBeing("Angry Being", angryBeingDes, game);
	private EventCard creepyCrawlies = new CreepyCrawlies("Creepy Crawlies", creepyCrawliesDes, game);
	private EventCard nightView = new NightView("Night View", nightViewDes, game);
	private EventCard rotten = new Rotten("Rotten", rottenDes, game);
	private ItemCard angelFeather = new AngelFeather("Angel Feather", "A perfect feather fluttering in your hand.");
	private ItemCard adrenalineShotCard = new AdrenalineShot("Adrenaline Shot", "A syringe containing a strange fluorescent liquid.");
	private ItemCard revolverCard = new Revolver("Revolver","WEAPON An old, potent-looking weapon.");	
	private ItemCard puzzleBoxCard = new PuzzleBox("Puzzle Box", "There must be a way to open it.");
	private OmenCard crystalBall = new CrystalBall("Crystal Ball", "Hazy images appear in the glass.",game);
	private OmenCard book = new Book("Book", "A diary or lab notes? Ancient script or modern ravings?",game);
	private OmenCard ring = new Ring("Ring","A battered ring with an incomprehensible inscription.",game);
	private Room foyer = new FoyerRoom();
	private Room organRoom = new OrganRoomRoom();
	private Player player = new Player(character);
	private ArrayList<Room> rooms = new ArrayList<Room>();
	private ArrayList<EventCard> events = new ArrayList<EventCard>();
	private ArrayList<ItemCard> items = new ArrayList<ItemCard>();
	private ArrayList<OmenCard> omens = new ArrayList<OmenCard>();
	private ArrayList<Player> players = new ArrayList<Player>();
	
	@Before
	public void setUp(){
		rooms.add(foyer);
		rooms.add(organRoom);
		events.add(angryBeing);
		events.add(creepyCrawlies);
		events.add(nightView);
		events.add(rotten);
		items.add(angelFeather);
		items.add(adrenalineShotCard);
		items.add(revolverCard);
		items.add(puzzleBoxCard);
		omens.add(crystalBall);
		omens.add(book);
		omens.add(ring);
		players.add(player);
		players.add(player);
		
		game = new Game(null, rooms, events, omens, items, players);
	}
	
	@Test
	public void testRottenInit(){
		card = new Rotten("Rotten", rottenDes, game);
		assertEquals("Rotten", card.getName());
		assertEquals(rottenDes, card.getDescription());
	}
	
	@Test
	public void testEventCardSets(){
		card = new Rotten("Rotten", rottenDes, game);
		assertEquals("Rotten", card.getName());
		assertEquals(rottenDes, card.getDescription());
		
		card.setName("Hello");
		card.setDescription("This is a fake description for testing");
		
		assertEquals("Hello", card.getName());
		assertEquals("This is a fake description for testing", card.getDescription());
	}
	
	@Test
	public void testRottenHappen5OrGreater(){
		card = new Rotten("Rotten", rottenDes, game);
		// Test to be removed
		assertEquals(character, game.getCurrentPlayer().getCharacter());
		card.happen(5);
		assertEquals(7, game.getCurrentPlayer().getCharacter().getCurrentSanity());
		card.happen(6);	
		assertEquals(7, game.getCurrentPlayer().getCharacter().getCurrentSanity());
	}
	
	@Test
	public void testRottenHappen2To4(){
		card = new Rotten("Rotten", rottenDes, game);
		
		card.happen(4);
		assertEquals(2, game.getCurrentPlayer().getCharacter().getCurrentMight());
		card.happen(2);
		assertEquals(1, game.getCurrentPlayer().getCharacter().getCurrentMight());
		card.happen(5);
		card.happen(3);
		assertEquals(1, game.getCurrentPlayer().getCharacter().getCurrentMight());
	}
	
	@Test 
	public void testRottenHappen1(){
		card = new Rotten("Rotten", rottenDes, game);
		
		card.happen(1);
		assertEquals(2, game.getCurrentPlayer().getCharacter().getCurrentMight());
		assertEquals(3, game.getCurrentPlayer().getCharacter().getCurrentSpeed());
	}
	
	@Test
	public void testRottenHappen0(){
		card = new Rotten("Rotten", rottenDes, game);
		
		card.happen(0);
		assertEquals(3, game.getCurrentPlayer().getCharacter().getCurrentKnowledge());
		assertEquals(3, game.getCurrentPlayer().getCharacter().getCurrentSpeed());
		assertEquals(2, game.getCurrentPlayer().getCharacter().getCurrentMight());
		assertEquals(5, game.getCurrentPlayer().getCharacter().getCurrentSanity());
	}
	
	@Test
	public void testAngryBeingInit(){
		card = new AngryBeing("Angry Being", angryBeingDes, game);
		assertEquals("Angry Being", card.getName());
		assertEquals(angryBeingDes, card.getDescription());
	}
	
	@Test
	public void testAngryBeingHappen5OrGreater(){
		card = new AngryBeing("Angry Being", angryBeingDes, game);
		// Test to be removed
		assertEquals(character, game.getCurrentPlayer().getCharacter());
		card.happen(5);
		assertEquals(4, game.getCurrentPlayer().getCharacter().getCurrentSpeed());
		card.happen(6);	
		assertEquals(5, game.getCurrentPlayer().getCharacter().getCurrentSpeed());
	}
	
	@Test
	public void testAngryBeingHappen2To4(){
		card = new AngryBeing("Angry Being", angryBeingDes, game);
		
		card.happen(4);
		assertEquals(3, game.getCurrentPlayer().getCharacter().getCurrentKnowledge());
		card.happen(2);
		assertEquals(3, game.getCurrentPlayer().getCharacter().getCurrentKnowledge());
		card.happen(3);
		assertEquals(1, game.getCurrentPlayer().getCharacter().getCurrentKnowledge());
	}
	
	@Test 
	public void testAngryBeingHappen1Or0(){
		card = new AngryBeing("Angry Being", angryBeingDes, game);
		
		card.happen(1);
		assertEquals(3, game.getCurrentPlayer().getCharacter().getCurrentKnowledge());
		assertEquals(2, game.getCurrentPlayer().getCharacter().getCurrentMight());
		card.happen(0);
		assertEquals(3, game.getCurrentPlayer().getCharacter().getCurrentKnowledge());
		assertEquals(1, game.getCurrentPlayer().getCharacter().getCurrentMight());
	}

	@Test
	public void testCreepyCrawliesInit(){
		card = new CreepyCrawlies("Creepy Crawlies", creepyCrawliesDes, game);
		assertEquals("Creepy Crawlies", card.getName());
		assertEquals(creepyCrawliesDes, card.getDescription());
	}
	
	@Test
	public void testCreepyCrawliesHappen5OrGreater(){
		card = new CreepyCrawlies("Creepy Crawlies", creepyCrawliesDes, game);
		// Test to be removed
		assertEquals(character, game.getCurrentPlayer().getCharacter());
		card.happen(5);
		assertEquals(7, game.getCurrentPlayer().getCharacter().getCurrentSanity());
		card.happen(6);	
		assertEquals(7, game.getCurrentPlayer().getCharacter().getCurrentSanity());
	}
	
	@Test
	public void testCreepyCrawlies1To4(){
		card = new CreepyCrawlies("Angry Being", angryBeingDes, game);
		
		card.happen(4);
		assertEquals(5, game.getCurrentPlayer().getCharacter().getCurrentSanity());
		card.happen(2);
		assertEquals(5, game.getCurrentPlayer().getCharacter().getCurrentSanity());
		card.happen(3);
		assertEquals(4, game.getCurrentPlayer().getCharacter().getCurrentSanity());
		card.happen(1);
		assertEquals(3, game.getCurrentPlayer().getCharacter().getCurrentSanity());
	}
	
	@Test 
	public void testCreepyCrawliesHappen0(){
		card = new CreepyCrawlies("Creepy Crawlies", creepyCrawliesDes, game);
		
		card.happen(0);
		assertEquals(5, game.getCurrentPlayer().getCharacter().getCurrentSanity());
	}

	@Test
	public void testNightViewInit(){
		card = new NightView("Night View", nightViewDes, game);
		assertEquals("Night View", card.getName());
		assertEquals(nightViewDes, card.getDescription());
	}
	
	@Test
	public void testNightViewHappen5OrGreater(){
		card = new NightView("Night View", nightViewDes, game);
		
		// Test to be removed
		assertEquals(character, game.getCurrentPlayer().getCharacter());
		card.happen(5);
		assertEquals(5, game.getCurrentPlayer().getCharacter().getCurrentKnowledge());
		card.happen(6);	
		assertEquals(6, game.getCurrentPlayer().getCharacter().getCurrentKnowledge());
	}
	
	@Test
	public void testNightViewLessThan5(){
		card = new NightView("Night View", nightViewDes, game);
		
		
		card.happen(4);
		assertEquals(4, game.getCurrentPlayer().getCharacter().getCurrentKnowledge());
		card.happen(2);
		assertEquals(4, game.getCurrentPlayer().getCharacter().getCurrentKnowledge());
		card.happen(3);
		assertEquals(4, game.getCurrentPlayer().getCharacter().getCurrentKnowledge());
		card.happen(1);
		assertEquals(4, game.getCurrentPlayer().getCharacter().getCurrentKnowledge());
		card.happen(0);
		assertEquals(4, game.getCurrentPlayer().getCharacter().getCurrentKnowledge());
	}
	
	@Test
	public void testFuneralInit(){
		card = new Funeral("Funeral", funeralDes, game);
		assertEquals("Funeral", card.getName());
		assertEquals(funeralDes, card.getDescription());
	}
	
	@Test
	public void testFuneral4OrGreater(){
		card = new Funeral("Funeral", funeralDes, game);
		
		// Test to be removed
		assertEquals(character, game.getCurrentPlayer().getCharacter());
		card.happen(4);
		assertEquals(7, game.getCurrentPlayer().getCharacter().getCurrentSanity());
		card.happen(5);	
		assertEquals(7, game.getCurrentPlayer().getCharacter().getCurrentSanity());
	}
	
	@Test
	public void testFuneral2Or3(){
		card = new Funeral("Funeral", funeralDes, game);
		
		card.happen(3);
		assertEquals(5, game.getCurrentPlayer().getCharacter().getCurrentSanity());
		card.happen(2);
		assertEquals(5, game.getCurrentPlayer().getCharacter().getCurrentSanity());
	}

	@Test
	public void testFuneral0Or1(){
		card = new Funeral("Funeral", funeralDes, game);
		
		card.happen(1);
		assertEquals(5, game.getCurrentPlayer().getCharacter().getCurrentSanity());
		assertEquals(2, game.getCurrentPlayer().getCharacter().getCurrentMight());
		card.happen(0);
		assertEquals(5, game.getCurrentPlayer().getCharacter().getCurrentSanity());
		assertEquals(1, game.getCurrentPlayer().getCharacter().getCurrentMight());
	}
	
	@Test
	public void testSomethingSlimyInit(){
		card = new SomethingSlimy("Something Slimy", somethingSlimyDes, game);
		assertEquals("Something Slimy", card.getName());
		assertEquals(somethingSlimyDes, card.getDescription());
	}
	
	@Test
	public void testSomethingSlimy4OrGreater(){
		card = new SomethingSlimy("Something Slimy", somethingSlimyDes, game);
		
		// Test to be removed
		assertEquals(character, game.getCurrentPlayer().getCharacter());
		card.happen(4);
		assertEquals(4, game.getCurrentPlayer().getCharacter().getCurrentSpeed());
		card.happen(5);	
		assertEquals(5, game.getCurrentPlayer().getCharacter().getCurrentSpeed());
	}
	
	@Test
	public void testSomethingSlimy1Or3(){
		card = new SomethingSlimy("Something Slimy", somethingSlimyDes, game);
		
		card.happen(3);
		assertEquals(2, game.getCurrentPlayer().getCharacter().getCurrentMight());
		card.happen(2);
		assertEquals(1, game.getCurrentPlayer().getCharacter().getCurrentMight());
		card.happen(5);
		card.happen(1);
		assertEquals(1, game.getCurrentPlayer().getCharacter().getCurrentMight());
	}

	@Test
	public void testSomethingSlimy0(){
		card = new SomethingSlimy("Something Slimy", somethingSlimyDes, game);
		
		card.happen(0);
		assertEquals(3, game.getCurrentPlayer().getCharacter().getCurrentSpeed());
		assertEquals(2, game.getCurrentPlayer().getCharacter().getCurrentMight());
	}
	
	@Test
	public void testMirror2Init(){
		card = new Mirror2("rorriM ehT nI egamI", mirror2Des, game);
		assertEquals("rorriM ehT nI egamI", card.getName());
		assertEquals(mirror2Des, card.getDescription());
	}
	
	@Test
	public void testMirror2Happen(){
		card = new Mirror2("rorriM ehT nI egamI", mirror2Des, game);
		
		assertEquals(0, game.getCurrentPlayer().getItemHand().size());
		card.happens();
		assertEquals(1, game.getCurrentPlayer().getItemHand().size());
		assertEquals(angelFeather, game.getCurrentPlayer().getItemHand().get(0));
		card.happens();	
		assertEquals(2, game.getCurrentPlayer().getItemHand().size());
		assertEquals(adrenalineShotCard, game.getCurrentPlayer().getItemHand().get(1));
	}
	
	@Test
	public void testSkeletonsInit(){
		card = new Skeletons("Skeletons", skeletonsDes, game);
		assertEquals("Skeletons", card.getName());
		assertEquals(skeletonsDes, card.getDescription());
	}
	
	@Test
	public void testSkeletons5orGreater(){
		card = new Skeletons("Skeletons", skeletonsDes, game);
		
		assertEquals(0, game.getCurrentPlayer().getItemHand().size());
		card.happen(5);
		assertEquals(1, game.getCurrentPlayer().getItemHand().size());
		assertEquals(angelFeather, game.getCurrentPlayer().getItemHand().get(0));
		card.happen(6);	
		assertEquals(2, game.getCurrentPlayer().getItemHand().size());
		assertEquals(adrenalineShotCard, game.getCurrentPlayer().getItemHand().get(1));
	}
	
	@Test
	public void testSkeletonsLessThan5(){
		card = new Skeletons("Skeletons", skeletonsDes, game);
		
		assertEquals(0, game.getCurrentPlayer().getItemHand().size());
		card.happen(0);
		assertEquals(0, game.getCurrentPlayer().getItemHand().size());
		assertEquals(5, game.getCurrentPlayer().getCharacter().getCurrentSanity());
		card.happen(1);	
		assertEquals(0, game.getCurrentPlayer().getItemHand().size());
		assertEquals(5, game.getCurrentPlayer().getCharacter().getCurrentSanity());
		card.happen(2);
		assertEquals(0, game.getCurrentPlayer().getItemHand().size());
		assertEquals(4, game.getCurrentPlayer().getCharacter().getCurrentSanity());
		card.happen(3);
		assertEquals(0, game.getCurrentPlayer().getItemHand().size());
		assertEquals(3, game.getCurrentPlayer().getCharacter().getCurrentSanity());
		card.happen(5);
		card.happen(4);
		assertEquals(1, game.getCurrentPlayer().getItemHand().size());
		assertEquals(angelFeather, game.getCurrentPlayer().getItemHand().get(0));
		assertEquals(3, game.getCurrentPlayer().getCharacter().getCurrentSanity());
	}
	
	@Test
	public void testTheVoiceInit(){
		card = new TheVoice("The Voice", theVoiceDes, game);
		assertEquals("The Voice", card.getName());
		assertEquals(theVoiceDes, card.getDescription());
	}
	
	@Test
	public void testTheVoice4orGreater(){
		card = new TheVoice("The Voice", theVoiceDes, game);
		
		assertEquals(0, game.getCurrentPlayer().getItemHand().size());
		card.happen(4);
		assertEquals(1, game.getCurrentPlayer().getItemHand().size());
		assertEquals(angelFeather, game.getCurrentPlayer().getItemHand().get(0));
		card.happen(5);	
		assertEquals(2, game.getCurrentPlayer().getItemHand().size());
		assertEquals(adrenalineShotCard, game.getCurrentPlayer().getItemHand().get(1));
	}
	
	@Test
	public void testSomethingHiddenInit(){
		card = new SomethingHidden("Something Hidden", somethingHiddenDes, game);
		assertEquals("Something Hidden", card.getName());
		assertEquals(somethingHiddenDes, card.getDescription());
	}
	
	@Test
	public void testSomethingHidden4orGreater(){
		card = new SomethingHidden("Something Hidden", somethingHiddenDes, game);
		
		assertEquals(0, game.getCurrentPlayer().getItemHand().size());
		card.happen(4);
		assertEquals(1, game.getCurrentPlayer().getItemHand().size());
		assertEquals(angelFeather, game.getCurrentPlayer().getItemHand().get(0));
		card.happen(5);	
		assertEquals(2, game.getCurrentPlayer().getItemHand().size());
		assertEquals(adrenalineShotCard, game.getCurrentPlayer().getItemHand().get(1));
	}
	
	@Test
	public void testSomethingHiddenLessThan4(){
		card = new SomethingHidden("Something Hidden", somethingHiddenDes, game);
		
		assertEquals(0, game.getCurrentPlayer().getItemHand().size());
		card.happen(0);
		assertEquals(0, game.getCurrentPlayer().getItemHand().size());
		assertEquals(5, game.getCurrentPlayer().getCharacter().getCurrentSanity());
		card.happen(1);	
		assertEquals(0, game.getCurrentPlayer().getItemHand().size());
		assertEquals(5, game.getCurrentPlayer().getCharacter().getCurrentSanity());
		card.happen(2);
		assertEquals(0, game.getCurrentPlayer().getItemHand().size());
		assertEquals(4, game.getCurrentPlayer().getCharacter().getCurrentSanity());
		card.happen(3);
		assertEquals(0, game.getCurrentPlayer().getItemHand().size());
		assertEquals(3, game.getCurrentPlayer().getCharacter().getCurrentSanity());
		
	}
	
	@Test
	public void testHangedMenInit(){
		card = new HangedMen("Hanged Men", hangedMenDes, game);
		assertEquals("Hanged Men", card.getName());
		assertEquals(hangedMenDes, card.getDescription());
	}
	
	@Test
	public void testHangedMen2OrGreater(){
		card = new HangedMen("Hanged Men", hangedMenDes, game);
		
		assertEquals(4, game.getCurrentPlayer().getCharacter().getCurrentKnowledge());
		assertEquals(2, game.getCurrentPlayer().getCharacter().getCurrentMight());
		assertEquals(6, game.getCurrentPlayer().getCharacter().getCurrentSanity());
		assertEquals(3, game.getCurrentPlayer().getCharacter().getCurrentSpeed());
		
		card.happen(2);
		
		assertEquals(5, game.getCurrentPlayer().getCharacter().getCurrentKnowledge());
		assertEquals(2, game.getCurrentPlayer().getCharacter().getCurrentMight());
		assertEquals(6, game.getCurrentPlayer().getCharacter().getCurrentSanity());
		assertEquals(3, game.getCurrentPlayer().getCharacter().getCurrentSpeed());
		
		card.happen(3);
		
		assertEquals(6, game.getCurrentPlayer().getCharacter().getCurrentKnowledge());
		assertEquals(2, game.getCurrentPlayer().getCharacter().getCurrentMight());
		assertEquals(6, game.getCurrentPlayer().getCharacter().getCurrentSanity());
		assertEquals(3, game.getCurrentPlayer().getCharacter().getCurrentSpeed());
	}
	
	@Test
	public void testHangedMenLessThan2(){
		card = new HangedMen("Hanged Men", hangedMenDes, game);
		
		assertEquals(4, game.getCurrentPlayer().getCharacter().getCurrentKnowledge());
		assertEquals(2, game.getCurrentPlayer().getCharacter().getCurrentMight());
		assertEquals(6, game.getCurrentPlayer().getCharacter().getCurrentSanity());
		assertEquals(3, game.getCurrentPlayer().getCharacter().getCurrentSpeed());
		
		card.happen(1);
		
		assertEquals(3, game.getCurrentPlayer().getCharacter().getCurrentKnowledge());
		assertEquals(2, game.getCurrentPlayer().getCharacter().getCurrentMight());
		assertEquals(5, game.getCurrentPlayer().getCharacter().getCurrentSanity());
		assertEquals(3, game.getCurrentPlayer().getCharacter().getCurrentSpeed());
		
		card.happen(0);
		
		assertEquals(3, game.getCurrentPlayer().getCharacter().getCurrentKnowledge());
		assertEquals(1, game.getCurrentPlayer().getCharacter().getCurrentMight());
		assertEquals(5, game.getCurrentPlayer().getCharacter().getCurrentSanity());
		assertEquals(2, game.getCurrentPlayer().getCharacter().getCurrentSpeed());
	}
	
	@Test
	public void testDebrisInit(){
		card = new Debris("Debris", debrisDes, game);
		assertEquals("Debris", card.getName());
		assertEquals(debrisDes, card.getDescription());
	}
	
	@Test
	public void testDebris3OrGreater(){
		card = new Debris("Debris", debrisDes, game);
		
		assertEquals(0, game.getCurrentPlayer().getEventHand().size());
		assertEquals(3, game.getCurrentPlayer().getCharacter().getCurrentSpeed());		
		card.happen(3);
		
		assertEquals(4, game.getCurrentPlayer().getCharacter().getCurrentSpeed());
		assertEquals(0, game.getCurrentPlayer().getEventHand().size());
		
		card.happen(6);
		
		assertEquals(5, game.getCurrentPlayer().getCharacter().getCurrentSpeed());
		assertEquals(0, game.getCurrentPlayer().getEventHand().size());		
		
	}
	
	@Test
	public void testDebris1Or2(){
		card = new Debris("Debris", debrisDes, game);
		
		assertEquals(0, game.getCurrentPlayer().getEventHand().size());
		
		card.happen(2);
		
		assertEquals(2, game.getCurrentPlayer().getCharacter().getCurrentMight());
		assertEquals(0, game.getCurrentPlayer().getEventHand().size());
		
		card.happen(1);
		assertEquals(1, game.getCurrentPlayer().getCharacter().getCurrentMight());
		assertEquals(0, game.getCurrentPlayer().getEventHand().size());		
		
	}
	
	@Test
	public void testDebris0(){
		card = new Debris("Debris", debrisDes, game);
		
		assertEquals(0, game.getCurrentPlayer().getEventHand().size());
		
		card.happen(0);
		
		assertEquals(1, game.getCurrentPlayer().getCharacter().getCurrentMight());
		assertEquals(1, game.getCurrentPlayer().getEventHand().size());

	}
	
}
