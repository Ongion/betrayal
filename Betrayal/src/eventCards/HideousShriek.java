package eventCards;

import characters.Explorer.Trait;
import Game.Game;

public class HideousShriek extends EventCard {

	private Game game;
	
	public HideousShriek(String name, String description) {
		super(name, description);
		this.game = Game.getInstance();
	}
	
	@Override
	public void happen(int rollResult) {
		if (rollResult >= 1 && rollResult <= 3){
			game.getCurrentCharacter().decrementSanity(); // TODO: Change this to decrementMental
		} else if(rollResult == 0){
			game.getCurrentCharacter().decrementSanity(2); // TODO: Change this to decrementMental
		}

	}

	@Override
	public void happens() {
		int rollResult = game.typeRoll(Trait.SANITY);
		if (rollResult >= 1 && rollResult <= 3){
			game.getCurrentCharacter().decrementSanity(game.rollDice(1)); // TODO: Change this to decrementMental
		} else if(rollResult == 0){
			game.getCurrentCharacter().decrementSanity(game.rollDice(2)); // TODO: Change this to decrementMental
		}
	}

}
