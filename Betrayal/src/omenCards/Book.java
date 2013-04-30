package omenCards;

import java.util.ArrayList;
import java.util.Locale;

import characters.ExplorerType;
import characters.Character;
import Game.Game;

public class Book extends OmenCard {

	public Book(Locale loc) {
		super("Book", loc);

	}

	@Override
	public void whatToDo(Character character) {
		Game game = Game.getInstance();
		if (!game.getIsHaunt()) {
			character.incrementKnowledge(2);
		}

	}

	public void isLost(Character character) {
		ArrayList omenHand = character.getOmenHand();
		if (!omenHand.contains(this)) {
			character.decrementKnowledge(2);

		}

	}

}
