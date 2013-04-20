package omenCards;

import java.util.ArrayList;
import characters.Character;

import characters.ExplorerType;
import Game.Game;

public class Madman extends OmenCard {

	public Madman(String name, String quote) {
		super(name, quote);

	}

	@Override
	public void whatToDo(Character character, Game game) {
		if (!game.getIsHaunt()) {
			character.incrementMight(2);
			character.decrementSanity(1);
		}

	}

	public void isLost(Character character) {
		ArrayList omenHand = character.getOmenHand();
		if (!omenHand.contains(this)) {
			character.decrementMight(2);
			character.incrementSanity();
		}

	}

}
