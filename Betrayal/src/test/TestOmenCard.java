package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
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

import rooms.Room;
import Game.Game;
import Game.Player;
import characters.Explorer;
import eventCards.AngryBeing;
import eventCards.CreepyCrawlies;
import eventCards.EventCard;
import eventCards.NightView;
import eventCards.Rotten;

public class TestOmenCard {

	private Explorer character = new Explorer(0, new Locale("en"));
	private Player player = new Player();
	
	private Game game;
	
	private ArrayList<Room> rooms = new ArrayList<Room>();
	
	
	private OmenCard crystalBallCard = new CrystalBall("Crystal Ball",
			"Hazy images appear in the glass.");
	private OmenCard bookCard = new Book("Book",
			"A diary or lab notes? Ancient script or modern ravings?");
	private OmenCard ringCard = new Ring("Ring",
			"A battered ring with an incomprehensible inscription.");
	private OmenCard madmanCard = new Madman("Madman",
			"COMPANION A raving, frothing madman");
	private OmenCard spearCard = new Spear("Spear",
			"A weapon pulsing with power.");
	private OmenCard spiritBoardCard = new SpiritBoard("Spirit Board",
			"A board with letters and numbers to call the dead");
	private Mask maskCard = new Mask("Mask",
			"A somber mask to hide your intentions.");
	private OmenCard medallionCard = new Medallion("Medallion",
			"A medallion inscribed with a pentagram.");
	private OmenCard girlCard = new Girl("Girl",
			"COMPANION A girl.Trapped.Alone.You free her!");
	private OmenCard biteCard = new Bite("Bite",
			"A growl, the scent of death.Pain.Darkness.Gone.");
	private OmenCard skullCard = new Skull("Skull",
			"A skull, cracked and missing teeth.");
	private OmenCard holySymbolCard = new HolySymbol("Holy Symbol",
			"A symbol of calm in an unsettling world.");
	private OmenCard dogCard = new Dog("Dog",
			"COMPANION This mangy dog seems friendly. At least you hope it is.");
	
	private ArrayList<EventCard> events = new ArrayList<EventCard>();
	private ArrayList<ItemCard> items = new ArrayList<ItemCard>();
	private ArrayList<OmenCard> omens = new ArrayList<OmenCard>();
	private ArrayList<Player> players = new ArrayList<Player>();
	private String rottenDes = "The smell in this room, it's horrible. Smells like death, like blood. A slaughterhouse smell.";
	private String angryBeingDes = "It emerges from the slime on the wall next to you.";
	private String creepyCrawliesDes = "A thousand bugs spill out on your skin, under your clothes, and in your hair.";
	private String nightViewDes = "You see a vision of a ghostly couple walking the grounds, silently strolling in their wedding best";
	private EventCard angryBeing = new AngryBeing("Angry Being", angryBeingDes);
	private EventCard creepyCrawlies = new CreepyCrawlies("Creepy Crawlies",
			creepyCrawliesDes);
	private EventCard nightView = new NightView("Night View", nightViewDes);
	private EventCard rotten = new Rotten("Rotten", rottenDes);
	private ItemCard angelFeather = new AngelFeather("Angel Feather", "A perfect feather fluttering in your hand.");
	


	@Before
	public void SetUp() {
		
		events.add(angryBeing);
		events.add(creepyCrawlies);
		events.add(nightView);
		events.add(rotten);
		items.add(angelFeather);
		omens.add(crystalBallCard);
		omens.add(bookCard);
		omens.add(ringCard);
		players.add(player);
		
		Game.resetGame();
		game = Game.getInstance();
		game.addAllToEventDeck(events);
		game.addAllToItemDeck(items);
		game.addAllToOmenDeck(omens);
		game.addPlayer(player);
		
		
		
	}

	@Test 
	public void TestIsHauntRollForOmenCard(){
		OmenCard card = new Book ("Test card", "Just testing");
		assertEquals(game.getIsHaunt(),card.isHauntRoll());
	}
	
	@Test
	public void TestMakeHauntRollForOmenCard(){
		OmenCard card = new Book("Test","Just testing");
		assertFalse(card.makeHauntRoll());
		game.setIsHaunt(true);
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
		game.setIsHaunt(true);
		assertTrue(crystalBallCard.isHauntRoll());
		game.setIsHaunt(false);
	}

	@Test
	public void MakeAHauntRollWithCrystalBall() {
		game.setIsHaunt(true);
		assertTrue(crystalBallCard.makeHauntRoll());
		game.setIsHaunt(false);
	}

	@Test
	public void TestWhatToDoForCrystalBall() {
		assertNotNull(crystalBallCard.whatToDo());
		if(game.getIsHaunt()==true){
			crystalBallCard.makeKnowledgeRoll();
		}
	}
	
	public void TestMakeKnowledgeRollForCrystalBall(){
			
		}
		
		
	
	
	

	@Test
	public void IsHauntRollWithBook() {
		game.setIsHaunt(true);
		assertTrue(bookCard.isHauntRoll());
		game.setIsHaunt(false);
	}

	@Test
	public void MakeAHauntRollWithBook() {
		game.setIsHaunt(true);
		assertTrue(bookCard.makeHauntRoll());
		game.setIsHaunt(false);
	}

	@Test
	public void TestWhatToDoForBook() {
		game.getInstance();
		Player player = new Player();
		Explorer character = new Explorer(0, new Locale("en"));
		player.addCharacter(character);
		game.addPlayer(player);
		game.addCharacter(character);
		
		assertNotNull(bookCard.whatToDo());
		assertEquals(bookCard.whatToDo(character,game),character.getCurrentKnowledge());
		
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
		game.setIsHaunt(true);
		assertTrue(ringCard.isHauntRoll());
		game.setIsHaunt(false);
	}

	@Test
	public void MakeAHauntRollWithRing() {
		game.setIsHaunt(true);
		assertTrue(ringCard.makeHauntRoll());
		game.setIsHaunt(false);
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
		game.setIsHaunt(true);
		assertTrue(madmanCard.isHauntRoll());
		game.setIsHaunt(false);
	}

	@Test
	public void MakeAHauntRollWithMadman() {
		game.setIsHaunt(true);
		assertTrue(madmanCard.makeHauntRoll());
		game.setIsHaunt(false);
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
		game.setIsHaunt(true);
		assertTrue(spearCard.isHauntRoll());
		game.setIsHaunt(false);
	}

	@Test
	public void MakeAHauntRollWithSpear() {
		game.setIsHaunt(true);
		assertTrue(spearCard.makeHauntRoll());
		game.setIsHaunt(false);
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
	public void TestWhatToDoForSpiritBoard() {
		assertNotNull(spiritBoardCard.whatToDo());
	}

	@Test
	public void IsHauntRollWithMask() {
		game.setIsHaunt(true);
		assertTrue(maskCard.isHauntRoll());
		game.setIsHaunt(false);
	}

	@Test
	public void MakeAHauntRollWithMask() {
		game.setIsHaunt(true);
		assertTrue(maskCard.makeHauntRoll());
		game.setIsHaunt(false);
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
		game.setIsHaunt(true);
		assertTrue(medallionCard.isHauntRoll());
		game.setIsHaunt(false);
	}

	@Test
	public void MakeAHauntRollWithMedallion() {
		game.setIsHaunt(true);
		assertTrue(medallionCard.makeHauntRoll());
		game.setIsHaunt(false);
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
		game.setIsHaunt(true);
		assertTrue(girlCard.isHauntRoll());
		game.setIsHaunt(false);
	}

	@Test
	public void MakeAHauntRollWithGirl() {
		game.setIsHaunt(true);
		assertTrue(girlCard.makeHauntRoll());
		game.setIsHaunt(false);
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
		game.setIsHaunt(true);
		assertTrue(biteCard.isHauntRoll());
		game.setIsHaunt(false);
	}

	@Test
	public void MakeAHauntRollWithBite() {
		game.setIsHaunt(true);
		assertTrue(biteCard.makeHauntRoll());
		game.setIsHaunt(false);
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
		game.setIsHaunt(true);
		assertTrue(skullCard.isHauntRoll());
		game.setIsHaunt(false);
	}

	@Test
	public void MakeAHauntRollWithSkull() {
		game.setIsHaunt(true);
		assertTrue(skullCard.makeHauntRoll());
		game.setIsHaunt(false);
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
		game.setIsHaunt(true);
		assertTrue(holySymbolCard.isHauntRoll());
		game.setIsHaunt(false);
	}

	@Test
	public void MakeAHauntRollWithHolySymbol() {
		game.setIsHaunt(true);
		assertTrue(holySymbolCard.makeHauntRoll());
		game.setIsHaunt(false);
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
		game.setIsHaunt(true);
		assertTrue(dogCard.isHauntRoll());
		game.setIsHaunt(false);
	}

	@Test
	public void MakeAHauntRollWithDog() {
		game.setIsHaunt(true);
		assertTrue(dogCard.makeHauntRoll());
		game.setIsHaunt(false);
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
