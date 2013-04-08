package eventCards;

import Game.Game;

public class AngryBeing extends EventCard {
	// This is only for testing purposes and will be removed
	private Game game;
	
	public AngryBeing(String name, String description, Game game) {
		super(name, description);
		this.game = game;
	}

	@Override
	public void happen(int rollResult) {
		// For testing purposes only
		if (rollResult >= 5){
			game.getCurrentCharacter().incrementSpeed();
		} else if ((rollResult >= 2) && (rollResult <= 4)){
			game.getCurrentCharacter().decrementKnowledge(); // TODO: Change this to decrementMental when implemented
		} else{
			game.getCurrentCharacter().decrementKnowledge(); // TODO: Change this to decrementMental
			game.getCurrentCharacter().decrementMight(); // TODO: Change this to decrementPhysical
		}
	}

	@Override
	public void happens() {
		int rollResult = game.rollDie(game.getCurrentCharacter().getCurrentSpeed());
		if (rollResult >= 5){
			game.getCurrentCharacter().incrementSpeed();
		} else if ((rollResult >= 2) && (rollResult <= 4)){
			game.getCurrentCharacter().decrementKnowledge(game.rollDie(1)); // TODO: Change this to decrementMental when implemented
		} else{
			game.getCurrentCharacter().decrementKnowledge(game.rollDie(1)); // TODO: Change this to decrementMental
			game.getCurrentCharacter().decrementMight(game.rollDie(1)); // TODO: Change this to decrementPhysical
		}
	}

}
