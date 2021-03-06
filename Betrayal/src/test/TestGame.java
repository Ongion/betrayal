package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import itemCards.AngelFeather;
import itemCards.ItemCard;

import java.util.ArrayList;
import java.util.Locale;

import omenCards.Book;
import omenCards.CrystalBall;
import omenCards.OmenCard;
import omenCards.Ring;

import org.junit.Before;
import org.junit.Test;

import rooms.Room;
import rooms.RoomFactory;
import rooms.RoomName;
import Game.Game;
import Game.Player;
import characters.Character;
import characters.Character.Character_Name;
import characters.ExplorerFactory;
import characters.Trait;
import eventCards.AngryBeing;
import eventCards.CreepyCrawlies;
import eventCards.EventCard;
import eventCards.NightView;
import eventCards.Rotten;

public class TestGame {

	private Game game;
	private ExplorerFactory explorers = new ExplorerFactory();
	private Locale enLocale = new Locale("en", "US");
	private Character character;
	private Character character2;
	private EventCard angryBeing = new AngryBeing(enLocale);
	private EventCard creepyCrawlies = new CreepyCrawlies(enLocale);
	private EventCard nightView = new NightView(enLocale);
	private EventCard rotten = new Rotten(enLocale);
	private ItemCard angelFeather = new AngelFeather(enLocale);
	private OmenCard crystalBall = new CrystalBall(enLocale);
	private OmenCard book = new Book(enLocale);
	private OmenCard ring = new Ring(enLocale);
	private Player player = new Player();
	private Player player2 = new Player();
	private ArrayList<Room> rooms = new ArrayList<Room>();
	private ArrayList<EventCard> events = new ArrayList<EventCard>();
	private ArrayList<ItemCard> items = new ArrayList<ItemCard>();
	private ArrayList<OmenCard> omens = new ArrayList<OmenCard>();
	private ArrayList<Player> players = new ArrayList<Player>();
	private Room foyer;
	private Room organRoom;
	
	@Before
	public void setUp(){
		RoomFactory roomfactory = new RoomFactory();
		character = explorers.getExplorer(Character_Name.FatherRhinehardt);
		character2 = explorers.getExplorer(Character_Name.OxBellows);
		player.addCharacter(character);
		player2.addCharacter(character2);
		
		events.add(angryBeing);
		events.add(creepyCrawlies);
		events.add(nightView);
		events.add(rotten);
		items.add(angelFeather);
		omens.add(crystalBall);
		omens.add(book);
		omens.add(ring);
		player.addCharacter(character);
		players.add(player);
		players.add(player2);
		
		// Set up Room Deck
		foyer = roomfactory.makeRoom(RoomName.FOYER);

		organRoom = roomfactory.makeRoom(RoomName.ORGANROOM);
		
		rooms.add(foyer);
		rooms.add(organRoom);

		
		Game.resetGame();
		game = Game.getInstance();
		game.addAllToEventDeck(events);
		game.addAllToItemDeck(items);
		game.addAllToOmenDeck(omens);
		game.addAllToRoomDeck(rooms);
		game.addPlayer(player);
		game.addPlayer(player2);
		game.addCharacter(character);
		game.addCharacter(character2);
	}
	
	@Test
	public void testGameInit(){

		assertNotNull(null, game);
		
		assertEquals(0, game.getCurrentCharacterIndex());
		assertEquals(rooms, game.getRoomDeck());
		assertEquals(events, game.getEventDeck());
		assertEquals(omens, game.getOmenDeck());
		assertEquals(items, game.getItemDeck());
		assertEquals(players, game.getPlayers());
		assertEquals(new ArrayList<Room>(), game.getRoomDiscard());
		assertEquals(new ArrayList<EventCard>(), game.getEventDiscard());
		assertEquals(new ArrayList<OmenCard>(), game.getOmenDiscard());
		assertEquals(new ArrayList<ItemCard>(), game.getItemDiscard());
		assertEquals(omens.size(), game.getNumOmens());
		assertFalse(game.getIsHaunt());
	}
	
	@Test
	public void testGetAndSetTraitForAction(){
		assertEquals(null, game.getTraitForAction());
		game.setTraitForAction(Trait.KNOWLEDGE);
		assertEquals(Trait.KNOWLEDGE, game.getTraitForAction());
	}
	
	@Test
	public void testGetAndSetIsHaunt(){
		assertFalse(game.getIsHaunt());
		game.setIsHaunt(true);
		assertTrue(game.getIsHaunt());
		game.setIsHaunt(false);
		assertFalse(game.getIsHaunt());
	}
	
	@Test
	public void testDrawAndDiscardRoom(){
		
		// Test drawRoom
		Room temp = game.drawRoom();
		assertEquals(foyer, temp);
		assertEquals(1, game.getRoomDeck().size());
		assertEquals(organRoom, game.getRoomDeck().get(0));
		assertEquals(0, game.getRoomDiscard().size());
		
		// Test discardRoom
		game.discardRoom(temp);
		assertEquals(1, game.getRoomDiscard().size());
		assertEquals(foyer, game.getRoomDiscard().get(0));
		
		// Test drawRoom with empty deck
		game.discardRoom(game.drawRoom());
		assertEquals(0, game.getRoomDeck().size());
		assertEquals(2, game.getRoomDiscard().size());
		temp = game.drawRoom();
		assertEquals(1, game.getRoomDeck().size());	
		game.discardRoom(temp);
		
	}
	
	@Test
	public void testDrawAndDiscardEvent(){
		
		// Test drawEvent
		EventCard temp = game.drawEvent();
		assertEquals(angryBeing, temp);
		assertEquals(3, game.getEventDeck().size());
		assertEquals(creepyCrawlies, game.getEventDeck().get(0));
		assertEquals(0, game.getEventDiscard().size());
		
		// Test discardEvent
		game.discardEvent(temp);
		assertEquals(1, game.getEventDiscard().size());
		assertEquals(angryBeing, game.getEventDiscard().get(0));
		
		// Test drawEvent with empty deck
		game.discardEvent(game.drawEvent());
		game.discardEvent(game.drawEvent());
		game.discardEvent(game.drawEvent());
		assertEquals(0, game.getEventDeck().size());
		assertEquals(4, game.getEventDiscard().size());
		temp = game.drawEvent();
		assertEquals(3, game.getEventDeck().size());		
		game.discardEvent(temp);
	}
	
	@Test
	public void testDrawAndDiscardOmen(){
		
		// Test drawOmen
		OmenCard temp = game.drawOmen();
		assertEquals(crystalBall, temp);
		assertEquals(2, game.getOmenDeck().size());
		assertEquals(book, game.getOmenDeck().get(0));
		assertEquals(0, game.getOmenDiscard().size());
		
		// Test discardOmen
		game.discardOmen(temp);
		assertEquals(1, game.getOmenDiscard().size());
		assertEquals(crystalBall, game.getOmenDiscard().get(0));
		
		// Test drawOmen with empty deck
		game.discardOmen(game.drawOmen());
		game.discardOmen(game.drawOmen());
		assertEquals(0, game.getOmenDeck().size());
		assertEquals(3, game.getOmenDiscard().size());
		temp = game.drawOmen();
		assertEquals(2, game.getOmenDeck().size());		
		game.discardOmen(temp);
	}
	
	@Test
	public void testDrawAndDiscardItem(){
		
		// Test drawItem
		ItemCard temp = game.drawItem();
		assertEquals(angelFeather, temp);
		assertEquals(0, game.getItemDeck().size());
		assertEquals(0, game.getItemDiscard().size());
		
		// Test discardItem
		game.discardItem(temp);
		assertEquals(1, game.getItemDiscard().size());
		assertEquals(angelFeather, game.getItemDiscard().get(0));
		
		// Test drawItem with empty deck
		assertEquals(0, game.getItemDeck().size());
		assertEquals(1, game.getItemDiscard().size());
		temp = game.drawItem();
		assertEquals(0, game.getItemDeck().size());		
		game.discardItem(temp);
	}
	
	@Test
	public void testNexCharacter(){
		assertEquals(0, game.getCurrentCharacterIndex());
		assertEquals(character, game.getCurrentCharacter());
		game.endCharacterTurn();
		assertEquals(1, game.getCurrentCharacterIndex());
		assertEquals(character2, game.getCurrentCharacter());
		
		// Test when currentPlayer should reset to zero
		game.endCharacterTurn();
		assertEquals(0, game.getCurrentCharacterIndex());
		assertEquals(character, game.getCurrentCharacter());
	}
	
	@Test
	public void testRollDie(){
		// This is a random function so tests multiple times for range
		
		int sum = 0;
		
		// Test Range for one die
		int i = 0;
		while (i < 100){
			sum = game.rollDice(1);
			assertTrue((sum <= 2) && (sum >= 0));
			i++;
		}
		
		// Test Range for two die
		i = 0;
		while (i < 100){
			sum = game.rollDice(2);
			assertTrue((sum <= 4) && (sum >= 0));
			i++;
		}
		
		// Test Range for eight die
		i = 0;
		while (i < 100){
			sum = game.rollDice(8);
			assertTrue(sum <= 16 && sum >= 0);
			i++;
		}
		
		// Test too many die input
		i = 0;
		while (i < 100){
			sum = game.rollDice(9);
			assertTrue(sum <= 16 && sum >= 0);
			i++;
		}
	}
	
	@Test
	public void testTypeRoll(){
		// This is a random function so tests multiple times for range for Traits of Father Rhinehardt
		
		int sum = 0;
		
		// Test Range for Knowledge
		int i = 0;
		while (i < 100){
			sum = game.typeRoll(Trait.KNOWLEDGE);
			assertTrue((sum <= 8) && (sum >= 0));
			i++;
		}
		
		// Test Range for Sanity
		i = 0;
		while (i < 100){
			sum = game.typeRoll(Trait.SANITY);
			assertTrue((sum <= 12) && (sum >= 0));
			i++;
		}
		
		// Test Range for Speed
		i = 0;
		while (i < 100){
			sum = game.typeRoll(Trait.SPEED);
			assertTrue(sum <= 6 && sum >= 0);
			i++;
		}
		
		// Test Range for Might
		i = 0;
		while (i < 100){
			sum = game.typeRoll(Trait.MIGHT);
			assertTrue(sum <= 4 && sum >= 0);
			i++;
		}
	}
	@Test
	public void testNumOmensOut(){
		assertEquals(0, game.numOmensOut());
		game.drawOmen();
		assertEquals(1, game.numOmensOut());
		game.discardOmen(game.drawOmen());
		assertEquals(1, game.numOmensOut());
		game.drawOmen();
		assertEquals(2, game.numOmensOut());
	}
	
}
