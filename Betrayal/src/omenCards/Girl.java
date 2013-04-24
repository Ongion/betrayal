package omenCards;

import java.util.ArrayList;

import characters.Explorer;
import Game.Game;

public class Girl extends OmenCard {

	public Girl(String name, String quote) {
		super(name, quote);

	}

	@Override
	public void whatToDo(Explorer character) {
		Game game = Game.getInstance();
		if (!game.getIsHaunt() == true) {
			character.incrementSanity(1);
			character.incrementKnowledge(1);

		}

	}

	public void isLost(Explorer character) {

		ArrayList omenHand = character.getOmenHand();

		if (!omenHand.contains(this)) {
			character.decrementKnowledge();
			character.decrementSanity();
		}

	}
}
