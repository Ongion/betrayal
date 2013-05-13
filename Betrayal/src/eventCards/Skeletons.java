package eventCards;

import java.util.Locale;

import characters.Character;
import characters.Trait;
import Game.Game;

public class Skeletons extends EventCard {
	// TODO: Add further implementation for skeleton token

	public Skeletons(Locale loc) {
		super("Skeletons", loc);
	}

	@Override
	public void happen(int rollResult) {
		// For testing purposes only
		if (rollResult >= 5){
			Game.getInstance().getCurrentCharacter().addItemCard(Game.getInstance().drawItem());
		} else{
			Game.getInstance().getCurrentCharacter().decrementSanity(); //TODO: Change this to decrementMental
		}
	}

	@Override
	public void happens() {
		Character character = Game.getInstance().getCurrentCharacter();
		Trait chosenTrait = Game.getInstance().chooseAMentalTrait();
		int damage = Game.getInstance().rollDice(1);
		character.decrementTrait(chosenTrait, damage);
		// TODO: Place Token
	}

	@Override
	public void beginningOfTurn(){
		Character character = Game.getInstance().getCurrentCharacter();
		Boolean attempt = Game.getInstance().attemptRoll();
		if(attempt){
			int rollResult = character.getTraitRoll(Trait.SANITY);
			if (rollResult >= 5){
				character.addItemCard(Game.getInstance().drawItem());
				// TODO: Remove Token
			} else{
				Trait chosenTrait = Game.getInstance().chooseAMentalTrait();
				int damage = Game.getInstance().rollDice(1);
				character.decrementTrait(chosenTrait, damage);
			}
		}
	}
}
