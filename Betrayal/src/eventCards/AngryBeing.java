package eventCards;

import characters.Character;

public class AngryBeing extends EventCard {
	// This is only for testing purposes and will be removed
	private Character character;
	
	public AngryBeing(String name, String description, Character person) {
		super(name, description);
		this.character = person;
	}

	@Override
	public void happen(int rollResult) {
		// rollResult will be removed. It is only for testing purposes
		if (rollResult >= 5){
			character.incrementKnowledge(); // TODO: Change this to incrementSpeed when implemented
		} else if ((rollResult >= 2) && (rollResult <= 4)){
			character.decrementKnowledge(); // TODO: Change this to decrementMental when implemented
		} else{
			character.decrementKnowledge(); // TODO: Change this to decrementMental
			character.decrementKnowledge(); // TODO: Change this to decrementPhysical
		}
	}
		
	@Override
	public Character getCharacter(){
		return character;
	}

}
