package Game;

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
	
	void addEventCard(EventCard c) {
		eventHand.add(c);
	}
	void addItemCard(ItemCard c){
		itemHand.add(c);
	}
	void addOmenCard(OmenCard c){
		omenHand.add(c);
	}
	
	ArrayList<EventCard> getEventHand(){
		return this.eventHand;
	}
	ArrayList<OmenCard> getOmenHand(){
		return this.omenHand;
	}
	ArrayList<ItemCard> getItemCard() {
		return this.itemHand;
	}
	
}
