package eventCards;

import Game.Game;

public class PhoneCall extends EventCard {

	// This is only for testing purposes and will be removed
	private Game game;
	
	public PhoneCall(String name, String description, Game game) {
		super(name, description);
		this.game = game;
	}

	@Override
	public void happen(int rollResult) {
		// For testing purposes only
		if(rollResult == 4){
			game.getCurrentPlayer().getCharacter().incrementSanity();
		} else if (rollResult == 3){
			game.getCurrentPlayer().getCharacter().incrementKnowledge();
		} else if (rollResult >= 1 && rollResult <=2){
			game.getCurrentPlayer().getCharacter().decrementKnowledge(); // TODO: change this to decrementMental
		} else if( rollResult == 0){
			game.getCurrentPlayer().getCharacter().decrementMight(2); // TODO: change this to decrementPhysical
		}
	}

	@Override
	public void happens() {
		int rollResult = game.rollDie(2);
		if(rollResult == 4){
			game.getCurrentPlayer().getCharacter().incrementSanity();
		} else if (rollResult == 3){
			game.getCurrentPlayer().getCharacter().incrementKnowledge();
		} else if (rollResult >= 1 && rollResult <=2){
			game.getCurrentPlayer().getCharacter().decrementKnowledge(game.rollDie(1)); // TODO: change this to decrementMental
		} else if( rollResult == 0){
			game.getCurrentPlayer().getCharacter().decrementMight(game.rollDie(2)); // TODO: change this to decrementPhysical
		}
	}

}
