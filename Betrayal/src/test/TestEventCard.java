package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import itemCards.AdrenalineShot;
import itemCards.AngelFeather;
import itemCards.ItemCard;
import itemCards.PuzzleBox;
import itemCards.Revolver;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

import junit.framework.Assert;

import omenCards.Bite;
import omenCards.Book;
import omenCards.CrystalBall;
import omenCards.OmenCard;
import omenCards.Ring;
import omenCards.Spear;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Before;
import org.junit.Test;

import rooms.Room;
import rooms.RoomFactory;
import rooms.RoomName;
import Game.Game;
import Game.Player;
import characters.Character;
import characters.HumanStats;
import characters.Character.Character_Name;
import characters.ExplorerFactory;
import eventCards.AMomentOfHope;
import eventCards.AngryBeing;
import eventCards.BloodyVision;
import eventCards.BurningMan;
import eventCards.ClosetDoor;
import eventCards.CreepyCrawlies;
import eventCards.CreepyPuppet;
import eventCards.Debris;
import eventCards.DisquietingSounds;
import eventCards.Drip;
import eventCards.EventCard;
import eventCards.Footsteps;
import eventCards.Funeral;
import eventCards.GraveDirt;
import eventCards.Groundskeeper;
import eventCards.HangedMen;
import eventCards.HideousShriek;
import eventCards.ItIsMeantToBe;
import eventCards.JonahsTurn;
import eventCards.LightsOut;
import eventCards.LockedSafe;
import eventCards.Mirror;
import eventCards.Mirror2;
import eventCards.MistsFromTheWalls;
import eventCards.MysticSlide;
import eventCards.NightView;
import eventCards.PhoneCall;
import eventCards.Possession;
import eventCards.RevolvingWall;
import eventCards.Rotten;
import eventCards.SecretPassage;
import eventCards.SecretStairs;
import eventCards.ShriekingWind;
import eventCards.Silence;
import eventCards.Skeletons;
import eventCards.Smoke;
import eventCards.SomethingHidden;
import eventCards.SomethingSlimy;
import eventCards.Spider;
import eventCards.TheBeckoning;
import eventCards.TheLostOne;
import eventCards.TheVoice;
import eventCards.TheWalls;
import eventCards.Webs;
import eventCards.WhatThe;
import eventCards.Whoops;

public class TestEventCard {

	private EventCard card;
	private Game game;
	private RoomFactory roomFact = new RoomFactory();
	
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
	private ItemCard angelFeather = new AngelFeather(enLocale);
	private ItemCard adrenalineShotCard = new AdrenalineShot(enLocale);
	private ItemCard revolverCard = new Revolver(enLocale);	
	private ItemCard puzzleBoxCard = new PuzzleBox(enLocale);
	private OmenCard crystalBall = new CrystalBall(enLocale);
	private OmenCard book = new Book(enLocale);
	private OmenCard ring = new Ring(enLocale);
	private Player player = new Player();
	private ArrayList<EventCard> events = new ArrayList<EventCard>();
	private ArrayList<ItemCard> items = new ArrayList<ItemCard>();
	private ArrayList<OmenCard> omens = new ArrayList<OmenCard>();
	private ArrayList<Player> players = new ArrayList<Player>();
	private ArrayList<Room> rooms = new ArrayList<Room>();
	
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
		
		rooms.add(roomFact.makeRoom(RoomName.TOWER));
		rooms.add(roomFact.makeRoom(RoomName.BALCONY));
		rooms.add(roomFact.makeRoom(RoomName.BEDROOM));
		rooms.add(roomFact.makeRoom(RoomName.GARDENS));
		rooms.add(roomFact.makeRoom(RoomName.PATIO));
		rooms.add(roomFact.makeRoom(RoomName.GRAVEYARD));
		rooms.add(roomFact.makeRoom(RoomName.DININGROOM));
		rooms.add(roomFact.makeRoom(RoomName.WINECELLAR));
		rooms.add(roomFact.makeRoom(RoomName.UNDERGROUNDLAKE));
		
		Game.resetGame();
		game = Game.getInstance();
		game.addAllToEventDeck(events);
		game.addAllToItemDeck(items);
		game.addAllToOmenDeck(omens);
		game.addPlayer(player);
		game.addAllToRoomDeck(rooms);
		game.addCharacter(character);
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
		Mockery mocks = new Mockery() {
			{
				setImposteriser(ClassImposteriser.INSTANCE);
			}
		};
		
		card = new Rotten(enLocale);
		
		final Game mockGame = mocks.mock(Game.class);
		try {
			Field instanceField = Game.class.getDeclaredField("INSTANCE");
			instanceField.setAccessible(true);
			instanceField.set(null, mockGame);

			mocks.checking(new Expectations() {
				{
					oneOf(mockGame).rollDice(6);
					will(returnValue(5));
					oneOf(mockGame).rollDice(7);
					will(returnValue(6));
				}
			});

			assertEquals(character, mockGame.getCurrentCharacter());
			card.happens();
			assertEquals(7, mockGame.getCurrentCharacter().getCurrentSanity());
			card.happens();	
			assertEquals(7, mockGame.getCurrentCharacter().getCurrentSanity());

			mocks.assertIsSatisfied();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
		
//		card = new Rotten(enLocale);
//		// Test to be removed
//		assertEquals(character, game.getCurrentCharacter());
//		card.happen(5);
//		assertEquals(7, game.getCurrentCharacter().getCurrentSanity());
//		card.happen(6);	
//		assertEquals(7, game.getCurrentCharacter().getCurrentSanity());
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
		// TODO: For now do nothing because the need methods that are not yet implemented for attack
		
	}
	
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
		
		card.happen(2);
		
		
		// TODO: Needs to test that location is in the EntranceHall but this doesn't exist yet
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
	}
	
	@Test
	public void testTheLostOne6(){
		card = new TheLostOne(enLocale);
		
		card.happen(6);
		assertEquals(roomFact.makeRoom(RoomName.ENTRANCEHALL), game.getCurrentCharacter().getCurrentRoom());
	}
	
	@Test
	public void testTheLostOne4or5(){
		card = new TheLostOne(enLocale);
		
		card.happen(5);
		assertEquals(roomFact.makeRoom(RoomName.UPPERLANDING), game.getCurrentCharacter().getCurrentRoom());
		
		game.getCurrentCharacter().setCurrentRoom(roomFact.makeRoom(RoomName.ENTRANCEHALL));
		assertEquals(roomFact.makeRoom(RoomName.ENTRANCEHALL), game.getCurrentCharacter().getCurrentRoom());
		
		card.happen(4);
		assertEquals(roomFact.makeRoom(RoomName.UPPERLANDING), game.getCurrentCharacter().getCurrentRoom());
		
	}
	
	@Test
	public void testTheLostOne2or3(){
		card = new TheLostOne(enLocale);
		
		card.happen(2);
		assertEquals(roomFact.makeRoom(RoomName.TOWER), game.getCurrentCharacter().getCurrentRoom());
		
		game.getCurrentCharacter().setCurrentRoom(roomFact.makeRoom(RoomName.ENTRANCEHALL));
		assertEquals(roomFact.makeRoom(RoomName.ENTRANCEHALL), game.getCurrentCharacter().getCurrentRoom());
		
		card.happen(3);
		assertEquals(roomFact.makeRoom(RoomName.BALCONY), game.getCurrentCharacter().getCurrentRoom());
	}
	
	@Test
	public void testTheLostOne0or1(){
		card = new TheLostOne(enLocale);
		
		card.happen(0);
		assertEquals(roomFact.makeRoom(RoomName.TOWER), game.getCurrentCharacter().getCurrentRoom());
		
		game.getCurrentCharacter().setCurrentRoom(roomFact.makeRoom(RoomName.ENTRANCEHALL));
		assertEquals(roomFact.makeRoom(RoomName.ENTRANCEHALL), game.getCurrentCharacter().getCurrentRoom());
		
		card.happen(1);
		assertEquals(roomFact.makeRoom(RoomName.BALCONY), game.getCurrentCharacter().getCurrentRoom());
	}
	
	@Test
	public void testTheWallsInit(){
		card = new TheWalls(enLocale);
		assertEquals(mesEN.getString("titleTheWalls"), card.getName());
		assertEquals(mesEN.getString("desTheWalls"), card.getDescription());
		assertEquals(mesEN.getString("rulesTheWalls"), card.getRules());
		
		//Check Spanish
		card = new TheWalls(spLocale);
		assertEquals(mesSP.getString("titleTheWalls"), card.getName());
		assertEquals(mesSP.getString("desTheWalls"), card.getDescription());
		assertEquals(mesSP.getString("rulesTheWalls"), card.getRules());
	}
	
	@Test
	public void testTheWallsHappen(){
		card = new TheWalls(enLocale);
		
		card.happens();
		assertEquals(roomFact.makeRoom(RoomName.TOWER), game.getCurrentCharacter().getCurrentRoom());
	}
	
	@Test
	public void testJonahsTurnInit(){
		card = new JonahsTurn(enLocale);
		assertEquals(mesEN.getString("titleJonahsTurn"), card.getName());
		assertEquals(mesEN.getString("desJonahsTurn"), card.getDescription());
		assertEquals(mesEN.getString("rulesJonahsTurn"), card.getRules());
		
		//Check Spanish
		card = new JonahsTurn(spLocale);
		assertEquals(mesSP.getString("titleJonahsTurn"), card.getName());
		assertEquals(mesSP.getString("desJonahsTurn"), card.getDescription());
		assertEquals(mesSP.getString("rulesJonahsTurn"), card.getRules());
	}
	
	@Test
	public void testJonahsTurnHasPuzzleBox(){
		card = new JonahsTurn(enLocale);
		System.out.print(game.getCharacters());
		Character ex1 = game.getCharacters().get(1);
		assertEquals(0, ex1.getItemHand().size());
		
		PuzzleBox pb = new PuzzleBox(enLocale);
		
		ex1.addItemCard(pb);
		assertEquals(1, ex1.getItemHand().size());
		assertEquals(pb, ex1.getItemHand().get(0));
		
		card.happens();
		assertEquals(1, ex1.getItemHand().size());
		assertEquals(angelFeather, ex1.getItemHand().get(0));
		
		assertEquals(7, game.getCurrentCharacter().getCurrentSanity());
	}
	
	@Test
	public void testJonahsTurnNoPuzzleBox(){
		card = new JonahsTurn(enLocale);
		
		card.happens();
		
		assertTrue(0 <= game.getCurrentCharacter().getCurrentSanity() && game.getCurrentCharacter().getCurrentSanity() <= 6);
	}
	
	@Test
	public void testWhatTheInit(){
		card = new WhatThe(enLocale);
		assertEquals(mesEN.getString("titleWhatThe"), card.getName());
		assertEquals(mesEN.getString("desWhatThe"), card.getDescription());
		assertEquals(mesEN.getString("rulesWhatThe"), card.getRules());
		
		//Check Spanish
		card = new WhatThe(spLocale);
		assertEquals(mesSP.getString("titleWhatThe"), card.getName());
		assertEquals(mesSP.getString("desWhatThe"), card.getDescription());
		assertEquals(mesSP.getString("rulesWhatThe"), card.getRules());
	}
	
	@Test
	public void testWhoopsInit(){
		card = new Whoops(enLocale);
		assertEquals(mesEN.getString("titleWhoops"), card.getName());
		assertEquals(mesEN.getString("desWhoops"), card.getDescription());
		assertEquals(mesEN.getString("rulesWhoops"), card.getRules());
		
		//Check Spanish
		card = new Whoops(spLocale);
		assertEquals(mesSP.getString("titleWhoops"), card.getName());
		assertEquals(mesSP.getString("desWhoops"), card.getDescription());
		assertEquals(mesSP.getString("rulesWhoops"), card.getRules());
	}
	
	@Test
	public void testMirrorInit(){
		card = new Mirror(enLocale);
		assertEquals(mesEN.getString("titleMirror"), card.getName());
		assertEquals(mesEN.getString("desMirror"), card.getDescription());
		assertEquals(mesEN.getString("rulesMirror"), card.getRules());
		
		//Check Spanish
		card = new Mirror(spLocale);
		assertEquals(mesSP.getString("titleMirror"), card.getName());
		assertEquals(mesSP.getString("desMirror"), card.getDescription());
		assertEquals(mesSP.getString("rulesMirror"), card.getRules());
	}
	
	@Test
	public void testMirrorHappen(){
		card = new Mirror(enLocale);
		
		assertEquals(0, game.getCurrentCharacter().getItemHand().size());
		
		PuzzleBox pb = new PuzzleBox(enLocale);
		game.getCurrentCharacter().addItemCard(pb);
		assertEquals(1, game.getCurrentCharacter().getItemHand().size());
		assertEquals(pb, game.getCurrentCharacter().getItemHand().get(0));
		
		card.happens();
		assertEquals(0, game.getCurrentCharacter().getItemHand().size());
		
		assertEquals(5, game.getCurrentCharacter().getCurrentKnowledge());
	}
	
	@Test
	public void testDisquietingSoundsInit(){
		card = new DisquietingSounds(enLocale);
		assertEquals(mesEN.getString("titleDisquietingSounds"), card.getName());
		assertEquals(mesEN.getString("desDisquietingSounds"), card.getDescription());
		assertEquals(mesEN.getString("rulesDisquietingSounds"), card.getRules());
		
		//Check Spanish
		card = new DisquietingSounds(spLocale);
		assertEquals(mesSP.getString("titleDisquietingSounds"), card.getName());
		assertEquals(mesSP.getString("desDisquietingSounds"), card.getDescription());
		assertEquals(mesSP.getString("rulesDisquietingSounds"), card.getRules());
	}
	
	@Test
	public void testDisquietingSoundsMoreThanOmens(){
		card = new DisquietingSounds(enLocale);
		
		assertEquals(0, game.numOmensOut());
		
		card.happens();
		
		assertEquals(7, game.getCurrentCharacter().getCurrentSanity());
		
	}
	
	@Test
	public void testDisquietingSoundsLessThanOmens(){
		card = new DisquietingSounds(enLocale);
		
		assertEquals(0, game.numOmensOut());
		
		game.addToOmenDeck(new Bite(enLocale));
		game.addToOmenDeck(new Bite(enLocale));
		game.addToOmenDeck(new Bite(enLocale));
		game.addToOmenDeck(new Bite(enLocale));
		game.addToOmenDeck(new Bite(enLocale));
		game.addToOmenDeck(new Bite(enLocale));
		game.addToOmenDeck(new Bite(enLocale));
		game.addToOmenDeck(new Bite(enLocale));
		game.addToOmenDeck(new Bite(enLocale));
		game.addToOmenDeck(new Bite(enLocale));
		game.addToOmenDeck(new Bite(enLocale));
		game.addToOmenDeck(new Bite(enLocale));
		game.addToOmenDeck(new Bite(enLocale));
		game.addToOmenDeck(new Bite(enLocale));
		
		int i = 0;
		while(i < 14){
			game.drawOmen();
			i++;
		}
		
		assertEquals(14, game.numOmensOut());
		
		card.happens();
		
		assertTrue(0 <= game.getCurrentCharacter().getCurrentSanity() && game.getCurrentCharacter().getCurrentSanity() <= 6);
	}
	
	@Test
	public void testCreepyPuppetInit(){
		card = new CreepyPuppet(enLocale);
		assertEquals(mesEN.getString("titleCreepyPuppet"), card.getName());
		assertEquals(mesEN.getString("desCreepyPuppet"), card.getDescription());
		assertEquals(mesEN.getString("rulesCreepyPuppet"), card.getRules());
		
		//Check Spanish
		card = new CreepyPuppet(spLocale);
		assertEquals(mesSP.getString("titleCreepyPuppet"), card.getName());
		assertEquals(mesSP.getString("desCreepyPuppet"), card.getDescription());
		assertEquals(mesSP.getString("rulesCreepyPuppet"), card.getRules());
	}
	
	@Test
	public void testCreepyPuppetSpear(){
		card = new CreepyPuppet(enLocale);
		
		Character ex1 = game.getCharacters().get(1);
		assertEquals(0, ex1.getOmenHand().size());
		
		Spear sp = new Spear(enLocale);
		ex1.addOmenCard(sp);
		assertEquals(1, ex1.getOmenHand().size());
		assertEquals(sp, ex1.getOmenHand().get(0));
		assertEquals(2, ex1.getCurrentMight());
		
		game.getCurrentCharacter().decrementMight(2);
		
		card.happens();
		
		assertEquals(4, ex1.getCurrentMight());
		
		assertTrue(0 <= game.getCurrentCharacter().getCurrentMight() && game.getCurrentCharacter().getCurrentMight() <= 2);
		
	}
	
	@Test
	public void testCreepyPuppetCurrentCharacterHasSpear(){
		card = new CreepyPuppet(enLocale);
		
		Character ex1 = game.getCurrentCharacter();
		assertEquals(0, ex1.getItemHand().size());
		
		Spear sp = new Spear(enLocale);
		ex1.addOmenCard(sp);
		assertEquals(1, ex1.getOmenHand().size());
		assertEquals(sp, ex1.getOmenHand().get(0));
		assertEquals(2, ex1.getCurrentMight());
		
		card.happens();
		
		assertTrue(0 <= game.getCurrentCharacter().getCurrentMight() && game.getCurrentCharacter().getCurrentMight() <= 2);
		
	}
	
	@Test
	public void testCreepyPuppetCurrentNoSpearDamaged(){
		card = new CreepyPuppet(enLocale);
		
		
		assertEquals(2, game.getCurrentCharacter().getCurrentMight());
		game.getCurrentCharacter().decrementMight(2);
		assertEquals(1, game.getCurrentCharacter().getCurrentMight());
		
		card.happens();
		
		assertTrue(0 <= game.getCurrentCharacter().getCurrentMight() && game.getCurrentCharacter().getCurrentMight() <= 2);
		
	}
	
	@Test
	public void testCreepyPuppetCurrentNoDamaged(){
		card = new CreepyPuppet(enLocale);
		
		
		assertEquals(2, game.getCurrentCharacter().getCurrentMight());
		game.getCurrentCharacter().incrementMight(6);
		assertEquals(7, game.getCurrentCharacter().getCurrentMight());
		
		card.happens();
		
		assertEquals(7, game.getCurrentCharacter().getCurrentMight());
		
	}
	
	@Test
	public void testGroundskeeperInit(){
		card = new Groundskeeper(enLocale);
		assertEquals(mesEN.getString("titleGroundskeeper"), card.getName());
		assertEquals(mesEN.getString("desGroundskeeper"), card.getDescription());
		assertEquals(mesEN.getString("rulesGroundskeeper"), card.getRules());
		
		//Check Spanish
		card = new Groundskeeper(spLocale);
		assertEquals(mesSP.getString("titleGroundskeeper"), card.getName());
		assertEquals(mesSP.getString("desGroundskeeper"), card.getDescription());
		assertEquals(mesSP.getString("rulesGroundskeeper"), card.getRules());
	}
	
	@Test
	public void testGroundskeeper4orGreater(){
		card = new Groundskeeper(enLocale);
		
		assertEquals(0, game.getCurrentCharacter().getItemHand().size());
		
		card.happen(4);
		
		assertEquals(1, game.getCurrentCharacter().getItemHand().size());
		
		card.happen(5);
		
		assertEquals(1, game.getCurrentCharacter().getItemHand().size());
		
	}
	
	@Test
	public void testGroundskeeper0to3(){
		card = new Groundskeeper(enLocale);
		
		card.happen(0);
		
		assertTrue(0 <= game.getCurrentCharacter().getCurrentMight() && game.getCurrentCharacter().getCurrentMight() <= 2);
		
		card.happen(1);
		
		assertTrue(0 <= game.getCurrentCharacter().getCurrentMight() && game.getCurrentCharacter().getCurrentMight() <= 2);
		
		card.happen(2);
		
		assertTrue(0 <= game.getCurrentCharacter().getCurrentMight() && game.getCurrentCharacter().getCurrentMight() <= 2);
		
		card.happen(3);
		
		assertTrue(0 <= game.getCurrentCharacter().getCurrentMight() && game.getCurrentCharacter().getCurrentMight() <= 2);

	}
	
	@Test
	public void testWebsInit(){
		card = new Webs(enLocale);
		assertEquals(mesEN.getString("titleWebs"), card.getName());
		assertEquals(mesEN.getString("desWebs"), card.getDescription());
		assertEquals(mesEN.getString("rulesWebs"), card.getRules());
		
		//Check Spanish
		card = new Webs(spLocale);
		assertEquals(mesSP.getString("titleWebs"), card.getName());
		assertEquals(mesSP.getString("desWebs"), card.getDescription());
		assertEquals(mesSP.getString("rulesWebs"), card.getRules());
	}
	
	@Test
	public void testGraveDirtInit(){
		card = new GraveDirt(enLocale);
		assertEquals(mesEN.getString("titleGraveDirt"), card.getName());
		assertEquals(mesEN.getString("desGraveDirt"), card.getDescription());
		assertEquals(mesEN.getString("rulesGraveDirt"), card.getRules());
		
		//Check Spanish
		card = new GraveDirt(spLocale);
		assertEquals(mesSP.getString("titleGraveDirt"), card.getName());
		assertEquals(mesSP.getString("desGraveDirt"), card.getDescription());
		assertEquals(mesSP.getString("rulesGraveDirt"), card.getRules());
	}
	
	@Test
	public void testLightsOutInit(){
		card = new LightsOut(enLocale);
		assertEquals(mesEN.getString("titleLightsOut"), card.getName());
		assertEquals(mesEN.getString("desLightsOut"), card.getDescription());
		assertEquals(mesEN.getString("rulesLightsOut"), card.getRules());
		
		//Check Spanish
		card = new LightsOut(spLocale);
		assertEquals(mesSP.getString("titleLightsOut"), card.getName());
		assertEquals(mesSP.getString("desLightsOut"), card.getDescription());
		assertEquals(mesSP.getString("rulesLightsOut"), card.getRules());
	}
	
	@Test
	public void testSecretPassageInit(){
		card = new SecretPassage(enLocale);
		assertEquals(mesEN.getString("titleSecretPassage"), card.getName());
		assertEquals(mesEN.getString("desSecretPassage"), card.getDescription());
		assertEquals(mesEN.getString("rulesSecretPassage"), card.getRules());
		
		//Check Spanish
		card = new SecretPassage(spLocale);
		assertEquals(mesSP.getString("titleSecretPassage"), card.getName());
		assertEquals(mesSP.getString("desSecretPassage"), card.getDescription());
		assertEquals(mesSP.getString("rulesSecretPassage"), card.getRules());
	}
	
	@Test
	public void testRevolvingWallInit(){
		card = new RevolvingWall(enLocale);
		assertEquals(mesEN.getString("titleRevolvingWall"), card.getName());
		assertEquals(mesEN.getString("desRevolvingWall"), card.getDescription());
		assertEquals(mesEN.getString("rulesRevolvingWall"), card.getRules());
		
		//Check Spanish
		card = new RevolvingWall(spLocale);
		assertEquals(mesSP.getString("titleRevolvingWall"), card.getName());
		assertEquals(mesSP.getString("desRevolvingWall"), card.getDescription());
		assertEquals(mesSP.getString("rulesRevolvingWall"), card.getRules());
	}
	
	@Test
	public void testMysticSlideInit(){
		card = new MysticSlide(enLocale);
		assertEquals(mesEN.getString("titleMysticSlide"), card.getName());
		assertEquals(mesEN.getString("desMysticSlide"), card.getDescription());
		assertEquals(mesEN.getString("rulesMysticSlide"), card.getRules());
		
		//Check Spanish
		card = new MysticSlide(spLocale);
		assertEquals(mesSP.getString("titleMysticSlide"), card.getName());
		assertEquals(mesSP.getString("desMysticSlide"), card.getDescription());
		assertEquals(mesSP.getString("rulesMysticSlide"), card.getRules());
	}
	
	@Test
	public void testAMomentOfHopeInit(){
		card = new AMomentOfHope(enLocale);
		assertEquals(mesEN.getString("titleAMomentOfHope"), card.getName());
		assertEquals(mesEN.getString("desAMomentOfHope"), card.getDescription());
		assertEquals(mesEN.getString("rulesAMomentOfHope"), card.getRules());
		
		//Check Spanish
		card = new AMomentOfHope(spLocale);
		assertEquals(mesSP.getString("titleAMomentOfHope"), card.getName());
		assertEquals(mesSP.getString("desAMomentOfHope"), card.getDescription());
		assertEquals(mesSP.getString("rulesAMomentOfHope"), card.getRules());
	}
	
	@Test
	public void testDripInit(){
		card = new Drip(enLocale);
		assertEquals(mesEN.getString("titleDrip"), card.getName());
		assertEquals(mesEN.getString("desDrip"), card.getDescription());
		assertEquals(mesEN.getString("rulesDrip"), card.getRules());
		
		//Check Spanish
		card = new Drip(spLocale);
		assertEquals(mesSP.getString("titleDrip"), card.getName());
		assertEquals(mesSP.getString("desDrip"), card.getDescription());
		assertEquals(mesSP.getString("rulesDrip"), card.getRules());
	}
	
	@Test
	public void testSmokeInit(){
		card = new Smoke(enLocale);
		assertEquals(mesEN.getString("titleSmoke"), card.getName());
		assertEquals(mesEN.getString("desSmoke"), card.getDescription());
		assertEquals(mesEN.getString("rulesSmoke"), card.getRules());
		
		//Check Spanish
		card = new Smoke(spLocale);
		assertEquals(mesSP.getString("titleSmoke"), card.getName());
		assertEquals(mesSP.getString("desSmoke"), card.getDescription());
		assertEquals(mesSP.getString("rulesSmoke"), card.getRules());
	}
	
	@Test
	public void testSecretStairsInit(){
		card = new SecretStairs(enLocale);
		assertEquals(mesEN.getString("titleSecretStairs"), card.getName());
		assertEquals(mesEN.getString("desSecretStairs"), card.getDescription());
		assertEquals(mesEN.getString("rulesSecretStairs"), card.getRules());
		
		//Check Spanish
		card = new SecretStairs(spLocale);
		assertEquals(mesSP.getString("titleSecretStairs"), card.getName());
		assertEquals(mesSP.getString("desSecretStairs"), card.getDescription());
		assertEquals(mesSP.getString("rulesSecretStairs"), card.getRules());
	}
	
	@Test
	public void testItIsMeantToBeInit(){
		card = new ItIsMeantToBe(enLocale);
		assertEquals(mesEN.getString("titleItIsMeantToBe"), card.getName());
		assertEquals(mesEN.getString("desItIsMeantToBe"), card.getDescription());
		assertEquals(mesEN.getString("rulesItIsMeantToBe"), card.getRules());
		
		//Check Spanish
		card = new ItIsMeantToBe(spLocale);
		assertEquals(mesSP.getString("titleItIsMeantToBe"), card.getName());
		assertEquals(mesSP.getString("desItIsMeantToBe"), card.getDescription());
		assertEquals(mesSP.getString("rulesItIsMeantToBe"), card.getRules());
	}
	
	
}
