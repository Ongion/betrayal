package eventCards;

import java.util.Locale;

import characters.Trait;
import Game.Game;

public class BurningMan extends EventCard {

	private Game game;
	
	public BurningMan(Locale loc) {
		super("BurningMan", loc);
		this.game = Game.getInstance();
	}
	@Override
	public void happen(int rollResult) {
		if(rollResult >= 4){
			game.getCurrentCharacter().incrementSanity();
		} else if (rollResult >=2 && rollResult <= 3){
			game.getCurrentCharacter().setCurrentRoom(game.getRoomByName("Entrance Hall"));
		} else {
			game.getCurrentCharacter().decrementSanity(); // TODO: Change this to decrementMental
			game.getCurrentCharacter().decrementMight(); // TODO: Change this to decrementPhysical
		}

	}

	@Override
	public void happens() {
		int rollResult = game.getCurrentCharacter().getTraitRoll(Trait.SANITY);
		if(rollResult >= 4){
			game.getCurrentCharacter().incrementSanity();
		} else if (rollResult >=2 && rollResult <= 3){
			game.getCurrentCharacter().setCurrentRoom(game.getRoomByName("Entrance Hall"));
		} else {
			game.getCurrentCharacter().decrementSanity(); // TODO: Change this to decrementMental
			game.getCurrentCharacter().decrementMight(); // TODO: Change this to decrementPhysical
		}

	}

}
