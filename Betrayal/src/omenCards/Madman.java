package omenCards;

import java.util.ArrayList;

import characters.Explorer;
import Game.Game;

public class Madman extends OmenCard {

	public Madman(String name, String quote) {
		super(name, quote);

	}

	@Override
	public void whatToDo(Explorer character) {
		Game game = Game.getInstance();
		if (!game.getIsHaunt()) {
			character.incrementMight(2);
			character.decrementSanity(1);
		}

	}

	public void isLost(Explorer character) {
		ArrayList omenHand = character.getOmenHand();
		if (!omenHand.contains(this)) {
			character.decrementMight(2);
			character.incrementSanity();
		}

	}

}
