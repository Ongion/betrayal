package eventCards;

import java.util.Locale;

import Game.Game;

public class Funeral extends EventCard {

	private Game game;
	
	public Funeral(Locale loc) {
		super("Funeral", loc);
		this.game = Game.getInstance();
	}

	@Override
	public void happen(int rollResult) {
		// For testing purposes only
		if (rollResult >= 4){
			game.getCurrentCharacter().incrementSanity();
		} else if (rollResult >= 2 && rollResult <= 3){
			game.getCurrentCharacter().decrementSanity();
		} else{
			game.getCurrentCharacter().decrementSanity();
			game.getCurrentCharacter().decrementMight();
		}
	}

	@Override
	public void happens() {
		int rollResult = game.rollDice(game.getCurrentCharacter().getCurrentSanity());
		if (rollResult >= 4){
			game.getCurrentCharacter().incrementSanity();
		} else if ((rollResult >= 2) && (rollResult <= 3)){
			game.getCurrentCharacter().decrementSanity();
		} else{
			game.getCurrentCharacter().decrementSanity();
			game.getCurrentCharacter().decrementMight();
		}
	}

}
