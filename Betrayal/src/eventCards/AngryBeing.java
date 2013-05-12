package eventCards;

import java.util.Locale;

import characters.Character;
import characters.Trait;
import Game.Game;

public class AngryBeing extends EventCard {

	public AngryBeing(Locale loc) {
		super("AngryBeing", loc);
	}

	@Override
	public void happen(int rollResult) {
		// For testing purposes only
		if (rollResult >= 5){
			Game.getInstance().getCurrentCharacter().incrementSpeed();
		} else if ((rollResult >= 2) && (rollResult <= 4)){
			Game.getInstance().getCurrentCharacter().decrementKnowledge(); // TODO: Change this to decrementMental when implemented
		} else{
			Game.getInstance().getCurrentCharacter().decrementKnowledge(); // TODO: Change this to decrementMental
			Game.getInstance().getCurrentCharacter().decrementMight(); // TODO: Change this to decrementPhysical
		}
	}

	@Override
	public void happens() {
		Character character = Game.getInstance().getCurrentCharacter();
		int rollResult = character.getTraitRoll(Trait.SPEED);
		if (rollResult >= 5){
			character.incrementSpeed();
		} else if ((rollResult >= 2) && (rollResult <= 4)){
			Trait chosenTrait = Game.getInstance().chooseAMentalTrait();
			int damage = Game.getInstance().rollDice(1);
			character.decrementTrait(chosenTrait, damage);
		} else{
			Trait trait1 = Game.getInstance().chooseAMentalTrait();
			Trait trait2 = Game.getInstance().chooseAPhysicalTrait();
			int damage1 = Game.getInstance().rollDice(1);
			int damage2 = Game.getInstance().rollDice(1);
			character.decrementTrait(trait1, damage1);
			character.decrementTrait(trait2, damage2);
		}
	}

}
