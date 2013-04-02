package test;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import floors.Floor;
import floors.Floor.FloorName;
import floors.FloorLocation;

import rooms.EventRoom;
import rooms.Room;
import rooms.Room.Room_Direction;
import rooms.Room.Room_Orientation;

public class TestRooms {
	Room organRoom;
	Floor groundFloor;
	
	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Before
	public void setUp() {
		this.groundFloor = new Floor(FloorName.ground);
		HashSet<Room_Direction> organRoomExits = new HashSet<Room_Direction>();
		
		organRoomExits.add(Room_Direction.SOUTH);
		organRoomExits.add(Room_Direction.WEST);
				
		organRoom = new EventRoom("Organ Room", Room_Orientation.WEST, organRoomExits);
		this.groundFloor.addRoom(new FloorLocation(0,0), organRoom);
	}
	
	@Test
	public void testGetRoomNameReturnsProperName() {
		assertEquals("Organ Room", organRoom.getName());
	}
	
	@Test
	public void testGetRoomExitDirections() {
		HashSet<Room_Direction> expectedOrganRoomExits = new HashSet<Room_Direction>();
		expectedOrganRoomExits.add(Room_Direction.SOUTH);
		expectedOrganRoomExits.add(Room_Direction.WEST);
		assertEquals(expectedOrganRoomExits, organRoom.getDoorExits());
	}
	
	@Test
	public void testGetSetRoomOrientation() {
		organRoom.setOrientation(Room_Orientation.WEST);

		assertEquals(Room_Orientation.WEST, organRoom.getOrientation());
	}
	
	@Test
	public void testGetFloorRoomIsOn() {
		assertEquals(FloorName.ground, this.organRoom.getFloor().getName());
	}
	
}
