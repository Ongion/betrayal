package eventCards;

import characters.Trait;
import Game.Game;

public class TheVoice extends EventCard {

	private Game game;
	
	public TheVoice(String name, String description) {
		super(name, description);
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
