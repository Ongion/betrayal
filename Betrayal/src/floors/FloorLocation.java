package floors;

import rooms.Room.Room_Direction;
import rooms.Room.Room_Orientation;

public class FloorLocation {
	private int x;
	private int y;
	
	public FloorLocation(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	@Override
	public boolean equals(Object otherFloorLocation) {  // HashMaps and HashSets expect to be using '.equals(OBJECT)', not '.equals(FloorLocation)'. That's why this implementation is screwy.
		if (otherFloorLocation instanceof FloorLocation) {
			FloorLocation oFL = (FloorLocation) otherFloorLocation;
			return (this.x == oFL.getX() && this.y == oFL.getY());
		}
		else {
			return false;
		}
	}
	
	public FloorLocation getLocationOfRoomAtExit(Room_Direction usingExit, Room_Orientation orientationOfStartingRoom) {
		FloorLocation locationOfNewRoom = null;
		switch (orientationOfStartingRoom) {
		case NORTH:
			switch(usingExit) {
			case NORTH:
				locationOfNewRoom = this.getFloorLocationToNorth();
				break;
			case EAST:
				locationOfNewRoom = this.getFloorLocationToEast();
				break;
			case SOUTH:
				locationOfNewRoom = this.getFloorLocationToSouth();
				break;
			case WEST:
				locationOfNewRoom = this.getFloorLocationToWest();
				break;
			}
			break;
		case EAST:
			switch (usingExit) {
			case NORTH:
				locationOfNewRoom = this.getFloorLocationToEast();
				break;
			case EAST:
				locationOfNewRoom = this.getFloorLocationToSouth();
				break;
			case SOUTH:
				locationOfNewRoom = this.getFloorLocationToWest();
				break;
			default:  // case WEST
				locationOfNewRoom = this.getFloorLocationToNorth();
				break;
			}
			break;

		case SOUTH:
			switch (usingExit) {
			case NORTH:
				locationOfNewRoom = this.getFloorLocationToSouth();
				break;
			case EAST:
				locationOfNewRoom = this.getFloorLocationToWest();
				break;
			case SOUTH:
				locationOfNewRoom = this.getFloorLocationToNorth();
				break;
			default: //case WEST
				locationOfNewRoom = this.getFloorLocationToEast();
				break;
			}
			break;
		default: //case WEST
			switch (usingExit) {
			case NORTH:
				locationOfNewRoom = this.getFloorLocationToWest();
				break;
			case EAST:
				locationOfNewRoom = this.getFloorLocationToNorth();
				break;
			case SOUTH:
				locationOfNewRoom = this.getFloorLocationToEast();
				break;
			default:  // case WEST
				locationOfNewRoom = this.getFloorLocationToSouth();
				break;
			}
		}
		return locationOfNewRoom;
	}

	
	private FloorLocation getFloorLocationToNorth() {
		return new FloorLocation(this.getX(), this.getY() + 1);
	}
	private FloorLocation getFloorLocationToWest() {
		return new FloorLocation(this.getX() - 1, this.getY());
	}

	private FloorLocation getFloorLocationToSouth() {
		return new FloorLocation(this.getX(), this.getY() - 1);
	}

	private FloorLocation getFloorLocationToEast() {
		return new FloorLocation(this.getX() + 1, this.getY());
	}


	
	@Override
	public int hashCode() { //Must override hashCode when overriding equals. Just doing some stuff with prime numbers. Hopefully, good enough to avoid collisions?
		int hash = 31;
		hash = 89 * hash + this.x;
		hash = 89 * hash + (int) (this.y ^ (this.y >>> 32));
		return hash;
	}
	
	public String toString() {
		return "("+this.x+","+this.y+")";
	}
	
}
