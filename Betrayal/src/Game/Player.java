package Game;

import itemCards.ItemCard;

import java.util.ArrayList;

import omenCards.OmenCard;

import rooms.Room;

import eventCards.EventCard;

import characters.Character;

public class Player {
	
	
	ArrayList<EventCard> eventHand = new ArrayList<EventCard>();
	ArrayList<OmenCard> omenHand = new ArrayList<OmenCard>();
	ArrayList<ItemCard> itemHand = new ArrayList<ItemCard>();
	
	Character character;
	
	Room location;
	
	public Player(Character character2){
		this.character = character2;
	}
	
	//Add a card to each hand
	public void addEventCard(EventCard c) {
		eventHand.add(c);
	}
	public void addItemCard(ItemCard c){
		itemHand.add(c);
	}
	public void addOmenCard(OmenCard c){
		omenHand.add(c);
	}
	
	//Add remove the given card from the hand and return if it was succesful or now
	public boolean removeEventCard(EventCard c) {
		return eventHand.remove(c);
	}
	public boolean removeItemCard(ItemCard c){
		return itemHand.remove(c);
	}
	public boolean removeOmenCard(OmenCard c){
		return omenHand.remove(c);
	}
	
	//Return the players hand
	public ArrayList<EventCard> getEventHand(){
		return this.eventHand;
	}
	public ArrayList<OmenCard> getOmenHand(){
		return this.omenHand;
	}
	public ArrayList<ItemCard> getItemHand() {
		return this.itemHand;
	}
	
	public Character getCharacter() {
		return this.character;
	} //Return the character object
	
}
