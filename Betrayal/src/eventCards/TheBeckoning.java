package eventCards;

import java.util.ArrayList;
import java.util.Locale;

import rooms.RoomName;

import characters.Character;
import characters.Trait;
import Game.Game;

public class TheBeckoning extends EventCard {
	
	public TheBeckoning(Locale loc) {
		super("TheBeckoning", loc);
	}
	
	@Override
	public void happen(int rollResult) {
		// TODO: add movement to the patio for this case
		if(rollResult >=0 && rollResult <= 2){
			Game.getInstance().getCurrentCharacter().decrementSpeed(); // TODO: Change to decrementPhysical
		}
	}

	@Override
	public void happens() {
		// TODO: add movement to the patio for this case
		ArrayList<Character> characters = Game.getInstance().getCharacters();
		for(Character character: characters){
			if (character.getCurrentRoom().getNameEnum() == RoomName.GARDENS || 
					character.getCurrentRoom().getNameEnum() == RoomName.GRAVEYARD ||
					character.getCurrentRoom().getNameEnum() == RoomName.TOWER ||
					character.getCurrentRoom().getNameEnum() == RoomName.BALCONY ||
					character.getCurrentRoom().getExternalWindows() != 0){
				int rollResult = character.getTraitRoll(Trait.SANITY);
				if(rollResult >=0 && rollResult <= 2){
					Trait chosenTrait = Game.getInstance().chooseAPhysicalTrait();
					int damage = Game.getInstance().rollDice(1);
					character.decrementTrait(chosenTrait, damage);
				}
			}
		}
	}

}
