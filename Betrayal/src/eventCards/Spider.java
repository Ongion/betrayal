package eventCards;

import Game.Game;

public class Spider extends EventCard {

	private Game game;
	
	public Spider(String name, String description) {
		super(name, description);
		this.game = Game.getInstance();
	}
	
	@Override
	public void happen(int rollResult) {
		if(rollResult >= 4){
			game.getCurrentCharacter().incrementSpeed(); // TODO: changes this to allow the user to choose either sooeed or sanity
		} else if (rollResult >= 1 && rollResult <=3){
			game.getCurrentCharacter().decrementSpeed(); // TODO: change this to decrementPhysical
		} else if(rollResult == 0){
			game.getCurrentCharacter().decrementSpeed(2); // TODO: change this to decrementPhysical
		}

	}

	@Override
	public void happens() {
		int rollResult = game.rollDice(game.getCurrentCharacter().getCurrentSpeed()); // TODO: change to allow user to choose either speed or sanity
		if(rollResult >= 4){
			game.getCurrentCharacter().incrementSpeed(); // TODO: changes this to allow the user to choose either speed or sanity
		} else if (rollResult >= 1 && rollResult <=3){
			game.getCurrentCharacter().decrementSpeed(game.rollDice(1)); // TODO: change this to decrementPhysical
		} else if( rollResult == 0){
			game.getCurrentCharacter().decrementSpeed(game.rollDice(2)); // TODO: change this to decrementPhysical
		}
	}

}
