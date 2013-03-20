package test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import rooms.FoyerRoom;
import rooms.OrganRoomRoom;
import rooms.Room;
import rooms.Room.Room_Orientation;
import rooms.Room.Exit_Direction;

public class TestRooms {
	Room foyer;
	Room organRoom;
	
	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Before
	public void setUp() {
				
		foyer = new FoyerRoom();		
		organRoom = new OrganRoomRoom();
	}
	
	@Test
	public void testGetRoomNameReturnsProperName() {
		assertEquals("Organ Room", organRoom.getName());
	}
	
	@Test
	public void testGetRoomExitDirections() {
		HashSet<Exit_Direction> expectedOrganRoomExits = new HashSet<Exit_Direction>();
		expectedOrganRoomExits.add(Exit_Direction.SOUTH);
		expectedOrganRoomExits.add(Exit_Direction.WEST);
		assertEquals(expectedOrganRoomExits, organRoom.getRoomExitDirections());
	}
	
	@Test
	public void testGetRoomOrientation() {
		organRoom.setOrientation(Room_Orientation.WEST);

		assertEquals(Room_Orientation.WEST, organRoom.getOrientation());
		assertEquals(Room_Orientation.NORTH, foyer.getOrientation());
	}
	
	@Test
	public void testGetConnectingRooms() {
		foyer.addRoomExit(Exit_Direction.EAST, organRoom);
		organRoom.addRoomExit(Exit_Direction.SOUTH, foyer);
		
		assertEquals(organRoom, foyer.getRoomFromExit(Exit_Direction.EAST));
		assertEquals(foyer, organRoom.getRoomFromExit(Exit_Direction.SOUTH));
	}
	
	@Test
	public void testAddingARoomToANonExistingExitThrowsException() {
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Room 'Organ Room' has no exit in direction 'NORTH'");
		organRoom.addRoomExit(Exit_Direction.NORTH, foyer);
	}

}
