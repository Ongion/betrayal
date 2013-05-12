package itemCards;

import java.util.Locale;

import Game.Game;

import characters.Character;
import characters.Trait;

public class SacrificialDagger extends ItemCard {

	public SacrificialDagger(Locale loc) {
		super("SacrificialDagger", loc);

	}

	@Override
	public void whatToDo(Character character) {

		Game currentGame = Game.getInstance();
		int rollResult = currentGame.rollDice(character.getCurrentKnowledge());

		if (rollResult >= 6) {
			return;
		}
		if (rollResult >= 3 && rollResult <= 5) {
			Trait mentalTraitChosen = currentGame.chooseAMentalTrait();
			if (mentalTraitChosen == Trait.KNOWLEDGE) {
				character.decrementKnowledge();
			} else if (mentalTraitChosen == Trait.SANITY) {
				character.decrementSanity();
			}
		}
		if (rollResult >= 0 && rollResult <= 2) {
			int damageResult = currentGame.rollDice(2);
			Trait physicalTraitChosen = currentGame.chooseAPhysicalTrait();
			if (physicalTraitChosen == Trait.MIGHT) {
				character.decrementMight(damageResult);
			} else if (physicalTraitChosen == Trait.SPEED) {
				character.decrementSpeed(damageResult);
			}

		}

	}

}
