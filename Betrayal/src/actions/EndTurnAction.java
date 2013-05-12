package actions;

import characters.Character;

public class EndTurnAction extends Action {

	@Override
	public String getName() {
		// TODO Localize
		return "End Turn";
	}

	@Override
	public String getDescription() {
		// TODO Localize
		return "End Turn";
	}

	@Override
	public boolean canPerform(Character characterAttemptingAction) {
		// TODO Some kind of checking. Most likely just if it's the current character
		return true;
	}

	@Override
	public void perform(Character characterPerformingAction) {
		characterPerformingAction.endMovement();
	}

}
