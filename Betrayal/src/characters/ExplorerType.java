package characters;

import actions.Action;
import rooms.Room;
import rooms.Room.Relative_Direction;
import Game.Game;

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

	@Override
	public int getTraitRoll(Trait traitBeingRolledFor) {
		return Game.getInstance().rollDice(this.characterTypeBelongsTo.getTrait(traitBeingRolledFor) + this.characterTypeBelongsTo.currentRoom.getTraitRollModifier(this.characterTypeBelongsTo));
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
		return Game.getInstance().chooseAnAction(this.characterTypeBelongsTo);
	}

}