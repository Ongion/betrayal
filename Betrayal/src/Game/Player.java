package Game;

import java.util.ArrayList;

import rooms.Room;
import characters.Explorer;

public class Player {
	
	
	ArrayList<Explorer> characters;
	
	Room location;
	
	public Player(){
		this.characters = new ArrayList<Explorer>();
	}
	
	public void addCharacter(Explorer characterPlayerWillControl) {
		characterPlayerWillControl.setControllingPlayer(this);
		this.characters.add(characterPlayerWillControl);
	}
	
	public ArrayList<Explorer> getCharacters() {
		return this.characters;
	} //Return the character object
	
}
