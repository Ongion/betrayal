package floors;

import java.util.HashMap;

import rooms.Room;

public class Floor {
	private HashMap<FloorLocation, Room> floorLayout;
	private FloorName name;
	public enum FloorName {basement, ground, upper};
	
	public Floor(FloorName floorName) {
		this.name = floorName;
		this.floorLayout = new HashMap<FloorLocation, Room>();
	}
	
	
}
