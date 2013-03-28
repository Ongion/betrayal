package eventCards;

import Game.Game;
import characters.Character;

public class SomethingSlimy extends EventCard {

	// This is only for testing purposes and will be removed
	private Game game;
	
	public SomethingSlimy(String name, String description, Game game) {
		super(name, description);
		this.game = game;
	}

	@Override
	public void happen(int rollResult) {
		// For testing purposes only
		if (rollResult >= 4){
			game.getCurrentPlayer().getCharacter().incrementSpeed();
		} else if (rollResult >= 1 && rollResult <= 3){
			game.getCurrentPlayer().getCharacter().decrementMight();
		} else{
			game.getCurrentPlayer().getCharacter().decrementMight();
			game.getCurrentPlayer().getCharacter().decrementSpeed();
		}
	}

	@Override
	public void happens() {
		int rollResult = game.rollDie(game.getCurrentPlayer().getCharacter().getCurrentSanity());
		if (rollResult >= 4){
			game.getCurrentPlayer().getCharacter().incrementSpeed();
		} else if (rollResult >= 1 && rollResult <= 3){
			game.getCurrentPlayer().getCharacter().decrementMight();
		} else{
			game.getCurrentPlayer().getCharacter().decrementMight();
			game.getCurrentPlayer().getCharacter().decrementSpeed();
		}
	}

}
