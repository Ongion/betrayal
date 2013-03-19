package rooms;

import java.util.HashMap;

public class BlankRoom extends Room {

	public BlankRoom(String name, Room_Orientation orientation, HashMap<Exit_Direction,Room> exits) {
		super(name, orientation, exits);
	}
	
}
