package eventCards;

import characters.Trait;
import Game.Game;

public class CreepyCrawlies extends EventCard {

	private Game game;
	
	public CreepyCrawlies(String name, String description) {
		super(name, description);
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
