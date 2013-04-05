package rooms;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import Game.Game;
import characters.Character;
import eventCards.EventCard;
import floors.Floor.FloorName;

public class EventRoom extends Room{
	
	public EventRoom(String name, Room_Orientation orientation,	Set<Room_Direction> doorExits, Set<FloorName> floorsAllowedOn, Map<Room_Direction, Integer> windows) {
		super(name, orientation, doorExits, floorsAllowedOn, windows);
	}

	public EventRoom(String name, Room_Orientation orientation,	Set<Room_Direction> doorExits, Set<FloorName> floorsAllowedOn) {
		super(name, orientation, doorExits, floorsAllowedOn, new HashMap<Room_Direction, Integer>());
	}
	
	@Override
	public void flipCard() {
		EventCard cardRecieved = Game.getInstance().drawEvent();
		Character currentCharacter = Game.getInstance().getCurrentCharacter();
		currentCharacter.addEventCard(cardRecieved);
	}

}
