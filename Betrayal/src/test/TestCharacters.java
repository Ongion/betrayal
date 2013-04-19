package test;

import itemCards.AngelFeather;
import itemCards.ItemCard;

import java.util.ArrayList;
import java.util.Locale;

import junit.framework.Assert;

import omenCards.CrystalBall;
import omenCards.OmenCard;

import org.junit.Before;
import org.junit.Test;

import characters.ExplorerType;
import characters.Character.Character_Name;
import characters.ExplorerFactory;
import characters.MonsterType;
import characters.MonsterType.Monsters;
import eventCards.EventCard;
import eventCards.Rotten;
import characters.Character;
import characters.HumanStats;

public class TestCharacters {
	
	Character FatherRhinehardt, c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11;
	
	@Before
	public void initializeTests(){
		ExplorerFactory explorers = new ExplorerFactory();
		FatherRhinehardt = explorers.getExplorer(Character_Name.FatherRhinehardt);
		c1 = explorers.getExplorer(Character_Name.ProfessorLongfellow);
		c2 = explorers.getExplorer(Character_Name.OxBellows);
		c3 = explorers.getExplorer(Character_Name.DarrinWilliams);
		c4 = explorers.getExplorer(Character_Name.MadameZostra);
		c5 = explorers.getExplorer(Character_Name.VivianLopez);
		c6 = explorers.getExplorer(Character_Name.ZoeIngstrom);
		c7 = explorers.getExplorer(Character_Name.MissyDubourde);
		c8 = explorers.getExplorer(Character_Name.JennyLeClerc);
		c9 = explorers.getExplorer(Character_Name.HeatherGranville);
		c10 = explorers.getExplorer(Character_Name.BrandonJaspers);
		c11 = explorers.getExplorer(Character_Name.PeterAkimoto);
		
	}
	
	@Test
	public void testInitialization() {
		Assert.assertNotNull(FatherRhinehardt);
		Assert.assertNotNull(c1);
		Assert.assertNotNull(c2);
		Assert.assertNotNull(c3);
		Assert.assertNotNull(c4);
		Assert.assertNotNull(c5);
		Assert.assertNotNull(c6);
		Assert.assertNotNull(c7);
		Assert.assertNotNull(c8);
		Assert.assertNotNull(c9);
		Assert.assertNotNull(c10);
		Assert.assertNotNull(c11);
	}
	
	@Test
	public void testGetName() {		
		Assert.assertEquals(FatherRhinehardt.getName(), "Father Rhinehardt");
	}
	
	@Test
	public void testGetAge() {		
		Assert.assertEquals(FatherRhinehardt.getAge(), 62);
	}
	
	@Test
	public void testGetHeight() {
		
		
		Assert.assertEquals(FatherRhinehardt.getHeight(), 69);
	}
	
	@Test
	public void testGetWeight() {
		
		
		Assert.assertEquals(FatherRhinehardt.getWeight(), 185);
	}
	
	@Test
	public void testGetHobbies() {
		
		String[] compare = {"Fencing","Gardening"};
		
		Assert.assertEquals(FatherRhinehardt.getHobbies().length, compare.length);
		for (int i = 0; i < compare.length; i ++){
			Assert.assertEquals(FatherRhinehardt.getHobbies()[i], compare[i] );
		}
		
	}
	
	@Test 
	public void testIncrementKnowledge() {
		Assert.assertEquals(FatherRhinehardt.getCurrentKnowledge(), 4);
		FatherRhinehardt.incrementKnowledge();
		Assert.assertEquals(FatherRhinehardt.getCurrentKnowledge(), 5);
		FatherRhinehardt.incrementKnowledge();
		Assert.assertEquals(FatherRhinehardt.getCurrentKnowledge(), 6);
		FatherRhinehardt.incrementKnowledge();
		Assert.assertEquals(FatherRhinehardt.getCurrentKnowledge(), 6);
		FatherRhinehardt.incrementKnowledge();
		Assert.assertEquals(FatherRhinehardt.getCurrentKnowledge(), 8);
		FatherRhinehardt.incrementKnowledge();
		Assert.assertEquals(FatherRhinehardt.getCurrentKnowledge(), 8);
	}
	@Test 
	public void testDecrementKnowledge() {
		Assert.assertEquals(FatherRhinehardt.getCurrentKnowledge(), 4);
		FatherRhinehardt.decrementKnowledge();
		Assert.assertEquals(FatherRhinehardt.getCurrentKnowledge(), 3);
		FatherRhinehardt.decrementKnowledge();
		Assert.assertEquals(FatherRhinehardt.getCurrentKnowledge(), 3);
		FatherRhinehardt.decrementKnowledge();
		Assert.assertEquals(FatherRhinehardt.getCurrentKnowledge(), 1);
		FatherRhinehardt.decrementKnowledge();
		Assert.assertEquals(FatherRhinehardt.getCurrentKnowledge(), 1);
	}
	
	@Test 
	public void testIncrementSanity() {
		Assert.assertEquals(FatherRhinehardt.getCurrentSanity(), 6);
		FatherRhinehardt.incrementSanity();
		Assert.assertEquals(FatherRhinehardt.getCurrentSanity(), 7);
		FatherRhinehardt.incrementSanity();
		Assert.assertEquals(FatherRhinehardt.getCurrentSanity(), 7);
		FatherRhinehardt.incrementSanity();
		Assert.assertEquals(FatherRhinehardt.getCurrentSanity(), 8);
		FatherRhinehardt.incrementSanity();
		Assert.assertEquals(FatherRhinehardt.getCurrentSanity(), 8);
		FatherRhinehardt.incrementSanity();
		Assert.assertEquals(FatherRhinehardt.getCurrentSanity(), 8);
	}
	@Test 
	public void testDecrementSanity() {
		Assert.assertEquals(FatherRhinehardt.getCurrentSanity(), 6);
		FatherRhinehardt.decrementSanity();
		Assert.assertEquals(FatherRhinehardt.getCurrentSanity(), 5);
		FatherRhinehardt.decrementSanity();
		Assert.assertEquals(FatherRhinehardt.getCurrentSanity(), 5);
		FatherRhinehardt.decrementSanity();
		Assert.assertEquals(FatherRhinehardt.getCurrentSanity(), 4);
		FatherRhinehardt.decrementSanity();
		Assert.assertEquals(FatherRhinehardt.getCurrentSanity(), 3);
		FatherRhinehardt.decrementSanity();
		Assert.assertEquals(FatherRhinehardt.getCurrentSanity(), 3);
	}
	@Test 
	public void testIncrementMight() {
		Assert.assertEquals(FatherRhinehardt.getCurrentMight(), 2);
		FatherRhinehardt.incrementMight();
		Assert.assertEquals(FatherRhinehardt.getCurrentMight(), 4);
		FatherRhinehardt.incrementMight();
		Assert.assertEquals(FatherRhinehardt.getCurrentMight(), 4);
		FatherRhinehardt.incrementMight();
		Assert.assertEquals(FatherRhinehardt.getCurrentMight(), 5);
		FatherRhinehardt.incrementMight();
		Assert.assertEquals(FatherRhinehardt.getCurrentMight(), 5);
		FatherRhinehardt.incrementMight();
		Assert.assertEquals(FatherRhinehardt.getCurrentMight(), 7);
		FatherRhinehardt.incrementMight();
		Assert.assertEquals(FatherRhinehardt.getCurrentMight(), 7);
	}
	@Test 
	public void testDecrementMight() {
		Assert.assertEquals(FatherRhinehardt.getCurrentMight(), 2);
		FatherRhinehardt.decrementMight();
		Assert.assertEquals(FatherRhinehardt.getCurrentMight(), 2);
		FatherRhinehardt.decrementMight();
		Assert.assertEquals(FatherRhinehardt.getCurrentMight(), 1);
		FatherRhinehardt.decrementMight();
		Assert.assertEquals(FatherRhinehardt.getCurrentMight(), 1);
		FatherRhinehardt.decrementMight();
		Assert.assertEquals(FatherRhinehardt.getCurrentMight(), 1);
	}
	@Test 
	public void testIncrementSpeed() {
		Assert.assertEquals(FatherRhinehardt.getCurrentSpeed(), 3);
		FatherRhinehardt.incrementSpeed();
		Assert.assertEquals(FatherRhinehardt.getCurrentSpeed(), 4);
		FatherRhinehardt.incrementSpeed();
		Assert.assertEquals(FatherRhinehardt.getCurrentSpeed(), 5);
		FatherRhinehardt.incrementSpeed();
		Assert.assertEquals(FatherRhinehardt.getCurrentSpeed(), 6);
		FatherRhinehardt.incrementSpeed();
		Assert.assertEquals(FatherRhinehardt.getCurrentSpeed(), 7);
		FatherRhinehardt.incrementSpeed();
		Assert.assertEquals(FatherRhinehardt.getCurrentSpeed(), 7);
		FatherRhinehardt.incrementSpeed();
		Assert.assertEquals(FatherRhinehardt.getCurrentSpeed(), 7);
		FatherRhinehardt.incrementSpeed();
		Assert.assertEquals(FatherRhinehardt.getCurrentSpeed(), 7);
	}
	@Test 
	public void testDecrementSpeed() {
		Assert.assertEquals(FatherRhinehardt.getCurrentSpeed(), 3);
		FatherRhinehardt.decrementSpeed();
		Assert.assertEquals(FatherRhinehardt.getCurrentSpeed(), 3);
		FatherRhinehardt.decrementSpeed();
		Assert.assertEquals(FatherRhinehardt.getCurrentSpeed(), 2);
		FatherRhinehardt.decrementSpeed();
		Assert.assertEquals(FatherRhinehardt.getCurrentSpeed(), 2);
		FatherRhinehardt.decrementSpeed();
		Assert.assertEquals(FatherRhinehardt.getCurrentSpeed(), 2);
	}
	
	@Test
	public void testGetAttributeIndexes() {
		Assert.assertEquals(((HumanStats) FatherRhinehardt.getStats()).getCurrentKnowledgeIndex(), 3);
		Assert.assertEquals(((HumanStats) FatherRhinehardt.getStats()).getCurrentSanityIndex(), 4);
		Assert.assertEquals(((HumanStats) FatherRhinehardt.getStats()).getCurrentMightIndex(), 2);
		Assert.assertEquals(((HumanStats) FatherRhinehardt.getStats()).getCurrentSpeedIndex(), 2);
		
		FatherRhinehardt.decrementKnowledge();
		FatherRhinehardt.decrementSanity();
		FatherRhinehardt.decrementMight();
		FatherRhinehardt.decrementSpeed();
		
		Assert.assertEquals(((HumanStats) FatherRhinehardt.getStats()).getCurrentKnowledgeIndex(), 2);
		Assert.assertEquals(((HumanStats) FatherRhinehardt.getStats()).getCurrentSanityIndex(), 3);
		Assert.assertEquals(((HumanStats) FatherRhinehardt.getStats()).getCurrentMightIndex(), 1);
		Assert.assertEquals(((HumanStats) FatherRhinehardt.getStats()).getCurrentSpeedIndex(), 1);
		
		FatherRhinehardt.decrementKnowledge();
		FatherRhinehardt.decrementSanity();
		FatherRhinehardt.decrementMight();
		FatherRhinehardt.decrementSpeed();
		
		Assert.assertEquals(((HumanStats) FatherRhinehardt.getStats()).getCurrentKnowledgeIndex(), 1);
		Assert.assertEquals(((HumanStats) FatherRhinehardt.getStats()).getCurrentSanityIndex(), 2);
		Assert.assertEquals(((HumanStats) FatherRhinehardt.getStats()).getCurrentMightIndex(), 0);
		Assert.assertEquals(((HumanStats) FatherRhinehardt.getStats()).getCurrentSpeedIndex(), 0);
		
		FatherRhinehardt.incrementKnowledge();
		FatherRhinehardt.incrementSanity();
		FatherRhinehardt.incrementMight();
		FatherRhinehardt.incrementSpeed();
		
		Assert.assertEquals(((HumanStats) FatherRhinehardt.getStats()).getCurrentKnowledgeIndex(), 2);
		Assert.assertEquals(((HumanStats) FatherRhinehardt.getStats()).getCurrentSanityIndex(), 3);
		Assert.assertEquals(((HumanStats) FatherRhinehardt.getStats()).getCurrentMightIndex(), 1);
		Assert.assertEquals(((HumanStats) FatherRhinehardt.getStats()).getCurrentSpeedIndex(), 1);
		
	}
	
	@Test
	public void testOmenHand() {
		OmenCard card = new CrystalBall("test","test 2");
		
		FatherRhinehardt.addOmenCard(card);
		
		ArrayList<OmenCard> oHand = FatherRhinehardt.getOmenHand();
		
		Assert.assertEquals(oHand.size(), 1);
		
		Assert.assertTrue(oHand.contains(card));
		
		FatherRhinehardt.removeOmenCard(card);
		
		Assert.assertEquals(oHand.size(), 0);
		
		Assert.assertFalse(oHand.contains(card));
		
	}
	
	@Test
	public void testItemHand() {
		ItemCard card = new AngelFeather(null, null);
		
		FatherRhinehardt.addItemCard(card);
		
		ArrayList<ItemCard> oHand = FatherRhinehardt.getItemHand();
		
		Assert.assertEquals(oHand.size(), 1);
		
		Assert.assertTrue(oHand.contains(card));
		
		FatherRhinehardt.removeItemCard(card);
		
		Assert.assertEquals(oHand.size(), 0);
		
		Assert.assertFalse(oHand.contains(card));
	}
	
	@Test
	public void testEventHand() {
		EventCard card = new Rotten(null, null);
		
		FatherRhinehardt.addEventCard(card);
		
		ArrayList<EventCard> oHand = FatherRhinehardt.getEventHand();
		
		Assert.assertEquals(oHand.size(), 1);
		
		Assert.assertTrue(oHand.contains(card));
		
		FatherRhinehardt.removeEventCard(card);
		
		Assert.assertEquals(oHand.size(), 0);
		
		Assert.assertFalse(oHand.contains(card));

	}

	@Test
	public void TestMonsterInit(){
		MonsterType m = new MonsterType(Monsters.Temp_Monster1);
		
		Assert.assertEquals(m.getCurrentMight(), 1);
		Assert.assertEquals(m.getCurrentSpeed(), 1);
		Assert.assertEquals(m.getCurrentSanity(), 1);
		Assert.assertEquals(m.getCurrentKnowledge(), 1);
	}
	

}
