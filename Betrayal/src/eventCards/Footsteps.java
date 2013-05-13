package eventCards;

import java.util.ArrayList;
import java.util.Locale;

import rooms.RoomName;

import characters.Character;
import characters.Trait;
import Game.Game;

public class Footsteps extends EventCard {

	public Footsteps(Locale loc) {
		super("Footsteps", loc);
	}
	
	@Override
	public void happen(int rollResult) {
		if(rollResult == 4){
			Game.getInstance().getCurrentCharacter().incrementMight(); // TODO: Increment closest explorer as well
		} else if (rollResult == 3){
			Game.getInstance().getCurrentCharacter().incrementMight(); // TODO: Decrement closest explorer's Sanity
		} else if (rollResult == 2){
			Game.getInstance().getCurrentCharacter().decrementSanity();
		} else if (rollResult == 1){
			Game.getInstance().getCurrentCharacter().decrementSpeed();
		} else {
			Game.getInstance().getCurrentCharacter().decrementSanity(); // TODO: do this for each character but allow to choose trait
		}

	}

	@Override
	public void happens() {
		Character character = Game.getInstance().getCurrentCharacter();
		int rollResult = 0;

		if (character.getCurrentRoom().getNameEnum() == RoomName.CHAPEL){
			rollResult = Game.getInstance().rollDice(2);
		}else{
			rollResult = Game.getInstance().rollDice(1);
		}
		if(rollResult == 4){
			character.incrementMight();
			Character char2 = character.getNearestCharacter();
			char2.incrementMight();
		} else if (rollResult == 3){
			character.incrementMight();
			Character char2 = character.getNearestCharacter();
			char2.decrementSanity();
		} else if (rollResult == 2){
			character.decrementSanity();
		} else if (rollResult == 1){
			character.decrementSpeed();
		} else {
			ArrayList<Character> characters = Game.getInstance().getCharacters();
			for (Character ch: characters){
				Trait chosenTrait = Game.getInstance().chooseATrait();
				ch.decrementTrait(chosenTrait, 1);
			}
		}
	}

}
