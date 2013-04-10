package eventCards;

import Game.Game;

public class Debris extends EventCard {
	// TODO: Add methods to handle when card is kept and attempts to break free

	// This is only for testing purposes and will be removed
	private Game game;
	
	public Debris(String name, String description, Game game) {
		super(name, description);
		this.game = game;
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
