package itemCards;

import java.util.Locale;

import Game.Game;

import characters.Character;

public class Axe extends ItemCard {

	public Axe(Locale loc) {
		super("Axe", loc);

	}

	@Override
	public void whatToDo(Character character) {
		Game.getInstance().rollDice(1);

	}

}
