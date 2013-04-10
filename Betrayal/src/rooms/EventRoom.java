package rooms;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import Game.Game;
import characters.Character;
import eventCards.EventCard;

public class EventRoom extends Room{
	
	public EventRoom(String name, Room_Orientation orientation,	Set<Relative_Direction> doorExits, Set<Floor_Name> floorsAllowedOn, Map<Relative_Direction, Integer> windows) {
		super(name, orientation, doorExits, floorsAllowedOn, windows);
	}

	public EventRoom(String name, Room_Orientation orientation,	Set<Relative_Direction> doorExits, Set<Floor_Name> floorsAllowedOn) {
		super(name, orientation, doorExits, floorsAllowedOn, new HashMap<Relative_Direction, Integer>());
	}
	
	@Override
	public void flipCard() {
		EventCard cardRecieved = Game.getInstance().drawEvent();
		Character currentCharacter = Game.getInstance().getCurrentCharacter();
		currentCharacter.addEventCard(cardRecieved);
	}

}
