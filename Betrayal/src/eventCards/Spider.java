package eventCards;

import java.util.Locale;

import characters.Trait;
import characters.Character;
import Game.Game;

public class Spider extends EventCard {

	public Spider(Locale loc) {
		super("Spider", loc);
	}
	
	@Override
	public void happen(int rollResult) {
		if(rollResult >= 4){
			Game.getInstance().getCurrentCharacter().incrementSpeed(); // TODO: changes this to allow the user to choose either sooeed or sanity
		} else if (rollResult >= 1 && rollResult <=3){
			Game.getInstance().getCurrentCharacter().decrementSpeed(); // TODO: change this to decrementPhysical
		} else if(rollResult == 0){
			Game.getInstance().getCurrentCharacter().decrementSpeed(2); // TODO: change this to decrementPhysical
		}

	}

	@Override
	public void happens() {
		int rollResult;
		Trait chosenTrait = Game.getInstance().chooseSpeedOrSanity();
		Character character = Game.getInstance().getCurrentCharacter();
		rollResult = character.getTraitRoll(chosenTrait);
		if(rollResult >= 4){
			character.incrementTrait(chosenTrait, 1);
		} else if (rollResult >= 1 && rollResult <=3){
			Trait trait = Game.getInstance().chooseAPhysicalTrait();
			character.decrementTrait(trait, Game.getInstance().rollDice(1));
		} else if( rollResult == 0){
			Trait trait = Game.getInstance().chooseAPhysicalTrait();
			character.decrementTrait(trait, Game.getInstance().rollDice(2));
		}
	}

}
