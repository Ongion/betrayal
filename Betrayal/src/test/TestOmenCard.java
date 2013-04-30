package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import itemCards.AngelFeather;
import itemCards.ItemCard;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

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

import Game.Game;
import Game.Player;
import characters.ExplorerFactory;
import characters.Character;
import characters.HumanStats;
import eventCards.AngryBeing;
import eventCards.CreepyCrawlies;
import eventCards.EventCard;
import eventCards.NightView;
import eventCards.Rotten;
import characters.Character.Character_Name;

public class TestOmenCard {

	private Locale enLocale = new Locale("en", "US");
	private Locale spLocale = new Locale("es", "ES");
	
	private ResourceBundle mesEN = ResourceBundle.getBundle("OmenCardBundle", enLocale);
	private ResourceBundle mesSP = ResourceBundle.getBundle("OmenCardBundle", spLocale);
	
	private ExplorerFactory explorers = new ExplorerFactory();
	private Character character;
	private Player player = new Player();

	private Game game;

	private OmenCard crystalBallCard = new CrystalBall(enLocale);
	private OmenCard bookCard = new Book(enLocale);
	private OmenCard ringCard = new Ring(enLocale);
	private OmenCard madmanCard = new Madman(enLocale);
	private OmenCard spearCard = new Spear(enLocale);
	private OmenCard spiritBoardCard = new SpiritBoard(enLocale);
	private Mask maskCard = new Mask(enLocale);
	private OmenCard medallionCard = new Medallion(enLocale);
	private OmenCard girlCard = new Girl(enLocale);
	private OmenCard biteCard = new Bite(enLocale);
	private OmenCard skullCard = new Skull(enLocale);
	private OmenCard holySymbolCard = new HolySymbol(enLocale);
	private OmenCard dogCard = new Dog(enLocale);

	private ArrayList<EventCard> events = new ArrayList<EventCard>();
	private ArrayList<ItemCard> items = new ArrayList<ItemCard>();
	private ArrayList<OmenCard> omens = new ArrayList<OmenCard>();
	private ArrayList<Player> players = new ArrayList<Player>();
	private EventCard angryBeing = new AngryBeing(enLocale);
	private EventCard creepyCrawlies = new CreepyCrawlies(enLocale);
	private EventCard nightView = new NightView(enLocale);
	private EventCard rotten = new Rotten(enLocale);
	private ItemCard angelFeather = new AngelFeather(enLocale);

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
		OmenCard card = new Book(enLocale);
		assertEquals(game.getIsHaunt(), card.isHauntRoll());
	}

	@Test
	public void TestMakeHauntRollForOmenCard() {
		OmenCard card = new Book(enLocale);
		assertFalse(card.makeHauntRoll());
		game.setIsHaunt(true);
		if (card.isHauntRoll()) {
			assertTrue(card.makeHauntRoll());
		}
	}

	@Test
	public void CrystalBallOmenInit() {
		crystalBallCard.setName("Crystal Ball");
		crystalBallCard.setDescription("Hazy images appear in the glass.");
		assertEquals("Crystal Ball", crystalBallCard.getName());
		assertEquals("Hazy images appear in the glass.",
				crystalBallCard.getDescription());
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

			int sanityBefore = ((HumanStats) (character.getStats())).getCurrentSanityIndex() - 1;
			crystalBallCard.whatToDo(character);
			int sanityAfter = ((HumanStats) (character.getStats())).getCurrentSanityIndex();
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

			int sanityBefore = ((HumanStats) (character.getStats())).getCurrentSanityIndex() - 2;
			crystalBallCard.whatToDo(character);
			int sanityAfter = ((HumanStats) (character.getStats())).getCurrentSanityIndex();
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
			crystalBallCard.itemOrEvent = 1;
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
		ExplorerFactory expFac = new ExplorerFactory();
		Character character = expFac.getExplorer(Character_Name.FatherRhinehardt);
		player.addCharacter(character);
		game.addPlayer(player);
		game.addCharacter(character);

		int expectedKnowledge = ((HumanStats) (character.getStats())).getCurrentKnowledgeIndex() + 2;
		bookCard.whatToDo(character);
		int knowledgeAfter = ((HumanStats) (character.getStats())).getCurrentKnowledgeIndex();
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
		assertEquals(mesEN.getString("titleBook"), bookCard.getName());
		assertEquals(mesEN.getString("desBook"), bookCard.getDescription());
		assertEquals(mesEN.getString("rulesBook"), bookCard.getRules());
		
		bookCard = new Book(spLocale);
		assertEquals(mesSP.getString("titleBook"), bookCard.getName());
		assertEquals(mesSP.getString("desBook"), bookCard.getDescription());
		assertEquals(mesSP.getString("rulesBook"), bookCard.getRules());
		
		bookCard.setName("Book");
		bookCard.setDescription("A diary or lab notes? Ancient script or modern ravings?");
		bookCard.setRules("Testing rules");
		assertEquals("Book", bookCard.getName());
		assertEquals("A diary or lab notes? Ancient script or modern ravings?",
				bookCard.getDescription());
		assertEquals("Testing rules", bookCard.getRules());
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
		assertEquals(mesEN.getString("titleRing"), ringCard.getName());
		assertEquals(mesEN.getString("desRing"), ringCard.getDescription());
		assertEquals(mesEN.getString("rulesRing"), ringCard.getRules());
		
		ringCard = new Ring(spLocale);
		assertEquals(mesSP.getString("titleRing"), ringCard.getName());
		assertEquals(mesSP.getString("desRing"), ringCard.getDescription());
		assertEquals(mesSP.getString("rulesRing"), ringCard.getRules());
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
		
		ExplorerFactory expFac = new ExplorerFactory();
		Character character = expFac.getExplorer(Character_Name.FatherRhinehardt);
		
		player.addCharacter(character);
		game.addPlayer(player);
		game.addCharacter(character);

		int expectedMight = ((HumanStats) character.getStats()).getCurrentMightIndex() + 2;
		int expectedSanity = ((HumanStats) character.getStats()).getCurrentSanityIndex() - 1;
		madmanCard.whatToDo(character);
		int mightAfter = ((HumanStats) character.getStats()).getCurrentMightIndex();
		int sanityAfter = ((HumanStats) character.getStats()).getCurrentSanityIndex();
		assertEquals(mightAfter, expectedMight);
		assertEquals(sanityAfter, expectedSanity);

	}

	@Test
	public void TestMadmanIsLost() {
		game.getInstance();
		Player player = new Player();

		ExplorerFactory expFac = new ExplorerFactory();
		Character character = expFac.getExplorer(Character_Name.FatherRhinehardt);
		
		player.addCharacter(character);
		game.addPlayer(player);
		game.addCharacter(character);
		character.addOmenCard(madmanCard);

		character.removeOmenCard(madmanCard); // For testing purposes the card
												// is removed here.

		int expectedMight = ((HumanStats) character.getStats()).getCurrentMightIndex() - 2;
		int expectedSanity = ((HumanStats) character.getStats()).getCurrentSanityIndex() + 1;
		((Madman) madmanCard).isLost(character);
		int mightAfter = ((HumanStats) character.getStats()).getCurrentMightIndex();
		int sanityAfter = ((HumanStats) character.getStats()).getCurrentSanityIndex();
		assertEquals(mightAfter, expectedMight);
		assertEquals(sanityAfter, expectedSanity);
	}

	@Test
	public void TestMadmanIsNotLost() {
		game.getInstance();
		Player player = new Player();
		
		ExplorerFactory expFac = new ExplorerFactory();
		Character character = expFac.getExplorer(Character_Name.FatherRhinehardt);
		
		player.addCharacter(character);
		game.addPlayer(player);
		game.addCharacter(character);
		character.addOmenCard(madmanCard);

		int expectedMight = ((HumanStats) character.getStats()).getCurrentMightIndex();
		int expectedSanity = ((HumanStats) character.getStats()).getCurrentSanityIndex();
		((Madman) madmanCard).isLost(character);
		int mightAfter = ((HumanStats) character.getStats()).getCurrentMightIndex();
		int sanityAfter = ((HumanStats) character.getStats()).getCurrentSanityIndex();
		assertEquals(mightAfter, expectedMight);
		assertEquals(sanityAfter, expectedSanity);
	}


	@Test
	public void MadmanInit() {
		assertEquals(mesEN.getString("titleMadman"), madmanCard.getName());
		assertEquals(mesEN.getString("desMadman"), madmanCard.getDescription());
		assertEquals(mesEN.getString("rulesMadman"), madmanCard.getRules());
		
		madmanCard = new Madman(spLocale);
		assertEquals(mesSP.getString("titleMadman"), madmanCard.getName());
		assertEquals(mesSP.getString("desMadman"), madmanCard.getDescription());
		assertEquals(mesSP.getString("rulesMadman"), madmanCard.getRules());
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
		assertEquals(mesEN.getString("titleSpear"), spearCard.getName());
		assertEquals(mesEN.getString("desSpear"), spearCard.getDescription());
		assertEquals(mesEN.getString("rulesSpear"), spearCard.getRules());
		
		spearCard = new Spear(spLocale);
		assertEquals(mesSP.getString("titleSpear"), spearCard.getName());
		assertEquals(mesSP.getString("desSpear"), spearCard.getDescription());
		assertEquals(mesSP.getString("rulesSpear"), spearCard.getRules());
	}

	@Test
	public void SpiritBoardInit() {
		assertEquals(mesEN.getString("titleSpiritBoard"), spiritBoardCard.getName());
		assertEquals(mesEN.getString("desSpiritBoard"), spiritBoardCard.getDescription());
		assertEquals(mesEN.getString("rulesSpiritBoard"), spiritBoardCard.getRules());
		
		spiritBoardCard = new SpiritBoard(spLocale);
		assertEquals(mesSP.getString("titleSpiritBoard"), spiritBoardCard.getName());
		assertEquals(mesSP.getString("desSpiritBoard"), spiritBoardCard.getDescription());
		assertEquals(mesSP.getString("rulesSpiritBoard"), spiritBoardCard.getRules());
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
		assertEquals(mesEN.getString("titleMask"), maskCard.getName());
		assertEquals(mesEN.getString("desMask"), maskCard.getDescription());
		assertEquals(mesEN.getString("rulesMask"), maskCard.getRules());
		
		maskCard = new Mask(spLocale);
		assertEquals(mesSP.getString("titleMask"), maskCard.getName());
		assertEquals(mesSP.getString("desMask"), maskCard.getDescription());
		assertEquals(mesSP.getString("rulesMask"), maskCard.getRules());
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
			int expectedSanity = ((HumanStats) character.getStats()).getCurrentSanityIndex() - 2;
			int expectedKnowledge = ((HumanStats) character.getStats()).getCurrentKnowledgeIndex() + 2;

			maskCard.isMaskOn = true;
			maskCard.whatToDo(character);
			int sanityAfter = ((HumanStats) character.getStats()).getCurrentSanityIndex();
			int knowledgeAfter = ((HumanStats) character.getStats()).getCurrentKnowledgeIndex();
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
			int expectedSanity2 = ((HumanStats) character.getStats()).getCurrentSanityIndex() + 2;
			int expectedKnowledge2 = ((HumanStats) character.getStats()).getCurrentKnowledgeIndex() - 2;

			maskCard.isMaskOn = false;
			maskCard.whatToDo(character);
			int sanityAfter2 = ((HumanStats) character.getStats()).getCurrentSanityIndex();
			int knowledgeAfter2 = ((HumanStats) character.getStats()).getCurrentKnowledgeIndex();
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

			int expectedSanity = ((HumanStats) character.getStats()).getCurrentSanityIndex();
			int expectedKnowledge = ((HumanStats) character.getStats()).getCurrentKnowledgeIndex();
			maskCard.whatToDo(character);
			int sanityAfter = ((HumanStats) character.getStats()).getCurrentSanityIndex();
			int knowledgeAfter = ((HumanStats) character.getStats()).getCurrentKnowledgeIndex();
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
		assertEquals(mesEN.getString("titleMedallion"), medallionCard.getName());
		assertEquals(mesEN.getString("desMedallion"), medallionCard.getDescription());
		assertEquals(mesEN.getString("rulesMedallion"), medallionCard.getRules());
		
		medallionCard = new Medallion(spLocale);
		assertEquals(mesSP.getString("titleMedallion"), medallionCard.getName());
		assertEquals(mesSP.getString("desMedallion"), medallionCard.getDescription());
		assertEquals(mesSP.getString("rulesMedallion"), medallionCard.getRules());
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
		
		ExplorerFactory expFac = new ExplorerFactory();
		Character character = expFac.getExplorer(Character_Name.FatherRhinehardt);
		
		player.addCharacter(character);
		game.addPlayer(player);
		game.addCharacter(character);

		int expectedSanity = ((HumanStats) character.getStats()).getCurrentSanityIndex() + 1;
		int expectedKnowledge = ((HumanStats) character.getStats()).getCurrentKnowledgeIndex() + 1;
		girlCard.whatToDo(character);
		int sanityAfter = ((HumanStats) character.getStats()).getCurrentSanityIndex();
		int knowledgeAfter = ((HumanStats) character.getStats()).getCurrentKnowledgeIndex();

		assertEquals(sanityAfter, expectedSanity);
		assertEquals(knowledgeAfter, expectedKnowledge);
	}

	@Test
	public void TestGirlIsLost() {
		game.getInstance();
		Player player = new Player();

		ExplorerFactory expFac = new ExplorerFactory();
		Character character = expFac.getExplorer(Character_Name.FatherRhinehardt);
		
		player.addCharacter(character);
		game.addPlayer(player);
		game.addCharacter(character);
		character.addOmenCard(girlCard);

		character.removeOmenCard(girlCard); // For testing purposes the card is
											// removed here.

		int expectedKnowledge = ((HumanStats) character.getStats()).getCurrentKnowledgeIndex() - 1;
		int expectedSanity = ((HumanStats) character.getStats()).getCurrentSanityIndex() - 1;
		((Girl) girlCard).isLost(character);
		int knowledgeAfter = ((HumanStats) character.getStats()).getCurrentKnowledgeIndex();
		int sanityAfter = ((HumanStats) character.getStats()).getCurrentSanityIndex();
		assertEquals(knowledgeAfter, expectedKnowledge);
		assertEquals(sanityAfter, expectedSanity);
	}

	@Test
	public void TestGirlIsNotLost() {
		game.getInstance();
		Player player = new Player();

		ExplorerFactory expFac = new ExplorerFactory();
		Character character = expFac.getExplorer(Character_Name.FatherRhinehardt);
		
		player.addCharacter(character);
		game.addPlayer(player);
		game.addCharacter(character);
		character.addOmenCard(girlCard);

		int expectedKnowledge = ((HumanStats) character.getStats()).getCurrentKnowledgeIndex();
		int expectedSanity = ((HumanStats) character.getStats()).getCurrentSanityIndex();
		((Girl) girlCard).isLost(character);
		int knowledgeAfter = ((HumanStats) character.getStats()).getCurrentKnowledgeIndex();
		int sanityAfter = ((HumanStats) character.getStats()).getCurrentSanityIndex();
		assertEquals(knowledgeAfter, expectedKnowledge);
		assertEquals(sanityAfter, expectedSanity);
	}

	@Test
	public void GirlInit() {
		assertEquals(mesEN.getString("titleGirl"), girlCard.getName());
		assertEquals(mesEN.getString("desGirl"), girlCard.getDescription());
		assertEquals(mesEN.getString("rulesGirl"), girlCard.getRules());
		
		girlCard = new Girl(spLocale);
		assertEquals(mesSP.getString("titleGirl"), girlCard.getName());
		assertEquals(mesSP.getString("desGirl"), girlCard.getDescription());
		assertEquals(mesSP.getString("rulesGirl"), girlCard.getRules());
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
		assertEquals(mesEN.getString("titleBite"), biteCard.getName());
		assertEquals(mesEN.getString("desBite"), biteCard.getDescription());
		assertEquals(mesEN.getString("rulesBite"), biteCard.getRules());
		
		biteCard = new Bite(spLocale);
		assertEquals(mesSP.getString("titleBite"), biteCard.getName());
		assertEquals(mesSP.getString("desBite"), biteCard.getDescription());
		assertEquals(mesSP.getString("rulesBite"), biteCard.getRules());
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
			int expectedMight = ((HumanStats) character.getStats()).getCurrentMightIndex();

			biteCard.whatToDo(character);
			int mightAfter = ((HumanStats) character.getStats()).getCurrentMightIndex();
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
			int expectedMight = ((HumanStats) character.getStats()).getCurrentMightIndex() - 1;

			biteCard.whatToDo(character);
			int mightAfter = ((HumanStats) character.getStats()).getCurrentMightIndex();
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
		assertEquals(mesEN.getString("titleSkull"), skullCard.getName());
		assertEquals(mesEN.getString("desSkull"), skullCard.getDescription());
		assertEquals(mesEN.getString("rulesSkull"), skullCard.getRules());
		
		skullCard = new Skull(spLocale);
		assertEquals(mesSP.getString("titleSkull"), skullCard.getName());
		assertEquals(mesSP.getString("desSkull"), skullCard.getDescription());
		assertEquals(mesSP.getString("rulesSkull"), skullCard.getRules());
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

		ExplorerFactory expFac = new ExplorerFactory();
		Character character = expFac.getExplorer(Character_Name.FatherRhinehardt);
		
		player.addCharacter(character);
		game.addPlayer(player);
		game.addCharacter(character);

		int expectedSanity = ((HumanStats) character.getStats()).getCurrentSanityIndex() + 2;
		holySymbolCard.whatToDo(character);
		int sanityAfter = ((HumanStats) character.getStats()).getCurrentSanityIndex();
		assertEquals(sanityAfter, expectedSanity);
	}

	@Test
	public void TestHolySymbolIstLost() {
		game.getInstance();
		Player player = new Player();
		
		ExplorerFactory expFac = new ExplorerFactory();
		Character character = expFac.getExplorer(Character_Name.FatherRhinehardt);
		
		player.addCharacter(character);
		game.addPlayer(player);
		game.addCharacter(character);
		character.addOmenCard(holySymbolCard);

		character.removeOmenCard(holySymbolCard);// For testing purposes, card
													// will be taken away here.

		int expectedSanity = ((HumanStats) character.getStats()).getCurrentSanityIndex() - 2;
		((HolySymbol) holySymbolCard).isLost(character);
		int sanityAfter = ((HumanStats) character.getStats()).getCurrentSanityIndex();
		assertEquals(sanityAfter, expectedSanity);

	}

	@Test
	public void TestHolySymbolIsNotLost() {
		game.getInstance();
		Player player = new Player();

		ExplorerFactory expFac = new ExplorerFactory();
		Character character = expFac.getExplorer(Character_Name.FatherRhinehardt);
		
		player.addCharacter(character);
		game.addPlayer(player);
		game.addCharacter(character);
		character.addOmenCard(holySymbolCard);

		int expectedSanity = ((HumanStats) character.getStats()).getCurrentSanityIndex();
		((HolySymbol) holySymbolCard).isLost(character);
		int sanityAfter = ((HumanStats) character.getStats()).getCurrentSanityIndex();
		assertEquals(sanityAfter, expectedSanity);

	}

	@Test
	public void HolySymbolInit() {
		assertEquals(mesEN.getString("titleHolySymbol"), holySymbolCard.getName());
		assertEquals(mesEN.getString("desHolySymbol"), holySymbolCard.getDescription());
		assertEquals(mesEN.getString("rulesHolySymbol"), holySymbolCard.getRules());
		
		holySymbolCard = new HolySymbol(spLocale);
		assertEquals(mesSP.getString("titleHolySymbol"), holySymbolCard.getName());
		assertEquals(mesSP.getString("desHolySymbol"), holySymbolCard.getDescription());
		assertEquals(mesSP.getString("rulesHolySymbol"), holySymbolCard.getRules());
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

		ExplorerFactory expFac = new ExplorerFactory();
		Character character = expFac.getExplorer(Character_Name.FatherRhinehardt);
		
		player.addCharacter(character);
		game.addPlayer(player);
		game.addCharacter(character);

		int expectedMight = ((HumanStats) character.getStats()).getCurrentMightIndex() + 1;
		int expectedSanity = ((HumanStats) character.getStats()).getCurrentSanityIndex() + 1;
		dogCard.whatToDo(character);
		int mightAfter = ((HumanStats) character.getStats()).getCurrentMightIndex();
		int sanityAfter = ((HumanStats) character.getStats()).getCurrentSanityIndex();
		assertEquals(sanityAfter, expectedSanity);
		assertEquals(mightAfter, expectedMight);
	}

	@Test
	public void TestDogIsLost() {
		game.getInstance();
		Player player = new Player();

		ExplorerFactory expFac = new ExplorerFactory();
		Character character = expFac.getExplorer(Character_Name.FatherRhinehardt);
		
		player.addCharacter(character);
		game.addPlayer(player);
		game.addCharacter(character);
		character.addOmenCard(dogCard);

		character.removeOmenCard(dogCard); // For testing purposes it is removed
											// here.

		int expectedMight = ((HumanStats) character.getStats()).getCurrentMightIndex() - 1;
		int expectedSanity = ((HumanStats) character.getStats()).getCurrentSanityIndex() - 1;
		((Dog) dogCard).isLost(character);
		int mightAfter = ((HumanStats) character.getStats()).getCurrentMightIndex();
		int sanityAfter = ((HumanStats) character.getStats()).getCurrentSanityIndex();
		assertEquals(mightAfter, expectedMight);
		assertEquals(sanityAfter, expectedSanity);
	}

	@Test
	public void TestDogIsNotLost() {
		game.getInstance();
		Player player = new Player();

		ExplorerFactory expFac = new ExplorerFactory();
		Character character = expFac.getExplorer(Character_Name.FatherRhinehardt);
		
		player.addCharacter(character);
		game.addPlayer(player);
		game.addCharacter(character);
		character.addOmenCard(dogCard);

		int expectedMight = ((HumanStats) character.getStats()).getCurrentMightIndex();
		int expectedSanity = ((HumanStats) character.getStats()).getCurrentSanityIndex();
		((Dog) dogCard).isLost(character);
		int mightAfter = ((HumanStats) character.getStats()).getCurrentMightIndex();
		int sanityAfter = ((HumanStats) character.getStats()).getCurrentSanityIndex();
		assertEquals(mightAfter, expectedMight);
		assertEquals(sanityAfter, expectedSanity);
	}

	@Test
	public void DogInit() {
		assertEquals(mesEN.getString("titleDog"), dogCard.getName());
		assertEquals(mesEN.getString("desDog"), dogCard.getDescription());
		assertEquals(mesEN.getString("rulesDog"), dogCard.getRules());
		
		dogCard = new Dog(spLocale);
		assertEquals(mesSP.getString("titleDog"), dogCard.getName());
		assertEquals(mesSP.getString("desDog"), dogCard.getDescription());
		assertEquals(mesSP.getString("rulesDog"), dogCard.getRules());

	}


}
