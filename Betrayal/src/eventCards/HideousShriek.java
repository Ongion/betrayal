package eventCards;

import java.util.ArrayList;
import java.util.Locale;

import characters.Character;
import characters.Trait;
import Game.Game;

public class HideousShriek extends EventCard {

	public HideousShriek(Locale loc) {
		super("HideousShriek", loc);
	}
	
	@Override
	public void happen(int rollResult) {
		if (rollResult >= 1 && rollResult <= 3){
			Game.getInstance().getCurrentCharacter().decrementSanity(); // TODO: Change this to decrementMental
		} else if(rollResult == 0){
			Game.getInstance().getCurrentCharacter().decrementSanity(2); // TODO: Change this to decrementMental
		}

	}

	@Override
	public void happens() {
		ArrayList<Character> characters = Game.getInstance().getCharacters();
		for(Character character: characters){
			int rollResult = character.getTraitRoll(Trait.SANITY);
			if (rollResult >= 1 && rollResult <= 3){
				Trait chosenTrait = Game.getInstance().chooseAMentalTrait();
				int damage = Game.getInstance().rollDice(1);
				character.decrementTrait(chosenTrait, damage);
			} else if(rollResult == 0){
				Trait chosenTrait = Game.getInstance().chooseAMentalTrait();
				int damage = Game.getInstance().rollDice(2);
				character.decrementTrait(chosenTrait, damage);
			}
		}
	}

}