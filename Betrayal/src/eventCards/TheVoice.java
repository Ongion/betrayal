package eventCards;

import java.util.Locale;

import characters.Trait;
import Game.Game;

public class TheVoice extends EventCard {

	private Game game;
	
	public TheVoice(Locale loc) {
		super("TheVoice", loc);
		this.game = Game.getInstance();
	}

	@Override
	public void happen(int rollResult) {
		// For testing purposes only
		if (rollResult >= 4){
			game.getCurrentCharacter().addItemCard(game.drawItem());
		} 
	}

	@Override
	public void happens() {
		int rollResult = game.typeRoll(Trait.KNOWLEDGE);
		if (rollResult >= 4){
			game.getCurrentCharacter().addItemCard(game.drawItem());
		} 
	}

}
