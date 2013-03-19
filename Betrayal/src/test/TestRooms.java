package test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

import rooms.BlankRoom;
import rooms.EventRoom;
import rooms.Room;
import rooms.Room.Room_Orientation;
import rooms.Room.Exit_Direction;

public class TestRooms {
	Room foyer;
	Room organRoom;
	

	@Before
	public void setUp() {
		HashMap<Exit_Direction, Room> foyerExits = new HashMap<Exit_Direction, Room>();
		HashMap<Exit_Direction, Room> organRoomExits = new HashMap<Exit_Direction, Room>();
		
		foyerExits.put(Exit_Direction.EAST, null);
		foyerExits.put(Exit_Direction.WEST, null);
		
		organRoomExits.put(Exit_Direction.SOUTH, null);
		foyer = new BlankRoom("Foyer", Room_Orientation.NORTH, foyerExits);
		
		
		organRoom = new EventRoom("Organ Room", Room_Orientation.WEST, organRoomExits);
	}
		
	@Test
	public void testGetRoomNameReturnsProperName() {
		assertEquals("Organ Room", organRoom.getName());
	}
	
	@Test
	public void testGetRoomExitDirections() {
		HashSet<Exit_Direction> expectedOrganRoomExits = new HashSet<Exit_Direction>();
		expectedOrganRoomExits.add(Exit_Direction.SOUTH);
		assertEquals(expectedOrganRoomExits, organRoom.getRoomExitDirections());
	}
	
	@Test
	public void testGetRoomOrientation() {
		assertEquals(Room_Orientation.WEST, organRoom.getOrientation());
	}

}
