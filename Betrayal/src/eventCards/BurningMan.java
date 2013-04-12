package eventCards;

import characters.Character.Trait;
import Game.Game;

public class BurningMan extends EventCard {

	private Game game;
	
	public BurningMan(String name, String description) {
		super(name, description);
		this.game = Game.getInstance();
	}
	@Override
	public void happen(int rollResult) {
		if(rollResult >= 4){
			game.getCurrentCharacter().incrementSanity();
		} else if (rollResult >=2 && rollResult <= 3){
			// TODO: put explorer in the entrance hall
		} else {
			game.getCurrentCharacter().decrementSanity(); // TODO: Change this to decrementMental
			game.getCurrentCharacter().decrementMight(); // TODO: Change this to decrementPhysical
		}

	}

	@Override
	public void happens() {
		int rollResult = game.typeRoll(Trait.SANITY);
		if(rollResult >= 4){
			game.getCurrentCharacter().incrementSanity();
		} else if (rollResult >=2 && rollResult <= 3){
			// TODO: put explorer in the entrance hall
		} else {
			game.getCurrentCharacter().decrementSanity(); // TODO: Change this to decrementMental
			game.getCurrentCharacter().decrementMight(); // TODO: Change this to decrementPhysical
		}

	}

}