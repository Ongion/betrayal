package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import floors.Floor;
import floors.Floor.FloorName;

public class TestFloor {
	
	private Floor basementFloor;
	private Floor groundFloor;
	private Floor upperFloor;
	
	@Before
	public void setUp() {
		this.basementFloor = new Floor(FloorName.basement);
		this.groundFloor = new Floor(FloorName.ground);
		this.upperFloor = new Floor(FloorName.upper);
	}

	@Test
	public void testFloorName() {
		assertEquals(FloorName.basement, this.basementFloor.getName());
		assertEquals(FloorName.ground, this.groundFloor.getName());
		assertEquals(FloorName.upper, this.upperFloor.getName());
	}

}
