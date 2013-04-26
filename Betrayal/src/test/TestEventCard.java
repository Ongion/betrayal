package test;

import static org.junit.Assert.assertEquals;
import itemCards.AdrenalineShot;
import itemCards.AngelFeather;
import itemCards.ItemCard;
import itemCards.PuzzleBox;
import itemCards.Revolver;

import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

import omenCards.Book;
import omenCards.CrystalBall;
import omenCards.OmenCard;
import omenCards.Ring;

import org.junit.Before;
import org.junit.Test;

import characters.Character.Character_Name;
import characters.ExplorerFactory;

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
	
	private Locale enLocale = new Locale("en", "US");
	private Locale spLocale = new Locale("es", "ES");
	
	private ResourceBundle mesEN = ResourceBundle.getBundle("EventCardBundle", enLocale);
	private ResourceBundle mesSP = ResourceBundle.getBundle("EventCardBundle", spLocale);
	
	
	private ExplorerFactory explorers = new ExplorerFactory();
	private characters.Character character;
	
	
	private EventCard angryBeing = new AngryBeing(enLocale);
	private EventCard creepyCrawlies = new CreepyCrawlies(enLocale);
	private EventCard nightView = new NightView(enLocale);
	private EventCard rotten = new Rotten(enLocale);
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
		character = explorers.getExplorer(Character_Name.FatherRhinehardt);
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
		card = new Rotten(enLocale);
		assertEquals(mesEN.getString("titleRotten"), card.getName());
		assertEquals(mesEN.getString("desRotten"), card.getDescription());
		assertEquals(mesEN.getString("rulesRotten"), card.getRules());
		
		//Check Spanish
		card = new Rotten(spLocale);
		assertEquals(mesSP.getString("titleRotten"), card.getName());
		assertEquals(mesSP.getString("desRotten"), card.getDescription());
		assertEquals(mesSP.getString("rulesRotten"), card.getRules());
		
	}
	
	@Test
	public void testEventCardSets(){
		card = new Rotten(enLocale);
		assertEquals(mesEN.getString("titleRotten"), card.getName());
		assertEquals(mesEN.getString("desRotten"), card.getDescription());
		assertEquals(mesEN.getString("rulesRotten"), card.getRules());
		
		card.setName("Hello");
		card.setDescription("This is a fake description for testing");
		card.setRules("These are fake rules");
		
		assertEquals("Hello", card.getName());
		assertEquals("This is a fake description for testing", card.getDescription());
		assertEquals("These are fake rules", card.getRules());
	}
	
	@Test
	public void testRottenHappen5OrGreater(){
		card = new Rotten(enLocale);
		// Test to be removed
		assertEquals(character, game.getCurrentCharacter());
		card.happen(5);
		assertEquals(7, game.getCurrentCharacter().getCurrentSanity());
		card.happen(6);	
		assertEquals(7, game.getCurrentCharacter().getCurrentSanity());
	}
	
	@Test
	public void testRottenHappen2To4(){
		card = new Rotten(enLocale);
		
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
		card = new Rotten(enLocale);
		
		card.happen(1);
		assertEquals(2, game.getCurrentCharacter().getCurrentMight());
		assertEquals(3, game.getCurrentCharacter().getCurrentSpeed());
	}
	
	@Test
	public void testRottenHappen0(){
		card = new Rotten(enLocale);
		
		card.happen(0);
		assertEquals(3, game.getCurrentCharacter().getCurrentKnowledge());
		assertEquals(3, game.getCurrentCharacter().getCurrentSpeed());
		assertEquals(2, game.getCurrentCharacter().getCurrentMight());
		assertEquals(5, game.getCurrentCharacter().getCurrentSanity());
	}
	
	@Test
	public void testAngryBeingInit(){
		card = new AngryBeing(enLocale);
		assertEquals(mesEN.getString("titleAngryBeing"), card.getName());
		assertEquals(mesEN.getString("desAngryBeing"), card.getDescription());
		assertEquals(mesEN.getString("rulesAngryBeing"), card.getRules());
		
		//Check Spanish
		card = new AngryBeing(spLocale);
		assertEquals(mesSP.getString("titleAngryBeing"), card.getName());
		assertEquals(mesSP.getString("desAngryBeing"), card.getDescription());
		assertEquals(mesSP.getString("rulesAngryBeing"), card.getRules());
	}
	
	@Test
	public void testAngryBeingHappen5OrGreater(){
		card = new AngryBeing(enLocale);
		// Test to be removed
		assertEquals(character, game.getCurrentCharacter());
		card.happen(5);
		assertEquals(4, game.getCurrentCharacter().getCurrentSpeed());
		card.happen(6);	
		assertEquals(5, game.getCurrentCharacter().getCurrentSpeed());
	}
	
	@Test
	public void testAngryBeingHappen2To4(){
		card = new AngryBeing(enLocale);
		
		card.happen(4);
		assertEquals(3, game.getCurrentCharacter().getCurrentKnowledge());
		card.happen(2);
		assertEquals(3, game.getCurrentCharacter().getCurrentKnowledge());
		card.happen(3);
		assertEquals(1, game.getCurrentCharacter().getCurrentKnowledge());
	}
	
	@Test 
	public void testAngryBeingHappen1Or0(){
		card = new AngryBeing(enLocale);
		
		card.happen(1);
		assertEquals(3, game.getCurrentCharacter().getCurrentKnowledge());
		assertEquals(2, game.getCurrentCharacter().getCurrentMight());
		card.happen(0);
		assertEquals(3, game.getCurrentCharacter().getCurrentKnowledge());
		assertEquals(1, game.getCurrentCharacter().getCurrentMight());
	}

	@Test
	public void testCreepyCrawliesInit(){
		card = new CreepyCrawlies(enLocale);
		assertEquals(mesEN.getString("titleCreepyCrawlies"), card.getName());
		assertEquals(mesEN.getString("desCreepyCrawlies"), card.getDescription());
		assertEquals(mesEN.getString("rulesCreepyCrawlies"), card.getRules());
		
		//Check Spanish
		card = new CreepyCrawlies(spLocale);
		assertEquals(mesSP.getString("titleCreepyCrawlies"), card.getName());
		assertEquals(mesSP.getString("desCreepyCrawlies"), card.getDescription());
		assertEquals(mesSP.getString("rulesCreepyCrawlies"), card.getRules());
	}
	
	@Test
	public void testCreepyCrawliesHappen5OrGreater(){
		card = new CreepyCrawlies(enLocale);
		// Test to be removed
		assertEquals(character, game.getCurrentCharacter());
		card.happen(5);
		assertEquals(7, game.getCurrentCharacter().getCurrentSanity());
		card.happen(6);	
		assertEquals(7, game.getCurrentCharacter().getCurrentSanity());
	}
	
	@Test
	public void testCreepyCrawlies1To4(){
		card = new CreepyCrawlies(enLocale);
		
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
		card = new CreepyCrawlies(enLocale);
		
		card.happen(0);
		assertEquals(5, game.getCurrentCharacter().getCurrentSanity());
	}

	@Test
	public void testNightViewInit(){
		card = new NightView(enLocale);
		assertEquals(mesEN.getString("titleNightView"), card.getName());
		assertEquals(mesEN.getString("desNightView"), card.getDescription());
		assertEquals(mesEN.getString("rulesNightView"), card.getRules());
		
		//Check Spanish
		card = new NightView(spLocale);
		assertEquals(mesSP.getString("titleNightView"), card.getName());
		assertEquals(mesSP.getString("desNightView"), card.getDescription());
		assertEquals(mesSP.getString("rulesNightView"), card.getRules());
	}
	
	@Test
	public void testNightViewHappen5OrGreater(){
		card = new NightView(enLocale);
		
		// Test to be removed
		assertEquals(character, game.getCurrentCharacter());
		card.happen(5);
		assertEquals(5, game.getCurrentCharacter().getCurrentKnowledge());
		card.happen(6);	
		assertEquals(6, game.getCurrentCharacter().getCurrentKnowledge());
	}
	
	@Test
	public void testNightViewLessThan5(){
		card = new NightView(enLocale);
				
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
		card = new Funeral(enLocale);
		assertEquals(mesEN.getString("titleFuneral"), card.getName());
		assertEquals(mesEN.getString("desFuneral"), card.getDescription());
		assertEquals(mesEN.getString("rulesFuneral"), card.getRules());
		
		//Check Spanish
		card = new Funeral(spLocale);
		assertEquals(mesSP.getString("titleFuneral"), card.getName());
		assertEquals(mesSP.getString("desFuneral"), card.getDescription());
		assertEquals(mesSP.getString("rulesFuneral"), card.getRules());
	}
	
	@Test
	public void testFuneral4OrGreater(){
		card = new Funeral(enLocale);
		
		// Test to be removed
		assertEquals(character, game.getCurrentCharacter());
		card.happen(4);
		assertEquals(7, game.getCurrentCharacter().getCurrentSanity());
		card.happen(5);	
		assertEquals(7, game.getCurrentCharacter().getCurrentSanity());
	}
	
	@Test
	public void testFuneral2Or3(){
		card = new Funeral(enLocale);
		
		card.happen(3);
		assertEquals(5, game.getCurrentCharacter().getCurrentSanity());
		card.happen(2);
		assertEquals(5, game.getCurrentCharacter().getCurrentSanity());
	}

	@Test
	public void testFuneral0Or1(){
		card = new Funeral(enLocale);
		
		card.happen(1);
		assertEquals(5, game.getCurrentCharacter().getCurrentSanity());
		assertEquals(2, game.getCurrentCharacter().getCurrentMight());
		card.happen(0);
		assertEquals(5, game.getCurrentCharacter().getCurrentSanity());
		assertEquals(1, game.getCurrentCharacter().getCurrentMight());
	}
	
	@Test
	public void testSomethingSlimyInit(){
		card = new SomethingSlimy(enLocale);
		assertEquals(mesEN.getString("titleSomethingSlimy"), card.getName());
		assertEquals(mesEN.getString("desSomethingSlimy"), card.getDescription());
		assertEquals(mesEN.getString("rulesSomethingSlimy"), card.getRules());
		
		//Check Spanish
		card = new SomethingSlimy(spLocale);
		assertEquals(mesSP.getString("titleSomethingSlimy"), card.getName());
		assertEquals(mesSP.getString("desSomethingSlimy"), card.getDescription());
		assertEquals(mesSP.getString("rulesSomethingSlimy"), card.getRules());
	}
	
	@Test
	public void testSomethingSlimy4OrGreater(){
		card = new SomethingSlimy(enLocale);
		
		// Test to be removed
		assertEquals(character, game.getCurrentCharacter());
		card.happen(4);
		assertEquals(4, game.getCurrentCharacter().getCurrentSpeed());
		card.happen(5);	
		assertEquals(5, game.getCurrentCharacter().getCurrentSpeed());
	}
	
	@Test
	public void testSomethingSlimy1Or3(){
		card = new SomethingSlimy(enLocale);
		
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
		card = new SomethingSlimy(enLocale);
		
		card.happen(0);
		assertEquals(3, game.getCurrentCharacter().getCurrentSpeed());
		assertEquals(2, game.getCurrentCharacter().getCurrentMight());
	}
	
	@Test
	public void testMirror2Init(){
		card = new Mirror2(enLocale);
		assertEquals(mesEN.getString("titleMirror2"), card.getName());
		assertEquals(mesEN.getString("desMirror2"), card.getDescription());
		assertEquals(mesEN.getString("rulesMirror2"), card.getRules());
		
		//Check Spanish
		card = new Mirror2(spLocale);
		assertEquals(mesSP.getString("titleMirror2"), card.getName());
		assertEquals(mesSP.getString("desMirror2"), card.getDescription());
		assertEquals(mesSP.getString("rulesMirror2"), card.getRules());
	}
	
	@Test
	public void testMirror2Happen(){
		card = new Mirror2(enLocale);
		
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
		card = new Skeletons(enLocale);
		assertEquals(mesEN.getString("titleSkeletons"), card.getName());
		assertEquals(mesEN.getString("desSkeletons"), card.getDescription());
		assertEquals(mesEN.getString("rulesSkeletons"), card.getRules());
		
		//Check Spanish
		card = new Skeletons(spLocale);
		assertEquals(mesSP.getString("titleSkeletons"), card.getName());
		assertEquals(mesSP.getString("desSkeletons"), card.getDescription());
		assertEquals(mesSP.getString("rulesSkeletons"), card.getRules());
	}
	
	@Test
	public void testSkeletons5orGreater(){
		card = new Skeletons(enLocale);
		
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
		card = new Skeletons(enLocale);
		
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
		card = new TheVoice(enLocale);
		assertEquals(mesEN.getString("titleTheVoice"), card.getName());
		assertEquals(mesEN.getString("desTheVoice"), card.getDescription());
		assertEquals(mesEN.getString("rulesTheVoice"), card.getRules());
		
		//Check Spanish
		card = new TheVoice(spLocale);
		assertEquals(mesSP.getString("titleTheVoice"), card.getName());
		assertEquals(mesSP.getString("desTheVoice"), card.getDescription());
		assertEquals(mesSP.getString("rulesTheVoice"), card.getRules());
	}
	
	@Test
	public void testTheVoice4orGreater(){
		card = new TheVoice(enLocale);
		
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
		card = new SomethingHidden(enLocale);
		assertEquals(mesEN.getString("titleSomethingHidden"), card.getName());
		assertEquals(mesEN.getString("desSomethingHidden"), card.getDescription());
		assertEquals(mesEN.getString("rulesSomethingHidden"), card.getRules());
		
		//Check Spanish
		card = new SomethingHidden(spLocale);
		assertEquals(mesSP.getString("titleSomethingHidden"), card.getName());
		assertEquals(mesSP.getString("desSomethingHidden"), card.getDescription());
		assertEquals(mesSP.getString("rulesSomethingHidden"), card.getRules());
	}
	
	@Test
	public void testSomethingHidden4orGreater(){
		card = new SomethingHidden(enLocale);
		
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
		card = new SomethingHidden(enLocale);
		
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
		card = new HangedMen(enLocale);
		assertEquals(mesEN.getString("titleHangedMen"), card.getName());
		assertEquals(mesEN.getString("desHangedMen"), card.getDescription());
		assertEquals(mesEN.getString("rulesHangedMen"), card.getRules());
		
		//Check Spanish
		card = new HangedMen(spLocale);
		assertEquals(mesSP.getString("titleHangedMen"), card.getName());
		assertEquals(mesSP.getString("desHangedMen"), card.getDescription());
		assertEquals(mesSP.getString("rulesHangedMen"), card.getRules());
	}
	
	@Test
	public void testHangedMen2OrGreater(){
		card = new HangedMen(enLocale);
		
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
		card = new HangedMen(enLocale);
		
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
		card = new Debris(enLocale);
		assertEquals(mesEN.getString("titleDebris"), card.getName());
		assertEquals(mesEN.getString("desDebris"), card.getDescription());
		assertEquals(mesEN.getString("rulesDebris"), card.getRules());
		
		//Check Spanish
		card = new Debris(spLocale);
		assertEquals(mesSP.getString("titleDebris"), card.getName());
		assertEquals(mesSP.getString("desDebris"), card.getDescription());
		assertEquals(mesSP.getString("rulesDebris"), card.getRules());
	}
	
	@Test
	public void testDebris3OrGreater(){
		card = new Debris(enLocale);
		
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
		card = new Debris(enLocale);
		
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
		card = new Debris(enLocale);
		
		assertEquals(0, game.getCurrentCharacter().getEventHand().size());
		
		card.happen(0);
		
		assertEquals(1, game.getCurrentCharacter().getCurrentMight());
		assertEquals(1, game.getCurrentCharacter().getEventHand().size());

	}
	
	@Test
	public void testShriekingWindInit(){
		card = new ShriekingWind(enLocale);
		assertEquals(mesEN.getString("titleShriekingWind"), card.getName());
		assertEquals(mesEN.getString("desShriekingWind"), card.getDescription());
		assertEquals(mesEN.getString("rulesShriekingWind"), card.getRules());
		
		//Check Spanish
		card = new ShriekingWind(spLocale);
		assertEquals(mesSP.getString("titleShriekingWind"), card.getName());
		assertEquals(mesSP.getString("desShriekingWind"), card.getDescription());
		assertEquals(mesSP.getString("rulesShriekingWind"), card.getRules());
	}
	
	@Test
	public void testShriekingWind5orGreater(){
		card = new ShriekingWind(enLocale);
		
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
		card = new ShriekingWind(enLocale);
		
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
		card = new ShriekingWind(enLocale);
		
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
		card = new ShriekingWind(enLocale);
		
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
		card = new Silence(enLocale);
		assertEquals(mesEN.getString("titleSilence"), card.getName());
		assertEquals(mesEN.getString("desSilence"), card.getDescription());
		assertEquals(mesEN.getString("rulesSilence"), card.getRules());
		
		//Check Spanish
		card = new Silence(spLocale);
		assertEquals(mesSP.getString("titleSilence"), card.getName());
		assertEquals(mesSP.getString("desSilence"), card.getDescription());
		assertEquals(mesSP.getString("rulesSilence"), card.getRules());
	}
	
	@Test
	public void testSilence4orGreater(){
		card = new Silence(enLocale);
		
		assertEquals(4, game.getCurrentCharacter().getCurrentKnowledge());
		
		card.happen(4);
		
		assertEquals(4, game.getCurrentCharacter().getCurrentKnowledge());
		
		card.happen(5);
		
		assertEquals(4, game.getCurrentCharacter().getCurrentKnowledge());
		
	}
	
	@Test
	public void testSilence1To3(){
		card = new Silence(enLocale);
		
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
		card = new Silence(enLocale);
		
		game.getCurrentCharacter().incrementKnowledge();
		
		assertEquals(5, game.getCurrentCharacter().getCurrentKnowledge());
		
		card.happen(0);
		
		assertEquals(3, game.getCurrentCharacter().getCurrentKnowledge());
		
		card.happen(0);
		
		assertEquals(1, game.getCurrentCharacter().getCurrentKnowledge());
	}
	
	@Test
	public void testPhoneCallInit(){
		card = new PhoneCall(enLocale);
		assertEquals(mesEN.getString("titlePhoneCall"), card.getName());
		assertEquals(mesEN.getString("desPhoneCall"), card.getDescription());
		assertEquals(mesEN.getString("rulesPhoneCall"), card.getRules());
		
		//Check Spanish
		card = new PhoneCall(spLocale);
		assertEquals(mesSP.getString("titlePhoneCall"), card.getName());
		assertEquals(mesSP.getString("desPhoneCall"), card.getDescription());
		assertEquals(mesSP.getString("rulesPhoneCall"), card.getRules());
	}
	
	@Test
	public void testPhoneCall4(){
		card = new PhoneCall(enLocale);
		
		card.happen(4);
		
		assertEquals(7, game.getCurrentCharacter().getCurrentSanity());
		
		card.happen(4);
		
		assertEquals(7, game.getCurrentCharacter().getCurrentSanity());
		
	}
	
	@Test
	public void testPhoneCall3(){
		card = new PhoneCall(enLocale);
		
		card.happen(3);
		
		assertEquals(5, game.getCurrentCharacter().getCurrentKnowledge());
		
		card.happen(3);
		
		assertEquals(6, game.getCurrentCharacter().getCurrentKnowledge());
		
	}
	
	@Test
	public void testPhoneCall1or2(){
		card = new PhoneCall(enLocale);
		
		card.happen(1);
		
		assertEquals(3, game.getCurrentCharacter().getCurrentKnowledge());
		
		card.happen(2);
		
		assertEquals(3, game.getCurrentCharacter().getCurrentKnowledge());
		
		card.happen(2);
		
		assertEquals(1, game.getCurrentCharacter().getCurrentKnowledge());
		
	}
	
	@Test
	public void testPhoneCall0(){
		card = new PhoneCall(enLocale);
		
		card.happen(0);
		assertEquals(1, game.getCurrentCharacter().getCurrentMight());
		
	}
	
	@Test
	public void testSpiderInit(){
		card = new Spider(enLocale);
		assertEquals(mesEN.getString("titleSpider"), card.getName());
		assertEquals(mesEN.getString("desSpider"), card.getDescription());
		assertEquals(mesEN.getString("rulesSpider"), card.getRules());
		
		//Check Spanish
		card = new Spider(spLocale);
		assertEquals(mesSP.getString("titleSpider"), card.getName());
		assertEquals(mesSP.getString("desSpider"), card.getDescription());
		assertEquals(mesSP.getString("rulesSpider"), card.getRules());
	}
	
	@Test
	public void testSpider4OrGreater(){
		card = new Spider(enLocale);
		
		card.happen(4);
		assertEquals(4, game.getCurrentCharacter().getCurrentSpeed());
		
		card.happen(5);
		assertEquals(5, game.getCurrentCharacter().getCurrentSpeed());
	}
	
	@Test
	public void testSpider1To3(){
		card = new Spider(enLocale);
		
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
		card = new Spider(enLocale);
		
		card.happen(0);
		assertEquals(2, game.getCurrentCharacter().getCurrentSpeed());
	}
	
	@Test
	public void testHideousShriekInit(){
		card = new HideousShriek(enLocale);
		assertEquals(mesEN.getString("titleHideousShriek"), card.getName());
		assertEquals(mesEN.getString("desHideousShriek"), card.getDescription());
		assertEquals(mesEN.getString("rulesHideousShriek"), card.getRules());
		
		//Check Spanish
		card = new HideousShriek(spLocale);
		assertEquals(mesSP.getString("titleHideousShriek"), card.getName());
		assertEquals(mesSP.getString("desHideousShriek"), card.getDescription());
		assertEquals(mesSP.getString("rulesHideousShriek"), card.getRules());
	}
	
	@Test
	public void testHideousShriek4OrGreater(){
		card = new HideousShriek(enLocale);
		
		card.happen(4);
		assertEquals(character, game.getCurrentCharacter());
		
		card.happen(5);
		assertEquals(character, game.getCurrentCharacter());
	}
	
	@Test
	public void testHideousShriek1To3(){
		card = new HideousShriek(enLocale);
		
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
		card = new HideousShriek(enLocale);
		
		game.getCurrentCharacter().decrementSanity();
		assertEquals(5, game.getCurrentCharacter().getCurrentSanity());
		
		card.happen(0);
		assertEquals(4, game.getCurrentCharacter().getCurrentSanity());
	}
	
	@Test
	public void testPossessionInit(){
		card = new Possession(enLocale);
		assertEquals(mesEN.getString("titlePossession"), card.getName());
		assertEquals(mesEN.getString("desPossession"), card.getDescription());
		assertEquals(mesEN.getString("rulesPossession"), card.getRules());
		
		//Check Spanish
		card = new Possession(spLocale);
		assertEquals(mesSP.getString("titlePossession"), card.getName());
		assertEquals(mesSP.getString("desPossession"), card.getDescription());
		assertEquals(mesSP.getString("rulesPossession"), card.getRules());
	}
	
	@Test
	public void testPossession4OrGreater(){
		card = new Possession(enLocale);
		
		card.happen(4);
		assertEquals(5, game.getCurrentCharacter().getCurrentKnowledge());
		
		card.happen(5);
		assertEquals(6, game.getCurrentCharacter().getCurrentKnowledge());
	}
	
	@Test
	public void testPossession0To3(){
		card = new Possession(enLocale);
		
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
		assertEquals(3, game.getCurrentCharacter().getCurrentSanity());
		assertEquals(2, game.getCurrentCharacter().getCurrentMight());
		assertEquals(3, game.getCurrentCharacter().getCurrentSpeed());
		assertEquals(1, game.getCurrentCharacter().getCurrentKnowledge());
		
		card.happen(2);
		assertEquals(1, game.getCurrentCharacter().getCurrentMight());
		assertEquals(3, game.getCurrentCharacter().getCurrentSpeed());
		assertEquals(1, game.getCurrentCharacter().getCurrentKnowledge());
		assertEquals(3, game.getCurrentCharacter().getCurrentSanity());
		
		card.happen(3);
		assertEquals(3, game.getCurrentCharacter().getCurrentSanity());
		assertEquals(1, game.getCurrentCharacter().getCurrentMight());
		assertEquals(2, game.getCurrentCharacter().getCurrentSpeed());
		assertEquals(1, game.getCurrentCharacter().getCurrentKnowledge());
		
	}
	
	@Test
	public void testLockedSafeInit(){
		card = new LockedSafe(enLocale);
		assertEquals(mesEN.getString("titleLockedSafe"), card.getName());
		assertEquals(mesEN.getString("desLockedSafe"), card.getDescription());
		assertEquals(mesEN.getString("rulesLockedSafe"), card.getRules());
		
		//Check Spanish
		card = new LockedSafe(spLocale);
		assertEquals(mesSP.getString("titleLockedSafe"), card.getName());
		assertEquals(mesSP.getString("desLockedSafe"), card.getDescription());
		assertEquals(mesSP.getString("rulesLockedSafe"), card.getRules());
	}
	
	@Test
	public void testLockedSafe5OrGreater(){
		card = new LockedSafe(enLocale);
		
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
		card = new LockedSafe(enLocale);
		
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
		card = new LockedSafe(enLocale);
		
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
		card = new TheBeckoning(enLocale);
		assertEquals(mesEN.getString("titleTheBeckoning"), card.getName());
		assertEquals(mesEN.getString("desTheBeckoning"), card.getDescription());
		assertEquals(mesEN.getString("rulesTheBeckoning"), card.getRules());
		
		//Check Spanish
		card = new TheBeckoning(spLocale);
		assertEquals(mesSP.getString("titleTheBeckoning"), card.getName());
		assertEquals(mesSP.getString("desTheBeckoning"), card.getDescription());
		assertEquals(mesSP.getString("rulesTheBeckoning"), card.getRules());
	}

	@Test
	public void testTheBeckoning3OrGreater(){
		card = new TheBeckoning(enLocale);
		
		card.happen(3);
		assertEquals(character, game.getCurrentCharacter());
		
		card.happen(4);
		assertEquals(character, game.getCurrentCharacter());
		
	}

	@Test
	public void testTheBeckoning0To2Damage(){
		card = new TheBeckoning(enLocale);
		
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
		card = new Footsteps(enLocale);
		assertEquals(mesEN.getString("titleFootsteps"), card.getName());
		assertEquals(mesEN.getString("desFootsteps"), card.getDescription());
		assertEquals(mesEN.getString("rulesFootsteps"), card.getRules());
		
		//Check Spanish
		card = new Footsteps(spLocale);
		assertEquals(mesSP.getString("titleFootsteps"), card.getName());
		assertEquals(mesSP.getString("desFootsteps"), card.getDescription());
		assertEquals(mesSP.getString("rulesFootsteps"), card.getRules());
	}
	
	@Test 
	public void testFootsteps4(){
		card = new Footsteps(enLocale);
		
		card.happen(4);
		assertEquals(4, game.getCurrentCharacter().getCurrentMight());
	}
	
	@Test 
	public void testFootsteps3(){
		card = new Footsteps(enLocale);
		
		card.happen(3);
		assertEquals(4, game.getCurrentCharacter().getCurrentMight());
	}
	
	@Test 
	public void testFootsteps2(){
		card = new Footsteps(enLocale);
		
		card.happen(2);
		assertEquals(5, game.getCurrentCharacter().getCurrentSanity());
	}
	
	@Test 
	public void testFootsteps1(){
		card = new Footsteps(enLocale);
		
		game.getCurrentCharacter().incrementSpeed();
		assertEquals(4, game.getCurrentCharacter().getCurrentSpeed());
		
		card.happen(1);
		assertEquals(3, game.getCurrentCharacter().getCurrentSpeed());
	}
	
	@Test 
	public void testFootsteps0(){
		card = new Footsteps(enLocale);
		
		card.happen(0);
		assertEquals(5, game.getCurrentCharacter().getCurrentSanity());
	}
	
	@Test
	public void testMistsFromTheWallsInit(){
		card = new MistsFromTheWalls(enLocale);
		assertEquals(mesEN.getString("titleMistsFromTheWalls"), card.getName());
		assertEquals(mesEN.getString("desMistsFromTheWalls"), card.getDescription());
		assertEquals(mesEN.getString("rulesMistsFromTheWalls"), card.getRules());
		
		//Check Spanish
		card = new MistsFromTheWalls(spLocale);
		assertEquals(mesSP.getString("titleMistsFromTheWalls"), card.getName());
		assertEquals(mesSP.getString("desMistsFromTheWalls"), card.getDescription());
		assertEquals(mesSP.getString("rulesMistsFromTheWalls"), card.getRules());
	}
	
	@Test
	public void testMistsFromTheWalls4OrGreater(){
		card = new MistsFromTheWalls(enLocale);
		
		card.happen(4);
		assertEquals(character, game.getCurrentCharacter());
		
		card.happen(5);
		assertEquals(character, game.getCurrentCharacter());
	}
	
	@Test
	public void testMistsFromTheWalls1To3(){
		card = new MistsFromTheWalls(enLocale);
		
		card.happen(1);
		assertEquals(5, game.getCurrentCharacter().getCurrentSanity());
		
		card.happen(2);
		assertEquals(5, game.getCurrentCharacter().getCurrentSanity());
		
		card.happen(3);
		assertEquals(4, game.getCurrentCharacter().getCurrentSanity());
	}
	
	@Test
	public void testMistsFromTheWalls0(){
		card = new MistsFromTheWalls(enLocale);
		
		card.happen(0);
		assertEquals(5, game.getCurrentCharacter().getCurrentSanity());
	}
	
	@Test
	public void testBloodyVisionInit(){
		card = new BloodyVision(enLocale);
		assertEquals(mesEN.getString("titleBloodyVision"), card.getName());
		assertEquals(mesEN.getString("desBloodyVision"), card.getDescription());
		assertEquals(mesEN.getString("rulesBloodyVision"), card.getRules());
		
		//Check Spanish
		card = new BloodyVision(spLocale);
		assertEquals(mesSP.getString("titleBloodyVision"), card.getName());
		assertEquals(mesSP.getString("desBloodyVision"), card.getDescription());
		assertEquals(mesSP.getString("rulesBloodyVision"), card.getRules());
	}
	
	@Test
	public void testBloddyVision4OrGreater(){
		card = new BloodyVision(enLocale);
		
		card.happen(4);
		assertEquals(7, game.getCurrentCharacter().getCurrentSanity());
		
		card.happen(5);
		assertEquals(7, game.getCurrentCharacter().getCurrentSanity());
		
	}
	
	@Test
	public void testBloddyVision2Or3(){
		card = new BloodyVision(enLocale);
		
		card.happen(2);
		assertEquals(5, game.getCurrentCharacter().getCurrentSanity());
		
		card.happen(3);
		assertEquals(5, game.getCurrentCharacter().getCurrentSanity());
		
	}
	
	@Test
	public void testBloodyVision1Or0(){
		card = new BloodyVision(enLocale);
		// For now do nothing because the need methods that are not yet implemented for attack
		
	}
	
	@Test
	public void testTheLostOneInit(){
		card = new TheLostOne(enLocale);
		assertEquals(mesEN.getString("titleTheLostOne"), card.getName());
		assertEquals(mesEN.getString("desTheLostOne"), card.getDescription());
		assertEquals(mesEN.getString("rulesTheLostOne"), card.getRules());
		
		//Check Spanish
		card = new TheLostOne(spLocale);
		assertEquals(mesSP.getString("titleTheLostOne"), card.getName());
		assertEquals(mesSP.getString("desTheLostOne"), card.getDescription());
		assertEquals(mesSP.getString("rulesTheLostOne"), card.getRules());
	}// Only test for now. Don't have methods to develop further yet
	
	@Test
	public void testBurningManInit(){
		card = new BurningMan(enLocale);
		assertEquals(mesEN.getString("titleBurningMan"), card.getName());
		assertEquals(mesEN.getString("desBurningMan"), card.getDescription());
		assertEquals(mesEN.getString("rulesBurningMan"), card.getRules());
		
		//Check Spanish
		card = new BurningMan(spLocale);
		assertEquals(mesSP.getString("titleBurningMan"), card.getName());
		assertEquals(mesSP.getString("desBurningMan"), card.getDescription());
		assertEquals(mesSP.getString("rulesBurningMan"), card.getRules());
	}
	
	@Test
	public void testBurningMan4OrGreater(){
		card = new BurningMan(enLocale);
		
		card.happen(4);
		assertEquals(7, game.getCurrentCharacter().getCurrentSanity());
		
		card.happen(5);
		assertEquals(7, game.getCurrentCharacter().getCurrentSanity());
	}
	
	@Test
	public void testBurningMan2Or3(){
		card = new BurningMan(enLocale);
		// Needs to test that location is in the EntranceHall but this doesn't exist yet
	}

	@Test
	public void testBurningMan1Or0(){
		card = new BurningMan(enLocale);
		
		card.happen(1);
		assertEquals(5, game.getCurrentCharacter().getCurrentSanity());
		assertEquals(2, game.getCurrentCharacter().getCurrentMight());
		
		card.happen(0);
		assertEquals(5, game.getCurrentCharacter().getCurrentSanity());
		assertEquals(1, game.getCurrentCharacter().getCurrentMight());
	}
	
	@Test
	public void testClosetDoorInit(){
		card = new ClosetDoor(enLocale);
		assertEquals(mesEN.getString("titleClosetDoor"), card.getName());
		assertEquals(mesEN.getString("desClosetDoor"), card.getDescription());
		assertEquals(mesEN.getString("rulesClosetDoor"), card.getRules());
		
		//Check Spanish
		card = new ClosetDoor(spLocale);
		assertEquals(mesSP.getString("titleClosetDoor"), card.getName());
		assertEquals(mesSP.getString("desClosetDoor"), card.getDescription());
		assertEquals(mesSP.getString("rulesClosetDoor"), card.getRules());
	}
	
	@Test
	public void testClosetDoor4(){
		card = new ClosetDoor(enLocale);
		
		assertEquals(0, game.getCurrentCharacter().getItemHand().size());
		
		card.happen(4);
		assertEquals(1, game.getCurrentCharacter().getItemHand().size());
		assertEquals(angelFeather, game.getCurrentCharacter().getItemHand().get(0));
	}
	
	@Test
	public void testClosetDoor2Or3(){
		card = new ClosetDoor(enLocale);
		
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
		card = new ClosetDoor(enLocale);
		
		assertEquals(0, game.getCurrentCharacter().getEventHand().size());
		
		card.happen(0);
		assertEquals(1, game.getCurrentCharacter().getEventHand().size());
		assertEquals(angryBeing, game.getCurrentCharacter().getEventHand().get(0));
		
		card.happen(1);
		assertEquals(2, game.getCurrentCharacter().getEventHand().size());
		assertEquals(creepyCrawlies, game.getCurrentCharacter().getEventHand().get(1));
	}
	
	
}
