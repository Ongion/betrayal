package Game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import rooms.Room;
import eventCards.EventCard;
import floors.Floor;
import omenCards.OmenCard;
import itemCards.ItemCard;

public class Game {
	
	private Floor[] map = new Floor[3]; 
	private ArrayList<Room> roomDeck;
	private ArrayList<EventCard> eventDeck;
	private ArrayList<OmenCard> omenDeck;
	private ArrayList<ItemCard> itemDeck;
	private ArrayList<Room> roomDiscard = new ArrayList<Room>();
	private ArrayList<EventCard> eventDiscard = new ArrayList<EventCard>();
	private ArrayList<OmenCard> omenDiscard = new ArrayList<OmenCard>();
	private ArrayList<ItemCard> itemDiscard = new ArrayList<ItemCard>();
	private ArrayList<Player> players;
	private int currentPlayer = 0;
	private int numOmens = 0;
	private Boolean isHaunt = false;

	public Game(Floor[] map, ArrayList<Room> roomDeck, ArrayList<EventCard> eventDeck, ArrayList<OmenCard> omenDeck, ArrayList<ItemCard> itemDeck, ArrayList<Player> players){
		this.map = map;
		this.roomDeck = roomDeck;
		this.eventDeck = eventDeck;
		this.omenDeck = omenDeck;
		this.itemDeck = itemDeck;
		this.players = players;
		this.numOmens = omenDeck.size();
	}
	
	public Boolean getIsHaunt() {
		return isHaunt;
	}

	public void setIsHaunt(Boolean isHaunt) {
		this.isHaunt = isHaunt;
	}
	
	public Room drawRoom(){
		// TODO: Handle when discard is empty too
		if(this.roomDeck.size() == 0){
			Collections.shuffle(this.roomDiscard);
			for (int i = 0; i < this.roomDiscard.size(); i++){
				this.roomDeck.add(this.roomDiscard.get(i));
			}
			this.roomDiscard.clear();
		}
		return this.roomDeck.remove(0);
	}
	
	public EventCard drawEvent(){
		// TODO: Handle when discard is empty too
		if(this.eventDeck.size() == 0){
			Collections.shuffle(this.eventDiscard);
			for (int i = 0; i < this.eventDiscard.size(); i++){
				this.eventDeck.add(this.eventDiscard.get(i));
			}
			this.eventDiscard.clear();
		}
		return this.eventDeck.remove(0);
	}
	
	public OmenCard drawOmen(){
		// TODO: Handle when discard is empty too
		if(this.omenDeck.size() == 0){
			Collections.shuffle(this.omenDiscard);
			for (int i = 0; i < this.omenDiscard.size(); i++){
				this.omenDeck.add(this.omenDiscard.get(i));
			}
			this.omenDiscard.clear();
		}
		return this.omenDeck.remove(0);
	}
	
	public ItemCard drawItem(){
		// TODO: Handle when discard is empty too
		if(this.itemDeck.size() == 0){
			Collections.shuffle(this.itemDiscard);
			for (int i = 0; i < this.itemDiscard.size(); i++){
				this.itemDeck.add(this.itemDiscard.get(i));
			}
			this.itemDiscard.clear();
		}
		return this.itemDeck.remove(0);
	}
	
	public void discardRoom(Room room){
		this.roomDiscard.add(room);
	}
	
	public void discardEvent(EventCard card){
		this.eventDiscard.add(card);
	}
	
	public void discardOmen(OmenCard card){
		this.omenDiscard.add(card);
	}
	
	public void discardItem(ItemCard card){
		this.itemDiscard.add(card);
	}
	
	public void nextPlayer(){
		if(this.currentPlayer < players.size() - 1){
			this.currentPlayer ++;
		} else {
			this.currentPlayer = 0;
		}
	}
	
	public int rollDie(int numberDie){
		int sum = 0;
		int die;
		if (numberDie > 8){
			die = 8;
		}
		else 
		{
			die = numberDie;
		}
		Random generator = new Random();
		for (int i = 0; i < die; i++){
			sum += generator.nextInt(2);
		}
		return sum;
	}
	
	public int numOmensOut(){
		return this.numOmens - this.omenDeck.size() - this.omenDiscard.size();
	}
	
	public Floor[] getMap() {
		return map;
	}

	public ArrayList<Room> getRoomDeck() {
		return roomDeck;
	}

	public ArrayList<EventCard> getEventDeck() {
		return eventDeck;
	}

	public ArrayList<OmenCard> getOmenDeck() {
		return omenDeck;
	}

	public ArrayList<ItemCard> getItemDeck() {
		return itemDeck;
	}

	public ArrayList<Room> getRoomDiscard() {
		return roomDiscard;
	}

	public ArrayList<EventCard> getEventDiscard() {
		return eventDiscard;
	}

	public ArrayList<OmenCard> getOmenDiscard() {
		return omenDiscard;
	}

	public ArrayList<ItemCard> getItemDiscard() {
		return itemDiscard;
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public int getCurrentPlayer() {
		return currentPlayer;
	}

	public int getNumOmens() {
		return numOmens;
	}

}
