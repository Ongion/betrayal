package eventCards;

import Game.Game;
import characters.Character;

public class Mirror2 extends EventCard {

	// This is only for testing purposes and will be removed
	private Game game;
	
	public Mirror2(String name, String description, Game game) {
		super(name, description);
		this.game = game;
	}

	@Override
	public void happen(int rollResult) {
		// For testing purposes only
		game.getCurrentPlayer().addItemCard(game.drawItem());
	}

	@Override
	public void happens() {
		game.getCurrentPlayer().addItemCard(game.drawItem());
	}

}
