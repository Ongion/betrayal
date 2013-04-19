package Game;

import itemCards.ItemCard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import omenCards.OmenCard;
import rooms.Room;
import characters.Character;
import characters.Explorer;
import characters.Character.Trait;
import eventCards.EventCard;
import floors.Floor;
import floors.Location;

public class Game {
	
	private Floor[] map; // TODO Remove this, only here for old tests.
	private Set<Room> mapRooms; 
	private ArrayList<Room> roomDeck;
	private ArrayList<EventCard> eventDeck;
	private ArrayList<OmenCard> omenDeck;
	private ArrayList<ItemCard> itemDeck;
	private ArrayList<Room> roomDiscard = new ArrayList<Room>();
	private ArrayList<EventCard> eventDiscard = new ArrayList<EventCard>();
	private ArrayList<OmenCard> omenDiscard = new ArrayList<OmenCard>();
	private ArrayList<ItemCard> itemDiscard = new ArrayList<ItemCard>();
	private ArrayList<Player> players;
	private ArrayList<Character> characters;
	private int currentCharacter;
	private int numOmens = 0;
	private Boolean isHaunt = false;
	
	private static Game INSTANCE = new Game();
	
	private Game() {
		//Set up map
		this.mapRooms = new HashSet<Room>();
		
		//Create arrays for decks
		this.roomDeck = new ArrayList<Room>();
		this.eventDeck = new ArrayList<EventCard>();
		this.omenDeck = new ArrayList<OmenCard>();
		this.itemDeck = new ArrayList<ItemCard>();
		
		//Create arrays for discard piles
		this.roomDiscard = new ArrayList<Room>();
		this.eventDiscard = new ArrayList<EventCard>();
		this.omenDiscard = new ArrayList<OmenCard>();
		this.itemDiscard = new ArrayList<ItemCard>();
		
		//Create array for players
		this.players = new ArrayList<Player>();
		this.characters = new ArrayList<Character>();
		
		this.currentCharacter = 0;
	}

	public static Game getInstance() {
		return INSTANCE;
	}
	
	public static void resetGame() {
		INSTANCE = new Game();
	}
	
	public Game(Floor[] map, ArrayList<Room> roomDeck, ArrayList<EventCard> eventDeck, ArrayList<OmenCard> omenDeck, ArrayList<ItemCard> itemDeck, ArrayList<Player> players){
		this.map = map;
		this.roomDeck = roomDeck;
		this.eventDeck = eventDeck;
		this.omenDeck = omenDeck;
		this.itemDeck = itemDeck;
		this.players = players;
		this.numOmens = omenDeck.size();
		
		this.currentCharacter = 0;
	}
	
	public Boolean getIsHaunt() {
		return isHaunt;
	}

	public void setIsHaunt(Boolean isHaunt) {
		this.isHaunt = isHaunt;
	}
	
	public Set<Room> getMapRooms() {
		return this.mapRooms;
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
	
	public Room peekRoom() {
		return roomDeck.get(0);
	}
	public ItemCard peekItem() {
		return itemDeck.get(0);
	}
	public OmenCard peekOmen() {
		return omenDeck.get(0);
	}
	public EventCard peekEvent() {
		return eventDeck.get(0);
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
	
	public void endCharacterTurn(){
		if(this.currentCharacter < players.size() - 1){
			this.currentCharacter ++;
		} else {
			this.currentCharacter = 0;
		}
	}
	
	public void addRoomToMap(Room roomToBeAdded) {
		this.mapRooms.add(roomToBeAdded);
	}
	
	
	public int rollDice(int numberDice){
		if (numberDice > 8){
			numberDice = 8;
		}
		Random generator = new Random();
		int rollResult = 0;
		for (int i = 0; i < numberDice; i++){
			rollResult += generator.nextInt(2);
		}
		return rollResult;
	}
	
	public int typeRoll(Trait trait){
		int rollResult = 0;
		Character explorer = Game.INSTANCE.getCurrentCharacter();
		switch (trait){
			case KNOWLEDGE: 
				rollResult = rollDice(explorer.getCurrentKnowledge()); break;
			case SANITY: 
				rollResult = rollDice(explorer.getCurrentSanity()); break;
			case SPEED: 
				rollResult = rollDice(explorer.getCurrentSpeed()); break;
			case MIGHT:
				rollResult = rollDice(explorer.getCurrentMight()); break;
		}
		return rollResult;
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
	
	public int getCurrentCharacterIndex(){
		return currentCharacter;
	}

	public Character getCurrentCharacter() {
		return characters.get(currentCharacter);
	}

	public int getNumOmens() {
		return numOmens;
	}
	
	public void addAllToRoomDeck(ArrayList<Room> roomsToAdd) {
		for (Room card : roomsToAdd) {
			this.addToRoomDeck(card);
		}
	}
	
	public void addToRoomDeck(Room roomToAdd) {
		this.roomDeck.add(roomToAdd);		
	}

	public void addAllToItemDeck(ArrayList<ItemCard> itemCardsToAdd) {
		for (ItemCard card : itemCardsToAdd) {
			this.addToItemDeck(card);
		}
	}
	
	public void addToItemDeck(ItemCard itemCardToAdd) {
		this.itemDeck.add(itemCardToAdd);		
	}
	
	public void addAllToOmenDeck(ArrayList<OmenCard> omenCardsToAdd) {
		for (OmenCard card : omenCardsToAdd) {
			this.addToOmenDeck(card);
		}
	}
	
	public void addToOmenDeck(OmenCard omenCardToAdd) {
		this.omenDeck.add(omenCardToAdd);		
		this.numOmens++;
	}

	public void addAllToEventDeck(ArrayList<EventCard> eventCardsToAdd) {
		for (EventCard card : eventCardsToAdd) {
			this.addToEventDeck(card);
		}
	}
	
	public void addToEventDeck(EventCard eventCardToAdd) {
		this.eventDeck.add(eventCardToAdd);		
	}

	public void addPlayer(Player player) {
		this.players.add(player);		
	}

	public void addCharacter(Character character) {
		this.characters.add(character);
	}

	public Room getRoomAtLocation(Location location) {
		for (Room roomChecking : mapRooms) {
			if (roomChecking.getLocation().equals(location)) {
				return roomChecking;
			}
		}
		return null;
	}
}
