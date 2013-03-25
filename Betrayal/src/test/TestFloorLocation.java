package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import floors.FloorLocation;

public class TestFloorLocation {
	
	private FloorLocation floorLocation1;
	private FloorLocation floorLocation2;
	
	@Before
	public void setUp() {
		floorLocation1 = new FloorLocation(0,0);
		floorLocation2 = new FloorLocation(5,7);
	}

	@Test
	public void testGetFloorLocationX() {
		assertEquals(0,floorLocation1.getX());
		assertEquals(5,floorLocation2.getX());
	}
	
	@Test
	public void testGetFloorLocationY() {
		assertEquals(0, floorLocation1.getY());
		assertEquals(7,floorLocation2.getY());
	}
	
	@Test
	public void testToString() {
		assertEquals("(0,0)", floorLocation1.toString());
		assertEquals("(5,7)", floorLocation2.toString());
	}
	
	@Test
	public void testEquals() {
		assertEquals(new FloorLocation(0,0), floorLocation1);
		assertEquals(new FloorLocation(5,7), floorLocation2);
		assertFalse(floorLocation1.equals(new FloorLocation(0,5)));
	}

}
