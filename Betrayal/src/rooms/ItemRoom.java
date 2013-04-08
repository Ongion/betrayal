package rooms;

import itemCards.ItemCard;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import Game.Game;
import characters.Character;

public class ItemRoom extends Room{
	
	public ItemRoom(String name, Room_Orientation orientation,	Set<Room_Direction> doorExits, Set<Floor_Name> floorsAllowedOn, Map<Room_Direction, Integer> windows) {
		super(name, orientation, doorExits, floorsAllowedOn, windows);
	}

	public ItemRoom(String name, Room_Orientation orientation,	Set<Room_Direction> doorExits, Set<Floor_Name> floorsAllowedOn) {
		super(name, orientation, doorExits, floorsAllowedOn, new HashMap<Room_Direction, Integer>());
	}
	
	@Override
	public void flipCard() {
		ItemCard cardRecieved = Game.getInstance().drawItem();
		Character currentCharacter = Game.getInstance().getCurrentCharacter();
		currentCharacter.addItemCard(cardRecieved);
	}

}