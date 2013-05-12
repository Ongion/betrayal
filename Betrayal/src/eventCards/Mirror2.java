package eventCards;

import java.util.Locale;

import Game.Game;

public class Mirror2 extends EventCard {
	
	public Mirror2(Locale loc) {
		super("Mirror2", loc);
	}

	@Override
	public void happen(int rollResult) {
		// For testing purposes only
		Game.getInstance().getCurrentCharacter().addItemCard(Game.getInstance().drawItem());
	}

	@Override
	public void happens() {
		Game.getInstance().getCurrentCharacter().addItemCard(Game.getInstance().drawItem());
	}

}
