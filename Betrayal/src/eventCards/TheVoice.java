package eventCards;

import java.util.Locale;

import characters.Character;
import characters.Trait;
import Game.Game;

public class TheVoice extends EventCard {
	
	public TheVoice(Locale loc) {
		super("TheVoice", loc);
	}

	@Override
	public void happen(int rollResult) {
		// For testing purposes only
		if (rollResult >= 4){
			Game.getInstance().getCurrentCharacter().addItemCard(Game.getInstance().drawItem());
		} 
	}

	@Override
	public void happens() {
		Character currentCharacter = Game.getInstance().getCurrentCharacter();
		int rollResult = currentCharacter.getTraitRoll(Trait.KNOWLEDGE);
		if (rollResult >= 4){
			currentCharacter.addItemCard(Game.getInstance().drawItem());
		} 
	}

}
