package omenCards;

import characters.Explorer;
import Game.Game;

public class Bite extends OmenCard {

	public Bite(String name, String quote) {
		super(name, quote);

	}

	@Override
	public void whatToDo(Explorer character, Game game) {
		if (game.rollDice(character.getCurrentMight()) < 4) {
			character.decrementMight();

		}
	}

}
