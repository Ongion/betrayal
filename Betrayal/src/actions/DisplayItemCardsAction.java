package actions;

import cardGUI.ItemCardPicker;
import characters.Character;

public class DisplayItemCardsAction extends Action {

	@Override
	public String getName() {
		// TODO Localize
		return "Display Item Cards";
	}

	@Override
	public String getDescription() {
		// TODO Localize
		return "Display the Item Cards in your hand.";
	}

	@Override
	public boolean canPerform(Character characterAttemptingAction) {
		return (!characterAttemptingAction.getItemHand().isEmpty());
	}

	@Override
	public void perform(Character characterPerformingAction) {
		ItemCardPicker frame = new ItemCardPicker(characterPerformingAction.getItemHand());
		
		frame.display();

	}

}
