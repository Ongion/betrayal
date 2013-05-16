package actions;

import java.util.ResourceBundle;

import Game.Game;
import characters.Character;

public class EndTurnAction extends Action {

	@Override
	public String getName() {
		return ResourceBundle.getBundle("actions/ActionBundle", Game.getInstance().getLocale()).getString("EndTurnName");
	}

	@Override
	public String getDescription() {
		return ResourceBundle.getBundle("actions/ActionBundle", Game.getInstance().getLocale()).getString("EndTurnDescription");
	}

	@Override
	public boolean canPerform(Character characterAttemptingAction) {
		// TODO Some kind of checking. Most likely just if it's the current character
		return true;
	}

	@Override
	public void perform(Character characterPerformingAction) {
		characterPerformingAction.endTurn();
	}

}
