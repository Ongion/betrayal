package test;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import rooms.Location;
import rooms.Room;
import rooms.Room.Floor_Name;
import rooms.Room.Relative_Direction;
import rooms.RoomFactory;
import rooms.RoomName;
import rooms.Room.Room_Orientation;

import characters.Character;
import characters.ExplorerFactory;
import characters.Character.Character_Name;

import Game.Game;
import actions.IAction;
import actions.JumpDownFromGalleryToBallroomAction;
import actions.UseSecretStairsAction;

public class TestActions {
	
	Room gallery;
	Room ballroom;
	Room basementLandingWithSecretStairs1;
	Room bedroomWithSecretStairs2;
	Character darrinWilliamsJumpingDownFromBalcony;
	Character missyDubourdeUsingSecretStairs;
	IAction jumpDownToBallroom;
	IAction useSecretStairs1;
	IAction useSecretStairs2;
	
	@Before
	public void setUp() throws Exception {
		Game.resetGame();
		
		RoomFactory rooms = new RoomFactory();
		gallery = rooms.makeRoom(RoomName.GALLERY);
		gallery.setPlacement(Room_Orientation.NORTH, new Location(Floor_Name.UPPER, -10, 10));
		
		ballroom = rooms.makeRoom(RoomName.BALLROOM);
		
		basementLandingWithSecretStairs1 = Game.getInstance().getRoomByRoomName(RoomName.BASEMENTLANDING);
		
		bedroomWithSecretStairs2 = rooms.makeRoom(RoomName.BEDROOM);
		bedroomWithSecretStairs2.setPlacement(Room_Orientation.SOUTH, new Location(Floor_Name.UPPER, 1, 1));
		
		ExplorerFactory explorers = new ExplorerFactory();
		darrinWilliamsJumpingDownFromBalcony = explorers.getExplorer(Character_Name.DarrinWilliams);
		missyDubourdeUsingSecretStairs = explorers.getExplorer(Character_Name.MissyDubourde);
		
		darrinWilliamsJumpingDownFromBalcony.setCurrentRoom(gallery);
		darrinWilliamsJumpingDownFromBalcony.setSideOfRoom(Relative_Direction.NORTH);
		missyDubourdeUsingSecretStairs.setCurrentRoom(bedroomWithSecretStairs2);
		missyDubourdeUsingSecretStairs.setSideOfRoom(Relative_Direction.EAST);
		
		jumpDownToBallroom =  gallery.getRoomActions().toArray(new IAction[1])[0];
		useSecretStairs1 = new UseSecretStairsAction(basementLandingWithSecretStairs1, bedroomWithSecretStairs2, Relative_Direction.EAST, missyDubourdeUsingSecretStairs.getSideOfRoom());
		useSecretStairs2 = new UseSecretStairsAction(bedroomWithSecretStairs2, basementLandingWithSecretStairs1, missyDubourdeUsingSecretStairs.getSideOfRoom(), Relative_Direction.EAST);
		
		basementLandingWithSecretStairs1.addRoomAction(useSecretStairs1);
		bedroomWithSecretStairs2.addRoomAction(useSecretStairs2);
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCanJumpDownWithNoBallroom() {
		IAction[] galleryActions = gallery.getRoomActions().toArray(new IAction[1]);
		for (IAction action : galleryActions) {
			assertFalse(action.canPerform(darrinWilliamsJumpingDownFromBalcony));
		}
	}
	
	@Test
	public void testCanJumpDownWithBallroom() {
		ballroom.setPlacement(Room_Orientation.NORTH, new Location(Floor_Name.GROUND, 100, 25));
		IAction[] galleryActions = gallery.getRoomActions().toArray(new IAction[1]);
		for (IAction action : galleryActions) {
			assertTrue(action.canPerform(darrinWilliamsJumpingDownFromBalcony));
		}
	}

	@Test
	public void testJumpDown() {
		ballroom.setPlacement(Room_Orientation.NORTH, new Location(Floor_Name.GROUND, 100, 25));
		jumpDownToBallroom.perform(darrinWilliamsJumpingDownFromBalcony);
		assertEquals(ballroom, darrinWilliamsJumpingDownFromBalcony.getCurrentRoom());
	}

	@Test
	public void testGetName() {
		// English
		assertEquals("Jump down to Ballroom", jumpDownToBallroom.getName());
		assertEquals("Use Secret Stairs", useSecretStairs1.getName());
		
		// Spanish
		
	}

	@Test
	public void testGetDescription() {
		// English
		assertEquals("Jump down to the Ballroom. Take 1 point of physical damage.", jumpDownToBallroom.getDescription());
		assertEquals("Go through the secret stairs. Takes one movement.", useSecretStairs1.getDescription());
		
		// Spanish
	}

}
