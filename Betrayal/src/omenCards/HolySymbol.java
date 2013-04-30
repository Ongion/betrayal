package omenCards;

import java.util.ArrayList;
import java.util.Locale;

import characters.Character;

import characters.ExplorerType;
import Game.Game;

public class HolySymbol extends OmenCard {

	public HolySymbol(Locale loc) {
		super("HolySymbol", loc);

	}

	@Override
	public void whatToDo(Character character) {
		Game game = Game.getInstance();
		if (!game.getIsHaunt() == true) {
			character.incrementSanity(2);
		}

	}

	public void isLost(Character character) {
		ArrayList omenHand = character.getOmenHand();
		if (!omenHand.contains(this)) {
			character.decrementSanity(2);
		}

	}

}
