package eventCards;
import java.util.Locale;

import characters.Trait;
import Game.Game;

public class Rotten extends EventCard {

	private Game game;
	
	public Rotten(Locale loc) {
		super("Rotten", loc);
		this.game = Game.getInstance();
	}

	@Override
	public void happen(int rollResult) {
		// This is only for testing purposes
		if (rollResult >= 5){
			game.getCurrentCharacter().incrementSanity();
		} else if (rollResult == 1){
			game.getCurrentCharacter().decrementMight();
			game.getCurrentCharacter().decrementSpeed();
		} else if (rollResult == 0){
			game.getCurrentCharacter().decrementMight();
			game.getCurrentCharacter().decrementSpeed();
			game.getCurrentCharacter().decrementSanity();
			game.getCurrentCharacter().decrementKnowledge(); 
		} else{
			game.getCurrentCharacter().decrementMight();
		}
	}

	@Override
	public void happens() {
		int rollResult = game.typeRoll(Trait.SANITY);
		if (rollResult >= 5){
			game.getCurrentCharacter().incrementSanity();
		} else if (rollResult == 1){
			game.getCurrentCharacter().decrementMight();
			game.getCurrentCharacter().decrementSpeed();
		} else if (rollResult == 0){
			game.getCurrentCharacter().decrementMight();
			game.getCurrentCharacter().decrementSpeed();
			game.getCurrentCharacter().decrementSanity();
			game.getCurrentCharacter().decrementKnowledge(); 
		} else{
			game.getCurrentCharacter().decrementMight();
		}
		
	}

}
