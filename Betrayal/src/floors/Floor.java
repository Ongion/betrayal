package floors;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import rooms.Room;
import rooms.Room.Relative_Direction;

public class Floor {
	private Map<Location, Room> floorLayout;
	private FloorName name;
	public enum FloorName {basement, ground, upper};
	
	public Floor(FloorName floorName) {
		this.name = floorName;
		this.floorLayout = new HashMap<Location, Room>();
	}
	

	public FloorName getName() {
		return this.name;
	}
	
	public boolean containsRoomWithName(String roomName) {
		for (Room room : this.getRoomsOnFloor()) {
			if (room.getName().equals(roomName)) {
				return true;
			}
		}
		return false;
	}
	
	private Collection<Room> getRoomsOnFloor() {
		return this.floorLayout.values();
	}
		
	
	public Room getRoomAtLocation(Location location) {
		return this.floorLayout.get(location);
	}
	
	public Room getNextdoorRoomFromExit(Location locationOfStartingRoom, Relative_Direction usingExit) {
		Room startingRoom = this.floorLayout.get(locationOfStartingRoom);
		
		if (!startingRoom.getExits().contains(usingExit)) {
			throw new IllegalArgumentException(String.format("Room '%s' has no exit in direction '%s'", startingRoom.getName(), usingExit.toString()));
		}
		
		Location locationOfNewRoom = locationOfStartingRoom.getLocationOfRoomAtExit(usingExit, startingRoom.getOrientation());
		return floorLayout.get(locationOfNewRoom);
	}
	
}
