package eventCards;

import Game.Game;

public class CreepyCrawlies extends EventCard {
	// This is only for testing purposes and will be removed
	private Game game;
	
	public CreepyCrawlies(String name, String description, Game game) {
		super(name, description);
		this.game = game;
	}

	@Override
	public void happen(int rollResult) {
		// For testing purposes only
		if (rollResult >= 5){
			game.getCurrentCharacter().incrementSanity();
		} else if (rollResult >= 1 && rollResult <= 4){
			game.getCurrentCharacter().decrementSanity();
		} else{
			game.getCurrentCharacter().decrementSanity(2);
		}
	}

	@Override
	public void happens() {
		int rollResult = game.rollDice(game.getCurrentCharacter().getCurrentSanity());
		if (rollResult >= 5){
			game.getCurrentCharacter().incrementSanity();
		} else if ((rollResult >= 1) && (rollResult <= 4)){
			game.getCurrentCharacter().decrementSanity();
		} else{
			game.getCurrentCharacter().decrementSanity(2);
		}
	}
}
