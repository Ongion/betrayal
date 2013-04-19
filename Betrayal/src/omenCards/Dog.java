package omenCards;

import java.util.ArrayList;

import characters.Explorer;
import Game.Game;

public class Dog extends OmenCard {
	private boolean hasToken;

	public Dog(String name, String quote) {
		super(name, quote);

	}

	@Override
	public void whatToDo(Explorer character, Game game) {
	
		if (!game.getIsHaunt()) {
			character.incrementMight();
			character.incrementSanity();
		}

	}

	public void isLost(Explorer character) {
		ArrayList<OmenCard> omenHand = character.getOmenHand();
		if (!omenHand.contains(this)) {
			
			character.decrementMight();
			character.decrementSanity();
		}

	}

}
