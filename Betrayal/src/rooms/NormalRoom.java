package rooms;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class NormalRoom extends Room{
	
	public NormalRoom(String name, Room_Orientation orientation, Set<Relative_Direction> doorExits, Set<Floor_Name> floorsAllowedOn, Map<Relative_Direction, Integer> windows) {
		super(name, orientation, doorExits, floorsAllowedOn, windows);
	}

	public NormalRoom(String name, Room_Orientation orientation, Set<Relative_Direction> doorExits, Set<Floor_Name> floorsAllowedOn) {
		super(name, orientation, doorExits, floorsAllowedOn, new HashMap<Relative_Direction, Integer>());
	}

}
