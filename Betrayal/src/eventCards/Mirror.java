package eventCards;

import java.util.Locale;

import characters.Character;
import Game.Game;

public class Mirror extends EventCard {

	public Mirror(Locale loc){
		super("Mirror", loc);
	}
	
	@Override
	public void happen(int rollResult) {

	}

	@Override
	public void happens() {
		Character character = Game.getInstance().getCurrentCharacter();
		Game.getInstance().discardItem(character.getItemHand().remove(0)); // TODO: Change this to allow the user to select the item card
		character.incrementKnowledge();

	}

}
