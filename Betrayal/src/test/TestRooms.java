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

import Game.Game;

import rooms.EventRoom;
import rooms.Room;
import rooms.Room.Floor_Name;
import rooms.Room.Room_Direction;
import rooms.Room.Room_Orientation;

public class TestRooms {
	Room organRoom;
	Room gardens;
	
	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Before
	public void setUp() {
		Game.resetGame();
		Game game = Game.getInstance();
		HashSet<Room_Direction> organRoomExits = new HashSet<Room_Direction>();
		HashSet<Room_Direction> gardensExits = new HashSet<Room_Direction>();
		
		organRoomExits.add(Room_Direction.SOUTH);
		organRoomExits.add(Room_Direction.WEST);
		
		gardensExits.add(Room_Direction.NORTH);
		gardensExits.add(Room_Direction.SOUTH);
		
		HashSet<Floor_Name> organRoomFloors = new HashSet<Floor_Name>();
		HashSet<Floor_Name> gardensFloors = new HashSet<Floor_Name>();
		
		organRoomFloors.add(Floor_Name.UPPER);
		organRoomFloors.add(Floor_Name.GROUND);
		organRoomFloors.add(Floor_Name.BASEMENT);
		
		gardensFloors.add(Floor_Name.GROUND);
		
		organRoom = new EventRoom("Organ Room", Room_Orientation.WEST, organRoomExits, organRoomFloors);
		gardens = new EventRoom("Garden", Room_Orientation.EAST, gardensExits, gardensFloors);
		
		gardens.setLocation(Floor_Name.GROUND, new FloorLocation(0,0), true);
		game.addRoomToMap(gardens);

		organRoom.setLocation(Floor_Name.GROUND, new FloorLocation(-1,0));	
		game.addRoomToMap(organRoom);
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
		assertEquals(Floor_Name.GROUND, this.organRoom.getFloor());
	}
	
	@Test
	public void testGetNextdoorRooms() {
		assertEquals(gardens, organRoom.getRoomFromExit(Room_Direction.SOUTH));
		assertEquals(organRoom, gardens.getRoomFromExit(Room_Direction.SOUTH));
	}

}
