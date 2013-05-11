package test;

import static org.junit.Assert.*;
import itemCards.AdrenalineShot;
import itemCards.AmuletOfAges;
import itemCards.AngelFeather;
import itemCards.Armor;
import itemCards.Axe;
import itemCards.Bell;
import itemCards.BloodDagger;
import itemCards.Bottle;
import itemCards.Candle;
import itemCards.DarkDice;
import itemCards.Dynamite;
import itemCards.HealingSalve;
import itemCards.Idol;
import itemCards.ItemCard;
import itemCards.LuckyStone;
import itemCards.MedicalKit;
import itemCards.MusicBox;
import itemCards.PickpocketsGloves;
import itemCards.PuzzleBox;
import itemCards.RabbitsFoot;
import itemCards.Revolver;
import itemCards.SacrificialDagger;
import itemCards.SmellingSalts;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

import omenCards.Book;
import omenCards.CrystalBall;
import omenCards.OmenCard;
import omenCards.Ring;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Game.Game;
import Game.Player;
import characters.Character;
import characters.Character.Character_Name;
import characters.ExplorerFactory;
import characters.HumanStats;
import eventCards.AngryBeing;
import eventCards.CreepyCrawlies;
import eventCards.EventCard;
import eventCards.NightView;
import eventCards.Rotten;

public class TestItemCard {

	private Locale enLocale = new Locale("en", "US");
	private Locale spLocale = new Locale("es", "ES");

	private ResourceBundle mesEN = ResourceBundle.getBundle("ItemCardBundle",
			enLocale);
	private ResourceBundle mesSP = ResourceBundle.getBundle("ItemCardBundle",
			spLocale);

	private ExplorerFactory explorers = new ExplorerFactory();
	private Character character;
	private Player player = new Player();

	private Game game;

	private ItemCard angelFeatherCard = new AngelFeather(enLocale);
	private ItemCard adrenalineShotCard = new AdrenalineShot(enLocale);
	private ItemCard revolverCard = new Revolver(enLocale);
	private ItemCard puzzleBoxCard = new PuzzleBox(enLocale);
	private ItemCard rabbitsFootCard = new RabbitsFoot(enLocale);
	private ItemCard medicalKitCard = new MedicalKit(enLocale);
	private ItemCard bottleCard = new Bottle(enLocale);
	private ItemCard luckyStoneCard = new LuckyStone(enLocale);
	private ItemCard sacrificialDaggerCard = new SacrificialDagger(enLocale);
	private ItemCard musicBoxCard = new MusicBox(enLocale);
	private ItemCard bellCard = new Bell(enLocale);
	private ItemCard healingSalveCard = new HealingSalve(enLocale);
	private ItemCard armorCard = new Armor(enLocale);
	private ItemCard amuletOfAgesCard = new AmuletOfAges(enLocale);
	private ItemCard candleCard = new Candle(enLocale);
	private ItemCard dynamiteCard = new Dynamite(enLocale);
	private ItemCard pickpocketCard = new PickpocketsGloves(enLocale);
	private ItemCard axeCard = new Axe(enLocale);
	private ItemCard smellingSaltsCard = new SmellingSalts(enLocale);
	private ItemCard darkDiceCard = new DarkDice(enLocale);
	private ItemCard bloodDaggerCard = new BloodDagger(enLocale);
	private ItemCard idolCard = new Idol(enLocale);

	private OmenCard crystalBallCard = new CrystalBall(enLocale);
	private OmenCard bookCard = new Book(enLocale);
	private OmenCard ringCard = new Ring(enLocale);

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
	public void TestAngelFeatherInit() {
		assertEquals(mesEN.getString("titleAngelFeather"),
				angelFeatherCard.getName());
		assertEquals(mesEN.getString("desAngelFeather"),
				angelFeatherCard.getDescription());
		assertEquals(mesEN.getString("detailAngelFeather"),
				angelFeatherCard.getDetails());

		angelFeatherCard.setName("Angel Feather");
		angelFeatherCard
				.setDescription("A perfect feather fluttering in your hand.");
		assertEquals("Angel Feather", angelFeatherCard.getName());
		assertEquals("A perfect feather fluttering in your hand.",
				angelFeatherCard.getDescription());

		angelFeatherCard = new AngelFeather(spLocale);
		assertEquals(mesSP.getString("titleAngelFeather"),
				angelFeatherCard.getName());
		assertEquals(mesSP.getString("desAngelFeather"),
				angelFeatherCard.getDescription());
		assertEquals(mesSP.getString("detailAngelFeather"),
				angelFeatherCard.getDetails());
	}

	@Test
	public void TestAdrenalineShotInit() {
		assertEquals(mesEN.getString("titleAdrenalineShot"),
				adrenalineShotCard.getName());
		assertEquals(mesEN.getString("desAdrenalineShot"),
				adrenalineShotCard.getDescription());
		assertEquals(mesEN.getString("detailAdrenalineShot"),
				adrenalineShotCard.getDetails());

		adrenalineShotCard = new AdrenalineShot(spLocale);
		assertEquals(mesSP.getString("titleAdrenalineShot"),
				adrenalineShotCard.getName());
		assertEquals(mesSP.getString("desAdrenalineShot"),
				adrenalineShotCard.getDescription());
		assertEquals(mesSP.getString("detailAdrenalineShot"),
				adrenalineShotCard.getDetails());

		adrenalineShotCard.setName("Adrenaline Shot");
		adrenalineShotCard
				.setDescription("A syringe containing a strange fluorescent liquid.");
		assertEquals("Adrenaline Shot", adrenalineShotCard.getName());
		assertEquals("A syringe containing a strange fluorescent liquid.",
				adrenalineShotCard.getDescription());
	}

	@Test
	public void TestRevolverInit() {
		assertEquals(mesEN.getString("titleRevolver"), revolverCard.getName());
		assertEquals(mesEN.getString("desRevolver"),
				revolverCard.getDescription());
		assertEquals(mesEN.getString("detailRevolver"),
				revolverCard.getDetails());

		revolverCard = new Revolver(spLocale);
		assertEquals(mesSP.getString("titleRevolver"), revolverCard.getName());
		assertEquals(mesSP.getString("desRevolver"),
				revolverCard.getDescription());
		assertEquals(mesSP.getString("detailRevolver"),
				revolverCard.getDetails());

		revolverCard.setName("Revolver");
		revolverCard.setDescription("WEAPON An old, potent-looking weapon.");
		assertEquals("Revolver", revolverCard.getName());
		assertEquals("WEAPON An old, potent-looking weapon.",
				revolverCard.getDescription());
	}

	@Test
	public void TestWhatToDoForRevolverForCorrectNumRolls() {
		assertEquals(revolverCard.numRolls, 2);
	}

	@Test
	public void TestNoDamageIsTakenIfLoseAttackAgainstPlayerInOtherRoom() {
		// some kind of mock here
	}

	@Test
	public void TestPuzzleBoxInit() {
		assertEquals(mesEN.getString("titlePuzzleBox"), puzzleBoxCard.getName());
		assertEquals(mesEN.getString("desPuzzleBox"),
				puzzleBoxCard.getDescription());
		assertEquals(mesEN.getString("detailPuzzleBox"),
				puzzleBoxCard.getDetails());

		puzzleBoxCard = new PuzzleBox(spLocale);
		assertEquals(mesSP.getString("titlePuzzleBox"), puzzleBoxCard.getName());
		assertEquals(mesSP.getString("desPuzzleBox"),
				puzzleBoxCard.getDescription());
		assertEquals(mesSP.getString("detailPuzzleBox"),
				puzzleBoxCard.getDetails());

		puzzleBoxCard.setName("Puzzle Box");
		puzzleBoxCard.setDescription("There must be a way to open it.");
		assertEquals("Puzzle Box", puzzleBoxCard.getName());
		assertEquals("There must be a way to open it.",
				puzzleBoxCard.getDescription());
	}

	@Test
	public void TestWhatToDoForPuzzleBoxDieRollGreaterThanSix() {
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
					will(returnValue(7));

				}
			});

			ArrayList<ItemCard> expectedItemHand = character.getItemHand();
			expectedItemHand.add(bellCard);
			expectedItemHand.add(candleCard);

			puzzleBoxCard.whatToDo(character);
			ArrayList<ItemCard> itemHandAfter = character.getItemHand();
			assertEquals(expectedItemHand, itemHandAfter);

			mocks.assertIsSatisfied();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Test
	public void TestWhatToDoForPuzzleBoxForDiscardedCard() {

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
					will(returnValue(7));

				}
			});

			puzzleBoxCard.whatToDo(character);
			assertFalse(character.getItemHand().contains(puzzleBoxCard));

			mocks.assertIsSatisfied();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Test
	public void TestRabbitsFootInit() {
		assertEquals(mesEN.getString("titleRabbitsFoot"),
				rabbitsFootCard.getName());
		assertEquals(mesEN.getString("desRabbitsFoot"),
				rabbitsFootCard.getDescription());
		assertEquals(mesEN.getString("detailRabbitsFoot"),
				rabbitsFootCard.getDetails());

		rabbitsFootCard = new RabbitsFoot(spLocale);
		assertEquals(mesSP.getString("titleRabbitsFoot"),
				rabbitsFootCard.getName());
		assertEquals(mesSP.getString("desRabbitsFoot"),
				rabbitsFootCard.getDescription());
		assertEquals(mesSP.getString("detailRabbitsFoot"),
				rabbitsFootCard.getDetails());

		rabbitsFootCard.setName("Rabbit's Foot");
		rabbitsFootCard.setDescription("Not so lucky for the rabbit.");
		assertEquals("Rabbit's Foot", rabbitsFootCard.getName());
		assertEquals("Not so lucky for the rabbit.",
				rabbitsFootCard.getDescription());
	}

	@Test
	public void TestWhatToDoForRabbitsFootForCorrectNumRolls() {
		assertEquals(rabbitsFootCard.numRolls, 2);
	}

	@Test
	public void TestWhatToDoForRabbitsFootKeepsSecondRoll() {
		// some kind of mock here
	}

	@Test
	public void TestMedicalKitInit() {
		assertEquals(mesEN.getString("titleMedicalKit"),
				medicalKitCard.getName());
		assertEquals(mesEN.getString("desMedicalKit"),
				medicalKitCard.getDescription());
		assertEquals(mesEN.getString("detailMedicalKit"),
				medicalKitCard.getDetails());

		medicalKitCard = new MedicalKit(spLocale);
		assertEquals(mesSP.getString("titleMedicalKit"),
				medicalKitCard.getName());
		assertEquals(mesSP.getString("desMedicalKit"),
				medicalKitCard.getDescription());
		assertEquals(mesSP.getString("detailMedicalKit"),
				medicalKitCard.getDetails());

		medicalKitCard.setName("Medical Kit");
		medicalKitCard
				.setDescription("A doctor's bag, depleted in some critical resources.");
		assertEquals("Medical Kit", medicalKitCard.getName());
		assertEquals("A doctor's bag, depleted in some critical resources.",
				medicalKitCard.getDescription());
	}

	@Test
	public void TestWhatToDoForMedicalKitKnowledgeRollGreaterThanEight() {
		// mock
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
					will(returnValue(9));
				}
			});

			int expectedMight = ((HumanStats) (character.getStats()))
					.getCurrentMightIndex() + 3;
			medicalKitCard.whatToDo(character);
			int mightAfter = ((HumanStats) (character.getStats()))
					.getCurrentMightIndex();
			assertEquals(mightAfter, expectedMight);

			mocks.assertIsSatisfied();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Test
	public void TestWhatToDoForMedicalKitKnowledgeRollSixOrSeven() {
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
					will(returnValue(7));
				}
			});

			int expectedMight = ((HumanStats) (character.getStats()))
					.getCurrentMightIndex() + 2;
			medicalKitCard.whatToDo(character);
			int mightAfter = ((HumanStats) (character.getStats()))
					.getCurrentMightIndex();
			assertEquals(mightAfter, expectedMight);

			mocks.assertIsSatisfied();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Test
	public void TestWhatToDoForMedicalKitKnowledgeRollFourOrFive() {
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
					will(returnValue(4));
				}
			});

			int expectedMight = ((HumanStats) (character.getStats()))
					.getCurrentMightIndex() + 1;
			medicalKitCard.whatToDo(character);
			int mightAfter = ((HumanStats) (character.getStats()))
					.getCurrentMightIndex();
			assertEquals(mightAfter, expectedMight);

			mocks.assertIsSatisfied();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Test
	public void TestWhatToDoForMedicalKitKnowledgeRollZeroToThree() {
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
					will(returnValue(2));
				}
			});

			int mightBefore = ((HumanStats) (character.getStats()))
					.getCurrentMightIndex();
			medicalKitCard.whatToDo(character);
			int mightAfter = ((HumanStats) (character.getStats()))
					.getCurrentMightIndex();
			assertEquals(mightAfter, mightBefore);

			mocks.assertIsSatisfied();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Test
	public void TestBottleInit() {
		assertEquals(mesEN.getString("titleBottle"), bottleCard.getName());
		assertEquals(mesEN.getString("desBottle"), bottleCard.getDescription());
		assertEquals(mesEN.getString("detailBottle"), bottleCard.getDetails());

		bottleCard = new Bottle(spLocale);
		assertEquals(mesSP.getString("titleBottle"), bottleCard.getName());
		assertEquals(mesSP.getString("desBottle"), bottleCard.getDescription());
		assertEquals(mesSP.getString("detailBottle"), bottleCard.getDetails());

		bottleCard.setName("Bottle");
		bottleCard.setDescription("An opaque vial containing a black liquid.");
		assertEquals("Bottle", bottleCard.getName());
		assertEquals("An opaque vial containing a black liquid.",
				bottleCard.getDescription());
	}

	@Test
	public void TestLuckyStoneInit() {
		assertEquals(mesEN.getString("titleLuckyStone"),
				luckyStoneCard.getName());
		assertEquals(mesEN.getString("desLuckyStone"),
				luckyStoneCard.getDescription());
		assertEquals(mesEN.getString("detailLuckyStone"),
				luckyStoneCard.getDetails());

		luckyStoneCard = new LuckyStone(spLocale);
		assertEquals(mesSP.getString("titleLuckyStone"),
				luckyStoneCard.getName());
		assertEquals(mesSP.getString("desLuckyStone"),
				luckyStoneCard.getDescription());
		assertEquals(mesSP.getString("detailLuckyStone"),
				luckyStoneCard.getDetails());

		luckyStoneCard.setName("Lucky Stone");
		luckyStoneCard
				.setDescription("A smooth, ordinary-looking rock. You sense it will bring you some good fortune.");
		assertEquals("Lucky Stone", luckyStoneCard.getName());
		assertEquals(
				"A smooth, ordinary-looking rock. You sense it will bring you some good fortune.",
				luckyStoneCard.getDescription());
	}

	@Test
	public void TestSacrificialDaggerInit() {
		assertEquals(mesEN.getString("titleSacrificialDagger"),
				sacrificialDaggerCard.getName());
		assertEquals(mesEN.getString("desSacrificialDagger"),
				sacrificialDaggerCard.getDescription());
		assertEquals(mesEN.getString("detailSacrificialDagger"),
				sacrificialDaggerCard.getDetails());

		sacrificialDaggerCard = new SacrificialDagger(spLocale);
		assertEquals(mesSP.getString("titleSacrificialDagger"),
				sacrificialDaggerCard.getName());
		assertEquals(mesSP.getString("desSacrificialDagger"),
				sacrificialDaggerCard.getDescription());
		assertEquals(mesSP.getString("detailSacrificialDagger"),
				sacrificialDaggerCard.getDetails());

		sacrificialDaggerCard.setName("Sacrificial Dagger");
		sacrificialDaggerCard
				.setDescription("A twisted shard of iron covered in mysterious symbols and stained with blood.");
		assertEquals("Sacrificial Dagger", sacrificialDaggerCard.getName());
		assertEquals(
				"A twisted shard of iron covered in mysterious symbols and stained with blood.",
				sacrificialDaggerCard.getDescription());
	}

	@Test
	public void TestWhatToDoForSacrificialDaggerHasCorrectNumRolls() {
		assertEquals(sacrificialDaggerCard.numRolls, 4);
	}

	@Test
	public void TestWhatToDoKnowledgeRollIfGreaterThanSix() {
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
					will(returnValue(7));
				}
			});

			int sanityBefore = ((HumanStats) (character.getStats()))
					.getCurrentSanityIndex();
			sacrificialDaggerCard.whatToDo(character);
			int sanityAfter = ((HumanStats) (character.getStats()))
					.getCurrentSanityIndex();
			assertEquals(sanityAfter, sanityBefore);

			mocks.assertIsSatisfied();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Test
	public void TestWhatToDoKnowledgeRollIfThreeToFiveTakingSanityDamage() {
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
					will(returnValue(4));
				}
			});

			int expectedSanity = ((HumanStats) (character.getStats()))
					.getCurrentSanityIndex() - 1;
			sacrificialDaggerCard.whatToDo(character);
			int sanityAfter = ((HumanStats) (character.getStats()))
					.getCurrentSanityIndex();
			assertEquals(sanityAfter, expectedSanity);

			mocks.assertIsSatisfied();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Test
	public void TestWhatToDoKnowledgeRollIfThreeToFiveTakingKnowledgeDamage() {
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

			int expectedKnowledge = ((HumanStats) (character.getStats()))
					.getCurrentKnowledgeIndex() - 1;
			sacrificialDaggerCard.whatToDo(character);
			int knowledgeAfter = ((HumanStats) (character.getStats()))
					.getCurrentKnowledgeIndex();
			assertEquals(knowledgeAfter, expectedKnowledge);

			mocks.assertIsSatisfied();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Test
	public void TestWhatToDoKnowledgeRollIfZeroToTwo() {
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
					will(returnValue(2));
				}
			});

			int expectedMight = ((HumanStats) (character.getStats()))
					.getCurrentKnowledgeIndex() - 1;
			sacrificialDaggerCard.whatToDo(character);
			int mightAfter = ((HumanStats) (character.getStats()))
					.getCurrentKnowledgeIndex();
			assertEquals(mightAfter, expectedMight);

			mocks.assertIsSatisfied();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Test
	public void TestMusicBoxInit() {
		assertEquals(mesEN.getString("titleMusicBox"), musicBoxCard.getName());
		assertEquals(mesEN.getString("desMusicBox"),
				musicBoxCard.getDescription());
		assertEquals(mesEN.getString("detailMusicBox"),
				musicBoxCard.getDetails());

		musicBoxCard = new MusicBox(spLocale);
		assertEquals(mesSP.getString("titleMusicBox"), musicBoxCard.getName());
		assertEquals(mesSP.getString("desMusicBox"),
				musicBoxCard.getDescription());
		assertEquals(mesSP.getString("detailMusicBox"),
				musicBoxCard.getDetails());

		musicBoxCard.setName("Music Box");
		musicBoxCard
				.setDescription("A hand-crafted antique. It plays a haunting melody that gets stuck in your head.");
		assertEquals("Music Box", musicBoxCard.getName());
		assertEquals(
				"A hand-crafted antique. It plays a haunting melody that gets stuck in your head.",
				musicBoxCard.getDescription());
	}

	@Test
	public void TestBellInit() {
		assertEquals(mesEN.getString("titleBell"), bellCard.getName());
		assertEquals(mesEN.getString("desBell"), bellCard.getDescription());
		assertEquals(mesEN.getString("detailBell"), bellCard.getDetails());

		bellCard = new Bell(spLocale);
		assertEquals(mesSP.getString("titleBell"), bellCard.getName());
		assertEquals(mesSP.getString("desBell"), bellCard.getDescription());
		assertEquals(mesSP.getString("detailBell"), bellCard.getDetails());

		bellCard.setName("Bell");
		bellCard.setDescription("A brass bell that makes a resonant clang.");
		assertEquals("Bell", bellCard.getName());
		assertEquals("A brass bell that makes a resonant clang.",
				bellCard.getDescription());

	}

	@Test
	public void TestHealingSalveInit() {
		assertEquals(mesEN.getString("titleHealingSalve"),
				healingSalveCard.getName());
		assertEquals(mesEN.getString("desHealingSalve"),
				healingSalveCard.getDescription());
		assertEquals(mesEN.getString("detailHealingSalve"),
				healingSalveCard.getDetails());

		healingSalveCard = new HealingSalve(spLocale);
		assertEquals(mesSP.getString("titleHealingSalve"),
				healingSalveCard.getName());
		assertEquals(mesSP.getString("desHealingSalve"),
				healingSalveCard.getDescription());
		assertEquals(mesSP.getString("detailHealingSalve"),
				healingSalveCard.getDetails());

		healingSalveCard.setName("Healing Salve");
		healingSalveCard.setDescription("A sticky paste in a shallow bowl.");
		assertEquals("Healing Salve", healingSalveCard.getName());
		assertEquals("A sticky paste in a shallow bowl.",
				healingSalveCard.getDescription());
	}

	@Test
	public void TestArmorInit() {
		assertEquals(mesEN.getString("titleArmor"), armorCard.getName());
		assertEquals(mesEN.getString("desArmor"), armorCard.getDescription());
		assertEquals(mesEN.getString("detailArmor"), armorCard.getDetails());

		armorCard = new Armor(spLocale);
		assertEquals(mesSP.getString("titleArmor"), armorCard.getName());
		assertEquals(mesSP.getString("desArmor"), armorCard.getDescription());
		assertEquals(mesSP.getString("detailArmor"), armorCard.getDetails());

		armorCard.setName("Armor");
		armorCard
				.setDescription("It's just prop armor from a Renaissance fair, but it's still metal.");
		assertEquals("Armor", armorCard.getName());
		assertEquals(
				"It's just prop armor from a Renaissance fair, but it's still metal.",
				armorCard.getDescription());
	}

	@Test
	public void TestAmuletOfAgesInit() {
		assertEquals(mesEN.getString("titleAmuletOfAges"),
				amuletOfAgesCard.getName());
		assertEquals(mesEN.getString("desAmuletOfAges"),
				amuletOfAgesCard.getDescription());
		assertEquals(mesEN.getString("detailAmuletOfAges"),
				amuletOfAgesCard.getDetails());

		amuletOfAgesCard = new AmuletOfAges(spLocale);
		assertEquals(mesSP.getString("titleAmuletOfAges"),
				amuletOfAgesCard.getName());
		assertEquals(mesSP.getString("desAmuletOfAges"),
				amuletOfAgesCard.getDescription());
		assertEquals(mesSP.getString("detailAmuletOfAges"),
				amuletOfAgesCard.getDetails());

		amuletOfAgesCard.setName("Amulet Of The Ages");
		amuletOfAgesCard
				.setDescription("Ancient silver and inlaid gems, inscribed with blessings.");
		assertEquals("Amulet Of The Ages", amuletOfAgesCard.getName());
		assertEquals(
				"Ancient silver and inlaid gems, inscribed with blessings.",
				amuletOfAgesCard.getDescription());
	}

	@Test
	public void TestAmuletOfAgesWhatToDo() {
		Game game = Game.getInstance();
		Player player = new Player();
		ExplorerFactory expFac = new ExplorerFactory();
		Character character = expFac
				.getExplorer(Character_Name.FatherRhinehardt);
		player.addCharacter(character);
		game.addPlayer(player);
		game.addCharacter(character);

		int expectedMight = ((HumanStats) (character.getStats()))
				.getCurrentMightIndex() + 1;
		int expectedSpeed = ((HumanStats) (character.getStats()))
				.getCurrentSpeedIndex() + 1;
		int expectedKnowledge = ((HumanStats) (character.getStats()))
				.getCurrentKnowledgeIndex() + 1;
		int expectedSanity = ((HumanStats) (character.getStats()))
				.getCurrentSanityIndex() + 1;

		amuletOfAgesCard.whatToDo(character);

		int mightAfter = ((HumanStats) (character.getStats()))
				.getCurrentMightIndex();
		int speedAfter = ((HumanStats) (character.getStats()))
				.getCurrentSpeedIndex();
		int knowledgeAfter = ((HumanStats) (character.getStats()))
				.getCurrentKnowledgeIndex();
		int sanityAfter = ((HumanStats) (character.getStats()))
				.getCurrentSanityIndex();

		assertEquals(expectedMight, mightAfter);
		assertEquals(expectedSpeed, speedAfter);
		assertEquals(expectedKnowledge, knowledgeAfter);
		assertEquals(expectedSanity, sanityAfter);

	}

	@Test
	public void TestAmuletCardWhatToDoIfLost() {
		Game game = Game.getInstance();
		Player player = new Player();
		ExplorerFactory expFac = new ExplorerFactory();
		Character character = expFac
				.getExplorer(Character_Name.FatherRhinehardt);
		player.addCharacter(character);
		game.addPlayer(player);
		game.addCharacter(character);

		amuletOfAgesCard.isLost = true;

		int expectedMight2 = ((HumanStats) (character.getStats()))
				.getCurrentMightIndex() - 3;
		int expectedSpeed2 = ((HumanStats) (character.getStats()))
				.getCurrentSpeedIndex() - 3;
		int expectedKnowledge2 = ((HumanStats) (character.getStats()))
				.getCurrentKnowledgeIndex() - 3;
		int expectedSanity2 = ((HumanStats) (character.getStats()))
				.getCurrentSanityIndex() - 3;

		amuletOfAgesCard.whatToDo(character);

		int mightAfter2 = ((HumanStats) (character.getStats()))
				.getCurrentMightIndex();
		int speedAfter2 = ((HumanStats) (character.getStats()))
				.getCurrentSpeedIndex();
		int knowledgeAfter2 = ((HumanStats) (character.getStats()))
				.getCurrentKnowledgeIndex();
		int sanityAfter2 = ((HumanStats) (character.getStats()))
				.getCurrentSanityIndex();

		assertEquals(expectedMight2, mightAfter2);
		assertEquals(expectedSpeed2, speedAfter2);
		assertEquals(expectedKnowledge2, knowledgeAfter2);
		assertEquals(expectedSanity2, sanityAfter2);
	}

	@Test
	public void TestCandleInit() {
		assertEquals(mesEN.getString("titleCandle"), candleCard.getName());
		assertEquals(mesEN.getString("desCandle"), candleCard.getDescription());
		assertEquals(mesEN.getString("detailCandle"), candleCard.getDetails());

		candleCard = new Candle(spLocale);
		assertEquals(mesSP.getString("titleCandle"), candleCard.getName());
		assertEquals(mesSP.getString("desCandle"), candleCard.getDescription());
		assertEquals(mesSP.getString("detailCandle"), candleCard.getDetails());

		candleCard.setName("Candle");
		candleCard
				.setDescription("It makes the shadows move-at least, you hope it's doing that.");
		assertEquals("Candle", candleCard.getName());
		assertEquals(
				"It makes the shadows move-at least, you hope it's doing that.",
				candleCard.getDescription());
	}

	@Test
	public void TestDynamiteInit() {
		assertEquals(mesEN.getString("titleDynamite"), dynamiteCard.getName());
		assertEquals(mesEN.getString("desDynamite"),
				dynamiteCard.getDescription());
		assertEquals(mesEN.getString("detailDynamite"),
				dynamiteCard.getDetails());

		dynamiteCard = new Dynamite(spLocale);
		assertEquals(mesSP.getString("titleDynamite"), dynamiteCard.getName());
		assertEquals(mesSP.getString("desDynamite"),
				dynamiteCard.getDescription());
		assertEquals(mesSP.getString("detailDynamite"),
				dynamiteCard.getDetails());

		dynamiteCard.setName("Dynamite");
		dynamiteCard.setDescription("The fuse isn't lit...yet.");
		assertEquals("Dynamite", dynamiteCard.getName());
		assertEquals("The fuse isn't lit...yet.", dynamiteCard.getDescription());
	}

	@Test
	public void TestPickpocketInit() {
		assertEquals(mesEN.getString("titlePickpoketsGloves"),
				pickpocketCard.getName());
		assertEquals(mesEN.getString("desPickpoketsGloves"),
				pickpocketCard.getDescription());
		assertEquals(mesEN.getString("detailPickpoketsGloves"),
				pickpocketCard.getDetails());

		pickpocketCard = new PickpocketsGloves(spLocale);
		assertEquals(mesSP.getString("titlePickpoketsGloves"),
				pickpocketCard.getName());
		assertEquals(mesSP.getString("desPickpoketsGloves"),
				pickpocketCard.getDescription());
		assertEquals(mesSP.getString("detailPickpoketsGloves"),
				pickpocketCard.getDetails());

		pickpocketCard.setName("Pickpocket's Gloves");
		pickpocketCard
				.setDescription("Helping yourself has never seemed so easy.");
		assertEquals("Pickpocket's Gloves", pickpocketCard.getName());
		assertEquals("Helping yourself has never seemed so easy.",
				pickpocketCard.getDescription());
	}

	@Test
	public void TestWhatToDoForPickPocketsGloves() {
		// Unfinished mock
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

			mocks.checking(new Expectations() {
				{

				}
			});

			pickpocketCard.whatToDo(character);
			assertFalse(character.getItemHand().contains(pickpocketCard));

			mocks.assertIsSatisfied();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}

	}

	@Test
	public void TestAxeInit() {
		assertEquals(mesEN.getString("titleAxe"), axeCard.getName());
		assertEquals(mesEN.getString("desAxe"), axeCard.getDescription());
		assertEquals(mesEN.getString("detailAxe"), axeCard.getDetails());

		axeCard = new Axe(spLocale);
		assertEquals(mesSP.getString("titleAxe"), axeCard.getName());
		assertEquals(mesSP.getString("desAxe"), axeCard.getDescription());
		assertEquals(mesSP.getString("detailAxe"), axeCard.getDetails());

		axeCard.setName("Axe");
		axeCard.setDescription("WEAPON Very sharp.");
		assertEquals("Axe", axeCard.getName());
		assertEquals("WEAPON Very sharp.", axeCard.getDescription());
	}

	@Test
	public void TestSmellingSaltsInit() {
		assertEquals(mesEN.getString("titleSmellingSalts"),
				smellingSaltsCard.getName());
		assertEquals(mesEN.getString("desSmellingSalts"),
				smellingSaltsCard.getDescription());
		assertEquals(mesEN.getString("detailSmellingSalts"),
				smellingSaltsCard.getDetails());

		smellingSaltsCard = new SmellingSalts(spLocale);
		assertEquals(mesSP.getString("titleSmellingSalts"),
				smellingSaltsCard.getName());
		assertEquals(mesSP.getString("desSmellingSalts"),
				smellingSaltsCard.getDescription());
		assertEquals(mesSP.getString("detailSmellingSalts"),
				smellingSaltsCard.getDetails());

		smellingSaltsCard.setName("Smelling Salts");
		smellingSaltsCard.setDescription("Whew, that's a lungful.");
		assertEquals("Smelling Salts", smellingSaltsCard.getName());
		assertEquals("Whew, that's a lungful.",
				smellingSaltsCard.getDescription());
	}

	@Test
	public void TestDarkDiceInit() {
		assertEquals(mesEN.getString("titleDarkDice"), darkDiceCard.getName());
		assertEquals(mesEN.getString("desDarkDice"),
				darkDiceCard.getDescription());
		assertEquals(mesEN.getString("detailDarkDice"),
				darkDiceCard.getDetails());

		darkDiceCard = new DarkDice(spLocale);
		assertEquals(mesSP.getString("titleDarkDice"), darkDiceCard.getName());
		assertEquals(mesSP.getString("desDarkDice"),
				darkDiceCard.getDescription());
		assertEquals(mesSP.getString("detailDarkDice"),
				darkDiceCard.getDetails());

		darkDiceCard.setName("Dark Dice");
		darkDiceCard.setDescription("Are you feeling lucky?");
		assertEquals("Dark Dice", darkDiceCard.getName());
		assertEquals("Are you feeling lucky?", darkDiceCard.getDescription());
	}

	@Test
	public void TestBloodDaggerInit() {
		assertEquals(mesEN.getString("titleBloodDagger"),
				bloodDaggerCard.getName());
		assertEquals(mesEN.getString("desBloodDagger"),
				bloodDaggerCard.getDescription());
		assertEquals(mesEN.getString("detailBloodDagger"),
				bloodDaggerCard.getDetails());

		bloodDaggerCard = new BloodDagger(spLocale);
		assertEquals(mesSP.getString("titleBloodDagger"),
				bloodDaggerCard.getName());
		assertEquals(mesSP.getString("desBloodDagger"),
				bloodDaggerCard.getDescription());
		assertEquals(mesSP.getString("detailBloodDagger"),
				bloodDaggerCard.getDetails());

		bloodDaggerCard.setName("Blood Dagger");
		bloodDaggerCard
				.setDescription("WEAPON A nasty weapon. Needles and tubes extend from the handle...and plunge right into your veins.");
		assertEquals("Blood Dagger", bloodDaggerCard.getName());
		assertEquals(
				"WEAPON A nasty weapon. Needles and tubes extend from the handle...and plunge right into your veins.",
				bloodDaggerCard.getDescription());
	}

	@Test
	public void TestIdolInit() {
		assertEquals(mesEN.getString("titleIdol"), idolCard.getName());
		assertEquals(mesEN.getString("desIdol"), idolCard.getDescription());
		assertEquals(mesEN.getString("detailIdol"), idolCard.getDetails());

		idolCard = new Idol(spLocale);
		assertEquals(mesSP.getString("titleIdol"), idolCard.getName());
		assertEquals(mesSP.getString("desIdol"), idolCard.getDescription());
		assertEquals(mesSP.getString("detailIdol"), idolCard.getDetails());

		idolCard.setName("Idol");
		idolCard.setDescription("Perhaps it's chosen you for some greater purpose. Like human sacrifice.");
		assertEquals("Idol", idolCard.getName());
		assertEquals(
				"Perhaps it's chosen you for some greater purpose. Like human sacrifice.",
				idolCard.getDescription());
	}
	
	@Test
	public void TestWhatToDoForIdol(){
		assertEquals(idolCard.numRolls, 2);
		int expectedSanity = ((HumanStats) (character.getStats()))
				.getCurrentSanityIndex() - 1;
		idolCard.whatToDo(character);
		int sanityAfter = ((HumanStats) (character.getStats()))
				.getCurrentSanityIndex();
		assertEquals(expectedSanity, sanityAfter);
	}
}
