package eventCards;

import java.util.Locale;

import Game.Game;

public class Footsteps extends EventCard {

	private Game game;
	
	public Footsteps(Locale loc) {
		super("Footsteps", loc);
		this.game = Game.getInstance();
	}
	
	@Override
	public void happen(int rollResult) {
		if(rollResult == 4){
			game.getCurrentCharacter().incrementMight(); // TODO: Increment closest explorer as well
		} else if (rollResult == 3){
			game.getCurrentCharacter().incrementMight(); // TODO: Decrement closest explorer's Sanity
		} else if (rollResult == 2){
			game.getCurrentCharacter().decrementSanity();
		} else if (rollResult == 1){
			game.getCurrentCharacter().decrementSpeed();
		} else {
			game.getCurrentCharacter().decrementSanity(); // TODO: do this for each character but allow to choose trait
		}

	}

	@Override
	public void happens() {
		int rollResult = game.rollDice(1); // TODO: Change this so if in Chapel player rolls 2 die
		if(rollResult == 4){
			game.getCurrentCharacter().incrementMight(); // TODO: Increment closest explorer as well
		} else if (rollResult == 3){
			game.getCurrentCharacter().incrementMight(); // TODO: Decrement closest explorer's Sanity
		} else if (rollResult == 2){
			game.getCurrentCharacter().decrementSanity();
		} else if (rollResult == 1){
			game.getCurrentCharacter().decrementSpeed();
		} else {
			game.getCurrentCharacter().decrementSanity(); // TODO: do this for each character but allow to choose trait
		}
	}

}
