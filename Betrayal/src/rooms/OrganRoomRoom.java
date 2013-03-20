package rooms;

import java.util.HashMap;

public class OrganRoomRoom extends Room {

	public OrganRoomRoom() {
		super("Organ Room");

		this.exits.put(Exit_Direction.SOUTH, null);
		this.exits.put(Exit_Direction.WEST, null);

	}

}
