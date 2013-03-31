package eventCards;

import Game.Game;

public class HangedMen extends EventCard {

	// This is only for testing purposes and will be removed
	private Game game;
	
	public HangedMen(String name, String description, Game game) {
		super(name, description);
		this.game = game;
	}

	@Override
	public void happen(int rollResult) {
		// For testing purposes only
		int i = 0;
		Boolean greaterThan2 = true;
		while (i < 4){
			if (rollResult < 2 ){
				greaterThan2 = false;
				switch (i){
					case 0: game.getCurrentPlayer().getCharacter().decrementKnowledge(); break;
					case 1: game.getCurrentPlayer().getCharacter().decrementMight(); break;
					case 2: game.getCurrentPlayer().getCharacter().decrementSanity(); break; 
					case 3: game.getCurrentPlayer().getCharacter().decrementSpeed(); break;
				}
			}
			i++;
		}
		
		if(greaterThan2){
			game.getCurrentPlayer().getCharacter().incrementKnowledge(); // TODO: Change this to allow player to choose trait
		}
	}

	@Override
	public void happens() {
		int i = 0;
		Boolean greaterThan2 = true;
		while (i < 4){
			int rollResult;
			switch (i) {
				case 0: rollResult = game.rollDie(game.getCurrentPlayer().getCharacter().getCurrentKnowledge());
				case 1: rollResult = game.rollDie(game.getCurrentPlayer().getCharacter().getCurrentMight());
				case 2: rollResult = game.rollDie(game.getCurrentPlayer().getCharacter().getCurrentSanity());
				default: rollResult = game.rollDie(game.getCurrentPlayer().getCharacter().getCurrentSpeed());
			}
			if (rollResult < 2 ){
				greaterThan2 = false;
				switch (i){
					case 0: game.getCurrentPlayer().getCharacter().decrementKnowledge(rollResult);
					case 1: game.getCurrentPlayer().getCharacter().decrementMight(rollResult);
					case 2: game.getCurrentPlayer().getCharacter().decrementSanity(rollResult);
					case 3: game.getCurrentPlayer().getCharacter().decrementSpeed(rollResult);
				}
			}
			i++;
		}
		
		if(greaterThan2){
			game.getCurrentPlayer().getCharacter().incrementKnowledge(); // TODO: Change this to allow player to choose trait
		}
	}

}
