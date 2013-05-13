package actions;

import cardGUI.OmenCardPicker;
import characters.Character;

public class DisplayOmenCardsAction extends Action {

	@Override
	public String getName() {
		// TODO Localize
		return "Display Omen Cards";
	}

	@Override
	public String getDescription() {
		// TODO Localize
		return "Display the Omen Cards in your hand.";
	}

	@Override
	public boolean canPerform(Character characterAttemptingAction) {
		return (!characterAttemptingAction.getOmenHand().isEmpty());
	}

	@Override
	public void perform(Character characterPerformingAction) {
		OmenCardPicker frame = new OmenCardPicker(characterPerformingAction.getOmenHand());
		
		frame.display();

	}

}
