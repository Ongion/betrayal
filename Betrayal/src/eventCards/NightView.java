package eventCards;

import Game.Game;
import characters.Character;

public class NightView extends EventCard {
	// This is only for testing purposes and will be removed
	private Character character;
	private Game game;
	
	public NightView(String name, String description, Character person, Game game) {
		super(name, description);
		this.character = person;
		this.game = game;
	}

	@Override
	public void happen(int rollResult) {
		// For testing purposes only
		if (rollResult >= 5){
			character.incrementKnowledge();
		} 
	}
		
	@Override
	public Character getCharacter(){
		return character;
	}

	@Override
	public void happens() {
		int rollResult = game.rollDie(character.getCurrentKnowledge());
		if (rollResult >= 5){
			character.incrementKnowledge();
		} 
		
	}
}
