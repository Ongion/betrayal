package omenCards;

import java.util.ArrayList;
import characters.Character;
import characters.ExplorerType;
import Game.Game;

public class Dog extends OmenCard {
	private boolean hasToken;

	public Dog(String name, String quote) {
		super(name, quote);

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
