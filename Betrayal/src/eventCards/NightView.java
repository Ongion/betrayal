package eventCards;

import Game.Game;

public class NightView extends EventCard {
	// This is only for testing purposes and will be removed
	private Game game;
	
	public NightView(String name, String description, Game game) {
		super(name, description);
		this.game = game;
	}

	@Override
	public void happen(int rollResult) {
		// For testing purposes only
		if (rollResult >= 5){
			game.getCurrentCharacter().incrementKnowledge();
		} 
	}

	@Override
	public void happens() {
		int rollResult = game.rollDie(game.getCurrentCharacter().getCurrentKnowledge());
		if (rollResult >= 5){
			game.getCurrentCharacter().incrementKnowledge();
		} 
		
	}
}
