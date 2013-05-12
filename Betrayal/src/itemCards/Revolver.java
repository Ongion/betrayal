package itemCards;

import java.util.Locale;

import Game.Game;

import characters.Character;

public class Revolver extends ItemCard {

	public Revolver(Locale loc) {
		super("Revolver", loc);
	
	}

	@Override
	public
	void whatToDo(Character character) {
		Game.getInstance().rollDice(1);
		
	}

}
