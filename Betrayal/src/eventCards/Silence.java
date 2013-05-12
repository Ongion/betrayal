package eventCards;

import java.util.ArrayList;
import java.util.Locale;

import rooms.Room.Floor_Name;
import characters.Character;
import characters.Trait;
import Game.Game;

public class Silence extends EventCard {

	public Silence(Locale loc) {
		super("Silence", loc);
	}

	@Override
	public void happen(int rollResult) {
		// For testing purposes only
		// Change this so it has an affect on every player in the basement
		if((rollResult > 0) && (rollResult < 4)){
			Game.getInstance().getCurrentCharacter().decrementKnowledge(); // TODO: Change this to decrementMental when implemented
		} else if (rollResult == 0){
			Game.getInstance().getCurrentCharacter().decrementKnowledge(2); // TODO: Change this to decrementMental
		}
	}

	@Override
	public void happens() {
		// TODO: Change to ensure only explorers
		ArrayList<Character> chars = Game.getInstance().getCharacters();
		for(Character character: chars){
			if(character.getCurrentRoom().getFloor() == Floor_Name.BASEMENT){
				int rollResult = character.getTraitRoll(Trait.SANITY);
				if((rollResult > 0) && (rollResult < 4)){
					Trait chosenTrait = Game.getInstance().chooseAMentalTrait();
					int damage = Game.getInstance().rollDice(1);
					character.decrementTrait(chosenTrait, damage);
				} else if (rollResult == 0){
					Trait chosenTrait = Game.getInstance().chooseAMentalTrait();
					int damage = Game.getInstance().rollDice(2);
					character.decrementTrait(chosenTrait, damage);
				}
			}
		
		}
	}

}
