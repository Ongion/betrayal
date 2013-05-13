package eventCards;

import java.util.Locale;

import characters.Character;
import characters.Trait;
import Game.Game;

public class LockedSafe extends EventCard {
	// TODO: Add functionality for tokens
	
	public LockedSafe(Locale loc) {
		super("LockedSafe", loc);
	}
	
	@Override
	public void happen(int rollResult) {
		if(rollResult >= 5){
			Game.getInstance().getCurrentCharacter().addItemCard(Game.getInstance().drawItem());
			Game.getInstance().getCurrentCharacter().addItemCard(Game.getInstance().drawItem());
			// TODO: Remove safe token
		} else if (rollResult >= 2 && rollResult <= 4){
			Game.getInstance().getCurrentCharacter().decrementSpeed(); // TODO: Change this to decrementphysical
		} else {
			Game.getInstance().getCurrentCharacter().decrementSpeed(2); // TODO: Change this to decrementPhysical
		}

	}

	@Override
	public void happens() {
		Character character = Game.getInstance().getCurrentCharacter();
		// TODO: Place token
		int rollResult = character.getTraitRoll(Trait.KNOWLEDGE);
		if(rollResult >= 5){
			character.addItemCard(Game.getInstance().drawItem());
			character.addItemCard(Game.getInstance().drawItem());
			// TODO: Remove safe token
		} else if (rollResult >= 2 && rollResult <= 4){
			Trait chosenTrait = Game.getInstance().chooseAPhysicalTrait();
			int damage = Game.getInstance().rollDice(1);
			character.decrementTrait(chosenTrait, damage);
		} else {
			Trait chosenTrait = Game.getInstance().chooseAPhysicalTrait();
			int damage = Game.getInstance().rollDice(2);
			character.decrementTrait(chosenTrait, damage);
		}
	}

}
