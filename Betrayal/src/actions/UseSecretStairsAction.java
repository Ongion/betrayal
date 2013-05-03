package actions;

import java.util.ResourceBundle;

import Game.Game;
import rooms.Room;
import rooms.Room.Relative_Direction;
import characters.Character;

public class UseSecretStairsAction implements IAction {
	private Room thisEndOfStairs;
	private Room otherEndOfStairs;
	private Relative_Direction thisEndsSideOfRoom;
	private Relative_Direction otherEndsSideOfRoom;

	public UseSecretStairsAction(Room thisEndOfStairs, Room otherEndOfStairs, Relative_Direction thisEndsSideOfRoom, Relative_Direction otherEndsSideOfRoom) {
		this.thisEndOfStairs = thisEndOfStairs;
		this.otherEndOfStairs = otherEndOfStairs;
		this.thisEndsSideOfRoom = thisEndsSideOfRoom;
		this.otherEndsSideOfRoom = otherEndsSideOfRoom;
	}

	@Override
	public String getName() {
		return ResourceBundle.getBundle("actions/ActionBundle", Game.getInstance().getLocale()).getString("UseSecretStairsName");
	}

	@Override
	public String getDescription() {
		return ResourceBundle.getBundle("actions/ActionBundle", Game.getInstance().getLocale()).getString("UseSecretStairsDescription");
	}

	public Room getThisEndOfStairs() {
		return thisEndOfStairs;
	}

	public Room getOtherEndOfStairs() {
		return otherEndOfStairs;
	}

	public Relative_Direction getThisEndsSideOfRoom() {
		return thisEndsSideOfRoom;
	}

	public Relative_Direction getOtherEndsSideOfRoom() {
		return otherEndsSideOfRoom;
	}

	@Override
	public boolean canPerform(Character characterAttemptingAction) {
		// Characters can only ever access this method if they are in the room with the secret stairs, so don't need to worry about that.
		// We do need to check to see if they have enough movement left
		// TODO: Add check for movmentsLeft being greater than 1
		return this.thisEndOfStairs.equals(characterAttemptingAction.getCurrentRoom()) && (!thisEndOfStairs.isBarrierRoom() || this.thisEndsSideOfRoom.equals(characterAttemptingAction.getSideOfRoom()));
	}

	@Override
	public void perform(Character characterPerformingAction) {
		if (canPerform(characterPerformingAction)) {
			characterPerformingAction.setCurrentRoom(this.otherEndOfStairs);
			characterPerformingAction.setSideOfRoom(otherEndsSideOfRoom);
		}
		else {
			// You shouldn't get here, because GameRunner should prevent this.
		}
	}
	
	@Override
	public boolean equals(Object other) {
		if (!(other instanceof UseSecretStairsAction)) {
			return false;
		}
		UseSecretStairsAction otherStairs = (UseSecretStairsAction) other;
		return this.thisEndOfStairs == otherStairs.getThisEndOfStairs() && this.thisEndsSideOfRoom == otherStairs.getThisEndsSideOfRoom() && this.otherEndOfStairs == otherStairs.getOtherEndOfStairs() && this.otherEndsSideOfRoom == otherStairs.getOtherEndsSideOfRoom();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int hash = 15457;
		hash = prime * hash + thisEndOfStairs.hashCode();
		hash = prime * hash + thisEndsSideOfRoom.hashCode();
		hash = prime * hash + otherEndOfStairs.hashCode();
		hash = prime * hash + otherEndsSideOfRoom.hashCode();
		return hash;
	}
}
