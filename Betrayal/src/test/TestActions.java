package test;

import static org.junit.Assert.*;

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

import actions.IAction;
import actions.JumpDownFromGalleryToBallroomAction;

import Game.Game;

public class TestActions {
	
	Game game;
	Room gallery;
	Room ballroom;
	Character darrinWilliams;
	IAction jumpDownToBallroom;
	
	@Before
	public void setUp() throws Exception {
		Game.resetGame();
		game = Game.getInstance();
		
		RoomFactory rooms = new RoomFactory();
		gallery = rooms.makeRoom(RoomName.GALLERY);
		gallery.setPlacement(Room_Orientation.NORTH, new Location(Floor_Name.UPPER, -10, 10));
		
		ballroom = rooms.makeRoom(RoomName.BALLROOM);
		
		darrinWilliams = new ExplorerFactory().getExplorer(Character_Name.DarrinWilliams);
		
		darrinWilliams.setCurrentRoom(gallery);
		darrinWilliams.setSideOfRoom(Relative_Direction.NORTH);
		
		jumpDownToBallroom = new JumpDownFromGalleryToBallroomAction();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCanPerformWithNoBallroom() {
		assertFalse(jumpDownToBallroom.canPerform(darrinWilliams));
	}
	
	@Test
	public void testCanPerformWithBallroom() {
		ballroom.setPlacement(Room_Orientation.NORTH, new Location(Floor_Name.GROUND, 100, 25));
		assertTrue(jumpDownToBallroom.canPerform(darrinWilliams));
	}

	@Test
	public void testPerform() {
		ballroom.setPlacement(Room_Orientation.NORTH, new Location(Floor_Name.GROUND, 100, 25));
		jumpDownToBallroom.perform(darrinWilliams);
		
		assertEquals(ballroom, darrinWilliams.getCurrentRoom());
	}

	@Test
	public void testGetName() {
		// English
		assertEquals("Jump down to Ballroom", jumpDownToBallroom.getName());
		
		// Spanish
		
	}

	@Test
	public void testGetDescription() {
		// English
		assertEquals("Jump down to the Ballroom. Take 1 point of physical damage.", jumpDownToBallroom.getDescription());
		
		// Spanish
	}

}
