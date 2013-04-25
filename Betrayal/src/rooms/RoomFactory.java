package rooms;

import java.util.HashMap;
import java.util.HashSet;

import rooms.Room.Floor_Name;
import rooms.Room.Relative_Direction;

public class RoomFactory {

	public RoomFactory() {}
	
	public Room makeRoom(RoomName nameOfRoom) {
		HashSet<Relative_Direction> roomExits = new HashSet<Relative_Direction>();
		HashSet<Floor_Name> roomFloors = new HashSet<Floor_Name>();
		HashMap<Relative_Direction,Integer> roomWindows = new HashMap<Relative_Direction, Integer>();
		Room room = null;
		switch(nameOfRoom) {
		case GARDEN:
			roomExits.add(Relative_Direction.NORTH);
			roomExits.add(Relative_Direction.SOUTH);
			roomFloors.add(Floor_Name.GROUND);
			room = new EventRoom("Garden", roomExits, roomFloors);
			break;
		case ORGANROOM:
			roomExits.add(Relative_Direction.SOUTH);
			roomExits.add(Relative_Direction.WEST);
			roomFloors.add(Floor_Name.UPPER);
			roomFloors.add(Floor_Name.GROUND);
			roomFloors.add(Floor_Name.BASEMENT);
			room = new EventRoom("Organ Room", roomExits, roomFloors);
			break;
		case DININGROOM:
			roomExits.add(Relative_Direction.NORTH);
			roomExits.add(Relative_Direction.EAST);
			roomFloors.add(Floor_Name.GROUND);
			roomWindows.put(Relative_Direction.WEST, 2);
			room = new OmenRoom("Dining Room", roomExits, roomFloors, roomWindows);
			break;
		}
		return room;
	}
	

}
