package test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import rooms.CatacombsRoom;
import rooms.ChasmRoom;
import rooms.EventRoom;
import rooms.JunkRoomRoom;
import rooms.NormalRoom;
import rooms.OmenRoom;
import rooms.PentagramChamberRoom;
import rooms.Room;
import rooms.Room.Floor_Name;
import rooms.Room.Relative_Direction;
import rooms.Room.Room_Orientation;
import Game.Game;
import characters.Character;
import characters.Explorer;
import characters.Explorer.Explorers;
import floors.Location;

public class TestPathfinding {
	
	Character c1, c2, c3, c4, c5, c6;
	
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
	Room junkRoom;
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
		gardens.setPlacement(Room_Orientation.EAST, new Location(Floor_Name.GROUND, 0 , 0));

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
		basementLanding.setPlacement(Room_Orientation.NORTH, new Location(Floor_Name.BASEMENT, 0, 0));
		
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
		
		HashSet<Relative_Direction> junkRoomExits = new HashSet<Relative_Direction>();
		junkRoomExits.add(Relative_Direction.NORTH);
		junkRoomExits.add(Relative_Direction.EAST);
		junkRoomExits.add(Relative_Direction.SOUTH);
		junkRoomExits.add(Relative_Direction.WEST);
		HashSet<Floor_Name> junkRoomFloors = new HashSet<Floor_Name>();
		junkRoomFloors.add(Floor_Name.UPPER);
		junkRoomFloors.add(Floor_Name.GROUND);
		junkRoomFloors.add(Floor_Name.BASEMENT);
		junkRoom = new JunkRoomRoom("Junk Room", junkRoomExits, junkRoomFloors);
		junkRoom.setPlacement(Room_Orientation.NORTH, new Location(Floor_Name.BASEMENT, 0, -1));
		
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
		creakyHallway.setPlacement(Room_Orientation.NORTH, new Location(Floor_Name.UPPER, 5, 5));
		
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

		c1 = new Explorer(Explorers.BrandonJaspers, new Locale("en"));
		c2 = new Explorer(Explorers.FatherRhinehardt, new Locale("en"));
		c3 = new Explorer(Explorers.DarrinWilliams, new Locale("en"));
		c4 = new Explorer(Explorers.HeatherGranville, new Locale("en"));
		c5 = new Explorer(Explorers.JennyLeClerc, new Locale("en"));
	}
	
	@Test
	public void testSimplePathfindingTwoCharacterFourRooms(){
		c1.setCurrentRoom(gardens);
		c2.setCurrentRoom(diningRoom);
		
		Game.getInstance().addCharacter(c1);
		Game.getInstance().addCharacter(c2);
		
		Character nearest = c1.getNearestCharacter();
		
		System.out.println(nearest);
		
		Assert.assertEquals(c2, nearest);
		//The only other character is the nearest one!
		Assert.assertEquals(c1,c2.getNearestCharacter());
		//Also works in reverse
	}
	
	@Test
	public void testSimplePathfindingThreeCharacterFourRooms(){
		c1.setCurrentRoom(gardens);
		c2.setCurrentRoom(organRoom);
		c3.setCurrentRoom(junkRoom);
		
		Game.getInstance().addCharacter(c1);
		Game.getInstance().addCharacter(c2);
		Game.getInstance().addCharacter(c3);
		
		Character nearest = c1.getNearestCharacter();
		
		Assert.assertEquals(c2, nearest);

	}
	
	@Test
	public void testPathfindingTwoCharacterEightRoomsNotFullExits(){
		Room r1, r2, r3, r4, r5, r6;
		HashSet<Relative_Direction> r1Exits = new HashSet<Relative_Direction>();
		r1Exits.add(Relative_Direction.NORTH);
		r1Exits.add(Relative_Direction.SOUTH);
		HashSet<Floor_Name> gardensFloors = new HashSet<Floor_Name>();
		gardensFloors.add(Floor_Name.GROUND);
		r1 = new EventRoom("Garden", r1Exits, gardensFloors);
		r1.setPlacement(Room_Orientation.EAST, new Location(Floor_Name.GROUND, 1 , 0));
		
		HashSet<Relative_Direction> r2Exits = new HashSet<Relative_Direction>();
		r2Exits.add(Relative_Direction.NORTH);
		r2Exits.add(Relative_Direction.EAST);
		r2 = new EventRoom("Garden", r2Exits, gardensFloors);
		r2.setPlacement(Room_Orientation.WEST, new Location(Floor_Name.GROUND, 2 , 0));
		
		r3 = new EventRoom("Garden", r2Exits, gardensFloors);
		r3.setPlacement(Room_Orientation.SOUTH, new Location(Floor_Name.GROUND, 2 , 1));
		
		r4 = new EventRoom("Garden", r1Exits, gardensFloors);
		r4.setPlacement(Room_Orientation.WEST, new Location(Floor_Name.GROUND, 1 , 1));
		
		HashSet<Relative_Direction> r5Exits = new HashSet<Relative_Direction>();
		r5Exits.add(Relative_Direction.NORTH);
		r5 = new EventRoom("Garden", r5Exits, gardensFloors);
		r5.setPlacement(Room_Orientation.EAST, new Location(Floor_Name.GROUND, 1 , 0));
		
		r6 = new EventRoom("Garden", r1Exits, gardensFloors);
		gardensFloors.add(Floor_Name.BASEMENT);
		r6.setPlacement(Room_Orientation.WEST, new Location(Floor_Name.BASEMENT, 100 , 100));
		
		c1.setCurrentRoom(r1);
		c2.setCurrentRoom(r5);
		c3.setCurrentRoom(r6); //Isn't on the same floor so won't be used for pathfinding. But will break my short circuit so adding it.
		
		Game.getInstance().addCharacter(c1);
		Game.getInstance().addCharacter(c2);
		Game.getInstance().addCharacter(c3);
		
		Assert.assertEquals(c2, c1.getNearestCharacter());
		Assert.assertEquals(c1, c2.getNearestCharacter());
	}

	@Test
	public void testMovingThroughMyTestRooms(){
		//This shoudln't be needed but I want to make sure you can get from r1 to r5
		//Cause Pathfinding is failing and I don't know why
		Game.resetGame();
		Room r1, r2, r3, r4, r5, r6;
		HashSet<Relative_Direction> r1Exits = new HashSet<Relative_Direction>();
		r1Exits.add(Relative_Direction.NORTH);
		r1Exits.add(Relative_Direction.SOUTH);
		HashSet<Floor_Name> gardensFloors = new HashSet<Floor_Name>();
		gardensFloors.add(Floor_Name.GROUND);
		r1 = new EventRoom("Garden", r1Exits, gardensFloors);
		r1.setPlacement(Room_Orientation.EAST, new Location(Floor_Name.GROUND, 1 , 0));
		
		HashSet<Relative_Direction> r2Exits = new HashSet<Relative_Direction>();
		r2Exits.add(Relative_Direction.NORTH);
		r2Exits.add(Relative_Direction.EAST);
		r2 = new EventRoom("Garden", r2Exits, gardensFloors);
		r2.setPlacement(Room_Orientation.WEST, new Location(Floor_Name.GROUND, 2 , 0));
		
		r3 = new EventRoom("Garden", r2Exits, gardensFloors);
		r3.setPlacement(Room_Orientation.SOUTH, new Location(Floor_Name.GROUND, 2 , 1));
		
		r4 = new EventRoom("Garden", r1Exits, gardensFloors);
		r4.setPlacement(Room_Orientation.WEST, new Location(Floor_Name.GROUND, 1 , 1));
		
		HashSet<Relative_Direction> r5Exits = new HashSet<Relative_Direction>();
		r5Exits.add(Relative_Direction.NORTH);
		r5 = new EventRoom("Garden", r5Exits, gardensFloors);
		r5.setPlacement(Room_Orientation.EAST, new Location(Floor_Name.GROUND, 0 , 1));
		
		r6 = new EventRoom("Garden", r1Exits, gardensFloors);
		gardensFloors.add(Floor_Name.BASEMENT);
		r6.setPlacement(Room_Orientation.WEST, new Location(Floor_Name.BASEMENT, 100 , 100));
		
		c1.setCurrentRoom(r1);
		System.out.println(r2.getExits());
		System.out.println(r2.getOrientation());
		System.out.println(r2.getLocation().getFloorLocationToNorth());
		System.out.println(r2.getRoomFromExit(Relative_Direction.EAST));
		//I know I really shouldn't be print lining but it worked because I found the bug!
		Assert.assertTrue(c1.moveInAbsoluteDirection(Relative_Direction.EAST));
		Assert.assertTrue(c1.moveInAbsoluteDirection(Relative_Direction.NORTH));
		Assert.assertTrue(c1.moveInAbsoluteDirection(Relative_Direction.WEST));
		Assert.assertTrue(c1.moveInAbsoluteDirection(Relative_Direction.WEST));
		
		System.out.println(c1.getCurrentRoom().getLocation());
		Assert.assertEquals(r5, c1.getCurrentRoom());
		
	}

}
