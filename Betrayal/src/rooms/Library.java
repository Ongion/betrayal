package rooms;

import java.util.HashSet;
import characters.Character;

public class Library extends EventRoom {

	public Library(String name, Room_Orientation orientation, HashSet<Room_Direction> doorExits) {
		super(name, orientation, doorExits);
	}
	
	@Override
	public void endTurnInRoom(Character characterEndingTurn) {
		//TODO Check to see if the character has ended their turn here already
		characterEndingTurn.incrementKnowledge(1);
	}

}
