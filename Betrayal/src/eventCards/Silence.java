package eventCards;

import Game.Game;

public class Silence extends EventCard {

	// This is only for testing purposes and will be removed
	private Game game;
	
	public Silence(String name, String description, Game game) {
		super(name, description);
		this.game = game;
	}

	@Override
	public void happen(int rollResult) {
		// For testing purposes only
		// Change this so it has an affect on every player in the basement
		if((rollResult > 0) && (rollResult < 4)){
			game.getCurrentPlayer().getCharacter().decrementKnowledge(); // TODO: Change this to decrementMental when implemented
		} else if (rollResult == 0){
			game.getCurrentPlayer().getCharacter().decrementKnowledge(2); // TODO: Change this to decrementMental
		}
	}

	@Override
	public void happens() {
		// Change this so it has an affect on every player in the basement
		int rollResult = game.rollDie(game.getCurrentPlayer().getCharacter().getCurrentSanity());
		if((rollResult > 0) && (rollResult < 4)){
			game.getCurrentPlayer().getCharacter().decrementKnowledge(game.rollDie(1)); // TODO: Change this to decrementMental when implemented
		} else if (rollResult == 0){
			game.getCurrentPlayer().getCharacter().decrementKnowledge(game.rollDie(2)); // TODO: Change this to decrementMental
		}
	}

}
