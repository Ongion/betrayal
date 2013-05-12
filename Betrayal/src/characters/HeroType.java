package characters;

import actions.Action;
import rooms.Room;
import rooms.Room.Relative_Direction;

public class HeroType implements ICharacterType {

	public HeroType() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void enterRoomGoingInAbsoluteDirection(Room nextRoom,
			Relative_Direction directionMovingWhenEnteringRoom) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setCharacter(Character character) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getTraitRoll(Trait traitBeingRolledFor) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isAffectedByBlessing() {
		return true;
	}

	@Override
	public boolean isAffectedByDrip() {
		return true;
	}

	@Override
	public boolean isAffectedBySmoke() {
		return true;
	}

	@Override
	public Action askForAction() {
		// TODO Auto-generated method stub
		return null;
	}

}
