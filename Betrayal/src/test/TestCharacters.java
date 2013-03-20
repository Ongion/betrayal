package test;

import static org.junit.Assert.*;

import java.util.HashMap;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import rooms.Room;
import rooms.Room.Exit_Direction;
import rooms.Room.Room_Orientation;

import characters.Character;
import characters.FatherRhinehardt;

public class TestCharacters {
	
	@Test
	public void testInitialization() {
		Character c = new FatherRhinehardt();
		Assert.assertNotNull(c);
	}
	
	@Test
	public void testGetName() {
		Character c = new FatherRhinehardt();
		
		Assert.assertEquals(c.getName(), "Father Rhinehardt");
	}
	
	@Test
	public void testGetAge() {
		Character c = new FatherRhinehardt();
		
		Assert.assertEquals(c.getAge(), 62);
	}
	
	@Test
	public void testGetHeight() {
		Character c = new FatherRhinehardt();
		
		Assert.assertEquals(c.getHeight(), 69);
	}
	
	@Test
	public void testGetWeight() {
		Character c = new FatherRhinehardt();
		
		Assert.assertEquals(c.getWeight(), 185);
	}
	
	@Test
	public void testGetHobbies() {
		Character c = new FatherRhinehardt();
		String[] compare = {"Fencing","Gardening"};
		
		Assert.assertEquals(c.getHobbies().length, compare.length);
		for (int i = 0; i < compare.length; i ++){
			Assert.assertEquals(c.getHobbies()[i], compare[i] );
		}
		
	}
	
	@Test 
	public void testIncrementKnowledge() {
		Character c = new FatherRhinehardt();
		
		Assert.assertEquals(c.getCurrentKnowledge(), 4);
		c.incrementKnowledge();
		Assert.assertEquals(c.getCurrentKnowledge(), 5);
		c.incrementKnowledge();
		Assert.assertEquals(c.getCurrentKnowledge(), 6);
		c.incrementKnowledge();
		Assert.assertEquals(c.getCurrentKnowledge(), 6);
		c.incrementKnowledge();
		Assert.assertEquals(c.getCurrentKnowledge(), 8);
		c.incrementKnowledge();
		Assert.assertEquals(c.getCurrentKnowledge(), 8);
	}
	
	@Test 
	public void testDecrementKnowledge() {
		Character c = new FatherRhinehardt();
		
		Assert.assertEquals(c.getCurrentKnowledge(), 4);
		c.decrementKnowledge();
		Assert.assertEquals(c.getCurrentKnowledge(), 3);
		c.decrementKnowledge();
		Assert.assertEquals(c.getCurrentKnowledge(), 3);
		c.decrementKnowledge();
		Assert.assertEquals(c.getCurrentKnowledge(), 1);
		c.decrementKnowledge();
		Assert.assertEquals(c.getCurrentKnowledge(), 1);
	}
	

}
