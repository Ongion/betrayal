package test;

import java.util.HashSet;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import rooms.EventRoom;
import rooms.Location;
import rooms.Room;
import rooms.Room.Floor_Name;
import rooms.Room.Relative_Direction;
import rooms.Room.Room_Orientation;
import rooms.RoomFactory;
import rooms.RoomName;
import Game.Game;
import characters.Character;
import characters.Character.Character_Name;
import characters.ExplorerFactory;

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
	Character zoeIngstrom;
	
	@Before
	public void setUp() {
		Game.resetGame();
		RoomFactory rooms = new RoomFactory();
		gardens = rooms.makeRoom(RoomName.GARDENS);
		gardens.setPlacement(Room_Orientation.EAST, new Location(Floor_Name.GROUND, 10 , 0));

		organRoom = rooms.makeRoom(RoomName.ORGANROOM);
		organRoom.setPlacement(Room_Orientation.WEST, new Location(Floor_Name.GROUND, 9 , 0));	
		
		diningRoom = rooms.makeRoom(RoomName.DININGROOM);
		diningRoom.setPlacement(Room_Orientation.NORTH, new Location(Floor_Name.GROUND, 9, -1));

		basementLanding = rooms.makeRoom(RoomName.BASEMENTLANDING);
		basementLanding.setPlacement(Room_Orientation.NORTH, new Location(Floor_Name.BASEMENT, 10, 0));
		
		catacombs = rooms.makeRoom(RoomName.CATACOMBS);
		catacombs.setPlacement(Room_Orientation.EAST, new Location(Floor_Name.BASEMENT, 11, 0));
		
		chasm = rooms.makeRoom(RoomName.CHASM);
		chasm.setPlacement(Room_Orientation.WEST, new Location(Floor_Name.BASEMENT, 10, 1));
		
		pentagramChamber = rooms.makeRoom(RoomName.PENTAGRAMCHAMBER);
		pentagramChamber.setPlacement(Room_Orientation.NORTH, new Location(Floor_Name.BASEMENT, 9, 0));
		
		junkRoom = rooms.makeRoom(RoomName.JUNKROOM);
		junkRoom.setPlacement(Room_Orientation.NORTH, new Location(Floor_Name.BASEMENT, 10, -1));
		
		creakyHallway = rooms.makeRoom(RoomName.CREAKYHALLWAY);
		creakyHallway.setPlacement(Room_Orientation.NORTH, new Location(Floor_Name.UPPER, 15, 5));
		
		servantsQuarters = rooms.makeRoom(RoomName.SERVANTSQUARTERS);
		servantsQuarters.setPlacement(Room_Orientation.NORTH, new Location(Floor_Name.UPPER, 16, 5));
		
		masterBedroom = rooms.makeRoom(RoomName.MASTERBEDROOM);
		masterBedroom.setPlacement(Room_Orientation.SOUTH, new Location(Floor_Name.UPPER, 15, 6));
		
		bedroom = rooms.makeRoom(RoomName.BEDROOM);
		bedroom.setPlacement(Room_Orientation.NORTH, new Location(Floor_Name.UPPER, 16, 6));

		ExplorerFactory explorers = new ExplorerFactory();
		c1 = explorers.getExplorer(Character_Name.BrandonJaspers);
		c2 = explorers.getExplorer(Character_Name.FatherRhinehardt);
		c3 = explorers.getExplorer(Character_Name.DarrinWilliams);
		c4 = explorers.getExplorer(Character_Name.HeatherGranville);
		c5 = explorers.getExplorer(Character_Name.JennyLeClerc);
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
		Game.resetGame();
		Room r1, r2, r3, r4, r5, r6;
		HashSet<Relative_Direction> r1Exits = new HashSet<Relative_Direction>();
		r1Exits.add(Relative_Direction.NORTH);
		r1Exits.add(Relative_Direction.SOUTH);
		HashSet<Floor_Name> gardensFloors = new HashSet<Floor_Name>();
		gardensFloors.add(Floor_Name.GROUND);
		r1 = new EventRoom(RoomName.GARDENS, r1Exits, gardensFloors);
		r1.setPlacement(Room_Orientation.EAST, new Location(Floor_Name.GROUND, 11 , 0));
		
		HashSet<Relative_Direction> r2Exits = new HashSet<Relative_Direction>();
		r2Exits.add(Relative_Direction.NORTH);
		r2Exits.add(Relative_Direction.EAST);
		r2 = new EventRoom(RoomName.BASEMENTLANDING, r2Exits, gardensFloors);
		r2.setPlacement(Room_Orientation.WEST, new Location(Floor_Name.GROUND, 12 , 0));
		
		r3 = new EventRoom(RoomName.CATACOMBS, r2Exits, gardensFloors);
		r3.setPlacement(Room_Orientation.SOUTH, new Location(Floor_Name.GROUND, 12 , 1));
		
		r4 = new EventRoom(RoomName.ENTRANCEHALL, r1Exits, gardensFloors);
		r4.setPlacement(Room_Orientation.WEST, new Location(Floor_Name.GROUND, 11 , 1));
		
		HashSet<Relative_Direction> r5Exits = new HashSet<Relative_Direction>();
		r5Exits.add(Relative_Direction.NORTH);
		r5 = new EventRoom(RoomName.GRANDSTAIRCASE, r5Exits, gardensFloors);
		r5.setPlacement(Room_Orientation.EAST, new Location(Floor_Name.GROUND, 10 , 1));
		
		r6 = new EventRoom(RoomName.ORGANROOM, r1Exits, gardensFloors);
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
		r1 = new EventRoom(RoomName.GARDENS, r1Exits, gardensFloors);
		r1.setPlacement(Room_Orientation.EAST, new Location(Floor_Name.GROUND, 11 , 0));
		
		HashSet<Relative_Direction> r2Exits = new HashSet<Relative_Direction>();
		r2Exits.add(Relative_Direction.NORTH);
		r2Exits.add(Relative_Direction.EAST);
		r2 = new EventRoom(RoomName.DININGROOM, r2Exits, gardensFloors);
		r2.setPlacement(Room_Orientation.WEST, new Location(Floor_Name.GROUND, 12 , 0));
		
		r3 = new EventRoom(RoomName.UNDERGROUNDLAKE, r2Exits, gardensFloors);
		r3.setPlacement(Room_Orientation.SOUTH, new Location(Floor_Name.GROUND, 12 , 1));
		
		r4 = new EventRoom(RoomName.STATUARYCORRIDOR, r1Exits, gardensFloors);
		r4.setPlacement(Room_Orientation.WEST, new Location(Floor_Name.GROUND, 11 , 1));
		
		HashSet<Relative_Direction> r5Exits = new HashSet<Relative_Direction>();
		r5Exits.add(Relative_Direction.NORTH);
		r5 = new EventRoom(RoomName.STOREROOM, r5Exits, gardensFloors);
		r5.setPlacement(Room_Orientation.EAST, new Location(Floor_Name.GROUND, 10 , 1));
		
		r6 = new EventRoom(RoomName.ORGANROOM, r1Exits, gardensFloors);
		gardensFloors.add(Floor_Name.BASEMENT);
		r6.setPlacement(Room_Orientation.WEST, new Location(Floor_Name.BASEMENT, 100 , 100));
		
		c1.setCurrentRoom(r1);
		
		Assert.assertTrue(c1.attemptMoveInAbsoluteDirection(Relative_Direction.EAST));
		Assert.assertTrue(c1.attemptMoveInAbsoluteDirection(Relative_Direction.NORTH));
		Assert.assertTrue(c1.attemptMoveInAbsoluteDirection(Relative_Direction.WEST));
		Assert.assertTrue(c1.attemptMoveInAbsoluteDirection(Relative_Direction.WEST));
		
		System.out.println(c1.getCurrentRoom().getLocation());
		Assert.assertEquals(r5, c1.getCurrentRoom());
		
	}

}
