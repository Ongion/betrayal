package eventCards;

import java.util.Locale;

import characters.Character;
import characters.Trait;
import Game.Game;

public class NightView extends EventCard {

	private Game game;
	
	public NightView(Locale loc) {
		super("NightView", loc);
		this.game = Game.getInstance();
	}

	@Override
	public void happen(int rollResult) {
		// For testing purposes only
		if (rollResult >= 5){
			Game.getInstance().getCurrentCharacter().incrementKnowledge();
		} 
	}

	@Override
	public void happens() {
		Character character = Game.getInstance().getCurrentCharacter();
		int rollResult = character.getTraitRoll(Trait.KNOWLEDGE);
		if (rollResult >= 5){
			character.incrementKnowledge();
		} 
		
	}
}
