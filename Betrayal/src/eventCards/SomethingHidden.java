package eventCards;

import java.util.Locale;

import Game.Game;

public class SomethingHidden extends EventCard {

	private Game game;
	
	public SomethingHidden(Locale loc) {
		super("SomethingHidden", loc);
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
