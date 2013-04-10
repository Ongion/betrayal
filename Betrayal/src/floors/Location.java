package floors;

import rooms.Room.Floor_Name;

public class Location {
	private Floor_Name floor;
	private int x;
	private int y;
	
	public Location(Floor_Name floor, int x, int y) {
		this.floor = floor;
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public Floor_Name getFloor() {
		return this.floor;
	}
		
	public Location getFloorLocationToNorth() {
		return new Location(this.getFloor(), this.getX(), this.getY() + 1);
	}
	public Location getFloorLocationToWest() {
		return new Location(this.getFloor(), this.getX() - 1, this.getY());
	}

	public Location getFloorLocationToSouth() {
		return new Location(this.getFloor(), this.getX(), this.getY() - 1);
	}

	public Location getFloorLocationToEast() {
		return new Location(this.getFloor(), this.getX() + 1, this.getY());
	}

	@Override
	public boolean equals(Object otherFloorLocation) {  // HashMaps and HashSets expect to be using '.equals(OBJECT)', not '.equals(FloorLocation)'. That's why this implementation is screwy.
		if (otherFloorLocation instanceof Location) {
			Location oFL = (Location) otherFloorLocation;
			return (this.floor == oFL.getFloor() && this.x == oFL.getX() && this.y == oFL.getY());
		}
		else {
			return false;
		}
	}
	
	@Override
	public int hashCode() { //Must override hashCode when overriding equals. Just doing some stuff with prime numbers. Hopefully, good enough to avoid collisions?
		int hash = 31;
		hash = 89 * hash + this.floor.ordinal();
		hash = 89 * hash + this.x;
		hash = 89 * hash + (int) (this.y ^ (this.y >>> 32));
		return hash;
	}
	
	public String toString() {
		return this.floor.toString()+"("+this.x+","+this.y+")";
	}
	
}
