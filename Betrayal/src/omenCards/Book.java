package omenCards;

import java.util.ArrayList;

import characters.ExplorerType;
import Game.Game;

public  class Book extends OmenCard {

	
	public Book(String name, String quote) {
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
			character.incrementKnowledge(2);
		}
		
	}
		

	@Override
	public void isLost(ExplorerType character) {
		ArrayList omenHand = character.getOmenHand();
		if(!omenHand.contains(this)){
			character.decrementKnowledge(2);
			
		}
		
		
	}
	



}
