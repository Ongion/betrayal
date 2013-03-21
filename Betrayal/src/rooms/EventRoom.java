package rooms;

import java.util.HashMap;
import java.util.HashSet;

public class EventRoom extends Room{
	
	public EventRoom(String name, Room_Orientation orientation,	HashSet<Room_Direction> doorExits, HashMap<Room_Direction, Integer> windows) {
		super(name, orientation, doorExits, windows);
	}

	public EventRoom(String name, Room_Orientation orientation,	HashSet<Room_Direction> doorExits) {
		super(name, orientation, doorExits, new HashMap<Room_Direction, Integer>());
	}

}
