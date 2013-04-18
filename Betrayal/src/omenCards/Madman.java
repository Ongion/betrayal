package omenCards;

import java.util.ArrayList;

import characters.ExplorerType;
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
	public void whatToDo(ExplorerType character, Game game) {
		if(!game.getIsHaunt()){
			character.incrementMight(2);
			character.decrementSanity(1);
		}
	
	}

	@Override
	public void isLost(ExplorerType character) {
		ArrayList omenHand = character.getOmenHand();
		if(!omenHand.contains(this)){
			character.decrementMight(2);
			character.incrementSanity();
		}
		
	}

}
