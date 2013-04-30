package omenCards;

import java.util.Locale;

import characters.ExplorerType;
import characters.Character;
import Game.Game;

public class Bite extends OmenCard {

	public Bite(Locale loc) {
		super("Bite", loc);

	}

	@Override
	public void whatToDo(Character character) {
		Game game = Game.getInstance();
		if (game.rollDice(character.getCurrentMight()) < 4) {
			character.decrementMight();

		}
	}

}
