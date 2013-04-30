package omenCards;

import java.util.ArrayList;
import java.util.Locale;

import characters.Character;
import characters.ExplorerType;
import Game.Game;

public class Dog extends OmenCard {
	private boolean hasToken;

	public Dog(Locale loc) {
		super("Dog", loc);

	}

	@Override
	public void whatToDo(Character character) {
		Game game = Game.getInstance();
	
		if (!game.getIsHaunt()) {
			character.incrementMight();
			character.incrementSanity();
		}

	}

	public void isLost(Character character) {
		ArrayList<OmenCard> omenHand = character.getOmenHand();
		if (!omenHand.contains(this)) {
			character.decrementMight();
			character.decrementSanity();
		}

	}

}
