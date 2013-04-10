package floors;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import rooms.Room;

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
	
}
