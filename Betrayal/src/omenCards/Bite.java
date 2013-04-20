package omenCards;

import characters.ExplorerType;
import characters.Character;
import Game.Game;

public class Bite extends OmenCard {

	public Bite(String name, String quote) {
		super(name, quote);

	}

	@Override
		
	public void whatToDo(Character character, Game game) {
		if (game.rollDice(character.getCurrentMight()) < 4) {
			character.decrementMight();

		}
	}

}
