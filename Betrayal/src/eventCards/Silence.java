package eventCards;

import java.util.Locale;

import Game.Game;

public class Silence extends EventCard {

	private Game game;
	
	public Silence(Locale loc) {
		super("Silence", loc);
		this.game = Game.getInstance();
	}

	@Override
	public void happen(int rollResult) {
		// For testing purposes only
		// Change this so it has an affect on every player in the basement
		if((rollResult > 0) && (rollResult < 4)){
			game.getCurrentCharacter().decrementKnowledge(); // TODO: Change this to decrementMental when implemented
		} else if (rollResult == 0){
			game.getCurrentCharacter().decrementKnowledge(2); // TODO: Change this to decrementMental
		}
	}

	@Override
	public void happens() {
		// Change this so it has an affect on every player in the basement
		int rollResult = game.rollDice(game.getCurrentCharacter().getCurrentSanity());
		if((rollResult > 0) && (rollResult < 4)){
			game.getCurrentCharacter().decrementKnowledge(game.rollDice(1)); // TODO: Change this to decrementMental when implemented
		} else if (rollResult == 0){
			game.getCurrentCharacter().decrementKnowledge(game.rollDice(2)); // TODO: Change this to decrementMental
		}
	}

}
