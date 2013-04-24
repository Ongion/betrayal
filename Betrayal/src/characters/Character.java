package characters;

import itemCards.ItemCard;

import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Set;

import omenCards.OmenCard;
import eventCards.EventCard;
import floors.Location;
import rooms.Room;
import rooms.Room.Relative_Direction;
import Game.Game;
import Game.Player;
import Game.Game;

public class Character {
	public enum Character_Name{
		FatherRhinehardt,
		ProfessorLongfellow,
		OxBellows,
		DarrinWilliams,
		MadameZostra,
		VivianLopez,
		ZoeIngstrom,
		MissyDubourde,
		JennyLeClerc,
		HeatherGranville,
		BrandonJaspers,
		PeterAkimoto,
	}
	
	protected Character_Name name;

	protected Player playerControlledBy;

	protected Room currentRoom;
	protected Relative_Direction sideOfRoom;
	//Side of room is stored relative to the room

	
	private ICharacterType type;
	private IStats stats;

	protected ArrayList<EventCard> eventHand = new ArrayList<EventCard>();
	protected ArrayList<OmenCard> omenHand = new ArrayList<OmenCard>();
	protected ArrayList<ItemCard> itemHand = new ArrayList<ItemCard>();
	
	public Character(Character_Name name, ICharacterType type, IStats stats) {
		this.name = name;
		this.type = type;
		this.stats = stats;
		
		type.setCharacter(this);
		stats.setCharacter(this);
	}

	public String getName() {
		return ResourceBundle.getBundle("characters.CharacterBundle-"+this.name.toString(), Game.getInstance().getLocale()).getString("name");
	}
	
	public ICharacterType getType() {
		return this.type;
	}
	
	public IStats getStats() {
		return this.stats;
	}
	
	public void setType(ICharacterType newType) {
		this.type = newType;
	}
	
	public int getAge() {
		return stats.getAge();
	}
	
	public int getHeight() {
		return stats.getHeight();
	}
	
	public int getWeight() {
		return stats.getWeight();
	}
	
	public String[] getHobbies() {
		return stats.getHobbies();
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
	
	public int getTraitRoll(Trait traitBeingRolledFor) {
		return this.type.getTraitRoll(traitBeingRolledFor);
	}
	
	public int getCurrentKnowledge() {
		return stats.getCurrentKnowledge();
	}
	
	public int getCurrentSanity() {
		return stats.getCurrentSanity();
	}
	
	public int getCurrentMight() {
		return stats.getCurrentMight();
	}
	
	public int getCurrentSpeed() {
		return stats.getCurrentSpeed();
	}
	
	public void enterRoomGoingInAbsoluteDirection(Room nextRoom, Relative_Direction directionMovingWhenEnteringRoom) {
		type.enterRoomGoingInAbsoluteDirection(nextRoom, directionMovingWhenEnteringRoom);
	}
	
	public boolean attemptMoveInAbsoluteDirection(Relative_Direction dir) {
		currentRoom.leaveRoomInAbsoluteDirection(this, dir);
		return true;
//		Room next = this.currentRoom.getRoomFromExitAbsoluteDirection(dir);
//		if (next == null){
//			return false;
//		}
//		this.currentRoom = next;
//		switch (dir){
//			case NORTH:
//				this.sideOfRoom = this.currentRoom.convertAbsoluteDirectionToRoomRelativeDirection(Relative_Direction.SOUTH);
//				break;
//			case SOUTH:
//				this.sideOfRoom = this.currentRoom.convertAbsoluteDirectionToRoomRelativeDirection(Relative_Direction.NORTH);
//				break;
//			case EAST:
//				this.sideOfRoom = this.currentRoom.convertAbsoluteDirectionToRoomRelativeDirection(Relative_Direction.WEST);
//				break;
//			case WEST:
//				this.sideOfRoom = this.currentRoom.convertAbsoluteDirectionToRoomRelativeDirection(Relative_Direction.EAST);
//				break;
//			default:
//				this.sideOfRoom = dir;
//		}
//		return true;
	}
		
	public void incrementKnowledge() {
		incrementKnowledge(1);
	}

	public void incrementSanity() {
		incrementSanity(1);
	}

	public void incrementMight() {
		incrementMight(1);
	}

	public void incrementSpeed() {
		incrementSpeed(1);
	}
	
	public void decrementKnowledge() {
		decrementKnowledge(1);
	}

	public void decrementSanity() {
		decrementSanity(1);
	}

	public void decrementMight() {
		decrementMight(1);
	}

	public void decrementSpeed(int amount) {
		stats.decrementSpeed(amount);
	}
	
	public void decrementKnowledge(int amount) {
		stats.decrementKnowledge(amount);
	}

	public void decrementSanity(int amount) {
		stats.decrementSanity(amount);
	}

	public void decrementMight(int amount) {
		stats.decrementMight(amount);
	}

	public void decrementSpeed() {
		decrementSpeed(1);
	}
	
	public void incrementKnowledge(int amount) {
		stats.incrementKnowledge(amount);
	}

	public void incrementSanity(int amount) {
		stats.incrementSanity(amount);
	}

	public void incrementMight(int amount) {
		stats.incrementMight(amount);
	}

	public void incrementSpeed(int amount) {
		stats.incrementSpeed(amount);
	}
	
	
	
	public Character getNearestCharacter(){
		ArrayList<Character> characters = new ArrayList<Character>();
		characters.addAll(Game.getInstance().getCharacters());
		
		characters.remove(this);
		
		if (characters.size() == 1){
			return characters.get(0);
		}
		
		ArrayList<PathfindingNode> openList = new ArrayList<PathfindingNode>();
		ArrayList<PathfindingNode> closedList = new ArrayList<PathfindingNode>();
		
		for (Character c: characters){
			PathfindingNode n = new PathfindingNode(c.getCurrentRoom());
			openList.add(n);
		}
		
		while (!closedList.contains(new PathfindingNode(this.getCurrentRoom())) && openList.size() > 0){
			PathfindingNode lowest = getLowestCostNodeTo(openList,this.getCurrentRoom());
			
			Set<Relative_Direction> exits = lowest.getRoom().getExits();
			
			ArrayList<Room> adjacentRooms = new ArrayList<Room>();
			
			for (Relative_Direction dir : exits){
				adjacentRooms.add(lowest.getRoom().getRoomFromExit(dir));
			}
			
			for (Room r : adjacentRooms){
				if (r != null){
					PathfindingNode newNode = new PathfindingNode(r,lowest,lowest.getGCost()+1);
					if (!closedList.contains(newNode) && !openList.contains(newNode)){
						openList.add(newNode);
					}
				}
				
				
			}
			
			openList.remove(lowest);
			closedList.add(lowest);
		}
		
		if (openList.isEmpty()){
			return null;
		}
		
		PathfindingNode last = null;
		for (PathfindingNode n : closedList){
			if (n.getRoom().equals(this.getCurrentRoom())){
				last = n;
				break;
			}
		}
		
		while (last.getParent() != null){
			last = last.getParent();
		}
		
		
		for (Character c :characters){
			if (c.getCurrentRoom().equals(last.getRoom())){
				return c;
			}
		}
		
		//This return should never happen
		return null;
	}
	
	private PathfindingNode getLowestCostNodeTo(ArrayList<PathfindingNode> openList, Room r){
		int lowestScore = openList.get(0).getScoreToRoom(r);
		PathfindingNode lowestNode = openList.get(0);
		
		for(PathfindingNode n: openList){
			int score = n.getScoreToRoom(r); 
			if (score < lowestScore){
				lowestScore = score;
				lowestNode = n;
			}
		}
		
		return lowestNode;
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
		
		public int getScoreToRoom(Room r){
			Location l = r.getLocation();
			Location cur = room.getLocation();
			int xDif = Math.abs(cur.getX() - l.getX());
			int yDif = Math.abs(cur.getY()- l.getY());
			
			return xDif + yDif + gCost;
		}
		
		public Room getRoom(){
			return this.room;
		}
		
		public int getGCost(){
			return this.gCost;
		}
		
		public boolean equals(Object obj){
			if (obj instanceof PathfindingNode){
				PathfindingNode n = ((PathfindingNode) obj);
				return this.room.equals(n.getRoom());
			}
			return false;
		}
		
		public PathfindingNode getParent() {
			return this.parent;
		}
		
	}

	public int getTrait(Trait traitGetting) {
		int traitAmount = 0;
		switch(traitGetting) {
		case KNOWLEDGE:
			traitAmount = getCurrentKnowledge();
			break;
		case MIGHT:
			traitAmount = getCurrentMight();
			break;
		case SANITY:
			traitAmount = getCurrentSanity();
			break;
		case SPEED:
			traitAmount = getCurrentSpeed();
			break;
		default:
			// How did you get here?
			break;
		}
		return traitAmount;

	}
}
