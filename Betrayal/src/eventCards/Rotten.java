package eventCards;
import Game.Game;
import characters.Character;

public class Rotten extends EventCard {
	// This is only for testing purposes and will be removed
	private Character character;
	private Game game;
	
	public Rotten(String name, String description, Character person, Game game) {
		super(name, description);
		this.character = person;
		this.game = game;
	}

	@Override
	public void happen(int rollResult) {
		// This is only for testing purposes
		if (rollResult >= 5){
			character.incrementSanity();
		} else if (rollResult == 1){
			character.decrementMight();
			character.decrementSpeed();
		} else if (rollResult == 0){
			character.decrementMight();
			character.decrementSpeed();
			character.decrementSanity();
			character.decrementKnowledge(); 
		} else{
			character.decrementMight();
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
		} else if (rollResult == 1){
			character.decrementMight();
			character.decrementSpeed();
		} else if (rollResult == 0){
			character.decrementMight();
			character.decrementSpeed();
			character.decrementSanity();
			character.decrementKnowledge(); 
		} else{
			character.decrementMight();
		}
		
	}

}
