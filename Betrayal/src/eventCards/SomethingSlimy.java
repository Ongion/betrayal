package eventCards;

import java.util.Locale;

import characters.Character;
import characters.Trait;
import Game.Game;

public class SomethingSlimy extends EventCard {

	public SomethingSlimy(Locale loc) {
		super("SomethingSlimy", loc);
	}

	@Override
	public void happen(int rollResult) {
		// For testing purposes only
		if (rollResult >= 4){
			Game.getInstance().getCurrentCharacter().incrementSpeed();
		} else if (rollResult >= 1 && rollResult <= 3){
			Game.getInstance().getCurrentCharacter().decrementMight();
		} else{
			Game.getInstance().getCurrentCharacter().decrementMight();
			Game.getInstance().getCurrentCharacter().decrementSpeed();
		}
	}

	@Override
	public void happens() {
		Character character = Game.getInstance().getCurrentCharacter();
		int rollResult = character.getTraitRoll(Trait.SPEED);
		if (rollResult >= 4){
			character.incrementSpeed();
		} else if (rollResult >= 1 && rollResult <= 3){
			character.decrementMight();
		} else{
			character.decrementMight();
			character.decrementSpeed();
		}
	}

}
