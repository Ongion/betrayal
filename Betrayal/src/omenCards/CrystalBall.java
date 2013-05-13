package omenCards;

import itemCards.ItemCard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

import Game.Game;
import characters.Character;
import eventCards.EventCard;

public class CrystalBall extends OmenCard {

	private int itemOrEvent;

	public CrystalBall(Locale loc) {
		super("CrystalBall", loc);

	}

	@Override
	public void whatToDo(Character character) {
		Game game = Game.getInstance();
		int rollResult = game.rollDice(character.getCurrentKnowledge());
		if (rollResult < 4 && rollResult > 0) {
			character.decrementSanity();
		}
		if (rollResult == 0) {
			character.decrementSanity(2);
		}
		if (rollResult >= 4) {
			ArrayList<EventCard> eventDeckChosen = game.getEventDeck();

			if (itemOrEvent == 0) {
				Collections.shuffle(eventDeckChosen);
			}
			else if (itemOrEvent == 1) {
				ArrayList<ItemCard> itemDeckChosen = game.getItemDeck();

				Collections.shuffle(itemDeckChosen);
			}
		}
	}

}
