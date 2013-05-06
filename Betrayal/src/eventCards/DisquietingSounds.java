package eventCards;

import java.util.Locale;

import Game.Game;

public class DisquietingSounds extends EventCard {

	private Game game;
	
	public DisquietingSounds(Locale loc){
		super("DisquietingSounds", loc);
		this.game = Game.getInstance();
	}
	
	@Override
	public void happen(int rollResult) {
		// TODO Auto-generated method stub

	}

	@Override
	public void happens() {
		int rollResult = game.rollDice(6);
		
		if (rollResult >= game.numOmensOut()){
			game.getCurrentCharacter().incrementSanity();
		} else {
			game.getCurrentCharacter().decrementSanity(game.rollDice(1)); // TODO: Change this to decrement mental
		}

	}

}
