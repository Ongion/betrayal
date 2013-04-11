package eventCards;

import Game.Game;

public class Skeletons extends EventCard {
	// TODO: Add further implementation for skeleton token

	private Game game;
	
	public Skeletons(String name, String description) {
		super(name, description);
		this.game = Game.getInstance();
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
