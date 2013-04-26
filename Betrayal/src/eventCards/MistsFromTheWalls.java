package eventCards;

import java.util.Locale;

import Game.Game;

public class MistsFromTheWalls extends EventCard {
	// TODO: Make this work for all explorers in the basement

	private Game game;
	
	public MistsFromTheWalls(Locale loc) {
		super("MistsFromTheWalls", loc);
		this.game = Game.getInstance();
	}
	
	@Override
	public void happen(int rollResult) {
		if (rollResult >= 1 && rollResult <= 3){
			game.getCurrentCharacter().decrementSanity(); // TODO: Make this decrementMental
			// TODO: Take an additional die of damage if in a room with an event symbol
		} else if (rollResult == 0){
			game.getCurrentCharacter().decrementSanity(); // TODO: Make this decrementMental
			// TODO: Take 2 additional die of damage if in a room with an event symbol
		}

	}

	@Override
	public void happens() {
		int rollResult = game.rollDice(1); 
		if (rollResult >= 1 && rollResult <= 3){
			game.getCurrentCharacter().decrementSanity(); // TODO: Make this decrementMental
			// TODO: Take an additional die of damage if in a room with an event symbol
		} else if (rollResult == 0){
			game.getCurrentCharacter().decrementSanity(); // TODO: Make this decrementMental
			// TODO: Take 2 additional die of damage if in a room with an event symbol
		}
	}

}
