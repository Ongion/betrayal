package eventCards;

import java.util.Locale;

import Game.Game;

public class Mirror extends EventCard {

	private Game game;
	
	public Mirror(Locale loc){
		super("Mirror", loc);
		this.game = Game.getInstance();
	}
	
	@Override
	public void happen(int rollResult) {

	}

	@Override
	public void happens() {
		game.discardItem(game.getCurrentCharacter().getItemHand().remove(0)); // TODO: Change this to all the user to select the item card
		game.getCurrentCharacter().incrementKnowledge();

	}

}
