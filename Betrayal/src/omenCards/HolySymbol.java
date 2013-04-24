package omenCards;

import java.util.ArrayList;

import characters.Explorer;
import Game.Game;

public class HolySymbol extends OmenCard {

	public HolySymbol(String name, String quote) {
		super(name, quote);

	}

	@Override
	public void whatToDo(Explorer character) {
		Game game = Game.getInstance();
		if (!game.getIsHaunt() == true) {
			character.incrementSanity(2);
		}

	}

	public void isLost(Explorer character) {
		ArrayList omenHand = character.getOmenHand();
		if (!omenHand.contains(this)) {
			character.decrementSanity(2);
		}

	}

}
