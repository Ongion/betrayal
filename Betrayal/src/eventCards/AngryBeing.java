package eventCards;

import Game.Game;
import characters.Character;

public class AngryBeing extends EventCard {
	// This is only for testing purposes and will be removed
	private Character character;
	private Game game;
	
	public AngryBeing(String name, String description, Character person, Game game) {
		super(name, description);
		this.character = person;
		this.game = game;
	}

	@Override
	public void happen(int rollResult) {
		// For testing purposes only
		if (rollResult >= 5){
			character.incrementSpeed();
		} else if ((rollResult >= 2) && (rollResult <= 4)){
			character.decrementKnowledge(); // TODO: Change this to decrementMental when implemented
		} else{
			character.decrementKnowledge(); // TODO: Change this to decrementMental
			character.decrementMight(); // TODO: Change this to decrementPhysical
		}
	}
		
	@Override
	public Character getCharacter(){
		return character;
	}

	@Override
	public void happens() {
		int rollResult = game.rollDie(character.getCurrentSpeed());
		if (rollResult >= 5){
			character.incrementSpeed();
		} else if ((rollResult >= 2) && (rollResult <= 4)){
			character.decrementKnowledge(game.rollDie(1)); // TODO: Change this to decrementMental when implemented
		} else{
			character.decrementKnowledge(game.rollDie(1)); // TODO: Change this to decrementMental
			character.decrementMight(game.rollDie(1)); // TODO: Change this to decrementPhysical
		}
	}

}
