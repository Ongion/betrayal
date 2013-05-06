package omenCards;

import java.util.Locale;

import Game.Game;
import characters.Character;

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
