package eventCards;
import Game.Game;

public class Rotten extends EventCard {
	// This is only for testing purposes and will be removed
	private Game game;
	
	public Rotten(String name, String description, Game game) {
		super(name, description);
		this.game = game;
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
		int rollResult = game.rollDice(game.getCurrentCharacter().getCurrentSanity());
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
