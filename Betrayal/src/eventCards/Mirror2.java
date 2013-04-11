package eventCards;

import Game.Game;

public class Mirror2 extends EventCard {

	private Game game;
	
	public Mirror2(String name, String description) {
		super(name, description);
		this.game = Game.getInstance();
	}

	@Override
	public void happen(int rollResult) {
		// For testing purposes only
		game.getCurrentCharacter().addItemCard(game.drawItem());
	}

	@Override
	public void happens() {
		game.getCurrentCharacter().addItemCard(game.drawItem());
	}

}
