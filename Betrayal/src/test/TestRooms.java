package test;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Assert;
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
import rooms.RoomName;
import rooms.Room.Floor_Name;
import rooms.Room.Relative_Direction;
import rooms.Room.Room_Orientation;
import rooms.RoomFactory;
import Game.Game;
import characters.Character.Character_Name;
import characters.ExplorerType;
import characters.Character;
import characters.ExplorerFactory;
import rooms.Location;
import characters.HumanStats;

public class TestRooms {
	ExplorerFactory explorers;
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

		basementLanding = Game.getInstance().getRoomByName("Basement Landing");
		
		catacombs = rooms.makeRoom(RoomName.CATACOMBS);
		catacombs.setPlacement(Room_Orientation.EAST, new Location(Floor_Name.BASEMENT, 1, 0));
		
		chasm = rooms.makeRoom(RoomName.CHASM);
		chasm.setPlacement(Room_Orientation.WEST, new Location(Floor_Name.BASEMENT, 0, 1));
		
		pentagramChamber = rooms.makeRoom(RoomName.PENTAGRAMCHAMBER);
		pentagramChamber.setPlacement(Room_Orientation.NORTH, new Location(Floor_Name.BASEMENT, -1, 0));
		
		junkRoom = rooms.makeRoom(RoomName.JUNKROOM);
		junkRoom.setPlacement(Room_Orientation.NORTH, new Location(Floor_Name.BASEMENT, 0, -1));
		
		creakyHallway = rooms.makeRoom(RoomName.CREAKYHALLWAY);
		creakyHallway.setPlacement(Room_Orientation.NORTH, new Location(Floor_Name.UPPER, 15, 5));
		
		servantsQuarters = rooms.makeRoom(RoomName.SERVANTSQUARTERS);
		servantsQuarters.setPlacement(Room_Orientation.NORTH, new Location(Floor_Name.UPPER, 16, 5));
		
		masterBedroom = rooms.makeRoom(RoomName.MASTERBEDROOM);
		masterBedroom.setPlacement(Room_Orientation.SOUTH, new Location(Floor_Name.UPPER, 15, 6));
		
		bedroom = rooms.makeRoom(RoomName.BEDROOM);
		bedroom.setPlacement(Room_Orientation.NORTH, new Location(Floor_Name.UPPER, 16, 6));
		
		explorers = new ExplorerFactory();

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
	
	@Test
	public void testLeavingPentagramChamberFailingRoll() {
		Mockery mocks = new Mockery() {{
	        setImposteriser(ClassImposteriser.INSTANCE);
	    }};
		final Game mockGame = mocks.mock(Game.class);
		try {
			Field instanceField = Game.class.getDeclaredField("INSTANCE");
			instanceField.setAccessible(true);
			instanceField.set(null, mockGame);
			
			mocks.checking(new Expectations() {{
				oneOf(mockGame).rollDice(3); will(returnValue(3));
				oneOf(mockGame).getLocale(); will(returnValue(new Locale("en")));
				oneOf(mockGame).getRoomAtLocation(new Location(Floor_Name.BASEMENT, 0, 0)); will(returnValue(basementLanding));
			}});
			zoeIngstrom = explorers.getExplorer(Character_Name.ZoeIngstrom);
			zoeIngstrom.setCurrentRoom(pentagramChamber);
			zoeIngstrom.setSideOfRoom(Relative_Direction.EAST);
			assertEquals(5, zoeIngstrom.getCurrentSanity());
			zoeIngstrom.attemptMoveInAbsoluteDirection(Relative_Direction.EAST);
			assertEquals(4, zoeIngstrom.getCurrentSanity());
			mocks.assertIsSatisfied();
		} catch(Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test
	public void testLeavingPentagramChamberSucceedingRoll() {
		Mockery mocks = new Mockery() {{
	        setImposteriser(ClassImposteriser.INSTANCE);
	    }};
		final Game mockGame = mocks.mock(Game.class);
		try {
			Field instanceField = Game.class.getDeclaredField("INSTANCE");
			instanceField.setAccessible(true);
			instanceField.set(null, mockGame);
			zoeIngstrom = explorers.getExplorer(Character_Name.ZoeIngstrom);
			final int zoesKnowledge = zoeIngstrom.getCurrentKnowledge();
			
			mocks.checking(new Expectations() {{
				oneOf(mockGame).rollDice(zoesKnowledge); will(returnValue(5));
				oneOf(mockGame).getLocale(); will(returnValue(new Locale("en")));
				oneOf(mockGame).getRoomAtLocation(new Location(Floor_Name.BASEMENT, 0, 0)); will(returnValue(basementLanding));
			}});
			zoeIngstrom.setCurrentRoom(pentagramChamber);
			zoeIngstrom.setSideOfRoom(Relative_Direction.EAST);
			assertEquals(5, zoeIngstrom.getCurrentSanity());
			zoeIngstrom.attemptMoveInAbsoluteDirection(Relative_Direction.EAST);
			assertEquals(5, zoeIngstrom.getCurrentSanity());
			mocks.assertIsSatisfied();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test
	public void testLeavingJunkRoomFailingRoll() {
		Mockery mocks = new Mockery() {{
	        setImposteriser(ClassImposteriser.INSTANCE);
	    }};
		final Game mockGame = mocks.mock(Game.class);
		try {
			Field instanceField = Game.class.getDeclaredField("INSTANCE");
			instanceField.setAccessible(true);
			instanceField.set(null, mockGame);
			zoeIngstrom = explorers.getExplorer(Character_Name.ZoeIngstrom);
			final int traitScore = zoeIngstrom.getCurrentMight();
			
			mocks.checking(new Expectations() {{
				oneOf(mockGame).rollDice(traitScore); will(returnValue(2));
				oneOf(mockGame).getLocale(); will(returnValue(new Locale("en")));
				oneOf(mockGame).getRoomAtLocation(new Location(Floor_Name.BASEMENT,0,-2)); will(returnValue(null));
				oneOf(mockGame).getRoomAtLocation(new Location(Floor_Name.BASEMENT,-1,-1)); will(returnValue(null));
				oneOf(mockGame).getRoomAtLocation(new Location(Floor_Name.BASEMENT,1,-1)); will(returnValue(null));
				oneOf(mockGame).getRoomAtLocation(new Location(Floor_Name.BASEMENT,0,0)); will(returnValue(basementLanding));

			}});
			zoeIngstrom.setCurrentRoom(junkRoom);
			zoeIngstrom.setSideOfRoom(Relative_Direction.EAST);
			assertEquals(3, ((HumanStats) zoeIngstrom.getStats()).getCurrentSpeedIndex());
			zoeIngstrom.attemptMoveInAbsoluteDirection(Relative_Direction.NORTH);
			assertEquals(2, ((HumanStats) zoeIngstrom.getStats()).getCurrentSpeedIndex());
			mocks.assertIsSatisfied();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test
	public void testLeavingJunkRoomSucceedingRoll() {
		Mockery mocks = new Mockery() {{
	        setImposteriser(ClassImposteriser.INSTANCE);
	    }};
		final Game mockGame = mocks.mock(Game.class);
		try {
			Field instanceField = Game.class.getDeclaredField("INSTANCE");
			instanceField.setAccessible(true);
			instanceField.set(null, mockGame);
			zoeIngstrom = explorers.getExplorer(Character_Name.ZoeIngstrom);
			final int traitScore = zoeIngstrom.getCurrentMight();
			
			mocks.checking(new Expectations() {{
				oneOf(mockGame).rollDice(traitScore); will(returnValue(3));
				oneOf(mockGame).getLocale(); will(returnValue(new Locale("en")));
				oneOf(mockGame).getRoomAtLocation(new Location(Floor_Name.BASEMENT,0,-2)); will(returnValue(null));
				oneOf(mockGame).getRoomAtLocation(new Location(Floor_Name.BASEMENT,-1,-1)); will(returnValue(null));
				oneOf(mockGame).getRoomAtLocation(new Location(Floor_Name.BASEMENT,1,-1)); will(returnValue(null));
				oneOf(mockGame).getRoomAtLocation(new Location(Floor_Name.BASEMENT,0,0)); will(returnValue(basementLanding));
			}});
			zoeIngstrom.setCurrentRoom(junkRoom);
			zoeIngstrom.setSideOfRoom(Relative_Direction.EAST);
			assertEquals(3, ((HumanStats) zoeIngstrom.getStats()).getCurrentSpeedIndex());
			zoeIngstrom.attemptMoveInAbsoluteDirection(Relative_Direction.NORTH);
			assertEquals(3, ((HumanStats) zoeIngstrom.getStats()).getCurrentSpeedIndex());
			mocks.assertIsSatisfied();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test
	public void TestConvertDirectionMethod(){
		gardens.setPlacement(Room_Orientation.NORTH, new Location(Floor_Name.GROUND,999,999));
		Assert.assertEquals(Relative_Direction.NORTH, gardens.convertAbsoluteDirectionToRoomRelativeDirection(Relative_Direction.NORTH));
		Assert.assertEquals(Relative_Direction.EAST, gardens.convertAbsoluteDirectionToRoomRelativeDirection(Relative_Direction.EAST));
		Assert.assertEquals(Relative_Direction.SOUTH, gardens.convertAbsoluteDirectionToRoomRelativeDirection(Relative_Direction.SOUTH));
		Assert.assertEquals(Relative_Direction.WEST, gardens.convertAbsoluteDirectionToRoomRelativeDirection(Relative_Direction.WEST));

	
		gardens.setPlacement(Room_Orientation.EAST, new Location(Floor_Name.GROUND,999,999));
		Assert.assertEquals(Relative_Direction.NORTH, gardens.convertAbsoluteDirectionToRoomRelativeDirection(Relative_Direction.EAST));
		Assert.assertEquals(Relative_Direction.EAST, gardens.convertAbsoluteDirectionToRoomRelativeDirection(Relative_Direction.SOUTH));
		Assert.assertEquals(Relative_Direction.SOUTH, gardens.convertAbsoluteDirectionToRoomRelativeDirection(Relative_Direction.WEST));
		Assert.assertEquals(Relative_Direction.WEST, gardens.convertAbsoluteDirectionToRoomRelativeDirection(Relative_Direction.NORTH));

	
		gardens.setPlacement(Room_Orientation.SOUTH, new Location(Floor_Name.GROUND,999,999));
		Assert.assertEquals(Relative_Direction.NORTH, gardens.convertAbsoluteDirectionToRoomRelativeDirection(Relative_Direction.SOUTH));
		Assert.assertEquals(Relative_Direction.EAST, gardens.convertAbsoluteDirectionToRoomRelativeDirection(Relative_Direction.WEST));
		Assert.assertEquals(Relative_Direction.SOUTH, gardens.convertAbsoluteDirectionToRoomRelativeDirection(Relative_Direction.NORTH));
		Assert.assertEquals(Relative_Direction.WEST, gardens.convertAbsoluteDirectionToRoomRelativeDirection(Relative_Direction.EAST));

	
		gardens.setPlacement(Room_Orientation.WEST, new Location(Floor_Name.GROUND,999,999));
		Assert.assertEquals(Relative_Direction.NORTH, gardens.convertAbsoluteDirectionToRoomRelativeDirection(Relative_Direction.WEST));
		Assert.assertEquals(Relative_Direction.EAST, gardens.convertAbsoluteDirectionToRoomRelativeDirection(Relative_Direction.NORTH));
		Assert.assertEquals(Relative_Direction.SOUTH, gardens.convertAbsoluteDirectionToRoomRelativeDirection(Relative_Direction.EAST));
		Assert.assertEquals(Relative_Direction.WEST, gardens.convertAbsoluteDirectionToRoomRelativeDirection(Relative_Direction.SOUTH));
}
	



}
