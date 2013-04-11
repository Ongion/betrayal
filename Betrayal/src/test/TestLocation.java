package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import rooms.Room.Floor_Name;

import floors.Location;

public class TestLocation {
	
	private Location floorLocation1;
	private Location floorLocation2;
	
	@Before
	public void setUp() {
		floorLocation1 = new Location(Floor_Name.BASEMENT, 0, 0);
		floorLocation2 = new Location(Floor_Name.UPPER, 5, 7);
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
		assertEquals("BASEMENT(0,0)", floorLocation1.toString());
		assertEquals("UPPER(5,7)", floorLocation2.toString());
	}
	
	@Test
	public void testEquals() {
		assertEquals(new Location(Floor_Name.BASEMENT, 0, 0), floorLocation1);
		assertEquals(new Location(Floor_Name.UPPER, 5, 7), floorLocation2);
		assertFalse(floorLocation1.equals(new Location(Floor_Name.BASEMENT, 0, 5)));
		assertFalse(floorLocation1.equals(new Location(Floor_Name.GROUND, 0, 0)));
	}

}
