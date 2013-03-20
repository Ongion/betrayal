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

}
