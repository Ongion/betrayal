package characters;

import rooms.Room;
import rooms.Room.Relative_Direction;
import characters.Character;;

public class MonsterType implements ICharacterType {
	private Character characterTypeBelongsTo;
	
	public MonsterType(){}
	

	@Override
	public void enterRoomGoingInAbsoluteDirection(Room nextRoom, Relative_Direction directionMovingWhenEnteringRoom) {
		this.characterTypeBelongsTo.setCurrentRoom(nextRoom);
		
		nextRoom.enterRoomGoingInAbsoluteDirection(this.characterTypeBelongsTo, directionMovingWhenEnteringRoom);
		
	}

	@Override
	public void setCharacter(Character character) {
		this.characterTypeBelongsTo = character;
	}


	@Override
	public int getTraitRoll(Trait traitBeingRolledFor) {
		return this.characterTypeBelongsTo.getTrait(traitBeingRolledFor);
	}

	@Override
	public boolean isAffectedByBlessing() {
		return false;
	}

	@Override
	public boolean isAffectedByDrip() {
		return false;
	}

	@Override
	public boolean isAffectedBySmoke() {
		return false;
	}
}
