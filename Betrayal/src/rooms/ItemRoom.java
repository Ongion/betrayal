package rooms;

import itemCards.ItemCard;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import Game.Game;
import characters.Character;
import characters.Explorer;

public class ItemRoom extends Room{
	
	public ItemRoom(String name, Set<Relative_Direction> doorExits, Set<Floor_Name> floorsAllowedOn, Map<Relative_Direction, Integer> windows) {
		super(name, doorExits, floorsAllowedOn, windows);
	}

	public ItemRoom(String name, Set<Relative_Direction> doorExits, Set<Floor_Name> floorsAllowedOn) {
		super(name, doorExits, floorsAllowedOn, new HashMap<Relative_Direction, Integer>());
	}
	
	@Override
	public void flipCard() {
		ItemCard cardRecieved = Game.getInstance().drawItem();
		Character currentCharacter = Game.getInstance().getCurrentCharacter();
		currentCharacter.addItemCard(cardRecieved);
	}

}
