package test;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import rooms.EventRoom;
import rooms.NormalRoom;
import rooms.Room;
import rooms.Room.Floor_Name;
import rooms.Room.Relative_Direction;
import rooms.Room.Room_Orientation;
import Game.Game;
import floors.Location;

public class TestRooms {
	Room organRoom;
	Room gardens;
	Room basementLanding;
	
	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Before
	public void setUp() {
		Game.resetGame();
		Game game = Game.getInstance();
		HashSet<Relative_Direction> gardensExits = new HashSet<Relative_Direction>();
		gardensExits.add(Relative_Direction.NORTH);
		gardensExits.add(Relative_Direction.SOUTH);
		HashSet<Floor_Name> gardensFloors = new HashSet<Floor_Name>();
		gardensFloors.add(Floor_Name.GROUND);
		gardens = new EventRoom("Garden", Room_Orientation.EAST, gardensExits, gardensFloors);
		gardens.setLocation(new Location(Floor_Name.GROUND, 0 , 0), true);
		game.addRoomToMap(gardens);

		HashSet<Relative_Direction> organRoomExits = new HashSet<Relative_Direction>();
		organRoomExits.add(Relative_Direction.SOUTH);
		organRoomExits.add(Relative_Direction.WEST);
		HashSet<Floor_Name> organRoomFloors = new HashSet<Floor_Name>();
		organRoomFloors.add(Floor_Name.UPPER);
		organRoomFloors.add(Floor_Name.GROUND);
		organRoomFloors.add(Floor_Name.BASEMENT);
		organRoom = new EventRoom("Organ Room", Room_Orientation.WEST, organRoomExits, organRoomFloors);
		organRoom.setLocation(new Location(Floor_Name.GROUND, -1 , 0));	
		game.addRoomToMap(organRoom);

		HashSet<Relative_Direction> basementLandingExits = new HashSet<Relative_Direction>();
		basementLandingExits.add(Relative_Direction.NORTH);
		basementLandingExits.add(Relative_Direction.EAST);
		basementLandingExits.add(Relative_Direction.SOUTH);
		basementLandingExits.add(Relative_Direction.WEST);
		HashSet<Floor_Name> basementLandingFloors = new HashSet<Floor_Name>();
		basementLandingFloors.add(Floor_Name.BASEMENT);
		basementLanding = new NormalRoom("Basement Landing", Room_Orientation.NORTH, basementLandingExits, basementLandingFloors);

		
	}
	
	@Test
	public void testGetRoomNameReturnsProperName() {
		assertEquals("Organ Room", organRoom.getName());
	}
	
	@Test
	public void testGetRoomExitDirections() {
		HashSet<Relative_Direction> expectedOrganRoomExits = new HashSet<Relative_Direction>();
		expectedOrganRoomExits.add(Relative_Direction.SOUTH);
		expectedOrganRoomExits.add(Relative_Direction.WEST);
		assertEquals(expectedOrganRoomExits, organRoom.getExits());
	}
	
	@Test
	public void testGetSetRoomOrientation() {
		organRoom.setOrientation(Room_Orientation.SOUTH);

		assertEquals(Room_Orientation.SOUTH, organRoom.getOrientation());
	}
	
	@Test
	public void testGetFloorRoomIsOn() {
		assertEquals(Floor_Name.GROUND, this.organRoom.getFloor());
	}
	
	@Test
	public void testGetNextdoorRooms() {
		assertEquals(gardens, organRoom.getRoomFromExit(Relative_Direction.SOUTH));
		assertEquals(organRoom, gardens.getRoomFromExit(Relative_Direction.SOUTH));
	}

}
