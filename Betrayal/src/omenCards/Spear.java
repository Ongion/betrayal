package omenCards;

import java.util.Locale;

import Game.Game;

import characters.Character;

public class Spear extends OmenCard {



	public Spear(Locale loc) {
		super("Spear", loc);
	}

	@Override
	public void whatToDo(Character character) {
		Game game = Game.getInstance();
		if(character.attack()){
			for(int i = 2; i < 3; i++){
				numRolls ++;
				game.rollDice(character.getCurrentMight());
			}
		}

	}
}
