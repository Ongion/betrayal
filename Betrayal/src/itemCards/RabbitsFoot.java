package itemCards;

import java.util.Locale;

import Game.Game;

import characters.Character;

public class RabbitsFoot extends ItemCard {

	public RabbitsFoot(Locale loc) {
		super("RabbitsFoot", loc);
		
	}

	@Override
	public
	void whatToDo(Character character) {
		Game.getInstance().rollDice(1);
		
	}

}
