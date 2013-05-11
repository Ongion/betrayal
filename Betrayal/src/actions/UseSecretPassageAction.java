package actions;

import java.util.ResourceBundle;

import Game.Game;
import rooms.Room;
import rooms.Room.Relative_Direction;
import characters.Character;

public class UseSecretPassageAction extends Action {
	private Room thisEndOfPassage;
	private Room otherEndOfPassage;
	private Relative_Direction thisEndsSideOfRoom;
	private Relative_Direction otherEndsSideOfRoom;
	
	public UseSecretPassageAction(Room thisEndOfPassage, Room otherEndOfPassage, Relative_Direction thisEndsSideOfRoom, Relative_Direction otherEndsSideOfRoom) {
		this.thisEndOfPassage = thisEndOfPassage;
		this.otherEndOfPassage = otherEndOfPassage;
		this.thisEndsSideOfRoom = thisEndsSideOfRoom;
		this.otherEndsSideOfRoom = otherEndsSideOfRoom;
	}

	@Override
	public String getName() {
		return ResourceBundle.getBundle("actions/ActionBundle", Game.getInstance().getLocale()).getString("UseSecretPassageName");
	}

	@Override
	public String getDescription() {
		return ResourceBundle.getBundle("actions/ActionBundle", Game.getInstance().getLocale()).getString("UseSecretPassageDescription");
	}

	public Room getThisEndOfPassage() {
		return thisEndOfPassage;
	}

	public Room getOtherEndOfPassage() {
		return otherEndOfPassage;
	}

	public Relative_Direction getThisEndsSideOfRoom() {
		return thisEndsSideOfRoom;
	}

	public Relative_Direction getOtherEndsSideOfRoom() {
		return otherEndsSideOfRoom;
	}

	@Override
	public boolean canPerform(Character characterAttemptingAction) {
		// Characters can only ever access this method if they are in the room with the secret passage, so don't need to worry about that.
		// We do need to check to see if they have enough movement left
		// TODO: Add check for movmentsLeft being greater than 1
		return this.thisEndOfPassage.equals(characterAttemptingAction.getCurrentRoom()) && (!thisEndOfPassage.isBarrierRoom() || this.thisEndsSideOfRoom.equals(characterAttemptingAction.getSideOfRoom()));
	}

	@Override
	public void perform(Character characterPerformingAction) {
		if (canPerform(characterPerformingAction)) {
			characterPerformingAction.setCurrentRoom(this.otherEndOfPassage);
			characterPerformingAction.setSideOfRoom(otherEndsSideOfRoom);
		}
		else {
			// You shouldn't get here, because GameRunner should prevent this.
		}
	}
	
	@Override
	public boolean equals(Object other) {
		if (!(other instanceof UseSecretPassageAction)) {
			return false;
		}
		UseSecretPassageAction otherPassage = (UseSecretPassageAction) other;
		return this.thisEndOfPassage == otherPassage.getThisEndOfPassage() && this.thisEndsSideOfRoom == otherPassage.getThisEndsSideOfRoom() && this.otherEndOfPassage == otherPassage.getOtherEndOfPassage() && this.otherEndsSideOfRoom == otherPassage.getOtherEndsSideOfRoom();
	}
	
	@Override
	public int hashCode() {
		final int prime = 8191;
		int hash = 131071;
		hash = prime * hash + thisEndOfPassage.hashCode();
		hash = prime * hash + thisEndsSideOfRoom.hashCode();
		hash = prime * hash + otherEndOfPassage.hashCode();
		hash = prime * hash + otherEndsSideOfRoom.hashCode();
		return hash;
	}
}
