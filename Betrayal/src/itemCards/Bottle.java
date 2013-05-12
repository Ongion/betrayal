package itemCards;

import java.util.Locale;

import Game.Game;

import characters.Character;

public class Bottle extends ItemCard {

	public Bottle(Locale loc) {
		super("Bottle", loc);

	}

	@Override
	public void whatToDo(Character character) {
		Game currentGame = Game.getInstance();
		int rollResult = currentGame.rollDice(3);

		if (rollResult == 5) {
			character.incrementMight(2);
			character.incrementSpeed(2);
		}

		if (rollResult == 4) {
			character.incrementKnowledge(2);
			character.incrementKnowledge(2);
		}

		if (rollResult == 3) {
			character.incrementKnowledge();
			character.decrementMight();
		}

		if (rollResult == 2) {
			character.decrementKnowledge(2);
			character.decrementSanity(2);
		}

		if (rollResult == 1) {
			character.decrementMight(2);
			character.decrementSpeed(2);
		}

		if (rollResult == 0) {
			character.decrementKnowledge(2);
			character.decrementMight(2);
			character.decrementSanity(2);
			character.decrementSpeed(2);
		}
	}

}
