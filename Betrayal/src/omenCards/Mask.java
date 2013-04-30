package omenCards;

import java.util.Locale;

import Game.Game;
import characters.Character;
import characters.ExplorerType;

public class Mask extends OmenCard {

	public boolean isMaskOn;

	public Mask(Locale loc) {
		super("Mask", loc);
	}

	@Override
	public void whatToDo(Character character) {
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
