package eventCards;

import Game.Game;

public class SomethingSlimy extends EventCard {

	private Game game;
	
	public SomethingSlimy(String name, String description) {
		super(name, description);
		this.game = Game.getInstance();
	}

	@Override
	public void happen(int rollResult) {
		// For testing purposes only
		if (rollResult >= 4){
			game.getCurrentCharacter().incrementSpeed();
		} else if (rollResult >= 1 && rollResult <= 3){
			game.getCurrentCharacter().decrementMight();
		} else{
			game.getCurrentCharacter().decrementMight();
			game.getCurrentCharacter().decrementSpeed();
		}
	}

	@Override
	public void happens() {
		int rollResult = game.rollDice(game.getCurrentCharacter().getCurrentSanity());
		if (rollResult >= 4){
			game.getCurrentCharacter().incrementSpeed();
		} else if (rollResult >= 1 && rollResult <= 3){
			game.getCurrentCharacter().decrementMight();
		} else{
			game.getCurrentCharacter().decrementMight();
			game.getCurrentCharacter().decrementSpeed();
		}
	}

}
