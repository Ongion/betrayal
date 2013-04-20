package characters;

import java.util.Locale;
import java.util.ResourceBundle;
import characters.Character;
import rooms.Room;
import rooms.Room.Relative_Direction;

import characters.Character.Character_Name;

public class ExplorerType implements ICharacterType {
	private Character characterTypeBelongsTo;
		
	public ExplorerType(){}

	@Override
	public void enterRoomGoingInAbsoluteDirection(Room nextRoom, Relative_Direction directionMovingWhenEnteringRoom) {
		this.characterTypeBelongsTo.setCurrentRoom(nextRoom);
			
		nextRoom.enterRoomGoingInAbsoluteDirection(this.characterTypeBelongsTo, directionMovingWhenEnteringRoom);
	}

	@Override
	public void setCharacter(Character character) {
		this.characterTypeBelongsTo = character;		
	}


}