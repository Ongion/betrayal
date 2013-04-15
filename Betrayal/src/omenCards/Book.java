package omenCards;

import java.util.ArrayList;

import characters.Explorer;
import Game.Game;

public  class Book extends OmenCard {

	//private Game game;
	
	public Book(String name, String quote) {
		super(name, quote);
		
	}

	@Override
	public Object whatToDo() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void whatToDo(Explorer character, Game game) {
		if(game.getIsHaunt()==true){
			character.incrementKnowledge(2);
		}
		
	}
		

	@Override
	public boolean isLost(Explorer character) {
		ArrayList omenHand = character.getOmenHand();
		
		return false;
	}
	



}
