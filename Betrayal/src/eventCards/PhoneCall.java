package eventCards;

import java.util.Locale;

import Game.Game;

public class PhoneCall extends EventCard {

	private Game game;
	
	public PhoneCall(Locale loc) {
		super("PhoneCall", loc);
		this.game = Game.getInstance();
	}

	@Override
	public void happen(int rollResult) {
		// For testing purposes only
		if(rollResult == 4){
			game.getCurrentCharacter().incrementSanity();
		} else if (rollResult == 3){
			game.getCurrentCharacter().incrementKnowledge();
		} else if (rollResult >= 1 && rollResult <=2){
			game.getCurrentCharacter().decrementKnowledge(); // TODO: change this to decrementMental
		} else if( rollResult == 0){
			game.getCurrentCharacter().decrementMight(2); // TODO: change this to decrementPhysical
		}
	}

	@Override
	public void happens() {
		int rollResult = game.rollDice(2);
		if(rollResult == 4){
			game.getCurrentCharacter().incrementSanity();
		} else if (rollResult == 3){
			game.getCurrentCharacter().incrementKnowledge();
		} else if (rollResult >= 1 && rollResult <=2){
			game.getCurrentCharacter().decrementKnowledge(game.rollDice(1)); // TODO: change this to decrementMental
		} else if( rollResult == 0){
			game.getCurrentCharacter().decrementMight(game.rollDice(2)); // TODO: change this to decrementPhysical
		}
	}

}
