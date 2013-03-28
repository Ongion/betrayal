package eventCards;

import Game.Game;
import characters.Character;

public class TheVoice extends EventCard {

	// This is only for testing purposes and will be removed
	private Game game;
	
	public TheVoice(String name, String description, Game game) {
		super(name, description);
		this.game = game;
	}

	@Override
	public void happen(int rollResult) {
		// For testing purposes only
		if (rollResult >= 4){
			game.getCurrentPlayer().addItemCard(game.drawItem());
		} 
	}

	@Override
	public void happens() {
		int rollResult = game.rollDie(game.getCurrentPlayer().getCharacter().getCurrentKnowledge());
		if (rollResult >= 4){
			game.getCurrentPlayer().addItemCard(game.drawItem());
		} 
	}

}
