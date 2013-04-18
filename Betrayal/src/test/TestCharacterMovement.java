package test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import characters.Character;
import characters.Explorer;
import characters.Explorer.Explorers;

import Game.Game;
import floors.Location;

import rooms.EventRoom;
import rooms.OmenRoom;
import rooms.Room;
import rooms.Room.Floor_Name;
import rooms.Room.Relative_Direction;
import rooms.Room.Room_Orientation;

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
	
	Character c;
	
	@Before
	public void init() {
		Game.resetGame();
		HashSet<Relative_Direction> gardensExits = new HashSet<Relative_Direction>();
		gardensExits.add(Relative_Direction.NORTH);
		gardensExits.add(Relative_Direction.SOUTH);
		HashSet<Floor_Name> gardensFloors = new HashSet<Floor_Name>();
		gardensFloors.add(Floor_Name.GROUND);
		gardens = new EventRoom("Garden", gardensExits, gardensFloors);
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

		c = new Explorer(Explorers.FatherRhinehardt, new Locale("en"));
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
		Assert.assertTrue(c.moveInAbsoluteDirection(Relative_Direction.WEST));
		Assert.assertEquals(c.getCurrentRoom(), nextRoomToMoveTo);
		
		//Now move back!
		nextRoomToMoveTo = c.getCurrentRoom().getRoomFromExitAbsoluteDirection(Relative_Direction.EAST);
		Assert.assertTrue(c.moveInAbsoluteDirection(Relative_Direction.EAST));
		Assert.assertEquals(nextRoomToMoveTo, c.getCurrentRoom());
	}

}
