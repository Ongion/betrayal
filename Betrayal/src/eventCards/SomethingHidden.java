package eventCards;

import java.util.Locale;

import characters.Character;
import characters.Trait;
import Game.Game;

public class SomethingHidden extends EventCard {

	public SomethingHidden(Locale loc) {
		super("SomethingHidden", loc);
	}

	@Override
	public void happen(int rollResult) {
		// For testing purposes only
		if (rollResult >= 4){
			Game.getInstance().getCurrentCharacter().addItemCard(Game.getInstance().drawItem());
		} else {
			Game.getInstance().getCurrentCharacter().decrementSanity();
		}
	}

	@Override
	public void happens() {
		Character character = Game.getInstance().getCurrentCharacter();
		int rollResult = character.getTraitRoll(Trait.KNOWLEDGE);
		if (rollResult >= 4){
			character.addItemCard(Game.getInstance().drawItem());
		} else {
			character.decrementSanity();
		}
	}

}
