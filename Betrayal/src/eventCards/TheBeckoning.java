package eventCards;

import java.util.Locale;

import characters.Trait;
import Game.Game;

public class TheBeckoning extends EventCard {
	// TODO: make work on all characters in Gardens, Graveyard, Tower, Balcony, or room with outward facing window
	private Game game;
	
	public TheBeckoning(Locale loc) {
		super("TheBeckoning", loc);
		this.game = Game.getInstance();
	}
	
	@Override
	public void happen(int rollResult) {
		// TODO: add movement to the patio for this case
		if(rollResult >=0 && rollResult <= 2){
			game.getCurrentCharacter().decrementSpeed(); // TODO: Change to decrementPhysical
		}
	}

	@Override
	public void happens() {
		// TODO: add movement to the patio for this case
		int rollResult = game.typeRoll(Trait.SANITY);
		if(rollResult >=0 && rollResult <= 2){
			game.getCurrentCharacter().decrementSpeed(game.rollDice(1)); // TODO: Change to decrementPhysical
		}
	}

}
