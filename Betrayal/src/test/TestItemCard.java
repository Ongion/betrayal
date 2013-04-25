package test;

import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Locale;

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

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Assert;
import org.junit.Test;

import characters.Character.Character_Name;
import characters.ExplorerFactory;
import characters.Character;
import characters.HumanStats;

import Game.Game;
import Game.Player;
import eventCards.EventCard;

public class TestItemCard {
	private ItemCard angelFeatherCard = new AngelFeather("Angel Feather",
			"A perfect feather fluttering in your hand.");
	private ItemCard adrenalineShotCard = new AdrenalineShot("Adrenaline Shot", "A syringe containing a strange fluorescent liquid.");
	private ItemCard revolverCard = new Revolver("Revolver","WEAPON An old, potent-looking weapon.");	
	private ItemCard puzzleBoxCard = new PuzzleBox("Puzzle Box", "There must be a way to open it.");
	private ItemCard rabbitsFootCard = new RabbitsFoot("Rabbit's Foot", "Not so lucky for the rabbit.");
	private ItemCard medicalKitCard = new MedicalKit("Medical Kit", "A doctor's bag, depleted in some critical resources.");
	private ItemCard bottleCard = new Bottle("Bottle", "An opaque vial containing a black liquid.");
	private ItemCard luckyStoneCard = new LuckyStone("Lucky Stone", "A smooth, ordinary-looking rock. You sense it will bring you some good fortune.");
	private ItemCard sacrificialDaggerCard = new SacrificialDagger("Sacrificial Dagger", "A twisted shard of iron covered in mysterious symbols and stained with blood.");
	private ItemCard musicBoxCard = new MusicBox("Music Box", "A hand-crafted antique. It plays a haunting melody that gets stuck in your head.");
	private ItemCard bellCard = new Bell("Bell","A brass bell that makes a resonant clang.");
	private ItemCard healingSalveCard = new HealingSalve("Healing Salve", "A sticky paste in a shallow bowl.");
	private ItemCard armorCard = new Armor("Armor", "It's just prop armor from a Renaissance fair, but it's still metal.");
	private ItemCard amuletOfAgesCard = new AmuletOfAges("Amulet Of The Ages", "Ancient silver and inlaid gems, inscribed with blessings.");
	private ItemCard candleCard = new Candle("Candle", "It makes the shadows move-at least, you hope it's doing that.");
	private ItemCard dynamiteCard = new Dynamite("Dynamite", "The fuse isn't lit...yet.");
	private ItemCard pickpocketCard = new PickpocketsGloves("Pickpocket's Gloves", "Helping yourself has never seemed so easy.");
	private ItemCard axeCard = new Axe("Axe", "WEAPON Very sharp.");
	private ItemCard smellingSaltsCard = new SmellingSalts("Smelling Salts","Whew, that's a lungful.");
	private ItemCard darkDiceCard = new DarkDice("Dark Dice", "Are you feeling lucky?");
	private ItemCard bloodDaggerCard = new BloodDagger("Blood Dagger", "WEAPON A nasty weapon. Needles and tubes extend from the handle...and plunge right into your veins.");
	private ItemCard idolCard = new Idol("Idol","Perhaps it's chosen you for some greater purpose. Like human sacrifice.");
	
	@Test
	public void TestAngelFeatherInit() {
		angelFeatherCard.setName("Angel Feather");
		angelFeatherCard.setDescription("A perfect feather fluttering in your hand.");
		assertEquals("Angel Feather", angelFeatherCard.getName());
		assertEquals("A perfect feather fluttering in your hand.",
				angelFeatherCard.getDescription());
	}

	@Test
	public void TestAdrenalineShotInit(){
		adrenalineShotCard.setName("Adrenaline Shot");
		adrenalineShotCard.setDescription("A syringe containing a strange fluorescent liquid.");
		assertEquals("Adrenaline Shot", adrenalineShotCard.getName());
		assertEquals("A syringe containing a strange fluorescent liquid.", adrenalineShotCard.getDescription());
	}
	
	@Test
	public void TestRevolverInit(){
		revolverCard.setName("Revolver");
		revolverCard.setDescription("WEAPON An old, potent-looking weapon.");
		assertEquals("Revolver", revolverCard.getName());
		assertEquals("WEAPON An old, potent-looking weapon.", revolverCard.getDescription());
	}
	
	@Test
	public void TestPuzzleBoxInit(){
		puzzleBoxCard.setName("Puzzle Box");
		puzzleBoxCard.setDescription("There must be a way to open it.");
		assertEquals("Puzzle Box", puzzleBoxCard.getName());
		assertEquals("There must be a way to open it.", puzzleBoxCard.getDescription());
	}
	
	@Test
	public void TestRabbitsFootInit(){
		rabbitsFootCard.setName("Rabbit's Foot");
		rabbitsFootCard.setDescription("Not so lucky for the rabbit.");
		assertEquals("Rabbit's Foot", rabbitsFootCard.getName());
		assertEquals("Not so lucky for the rabbit.", rabbitsFootCard.getDescription());
	}
	
	@Test 
	public void TestMedicalKitInit(){
		medicalKitCard.setName("Medical Kit");
		medicalKitCard.setDescription("A doctor's bag, depleted in some critical resources.");
		assertEquals("Medical Kit", medicalKitCard.getName());
		assertEquals("A doctor's bag, depleted in some critical resources.", medicalKitCard.getDescription());
	}
	
	@Test
	public void TestBottleInit(){
		bottleCard.setName("Bottle");
		bottleCard.setDescription("An opaque vial containing a black liquid.");
		assertEquals("Bottle", bottleCard.getName());
		assertEquals("An opaque vial containing a black liquid.", bottleCard.getDescription());
	}
	
	@Test
	public void TestLuckyStoneInit(){
		luckyStoneCard.setName("Lucky Stone");
		luckyStoneCard.setDescription("A smooth, ordinary-looking rock. You sense it will bring you some good fortune.");
		assertEquals("Lucky Stone", luckyStoneCard.getName());
		assertEquals("A smooth, ordinary-looking rock. You sense it will bring you some good fortune.", luckyStoneCard.getDescription());
	}
	
	@Test
	public void TestSacrificialDaggerInit(){
		sacrificialDaggerCard.setName("Sacrificial Dagger");
		sacrificialDaggerCard.setDescription("A twisted shard of iron covered in mysterious symbols and stained with blood.");
		assertEquals("Sacrificial Dagger", sacrificialDaggerCard.getName());
		assertEquals("A twisted shard of iron covered in mysterious symbols and stained with blood.", sacrificialDaggerCard.getDescription());
	}
	
	@Test
	public void TestMusicBoxInit(){
		musicBoxCard.setName("Music Box");
		musicBoxCard.setDescription("A hand-crafted antique. It plays a haunting melody that gets stuck in your head.");
		assertEquals("Music Box", musicBoxCard.getName());
		assertEquals("A hand-crafted antique. It plays a haunting melody that gets stuck in your head.", musicBoxCard.getDescription());
	}
	
	@Test 
	public void TestBellInit(){
		bellCard.setName("Bell");
		bellCard.setDescription("A brass bell that makes a resonant clang.");
		assertEquals("Bell", bellCard.getName());
		assertEquals("A brass bell that makes a resonant clang.", bellCard.getDescription());
		
	}
	
	@Test
	public void TestHealingSalveInit(){
		healingSalveCard.setName("Healing Salve");
		healingSalveCard.setDescription("A sticky paste in a shallow bowl.");
		assertEquals("Healing Salve", healingSalveCard.getName());
		assertEquals("A sticky paste in a shallow bowl.", healingSalveCard.getDescription());
	}
	
	@Test
	public void TestArmorInit(){
		armorCard.setName("Armor");
		armorCard.setDescription("It's just prop armor from a Renaissance fair, but it's still metal.");
		assertEquals("Armor", armorCard.getName());
		assertEquals("It's just prop armor from a Renaissance fair, but it's still metal.", armorCard.getDescription());
	}
	
	@Test
	public void TestAmuletOfAgesInit(){
		amuletOfAgesCard.setName("Amulet Of The Ages");
		amuletOfAgesCard.setDescription("Ancient silver and inlaid gems, inscribed with blessings.");
		assertEquals("Amulet Of The Ages", amuletOfAgesCard.getName());
		assertEquals("Ancient silver and inlaid gems, inscribed with blessings.", amuletOfAgesCard.getDescription());
	}
	
	@Test
	public void TestAmuletOfAgesWhatToDo(){
		Game game = Game.getInstance();
		Player player = new Player();
		ExplorerFactory expFac = new ExplorerFactory();
		Character character = expFac.getExplorer(Character_Name.FatherRhinehardt);
		player.addCharacter(character);
		game.addPlayer(player);
		game.addCharacter(character);
		
		int expectedMight = ((HumanStats) (character.getStats())).getCurrentMightIndex() + 1;
		int expectedSpeed = ((HumanStats) (character.getStats())).getCurrentSpeedIndex() + 1;
		int expectedKnowledge = ((HumanStats) (character.getStats())).getCurrentKnowledgeIndex() + 1;
		int expectedSanity = ((HumanStats) (character.getStats())).getCurrentSanityIndex() + 1;
		
		amuletOfAgesCard.whatToDo(character);
		
		int mightAfter = ((HumanStats) (character.getStats())).getCurrentMightIndex();
		int speedAfter = ((HumanStats) (character.getStats())).getCurrentSpeedIndex();
		int knowledgeAfter = ((HumanStats) (character.getStats())).getCurrentKnowledgeIndex();
		int sanityAfter = ((HumanStats) (character.getStats())).getCurrentSanityIndex();
		
		amuletOfAgesCard.isLost = false;
		
		assertEquals(expectedMight, mightAfter);
		assertEquals(expectedSpeed, speedAfter);
		assertEquals(expectedKnowledge, knowledgeAfter);
		assertEquals(expectedSanity, sanityAfter);
		
		amuletOfAgesCard.isLost = true;
		
		int expectedMight2 = character.getCurrentMightIndex() - 3;
		int expectedSpeed2 = character.getCurrentSpeedIndex() - 3;
		int expectedKnowledge2 = character.getCurrentKnowledgeIndex() - 3;
		int expectedSanity2 = character.getCurrentSanityIndex() - 3;
		
		amuletOfAgesCard.whatToDo(character);
		
		int mightAfter2 = character.getCurrentMightIndex();
		int speedAfter2 = character.getCurrentSpeedIndex();
		int knowledgeAfter2 = character.getCurrentKnowledgeIndex();
		int sanityAfter2 = character.getCurrentSanityIndex();
		
		assertEquals(expectedMight2, mightAfter2);
		assertEquals(expectedSpeed2, speedAfter2);
		assertEquals(expectedKnowledge2, knowledgeAfter2);
		assertEquals(expectedSanity2, sanityAfter2);
	}
	
	
	@Test
	public void TestCandleInit(){
		candleCard.setName("Candle");
		candleCard.setDescription("It makes the shadows move-at least, you hope it's doing that.");
		assertEquals("Candle", candleCard.getName());
		assertEquals("It makes the shadows move-at least, you hope it's doing that.", candleCard.getDescription());
	}
	
	@Test
	public void TestDynamiteInit(){
		dynamiteCard.setName("Dynamite");
		dynamiteCard.setDescription("The fuse isn't lit...yet.");
		assertEquals("Dynamite", dynamiteCard.getName());
		assertEquals("The fuse isn't lit...yet.", dynamiteCard.getDescription());
	}
	
	@Test
	public void TestPickpocketInit(){
		pickpocketCard.setName("Pickpocket's Gloves");
		pickpocketCard.setDescription("Helping yourself has never seemed so easy.");
		assertEquals("Pickpocket's Gloves", pickpocketCard.getName());
		assertEquals("Helping yourself has never seemed so easy.", pickpocketCard.getDescription());
	}
	
	@Test
	public void TestAxeInit(){
		axeCard.setName("Axe");
		axeCard.setDescription("WEAPON Very sharp.");
		assertEquals("Axe", axeCard.getName());
		assertEquals("WEAPON Very sharp.", axeCard.getDescription());
	}
	
	@Test
	public void TestSmellingSaltsInit(){
		smellingSaltsCard.setName("Smelling Salts");
		smellingSaltsCard.setDescription("Whew, that's a lungful.");
		assertEquals("Smelling Salts", smellingSaltsCard.getName());
		assertEquals("Whew, that's a lungful.", smellingSaltsCard.getDescription());
	}
	
	@Test
	public void TestDarkDiceInit(){
		darkDiceCard.setName("Dark Dice");
		darkDiceCard.setDescription("Are you feeling lucky?");
		assertEquals("Dark Dice", darkDiceCard.getName());
		assertEquals("Are you feeling lucky?", darkDiceCard.getDescription());
	}
	
	@Test
	public void TestBloodDaggerInit(){
		bloodDaggerCard.setName("Blood Dagger");
		bloodDaggerCard.setDescription("WEAPON A nasty weapon. Needles and tubes extend from the handle...and plunge right into your veins.");
		assertEquals("Blood Dagger", bloodDaggerCard.getName());
		assertEquals("WEAPON A nasty weapon. Needles and tubes extend from the handle...and plunge right into your veins.", bloodDaggerCard.getDescription());
	}
	
	@Test
	public void TestIdolInit(){
		idolCard.setName("Idol");
		idolCard.setDescription("Perhaps it's chosen you for some greater purpose. Like human sacrifice.");
		assertEquals("Idol", idolCard.getName());
		assertEquals("Perhaps it's chosen you for some greater purpose. Like human sacrifice.", idolCard.getDescription());
	}
}
