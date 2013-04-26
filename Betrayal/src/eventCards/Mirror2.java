package eventCards;

import java.util.Locale;

import Game.Game;

public class Mirror2 extends EventCard {

	private Game game;
	
	public Mirror2(Locale loc) {
		super("Mirror2", loc);
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
