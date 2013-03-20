package test;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

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

}
