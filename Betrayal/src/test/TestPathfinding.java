package test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;

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
import characters.Explorer;
import characters.Explorer.Explorers;
import floors.Location;

public class TestPathfinding {

	Room organRoom;
	Room gardens;
	Room diningRoom;
	Room junkRoom;
	
	Character c1, c2, c3, c4, c5, c6;
	
	@Before
	public void init() {
		Game.resetGame();
		
		HashSet<Relative_Direction> allDirectionExits = new HashSet<Relative_Direction>();
		allDirectionExits.add(Relative_Direction.NORTH);
		allDirectionExits.add(Relative_Direction.SOUTH);
		allDirectionExits.add(Relative_Direction.EAST);
		allDirectionExits.add(Relative_Direction.WEST);
		
		HashSet<Floor_Name> gardensFloors = new HashSet<Floor_Name>();
		gardensFloors.add(Floor_Name.GROUND);
		gardens = new EventRoom("Garden", allDirectionExits, gardensFloors);
		gardens.setPlacement(Room_Orientation.EAST, new Location(Floor_Name.GROUND, 0 , 0));

		HashSet<Floor_Name> organRoomFloors = new HashSet<Floor_Name>();
		organRoomFloors.add(Floor_Name.UPPER);
		organRoomFloors.add(Floor_Name.GROUND);
		organRoomFloors.add(Floor_Name.BASEMENT);
		organRoom = new EventRoom("Organ Room", allDirectionExits, organRoomFloors);
		organRoom.setPlacement(Room_Orientation.WEST, new Location(Floor_Name.GROUND, -1 , 0));	
		
		HashSet<Floor_Name> diningRoomFloors = new HashSet<Floor_Name>();
		diningRoomFloors.add(Floor_Name.GROUND);
		HashMap<Relative_Direction, Integer> diningRoomWindows = new HashMap<Relative_Direction, Integer>();
		diningRoomWindows.put(Relative_Direction.WEST, 2);
		diningRoom = new OmenRoom("Dining Room", allDirectionExits, diningRoomFloors, diningRoomWindows);
		diningRoom.setPlacement(Room_Orientation.NORTH, new Location(Floor_Name.GROUND, -1, 1));
		
		HashSet<Floor_Name> junkRoomFloors = new HashSet<Floor_Name>();
		junkRoomFloors.add(Floor_Name.UPPER);
		junkRoomFloors.add(Floor_Name.GROUND);
		junkRoomFloors.add(Floor_Name.BASEMENT);
		junkRoom = new JunkRoomRoom("Junk Room", allDirectionExits, junkRoomFloors);
		junkRoom.setPlacement(Room_Orientation.NORTH, new Location(Floor_Name.GROUND, 0, 1));

		c1 = new Explorer(Explorers.BrandonJaspers, new Locale("en"));
		c2 = new Explorer(Explorers.FatherRhinehardt, new Locale("en"));
		c3 = new Explorer(Explorers.DarrinWilliams, new Locale("en"));
		c4 = new Explorer(Explorers.HeatherGranville, new Locale("en"));
		c5 = new Explorer(Explorers.JennyLeClerc, new Locale("en"));
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
		c2.setCurrentRoom(diningRoom);
		c3.setCurrentRoom(junkRoom);
		
		Game.getInstance().addCharacter(c1);
		Game.getInstance().addCharacter(c2);
		Game.getInstance().addCharacter(c3);
		
		Character nearest = c1.getNearestCharacter();
		
		Assert.assertEquals(c3, nearest);

	}

}
