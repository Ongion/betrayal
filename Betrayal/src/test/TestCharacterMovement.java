package test;

import java.util.HashMap;
import java.util.HashSet;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import rooms.EventRoom;
import rooms.OmenRoom;
import rooms.Room;
import rooms.RoomFactory;
import rooms.Room.Floor_Name;
import rooms.Room.Relative_Direction;
import rooms.Room.Room_Orientation;
import rooms.RoomName;
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
		
		RoomFactory rooms = new RoomFactory();
		HashSet<Relative_Direction> allDirectionExits = new HashSet<Relative_Direction>();
		allDirectionExits.add(Relative_Direction.NORTH);
		allDirectionExits.add(Relative_Direction.SOUTH);
		allDirectionExits.add(Relative_Direction.EAST);
		allDirectionExits.add(Relative_Direction.WEST);
		
		HashSet<Relative_Direction> gardensExits = new HashSet<Relative_Direction>();
		gardensExits.add(Relative_Direction.NORTH);
		gardensExits.add(Relative_Direction.SOUTH);
		
		gardens = rooms.makeRoom(RoomName.CREAKYHALLWAY);
		gardens.setPlacement(Room_Orientation.EAST, new Location(Floor_Name.GROUND, 10 , 0));

		organRoom = rooms.makeRoom(RoomName.ORGANROOM);
		organRoom.setPlacement(Room_Orientation.WEST, new Location(Floor_Name.GROUND, 9 , 0));	
		
		diningRoom = rooms.makeRoom(RoomName.DININGROOM);
		diningRoom.setPlacement(Room_Orientation.NORTH, new Location(Floor_Name.GROUND, 9, -1));
		
		junkRoom = rooms.makeRoom(RoomName.DUSTYHALLWAY);
		junkRoom.setPlacement(Room_Orientation.NORTH, new Location(Floor_Name.GROUND, 10, -1));

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
		
		Assert.assertTrue(c.attemptMoveInAbsoluteDirection(Relative_Direction.SOUTH));
		Assert.assertEquals(c.getCurrentRoom(), diningRoom);
		
		Assert.assertTrue(c.attemptMoveInAbsoluteDirection(Relative_Direction.EAST));
		Assert.assertEquals(c.getCurrentRoom(), junkRoom);
		
		Assert.assertTrue(c.attemptMoveInAbsoluteDirection(Relative_Direction.NORTH));
		Assert.assertEquals(c.getCurrentRoom(), gardens);
		
		//Completed the full loop. Now go backwards!
		Assert.assertTrue(c.attemptMoveInAbsoluteDirection(Relative_Direction.SOUTH));
		Assert.assertEquals(c.getCurrentRoom(), junkRoom);
		
		Assert.assertTrue(c.attemptMoveInAbsoluteDirection(Relative_Direction.WEST));
		Assert.assertEquals(c.getCurrentRoom(), diningRoom);
		
		Assert.assertTrue(c.attemptMoveInAbsoluteDirection(Relative_Direction.NORTH));
		Assert.assertEquals(c.getCurrentRoom(), organRoom);
		
		Assert.assertTrue(c.attemptMoveInAbsoluteDirection(Relative_Direction.EAST));
		Assert.assertEquals(c.getCurrentRoom(), gardens);
		
	
	}

}
