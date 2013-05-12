package itemCards;

import java.util.Locale;

import Game.Game;

import characters.Character;

public class BloodDagger extends ItemCard {

	public BloodDagger(Locale loc) {
		super("BloodDagger", loc);
		
	}

	@Override
	public
	void whatToDo(Character character) {
		
		//if character does a might attack
		Game.getInstance().rollDice(3);
		this.numRolls+=3;
		character.decrementSpeed();
		
	}

}
