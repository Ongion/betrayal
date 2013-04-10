package eventCards;

import Game.Game;

public class SomethingHidden extends EventCard {

	// This is only for testing purposes and will be removed
	private Game game;
	
	public SomethingHidden(String name, String description, Game game) {
		super(name, description);
		this.game = game;
	}

	@Override
	public void happen(int rollResult) {
		// For testing purposes only
		if (rollResult >= 4){
			game.getCurrentCharacter().addItemCard(game.drawItem());
		} else {
			game.getCurrentCharacter().decrementSanity();
		}
	}

	@Override
	public void happens() {
		int rollResult = game.rollDice(game.getCurrentCharacter().getCurrentKnowledge());
		if (rollResult >= 4){
			game.getCurrentCharacter().addItemCard(game.drawItem());
		} else {
			game.getCurrentCharacter().decrementSanity();
		}
	}

}
