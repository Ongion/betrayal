package eventCards;

import java.util.Locale;

import Game.Game;

public class ClosetDoor extends EventCard {
	//TODO: Add functionality to token

	private Game game;
	
	public ClosetDoor(Locale loc) {
		super("ClosetDoor", loc);
		this.game = Game.getInstance();
	}
	
	@Override
	public void happen(int rollResult) {
		if (rollResult == 4){
			game.getCurrentCharacter().addItemCard(game.drawItem());
		} else if (rollResult == 1 || rollResult == 2){
			game.getCurrentCharacter().addEventCard(game.drawEvent()); // TODO: Change this so the event happens instead of adding the card to hand
		} else {
			game.getCurrentCharacter().addEventCard(game.drawEvent()); // TODO: Change this so the event happens instead of adding the card to hand
			// TODO: Remove Closet token
		}

	}

	@Override
	public void happens() {
		int rollResult = game.rollDice(2);
		if (rollResult == 4){
			game.getCurrentCharacter().addItemCard(game.drawItem());
		} else if (rollResult == 1 || rollResult == 2){
			game.getCurrentCharacter().addEventCard(game.drawEvent()); // TODO: Change this so the event happens instead of adding the card to hand
		} else {
			game.getCurrentCharacter().addEventCard(game.drawEvent()); // TODO: Change this so the event happens instead of adding the card to hand
			// TODO: Remove Closet token
		}
	}

}
