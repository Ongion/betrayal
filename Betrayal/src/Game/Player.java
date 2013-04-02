package Game;

import itemCards.ItemCard;

import java.util.ArrayList;

import omenCards.OmenCard;

import rooms.Room;

import eventCards.EventCard;

import characters.Character;

public class Player {
	
	
	ArrayList<Character> characters;
	
	Room location;
	
	public Player(){
		this.characters = new ArrayList<Character>();
	}
	
	public void addCharacter(Character characterPlayerWillControl) {
		characterPlayerWillControl.setControllingPlayer(this);
		this.characters.add(characterPlayerWillControl);
	}
	
	public ArrayList<Character> getCharacters() {
		return this.characters;
	} //Return the character object
	
}
