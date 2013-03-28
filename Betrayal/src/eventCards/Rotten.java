package eventCards;
import Game.Game;
import characters.Character;

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
			game.getCurrentPlayer().getCharacter().incrementSanity();
		} else if (rollResult == 1){
			game.getCurrentPlayer().getCharacter().decrementMight();
			game.getCurrentPlayer().getCharacter().decrementSpeed();
		} else if (rollResult == 0){
			game.getCurrentPlayer().getCharacter().decrementMight();
			game.getCurrentPlayer().getCharacter().decrementSpeed();
			game.getCurrentPlayer().getCharacter().decrementSanity();
			game.getCurrentPlayer().getCharacter().decrementKnowledge(); 
		} else{
			game.getCurrentPlayer().getCharacter().decrementMight();
		}
	}

	@Override
	public void happens() {
		int rollResult = game.rollDie(game.getCurrentPlayer().getCharacter().getCurrentSanity());
		if (rollResult >= 5){
			game.getCurrentPlayer().getCharacter().incrementSanity();
		} else if (rollResult == 1){
			game.getCurrentPlayer().getCharacter().decrementMight();
			game.getCurrentPlayer().getCharacter().decrementSpeed();
		} else if (rollResult == 0){
			game.getCurrentPlayer().getCharacter().decrementMight();
			game.getCurrentPlayer().getCharacter().decrementSpeed();
			game.getCurrentPlayer().getCharacter().decrementSanity();
			game.getCurrentPlayer().getCharacter().decrementKnowledge(); 
		} else{
			game.getCurrentPlayer().getCharacter().decrementMight();
		}
		
	}

}
