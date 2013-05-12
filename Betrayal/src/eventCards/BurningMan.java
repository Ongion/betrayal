package eventCards;

import java.util.Locale;

import rooms.RoomName;

import characters.Character;
import characters.Trait;
import Game.Game;

public class BurningMan extends EventCard {

	public BurningMan(Locale loc) {
		super("BurningMan", loc);
	}
	@Override
	public void happen(int rollResult) {
		if(rollResult >= 4){
			Game.getInstance().getCurrentCharacter().incrementSanity();
		} else if (rollResult >=2 && rollResult <= 3){
			Game.getInstance().getCurrentCharacter().setCurrentRoom(Game.getInstance().getRoomByRoomName(RoomName.ENTRANCEHALL));
		} else {
			Game.getInstance().getCurrentCharacter().decrementSanity(); // TODO: Change this to decrementMental
			Game.getInstance().getCurrentCharacter().decrementMight(); // TODO: Change this to decrementPhysical
		}

	}

	@Override
	public void happens() {
		Character character = Game.getInstance().getCurrentCharacter();
		int rollResult = character.getTraitRoll(Trait.SANITY);
		if(rollResult >= 4){
			character.incrementSanity();
		} else if (rollResult >=2 && rollResult <= 3){
			character.setCurrentRoom(Game.getInstance().getRoomByRoomName(RoomName.ENTRANCEHALL));
		} else {
			Trait trait1 = Game.getInstance().chooseAMentalTrait();
			Trait trait2 = Game.getInstance().chooseAPhysicalTrait();
			int damage1 = Game.getInstance().rollDice(1);
			int damage2 = Game.getInstance().rollDice(1);
			character.decrementTrait(trait1, damage1);
			character.decrementTrait(trait2, damage2);
		}

	}

}
