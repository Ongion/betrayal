package test;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Locale;

import javax.swing.JOptionPane;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import rooms.Location;
import rooms.Room;
import rooms.Room.Floor_Name;
import rooms.Room.Relative_Direction;
import rooms.Room.Room_Orientation;
import rooms.RoomFactory;
import rooms.RoomName;
import tiles.BlessingTile;
import tiles.DripTile;
import tiles.SmokeTile;
import Game.Game;
import characters.Character;
import characters.Character.Character_Name;
import characters.ExplorerFactory;
import characters.HumanStats;
import characters.Trait;

public class TestRooms {
	ExplorerFactory explorers;
	Room grandStaircase;
	Room upperLanding;
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
	Room dustyHallwayWithTiles;
	Character zoeIngstrom;
	
	@Before
	public void setUp() {
		Game.resetGame();
		RoomFactory rooms = new RoomFactory();
		grandStaircase = Game.getInstance().getRoomByRoomName(RoomName.GRANDSTAIRCASE);
		upperLanding = Game.getInstance().getRoomByRoomName(RoomName.UPPERLANDING);
		
		gardens = rooms.makeRoom(RoomName.GARDENS);
		gardens.setPlacement(Room_Orientation.EAST, new Location(Floor_Name.GROUND, 10 , 0));

		organRoom = rooms.makeRoom(RoomName.ORGANROOM);
		organRoom.setPlacement(Room_Orientation.WEST, new Location(Floor_Name.GROUND, 9 , 0));	
		
		diningRoom = rooms.makeRoom(RoomName.DININGROOM);
		diningRoom.setPlacement(Room_Orientation.NORTH, new Location(Floor_Name.GROUND, 9, -1));

		basementLanding = Game.getInstance().getRoomByRoomName(RoomName.BASEMENTLANDING);
		
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
		
		dustyHallwayWithTiles = rooms.makeRoom(RoomName.DUSTYHALLWAY);
		dustyHallwayWithTiles.setPlacement(Room_Orientation.NORTH, new Location(Floor_Name.UPPER, -10, 7));
		
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
		
		HashSet<Relative_Direction> expectedGrandStaircaseExits = new HashSet<Relative_Direction>();
		expectedGrandStaircaseExits.add(Relative_Direction.SOUTH);
		expectedGrandStaircaseExits.add(Relative_Direction.UP);
		assertEquals(expectedGrandStaircaseExits, grandStaircase.getExits());
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
		
		assertEquals(upperLanding, grandStaircase.getRoomFromExit(Relative_Direction.UP));
		assertEquals(grandStaircase, upperLanding.getRoomFromExit(Relative_Direction.DOWN));
		
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
	public void testLeavingPentagramChamberFailingRollAndStillMoving() {
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
				oneOf(mockGame).makeYesNoDialogAndGetResult("FailedRollTitle", "FailedRollMessage"); will(returnValue(JOptionPane.YES_OPTION));
				oneOf(mockGame).getRoomAtLocation(new Location(Floor_Name.BASEMENT, 0, 0)); will(returnValue(basementLanding));
			}});
			zoeIngstrom = explorers.getExplorer(Character_Name.ZoeIngstrom);
			zoeIngstrom.setCurrentRoom(pentagramChamber);
			zoeIngstrom.setSideOfRoom(Relative_Direction.EAST);
			assertEquals(5, zoeIngstrom.getCurrentSanity());
			zoeIngstrom.attemptMoveInAbsoluteDirection(Relative_Direction.EAST);
			assertEquals(4, zoeIngstrom.getCurrentSanity());
			assertEquals(basementLanding, zoeIngstrom.getCurrentRoom());
			mocks.assertIsSatisfied();
		} catch(Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Test
	public void testLeavingPentagramChamberFailingRollAndStopsMoving() {
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
				oneOf(mockGame).makeYesNoDialogAndGetResult("FailedRollTitle", "FailedRollMessage"); will(returnValue(JOptionPane.NO_OPTION));
			}});
			zoeIngstrom = explorers.getExplorer(Character_Name.ZoeIngstrom);
			zoeIngstrom.setCurrentRoom(pentagramChamber);
			zoeIngstrom.setSideOfRoom(Relative_Direction.EAST);
			assertEquals(5, zoeIngstrom.getCurrentSanity());
			zoeIngstrom.attemptMoveInAbsoluteDirection(Relative_Direction.EAST);
			assertEquals(5, zoeIngstrom.getCurrentSanity());
			assertEquals(pentagramChamber, zoeIngstrom.getCurrentRoom());
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
	public void testLeavingJunkRoomFailingRollAndStillMoving() {
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
				oneOf(mockGame).makeYesNoDialogAndGetResult("FailedRollTitle", "FailedRollMessage"); will(returnValue(JOptionPane.YES_OPTION));
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
			assertEquals(basementLanding, zoeIngstrom.getCurrentRoom());
			mocks.assertIsSatisfied();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test
	public void testLeavingJunkRoomFailingRollAndStopsMoving() {
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
				oneOf(mockGame).makeYesNoDialogAndGetResult("FailedRollTitle", "FailedRollMessage"); will(returnValue(JOptionPane.NO_OPTION));
			}});
			zoeIngstrom.setCurrentRoom(junkRoom);
			zoeIngstrom.setSideOfRoom(Relative_Direction.EAST);
			assertEquals(3, ((HumanStats) zoeIngstrom.getStats()).getCurrentSpeedIndex());
			zoeIngstrom.attemptMoveInAbsoluteDirection(Relative_Direction.NORTH);
			assertEquals(3, ((HumanStats) zoeIngstrom.getStats()).getCurrentSpeedIndex());
			assertEquals(junkRoom, zoeIngstrom.getCurrentRoom());
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
	public void testConvertDirectionMethod(){
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
	
	@Test
	public void testBlessingTileAddsDiceToTraitRolls() {
		Mockery mocks = new Mockery() {{
	        setImposteriser(ClassImposteriser.INSTANCE);
	    }};
		final Game mockGame = mocks.mock(Game.class);
		try {
			Field instanceField = Game.class.getDeclaredField("INSTANCE");
			instanceField.setAccessible(true);
			instanceField.set(null, mockGame);
			zoeIngstrom = explorers.getExplorer(Character_Name.ZoeIngstrom);
			final int traitScore = zoeIngstrom.getCurrentKnowledge();
			
			mocks.checking(new Expectations() {{
				oneOf(mockGame).rollDice(traitScore+1); will(returnValue(4));
			}});
			zoeIngstrom.setCurrentRoom(dustyHallwayWithTiles);
			zoeIngstrom.setSideOfRoom(Relative_Direction.SOUTH);
			dustyHallwayWithTiles.addTraitRollModifyingTile(new BlessingTile());

			assertEquals(3, zoeIngstrom.getCurrentKnowledge());
			assertEquals(4, zoeIngstrom.getTraitRoll(Trait.KNOWLEDGE));
			mocks.assertIsSatisfied();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test
	public void testDripTileSubtractsDiceFromTraitRolls() {
		Mockery mocks = new Mockery() {{
	        setImposteriser(ClassImposteriser.INSTANCE);
	    }};
		final Game mockGame = mocks.mock(Game.class);
		try {
			Field instanceField = Game.class.getDeclaredField("INSTANCE");
			instanceField.setAccessible(true);
			instanceField.set(null, mockGame);
			zoeIngstrom = explorers.getExplorer(Character_Name.ZoeIngstrom);
			final int traitScore = zoeIngstrom.getCurrentKnowledge();
			
			mocks.checking(new Expectations() {{
				oneOf(mockGame).rollDice(traitScore-1); will(returnValue(4));
			}});
			zoeIngstrom.setCurrentRoom(dustyHallwayWithTiles);
			zoeIngstrom.setSideOfRoom(Relative_Direction.SOUTH);
			dustyHallwayWithTiles.addTraitRollModifyingTile(new DripTile());

			assertEquals(3, zoeIngstrom.getCurrentKnowledge());
			assertEquals(4, zoeIngstrom.getTraitRoll(Trait.KNOWLEDGE));
			mocks.assertIsSatisfied();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test
	public void testSmokeTileSubtractsDiceFromTraitRolls() {
		Mockery mocks = new Mockery() {{
	        setImposteriser(ClassImposteriser.INSTANCE);
	    }};
		final Game mockGame = mocks.mock(Game.class);
		try {
			Field instanceField = Game.class.getDeclaredField("INSTANCE");
			instanceField.setAccessible(true);
			instanceField.set(null, mockGame);
			zoeIngstrom = explorers.getExplorer(Character_Name.ZoeIngstrom);
			final int traitScore = zoeIngstrom.getCurrentKnowledge();
			
			mocks.checking(new Expectations() {{
				oneOf(mockGame).rollDice(traitScore-2); will(returnValue(2));
			}});
			zoeIngstrom.setCurrentRoom(dustyHallwayWithTiles);
			zoeIngstrom.setSideOfRoom(Relative_Direction.SOUTH);
			dustyHallwayWithTiles.addTraitRollModifyingTile(new SmokeTile());

			assertEquals(3, zoeIngstrom.getCurrentKnowledge());
			assertEquals(2, zoeIngstrom.getTraitRoll(Trait.KNOWLEDGE));
			mocks.assertIsSatisfied();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	



}
