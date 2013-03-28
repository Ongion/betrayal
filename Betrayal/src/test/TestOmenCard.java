package test;

import static org.junit.Assert.*;

import itemCards.AngelFeather;
import itemCards.ItemCard;

import java.util.ArrayList;
import java.util.Locale;

import omenCards.Bite;
import omenCards.Book;
import omenCards.CrystalBall;
import omenCards.Dog;
import omenCards.Girl;
import omenCards.HolySymbol;
import omenCards.Madman;
import omenCards.Mask;
import omenCards.Medallion;
import omenCards.OmenCard;
import omenCards.Ring;
import omenCards.Skull;
import omenCards.Spear;
import omenCards.SpiritBoard;

import org.junit.Before;
import org.junit.Test;

import rooms.FoyerRoom;
import rooms.OrganRoomRoom;
import rooms.Room;

import Game.Game;
import Game.Player;
import characters.Character;
import eventCards.AngryBeing;
import eventCards.CreepyCrawlies;
import eventCards.EventCard;
import eventCards.NightView;
import eventCards.Rotten;

public class TestOmenCard {

	private Game game;
	private Character character = new Character(0, new Locale("en"));
	private OmenCard crystalBallCard = new CrystalBall("Crystal Ball",
			"Hazy images appear in the glass.", game);
	private OmenCard bookCard = new Book("Book",
			"A diary or lab notes? Ancient script or modern ravings?",game);
	private OmenCard ringCard = new Ring("Ring",
			"A battered ring with an incomprehensible inscription.",game);
	private OmenCard madmanCard = new Madman("Madman",
			"COMPANION A raving, frothing madman",game);
	private OmenCard spearCard = new Spear("Spear",
			"A weapon pulsing with power.",game);
	private OmenCard spiritBoardCard = new SpiritBoard("Spirit Board",
			"A board with letters and numbers to call the dead",game);
	private Mask maskCard = new Mask("Mask",
			"A somber mask to hide your intentions.", character, game);
	private OmenCard medallionCard = new Medallion("Medallion",
			"A medallion inscribed with a pentagram.",game);
	private OmenCard girlCard = new Girl("Girl",
			"COMPANION A girl.Trapped.Alone.You free her!",game);
	private OmenCard biteCard = new Bite("Bite",
			"A growl, the scent of death.Pain.Darkness.Gone.",game);
	private OmenCard skullCard = new Skull("Skull",
			"A skull, cracked and missing teeth.",game);
	private OmenCard holySymbolCard = new HolySymbol("Holy Symbol",
			"A symbol of calm in an unsettling world.",game);
	private OmenCard dogCard = new Dog("Dog",
			"COMPANION This mangy dog seems friendly. At least you hope it is.",game);
	private Room foyer = new FoyerRoom();
	private Room organRoom = new OrganRoomRoom();
	private ArrayList<Room> rooms = new ArrayList<Room>();
	private ArrayList<EventCard> events = new ArrayList<EventCard>();
	private ArrayList<ItemCard> items = new ArrayList<ItemCard>();
	private ArrayList<OmenCard> omens = new ArrayList<OmenCard>();
	private ArrayList<Player> players = new ArrayList<Player>();
	private String rottenDes = "The smell in this room, it's horrible. Smells like death, like blood. A slaughterhouse smell.";
	private String angryBeingDes = "It emerges from the slime on the wall next to you.";
	private String creepyCrawliesDes = "A thousand bugs spill out on your skin, under your clothes, and in your hair.";
	private String nightViewDes = "You see a vision of a ghostly couple walking the grounds, silently strolling in their wedding best";
	private EventCard angryBeing = new AngryBeing("Angry Being", angryBeingDes, game);
	private EventCard creepyCrawlies = new CreepyCrawlies("Creepy Crawlies",
			creepyCrawliesDes, game);
	private EventCard nightView = new NightView("Night View", nightViewDes, game);
	private EventCard rotten = new Rotten("Rotten", rottenDes, game);
	private ItemCard angelFeather = new AngelFeather("Angel Feather", "A perfect feather fluttering in your hand.");
	private Player player = new Player(character);


	@Before
	public void SetUp() {
		// Initalize ArrayLists for rest of tests
		rooms.add(foyer);
		rooms.add(organRoom);
		events.add(angryBeing);
		events.add(creepyCrawlies);
		events.add(nightView);
		events.add(rotten);
		items.add(angelFeather);
		omens.add(crystalBallCard);
		omens.add(bookCard);
		omens.add(ringCard);
		players.add(player);
		players.add(player);
		
		game = new Game(null, rooms, events, omens, items, players);
		
	}

	@Test 
	public void TestIsHauntRollForOmenCard(){
		OmenCard card = new Book ("Test card", "Just testing",game);
		assertEquals(game.getIsHaunt(),card.isHauntRoll());
	}
	
	@Test
	public void TestMakeHauntRollForOmenCard(){
		OmenCard card = new Book("Test","Just testing",game);
		assertFalse(card.makeHauntRoll());
		if(card.isHauntRoll()){
			assertTrue(card.makeHauntRoll());
		}
	}
	
	@Test
	public void CrystalBallOmenInit() {
		crystalBallCard.setName("Crystal Ball");
		crystalBallCard.setQuote("Hazy images appear in the glass.");
		assertEquals("Crystal Ball", crystalBallCard.getName());
		assertEquals("Hazy images appear in the glass.",
				crystalBallCard.getQuote());
	}

	@Test
	public void IsHauntRollWithCrystalBall() {
		assertTrue(crystalBallCard.isHauntRoll());
	}

	@Test
	public void MakeAHauntRollWithCrystalBall() {
		assertTrue(crystalBallCard.makeHauntRoll());
	}

	@Test
	public void TestWhatToDoForCrystalBall() {
		assertNotNull(crystalBallCard.whatToDo());
	}
	
	@Test
	public void IsHauntRollWithBook() {
		assertTrue(bookCard.isHauntRoll());
	}

	@Test
	public void MakeAHauntRollWithBook() {
		assertTrue(bookCard.makeHauntRoll());
	}

	@Test
	public void TestWhatToDoForBook() {
		assertNotNull(bookCard.whatToDo());
	}

	@Test
	public void BookInit() {
		bookCard.setName("Book");
		bookCard.setQuote("A diary or lab notes? Ancient script or modern ravings?");
		assertEquals("Book", bookCard.getName());
		assertEquals("A diary or lab notes? Ancient script or modern ravings?",
				bookCard.getQuote());
	}
	
	@Test
	public void IsHauntRollWithRing() {
		assertTrue(ringCard.isHauntRoll());
	}

	@Test
	public void MakeAHauntRollWithRing() {
		assertTrue(ringCard.makeHauntRoll());
	}

	@Test
	public void TestWhatToDoForRing() {
		assertNotNull(ringCard.whatToDo());
	}

	@Test
	public void RingInit() {
		ringCard.setName("Ring");
		ringCard.setQuote("A battered ring with an incomprehensible inscription.");
		assertEquals("Ring", ringCard.getName());
		assertEquals("A battered ring with an incomprehensible inscription.",
				ringCard.getQuote());
	}

	@Test
	public void IsHauntRollWithMadman() {
		assertTrue(madmanCard.isHauntRoll());
	}

	@Test
	public void MakeAHauntRollWithMadman() {
		assertTrue(madmanCard.makeHauntRoll());
	}

	@Test
	public void TestWhatToDoForMadman() {
		assertNotNull(madmanCard.whatToDo());
	}
	@Test
	public void MadmanInit() {
		madmanCard.setName("Madman");
		madmanCard.setQuote("COMPANION A raving, frothing madman");
		assertEquals("Madman", madmanCard.getName());
		assertEquals("COMPANION A raving, frothing madman",
				madmanCard.getQuote());
	}

	@Test
	public void IsHauntRollWithSpear() {
		assertTrue(spearCard.isHauntRoll());
	}

	@Test
	public void MakeAHauntRollWithSpear() {
		assertTrue(spearCard.makeHauntRoll());
	}

	@Test
	public void TestWhatToDoForSpear() {
		assertNotNull(spearCard.whatToDo());
	}
	
	@Test
	public void SpearInit() {
		spearCard.setName("Spear");
		spearCard.setQuote("A weapon pulsing with power.");
		assertEquals("Spear", spearCard.getName());
		assertEquals("A weapon pulsing with power.", spearCard.getQuote());
	}

	@Test
	public void SpiritBoardInit() {
		spiritBoardCard.setName("Spirit Board");
		spiritBoardCard.setQuote("A board with letters and numbers to call the dead");
		assertEquals("Spirit Board", spiritBoardCard.getName());
		assertEquals("A board with letters and numbers to call the dead",
				spiritBoardCard.getQuote());
	}

	@Test
	public void IsHauntRollWithMask() {
		assertTrue(maskCard.isHauntRoll());
	}

	@Test
	public void MakeAHauntRollWithMask() {
		assertTrue(maskCard.makeHauntRoll());
	}

	@Test
	public void TestWhatToDoForMask() {
		assertNotNull(maskCard.whatToDo());
	}
	
	@Test
	public void MaskInit() {
		maskCard.setName("Mask");
		maskCard.setQuote("A somber mask to hide your intentions.");
		assertEquals("Mask", maskCard.getName());
		assertEquals("A somber mask to hide your intentions.",
				maskCard.getQuote());
	}
	
//	@Test
//	public void TestputOnMask(){
//		assertTrue(maskCard.putOnMask());
//	}
//	
//	@Test
//	public void TestWhatToDoMask(){
//		assertEquals(null,maskCard.whatToDo());
//	}

	@Test
	public void IsHauntRollWithMedallion() {
		assertTrue(medallionCard.isHauntRoll());
	}

	@Test
	public void MakeAHauntRollWithMedallion() {
		assertTrue(medallionCard.makeHauntRoll());
	}

	@Test
	public void TestWhatToDoForMedallion() {
		assertNotNull(medallionCard.whatToDo());
	}
	
	@Test
	public void MedallionInit() {
		medallionCard.setName("Medallion");
		medallionCard.setQuote("A medallion inscribed with a pentagram.");
		assertEquals("Medallion", medallionCard.getName());
		assertEquals("A medallion inscribed with a pentagram.",
				medallionCard.getQuote());
	}

	@Test
	public void IsHauntRollWithGirl() {
		assertTrue(girlCard.isHauntRoll());
	}

	@Test
	public void MakeAHauntRollWithGirl() {
		assertTrue(girlCard.makeHauntRoll());
	}

	@Test
	public void TestWhatToDoForGirl() {
		assertNotNull(girlCard.whatToDo());
	}
	
	@Test
	public void GirlInit() {
		girlCard.setName("Girl");
		girlCard.setQuote("COMPANION A girl.Trapped.Alone.You free her!");
		assertEquals("Girl", girlCard.getName());
		assertEquals("COMPANION A girl.Trapped.Alone.You free her!",
				girlCard.getQuote());
	}

	@Test
	public void IsHauntRollWithBite() {
		assertTrue(biteCard.isHauntRoll());
	}

	@Test
	public void MakeAHauntRollWithBite() {
		assertTrue(biteCard.makeHauntRoll());
	}

	@Test
	public void TestWhatToDoForBite() {
		assertNotNull(biteCard.whatToDo());
	}
	
	@Test
	public void BiteInit() {
		biteCard.setName("Bite");
		biteCard.setQuote("A growl, the scent of death.Pain.Darkness.Gone.");
		assertEquals("Bite", biteCard.getName());
		assertEquals("A growl, the scent of death.Pain.Darkness.Gone.",
				biteCard.getQuote());
	}

	@Test
	public void IsHauntRollWithSkull() {
		assertTrue(skullCard.isHauntRoll());
	}

	@Test
	public void MakeAHauntRollWithSkull() {
		assertTrue(skullCard.makeHauntRoll());
	}

	@Test
	public void TestWhatToDoForSkull() {
		assertNotNull(skullCard.whatToDo());
	}
	
	@Test
	public void SkullInit() {
		skullCard.setName("Skull");
		skullCard.setQuote("A skull, cracked and missing teeth.");
		assertEquals("Skull", skullCard.getName());
		assertEquals("A skull, cracked and missing teeth.",
				skullCard.getQuote());
	}

	@Test
	public void IsHauntRollWithHolySymbol() {
		assertTrue(holySymbolCard.isHauntRoll());
	}

	@Test
	public void MakeAHauntRollWithHolySymbol() {
		assertTrue(holySymbolCard.makeHauntRoll());
	}

	@Test
	public void TestWhatToDoForHolySymbol() {
		assertNotNull(holySymbolCard.whatToDo());
	}
	
	@Test
	public void HolySymbolInit() {
		holySymbolCard.setName("Holy Symbol");
		holySymbolCard.setQuote("A symbol of calm in an unsettling world.");
		assertEquals("Holy Symbol", holySymbolCard.getName());
		assertEquals("A symbol of calm in an unsettling world.",
				holySymbolCard.getQuote());
	}
	
	@Test
	public void IsHauntRollWithDog() {
		assertTrue(dogCard.isHauntRoll());
	}

	@Test
	public void MakeAHauntRollWithDog() {
		assertTrue(dogCard.makeHauntRoll());
	}

	@Test
	public void TestWhatToDoForDog() {
		assertNotNull(dogCard.whatToDo());
	}
	

	@Test
	public void DogInit() {
		dogCard.setName("Dog");
		dogCard.setQuote("COMPANION This mangy dog seems friendly. At least you hope it is.");
		assertEquals("Dog", dogCard.getName());
		assertEquals(
				"COMPANION This mangy dog seems friendly. At least you hope it is.",
				dogCard.getQuote());

	}

}
