package actions;

import java.util.ResourceBundle;

import Game.Game;
import rooms.Room;
import rooms.Room.Relative_Direction;
import characters.Character;

public class UseSecretPassageAction implements IAction {
	private Room thisEndOfPassage;
	private Room otherEndOfPassage;
	private Relative_Direction thisEndsSideOfPassage;
	private Relative_Direction otherEndsSideOfPassage;

	public UseSecretPassageAction(Room thisEndOfPassage, Room otherEndOfPassage, Relative_Direction thisEndsSideOfRoom, Relative_Direction otherEndsSideOfRoom) {
		this.thisEndOfPassage = thisEndOfPassage;
		this.otherEndOfPassage = otherEndOfPassage;
		this.thisEndsSideOfPassage = thisEndsSideOfRoom;
		this.otherEndsSideOfPassage = otherEndsSideOfRoom;
	}

	@Override
	public String getName() {
		return ResourceBundle.getBundle("actions/ActionBundle", Game.getInstance().getLocale()).getString("UseSecretPassageName");
	}

	@Override
	public String getDescription() {
		return ResourceBundle.getBundle("actions/ActionBundle", Game.getInstance().getLocale()).getString("UseSecretPassageDescription");
	}

	@Override
	public boolean canPerform(Character characterAttemptingAction) {
		// Characters can only ever access this method if they are in the room with the secret passage, so don't need to worry about that.
		// We do need to check to see if they have enough movement left
		// TODO: Add check for movmentsLeft being greater than 1
		return this.thisEndOfPassage.equals(characterAttemptingAction.getCurrentRoom()) && (!thisEndOfPassage.isBarrierRoom() || this.thisEndsSideOfPassage.equals(characterAttemptingAction.getSideOfRoom()));
	}

	@Override
	public void perform(Character characterPerformingAction) {
		if (canPerform(characterPerformingAction)) {
			characterPerformingAction.setCurrentRoom(this.otherEndOfPassage);
			characterPerformingAction.setSideOfRoom(otherEndsSideOfPassage);
		}
		else {
			// You shouldn't get here, because GameRunner should prevent this.
		}
	}

}
