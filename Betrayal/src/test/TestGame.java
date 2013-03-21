package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Locale;

import org.junit.Test;

import omenCards.Book;
import omenCards.CrystalBall;
import omenCards.OmenCard;
import omenCards.Ring;

import itemCards.AngelFeather;
import itemCards.ItemCard;

import rooms.FoyerRoom;
import rooms.OrganRoomRoom;
import rooms.Room;

import Game.Game;
import Game.Player;

import eventCards.AngryBeing;
import eventCards.CreepyCrawlies;
import eventCards.EventCard;
import eventCards.NightView;
import eventCards.Rotten;

public class TestGame {

	private Game game;
	private characters.Character character = new characters.Character(0,new Locale("en"));
	private String rottenDes = "The smell in this room, it's horrible. Smells like death, like blood. A slaughterhouse smell.";
	private String angryBeingDes = "It emerges from the slime on the wall next to you.";
	private String creepyCrawliesDes = "A thousand bugs spill out on your skin, under your clothes, and in your hair.";
	private String nightViewDes = "You see a vision of a ghostly couple walking the grounds, silently strolling in their wedding best";
	private EventCard angryBeing = new AngryBeing("Angry Being", angryBeingDes, character);
	private EventCard creepyCrawlies = new CreepyCrawlies("Creepy Crawlies", creepyCrawliesDes, character);
	private EventCard nightView = new NightView("Night View", nightViewDes, character);
	private EventCard rotten = new Rotten("Rotten", rottenDes, character);
	private ItemCard angelFeather = new AngelFeather("Angel Feather", "A perfect feather fluttering in your hand.");
	private OmenCard crystalBall = new CrystalBall("Crystal Ball", "Hazy images appear in the glass.");
	private OmenCard book = new Book("Book", "A diary or lab notes? Ancient script or modern ravings?");
	private OmenCard ring = new Ring("Ring","A battered ring with an incomprehensible inscription.");
	private Room foyer = new FoyerRoom();
	private Room organRoom = new OrganRoomRoom();
	private Player player = new Player(character);
	private ArrayList<Room> rooms = new ArrayList<Room>();
	private ArrayList<EventCard> events = new ArrayList<EventCard>();
	private ArrayList<ItemCard> items = new ArrayList<ItemCard>();
	private ArrayList<OmenCard> omens = new ArrayList<OmenCard>();
	private ArrayList<Player> players = new ArrayList<Player>();
	
	
	
	@Test
	public void testGameInit(){
		
		// Initalize ArrayLists for rest of tests
		rooms.add(foyer);
		rooms.add(organRoom);
		events.add(angryBeing);
		events.add(creepyCrawlies);
		events.add(nightView);
		events.add(rotten);
		items.add(angelFeather);
		omens.add(crystalBall);
		omens.add(book);
		omens.add(ring);
		
		game = new Game(null, rooms, events, omens, items, );
		
	}
	
}
