package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import rooms.EventRoom;
import rooms.Room;

public class TestRooms {
	Room organRoom;
	

	@Before
	public void setUp() {
		organRoom = new EventRoom("Organ Room");
	}
		
	@Test
	public void testGetRoomName() {
		assertTrue(organRoom.getName().equals("Organ Room"));
	}

}
