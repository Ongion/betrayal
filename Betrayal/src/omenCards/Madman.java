package omenCards;

import java.util.ArrayList;
import java.util.Locale;

import characters.Character;

import characters.ExplorerType;
import Game.Game;

public class Madman extends OmenCard {

	public Madman(Locale loc) {
		super("Madman", loc);

	}

	@Override
	public void whatToDo(Character character) {
		Game game = Game.getInstance();
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
