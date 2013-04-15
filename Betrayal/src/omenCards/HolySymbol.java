package omenCards;

import characters.Explorer;
import Game.Game;

public class HolySymbol extends OmenCard {

	public HolySymbol(String name, String quote) {
		super(name, quote);

	}

	@Override
	public Object whatToDo() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void whatToDo(Explorer character, Game game) {
		if(!game.getIsHaunt()==true){
			character.decrementSanity(2);
		}
		
	}

}
