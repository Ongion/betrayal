package eventCards;

import java.util.Locale;

import characters.Trait;
import Game.Game;

public class CreepyCrawlies extends EventCard {

	private Game game;
	
	public CreepyCrawlies(Locale loc) {
		super("CreepyCrawlies", loc);
		this.game = Game.getInstance();
	}

	@Override
	public void happen(int rollResult) {
		// For testing purposes only
		if (rollResult >= 5){
			game.getCurrentCharacter().incrementSanity();
		} else if (rollResult >= 1 && rollResult <= 4){
			game.getCurrentCharacter().decrementSanity();
		} else{
			game.getCurrentCharacter().decrementSanity(2);
		}
	}

	@Override
	public void happens() {
		int rollResult = game.getCurrentCharacter().getTraitRoll(Trait.SANITY);
		if (rollResult >= 5){
			game.getCurrentCharacter().incrementSanity();
		} else if ((rollResult >= 1) && (rollResult <= 4)){
			game.getCurrentCharacter().decrementSanity();
		} else{
			game.getCurrentCharacter().decrementSanity(2);
		}
	}
}
