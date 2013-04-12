package test;

import static org.junit.Assert.assertEquals;
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

import characters.Explorer.Explorers;

import Game.Game;
import Game.Player;
import eventCards.AngryBeing;
import eventCards.BloodyVision;
import eventCards.BurningMan;
import eventCards.ClosetDoor;
import eventCards.CreepyCrawlies;
import eventCards.Debris;
import eventCards.EventCard;
import eventCards.Footsteps;
import eventCards.Funeral;
import eventCards.HangedMen;
import eventCards.HideousShriek;
import eventCards.LockedSafe;
import eventCards.MistsFromTheWalls;
import eventCards.Mirror2;
import eventCards.NightView;
import eventCards.PhoneCall;
import eventCards.Possession;
import eventCards.Rotten;
import eventCards.ShriekingWind;
import eventCards.Silence;
import eventCards.Skeletons;
import eventCards.SomethingHidden;
import eventCards.SomethingSlimy;
import eventCards.Spider;
import eventCards.TheBeckoning;
import eventCards.TheLostOne;
import eventCards.TheVoice;

public class TestEventCard {

	private EventCard card;
	private Game game;
	private characters.Explorer character = new characters.Explorer(Explorers.FatherRhinehardt,new Locale("en"));
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
	private String shriekingWindDes = "The wind picks up, a slow crescendo to a screeching howl.";
	private String silenceDes = "Underground, everything goes silent. Even the sound of breathing is gone.";
	private String phoneCallDes = "A phone rings in the room. You feel complelled to answer it.";
	private String spiderDes = "A spider the size of a fist lands on your shoulder... and crawls into your hair.";
	private String hideousShriekDes = "It starts like a whisper, but ends in a soul-rending shriek.";
	private String possessionDes = "A shadow separates from the wall. As you stand in shock, the shadow surrounds you and chills you to the core.";
	private String lockedSafeDes = "Behind a portrait is a wall safe. It is trapped, or course.";
	private String theBeckoningDes = "Outside. You must get outside. Fly to freedom!";
	private String footstepsDes = "The floorboards slowly creak. Dust rises. Footprints appear on the dirty floor. And " +
			"then, as they reach you, they are gone.";
	private String mistsFromTheWallsDes = "Mists pour out from the walls. There are " +
			"faces in the mist, human and ... inhuman.";
	private String bloodyVisionDes = "The walls of this room are damp with blood. The blood drips " +
			"from the ceiling, down the walls, over the furniture, and onto your shoes. In a blink, " +
			"it is gone.";
	private String theLostOneDes = "A woman wearing a Civil War dress beckons to you. You fall into a trance.";
	private String burningManDes = "A man on fire runs through the room. His skin bubbles and cracks, " +
			"falling away from him and leaving a fiery skull that clatters to the ground, bounces, rolls, and disappears.";
	private String closetDoorDes = "That closet door is open... just a crack. Ther must be something inside.";
	
	private EventCard angryBeing = new AngryBeing("Angry Being", angryBeingDes);
	private EventCard creepyCrawlies = new CreepyCrawlies("Creepy Crawlies", creepyCrawliesDes);
	private EventCard nightView = new NightView("Night View", nightViewDes);
	private EventCard rotten = new Rotten("Rotten", rottenDes);
	private ItemCard angelFeather = new AngelFeather("Angel Feather", "A perfect feather fluttering in your hand.");
	private ItemCard adrenalineShotCard = new AdrenalineShot("Adrenaline Shot", "A syringe containing a strange fluorescent liquid.");
	private ItemCard revolverCard = new Revolver("Revolver","WEAPON An old, potent-looking weapon.");	
	private ItemCard puzzleBoxCard = new PuzzleBox("Puzzle Box", "There must be a way to open it.");
	private OmenCard crystalBall = new CrystalBall("Crystal Ball", "Hazy images appear in the glass.");
	private OmenCard book = new Book("Book", "A diary or lab notes? Ancient script or modern ravings?");
	private OmenCard ring = new Ring("Ring","A battered ring with an incomprehensible inscription.");
	private Player player = new Player();
	private ArrayList<EventCard> events = new ArrayList<EventCard>();
	private ArrayList<ItemCard> items = new ArrayList<ItemCard>();
	private ArrayList<OmenCard> omens = new ArrayList<OmenCard>();
	private ArrayList<Player> players = new ArrayList<Player>();
	
	@Before
	public void setUp(){
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
		player.addCharacter(character);
		players.add(player);
		players.add(player);
		
		Game.resetGame();
		game = Game.getInstance();
		game.addAllToEventDeck(events);
		game.addAllToItemDeck(items);
		game.addAllToOmenDeck(omens);
		game.addPlayer(player);
		game.addCharacter(character);
	}
	
	@Test
	public void testRottenInit(){
		card = new Rotten("Rotten", rottenDes);
		assertEquals("Rotten", card.getName());
		assertEquals(rottenDes, card.getDescription());
	}
	
	@Test
	public void testEventCardSets(){
		card = new Rotten("Rotten", rottenDes);
		assertEquals("Rotten", card.getName());
		assertEquals(rottenDes, card.getDescription());
		
		card.setName("Hello");
		card.setDescription("This is a fake description for testing");
		
		assertEquals("Hello", card.getName());
		assertEquals("This is a fake description for testing", card.getDescription());
	}
	
	@Test
	public void testRottenHappen5OrGreater(){
		card = new Rotten("Rotten", rottenDes);
		// Test to be removed
		assertEquals(character, game.getCurrentCharacter());
		card.happen(5);
		assertEquals(7, game.getCurrentCharacter().getCurrentSanity());
		card.happen(6);	
		assertEquals(7, game.getCurrentCharacter().getCurrentSanity());
	}
	
	@Test
	public void testRottenHappen2To4(){
		card = new Rotten("Rotten", rottenDes);
		
		card.happen(4);
		assertEquals(2, game.getCurrentCharacter().getCurrentMight());
		card.happen(2);
		assertEquals(1, game.getCurrentCharacter().getCurrentMight());
		card.happen(5);
		card.happen(3);
		assertEquals(1, game.getCurrentCharacter().getCurrentMight());
	}
	
	@Test 
	public void testRottenHappen1(){
		card = new Rotten("Rotten", rottenDes);
		
		card.happen(1);
		assertEquals(2, game.getCurrentCharacter().getCurrentMight());
		assertEquals(3, game.getCurrentCharacter().getCurrentSpeed());
	}
	
	@Test
	public void testRottenHappen0(){
		card = new Rotten("Rotten", rottenDes);
		
		card.happen(0);
		assertEquals(3, game.getCurrentCharacter().getCurrentKnowledge());
		assertEquals(3, game.getCurrentCharacter().getCurrentSpeed());
		assertEquals(2, game.getCurrentCharacter().getCurrentMight());
		assertEquals(5, game.getCurrentCharacter().getCurrentSanity());
	}
	
	@Test
	public void testAngryBeingInit(){
		card = new AngryBeing("Angry Being", angryBeingDes);
		assertEquals("Angry Being", card.getName());
		assertEquals(angryBeingDes, card.getDescription());
	}
	
	@Test
	public void testAngryBeingHappen5OrGreater(){
		card = new AngryBeing("Angry Being", angryBeingDes);
		// Test to be removed
		assertEquals(character, game.getCurrentCharacter());
		card.happen(5);
		assertEquals(4, game.getCurrentCharacter().getCurrentSpeed());
		card.happen(6);	
		assertEquals(5, game.getCurrentCharacter().getCurrentSpeed());
	}
	
	@Test
	public void testAngryBeingHappen2To4(){
		card = new AngryBeing("Angry Being", angryBeingDes);
		
		card.happen(4);
		assertEquals(3, game.getCurrentCharacter().getCurrentKnowledge());
		card.happen(2);
		assertEquals(3, game.getCurrentCharacter().getCurrentKnowledge());
		card.happen(3);
		assertEquals(1, game.getCurrentCharacter().getCurrentKnowledge());
	}
	
	@Test 
	public void testAngryBeingHappen1Or0(){
		card = new AngryBeing("Angry Being", angryBeingDes);
		
		card.happen(1);
		assertEquals(3, game.getCurrentCharacter().getCurrentKnowledge());
		assertEquals(2, game.getCurrentCharacter().getCurrentMight());
		card.happen(0);
		assertEquals(3, game.getCurrentCharacter().getCurrentKnowledge());
		assertEquals(1, game.getCurrentCharacter().getCurrentMight());
	}

	@Test
	public void testCreepyCrawliesInit(){
		card = new CreepyCrawlies("Creepy Crawlies", creepyCrawliesDes);
		assertEquals("Creepy Crawlies", card.getName());
		assertEquals(creepyCrawliesDes, card.getDescription());
	}
	
	@Test
	public void testCreepyCrawliesHappen5OrGreater(){
		card = new CreepyCrawlies("Creepy Crawlies", creepyCrawliesDes);
		// Test to be removed
		assertEquals(character, game.getCurrentCharacter());
		card.happen(5);
		assertEquals(7, game.getCurrentCharacter().getCurrentSanity());
		card.happen(6);	
		assertEquals(7, game.getCurrentCharacter().getCurrentSanity());
	}
	
	@Test
	public void testCreepyCrawlies1To4(){
		card = new CreepyCrawlies("Angry Being", angryBeingDes);
		
		card.happen(4);
		assertEquals(5, game.getCurrentCharacter().getCurrentSanity());
		card.happen(2);
		assertEquals(5, game.getCurrentCharacter().getCurrentSanity());
		card.happen(3);
		assertEquals(4, game.getCurrentCharacter().getCurrentSanity());
		card.happen(1);
		assertEquals(3, game.getCurrentCharacter().getCurrentSanity());
	}
	
	@Test 
	public void testCreepyCrawliesHappen0(){
		card = new CreepyCrawlies("Creepy Crawlies", creepyCrawliesDes);
		
		card.happen(0);
		assertEquals(5, game.getCurrentCharacter().getCurrentSanity());
	}

	@Test
	public void testNightViewInit(){
		card = new NightView("Night View", nightViewDes);
		assertEquals("Night View", card.getName());
		assertEquals(nightViewDes, card.getDescription());
	}
	
	@Test
	public void testNightViewHappen5OrGreater(){
		card = new NightView("Night View", nightViewDes);
		
		// Test to be removed
		assertEquals(character, game.getCurrentCharacter());
		card.happen(5);
		assertEquals(5, game.getCurrentCharacter().getCurrentKnowledge());
		card.happen(6);	
		assertEquals(6, game.getCurrentCharacter().getCurrentKnowledge());
	}
	
	@Test
	public void testNightViewLessThan5(){
		card = new NightView("Night View", nightViewDes);
		
		
		card.happen(4);
		assertEquals(4, game.getCurrentCharacter().getCurrentKnowledge());
		card.happen(2);
		assertEquals(4, game.getCurrentCharacter().getCurrentKnowledge());
		card.happen(3);
		assertEquals(4, game.getCurrentCharacter().getCurrentKnowledge());
		card.happen(1);
		assertEquals(4, game.getCurrentCharacter().getCurrentKnowledge());
		card.happen(0);
		assertEquals(4, game.getCurrentCharacter().getCurrentKnowledge());
	}
	
	@Test
	public void testFuneralInit(){
		card = new Funeral("Funeral", funeralDes);
		assertEquals("Funeral", card.getName());
		assertEquals(funeralDes, card.getDescription());
	}
	
	@Test
	public void testFuneral4OrGreater(){
		card = new Funeral("Funeral", funeralDes);
		
		// Test to be removed
		assertEquals(character, game.getCurrentCharacter());
		card.happen(4);
		assertEquals(7, game.getCurrentCharacter().getCurrentSanity());
		card.happen(5);	
		assertEquals(7, game.getCurrentCharacter().getCurrentSanity());
	}
	
	@Test
	public void testFuneral2Or3(){
		card = new Funeral("Funeral", funeralDes);
		
		card.happen(3);
		assertEquals(5, game.getCurrentCharacter().getCurrentSanity());
		card.happen(2);
		assertEquals(5, game.getCurrentCharacter().getCurrentSanity());
	}

	@Test
	public void testFuneral0Or1(){
		card = new Funeral("Funeral", funeralDes);
		
		card.happen(1);
		assertEquals(5, game.getCurrentCharacter().getCurrentSanity());
		assertEquals(2, game.getCurrentCharacter().getCurrentMight());
		card.happen(0);
		assertEquals(5, game.getCurrentCharacter().getCurrentSanity());
		assertEquals(1, game.getCurrentCharacter().getCurrentMight());
	}
	
	@Test
	public void testSomethingSlimyInit(){
		card = new SomethingSlimy("Something Slimy", somethingSlimyDes);
		assertEquals("Something Slimy", card.getName());
		assertEquals(somethingSlimyDes, card.getDescription());
	}
	
	@Test
	public void testSomethingSlimy4OrGreater(){
		card = new SomethingSlimy("Something Slimy", somethingSlimyDes);
		
		// Test to be removed
		assertEquals(character, game.getCurrentCharacter());
		card.happen(4);
		assertEquals(4, game.getCurrentCharacter().getCurrentSpeed());
		card.happen(5);	
		assertEquals(5, game.getCurrentCharacter().getCurrentSpeed());
	}
	
	@Test
	public void testSomethingSlimy1Or3(){
		card = new SomethingSlimy("Something Slimy", somethingSlimyDes);
		
		card.happen(3);
		assertEquals(2, game.getCurrentCharacter().getCurrentMight());
		card.happen(2);
		assertEquals(1, game.getCurrentCharacter().getCurrentMight());
		card.happen(5);
		card.happen(1);
		assertEquals(1, game.getCurrentCharacter().getCurrentMight());
	}

	@Test
	public void testSomethingSlimy0(){
		card = new SomethingSlimy("Something Slimy", somethingSlimyDes);
		
		card.happen(0);
		assertEquals(3, game.getCurrentCharacter().getCurrentSpeed());
		assertEquals(2, game.getCurrentCharacter().getCurrentMight());
	}
	
	@Test
	public void testMirror2Init(){
		card = new Mirror2("rorriM ehT nI egamI", mirror2Des);
		assertEquals("rorriM ehT nI egamI", card.getName());
		assertEquals(mirror2Des, card.getDescription());
	}
	
	@Test
	public void testMirror2Happen(){
		card = new Mirror2("rorriM ehT nI egamI", mirror2Des);
		
		assertEquals(0, game.getCurrentCharacter().getItemHand().size());
		card.happens();
		assertEquals(1, game.getCurrentCharacter().getItemHand().size());
		assertEquals(angelFeather, game.getCurrentCharacter().getItemHand().get(0));
		card.happens();	
		assertEquals(2, game.getCurrentCharacter().getItemHand().size());
		assertEquals(adrenalineShotCard, game.getCurrentCharacter().getItemHand().get(1));
	}
	
	@Test
	public void testSkeletonsInit(){
		card = new Skeletons("Skeletons", skeletonsDes);
		assertEquals("Skeletons", card.getName());
		assertEquals(skeletonsDes, card.getDescription());
	}
	
	@Test
	public void testSkeletons5orGreater(){
		card = new Skeletons("Skeletons", skeletonsDes);
		
		assertEquals(0, game.getCurrentCharacter().getItemHand().size());
		card.happen(5);
		assertEquals(1, game.getCurrentCharacter().getItemHand().size());
		assertEquals(angelFeather, game.getCurrentCharacter().getItemHand().get(0));
		card.happen(6);	
		assertEquals(2, game.getCurrentCharacter().getItemHand().size());
		assertEquals(adrenalineShotCard, game.getCurrentCharacter().getItemHand().get(1));
	}
	
	@Test
	public void testSkeletonsLessThan5(){
		card = new Skeletons("Skeletons", skeletonsDes);
		
		assertEquals(0, game.getCurrentCharacter().getItemHand().size());
		card.happen(0);
		assertEquals(0, game.getCurrentCharacter().getItemHand().size());
		assertEquals(5, game.getCurrentCharacter().getCurrentSanity());
		card.happen(1);	
		assertEquals(0, game.getCurrentCharacter().getItemHand().size());
		assertEquals(5, game.getCurrentCharacter().getCurrentSanity());
		card.happen(2);
		assertEquals(0, game.getCurrentCharacter().getItemHand().size());
		assertEquals(4, game.getCurrentCharacter().getCurrentSanity());
		card.happen(3);
		assertEquals(0, game.getCurrentCharacter().getItemHand().size());
		assertEquals(3, game.getCurrentCharacter().getCurrentSanity());
		card.happen(5);
		card.happen(4);
		assertEquals(1, game.getCurrentCharacter().getItemHand().size());
		assertEquals(angelFeather, game.getCurrentCharacter().getItemHand().get(0));
		assertEquals(3, game.getCurrentCharacter().getCurrentSanity());
	}
	
	@Test
	public void testTheVoiceInit(){
		card = new TheVoice("The Voice", theVoiceDes);
		assertEquals("The Voice", card.getName());
		assertEquals(theVoiceDes, card.getDescription());
	}
	
	@Test
	public void testTheVoice4orGreater(){
		card = new TheVoice("The Voice", theVoiceDes);
		
		assertEquals(0, game.getCurrentCharacter().getItemHand().size());
		card.happen(4);
		assertEquals(1, game.getCurrentCharacter().getItemHand().size());
		assertEquals(angelFeather, game.getCurrentCharacter().getItemHand().get(0));
		card.happen(5);	
		assertEquals(2, game.getCurrentCharacter().getItemHand().size());
		assertEquals(adrenalineShotCard, game.getCurrentCharacter().getItemHand().get(1));
	}
	
	@Test
	public void testSomethingHiddenInit(){
		card = new SomethingHidden("Something Hidden", somethingHiddenDes);
		assertEquals("Something Hidden", card.getName());
		assertEquals(somethingHiddenDes, card.getDescription());
	}
	
	@Test
	public void testSomethingHidden4orGreater(){
		card = new SomethingHidden("Something Hidden", somethingHiddenDes);
		
		assertEquals(0, game.getCurrentCharacter().getItemHand().size());
		card.happen(4);
		assertEquals(1, game.getCurrentCharacter().getItemHand().size());
		assertEquals(angelFeather, game.getCurrentCharacter().getItemHand().get(0));
		card.happen(5);	
		assertEquals(2, game.getCurrentCharacter().getItemHand().size());
		assertEquals(adrenalineShotCard, game.getCurrentCharacter().getItemHand().get(1));
	}
	
	@Test
	public void testSomethingHiddenLessThan4(){
		card = new SomethingHidden("Something Hidden", somethingHiddenDes);
		
		assertEquals(0, game.getCurrentCharacter().getItemHand().size());
		card.happen(0);
		assertEquals(0, game.getCurrentCharacter().getItemHand().size());
		assertEquals(5, game.getCurrentCharacter().getCurrentSanity());
		card.happen(1);	
		assertEquals(0, game.getCurrentCharacter().getItemHand().size());
		assertEquals(5, game.getCurrentCharacter().getCurrentSanity());
		card.happen(2);
		assertEquals(0, game.getCurrentCharacter().getItemHand().size());
		assertEquals(4, game.getCurrentCharacter().getCurrentSanity());
		card.happen(3);
		assertEquals(0, game.getCurrentCharacter().getItemHand().size());
		assertEquals(3, game.getCurrentCharacter().getCurrentSanity());
		
	}
	
	@Test
	public void testHangedMenInit(){
		card = new HangedMen("Hanged Men", hangedMenDes);
		assertEquals("Hanged Men", card.getName());
		assertEquals(hangedMenDes, card.getDescription());
	}
	
	@Test
	public void testHangedMen2OrGreater(){
		card = new HangedMen("Hanged Men", hangedMenDes);
		
		assertEquals(4, game.getCurrentCharacter().getCurrentKnowledge());
		assertEquals(2, game.getCurrentCharacter().getCurrentMight());
		assertEquals(6, game.getCurrentCharacter().getCurrentSanity());
		assertEquals(3, game.getCurrentCharacter().getCurrentSpeed());
		
		card.happen(2);
		
		assertEquals(5, game.getCurrentCharacter().getCurrentKnowledge());
		assertEquals(2, game.getCurrentCharacter().getCurrentMight());
		assertEquals(6, game.getCurrentCharacter().getCurrentSanity());
		assertEquals(3, game.getCurrentCharacter().getCurrentSpeed());
		
		card.happen(3);
		
		assertEquals(6, game.getCurrentCharacter().getCurrentKnowledge());
		assertEquals(2, game.getCurrentCharacter().getCurrentMight());
		assertEquals(6, game.getCurrentCharacter().getCurrentSanity());
		assertEquals(3, game.getCurrentCharacter().getCurrentSpeed());
	}
	
	@Test
	public void testHangedMenLessThan2(){
		card = new HangedMen("Hanged Men", hangedMenDes);
		
		assertEquals(4, game.getCurrentCharacter().getCurrentKnowledge());
		assertEquals(2, game.getCurrentCharacter().getCurrentMight());
		assertEquals(6, game.getCurrentCharacter().getCurrentSanity());
		assertEquals(3, game.getCurrentCharacter().getCurrentSpeed());
		
		card.happen(1);
		
		assertEquals(3, game.getCurrentCharacter().getCurrentKnowledge());
		assertEquals(2, game.getCurrentCharacter().getCurrentMight());
		assertEquals(5, game.getCurrentCharacter().getCurrentSanity());
		assertEquals(3, game.getCurrentCharacter().getCurrentSpeed());
		
		card.happen(0);
		
		assertEquals(3, game.getCurrentCharacter().getCurrentKnowledge());
		assertEquals(1, game.getCurrentCharacter().getCurrentMight());
		assertEquals(5, game.getCurrentCharacter().getCurrentSanity());
		assertEquals(2, game.getCurrentCharacter().getCurrentSpeed());
	}
	
	@Test
	public void testDebrisInit(){
		card = new Debris("Debris", debrisDes);
		assertEquals("Debris", card.getName());
		assertEquals(debrisDes, card.getDescription());
	}
	
	@Test
	public void testDebris3OrGreater(){
		card = new Debris("Debris", debrisDes);
		
		assertEquals(0, game.getCurrentCharacter().getEventHand().size());
		assertEquals(3, game.getCurrentCharacter().getCurrentSpeed());		
		card.happen(3);
		
		assertEquals(4, game.getCurrentCharacter().getCurrentSpeed());
		assertEquals(0, game.getCurrentCharacter().getEventHand().size());
		
		card.happen(6);
		
		assertEquals(5, game.getCurrentCharacter().getCurrentSpeed());
		assertEquals(0, game.getCurrentCharacter().getEventHand().size());		
		
	}
	
	@Test
	public void testDebris1Or2(){
		card = new Debris("Debris", debrisDes);
		
		assertEquals(0, game.getCurrentCharacter().getEventHand().size());
		
		card.happen(2);
		
		assertEquals(2, game.getCurrentCharacter().getCurrentMight());
		assertEquals(0, game.getCurrentCharacter().getEventHand().size());
		
		card.happen(1);
		assertEquals(1, game.getCurrentCharacter().getCurrentMight());
		assertEquals(0, game.getCurrentCharacter().getEventHand().size());		
		
	}
	
	@Test
	public void testDebris0(){
		card = new Debris("Debris", debrisDes);
		
		assertEquals(0, game.getCurrentCharacter().getEventHand().size());
		
		card.happen(0);
		
		assertEquals(1, game.getCurrentCharacter().getCurrentMight());
		assertEquals(1, game.getCurrentCharacter().getEventHand().size());

	}
	
	@Test
	public void testShriekingWindInit(){
		card = new ShriekingWind("Shrieking Wind", shriekingWindDes);
		assertEquals("Shrieking Wind", card.getName());
		assertEquals(shriekingWindDes, card.getDescription());
	}
	
	@Test
	public void testShriekingWind5orGreater(){
		card = new ShriekingWind("Shrieking Wind", shriekingWindDes);
		
		assertEquals(3, game.getCurrentCharacter().getCurrentSpeed());
		assertEquals(4, game.getCurrentCharacter().getCurrentKnowledge());
		assertEquals(2, game.getCurrentCharacter().getCurrentMight());
		assertEquals(0, game.getCurrentCharacter().getItemHand().size());
		
		card.happen(5);
		
		assertEquals(3, game.getCurrentCharacter().getCurrentSpeed());
		assertEquals(4, game.getCurrentCharacter().getCurrentKnowledge());
		assertEquals(2, game.getCurrentCharacter().getCurrentMight());
		assertEquals(0, game.getCurrentCharacter().getItemHand().size());
		
		card.happen(6);
		
		assertEquals(3, game.getCurrentCharacter().getCurrentSpeed());
		assertEquals(4, game.getCurrentCharacter().getCurrentKnowledge());
		assertEquals(2, game.getCurrentCharacter().getCurrentMight());
		assertEquals(0, game.getCurrentCharacter().getItemHand().size());
		
	}
	
	@Test
	public void testShriekingWind3or4(){
		card = new ShriekingWind("Shrieking Wind", shriekingWindDes);
		
		assertEquals(3, game.getCurrentCharacter().getCurrentSpeed());
		assertEquals(4, game.getCurrentCharacter().getCurrentKnowledge());
		assertEquals(2, game.getCurrentCharacter().getCurrentMight());
		assertEquals(0, game.getCurrentCharacter().getItemHand().size());
		
		game.getCurrentCharacter().addItemCard(game.drawItem());
		
		assertEquals(1, game.getCurrentCharacter().getItemHand().size());
		
		card.happen(4);
		
		assertEquals(3, game.getCurrentCharacter().getCurrentSpeed());
		assertEquals(4, game.getCurrentCharacter().getCurrentKnowledge());
		assertEquals(2, game.getCurrentCharacter().getCurrentMight());
		assertEquals(1, game.getCurrentCharacter().getItemHand().size());
		
		card.happen(3);
		
		assertEquals(2, game.getCurrentCharacter().getCurrentSpeed());
		assertEquals(4, game.getCurrentCharacter().getCurrentKnowledge());
		assertEquals(2, game.getCurrentCharacter().getCurrentMight());
		assertEquals(1, game.getCurrentCharacter().getItemHand().size());
	}

	@Test
	public void testShriekingWind1or2(){
		card = new ShriekingWind("Shrieking Wind", shriekingWindDes);
		
		assertEquals(3, game.getCurrentCharacter().getCurrentSpeed());
		assertEquals(4, game.getCurrentCharacter().getCurrentKnowledge());
		assertEquals(2, game.getCurrentCharacter().getCurrentMight());
		assertEquals(0, game.getCurrentCharacter().getItemHand().size());
		
		game.getCurrentCharacter().addItemCard(game.drawItem());
		
		assertEquals(1, game.getCurrentCharacter().getItemHand().size());
		
		card.happen(2);
		
		assertEquals(3, game.getCurrentCharacter().getCurrentSpeed());
		assertEquals(3, game.getCurrentCharacter().getCurrentKnowledge());
		assertEquals(2, game.getCurrentCharacter().getCurrentMight());
		assertEquals(1, game.getCurrentCharacter().getItemHand().size());
		
		card.happen(1);
		
		assertEquals(3, game.getCurrentCharacter().getCurrentSpeed());
		assertEquals(3, game.getCurrentCharacter().getCurrentKnowledge());
		assertEquals(2, game.getCurrentCharacter().getCurrentMight());
		assertEquals(1, game.getCurrentCharacter().getItemHand().size());
	}
	
	@Test
	public void testShriekingWind0(){
		card = new ShriekingWind("Shrieking Wind", shriekingWindDes);
		
		assertEquals(3, game.getCurrentCharacter().getCurrentSpeed());
		assertEquals(4, game.getCurrentCharacter().getCurrentKnowledge());
		assertEquals(2, game.getCurrentCharacter().getCurrentMight());
		assertEquals(0, game.getCurrentCharacter().getItemHand().size());
		
		game.getCurrentCharacter().addItemCard(game.drawItem());
		
		assertEquals(1, game.getCurrentCharacter().getItemHand().size());
		
		card.happen(0);
		
		assertEquals(3, game.getCurrentCharacter().getCurrentSpeed());
		assertEquals(4, game.getCurrentCharacter().getCurrentKnowledge());
		assertEquals(2, game.getCurrentCharacter().getCurrentMight());
		assertEquals(0, game.getCurrentCharacter().getItemHand().size());
		
		game.getCurrentCharacter().addItemCard(game.drawItem());
		
		assertEquals(1, game.getCurrentCharacter().getItemHand().size());
		
		card.happen(0);
		
		assertEquals(3, game.getCurrentCharacter().getCurrentSpeed());
		assertEquals(4, game.getCurrentCharacter().getCurrentKnowledge());
		assertEquals(1, game.getCurrentCharacter().getCurrentMight());
		assertEquals(0, game.getCurrentCharacter().getItemHand().size());
	}
	
	@Test
	public void testSilenceInit(){
		card = new Silence("Silence", silenceDes);
		assertEquals("Silence", card.getName());
		assertEquals(silenceDes, card.getDescription());
	}
	
	@Test
	public void testSilence4orGreater(){
		card = new Silence("Silence", silenceDes);
		
		assertEquals(4, game.getCurrentCharacter().getCurrentKnowledge());
		
		card.happen(4);
		
		assertEquals(4, game.getCurrentCharacter().getCurrentKnowledge());
		
		card.happen(5);
		
		assertEquals(4, game.getCurrentCharacter().getCurrentKnowledge());
		
	}
	
	@Test
	public void testSilence1To3(){
		card = new Silence("Silence", silenceDes);
		
		assertEquals(4, game.getCurrentCharacter().getCurrentKnowledge());
		
		card.happen(1);
		
		assertEquals(3, game.getCurrentCharacter().getCurrentKnowledge());
		
		card.happen(2);
		
		assertEquals(3, game.getCurrentCharacter().getCurrentKnowledge());
		
		card.happen(3);
		
		assertEquals(1, game.getCurrentCharacter().getCurrentKnowledge());
	}
	
	@Test
	public void testSilence0(){
		card = new Silence("Silence", silenceDes);
		
		game.getCurrentCharacter().incrementKnowledge();
		
		assertEquals(5, game.getCurrentCharacter().getCurrentKnowledge());
		
		card.happen(0);
		
		assertEquals(3, game.getCurrentCharacter().getCurrentKnowledge());
		
		card.happen(0);
		
		assertEquals(1, game.getCurrentCharacter().getCurrentKnowledge());
	}
	
	@Test
	public void testPhoneCallInit(){
		card = new Silence("Phone Call", phoneCallDes);
		assertEquals("Phone Call", card.getName());
		assertEquals(phoneCallDes, card.getDescription());
	}
	
	@Test
	public void testPhoneCall4(){
		card = new PhoneCall("Phone Call", phoneCallDes);
		
		card.happen(4);
		
		assertEquals(7, game.getCurrentCharacter().getCurrentSanity());
		
		card.happen(4);
		
		assertEquals(7, game.getCurrentCharacter().getCurrentSanity());
		
	}
	
	@Test
	public void testPhoneCall3(){
		card = new PhoneCall("Phone Call", phoneCallDes);
		
		card.happen(3);
		
		assertEquals(5, game.getCurrentCharacter().getCurrentKnowledge());
		
		card.happen(3);
		
		assertEquals(6, game.getCurrentCharacter().getCurrentKnowledge());
		
	}
	
	@Test
	public void testPhoneCall1or2(){
		card = new PhoneCall("Phone Call", phoneCallDes);
		
		card.happen(1);
		
		assertEquals(3, game.getCurrentCharacter().getCurrentKnowledge());
		
		card.happen(2);
		
		assertEquals(3, game.getCurrentCharacter().getCurrentKnowledge());
		
		card.happen(2);
		
		assertEquals(1, game.getCurrentCharacter().getCurrentKnowledge());
		
	}
	
	@Test
	public void testPhoneCall0(){
		card = new PhoneCall("Phone Call", phoneCallDes);
		
		card.happen(0);
		assertEquals(1, game.getCurrentCharacter().getCurrentMight());
		
	}
	
	@Test
	public void testSpiderInit(){
		card = new Spider("Spider", spiderDes);
		assertEquals("Spider", card.getName());
		assertEquals(spiderDes, card.getDescription());
	}
	
	@Test
	public void testSpider4OrGreater(){
		card = new Spider("Spider", spiderDes);
		
		card.happen(4);
		assertEquals(4, game.getCurrentCharacter().getCurrentSpeed());
		
		card.happen(5);
		assertEquals(5, game.getCurrentCharacter().getCurrentSpeed());
	}
	
	@Test
	public void testSpider1To3(){
		card = new Spider("Spider", spiderDes);
		
		game.getCurrentCharacter().incrementSpeed();
		game.getCurrentCharacter().incrementSpeed();
		game.getCurrentCharacter().incrementSpeed();
		
		assertEquals(6, game.getCurrentCharacter().getCurrentSpeed());
		
		card.happen(1);
		assertEquals(5, game.getCurrentCharacter().getCurrentSpeed());
		
		card.happen(2);
		assertEquals(4, game.getCurrentCharacter().getCurrentSpeed());
		
		card.happen(3);
		assertEquals(3, game.getCurrentCharacter().getCurrentSpeed());
	}
	

	@Test
	public void testSpider0(){
		card = new Spider("Spider", spiderDes);
		
		card.happen(0);
		assertEquals(2, game.getCurrentCharacter().getCurrentSpeed());
	}
	
	@Test
	public void testHideousShriekInit(){
		card = new HideousShriek("Hideous Shriek", hideousShriekDes);
		assertEquals("Hideous Shriek", card.getName());
		assertEquals(hideousShriekDes, card.getDescription());
	}
	
	@Test
	public void testHideousShriek4OrGreater(){
		card = new HideousShriek("Hideous Shriek", hideousShriekDes);
		
		card.happen(4);
		assertEquals(character, game.getCurrentCharacter());
		
		card.happen(5);
		assertEquals(character, game.getCurrentCharacter());
	}
	
	@Test
	public void testHideousShriek1To3(){
		card = new HideousShriek("Hideous Shriek", hideousShriekDes);
		
		game.getCurrentCharacter().incrementSanity();
		game.getCurrentCharacter().incrementSanity();
		
		assertEquals(7, game.getCurrentCharacter().getCurrentSanity());
		
		card.happen(1);
		assertEquals(7, game.getCurrentCharacter().getCurrentSanity());
		
		card.happen(2);
		assertEquals(6, game.getCurrentCharacter().getCurrentSanity());
		
		card.happen(3);
		assertEquals(5, game.getCurrentCharacter().getCurrentSanity());
	}
	

	@Test
	public void testHideousShriek0(){
		card = new HideousShriek("Hideous Shriek", hideousShriekDes);
		
		game.getCurrentCharacter().decrementSanity();
		assertEquals(5, game.getCurrentCharacter().getCurrentSanity());
		
		card.happen(0);
		assertEquals(4, game.getCurrentCharacter().getCurrentSanity());
	}
	
	@Test
	public void testPossessionInit(){
		card = new Possession("Possession", possessionDes);
		assertEquals("Possession", card.getName());
		assertEquals(possessionDes, card.getDescription());
	}
	
	@Test
	public void testPossession4OrGreater(){
		card = new Possession("Possession", possessionDes);
		
		card.happen(4);
		assertEquals(5, game.getCurrentCharacter().getCurrentKnowledge());
		
		card.happen(5);
		assertEquals(6, game.getCurrentCharacter().getCurrentKnowledge());
	}
	
	@Test
	public void testPossession0To3(){
		card = new Possession("Possession", possessionDes);
		
		assertEquals(6, game.getCurrentCharacter().getCurrentSanity());
		assertEquals(2, game.getCurrentCharacter().getCurrentMight());
		assertEquals(3, game.getCurrentCharacter().getCurrentSpeed());
		assertEquals(4, game.getCurrentCharacter().getCurrentKnowledge());
		
		card.happen(0);
		assertEquals(6, game.getCurrentCharacter().getCurrentSanity());
		assertEquals(2, game.getCurrentCharacter().getCurrentMight());
		assertEquals(3, game.getCurrentCharacter().getCurrentSpeed());
		assertEquals(1, game.getCurrentCharacter().getCurrentKnowledge());
		
		card.happen(1);
		assertEquals(6, game.getCurrentCharacter().getCurrentSanity());
		assertEquals(2, game.getCurrentCharacter().getCurrentMight());
		assertEquals(2, game.getCurrentCharacter().getCurrentSpeed());
		assertEquals(1, game.getCurrentCharacter().getCurrentKnowledge());
		
		card.happen(2);
		assertEquals(1, game.getCurrentCharacter().getCurrentMight());
		assertEquals(2, game.getCurrentCharacter().getCurrentSpeed());
		assertEquals(1, game.getCurrentCharacter().getCurrentKnowledge());
		assertEquals(6, game.getCurrentCharacter().getCurrentSanity());
		
		card.happen(3);
		assertEquals(3, game.getCurrentCharacter().getCurrentSanity());
		assertEquals(1, game.getCurrentCharacter().getCurrentMight());
		assertEquals(2, game.getCurrentCharacter().getCurrentSpeed());
		assertEquals(1, game.getCurrentCharacter().getCurrentKnowledge());
		
	}
	
	@Test
	public void testLockedSafeInit(){
		card = new LockedSafe("Locked Safe", lockedSafeDes);
		assertEquals("Locked Safe", card.getName());
		assertEquals(lockedSafeDes, card.getDescription());
	}
	
	@Test
	public void testLockedSafe4OrGreater(){
		card = new LockedSafe("Locked Safe", lockedSafeDes);
		
		assertEquals(0, game.getCurrentCharacter().getItemHand().size());
		
		card.happen(5);
		assertEquals(2, game.getCurrentCharacter().getItemHand().size());
		assertEquals(angelFeather, game.getCurrentCharacter().getItemHand().get(0));
		assertEquals(adrenalineShotCard, game.getCurrentCharacter().getItemHand().get(1));
		assertEquals(2, game.getItemDeck().size());
		
		card.happen(6);
		assertEquals(4, game.getCurrentCharacter().getItemHand().size());
		assertEquals(angelFeather, game.getCurrentCharacter().getItemHand().get(0));
		assertEquals(adrenalineShotCard, game.getCurrentCharacter().getItemHand().get(1));
		assertEquals(revolverCard, game.getCurrentCharacter().getItemHand().get(2));
		assertEquals(puzzleBoxCard, game.getCurrentCharacter().getItemHand().get(3));
		assertEquals(0, game.getItemDeck().size());
		
	}
	
	@Test
	public void testLockedSafe2To4(){
		card = new LockedSafe("Locked Safe", lockedSafeDes);
		
		game.getCurrentCharacter().incrementSpeed();
		game.getCurrentCharacter().incrementSpeed();
		game.getCurrentCharacter().incrementSpeed();
		
		assertEquals(6, game.getCurrentCharacter().getCurrentSpeed());
		
		card.happen(2);
		assertEquals(5, game.getCurrentCharacter().getCurrentSpeed());
		
		card.happen(3);
		assertEquals(4, game.getCurrentCharacter().getCurrentSpeed());
		
		card.happen(4);
		assertEquals(3, game.getCurrentCharacter().getCurrentSpeed());
		
	}
	

	@Test
	public void testLockedSafe0And1(){
		card = new LockedSafe("Locked Safe", lockedSafeDes);
		
		game.getCurrentCharacter().incrementSpeed();
		game.getCurrentCharacter().incrementSpeed();
		assertEquals(5, game.getCurrentCharacter().getCurrentSpeed());
		
		card.happen(0);
		assertEquals(3, game.getCurrentCharacter().getCurrentSpeed());
		
		card.happen(1);
		assertEquals(2, game.getCurrentCharacter().getCurrentSpeed());
	}
	
	@Test
	public void testTheBeckoningInit(){
		card = new TheBeckoning("The Beckoning", theBeckoningDes);
		assertEquals("The Beckoning", card.getName());
		assertEquals(theBeckoningDes, card.getDescription());
	}

	@Test
	public void testLockedSafe3OrGreater(){
		card = new TheBeckoning("The Beckoning", theBeckoningDes);
		
		card.happen(3);
		assertEquals(character, game.getCurrentCharacter());
		
		card.happen(4);
		assertEquals(character, game.getCurrentCharacter());
		
	}

	@Test
	public void testLockedSafe0To2Damage(){
		card = new TheBeckoning("The Beckoning", theBeckoningDes);
		
		game.getCurrentCharacter().incrementSpeed();
		game.getCurrentCharacter().incrementSpeed();
		game.getCurrentCharacter().incrementSpeed();
		
		assertEquals(6, game.getCurrentCharacter().getCurrentSpeed());
		
		card.happen(0);
		assertEquals(5, game.getCurrentCharacter().getCurrentSpeed());
		
		card.happen(1);
		assertEquals(4, game.getCurrentCharacter().getCurrentSpeed());
		
		card.happen(2);
		assertEquals(3, game.getCurrentCharacter().getCurrentSpeed());

	}
	
	@Test
	public void testFootstepsInit(){
		card = new Footsteps("Footsteps", footstepsDes);
		assertEquals("Footsteps", card.getName());
		assertEquals(footstepsDes, card.getDescription());
	}
	
	@Test 
	public void testFootsteps4(){
		card = new Footsteps("Footsteps", footstepsDes);
		
		card.happen(4);
		assertEquals(4, game.getCurrentCharacter().getCurrentMight());
	}
	
	@Test 
	public void testFootsteps3(){
		card = new Footsteps("Footsteps", footstepsDes);
		
		card.happen(3);
		assertEquals(4, game.getCurrentCharacter().getCurrentMight());
	}
	
	@Test 
	public void testFootsteps2(){
		card = new Footsteps("Footsteps", footstepsDes);
		
		card.happen(2);
		assertEquals(5, game.getCurrentCharacter().getCurrentSanity());
	}
	
	@Test 
	public void testFootsteps1(){
		card = new Footsteps("Footsteps", footstepsDes);
		
		game.getCurrentCharacter().incrementSpeed();
		assertEquals(4, game.getCurrentCharacter().getCurrentSpeed());
		
		card.happen(1);
		assertEquals(3, game.getCurrentCharacter().getCurrentSpeed());
	}
	
	@Test 
	public void testFootsteps0(){
		card = new Footsteps("Footsteps", footstepsDes);
		
		card.happen(0);
		assertEquals(5, game.getCurrentCharacter().getCurrentSanity());
	}
	
	@Test
	public void testMistsFromTheWallsInit(){
		card = new MistsFromTheWalls("Mists From The Walls", mistsFromTheWallsDes);
		assertEquals("Mists From The Walls", card.getName());
		assertEquals(mistsFromTheWallsDes, card.getDescription());
	}
	
	@Test
	public void testMistsFromTheWalls4OrGreater(){
		card = new MistsFromTheWalls("Mists From The Walls", mistsFromTheWallsDes);
		
		card.happen(4);
		assertEquals(character, game.getCurrentCharacter());
		
		card.happen(5);
		assertEquals(character, game.getCurrentCharacter());
	}
	
	@Test
	public void testMistsFromTheWalls1To3(){
		card = new MistsFromTheWalls("Mists From The Walls", mistsFromTheWallsDes);
		
		card.happen(1);
		assertEquals(5, game.getCurrentCharacter().getCurrentSanity());
		
		card.happen(2);
		assertEquals(5, game.getCurrentCharacter().getCurrentSanity());
		
		card.happen(3);
		assertEquals(4, game.getCurrentCharacter().getCurrentSanity());
	}
	
	@Test
	public void testMistsFromTheWalls0(){
		card = new MistsFromTheWalls("Mists From The Walls", mistsFromTheWallsDes);
		
		card.happen(0);
		assertEquals(5, game.getCurrentCharacter().getCurrentSanity());
	}
	
	@Test
	public void testBloodyVisionInit(){
		card = new BloodyVision("Bloody Vision", bloodyVisionDes);
		assertEquals("Bloody Vision", card.getName());
		assertEquals(bloodyVisionDes, card.getDescription());
	}
	
	@Test
	public void testBloddyVision4OrGreater(){
		card = new BloodyVision("Bloody Vision", bloodyVisionDes);
		
		card.happen(4);
		assertEquals(7, game.getCurrentCharacter().getCurrentSanity());
		
		card.happen(5);
		assertEquals(7, game.getCurrentCharacter().getCurrentSanity());
		
	}
	
	@Test
	public void testBloddyVision2Or3(){
		card = new BloodyVision("Bloody Vision", bloodyVisionDes);
		
		card.happen(2);
		assertEquals(5, game.getCurrentCharacter().getCurrentSanity());
		
		card.happen(3);
		assertEquals(5, game.getCurrentCharacter().getCurrentSanity());
		
	}
	
	@Test
	public void testBloodyVision1Or0(){
		card = new BloodyVision("Bloody Vision", bloodyVisionDes);
		// For now do nothing because the need methods are not yet implemented for attack
		
	}
	
	@Test
	public void testTheLostOneInit(){
		card = new TheLostOne("The Lost One", theLostOneDes);
		assertEquals("The Lost One", card.getName());
		assertEquals(theLostOneDes, card.getDescription());
	}// Only test for now. Don't have methods to develop further yet
	
	@Test
	public void testBurningManInit(){
		card = new BurningMan("Burning Man", burningManDes);
		assertEquals("Burning Man", card.getName());
		assertEquals(burningManDes, card.getDescription());
	}
	
	@Test
	public void testBurningMan4OrGreater(){
		card = new BurningMan("Burning Man", burningManDes);
		
		card.happen(4);
		assertEquals(7, game.getCurrentCharacter().getCurrentSanity());
		
		card.happen(5);
		assertEquals(7, game.getCurrentCharacter().getCurrentSanity());
	}
	
	@Test
	public void testBurningMan2Or3(){
		card = new BurningMan("Burning Man", burningManDes);
		// Needs to test that location is in the EntranceHall but this doesn't exist yet
	}

	@Test
	public void testBurningMan1Or0(){
		card = new BurningMan("Burning Man", burningManDes);
		
		card.happen(1);
		assertEquals(5, game.getCurrentCharacter().getCurrentSanity());
		assertEquals(2, game.getCurrentCharacter().getCurrentMight());
		
		card.happen(0);
		assertEquals(5, game.getCurrentCharacter().getCurrentSanity());
		assertEquals(1, game.getCurrentCharacter().getCurrentMight());
	}
	
	@Test
	public void testClosetDoorInit(){
		card = new ClosetDoor("Closet Door", closetDoorDes);
		assertEquals("Closet Door", card.getName());
		assertEquals(closetDoorDes, card.getDescription());
	}
	
	@Test
	public void testClosetDoor4(){
		card = new ClosetDoor("Closet Door", closetDoorDes);
		
		assertEquals(0, game.getCurrentCharacter().getItemHand().size());
		
		card.happen(4);
		assertEquals(1, game.getCurrentCharacter().getItemHand().size());
		assertEquals(angelFeather, game.getCurrentCharacter().getItemHand().get(0));
	}
	
	@Test
	public void testClosetDoor2Or3(){
		card = new ClosetDoor("Closet Door", closetDoorDes);
		
		assertEquals(0, game.getCurrentCharacter().getEventHand().size());
		
		card.happen(2);
		assertEquals(1, game.getCurrentCharacter().getEventHand().size());
		assertEquals(angryBeing, game.getCurrentCharacter().getEventHand().get(0));
		
		card.happen(3);
		assertEquals(2, game.getCurrentCharacter().getEventHand().size());
		assertEquals(creepyCrawlies, game.getCurrentCharacter().getEventHand().get(1));
	}
	
	@Test
	public void testClosetDoor1Or0(){
		// Eventually needs to test for removal of Closet Token
		card = new ClosetDoor("Closet Door", closetDoorDes);
		
		assertEquals(0, game.getCurrentCharacter().getEventHand().size());
		
		card.happen(0);
		assertEquals(1, game.getCurrentCharacter().getEventHand().size());
		assertEquals(angryBeing, game.getCurrentCharacter().getEventHand().get(0));
		
		card.happen(1);
		assertEquals(2, game.getCurrentCharacter().getEventHand().size());
		assertEquals(creepyCrawlies, game.getCurrentCharacter().getEventHand().get(1));
	}
	
	
}
