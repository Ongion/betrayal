package eventCards;

import Game.Game;
import characters.Character;

public class CreepyCrawlies extends EventCard {
	// This is only for testing purposes and will be removed
	private Character character;
	private Game game;
	
	public CreepyCrawlies(String name, String description, Character person, Game game) {
		super(name, description);
		this.character = person;
		this.game = game;
	}

	@Override
	public void happen(int rollResult) {
		// For testing purposes only
		if (rollResult >= 5){
			character.incrementSanity();
		} else if (rollResult >= 1 && rollResult <= 4){
			character.decrementSanity();
		} else{
			character.decrementSanity(2);
		}
	}
		
	@Override
	public Character getCharacter(){
		return character;
	}

	@Override
	public void happens() {
		int rollResult = game.rollDie(character.getCurrentSanity());
		if (rollResult >= 5){
			character.incrementSanity();
		} else if ((rollResult >= 1) && (rollResult <= 4)){
			character.decrementSanity();
		} else{
			character.decrementSanity(2);
		}
	}
}
