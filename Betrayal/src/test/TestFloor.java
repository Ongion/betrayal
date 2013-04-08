package test;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

import rooms.EventRoom;
import rooms.Room;
import rooms.Room.Room_Direction;
import rooms.Room.Room_Orientation;

import floors.Floor;
import floors.Floor.FloorName;
import floors.FloorLocation;

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
	
	@Test
	public void testGetNextdoorRooms() {
		HashSet<Room_Direction> organRoomExits = new HashSet<Room_Direction>();
		HashSet<Room_Direction> gardensExits = new HashSet<Room_Direction>();
		
		organRoomExits.add(Room_Direction.SOUTH);
		organRoomExits.add(Room_Direction.WEST);
		
		gardensExits.add(Room_Direction.NORTH);
		gardensExits.add(Room_Direction.SOUTH);
		
		HashSet<FloorName> organRoomFloors = new HashSet<FloorName>();
		HashSet<FloorName> gardensFloors = new HashSet<FloorName>();
		
		organRoomFloors.add(FloorName.upper);
		organRoomFloors.add(FloorName.ground);
		organRoomFloors.add(FloorName.basement);
		
		gardensFloors.add(FloorName.ground);
		
		Room organRoom = new EventRoom("Organ Room", Room_Orientation.WEST, organRoomExits, organRoomFloors);
		Room gardens = new EventRoom("Garden", Room_Orientation.EAST, gardensExits, gardensFloors);
		
		this.groundFloor.addRoom(new FloorLocation(-1, 0), organRoom);
		this.groundFloor.addRoom(new FloorLocation(0,0), gardens);
		
		assertEquals(gardens, this.groundFloor.getNextdoorRoomFromExit(new FloorLocation(-1,0), Room_Direction.SOUTH));
	}
	
	@Test
	public void testFloorContainsRoom() {
		HashSet<Room_Direction> organRoomExits = new HashSet<Room_Direction>();
		HashSet<Room_Direction> gardensExits = new HashSet<Room_Direction>();
		
		organRoomExits.add(Room_Direction.SOUTH);
		organRoomExits.add(Room_Direction.WEST);
		
		gardensExits.add(Room_Direction.NORTH);
		gardensExits.add(Room_Direction.SOUTH);
		
		HashSet<FloorName> organRoomFloors = new HashSet<FloorName>();
		HashSet<FloorName> gardensFloors = new HashSet<FloorName>();
		
		organRoomFloors.add(FloorName.upper);
		organRoomFloors.add(FloorName.ground);
		organRoomFloors.add(FloorName.basement);
		
		gardensFloors.add(FloorName.ground);
		
		Room organRoom = new EventRoom("Organ Room", Room_Orientation.WEST, organRoomExits, organRoomFloors);
		Room gardens = new EventRoom("Garden", Room_Orientation.EAST, gardensExits, gardensFloors);
		
		this.groundFloor.addRoom(new FloorLocation(-1, 0), organRoom);
		this.groundFloor.addRoom(new FloorLocation(0,0), gardens);

		assertTrue(this.groundFloor.containsRoomWithName("Organ Room"));
		assertTrue(this.groundFloor.containsRoomWithName("Garden"));
		
	}

}
