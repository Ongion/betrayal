package rooms;

import java.util.Map;
import java.util.Set;

import floors.Floor.FloorName;

public abstract class Room {
	protected final String name;
	protected Room_Orientation orientation;
	protected final Set<Room_Direction> doorExits;
	protected Set<FloorName> floorsAllowedOn;
	protected Map<Room_Direction, Integer> windows;
	
	public enum Room_Orientation {NORTH, EAST, SOUTH, WEST};  // Room rotations are defined which way the TOP of the card is pointing. NORTH is "normal", where text on the card is readable
	public enum Room_Direction {NORTH, EAST, SOUTH, WEST};  // Room directions are relative to a NORTH orientation. For example, the Mystic Elevator ALWAYS has a southern exit
	
	
	public Room (String name, Room_Orientation orientation, Set<Room_Direction> doorExits, Map<Room_Direction, Integer> windows) {
		this.name = name;
		this.orientation = orientation;
		this.doorExits = doorExits;
		this.windows = windows;
	}
	
	public String getName() {
		return this.name;
	}
		
	public void setOrientation(Room_Orientation newOrientation) {
		this.orientation = newOrientation;
	}
	
	public Set<Room_Direction> getDoorExits() {
		return this.doorExits;
	}
	
	public Room_Orientation getOrientation() {
		return this.orientation;
	}
	
	public Map<Room_Direction, Integer> getWindows() {
		return this.windows;
	}
	
	@Override
	public boolean equals(Object other) {
		if (other instanceof Room) {
			Room otherRoom = (Room) other;
			return (this.name.equals(otherRoom.getName()) && this.orientation.equals(otherRoom.getOrientation()) && this.doorExits.equals(otherRoom.getDoorExits()) && this.windows.equals(otherRoom.getWindows()));
		} else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		int prime = 31;
		int result = 1;
		result = prime * result + (this.name== null? 0 : name.hashCode());
		result = prime * result + (this.orientation.ordinal());
		return result;
	}
	
	
}
