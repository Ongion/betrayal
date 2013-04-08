package floors;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import rooms.Room;
import rooms.Room.Room_Direction;

public class Floor {
	private Map<FloorLocation, Room> floorLayout;
	private FloorName name;
	public enum FloorName {basement, ground, upper};
	
	public Floor(FloorName floorName) {
		this.name = floorName;
		this.floorLayout = new HashMap<FloorLocation, Room>();
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
	
	public Collection<Room> getRoomsOnFloor() {
		return this.floorLayout.values();
	}
		
	
	public Room getRoomAtLocation(FloorLocation location) {
		return this.floorLayout.get(location);
	}
	
	public Room getNextdoorRoomFromExit(FloorLocation locationOfStartingRoom, Room_Direction usingExit) {
		Room startingRoom = this.floorLayout.get(locationOfStartingRoom);
		
		if (!startingRoom.getDoorExits().contains(usingExit)) {
			throw new IllegalArgumentException(String.format("Room '%s' has no exit in direction '%s'", startingRoom.getName(), usingExit.toString()));
		}
		
		FloorLocation locationOfNewRoom = locationOfStartingRoom.getLocationOfRoomAtExit(usingExit, startingRoom.getOrientation());
		return floorLayout.get(locationOfNewRoom);
	}


	public void addRoom(FloorLocation locationOfRoomToAdd, Room roomToAdd) {
		this.floorLayout.put(locationOfRoomToAdd, roomToAdd);
		roomToAdd.setFloor(this);
		roomToAdd.setLocation(locationOfRoomToAdd);
	}	
	
}
