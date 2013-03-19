package rooms;

import java.util.HashMap;

public class EventRoom extends Room {

	public EventRoom(String name, Room_Orientation orientation, HashMap<Exit_Direction,Room> exits) {
		super(name, orientation, exits);
	}
	
}
