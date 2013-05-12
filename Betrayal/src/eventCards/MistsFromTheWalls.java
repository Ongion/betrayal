package eventCards;

import java.util.Locale;

import rooms.EventRoom;
import rooms.Room.Floor_Name;
import Game.Game;
import characters.Character;
import characters.Trait;

public class MistsFromTheWalls extends EventCard {
	
	public MistsFromTheWalls(Locale loc) {
		super("MistsFromTheWalls", loc);
	}
	
	@Override
	public void happen(int rollResult) {
		for (Character characterChecking : Game.getInstance().getCharacters()) {
			//if (characterChecking.getCurrentRoom().getFloor() == Floor_Name.BASEMENT) {
				if (rollResult >= 1 && rollResult <= 3){
					Trait chosenTrait = Game.getInstance().chooseAMentalTrait();
					int diceToRoll = 1;
					if (characterChecking.getCurrentRoom() instanceof EventRoom) {
						diceToRoll += 1;
					}
					int damage = Game.getInstance().rollDice(diceToRoll);
					Game.getInstance().getCurrentCharacter().decrementTrait(chosenTrait, damage); // TODO: Make this decrementMental
					// TODO: Take an additional die of damage if in a room with an event symbol
				} else if (rollResult == 0){
					Game.getInstance().getCurrentCharacter().decrementSanity(); // TODO: Make this decrementMental
					// TODO: Take 2 additional die of damage if in a room with an event symbol
				}
			//}
		}
	}

	@Override
	public void happens() {
		for (Character characterChecking : Game.getInstance().getCharacters()) {
			if (characterChecking.getCurrentRoom().getFloor() == Floor_Name.BASEMENT) {
				int rollResult = characterChecking.getTraitRoll(Trait.SANITY); 
				if (rollResult >= 1 && rollResult <= 3){
					Trait chosenTrait = Game.getInstance().chooseAMentalTrait();
					int diceToRoll = 1;
					if (characterChecking.getCurrentRoom() instanceof EventRoom) {
						diceToRoll += 1;
					}
					int damage = Game.getInstance().rollDice(diceToRoll);
					characterChecking.decrementTrait(chosenTrait, damage);
				} else if (rollResult == 0){
					Trait chosenTrait = Game.getInstance().chooseAMentalTrait();
					int diceToRoll = 1;
					if (characterChecking.getCurrentRoom() instanceof EventRoom) {
						diceToRoll += 2;
					}
					int damage = Game.getInstance().rollDice(diceToRoll);
					characterChecking.decrementTrait(chosenTrait, damage); 
				}
			}
		}
	}

}
