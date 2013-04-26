package eventCards;

import java.util.Locale;

import Game.Game;

public class HangedMen extends EventCard {

	private Game game;
	
	public HangedMen(Locale loc) {
		super("HangedMen", loc);
		this.game = Game.getInstance();
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
					case 0: game.getCurrentCharacter().decrementKnowledge(); break;
					case 1: game.getCurrentCharacter().decrementMight(); break;
					case 2: game.getCurrentCharacter().decrementSanity(); break; 
					case 3: game.getCurrentCharacter().decrementSpeed(); break;
				}
			}
			i++;
		}
		
		if(greaterThan2){
			game.getCurrentCharacter().incrementKnowledge(); // TODO: Change this to allow player to choose trait
		}
	}

	@Override
	public void happens() {
		int i = 0;
		Boolean greaterThan2 = true;
		while (i < 4){
			int rollResult;
			switch (i) {
				case 0: rollResult = game.rollDice(game.getCurrentCharacter().getCurrentKnowledge());
				case 1: rollResult = game.rollDice(game.getCurrentCharacter().getCurrentMight());
				case 2: rollResult = game.rollDice(game.getCurrentCharacter().getCurrentSanity());
				default: rollResult = game.rollDice(game.getCurrentCharacter().getCurrentSpeed());
			}
			if (rollResult < 2 ){
				greaterThan2 = false;
				switch (i){
					case 0: game.getCurrentCharacter().decrementKnowledge(rollResult);
					case 1: game.getCurrentCharacter().decrementMight(rollResult);
					case 2: game.getCurrentCharacter().decrementSanity(rollResult);
					case 3: game.getCurrentCharacter().decrementSpeed(rollResult);
				}
			}
			i++;
		}
		
		if(greaterThan2){
			game.getCurrentCharacter().incrementKnowledge(); // TODO: Change this to allow player to choose trait
		}
	}

}
