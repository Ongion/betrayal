package omenCards;

import java.util.Locale;

import Game.Game;


import characters.Character;

public class SpiritBoard extends OmenCard {

	public SpiritBoard(Locale loc) {
		super("SpiritBoard", loc);
	}

	@Override
	public void whatToDo(Character character) {
		Game.getInstance().peekRoom();
	}

}
