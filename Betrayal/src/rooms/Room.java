package rooms;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public abstract class Room {
	protected String name;
	protected Room_Orientation orientation;
	protected HashMap<Exit_Direction, Room> exits;
	
	public enum Room_Orientation {NORTH, EAST, SOUTH, WEST};  // Room rotations are defined which way the TOP of the card is pointing. NORTH is "normal"
	public enum Exit_Direction {NORTH, EAST, SOUTH, WEST};  // Room exits are relative to a NORTH orientation. For example, the Mystic Elevator ALWAYS has a southern exit
	
	
	public Room (String name, Room_Orientation orientation, HashMap<Exit_Direction, Room> exits) {
		this.name = name;
		this.orientation = orientation;
		this.exits = exits;
	}
	
	public String getName() {
		return this.name;
	}
	
//	public void addRoomExit(Exit_Direction direction, Room goesTo) {
//		getRoomExits().
//	}
	
	
	
	public Set<Exit_Direction> getRoomExitDirections() {
		return this.exits.keySet();
	}
	
	public Room_Orientation getOrientation() {
		return this.orientation;
	}
}
