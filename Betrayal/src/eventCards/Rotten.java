package eventCards;
import characters.Character;
import characters.FatherRhinehardt;

public abstract class Rotten extends EventCard {
	// This is only for testing purposes and will be removed
	private Character character;
	
	protected Rotten(String name, String description, Character person) {
		super(name, description);
		this.character = person;
	}

	@Override
	public void happen(int rollResult) {
		// rollResult will be removed. It is only for testing purposes
		if (rollResult >= 5){
			character.incrementKnowledge(); // TODO: Change this to incrementSanity when implemented
		} else if (rollResult == 1){
			character.decrementKnowledge(); // TODO: Change this to decrementMight when implemented
		} else if (rollResult == 0){
			character.decrementKnowledge(); // TODO: Change this to decrementMight
			character.decrementKnowledge(); // TODO: Change this to decrementSpeed
		} else{
			character.decrementKnowledge(); // TODO: Change this to decrementMight
		}

	}

}
