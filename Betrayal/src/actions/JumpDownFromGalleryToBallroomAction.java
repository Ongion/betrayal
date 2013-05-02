package actions;

import java.util.ResourceBundle;

import rooms.RoomName;

import Game.Game;
import characters.Character;

public class JumpDownFromGalleryToBallroomAction implements IAction {

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

}
