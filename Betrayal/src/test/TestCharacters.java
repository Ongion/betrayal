package test;

import java.util.Locale;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import characters.Character;

public class TestCharacters {
	
	Character FatherRhinehardt;
	
	@Before
	public void initializeTests(){
		FatherRhinehardt = new Character(0,new Locale("en"));
	}
	
	@Test
	public void testInitialization() {
		Assert.assertNotNull(FatherRhinehardt);
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
	

}
