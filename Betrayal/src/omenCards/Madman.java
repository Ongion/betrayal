package omenCards;

import characters.Explorer;
import Game.Game;

public class Madman extends OmenCard {

	public Madman(String name, String quote) {
		super(name, quote);
		
	}

	@Override
	public Object whatToDo() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int whatToDo(Explorer character, Game game) {
		if(game.getIsHaunt()==true){
			character.incrementMight(2);
			character.decrementSanity(1);
		}
		return character.getCurrentMight();
	}

}
