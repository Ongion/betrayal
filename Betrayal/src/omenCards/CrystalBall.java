package omenCards;

import java.util.Collections;

import characters.Explorer;
import Game.Game;

public class CrystalBall extends OmenCard {

	public CrystalBall(String name, String quote) {
		super(name, quote);

	}

	@Override
	public void whatToDo(Explorer character, Game game) {
		int rollResult = game.rollDice(character.getCurrentKnowledge());
		if (rollResult < 4 && rollResult > 0) {
			character.decrementSanity();
		}
		if (rollResult == 0) {
			character.decrementSanity(2);
		}

	}

}
