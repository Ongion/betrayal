package rooms;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import omenCards.OmenCard;
import Game.Game;
import characters.Character;

public class OmenRoom extends Room{
	
	public OmenRoom(RoomName name, Set<Relative_Direction> doorExits, Set<Floor_Name> floorsAllowedOn, Map<Relative_Direction, Integer> windows) {
		super(name, doorExits, floorsAllowedOn, windows);
	}

	public OmenRoom(RoomName name, Set<Relative_Direction> doorExits, Set<Floor_Name> floorsAllowedOn) {
		super(name, doorExits, floorsAllowedOn, new HashMap<Relative_Direction, Integer>());
	}
	
	@Override
	public void flipCard() {
		Game game = Game.getInstance();
		OmenCard cardRecieved = game.drawOmen();
		Character currentCharacter = game.getCurrentCharacter();
		currentCharacter.addOmenCard(cardRecieved);
	}

}
