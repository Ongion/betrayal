package actions;

import cardGUI.EventCardPicker;
import characters.Character;

public class DisplayEventCardsAction extends Action {

	@Override
	public String getName() {
		// TODO Localize
		return "Display Event Cards";
	}

	@Override
	public String getDescription() {
		// TODO Localize
		return "Display the Event Cards in your hand.";
	}

	@Override
	public boolean canPerform(Character characterAttemptingAction) {
		return (!characterAttemptingAction.getEventHand().isEmpty());
	}

	@Override
	public void perform(Character characterPerformingAction) {
		EventCardPicker frame = new EventCardPicker(characterPerformingAction.getEventHand());
		
		frame.display();

	}

}
