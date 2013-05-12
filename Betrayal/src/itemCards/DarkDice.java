package itemCards;

import java.util.Locale;

import Game.Game;

import characters.Character;
import characters.Trait;
import eventCards.EventCard;

public class DarkDice extends ItemCard {

	public DarkDice(Locale loc) {
		super("DarkDice", loc);
		
	}

	@Override
	public
	void whatToDo(Character character) {
		Game currentGame = Game.getInstance();
		int rollResult = currentGame.rollDice(3);
		if(rollResult == 4){
			Trait physicalTraitChosen = currentGame.chooseAPhysicalTrait();
			if(physicalTraitChosen == Trait.SPEED){
				character.incrementSpeed();
			}else if(physicalTraitChosen== Trait.MIGHT){
				character.incrementMight();
			}
		}
		
		if(rollResult == 2){
			Trait mentalTraitChosen = currentGame.chooseAMentalTrait();
			if(mentalTraitChosen == Trait.KNOWLEDGE){
				character.incrementKnowledge();
			}else if(mentalTraitChosen == Trait.SANITY){
				character.incrementSanity();
			}
		}
		
		if(rollResult == 1){
			EventCard eventCardDrawn = currentGame.drawEvent();
			character.getEventHand().add(eventCardDrawn);
		}
		
	}

}
