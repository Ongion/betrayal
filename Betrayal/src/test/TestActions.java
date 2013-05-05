package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import itemCards.AngelFeather;
import itemCards.DarkDice;

import java.lang.reflect.Field;
import java.util.Locale;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.After;
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
import Game.Game;
import actions.IAction;
import actions.JumpDownFromGalleryToBallroomAction;
import actions.OpenVaultAction;
import actions.UseSecretPassageAction;
import actions.UseSecretStairsAction;
import characters.Character;
import characters.Character.Character_Name;
import characters.ExplorerFactory;

public class TestActions {
	
	Room gallery;
	Room ballroom;
	Room basementLandingWithSecretStairs1;
	Room bedroomWithSecretStairs2;
	Room catacombsWithSecretStairs3;
	Room foyerWithSecretStairs4;
	Room chasmWithSecretPassage1;
	Room charredRoomWithSecretPassage2;
	Room vault;
	Character darrinWilliamsJumpingDownFromGallery;
	Character missyDubourdeUsingSecretStairs;
	Character zoeIngstromUsingSecretStairs;
	Character professorLongfellowUsingSecretPassage;
	Character peterAkimotoOpeningVault;
	IAction jumpDownToBallroom;
	IAction useSecretStairs1;
	IAction useSecretStairs2;
	IAction useSecretStairs3;
	IAction useSecretStairs4;
	IAction useSecretPassage1;
	IAction useSecretPassage2;
	IAction openVault;
	
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
		
		catacombsWithSecretStairs3 = rooms.makeRoom(RoomName.CATACOMBS);
		catacombsWithSecretStairs3.setPlacement(Room_Orientation.NORTH, new Location(Floor_Name.BASEMENT, 15, 15));
		
		foyerWithSecretStairs4 = Game.getInstance().getRoomByRoomName(RoomName.FOYER);
		
		chasmWithSecretPassage1 = rooms.makeRoom(RoomName.CHASM);
		chasmWithSecretPassage1.setPlacement(Room_Orientation.NORTH, new Location(Floor_Name.BASEMENT, 20, -13));
		
		vault = rooms.makeRoom(RoomName.VAULT);
		vault.setPlacement(Room_Orientation.NORTH, new Location(Floor_Name.BASEMENT, -5, 7));
		
		charredRoomWithSecretPassage2 = rooms.makeRoom(RoomName.CHARREDROOM);
		charredRoomWithSecretPassage2.setPlacement(Room_Orientation.SOUTH, new Location(Floor_Name.GROUND, 0, -8));
		
		ExplorerFactory explorers = new ExplorerFactory();
		darrinWilliamsJumpingDownFromGallery = explorers.getExplorer(Character_Name.DarrinWilliams);
		missyDubourdeUsingSecretStairs = explorers.getExplorer(Character_Name.MissyDubourde);
		zoeIngstromUsingSecretStairs = explorers.getExplorer(Character_Name.ZoeIngstrom);
		professorLongfellowUsingSecretPassage = explorers.getExplorer(Character_Name.ProfessorLongfellow);
		peterAkimotoOpeningVault = explorers.getExplorer(Character_Name.PeterAkimoto);
		
		darrinWilliamsJumpingDownFromGallery.setCurrentRoom(gallery);
		darrinWilliamsJumpingDownFromGallery.setSideOfRoom(Relative_Direction.NORTH);
		missyDubourdeUsingSecretStairs.setCurrentRoom(bedroomWithSecretStairs2);
		missyDubourdeUsingSecretStairs.setSideOfRoom(Relative_Direction.WEST);
		zoeIngstromUsingSecretStairs.setCurrentRoom(catacombsWithSecretStairs3);
		zoeIngstromUsingSecretStairs.setSideOfRoom(Relative_Direction.NORTH);
		professorLongfellowUsingSecretPassage.setCurrentRoom(chasmWithSecretPassage1);
		professorLongfellowUsingSecretPassage.setSideOfRoom(Relative_Direction.EAST);
		peterAkimotoOpeningVault.setCurrentRoom(vault);
		peterAkimotoOpeningVault.setSideOfRoom(Relative_Direction.NORTH);
		
		jumpDownToBallroom = gallery.getRoomActions().toArray(new IAction[1])[0];
		useSecretStairs1 = new UseSecretStairsAction(basementLandingWithSecretStairs1, bedroomWithSecretStairs2, Relative_Direction.EAST, missyDubourdeUsingSecretStairs.getSideOfRoom());
		useSecretStairs2 = new UseSecretStairsAction(bedroomWithSecretStairs2, basementLandingWithSecretStairs1, missyDubourdeUsingSecretStairs.getSideOfRoom(), Relative_Direction.EAST);
		useSecretStairs3 = new UseSecretStairsAction(catacombsWithSecretStairs3, foyerWithSecretStairs4, zoeIngstromUsingSecretStairs.getSideOfRoom(), Relative_Direction.WEST);
		useSecretStairs4 = new UseSecretStairsAction(foyerWithSecretStairs4, catacombsWithSecretStairs3, Relative_Direction.WEST, zoeIngstromUsingSecretStairs.getSideOfRoom());
		useSecretPassage1 = new UseSecretPassageAction(chasmWithSecretPassage1, charredRoomWithSecretPassage2, professorLongfellowUsingSecretPassage.getSideOfRoom(), Relative_Direction.WEST);
		useSecretPassage2 = new UseSecretPassageAction(charredRoomWithSecretPassage2, chasmWithSecretPassage1, Relative_Direction.WEST, professorLongfellowUsingSecretPassage.getSideOfRoom());
		openVault = vault.getRoomActions().toArray(new IAction[1])[0];
		
		basementLandingWithSecretStairs1.addRoomAction(useSecretStairs1);
		bedroomWithSecretStairs2.addRoomAction(useSecretStairs2);
		catacombsWithSecretStairs3.addRoomAction(useSecretStairs3);
		foyerWithSecretStairs4.addRoomAction(useSecretStairs4);
		chasmWithSecretPassage1.addRoomAction(useSecretPassage1);
		charredRoomWithSecretPassage2.addRoomAction(useSecretPassage2);
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCannotJumpDownWithNoBallroom() {
		assertFalse(jumpDownToBallroom.canPerform(darrinWilliamsJumpingDownFromGallery));
		jumpDownToBallroom.perform(darrinWilliamsJumpingDownFromGallery);
		assertEquals(gallery, darrinWilliamsJumpingDownFromGallery.getCurrentRoom());
	}
	
	@Test
	public void testCanJumpDownWithBallroom() {
		ballroom.setPlacement(Room_Orientation.NORTH, new Location(Floor_Name.GROUND, 100, 25));
		IAction[] galleryActions = gallery.getRoomActions().toArray(new IAction[1]);
		for (IAction action : galleryActions) {
			assertTrue(action.canPerform(darrinWilliamsJumpingDownFromGallery));
		}
	}

	@Test
	public void testJumpDown() {
		ballroom.setPlacement(Room_Orientation.NORTH, new Location(Floor_Name.GROUND, 100, 25));
		jumpDownToBallroom.perform(darrinWilliamsJumpingDownFromGallery);
		assertEquals(ballroom, darrinWilliamsJumpingDownFromGallery.getCurrentRoom());
	}
	
	@Test
	public void testCanUseSecretStairsWhenNotInBarrierRooms() {
		assertTrue(useSecretStairs2.canPerform(missyDubourdeUsingSecretStairs));
	}
	
	@Test
	public void testCanUseSecretStairsWhenInBarrierRoomsOnCorrectSide() {
		assertTrue(useSecretStairs3.canPerform(zoeIngstromUsingSecretStairs));
	}
	
	@Test
	public void testCannotUseSecretStairsWhenInBarrierRoomsOnWrongSide() {
		zoeIngstromUsingSecretStairs.setSideOfRoom(Relative_Direction.SOUTH);
		assertFalse(useSecretStairs3.canPerform(zoeIngstromUsingSecretStairs));
	}
	
	@Test public void testUsingSecretStairsWorksProperly() {
		useSecretStairs2.perform(missyDubourdeUsingSecretStairs);
		
		assertEquals(basementLandingWithSecretStairs1, missyDubourdeUsingSecretStairs.getCurrentRoom());
		assertEquals(Relative_Direction.EAST, missyDubourdeUsingSecretStairs.getSideOfRoom());
		
		useSecretStairs1.perform(missyDubourdeUsingSecretStairs);
		assertEquals(bedroomWithSecretStairs2, missyDubourdeUsingSecretStairs.getCurrentRoom());
		assertEquals(Relative_Direction.WEST, missyDubourdeUsingSecretStairs.getSideOfRoom());
		
		useSecretStairs3.perform(zoeIngstromUsingSecretStairs);
		assertEquals(foyerWithSecretStairs4, zoeIngstromUsingSecretStairs.getCurrentRoom());
		assertEquals(Relative_Direction.WEST, zoeIngstromUsingSecretStairs.getSideOfRoom());
		
		useSecretStairs4.perform(zoeIngstromUsingSecretStairs);
		assertEquals(catacombsWithSecretStairs3, zoeIngstromUsingSecretStairs.getCurrentRoom());
		assertEquals(Relative_Direction.NORTH, zoeIngstromUsingSecretStairs.getSideOfRoom());
		
		zoeIngstromUsingSecretStairs.setSideOfRoom(Relative_Direction.SOUTH);
		useSecretStairs3.perform(zoeIngstromUsingSecretStairs);
		assertEquals(catacombsWithSecretStairs3, zoeIngstromUsingSecretStairs.getCurrentRoom());
	}
	
	@Test
	public void testGetDescription() {
		// English
		assertEquals("Jump down to the Ballroom. Take 1 point of physical damage.", jumpDownToBallroom.getDescription());
		assertEquals("Go through the secret stairs. Takes one movement.", useSecretStairs1.getDescription());
		assertEquals("Go through the secret passage. Takes one movement.", useSecretPassage1.getDescription());
		assertEquals("Attempt to open the Vault. Requires a Knowledge roll of 6+", openVault.getDescription());
		
		// Spanish
	}

	@Test
	public void testGetName() {
		// English
		assertEquals("Jump down to Ballroom", jumpDownToBallroom.getName());
		assertEquals("Use Secret Stairs", useSecretStairs1.getName());
		assertEquals("Use Secret Passage", useSecretPassage1.getName());
		assertEquals("Open Vault", openVault.getName());
		
		// Spanish
		
	}
	
	@Test
	public void testCannotUseSecretPassageOnWrongSideOfBarrierRoom() {
		professorLongfellowUsingSecretPassage.setSideOfRoom(Relative_Direction.WEST);
		assertFalse(useSecretPassage1.canPerform(professorLongfellowUsingSecretPassage));
		useSecretPassage1.perform(professorLongfellowUsingSecretPassage);
		assertEquals(chasmWithSecretPassage1, professorLongfellowUsingSecretPassage.getCurrentRoom());
	}
	
	@Test
	public void testCannotUseSecretPassageWhenNotInRoom() {
		assertFalse(useSecretPassage2.canPerform(professorLongfellowUsingSecretPassage));
	}
	
	@Test
	public void testCanUseSecretPassageOnCorrectSideOfBarrierRoom() {
		assertTrue(useSecretPassage1.canPerform(professorLongfellowUsingSecretPassage));
	}
	
	@Test
	public void usingSecretPassagePutsYouInTheOtherRoom() {
		useSecretPassage1.perform(professorLongfellowUsingSecretPassage);
		assertEquals(charredRoomWithSecretPassage2, professorLongfellowUsingSecretPassage.getCurrentRoom());
		assertEquals(Relative_Direction.WEST, professorLongfellowUsingSecretPassage.getSideOfRoom());
		
		useSecretPassage2.perform(professorLongfellowUsingSecretPassage);
		assertEquals(chasmWithSecretPassage1, professorLongfellowUsingSecretPassage.getCurrentRoom());
		assertEquals(Relative_Direction.EAST, professorLongfellowUsingSecretPassage.getSideOfRoom());
	}
	
	@Test
	public void testSecretStairsEquals() {
		assertEquals(new UseSecretStairsAction(basementLandingWithSecretStairs1, bedroomWithSecretStairs2, Relative_Direction.EAST, Relative_Direction.WEST), useSecretStairs1);
		assertFalse(useSecretStairs1.equals(useSecretStairs2));
		assertFalse(useSecretStairs1.equals(jumpDownToBallroom));
	}
	
	@Test
	public void testSecretPassageEquals() {
		assertEquals(new UseSecretPassageAction(chasmWithSecretPassage1, charredRoomWithSecretPassage2, Relative_Direction.EAST, Relative_Direction.WEST), useSecretPassage1);
		assertFalse(useSecretPassage1.equals(useSecretPassage2));
		assertFalse(useSecretPassage1.equals(useSecretStairs1));
	}
	
	@Test
	public void testJumpDownEquals() {
		assertEquals(new JumpDownFromGalleryToBallroomAction(), jumpDownToBallroom);
		assertFalse(jumpDownToBallroom.equals(useSecretStairs4));
	}
	
	@Test
	public void testOpenVaultEquals() {
		assertEquals(new OpenVaultAction(vault), openVault);
		assertFalse(new OpenVaultAction(ballroom).equals(openVault));
		assertFalse(openVault.equals(jumpDownToBallroom));
	}
	
	@Test
	public void testCanOpenVaultSucceedsWithKnowledgeRollOfAtLeast6() {
		Mockery mocks = new Mockery() {{
	        setImposteriser(ClassImposteriser.INSTANCE);
	    }};
		final Game mockGame = mocks.mock(Game.class);
		try {
			Field instanceField = Game.class.getDeclaredField("INSTANCE");
			instanceField.setAccessible(true);
			instanceField.set(null, mockGame);
			final int knowledgeScore = peterAkimotoOpeningVault.getCurrentKnowledge();
			
			mocks.checking(new Expectations() {{
				oneOf(mockGame).rollDice(knowledgeScore); will(returnValue(6));
				oneOf(mockGame).drawItem(); will(returnValue(new AngelFeather(new Locale("en", "US"))));
				oneOf(mockGame).drawItem(); will(returnValue(new DarkDice(new Locale("en", "US"))));
			}});
			assertTrue(openVault.canPerform(peterAkimotoOpeningVault));
			assertTrue(peterAkimotoOpeningVault.getItemHand().isEmpty());
			openVault.perform(peterAkimotoOpeningVault);
			assertEquals(2, peterAkimotoOpeningVault.getItemHand().size());
			mocks.assertIsSatisfied();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test
	public void testCanOpenVaultFailsWithKnowledgeRollLessThan6() {
		Mockery mocks = new Mockery() {{
	        setImposteriser(ClassImposteriser.INSTANCE);
	    }};
		final Game mockGame = mocks.mock(Game.class);
		try {
			Field instanceField = Game.class.getDeclaredField("INSTANCE");
			instanceField.setAccessible(true);
			instanceField.set(null, mockGame);
			final int knowledgeScore = peterAkimotoOpeningVault.getCurrentKnowledge();
			
			mocks.checking(new Expectations() {{
				oneOf(mockGame).rollDice(knowledgeScore); will(returnValue(4));
			}});
			assertTrue(openVault.canPerform(peterAkimotoOpeningVault));
			assertTrue(peterAkimotoOpeningVault.getItemHand().isEmpty());
			openVault.perform(peterAkimotoOpeningVault);
			assertTrue(peterAkimotoOpeningVault.getItemHand().isEmpty());
			mocks.assertIsSatisfied();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test
	public void testCannotOpenVaultWhenNotItRoom() {
		assertFalse(openVault.canPerform(missyDubourdeUsingSecretStairs));
		openVault.perform(missyDubourdeUsingSecretStairs);
		assertTrue(missyDubourdeUsingSecretStairs.getItemHand().isEmpty());
	}
}
