package eventCards;

import Game.Game;

public class NightView extends EventCard {

	private Game game;
	
	public NightView(String name, String description) {
		super(name, description);
		this.game = Game.getInstance();
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
		int rollResult = game.rollDice(game.getCurrentCharacter().getCurrentKnowledge());
		if (rollResult >= 5){
			game.getCurrentCharacter().incrementKnowledge();
		} 
		
	}
}
