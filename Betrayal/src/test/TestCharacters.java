package test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Locale;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import rooms.Room;
import rooms.Room.Exit_Direction;
import rooms.Room.Room_Orientation;

import characters.Character;

public class TestCharacters {
	
	Character FatherRhinehardt, c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11;
	
	@Before
	public void initializeTests(){
		FatherRhinehardt = new Character(0,new Locale("en"));
		c1 = new Character(1,new Locale("en"));
		c2 = new Character(2,new Locale("en"));
		c3 = new Character(3,new Locale("en"));
		c4 = new Character(4,new Locale("en"));
		c5 = new Character(5,new Locale("en"));
		c6 = new Character(6,new Locale("en"));
		c7 = new Character(7,new Locale("en"));
		c8 = new Character(8,new Locale("en"));
		c9 = new Character(9,new Locale("en"));
		c10 = new Character(10,new Locale("en"));
		c11 = new Character(11,new Locale("en"));
		
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
		Assert.assertEquals(FatherRhinehardt.getCurrentKnowledgeIndex(), 3);
		Assert.assertEquals(FatherRhinehardt.getCurrentSanityIndex(), 2);
		Assert.assertEquals(FatherRhinehardt.getCurrentMightIndex(), 2);
		Assert.assertEquals(FatherRhinehardt.getCurrentSpeedIndex(), 4);
		
		FatherRhinehardt.decrementKnowledge();
		FatherRhinehardt.decrementSanity();
		FatherRhinehardt.decrementMight();
		FatherRhinehardt.decrementSpeed();
		
		Assert.assertEquals(FatherRhinehardt.getCurrentKnowledgeIndex(), 2);
		Assert.assertEquals(FatherRhinehardt.getCurrentSanityIndex(), 1);
		Assert.assertEquals(FatherRhinehardt.getCurrentMightIndex(), 1);
		Assert.assertEquals(FatherRhinehardt.getCurrentSpeedIndex(), 3);
		
		FatherRhinehardt.decrementKnowledge();
		FatherRhinehardt.decrementSanity();
		FatherRhinehardt.decrementMight();
		FatherRhinehardt.decrementSpeed();
		
		Assert.assertEquals(FatherRhinehardt.getCurrentKnowledgeIndex(), 1);
		Assert.assertEquals(FatherRhinehardt.getCurrentSanityIndex(), 0);
		Assert.assertEquals(FatherRhinehardt.getCurrentMightIndex(), 0);
		Assert.assertEquals(FatherRhinehardt.getCurrentSpeedIndex(), 2);
		
		FatherRhinehardt.incrementKnowledge();
		FatherRhinehardt.incrementSanity();
		FatherRhinehardt.incrementMight();
		FatherRhinehardt.incrementSpeed();
		
		Assert.assertEquals(FatherRhinehardt.getCurrentKnowledgeIndex(), 2);
		Assert.assertEquals(FatherRhinehardt.getCurrentSanityIndex(), 1);
		Assert.assertEquals(FatherRhinehardt.getCurrentMightIndex(), 1);
		Assert.assertEquals(FatherRhinehardt.getCurrentSpeedIndex(), 3);
		
	}
	

}
