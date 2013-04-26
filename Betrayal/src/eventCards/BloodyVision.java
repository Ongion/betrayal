package eventCards;

import java.util.Locale;

import characters.Trait;
import Game.Game;

public class BloodyVision extends EventCard {
	
	private Game game;
	
	public BloodyVision(Locale loc) {
		super("BloodyVision", loc);
		this.game = Game.getInstance();
	}
	@Override
	public void happen(int rollResult) {
		if(rollResult >= 4){
			game.getCurrentCharacter().incrementSanity();
		} else if (rollResult >= 2 && rollResult <= 3){
			game.getCurrentCharacter().decrementSanity();
		} else {
			// TODO: Have character attack character/monster in the room or an adjacent one
			// Should attack the one with the lowest might if possible
		}

	}

	@Override
	public void happens() {
		int rollResult = game.getCurrentCharacter().getTraitRoll(Trait.SANITY);
		if(rollResult >= 4){
			game.getCurrentCharacter().incrementSanity();
		} else if (rollResult >= 2 && rollResult <= 3){
			game.getCurrentCharacter().decrementSanity();
		} else {
			// TODO: Have character attack character/monster in the room or an adjacent one
			// Should attack the one with the lowest might if possible
		}
	}

}
