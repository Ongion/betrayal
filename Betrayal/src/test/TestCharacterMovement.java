package test;

import java.util.HashMap;
import java.util.HashSet;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import rooms.EventRoom;
import rooms.JunkRoomRoom;
import rooms.OmenRoom;
import rooms.Room;
import rooms.Room.Floor_Name;
import rooms.Room.Relative_Direction;
import rooms.Room.Room_Orientation;
import Game.Game;
import characters.Character;
import characters.Character.Character_Name;
import characters.ExplorerFactory;
import rooms.Location;

public class TestCharacterMovement {

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
	
	Character c;
	
	@Before
	public void init() {
		Game.resetGame();
		
		HashSet<Relative_Direction> allDirectionExits = new HashSet<Relative_Direction>();
		allDirectionExits.add(Relative_Direction.NORTH);
		allDirectionExits.add(Relative_Direction.SOUTH);
		allDirectionExits.add(Relative_Direction.EAST);
		allDirectionExits.add(Relative_Direction.WEST);
		
		HashSet<Relative_Direction> gardensExits = new HashSet<Relative_Direction>();
		gardensExits.add(Relative_Direction.NORTH);
		gardensExits.add(Relative_Direction.SOUTH);
		
		HashSet<Floor_Name> gardensFloors = new HashSet<Floor_Name>();
		gardensFloors.add(Floor_Name.GROUND);
		gardens = new EventRoom("Garden", allDirectionExits, gardensFloors);
		gardens.setPlacement(Room_Orientation.EAST, new Location(Floor_Name.GROUND, 0 , 0));

		HashSet<Relative_Direction> organRoomExits = new HashSet<Relative_Direction>();
		organRoomExits.add(Relative_Direction.SOUTH);
		organRoomExits.add(Relative_Direction.WEST);
		HashSet<Floor_Name> organRoomFloors = new HashSet<Floor_Name>();
		organRoomFloors.add(Floor_Name.UPPER);
		organRoomFloors.add(Floor_Name.GROUND);
		organRoomFloors.add(Floor_Name.BASEMENT);
		organRoom = new EventRoom("Organ Room", allDirectionExits, organRoomFloors);
		organRoom.setPlacement(Room_Orientation.WEST, new Location(Floor_Name.GROUND, -1 , 0));	
		
		HashSet<Relative_Direction> diningRoomExits = new HashSet<Relative_Direction>();
		diningRoomExits.add(Relative_Direction.NORTH);
		diningRoomExits.add(Relative_Direction.EAST);
		HashSet<Floor_Name> diningRoomFloors = new HashSet<Floor_Name>();
		diningRoomFloors.add(Floor_Name.GROUND);
		HashMap<Relative_Direction, Integer> diningRoomWindows = new HashMap<Relative_Direction, Integer>();
		diningRoomWindows.put(Relative_Direction.WEST, 2);
		diningRoom = new OmenRoom("Dining Room", allDirectionExits, diningRoomFloors, diningRoomWindows);
		diningRoom.setPlacement(Room_Orientation.NORTH, new Location(Floor_Name.GROUND, -1, 1));
		
		HashSet<Relative_Direction> junkRoomExits = new HashSet<Relative_Direction>();
		junkRoomExits.add(Relative_Direction.NORTH);
		junkRoomExits.add(Relative_Direction.EAST);
		junkRoomExits.add(Relative_Direction.SOUTH);
		junkRoomExits.add(Relative_Direction.WEST);
		HashSet<Floor_Name> junkRoomFloors = new HashSet<Floor_Name>();
		junkRoomFloors.add(Floor_Name.UPPER);
		junkRoomFloors.add(Floor_Name.GROUND);
		junkRoomFloors.add(Floor_Name.BASEMENT);
		junkRoom = new JunkRoomRoom("Junk Room", allDirectionExits, junkRoomFloors);
		junkRoom.setPlacement(Room_Orientation.NORTH, new Location(Floor_Name.GROUND, 0, 1));

		c = new ExplorerFactory().getExplorer(Character_Name.FatherRhinehardt);
		}
	
	@Test
	public void testSettingAndGettingCharacterCurrentRoom(){
		c.setCurrentRoom(gardens);
		Assert.assertEquals(gardens,c.getCurrentRoom());
		
		c.setCurrentRoom(diningRoom);
		Assert.assertEquals(diningRoom,c.getCurrentRoom());
		
		c.setCurrentRoom(organRoom);
		Assert.assertEquals(organRoom,c.getCurrentRoom());
	}
	
	@Test
	public void testSettingAndGettingCharacterCurrentRoomSide(){
		//Test all directions
		c.setCurrentRoom(gardens);
		c.setSideOfRoom(Relative_Direction.NORTH);
		Assert.assertEquals(c.getSideOfRoom(), Relative_Direction.NORTH);
		
		c.setSideOfRoom(Relative_Direction.EAST);
		Assert.assertEquals(c.getSideOfRoom(), Relative_Direction.EAST);
		
		c.setSideOfRoom(Relative_Direction.WEST);
		Assert.assertEquals(c.getSideOfRoom(), Relative_Direction.WEST);
		
		c.setSideOfRoom(Relative_Direction.SOUTH);
		Assert.assertEquals(c.getSideOfRoom(), Relative_Direction.SOUTH);
		
		//Test a different room to make sure that room wasn't a fluke
		c.setCurrentRoom(diningRoom);
		c.setSideOfRoom(Relative_Direction.NORTH);
		Assert.assertEquals(c.getSideOfRoom(), Relative_Direction.NORTH);
		
		c.setSideOfRoom(Relative_Direction.EAST);
		Assert.assertEquals(c.getSideOfRoom(), Relative_Direction.EAST);
		
		c.setSideOfRoom(Relative_Direction.WEST);
		Assert.assertEquals(c.getSideOfRoom(), Relative_Direction.WEST);
		
		c.setSideOfRoom(Relative_Direction.SOUTH);
		Assert.assertEquals(c.getSideOfRoom(), Relative_Direction.SOUTH);
	}
	
	@Test
	public void TestMovingAPlayerToAnAdjacentRoomByGetterAndSetter(){
		c.setCurrentRoom(gardens);
		Room nextRoomToMoveTo = c.getCurrentRoom().getRoomFromExitAbsoluteDirection(Relative_Direction.WEST);
		c.setCurrentRoom(nextRoomToMoveTo);
		Assert.assertEquals(c.getCurrentRoom(), nextRoomToMoveTo);
		Assert.assertEquals(c.getCurrentRoom(), organRoom);
		
		//Now move back!
		nextRoomToMoveTo = c.getCurrentRoom().getRoomFromExitAbsoluteDirection(Relative_Direction.EAST);
		c.setCurrentRoom(nextRoomToMoveTo);
		Assert.assertEquals(nextRoomToMoveTo, c.getCurrentRoom());
		Assert.assertEquals(gardens, c.getCurrentRoom());
	}
	
	@Test
	public void TestMovingAPlayerToAnAdjacentRoomByCharacterFunctions() {
		c.setCurrentRoom(gardens);
		Room nextRoomToMoveTo = c.getCurrentRoom().getRoomFromExitAbsoluteDirection(Relative_Direction.WEST);
		Assert.assertTrue(c.attemptMoveInAbsoluteDirection(Relative_Direction.WEST));
		Assert.assertEquals(c.getCurrentRoom(), nextRoomToMoveTo);
		Assert.assertEquals(c.getCurrentRoom(), organRoom);
		Assert.assertEquals(c.getCurrentRoom().convertAbsoluteDirectionToRoomRelativeDirection(Relative_Direction.EAST), c.getSideOfRoom());
		
		//Now move back!
		nextRoomToMoveTo = c.getCurrentRoom().getRoomFromExitAbsoluteDirection(Relative_Direction.EAST);
		Assert.assertTrue(c.attemptMoveInAbsoluteDirection(Relative_Direction.EAST));
		Assert.assertEquals(nextRoomToMoveTo, c.getCurrentRoom());
		Assert.assertEquals(c.getCurrentRoom(), gardens);
		Assert.assertEquals(c.getCurrentRoom().convertAbsoluteDirectionToRoomRelativeDirection(Relative_Direction.WEST), c.getSideOfRoom());
	}
	
	@Test
	public void TestMovingAPlayerToMultipleRoomsByCharacterFunctions() {
		c.setCurrentRoom(gardens);
		
		Assert.assertTrue(c.attemptMoveInAbsoluteDirection(Relative_Direction.WEST));
		Assert.assertEquals(c.getCurrentRoom(), organRoom);
		
		Assert.assertTrue(c.attemptMoveInAbsoluteDirection(Relative_Direction.NORTH));
		Assert.assertEquals(c.getCurrentRoom(), diningRoom);
		
		Assert.assertTrue(c.attemptMoveInAbsoluteDirection(Relative_Direction.EAST));
		Assert.assertEquals(c.getCurrentRoom(), junkRoom);
		
		Assert.assertTrue(c.attemptMoveInAbsoluteDirection(Relative_Direction.SOUTH));
		Assert.assertEquals(c.getCurrentRoom(), gardens);
		
		//Completed the full loop. Now go backwards!
		Assert.assertTrue(c.attemptMoveInAbsoluteDirection(Relative_Direction.NORTH));
		Assert.assertEquals(c.getCurrentRoom(), junkRoom);
		
		Assert.assertTrue(c.attemptMoveInAbsoluteDirection(Relative_Direction.WEST));
		Assert.assertEquals(c.getCurrentRoom(), diningRoom);
		
		Assert.assertTrue(c.attemptMoveInAbsoluteDirection(Relative_Direction.SOUTH));
		Assert.assertEquals(c.getCurrentRoom(), organRoom);
		
		Assert.assertTrue(c.attemptMoveInAbsoluteDirection(Relative_Direction.EAST));
		Assert.assertEquals(c.getCurrentRoom(), gardens);
		
	
	}

}
