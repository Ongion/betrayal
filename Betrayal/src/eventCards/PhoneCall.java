package eventCards;

import java.util.Locale;

import characters.Character;
import characters.Trait;
import Game.Game;

public class PhoneCall extends EventCard {

	public PhoneCall(Locale loc) {
		super("PhoneCall", loc);
	}

	@Override
	public void happen(int rollResult) {
		// For testing purposes only
		if(rollResult == 4){
			Game.getInstance().getCurrentCharacter().incrementSanity();
		} else if (rollResult == 3){
			Game.getInstance().getCurrentCharacter().incrementKnowledge();
		} else if (rollResult >= 1 && rollResult <=2){
			Game.getInstance().getCurrentCharacter().decrementKnowledge(); // TODO: change this to decrementMental
		} else if( rollResult == 0){
			Game.getInstance().getCurrentCharacter().decrementMight(2); // TODO: change this to decrementPhysical
		}
	}

	@Override
	public void happens() {
		Character character = Game.getInstance().getCurrentCharacter();
		int rollResult = Game.getInstance().rollDice(2);
		if(rollResult == 4){
			character.incrementSanity();
		} else if (rollResult == 3){
			character.incrementKnowledge();
		} else if (rollResult >= 1 && rollResult <=2){
			Trait chosenTrait = Game.getInstance().chooseAMentalTrait();
			int damage = Game.getInstance().rollDice(1);
			character.decrementTrait(chosenTrait, damage);
		} else if( rollResult == 0){
			Trait chosenTrait = Game.getInstance().chooseAPhysicalTrait();
			int damage = Game.getInstance().rollDice(2);
			character.decrementTrait(chosenTrait, damage);
		}
	}

}
