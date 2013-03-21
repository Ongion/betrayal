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
}
