package eventCards;

import characters.Character.Trait;
import Game.Game;

public class LockedSafe extends EventCard {
	// TODO: Add functionality for tokens

	private Game game;
	
	public LockedSafe(String name, String description) {
		super(name, description);
		this.game = Game.getInstance();
	}
	
	@Override
	public void happen(int rollResult) {
		if(rollResult >= 5){
			game.getCurrentCharacter().addItemCard(game.drawItem());
			game.getCurrentCharacter().addItemCard(game.drawItem());
			// TODO: Remove safe token
		} else if (rollResult >= 2 && rollResult <= 4){
			game.getCurrentCharacter().decrementSpeed(); // TODO: Change this to decrementphysical
		} else {
			game.getCurrentCharacter().decrementSpeed(2); // TODO: Change this to decrementPhysical
		}

	}

	@Override
	public void happens() {
		int rollResult = game.typeRoll(Trait.KNOWLEDGE);
		if(rollResult >= 5){
			game.getCurrentCharacter().addItemCard(game.drawItem());
			game.getCurrentCharacter().addItemCard(game.drawItem());
			// TODO: Remove safe token
		} else if (rollResult >= 2 && rollResult <= 4){
			game.getCurrentCharacter().decrementSpeed(game.rollDice(1)); // TODO: Change this to decrementphysical
		} else {
			game.getCurrentCharacter().decrementSpeed(game.rollDice(2)); // TODO: Change this to decrementPhysical
		}
	}

}