package characters;

import rooms.Room;
import rooms.Room.Relative_Direction;

public interface ICharacterType {

	void enterRoomGoingInAbsoluteDirection(Room nextRoom,
			Relative_Direction directionMovingWhenEnteringRoom);

	void setCharacter(Character character);

	int getTraitRoll(Trait traitBeingRolledFor);

}
