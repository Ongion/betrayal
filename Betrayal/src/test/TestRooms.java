package test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import rooms.EventRoom;
import rooms.FoyerRoom;
import rooms.Room;
import rooms.Room.Room_Orientation;
import rooms.Room.Room_Direction;

public class TestRooms {
	Room foyer;
	Room organRoom;
	
	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Before
	public void setUp() {
		HashSet<Room_Direction> organRoomExits = new HashSet<Room_Direction>();
		
		organRoomExits.add(Room_Direction.SOUTH);
		organRoomExits.add(Room_Direction.WEST);
				
		organRoom = new EventRoom("Organ Room", Room_Orientation.WEST, organRoomExits);
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
	public void testGetRoomOrientation() {
		organRoom.setOrientation(Room_Orientation.WEST);

		assertEquals(Room_Orientation.WEST, organRoom.getOrientation());
		assertEquals(Room_Orientation.NORTH, foyer.getOrientation());
	}
	
}
