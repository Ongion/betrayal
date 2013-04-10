package eventCards;

import Game.Game;

public class Skeletons extends EventCard {
	// TODO: Add further implementation for skeleton token

	// This is only for testing purposes and will be removed
	private Game game;
	
	public Skeletons(String name, String description, Game game) {
		super(name, description);
		this.game = game;
	}

	@Override
	public void happen(int rollResult) {
		// For testing purposes only
		if (rollResult >= 5){
			game.getCurrentCharacter().addItemCard(game.drawItem());
		} else{
			game.getCurrentCharacter().decrementSanity(); //TODO: Change this to decrementMental
		}
	}

	@Override
	public void happens() {
		int rollResult = game.rollDice(game.getCurrentCharacter().getCurrentSanity());
		if (rollResult >= 5){
			game.getCurrentCharacter().addItemCard(game.drawItem());
		} else{
			game.getCurrentCharacter().decrementSanity(game.rollDice(1)); //TODO: Change this to decrementMental
		}
	}

}
