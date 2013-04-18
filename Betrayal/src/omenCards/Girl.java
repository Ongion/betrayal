package omenCards;

import java.util.ArrayList;

import characters.ExplorerType;
import Game.Game;

public class Girl extends OmenCard {

	public Girl(String name, String quote) {
		super(name, quote);
		
	}

	@Override
	public Object whatToDo() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void whatToDo(ExplorerType character, Game game) {
		if(!game.getIsHaunt()==true){
			character.incrementSanity(1);
			character.incrementKnowledge(1);
			
		}
		
	}

	@Override
	public void isLost(ExplorerType character) {
		
		ArrayList omenHand = character.getOmenHand();
		
		if(!omenHand.contains(this)){
			character.decrementKnowledge();
			character.decrementSanity();
		}
		
	}
}
