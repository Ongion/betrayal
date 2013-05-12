package eventCards;

import java.util.Locale;

import characters.Character;
import characters.Trait;
import Game.Game;

public class HangedMen extends EventCard {

	public HangedMen(Locale loc) {
		super("HangedMen", loc);
	}

	@Override
	public void happen(int rollResult) {
		// For testing purposes only
		int i = 0;
		Boolean greaterThan2 = true;
		while (i < 4){
			if (rollResult < 2 ){
				greaterThan2 = false;
				switch (i){
					case 0: Game.getInstance().getCurrentCharacter().decrementKnowledge(); break;
					case 1: Game.getInstance().getCurrentCharacter().decrementMight(); break;
					case 2: Game.getInstance().getCurrentCharacter().decrementSanity(); break; 
					case 3: Game.getInstance().getCurrentCharacter().decrementSpeed(); break;
				}
			}
			i++;
		}
		
		if(greaterThan2){
			Game.getInstance().getCurrentCharacter().incrementKnowledge(); // TODO: Change this to allow player to choose trait
		}
	}

	@Override
	public void happens() {
		int i = 0;
		Boolean greaterThan2 = true;
		Character character = Game.getInstance().getCurrentCharacter();
		while (i < 4){
			int rollResult;
			switch (i) {
				case 0: rollResult = character.getTraitRoll(Trait.KNOWLEDGE); break;
				case 1: rollResult = character.getTraitRoll(Trait.MIGHT); break;
				case 2: rollResult = character.getTraitRoll(Trait.SANITY); break;
				default: rollResult = character.getTraitRoll(Trait.SPEED); break;
			}
			if (rollResult < 2 ){
				greaterThan2 = false;
				switch (i){
					case 0: character.decrementKnowledge(rollResult); break;
					case 1: character.decrementMight(rollResult); break;
					case 2: character.decrementSanity(rollResult); break;
					case 3: character.decrementSpeed(rollResult); break;
				}
			}
			i++;
		}
		
		if(greaterThan2){
			Trait chosenTrait = Game.getInstance().chooseATrait();
			character.incrementTrait(chosenTrait, 1);
		}
	}

}
