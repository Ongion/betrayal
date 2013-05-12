package eventCards;
import java.util.Locale;
import characters.Character;
import characters.Trait;
import Game.Game;

public class Rotten extends EventCard {

	
	public Rotten(Locale loc) {
		super("Rotten", loc);
	}

	@Override
	public void happen(int rollResult) {
		// This is only for testing purposes
		if (rollResult >= 5){
			Game.getInstance().getCurrentCharacter().incrementSanity();
		} else if (rollResult == 1){
			Game.getInstance().getCurrentCharacter().decrementMight();
			Game.getInstance().getCurrentCharacter().decrementSpeed();
		} else if (rollResult == 0){
			Game.getInstance().getCurrentCharacter().decrementMight();
			Game.getInstance().getCurrentCharacter().decrementSpeed();
			Game.getInstance().getCurrentCharacter().decrementSanity();
			Game.getInstance().getCurrentCharacter().decrementKnowledge(); 
		} else{
			Game.getInstance().getCurrentCharacter().decrementMight();
		}
	}

	@Override
	public void happens() {
		Character currentCharacter = Game.getInstance().getCurrentCharacter();
		int rollResult = currentCharacter.getTraitRoll(Trait.SANITY);
		if (rollResult >= 5){
			currentCharacter.incrementSanity();
		} else if (rollResult == 1){
			currentCharacter.decrementMight();
			currentCharacter.decrementSpeed();
		} else if (rollResult == 0){
			currentCharacter.decrementMight();
			currentCharacter.decrementSpeed();
			currentCharacter.decrementSanity();
			currentCharacter.decrementKnowledge(); 
		} else{
			currentCharacter.decrementMight();
		}
		
	}

}
