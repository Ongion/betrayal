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
		Game.getInstance().rollDice(2);
	}
}
