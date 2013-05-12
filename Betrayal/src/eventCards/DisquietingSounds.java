package eventCards;

import java.util.Locale;

import characters.Trait;

import Game.Game;

public class DisquietingSounds extends EventCard {

	public DisquietingSounds(Locale loc){
		super("DisquietingSounds", loc);
	}
	
	@Override
	public void happen(int rollResult) {
		// TODO Auto-generated method stub

	}

	@Override
	public void happens() {
		int rollResult = Game.getInstance().rollDice(6);
		
		if (rollResult >= Game.getInstance().numOmensOut()){
			Game.getInstance().getCurrentCharacter().incrementSanity();
		} else {
			Trait chosenTrait = Game.getInstance().chooseAMentalTrait();
			int damage = Game.getInstance().rollDice(1);
			Game.getInstance().getCurrentCharacter().decrementTrait(chosenTrait, damage);			
		}
	}

}
