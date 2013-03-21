package omenCards;

import Game.Game;
import Game.Player;
import characters.Character;

public class Mask extends OmenCard {

	private Character currentCharacter;
	private Game currentGame;

	public Mask(String name, String quote, Character currentCharacter,
			Game currentGame) {
		super(name, quote);
		this.currentCharacter = currentCharacter;
		this.currentGame = currentGame;
	}

	@Override
	public Object whatToDo() {

		boolean canUseMask = false;
		int sanityRollNeeded = this.currentCharacter.getCurrentSanity();
		int resultOfRoll = this.currentGame.rollDie(sanityRollNeeded);

		if (resultOfRoll >= 4) {
			canUseMask = true;
			putOnMask();
			if (putOnMask() == true) {
				this.currentCharacter.incrementKnowledge(2);
				this.currentCharacter.decrementSanity(2);
			} else {
				this.currentCharacter.incrementSanity(2);
				this.currentCharacter.decrementKnowledge(2);
			}
		}
		if (resultOfRoll >= 0 && resultOfRoll <= 3) {
			canUseMask = false;

		}

		return null;
	}

	public boolean putOnMask() {

		return true;

	}

}
