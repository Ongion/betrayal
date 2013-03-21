package floors;

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
