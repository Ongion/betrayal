package eventCards;

import Game.Game;

public class SomethingHidden extends EventCard {

	private Game game;
	
	public SomethingHidden(String name, String description) {
		super(name, description);
		this.game = Game.getInstance();
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
