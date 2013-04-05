package rooms;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import omenCards.OmenCard;
import Game.Game;
import characters.Character;
import floors.Floor.FloorName;

public class OmenRoom extends Room{
	
	public OmenRoom(String name, Room_Orientation orientation,	Set<Room_Direction> doorExits, Set<FloorName> floorsAllowedOn, Map<Room_Direction, Integer> windows) {
		super(name, orientation, doorExits, floorsAllowedOn, windows);
	}

	public OmenRoom(String name, Room_Orientation orientation,	Set<Room_Direction> doorExits, Set<FloorName> floorsAllowedOn) {
		super(name, orientation, doorExits, floorsAllowedOn, new HashMap<Room_Direction, Integer>());
	}
	
	@Override
	public void flipCard() {
		Game game = Game.getInstance();
		OmenCard cardRecieved = game.drawOmen();
		Character currentCharacter = game.getCurrentCharacter();
		currentCharacter.addOmenCard(cardRecieved);
	}

}
