package rooms;

import java.util.HashSet;
import characters.Character;

public class Library extends EventRoom {

	public Library(String name, Room_Orientation orientation, HashSet<Room_Direction> doorExits) {
		super(name, orientation, doorExits);
	}
	
	@Override
	public void endTurnInRoom(Character characterEndingTurn) {
		if (!characterEndingTurn.getRoomsEndedIn().contains(this)) {
			characterEndingTurn.incrementKnowledge(1);
			characterEndingTurn.getRoomsEndedIn().add(this);
		}
	}

}
