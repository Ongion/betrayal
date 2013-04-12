package test;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import rooms.CatacombsRoom;
import rooms.ChasmRoom;
import rooms.EventRoom;
import rooms.NormalRoom;
import rooms.OmenRoom;
import rooms.PentagramChamberRoom;
import rooms.Room;
import rooms.Room.Floor_Name;
import rooms.Room.Relative_Direction;
import rooms.Room.Room_Orientation;
import Game.Game;
import floors.Location;
import characters.Explorer;

public class TestRooms {
	Room organRoom;
	Room gardens;
	Room basementLanding;
	Room catacombs;
	Room diningRoom;
	Room creakyHallway;
	Room servantsQuarters;
	Room masterBedroom;
	Room bedroom;
	Room chasm;
	Room pentagramChamber;
	Explorer zoeIngstrom;
	
	@Before
	public void setUp() {
		Game.resetGame();
		HashSet<Relative_Direction> gardensExits = new HashSet<Relative_Direction>();
		gardensExits.add(Relative_Direction.NORTH);
		gardensExits.add(Relative_Direction.SOUTH);
		HashSet<Floor_Name> gardensFloors = new HashSet<Floor_Name>();
		gardensFloors.add(Floor_Name.GROUND);
		gardens = new EventRoom("Garden", gardensExits, gardensFloors);
//		game.addRoomToMap(gardens);
		gardens.setPlacement(Room_Orientation.EAST, new Location(Floor_Name.GROUND, 0 , 0), true);

		HashSet<Relative_Direction> organRoomExits = new HashSet<Relative_Direction>();
		organRoomExits.add(Relative_Direction.SOUTH);
		organRoomExits.add(Relative_Direction.WEST);
		HashSet<Floor_Name> organRoomFloors = new HashSet<Floor_Name>();
		organRoomFloors.add(Floor_Name.UPPER);
		organRoomFloors.add(Floor_Name.GROUND);
		organRoomFloors.add(Floor_Name.BASEMENT);
		organRoom = new EventRoom("Organ Room", organRoomExits, organRoomFloors);
		organRoom.setPlacement(Room_Orientation.WEST, new Location(Floor_Name.GROUND, -1 , 0));	
		
		HashSet<Relative_Direction> diningRoomExits = new HashSet<Relative_Direction>();
		diningRoomExits.add(Relative_Direction.NORTH);
		diningRoomExits.add(Relative_Direction.EAST);
		HashSet<Floor_Name> diningRoomFloors = new HashSet<Floor_Name>();
		diningRoomFloors.add(Floor_Name.GROUND);
		HashMap<Relative_Direction, Integer> diningRoomWindows = new HashMap<Relative_Direction, Integer>();
		diningRoomWindows.put(Relative_Direction.WEST, 2);
		diningRoom = new OmenRoom("Dining Room", diningRoomExits, diningRoomFloors, diningRoomWindows);
		diningRoom.setPlacement(Room_Orientation.NORTH, new Location(Floor_Name.GROUND, -1, -1));

		HashSet<Relative_Direction> basementLandingExits = new HashSet<Relative_Direction>();
		basementLandingExits.add(Relative_Direction.NORTH);
		basementLandingExits.add(Relative_Direction.EAST);
		basementLandingExits.add(Relative_Direction.SOUTH);
		basementLandingExits.add(Relative_Direction.WEST);
		HashSet<Floor_Name> basementLandingFloors = new HashSet<Floor_Name>();
		basementLandingFloors.add(Floor_Name.BASEMENT);
		basementLanding = new NormalRoom("Basement Landing", basementLandingExits, basementLandingFloors);
		basementLanding.setPlacement(Room_Orientation.NORTH, new Location(Floor_Name.BASEMENT, 0, 0), true);
		
		HashSet<Relative_Direction> catacombsExits = new HashSet<Relative_Direction>();
		catacombsExits.add(Relative_Direction.NORTH);
		catacombsExits.add(Relative_Direction.SOUTH);
		HashSet<Floor_Name> catacombsFloors = new HashSet<Floor_Name>();
		catacombsFloors.add(Floor_Name.BASEMENT);
		catacombs = new CatacombsRoom("Catacombs", catacombsExits, catacombsFloors);
		catacombs.setPlacement(Room_Orientation.EAST, new Location(Floor_Name.BASEMENT, 1, 0));
		
		HashSet<Relative_Direction> chasmExits = new HashSet<Relative_Direction>();
		chasmExits.add(Relative_Direction.EAST);
		chasmExits.add(Relative_Direction.WEST);
		HashSet<Floor_Name> chasmFloors = new HashSet<Floor_Name>();
		chasmFloors.add(Floor_Name.BASEMENT);
		chasm = new ChasmRoom("Chasm", chasmExits, chasmFloors);
		chasm.setPlacement(Room_Orientation.WEST, new Location(Floor_Name.BASEMENT, 0, 1));
		
		HashSet<Relative_Direction> pentagramChamberExits = new HashSet<Relative_Direction>();
		pentagramChamberExits.add(Relative_Direction.EAST);
		HashSet<Floor_Name> pentagramChamberFloors = new HashSet<Floor_Name>();
		pentagramChamberFloors.add(Floor_Name.BASEMENT);
		pentagramChamber = new PentagramChamberRoom("Pentagram Chamber", pentagramChamberExits, pentagramChamberFloors);
		pentagramChamber.setPlacement(Room_Orientation.NORTH, new Location(Floor_Name.BASEMENT, -1, 0));
		
		HashSet<Relative_Direction> creakyHallwayExits = new HashSet<Relative_Direction>();
		creakyHallwayExits.add(Relative_Direction.NORTH);
		creakyHallwayExits.add(Relative_Direction.EAST);
		creakyHallwayExits.add(Relative_Direction.SOUTH);
		creakyHallwayExits.add(Relative_Direction.WEST);
		HashSet<Floor_Name> creakyHallwayFloors = new HashSet<Floor_Name>();
		creakyHallwayFloors.add(Floor_Name.UPPER);
		creakyHallwayFloors.add(Floor_Name.GROUND);
		creakyHallwayFloors.add(Floor_Name.BASEMENT);
		creakyHallway = new NormalRoom("Creaky Hallway", creakyHallwayExits, creakyHallwayFloors);
		creakyHallway.setPlacement(Room_Orientation.NORTH, new Location(Floor_Name.UPPER, 5, 5), true);
		
		HashSet<Relative_Direction> servantsQuartersExits = new HashSet<Relative_Direction>();
		servantsQuartersExits.add(Relative_Direction.NORTH);
		servantsQuartersExits.add(Relative_Direction.EAST);
		servantsQuartersExits.add(Relative_Direction.SOUTH);
		servantsQuartersExits.add(Relative_Direction.WEST);
		HashSet<Floor_Name> servantsQuartersFloors = new HashSet<Floor_Name>();
		servantsQuartersFloors.add(Floor_Name.UPPER);
		servantsQuartersFloors.add(Floor_Name.BASEMENT);
		servantsQuarters = new OmenRoom("Servant's Quarters", servantsQuartersExits, servantsQuartersFloors);
		servantsQuarters.setPlacement(Room_Orientation.NORTH, new Location(Floor_Name.UPPER, 6, 5));
		
		HashSet<Relative_Direction> masterBedroomExits = new HashSet<Relative_Direction>();
		masterBedroomExits.add(Relative_Direction.NORTH);
		masterBedroomExits.add(Relative_Direction.WEST);
		HashSet<Floor_Name> masterBedroomFloors = new HashSet<Floor_Name>();
		masterBedroomFloors.add(Floor_Name.UPPER);
		HashMap<Relative_Direction, Integer> masterBedroomWindows = new HashMap<Relative_Direction, Integer>();
		masterBedroomWindows.put(Relative_Direction.SOUTH, 2);
		masterBedroom = new OmenRoom("Master Bedroom", masterBedroomExits, masterBedroomFloors, masterBedroomWindows);
		masterBedroom.setPlacement(Room_Orientation.SOUTH, new Location(Floor_Name.UPPER, 5, 6));
		
		HashSet<Relative_Direction> bedroomExits = new HashSet<Relative_Direction>();
		bedroomExits.add(Relative_Direction.EAST);
		bedroomExits.add(Relative_Direction.WEST);
		HashSet<Floor_Name> bedroomFloors = new HashSet<Floor_Name>();
		bedroomFloors.add(Floor_Name.UPPER);
		HashMap<Relative_Direction, Integer> bedroomWindows = new HashMap<Relative_Direction, Integer>();
		bedroomWindows.put(Relative_Direction.SOUTH, 1);
		bedroom = new EventRoom("Bedroom", bedroomExits, bedroomFloors, bedroomWindows);
		bedroom.setPlacement(Room_Orientation.NORTH, new Location(Floor_Name.UPPER, 6, 6));

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
		gardens.setPlacement(Room_Orientation.WEST, gardens.getLocation());
		assertEquals(Room_Orientation.WEST, gardens.getOrientation());
		
		try {
			organRoom.setPlacement(Room_Orientation.SOUTH, organRoom.getLocation());
		} catch (RuntimeException e) {
			assertEquals("New placement invalidates map state!", e.getMessage());
		}
		
		assertEquals(Room_Orientation.WEST, organRoom.getOrientation());
	}
		
	@Test
	public void testGetFloorRoomIsOn() {
		assertEquals(Floor_Name.GROUND, organRoom.getFloor());
		assertEquals(Floor_Name.BASEMENT, catacombs.getFloor());
		assertEquals(Floor_Name.UPPER, masterBedroom.getFloor());
	}
	
	@Test
	public void testGetRoomFromExit() {
		assertEquals(gardens, organRoom.getRoomFromExit(Relative_Direction.SOUTH));
		assertEquals(organRoom, gardens.getRoomFromExit(Relative_Direction.SOUTH));
		
		assertEquals(catacombs, basementLanding.getRoomFromExit(Relative_Direction.EAST));
		assertEquals(basementLanding, catacombs.getRoomFromExit(Relative_Direction.SOUTH));
		
		assertEquals(null, servantsQuarters.getRoomFromExit(Relative_Direction.NORTH));
	}
	
	@Test
	public void testGetExternalWindows() {
		assertEquals(0, gardens.getExternalWindows());
		assertEquals(2, diningRoom.getExternalWindows());
		assertEquals(2, masterBedroom.getExternalWindows());
		assertEquals(0, bedroom.getExternalWindows());
	}

	
	@Test
	public void testMovingRooms() {
		servantsQuarters.setPlacement(Room_Orientation.WEST, new Location(Floor_Name.BASEMENT, 2, 0));
		assertEquals(1, bedroom.getExternalWindows());
		assertEquals(catacombs, servantsQuarters.getRoomFromExit(Relative_Direction.NORTH));
		
		try {
			servantsQuarters.setPlacement(Room_Orientation.SOUTH, new Location(Floor_Name.GROUND, 0, -1));
		} catch (RuntimeException e) {
			assertEquals("The Servant's Quarters is not allowed on the GROUND floor", e.getMessage());
		}
		
		try {
			servantsQuarters.setPlacement(servantsQuarters.getOrientation(), new Location(Floor_Name.BASEMENT, 0, 0));
		} catch (RuntimeException e) {
			assertEquals("The Basement Landing is already at that location", e.getMessage());
		}
		
		assertEquals(servantsQuarters.getOrientation(), Room_Orientation.WEST);
		assertEquals(servantsQuarters.getFloor(), Floor_Name.BASEMENT);
	}

}
