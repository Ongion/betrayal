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
	
	public Collection<Room> getRoomsOnFloor() {
		return this.floorLayout.values();
	}
	
	public void addRoom(FloorLocation locationOfNewRoom, Room roomToAdd) {
		if (this.floorLayout.containsKey(floorLayout)) {
			throw new IllegalArgumentException(String.format("The floor already has the room '%s' at location '%s'!", floorLayout.get(locationOfNewRoom), locationOfNewRoom.toString()));
		}
		this.floorLayout.put(locationOfNewRoom, roomToAdd);
	}
	
	public Room getConnectingRoomFromExit(FloorLocation locationOfStartingRoom, Room_Direction usingExit) {
		Room startingRoom = this.floorLayout.get(locationOfStartingRoom);
		
		if (!startingRoom.getDoorExits().contains(usingExit)) {
			throw new IllegalArgumentException(String.format("Room '%s' has no exit in direction '%s'", startingRoom.getName(), usingExit.toString()));
		}
		
		FloorLocation locationOfNewRoom = null;
		switch (startingRoom.getOrientation()) {
		case NORTH:
			switch(usingExit) {
			case NORTH:
				locationOfNewRoom = getFloorLocationToNorth(locationOfStartingRoom);
				break;
			case EAST:
				locationOfNewRoom = getFloorLocationToEast(locationOfStartingRoom);
				break;
			case SOUTH:
				locationOfNewRoom = getFloorLocationToSouth(locationOfStartingRoom);
				break;
			case WEST:
				locationOfNewRoom = getFloorLocationToWest(locationOfStartingRoom);
				break;
			}
			break;
		case EAST:
			switch (usingExit) {
			case NORTH:
				locationOfNewRoom = getFloorLocationToEast(locationOfStartingRoom);
				break;
			case EAST:
				locationOfNewRoom = getFloorLocationToSouth(locationOfStartingRoom);
				break;
			case SOUTH:
				locationOfNewRoom = getFloorLocationToWest(locationOfStartingRoom);
				break;
			default:  // case WEST
				locationOfNewRoom = getFloorLocationToNorth(locationOfStartingRoom);
				break;
			}
			break;

		case SOUTH:
			switch (usingExit) {
			case NORTH:
				locationOfNewRoom = getFloorLocationToSouth(locationOfStartingRoom);
				break;
			case EAST:
				locationOfNewRoom = getFloorLocationToWest(locationOfStartingRoom);
				break;
			case SOUTH:
				locationOfNewRoom = getFloorLocationToNorth(locationOfStartingRoom);
				break;
			default: //case WEST
				locationOfNewRoom = getFloorLocationToEast(locationOfStartingRoom);
				break;
			}
			break;
		default: //case WEST
			switch (usingExit) {
			case NORTH:
				locationOfNewRoom = getFloorLocationToWest(locationOfStartingRoom);
				break;
			case EAST:
				locationOfNewRoom = getFloorLocationToNorth(locationOfStartingRoom);
				break;
			case SOUTH:
				locationOfNewRoom = getFloorLocationToEast(locationOfStartingRoom);
				break;
			default:  // case WEST
				locationOfNewRoom  = getFloorLocationToSouth(locationOfStartingRoom);
				break;
			}
		}
		return floorLayout.get(locationOfNewRoom);
	}

	private FloorLocation getFloorLocationToNorth(FloorLocation locationOfStartingRoom) {
		return new FloorLocation(locationOfStartingRoom.getX(), locationOfStartingRoom.getY() + 1);
	}

	private FloorLocation getFloorLocationToWest(FloorLocation locationOfStartingRoom) {
		return new FloorLocation(locationOfStartingRoom.getX() - 1, locationOfStartingRoom.getY());
	}

	private FloorLocation getFloorLocationToSouth(FloorLocation locationOfStartingRoom) {
		return new FloorLocation(locationOfStartingRoom.getX(), locationOfStartingRoom.getY() - 1);
	}

	private FloorLocation getFloorLocationToEast(FloorLocation locationOfStartingRoom) {
		return new FloorLocation(locationOfStartingRoom.getX() + 1, locationOfStartingRoom.getY());
	}
	
	
}
