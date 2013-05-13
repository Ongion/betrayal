package eventCards;

import java.util.Locale;

import characters.Character;
import Game.Game;

public class ClosetDoor extends EventCard {

	public ClosetDoor(Locale loc) {
		super("ClosetDoor", loc);
	}
	
	@Override
	public void happen(int rollResult) {
		if (rollResult == 4){
			Game.getInstance().getCurrentCharacter().addItemCard(Game.getInstance().drawItem());
		} else if (rollResult == 1 || rollResult == 2){
			Game.getInstance().getCurrentCharacter().addEventCard(Game.getInstance().drawEvent()); // TODO: Change this so the event happens instead of adding the card to hand
		} else {
			Game.getInstance().getCurrentCharacter().addEventCard(Game.getInstance().drawEvent()); // TODO: Change this so the event happens instead of adding the card to hand
			// TODO: Remove Closet token
		}

	}

	@Override
	public void happens() {
		Character character = Game.getInstance().getCurrentCharacter();
		// TODO: Place Closet token
		int rollResult = Game.getInstance().rollDice(2);
		if (rollResult == 4){
			character.addItemCard(Game.getInstance().drawItem());
		} else if (rollResult == 1 || rollResult == 2){
			Game.getInstance().drawEvent().happens(); 
		} else {
			Game.getInstance().drawEvent().happens(); 
			// TODO: Remove Closet token
		}
	}

}
