package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import itemCards.AngelFeather;
import itemCards.ItemCard;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
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

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import rooms.Room;
import rooms.Room.Relative_Direction;
import Game.Game;
import Game.Player;
import characters.ExplorerType;
import characters.ExplorerFactory;
import characters.Character;
import characters.HumanStats;
import eventCards.AngryBeing;
import eventCards.CreepyCrawlies;
import eventCards.EventCard;
import eventCards.NightView;
import eventCards.Rotten;
import characters.Character;
import characters.Character.Character_Name;

public class TestOmenCard {

	private ExplorerFactory explorers = new ExplorerFactory();
	private Character character;
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
	private ItemCard angelFeather = new AngelFeather("Angel Feather",
			"A perfect feather fluttering in your hand.");

	@Before
	public void SetUp() {
		character = explorers.getExplorer(Character_Name.FatherRhinehardt);
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
	public void TestIsHauntRollForOmenCard() {
		OmenCard card = new Book("Test card", "Just testing");
		assertEquals(game.getIsHaunt(), card.isHauntRoll());
	}

	@Test
	public void TestMakeHauntRollForOmenCard() {
		OmenCard card = new Book("Test", "Just testing");
		assertFalse(card.makeHauntRoll());
		game.setIsHaunt(true);
		if (card.isHauntRoll()) {
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
	public void TestKnowledgeRollLessThan4ForCrystalBall() {
		Mockery mocks = new Mockery() {
			{
				setImposteriser(ClassImposteriser.INSTANCE);
			}
		};
		final Game mockGame = mocks.mock(Game.class);
		try {
			Field instanceField = Game.class.getDeclaredField("INSTANCE");
			instanceField.setAccessible(true);
			instanceField.set(null, mockGame);

			final int fRKnowledge = character.getCurrentKnowledge();
			mocks.checking(new Expectations() {
				{
					oneOf(mockGame).rollDice(fRKnowledge);
					will(returnValue(3));
				}
			});

			int sanityBefore = character.getCurrentSanityIndex() - 1;
			crystalBallCard.whatToDo(character);
			int sanityAfter = character.getCurrentSanityIndex();
			assertEquals(sanityAfter, sanityBefore);

			mocks.assertIsSatisfied();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Test
	public void TestKnowledgeRollIsZeroForCrystalBall() {
		Mockery mocks = new Mockery() {
			{
				setImposteriser(ClassImposteriser.INSTANCE);
			}
		};
		final Game mockGame = mocks.mock(Game.class);
		try {
			Field instanceField = Game.class.getDeclaredField("INSTANCE");
			instanceField.setAccessible(true);
			instanceField.set(null, mockGame);

			final int fRKnowledge = character.getCurrentKnowledge();
			mocks.checking(new Expectations() {
				{
					oneOf(mockGame).rollDice(fRKnowledge);
					will(returnValue(0));
				}
			});

			int sanityBefore = character.getCurrentSanityIndex() - 2;
			crystalBallCard.whatToDo(character);
			int sanityAfter = character.getCurrentSanityIndex();
			assertEquals(sanityAfter, sanityBefore);

			mocks.assertIsSatisfied();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test
	public void TestKnowledgeRollIsGreaterThan4ForCrystallBallEvent(){
		Mockery mocks = new Mockery() {
			{
				setImposteriser(ClassImposteriser.INSTANCE);
			}
		};
		final Game mockGame = mocks.mock(Game.class);
		try {
			Field instanceField = Game.class.getDeclaredField("INSTANCE");
			instanceField.setAccessible(true);
			instanceField.set(null, mockGame);

			final int fRKnowledge = character.getCurrentKnowledge();
			mocks.checking(new Expectations() {
				{
					oneOf(mockGame).rollDice(fRKnowledge);
					will(returnValue(6));
				}
			});
			crystalBallCard.itemOrEvent = 0;
			ArrayList<EventCard> eventStackBefore = mockGame.getEventDeck();
			crystalBallCard.whatToDo(character);
			ArrayList<EventCard> eventStackAfter = mockGame.getEventDeck();
			assertFalse(eventStackAfter.equals(eventStackBefore));

			mocks.assertIsSatisfied();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test
	public void TestKnowledgeRollIsGreaterThan4ForCrystallBallItem(){
		Mockery mocks = new Mockery() {
			{
				setImposteriser(ClassImposteriser.INSTANCE);
			}
		};
		final Game mockGame = mocks.mock(Game.class);
		try {
			Field instanceField = Game.class.getDeclaredField("INSTANCE");
			instanceField.setAccessible(true);
			instanceField.set(null, mockGame);

			final int fRKnowledge = character.getCurrentKnowledge();
			mocks.checking(new Expectations() {
				{
					oneOf(mockGame).rollDice(fRKnowledge);
					will(returnValue(5));
				}
			});
			crystalBallCard. itemOrEvent = 1;
			ArrayList<ItemCard> itemStackBefore = mockGame.getItemDeck();
			crystalBallCard.whatToDo(character);
			ArrayList<ItemCard> itemStackAfter = mockGame.getItemDeck();
			assertFalse(itemStackAfter.equals(itemStackBefore));

			mocks.assertIsSatisfied();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
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
		Explorer character = new Explorer(Explorers.FatherRhinehardt,
				new Locale("en"));
		player.addCharacter(character);
		game.addPlayer(player);
		game.addCharacter(character);

		int expectedKnowledge = character.getCurrentKnowledgeIndex() + 2;
		bookCard.whatToDo(character);
		int knowledgeAfter = character.getCurrentKnowledgeIndex();
		assertEquals(knowledgeAfter, expectedKnowledge);
	}

	@Test
	public void TestBookIsLost() {

		character.addOmenCard(bookCard);

		character.removeOmenCard(bookCard);// For testing purposes, card will be
											// taken away here.

		int expectedKnowledge = ((HumanStats) character.getStats()).getCurrentKnowledgeIndex() - 2;
		((Book) bookCard).isLost(character);
		int knowledgeAfter = ((HumanStats) character.getStats()).getCurrentKnowledgeIndex();
		assertEquals(knowledgeAfter, expectedKnowledge);

	}

	@Test
	public void TestBookIsNotLost() {
		character.addOmenCard(bookCard);

		int expectedKnowledge = ((HumanStats) character.getStats()).getCurrentKnowledgeIndex();
		((Book) bookCard).isLost(character);
		int knowledgeAfter = ((HumanStats) character.getStats()).getCurrentKnowledgeIndex();
		assertEquals(expectedKnowledge, knowledgeAfter);
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
		game.getInstance();
		Player player = new Player();
<<<<<<< HEAD
//		Character character = new Explorer(ExplorerName.FatherRhinehardt, new Locale("en"));
//		player.addCharacter(character);
//		game.addPlayer(player);
//		game.addCharacter(character);
		assertNotNull(madmanCard.whatToDo());
		
=======
		Explorer character = new Explorer(Explorers.FatherRhinehardt,
				new Locale("en"));
		player.addCharacter(character);
		game.addPlayer(player);
		game.addCharacter(character);

>>>>>>> master
		int expectedMight = character.getCurrentMightIndex() + 2;
		int expectedSanity = character.getCurrentSanityIndex() - 1;
		madmanCard.whatToDo(character);
		int mightAfter = character.getCurrentMightIndex();
		int sanityAfter = character.getCurrentSanityIndex();
		assertEquals(mightAfter, expectedMight);
		assertEquals(sanityAfter, expectedSanity);

	}

	@Test
	public void TestMadmanIsLost() {
		game.getInstance();
		Player player = new Player();
<<<<<<< HEAD
		ExplorerType character = new ExplorerType(Explorers.FatherRhinehardt, new Locale("en"));
=======
		Explorer character = new Explorer(Explorers.FatherRhinehardt,
				new Locale("en"));
>>>>>>> master
		player.addCharacter(character);
		game.addPlayer(player);
		game.addCharacter(character);
		character.addOmenCard(madmanCard);

		character.removeOmenCard(madmanCard); // For testing purposes the card
												// is removed here.

		int expectedMight = character.getCurrentMightIndex() - 2;
		int expectedSanity = character.getCurrentSanityIndex() + 1;
		((Madman) madmanCard).isLost(character);
		int mightAfter = character.getCurrentMightIndex();
		int sanityAfter = character.getCurrentSanityIndex();
		assertEquals(mightAfter, expectedMight);
		assertEquals(sanityAfter, expectedSanity);
	}

	@Test
<<<<<<< HEAD
	public void TestMadmanIsNotLost(){
			game.getInstance();
			Player player = new Player();
			ExplorerType character = new ExplorerType(Explorers.FatherRhinehardt, new Locale("en"));
			player.addCharacter(character);
			game.addPlayer(player);
			game.addCharacter(character);
			character.addOmenCard(madmanCard);
			
			int expectedMight = character.getCurrentMightIndex();
			int expectedSanity = character.getCurrentSanityIndex();
			madmanCard.isLost(character);
			int mightAfter = character.getCurrentMightIndex();
			int sanityAfter = character.getCurrentSanityIndex();
			assertEquals(mightAfter, expectedMight);
			assertEquals(sanityAfter,expectedSanity);
		}
	
	
=======
	public void TestMadmanIsNotLost() {
		game.getInstance();
		Player player = new Player();
		Explorer character = new Explorer(Explorers.FatherRhinehardt,
				new Locale("en"));
		player.addCharacter(character);
		game.addPlayer(player);
		game.addCharacter(character);
		character.addOmenCard(madmanCard);

		int expectedMight = character.getCurrentMightIndex();
		int expectedSanity = character.getCurrentSanityIndex();
		((Madman) madmanCard).isLost(character);
		int mightAfter = character.getCurrentMightIndex();
		int sanityAfter = character.getCurrentSanityIndex();
		assertEquals(mightAfter, expectedMight);
		assertEquals(sanityAfter, expectedSanity);
	}

>>>>>>> master
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
	public void SpearInit() {
		spearCard.setName("Spear");
		spearCard.setQuote("A weapon pulsing with power.");
		assertEquals("Spear", spearCard.getName());
		assertEquals("A weapon pulsing with power.", spearCard.getQuote());
	}

	@Test
	public void SpiritBoardInit() {
		spiritBoardCard.setName("Spirit Board");
		spiritBoardCard
				.setQuote("A board with letters and numbers to call the dead");
		assertEquals("Spirit Board", spiritBoardCard.getName());
		assertEquals("A board with letters and numbers to call the dead",
				spiritBoardCard.getQuote());
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
	public void MaskInit() {
		maskCard.setName("Mask");
		maskCard.setQuote("A somber mask to hide your intentions.");
		assertEquals("Mask", maskCard.getName());
		assertEquals("A somber mask to hide your intentions.",
				maskCard.getQuote());
	}

	@Test
	public void TestMaskDiceRollGreaterThan4AndMaskIsOn() {
		Mockery mocks = new Mockery() {
			{
				setImposteriser(ClassImposteriser.INSTANCE);
			}
		};
		final Game mockGame = mocks.mock(Game.class);
		try {
			Field instanceField = Game.class.getDeclaredField("INSTANCE");
			instanceField.setAccessible(true);
			instanceField.set(null, mockGame);

			final int fRSanity = character.getCurrentSanity();

			mocks.checking(new Expectations() {
				{
					oneOf(mockGame).rollDice(fRSanity);
					will(returnValue(5));
				}
			});
			int expectedSanity = character.getCurrentSanityIndex() - 2;
			int expectedKnowledge = character.getCurrentKnowledgeIndex() + 2;

			maskCard.isMaskOn = true;
			maskCard.whatToDo(character);
			int sanityAfter = character.getCurrentSanityIndex();
			int knowledgeAfter = character.getCurrentKnowledgeIndex();
			assertEquals(sanityAfter, expectedSanity);
			assertEquals(knowledgeAfter, expectedKnowledge);

			mocks.assertIsSatisfied();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Test
	public void TestMaskDiceRollGreaterThan4AndMaskIsOff() {
		Mockery mocks = new Mockery() {
			{
				setImposteriser(ClassImposteriser.INSTANCE);
			}
		};
		final Game mockGame = mocks.mock(Game.class);
		try {
			Field instanceField = Game.class.getDeclaredField("INSTANCE");
			instanceField.setAccessible(true);
			instanceField.set(null, mockGame);

			final int fRSanity = character.getCurrentSanity();

			mocks.checking(new Expectations() {
				{
					oneOf(mockGame).rollDice(fRSanity);
					will(returnValue(5));
				}
			});
			int expectedSanity2 = character.getCurrentSanityIndex() + 2;
			int expectedKnowledge2 = character.getCurrentKnowledgeIndex() - 2;

			maskCard.isMaskOn = false;
			maskCard.whatToDo(character);
			int sanityAfter2 = character.getCurrentSanityIndex();
			int knowledgeAfter2 = character.getCurrentKnowledgeIndex();
			assertEquals(sanityAfter2, expectedSanity2);
			assertEquals(knowledgeAfter2, expectedKnowledge2);

			mocks.assertIsSatisfied();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Test
	public void TestMaskDiceRollLessThan4() {
		Mockery mocks = new Mockery() {
			{
				setImposteriser(ClassImposteriser.INSTANCE);
			}
		};
		final Game mockGame = mocks.mock(Game.class);
		try {
			Field instanceField = Game.class.getDeclaredField("INSTANCE");
			instanceField.setAccessible(true);
			instanceField.set(null, mockGame);

			final int fRSanity = character.getCurrentSanity();

			mocks.checking(new Expectations() {
				{
					oneOf(mockGame).rollDice(fRSanity);
					will(returnValue(1));
				}
			});

			int expectedSanity = character.getCurrentSanityIndex();
			int expectedKnowledge = character.getCurrentKnowledgeIndex();
			maskCard.whatToDo(character);
			int sanityAfter = character.getCurrentSanityIndex();
			int knowledgeAfter = character.getCurrentKnowledgeIndex();
			assertEquals(sanityAfter, expectedSanity);
			assertEquals(knowledgeAfter, expectedKnowledge);

			mocks.assertIsSatisfied();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

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
		game.getInstance();
		Player player = new Player();
<<<<<<< HEAD
		Character character = new ExplorerType(ExplorerName.FatherRhinehardt, new Locale("en"));
=======
		Explorer character = new Explorer(Explorers.FatherRhinehardt,
				new Locale("en"));
>>>>>>> master
		player.addCharacter(character);
		game.addPlayer(player);
		game.addCharacter(character);

		int expectedSanity = character.getCurrentSanityIndex() + 1;
		int expectedKnowledge = character.getCurrentKnowledgeIndex() + 1;
		girlCard.whatToDo(character);
		int sanityAfter = character.getCurrentSanityIndex();
		int knowledgeAfter = character.getCurrentKnowledgeIndex();

		assertEquals(sanityAfter, expectedSanity);
		assertEquals(knowledgeAfter, expectedKnowledge);
	}

	@Test
	public void TestGirlIsLost() {
		game.getInstance();
		Player player = new Player();
<<<<<<< HEAD
		ExplorerType character = new ExplorerType(Explorers.FatherRhinehardt, new Locale("en"));
=======
		Explorer character = new Explorer(Explorers.FatherRhinehardt,
				new Locale("en"));
>>>>>>> master
		player.addCharacter(character);
		game.addPlayer(player);
		game.addCharacter(character);
		character.addOmenCard(girlCard);

		character.removeOmenCard(girlCard); // For testing purposes the card is
											// removed here.

		int expectedKnowledge = character.getCurrentKnowledgeIndex() - 1;
		int expectedSanity = character.getCurrentSanityIndex() - 1;
		((Girl) girlCard).isLost(character);
		int knowledgeAfter = character.getCurrentKnowledgeIndex();
		int sanityAfter = character.getCurrentSanityIndex();
		assertEquals(knowledgeAfter, expectedKnowledge);
		assertEquals(sanityAfter, expectedSanity);
	}

	@Test
	public void TestGirlIsNotLost() {
		game.getInstance();
		Player player = new Player();
<<<<<<< HEAD
		ExplorerType character = new ExplorerType(Explorers.FatherRhinehardt, new Locale("en"));
=======
		Explorer character = new Explorer(Explorers.FatherRhinehardt,
				new Locale("en"));
>>>>>>> master
		player.addCharacter(character);
		game.addPlayer(player);
		game.addCharacter(character);
		character.addOmenCard(girlCard);

		int expectedKnowledge = character.getCurrentKnowledgeIndex();
		int expectedSanity = character.getCurrentSanityIndex();
		((Girl) girlCard).isLost(character);
		int knowledgeAfter = character.getCurrentKnowledgeIndex();
		int sanityAfter = character.getCurrentSanityIndex();
		assertEquals(knowledgeAfter, expectedKnowledge);
		assertEquals(sanityAfter, expectedSanity);
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
	public void BiteInit() {
		biteCard.setName("Bite");
		biteCard.setQuote("A growl, the scent of death.Pain.Darkness.Gone.");
		assertEquals("Bite", biteCard.getName());
		assertEquals("A growl, the scent of death.Pain.Darkness.Gone.",
				biteCard.getQuote());
	}

	@Test
	public void TestWhatToDoBiteWin() {
		Mockery mocks = new Mockery() {
			{
				setImposteriser(ClassImposteriser.INSTANCE);
			}
		};
		final Game mockGame = mocks.mock(Game.class);
		try {
			Field instanceField = Game.class.getDeclaredField("INSTANCE");
			instanceField.setAccessible(true);
			instanceField.set(null, mockGame);

			final int fRMight = character.getCurrentMight();

			mocks.checking(new Expectations() {
				{
					oneOf(mockGame).rollDice(fRMight);
					will(returnValue(5));
				}
			});
			int expectedMight = character.getCurrentMightIndex();

			biteCard.whatToDo(character);
			int mightAfter = character.getCurrentMightIndex();
			assertEquals(mightAfter, expectedMight);

			mocks.assertIsSatisfied();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Test
	public void TestWhatToDoBiteLose() {
		Mockery mocks = new Mockery() {
			{
				setImposteriser(ClassImposteriser.INSTANCE);
			}
		};
		final Game mockGame = mocks.mock(Game.class);
		try {
			Field instanceField = Game.class.getDeclaredField("INSTANCE");
			instanceField.setAccessible(true);
			instanceField.set(null, mockGame);

			final int fRMight = character.getCurrentMight();

			mocks.checking(new Expectations() {
				{
					oneOf(mockGame).rollDice(fRMight);
					will(returnValue(3));
				}
			});
			int expectedMight = character.getCurrentMightIndex() - 1;

			biteCard.whatToDo(character);
			int mightAfter = character.getCurrentMightIndex();
			assertEquals(mightAfter, expectedMight);

			mocks.assertIsSatisfied();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
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
		game.getInstance();
		Player player = new Player();
<<<<<<< HEAD
		Character character = new ExplorerType(ExplorerName.FatherRhinehardt, new Locale("en"));
=======
		Explorer character = new Explorer(Explorers.FatherRhinehardt,
				new Locale("en"));
>>>>>>> master
		player.addCharacter(character);
		game.addPlayer(player);
		game.addCharacter(character);

		int expectedSanity = character.getCurrentSanityIndex() + 2;
		holySymbolCard.whatToDo(character);
		int sanityAfter = character.getCurrentSanityIndex();
		assertEquals(sanityAfter, expectedSanity);
	}

	@Test
	public void TestHolySymbolIstLost() {
		game.getInstance();
		Player player = new Player();
<<<<<<< HEAD
		ExplorerType character = new ExplorerType(Explorers.FatherRhinehardt, new Locale("en"));
=======
		Explorer character = new Explorer(Explorers.FatherRhinehardt,
				new Locale("en"));
>>>>>>> master
		player.addCharacter(character);
		game.addPlayer(player);
		game.addCharacter(character);
		character.addOmenCard(holySymbolCard);

		character.removeOmenCard(holySymbolCard);// For testing purposes, card
													// will be taken away here.

		int expectedSanity = character.getCurrentSanityIndex() - 2;
		((HolySymbol) holySymbolCard).isLost(character);
		int sanityAfter = character.getCurrentSanityIndex();
		assertEquals(sanityAfter, expectedSanity);

	}

	@Test
	public void TestHolySymbolIsNotLost() {
		game.getInstance();
		Player player = new Player();
<<<<<<< HEAD
		ExplorerType character = new ExplorerType(Explorers.FatherRhinehardt, new Locale("en"));
=======
		Explorer character = new Explorer(Explorers.FatherRhinehardt,
				new Locale("en"));
>>>>>>> master
		player.addCharacter(character);
		game.addPlayer(player);
		game.addCharacter(character);
		character.addOmenCard(holySymbolCard);

		int expectedSanity = character.getCurrentSanityIndex();
		((HolySymbol) holySymbolCard).isLost(character);
		int sanityAfter = character.getCurrentSanityIndex();
		assertEquals(sanityAfter, expectedSanity);

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
		game.getInstance();
		Player player = new Player();
<<<<<<< HEAD
		ExplorerType character = new ExplorerType(Explorers.FatherRhinehardt, new Locale("en"));
=======
		Explorer character = new Explorer(Explorers.FatherRhinehardt,
				new Locale("en"));
>>>>>>> master
		player.addCharacter(character);
		game.addPlayer(player);
		game.addCharacter(character);

		int expectedMight = character.getCurrentMightIndex() + 1;
		int expectedSanity = character.getCurrentSanityIndex() + 1;
		dogCard.whatToDo(character);
		int mightAfter = character.getCurrentMightIndex();
		int sanityAfter = character.getCurrentSanityIndex();
		assertEquals(sanityAfter, expectedSanity);
		assertEquals(mightAfter, expectedMight);
	}

	@Test
	public void TestDogIsLost() {
		game.getInstance();
		Player player = new Player();
<<<<<<< HEAD
		ExplorerType character = new ExplorerType(Explorers.FatherRhinehardt, new Locale("en"));
=======
		Explorer character = new Explorer(Explorers.FatherRhinehardt,
				new Locale("en"));
>>>>>>> master
		player.addCharacter(character);
		game.addPlayer(player);
		game.addCharacter(character);
		character.addOmenCard(dogCard);

		character.removeOmenCard(dogCard); // For testing purposes it is removed
											// here.

		int expectedMight = character.getCurrentMightIndex() - 1;
		int expectedSanity = character.getCurrentSanityIndex() - 1;
		((Dog) dogCard).isLost(character);
		int mightAfter = character.getCurrentMightIndex();
		int sanityAfter = character.getCurrentSanityIndex();
		assertEquals(mightAfter, expectedMight);
		assertEquals(sanityAfter, expectedSanity);
	}

	@Test
	public void TestDogIsNotLost() {
		game.getInstance();
		Player player = new Player();
<<<<<<< HEAD
		ExplorerType character = new ExplorerType(Explorers.FatherRhinehardt, new Locale("en"));
=======
		Explorer character = new Explorer(Explorers.FatherRhinehardt,
				new Locale("en"));
>>>>>>> master
		player.addCharacter(character);
		game.addPlayer(player);
		game.addCharacter(character);
		character.addOmenCard(dogCard);

		int expectedMight = character.getCurrentMightIndex();
		int expectedSanity = character.getCurrentSanityIndex();
		((Dog) dogCard).isLost(character);
		int mightAfter = character.getCurrentMightIndex();
		int sanityAfter = character.getCurrentSanityIndex();
		assertEquals(mightAfter, expectedMight);
		assertEquals(sanityAfter, expectedSanity);
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
