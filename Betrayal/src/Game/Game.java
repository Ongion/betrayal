package Game;

import java.util.ArrayList;
import java.util.Random;

import rooms.Room;
import eventCards.EventCard;
import omenCards.OmenCard;
import itemCards.ItemCard;

public class Game {
	
	private Room[] map = new Room[3]; 
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

	public Game(Room[] map, ArrayList<Room> roomDeck, ArrayList<EventCard> eventDeck, ArrayList<OmenCard> omenDeck, ArrayList<ItemCard> itemDeck, ArrayList<Player> players){
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
		return this.roomDeck.remove(0);
	}
	
	public EventCard drawEvent(){
		return this.eventDeck.remove(0);
	}
	
	public OmenCard drawOmen(){
		return this.omenDeck.remove(0);
	}
	
	public ItemCard drawItem(){
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
		if(this.currentPlayer < players.size()){
			this.currentPlayer ++;
		} else {
			this.currentPlayer = 0;
		}
	}
	
	public int rollDie(int numberDie){
		int sum = 0;
		Random generator = new Random();
		for (int i = 0; i < numberDie; i++){
			sum += generator.nextInt(2);
		}
		return sum;
	}
	
	public int numOmensOut(){
		return this.numOmens - this.omenDeck.size() - this.omenDiscard.size();
	}
	
	public Room[] getMap() {
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
