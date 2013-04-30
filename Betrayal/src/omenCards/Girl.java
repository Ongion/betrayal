package omenCards;

import java.util.ArrayList;
import java.util.Locale;

import characters.Character;
import characters.ExplorerType;
import Game.Game;

public class Girl extends OmenCard {

	public Girl(Locale loc) {
		super("Girl", loc);

	}

	@Override
	public void whatToDo(Character character) {
		Game game = Game.getInstance();
		if (!game.getIsHaunt() == true) {
			character.incrementSanity(1);
			character.incrementKnowledge(1);
		}

	}

	public void isLost(Character character) {
		ArrayList omenHand = character.getOmenHand();

		if (!omenHand.contains(this)) {
			character.decrementKnowledge();
			character.decrementSanity();
		}

	}
}
