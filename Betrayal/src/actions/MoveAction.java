package actions;

import rooms.Room.Relative_Direction;
import characters.Character;

public class MoveAction extends Action{
	private Relative_Direction absoluteMovementDirection;

	public MoveAction(Relative_Direction absoluteMovementDirection) {
		this.absoluteMovementDirection = absoluteMovementDirection;
	}

	@Override
	public String getName() {
		// TODO I18N
		return "Move " + this.absoluteMovementDirection.toString().toLowerCase();
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean canPerform(Character characterAttemptingAction) {
		return characterAttemptingAction.getCurrentRoom().getAbsoluteExits().contains(absoluteMovementDirection);
	}

	@Override
	public void perform(Character characterPerformingAction) {
		if (canPerform(characterPerformingAction)) {
			characterPerformingAction.attemptMoveInAbsoluteDirection(absoluteMovementDirection);
		}
	}

}
