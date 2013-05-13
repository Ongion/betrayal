package eventCards;

import java.util.Locale;

import rooms.RoomName;

import characters.Trait;
import characters.Character;

import Game.Game;

public class Funeral extends EventCard {

	public Funeral(Locale loc) {
		super("Funeral", loc);
	}

	@Override
	public void happen(int rollResult) {
		// For testing purposes only
		if (rollResult >= 4){
			Game.getInstance().getCurrentCharacter().incrementSanity();
		} else if (rollResult >= 2 && rollResult <= 3){
			Game.getInstance().getCurrentCharacter().decrementSanity();
		} else{
			Game.getInstance().getCurrentCharacter().decrementSanity();
			Game.getInstance().getCurrentCharacter().decrementMight();
		}
	}

	@Override
	public void happens() {
		Character character = Game.getInstance().getCurrentCharacter();
		int rollResult = character.getTraitRoll(Trait.SANITY);
		if (rollResult >= 4){
			character.incrementSanity();
		} else if ((rollResult >= 2) && (rollResult <= 3)){
			character.decrementSanity();
		} else{
			character.decrementSanity();
			character.decrementMight();
			if(Game.getInstance().getRoomByRoomName(RoomName.GRAVEYARD) != null && Game.getInstance().getRoomByRoomName(RoomName.CRYPT) != null){
				RoomName room = Game.getInstance().chooseGraveyardOrCrypt();
				character.setCurrentRoom(Game.getInstance().getRoomByRoomName(room));
			} else if (Game.getInstance().getRoomByRoomName(RoomName.GRAVEYARD) != null && Game.getInstance().getRoomByRoomName(RoomName.CRYPT) == null){
				character.setCurrentRoom(Game.getInstance().getRoomByRoomName(RoomName.GRAVEYARD));
			} else if (Game.getInstance().getRoomByRoomName(RoomName.GRAVEYARD) == null && Game.getInstance().getRoomByRoomName(RoomName.CRYPT) != null){
				character.setCurrentRoom(Game.getInstance().getRoomByRoomName(RoomName.CRYPT));
			}
		}
	}

}
