package eventCards;

import java.util.Locale;

import Game.Game;

public class Debris extends EventCard {
	// TODO: Add methods to handle when card is kept and attempts to break free

	private Game game;
	
	public Debris(Locale loc) {
		super("Debris", loc);
		this.game = Game.getInstance();
	}

	@Override
	public void happen(int rollResult) {
		// For testing purposes only
		if (rollResult >= 3 ){
			game.getCurrentCharacter().incrementSpeed();
		} else if (rollResult < 3 && rollResult > 0){
			game.getCurrentCharacter().decrementMight(); // TODO: Change this to decrement physical damage
		} else {
			game.getCurrentCharacter().decrementMight(2); // TODO: Change this to decrement physical damage
			game.getCurrentCharacter().addEventCard(this);
		}
	}

	@Override
	public void happens() {
		int rollResult = game.rollDice(game.getCurrentCharacter().getCurrentSpeed());
		if (rollResult >= 3 ){
			game.getCurrentCharacter().incrementSpeed();
		} else if (rollResult < 3 && rollResult > 0){
			game.getCurrentCharacter().decrementMight(); // TODO: Change this to decrement physical damage
		} else {
			game.getCurrentCharacter().decrementMight(2); // TODO: Change this to decrement physical damage
			game.getCurrentCharacter().addEventCard(this);
		}
	}

}
