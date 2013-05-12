package eventCards;

import java.util.Locale;

import characters.Trait;
import Game.Game;

public class BloodyVision extends EventCard {
	
	public BloodyVision(Locale loc) {
		super("BloodyVision", loc);
	}
	@Override
	public void happen(int rollResult) {
		if(rollResult >= 4){
			Game.getInstance().getCurrentCharacter().incrementSanity();
		} else if (rollResult >= 2 && rollResult <= 3){
			Game.getInstance().getCurrentCharacter().decrementSanity();
		} else {
			// TODO: Have character attack character/monster in the room or an adjacent one
			// Should attack the one with the lowest might if possible
		}

	}

	@Override
	public void happens() {
		characters.Character character = Game.getInstance().getCurrentCharacter();
		int rollResult = character.getTraitRoll(Trait.SANITY);
		if(rollResult >= 4){
			character.incrementSanity();
		} else if (rollResult >= 2 && rollResult <= 3){
			character.decrementSanity();
		} else {
			// TODO: Have character attack character/monster in the room or an adjacent one
			// Should attack the one with the lowest might if possible
		}
	}

}
