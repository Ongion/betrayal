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
		character.removeItemCard(Game.getInstance().chooseItemCard(character));
		character.incrementKnowledge();

	}

}
