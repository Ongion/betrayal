package itemCards;

import java.util.Locale;

import Game.Game;

import rooms.Room;

import characters.Character;

public class PickpocketsGloves extends ItemCard {

	public PickpocketsGloves(Locale loc) {
		super("PickpoketsGloves", loc);
	
	}

	@Override
	public
	void whatToDo(Character character) {
		Game currentGame = Game.getInstance();
		Room currentRoom = character.getCurrentRoom();
		for(int i = 0 ; i < currentGame.getCharacters().size(); i++){
			if(currentGame.getCharacters().get(i).getCurrentRoom() == currentRoom){
				character.getItemHand().remove(this);
			}
		}
		
	}

}
