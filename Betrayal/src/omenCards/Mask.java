package omenCards;

import Game.Game;
import characters.Explorer;

public class Mask extends OmenCard {

	public boolean isMaskOn;

	public Mask(String name, String quote) {
		super(name, quote);
	}

	@Override
	public void whatToDo(Explorer character) {
		Game game = Game.getInstance();
		int rollResult = game.rollDice(character.getCurrentSanity());
		if (rollResult >= 4) {
			if (isMaskOn) {
				character.incrementKnowledge(2);
				character.decrementSanity(2);
			}
			if (!isMaskOn) {
				character.decrementKnowledge(2);
				character.incrementSanity(2);
			}

		}

	}

}
