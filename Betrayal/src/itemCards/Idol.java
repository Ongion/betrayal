package itemCards;

import java.util.Locale;

import Game.Game;

import characters.Character;

public class Idol extends ItemCard {

	public Idol(Locale loc) {
		super("Idol", loc);
	}

	@Override
	public
	void whatToDo(Character character) {
		Game.getInstance().rollDice(2);
		character.decrementSanity();
		
	}

}
