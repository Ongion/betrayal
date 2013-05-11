package actions;

import java.util.ResourceBundle;

import rooms.RoomName;

import Game.Game;
import characters.Character;
import characters.Trait;

public class JumpDownFromGalleryToBallroomAction extends Action {

	public JumpDownFromGalleryToBallroomAction() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canPerform(Character characterAttemptingAction) {
		return (Game.getInstance().getRoomByRoomName(RoomName.BALLROOM) != null && Game.getInstance().getRoomByRoomName(RoomName.GALLERY) != null && Game.getInstance().getRoomByRoomName(RoomName.GALLERY).equals(characterAttemptingAction.getCurrentRoom()));
	}

	@Override
	public void perform(Character characterPerformingAction) {
		if (canPerform(characterPerformingAction)) {
			characterPerformingAction.setCurrentRoom(Game.getInstance().getRoomByRoomName(RoomName.BALLROOM));
			// TODO: Character needs to take physical damage from this.
			Trait chosenTrait = Game.getInstance().chooseAPhysicalTrait();
			int damage = 1;
			characterPerformingAction.decrementTrait(chosenTrait, damage);
			return;
		} else {
			// Theoretically, GameRunner should check canPerform before allowing characters to perform actions, so you shouldn't get here anyway.
		}
	}

	@Override
	public String getName() {
		return ResourceBundle.getBundle("actions/ActionBundle", Game.getInstance().getLocale()).getString("JumpDownFromGalleryToBallroomName");
	}

	@Override
	public String getDescription() {
		return ResourceBundle.getBundle("actions/ActionBundle", Game.getInstance().getLocale()).getString("JumpDownFromGalleryToBallroomDescription");
	}
	
	@Override
	public boolean equals(Object other) {
		return other instanceof JumpDownFromGalleryToBallroomAction;
	}
	
	@Override
	public int hashCode() {
		// All of these actions are identical to one another
		return 78345895;
	}

}
