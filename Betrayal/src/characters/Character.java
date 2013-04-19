package characters;

import itemCards.ItemCard;

import java.util.ArrayList;

import omenCards.OmenCard;
import eventCards.EventCard;
import rooms.Room;
import rooms.Room.Relative_Direction;
import Game.Player;
import Game.Game;

public abstract class Character {
	protected String name;

	protected Player playerControlledBy;

	protected Room currentRoom;
	protected Relative_Direction sideOfRoom;
	//Side of room is stored relative to the room

	public enum Trait {
		KNOWLEDGE, SANITY, MIGHT, SPEED
	};

	protected ArrayList<EventCard> eventHand = new ArrayList<EventCard>();
	protected ArrayList<OmenCard> omenHand = new ArrayList<OmenCard>();
	protected ArrayList<ItemCard> itemHand = new ArrayList<ItemCard>();

	public String getName() {
		return name;
	}

	// Add a card to each hand
	public void addEventCard(EventCard c) {
		eventHand.add(c);
	}

	public void addItemCard(ItemCard c) {
		itemHand.add(c);
	}

	public void addOmenCard(OmenCard c) {
		omenHand.add(c);
	}

	// Add remove the given card from the hand and return if it was succesful or
	// now
	public boolean removeEventCard(EventCard c) {
		return eventHand.remove(c);
	}

	public boolean removeItemCard(ItemCard c) {
		return itemHand.remove(c);
	}

	public boolean removeOmenCard(OmenCard c) {
		return omenHand.remove(c);
	}

	// Return the characters hand
	public ArrayList<EventCard> getEventHand() {
		return this.eventHand;
	}

	public ArrayList<OmenCard> getOmenHand() {
		return this.omenHand;
	}

	public ArrayList<ItemCard> getItemHand() {
		return this.itemHand;
	}

	public void setControllingPlayer(Player p) {
		this.playerControlledBy = p;
	}

	public void endMovement() {
		// TODO Implement this. Probably will call a method in Game?
	}

	public void setCurrentRoom(Room room) {
		this.currentRoom = room;
	}

	public Room getCurrentRoom() {
		return this.currentRoom;
	}

	public void setSideOfRoom(Relative_Direction side) {
		this.sideOfRoom = side;
	}

	public Relative_Direction getSideOfRoom() {
		return this.sideOfRoom;
	}
	
	public boolean moveInAbsoluteDirection(Relative_Direction dir) {
		Room next = this.currentRoom.getRoomFromExitAbsoluteDirection(dir);
		if (next == null){
			return false;
		}
		this.currentRoom = next;
		switch (dir){
			case NORTH:
				this.sideOfRoom = this.currentRoom.convertAbsoluteDirectionToRoomRelativeDirection(Relative_Direction.SOUTH);
				break;
			case SOUTH:
				this.sideOfRoom = this.currentRoom.convertAbsoluteDirectionToRoomRelativeDirection(Relative_Direction.NORTH);
				break;
			case EAST:
				this.sideOfRoom = this.currentRoom.convertAbsoluteDirectionToRoomRelativeDirection(Relative_Direction.WEST);
				break;
			case WEST:
				this.sideOfRoom = this.currentRoom.convertAbsoluteDirectionToRoomRelativeDirection(Relative_Direction.EAST);
				break;
			default:
				this.sideOfRoom = dir;
		}
		return true;
	}
	
	public abstract int getCurrentSanity();
	public abstract int getCurrentKnowledge();
	public abstract int getCurrentMight();
	public abstract int getCurrentSpeed();

	
	/* I don't like having the methods below here be part of character.
	 * They really only exist in explorer but I understand that a lot of test will break
	 * if I delete them so I'll leave them for now.
	 */
	public void incrementKnowledge() {
		// Only implemented by Explorers
	}

	public void incrementSanity() {
		// Only implemented by Explorers
	}

	public void incrementMight() {
		// Only implemented by Explorers
	}

	public void incrementSpeed() {
		// Only implemented by Explorers
	}
	
	public void decrementKnowledge() {
		// Only implemented by Explorers
	}

	public void decrementSanity() {
		// Only implemented by Explorers
	}

	public void decrementMight() {
		// Only implemented by Explorers
	}

	public void decrementSpeed(int amount) {
		// Only implemented by Explorers
	}
	
	public void decrementKnowledge(int amount) {
		// Only implemented by Explorers
	}

	public void decrementSanity(int amount) {
		// Only implemented by Explorers
	}

	public void decrementMight(int amount) {
		// Only implemented by Explorers
	}

	public void decrementSpeed() {
		// Only implemented by Explorers
	}
	
	public void incrementKnowledge(int amount) {
		// Only implemented by Explorers
	}

	public void incrementSanity(int amount) {
		// Only implemented by Explorers
	}

	public void incrementMight(int amount) {
		// Only implemented by Explorers
	}

	public void incrementSpeed(int amount) {
		// Only implemented by Explorers
	}
	
	
	
	
	

	public Character getNearestCharacter(){
		ArrayList<Character> characters = new ArrayList<Character>();
		characters.addAll(Game.getInstance().getCharacters());
		
		characters.remove(this);
		
		if (characters.size() == 1){
			return characters.get(0);
		}
		
		return null;
	}



	private class PathfindingNode{
		PathfindingNode parent = null;
		int gCost = 0;
		Room room;
		
		public PathfindingNode(Room room){
			this.room = room;
		}
		
		public PathfindingNode(Room room, PathfindingNode parent, int gCost){
			this.room = room;
			this.parent = parent;
			this.gCost = gCost;
		}
		
		
		
	}
}
