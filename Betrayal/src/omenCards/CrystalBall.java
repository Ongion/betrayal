package omenCards;

import java.util.Collections;

import characters.Explorer;
import Game.Game;

public class CrystalBall extends OmenCard {

	private int itemOrEvent;

	public CrystalBall(String name, String quote) {
		super(name, quote);

	}

	@Override
	public void whatToDo(Explorer character) {
		Game game = Game.getInstance();
		int rollResult = game.rollDice(character.getCurrentKnowledge());
		if (rollResult < 4 && rollResult > 0) {
			character.decrementSanity();
		}
		if (rollResult == 0) {
			character.decrementSanity(2);
		}
		if (rollResult > 4) {
			if (itemOrEvent == 1) {
				Collections.shuffle(game.getEventDeck());
			}
			if (itemOrEvent == 0) {
				Collections.shuffle(game.getItemDeck());
			}
		}

	}

}
