package eventCards;

import java.util.ArrayList;
import java.util.Locale;

import rooms.RoomName;

import characters.Character;
import characters.Trait;
import Game.Game;

public class ShriekingWind extends EventCard {

	public ShriekingWind(Locale loc) {
		super("ShriekingWind", loc);
	}

	@Override
	public void happen(int rollResult) {
		// For testing purposes only
		// TODO: Change this so it affects all players in the Gardens, Graveyard, Patio, Tower, Balcony, or room with an outside-facing window
		if ((rollResult >= 3) && (rollResult <= 4)){
			Game.getInstance().getCurrentCharacter().decrementSpeed(); // TODO: Change this to decrementPhysical when implemented
		} else if((rollResult > 0) && (rollResult < 3)){
			Game.getInstance().getCurrentCharacter().decrementKnowledge(); // TODO: Change this to decrementMental when implemented
		} else if (rollResult == 0){
			Game.getInstance().getCurrentCharacter().decrementMight(); // TODO: Change this to decrementPhysical
			Game.getInstance().getCurrentCharacter().removeItemCard(Game.getInstance().getCurrentCharacter().getItemHand().get(0)); // TODO: Change this so the player can choose the item card
		}
	}

	@Override
	public void happens() {
		ArrayList<Character> characters = Game.getInstance().getCharacters();
		for(Character character: characters){
			if (character.getCurrentRoom().getNameEnum() == RoomName.GARDENS || 
					character.getCurrentRoom().getNameEnum() == RoomName.GRAVEYARD ||
					character.getCurrentRoom().getNameEnum() == RoomName.TOWER ||
					character.getCurrentRoom().getNameEnum() == RoomName.BALCONY ||
					character.getCurrentRoom().getNameEnum() == RoomName.PATIO ||
					character.getCurrentRoom().getExternalWindows() != 0){
				int rollResult = character.getTraitRoll(Trait.MIGHT);
				if ((rollResult >= 3) && (rollResult <= 4)){
					Trait chosenTrait = Game.getInstance().chooseAPhysicalTrait();
					int damage = Game.getInstance().rollDice(1);
					character.decrementTrait(chosenTrait, damage);
				} else if((rollResult > 0) && (rollResult < 3)){
					Trait chosenTrait = Game.getInstance().chooseAMentalTrait();
					int damage = Game.getInstance().rollDice(1);
					character.decrementTrait(chosenTrait, damage);
				} else if (rollResult == 0){
					Trait chosenTrait = Game.getInstance().chooseAPhysicalTrait();
					int damage = Game.getInstance().rollDice(1);
					character.decrementTrait(chosenTrait, damage);
					character.removeItemCard(Game.getInstance().chooseItemCard(character)); 
					// TODO: make it so the item removed is placed in the entrance hall
				}
			}
		}
	}

}
