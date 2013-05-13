package itemCards;

import java.util.Locale;

import Game.Game;

import characters.Character;
import characters.Trait;

public class MedicalKit extends ItemCard {

	public MedicalKit(Locale loc) {
		super("MedicalKit", loc);
	
	}

	@Override
	public
	void whatToDo(Character character) {
		Game currentGame = Game.getInstance();
		int rollResult = currentGame.rollDice(character.getCurrentKnowledge());
		
		if(rollResult >= 8){
			Trait physicalTraitChosen = currentGame.chooseAPhysicalTrait();
			if(physicalTraitChosen == Trait.MIGHT){
				character.incrementMight(3);
			}
			
			if(physicalTraitChosen == Trait.SPEED){
				character.incrementSpeed(3);
			}
		}
		
		if(rollResult == 6 || rollResult == 7){
			Trait physicalTraitChosen = currentGame.chooseAPhysicalTrait();
			if(physicalTraitChosen == Trait.MIGHT){
				character.incrementMight(2);
			}
			
			if(physicalTraitChosen == Trait.SPEED){
				character.incrementSpeed(2);
			}
			
		}
		
		if(rollResult == 4 || rollResult == 5){
			Trait physicalTraitChosen = currentGame.chooseAPhysicalTrait();
			if(physicalTraitChosen == Trait.MIGHT){
				character.incrementMight();
			}
			
			if(physicalTraitChosen == Trait.SPEED){
				character.incrementSpeed();
			}
		}
		
		if(rollResult >= 0 && rollResult <=3){
			return;
		}
	}

}
