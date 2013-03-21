package test;

import static org.junit.Assert.*;
import itemCards.AdrenalineShot;
import itemCards.AngelFeather;
import itemCards.ItemCard;
import itemCards.PuzzleBox;
import itemCards.Revolver;

import org.junit.Test;

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
		assertEquals("Angel Feather", angelFeatherCard.getName());
		assertEquals("A perfect feather fluttering in your hand.",
				angelFeatherCard.getDescription());
	}

	@Test
	public void TestAdrenalineShotInit(){
		assertEquals("Adrenaline Shot", adrenalineShotCard.getName());
		assertEquals("A syringe containing a strange fluorescent liquid.", adrenalineShotCard.getDescription());
	}
	
	@Test
	public void TestRevolverInit(){
		assertEquals("Revolver", revolverCard.getName());
		assertEquals("WEAPON An old, potent-looking weapon.", revolverCard.getDescription());
	}
	
	@Test
	public void TestPuzzleBoxInit(){
		assertEquals("Puzzle Box", puzzleBoxCard.getName());
		assertEquals("There must be a way to open it.", puzzleBoxCard.getDescription());
	}
	
	@Test
	public void TestRabbitsFootInit(){
		assertEquals("Rabbit's Foot", rabbitsFootCard.getName());
		assertEquals("Not so lucky for the rabbit.", rabbitsFootCard.getDescription());
	}
	
	@Test 
	public void TestMedicalKitInit(){
		assertEquals("Medical Kit", medicalKitCard.getName());
		assertEquals("A doctor's bag, depleted in some critical resources.", medicalKitCard.getDescription());
	}
	
	@Test
	public void TestBottleInit(){
		assertEquals("Bottle", bottleCard.getName());
		assertEquals("An opaque vial containing a black liquid.", bottleCard.getDescription());
	}
	
	@Test
	public void TestLuckyStoneInit(){
		assertEquals("Lucky Stone", luckyStoneCard.getName());
		assertEquals("A smooth, ordinary-looking rock. You sense it will bring you some good fortune.", luckyStoneCard.getDescription());
	}
	
	@Test
	public void TestSacrificialDaggerInit(){
		assertEquals("Sacrificial Dagger", sacrificialDaggerCard.getName());
		assertEquals("A twisted shard of iron covered in mysterious symbols and stained with blood.", sacrificialDaggerCard.getDescription());
	}
	
	@Test
	public void TestMusicBoxInit(){
		assertEquals("Music Box", musicBoxCard.getName());
		assertEquals("A hand-crafted antique. It plays a haunting melody that gets stuck in your head.", musicBoxCard.getDescription());
	}
	
	@Test 
	public void TestBellInit(){
		assertEquals("Bell", bellCard.getName());
		assertEquals("A brass bell that makes a resonant clang.", bellCard.getDescription());
	}
	
	@Test
	public void TestHealingSalveInit(){
		assertEquals("Healing Salve", healingSalveCard.getName());
		assertEquals("A sticky paste in a shallow bowl.", healingSalveCard.getDescription());
	}
	
	@Test
	public void TestArmorInit(){
		assertEquals("Armor", armorCard.getName());
		assertEquals("It's just prop armor from a Renaissance fair, but it's still metal.", armorCard.getDescription());
	}
	
	@Test
	public void TestAmuletOfAgesInit(){
		assertEquals("Amulet Of The Ages", amuletOfAgesCard.getName());
		assertEquals("Ancient silver and inlaid gems, inscribed with blessings.", amuletOfAgesCard.getDescription());
	}
	
	@Test
	public void TestCandleInit(){
		assertEquals("Candle", candleCard.getName());
		assertEquals("It makes the shadows move-at least, you hope it's doing that.", candleCard.getDescription());
	}
	
	@Test
	public void TestDynamiteInit(){
		assertEquals("Dynamite", dynamiteCard.getName());
		assertEquals("The fuse isn't lit...yet.", dynamiteCard.getDescription());
	}
	
	@Test
	public void TestPickpocketInit(){
		assertEquals("Pickpocket's Glove", pickpocketCard.getName());
		assertEquals("Helping yourself has never seemed so easy.", pickpocketCard.getDescription());
	}
	
	@Test
	public void TestAxeInit(){
		assertEquals("Axe", axeCard.getName());
		assertEquals("WEAPON Very sharp.", axeCard.getDescription());
	}
	
	@Test
	public void TestSmellingSaltsInit(){
		assertEquals("Smelling Salts", smellingSaltsCard.getName());
		assertEquals("Whew, that's a lungful.", smellingSaltsCard.getDescription());
	}
	
	@Test
	public void TestDarkDiceInit(){
		assertEquals("Dark Dice", darkDiceCard.getName());
		assertEquals("Are you feeling lucky?", darkDiceCard.getDescription());
	}
	
	@Test
	public void TestBloodDaggerInit(){
		assertEquals("Blood Dagger", bloodDaggerCard.getName());
		assertEquals("WEAPON A nasty weapon. Needles and tubes extend from the handle...and plunge right into your veins.", bloodDaggerCard.getDescription());
	}
	
	@Test
	public void TestIdolInit(){
		assertEquals("Idol", idolCard.getName());
		assertEquals("Perhaps it's chosen you for some greater purpose. Like human sacrifice.", idolCard.getDescription());
	}
}
