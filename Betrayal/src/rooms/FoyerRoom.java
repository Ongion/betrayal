package rooms;

import rooms.Room.Exit_Direction;
import rooms.Room.Room_Orientation;

public class FoyerRoom extends Room {
	public FoyerRoom() {
		super("Foyer");
		this.exits.put(Exit_Direction.EAST, null);
		this.exits.put(Exit_Direction.WEST, null);
	}
}
