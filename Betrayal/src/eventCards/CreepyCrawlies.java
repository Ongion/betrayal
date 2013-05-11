package eventCards;

import java.util.Locale;

import characters.Character;
import characters.Trait;
import Game.Game;

public class CreepyCrawlies extends EventCard {

	public CreepyCrawlies(Locale loc) {
		super("CreepyCrawlies", loc);
	}

	@Override
	public void happen(int rollResult) {
		// For testing purposes only
		if (rollResult >= 5){
			Game.getInstance().getCurrentCharacter().incrementSanity();
		} else if (rollResult >= 1 && rollResult <= 4){
			Game.getInstance().getCurrentCharacter().decrementSanity();
		} else{
			Game.getInstance().getCurrentCharacter().decrementSanity(2);
		}
	}

	@Override
	public void happens() {
		Character character = Game.getInstance().getCurrentCharacter();
		int rollResult = character.getTraitRoll(Trait.SANITY);
		if (rollResult >= 5){
			character.incrementSanity();
		} else if ((rollResult >= 1) && (rollResult <= 4)){
			character.decrementSanity();
		} else{
			character.decrementSanity(2);
		}
	}
}
