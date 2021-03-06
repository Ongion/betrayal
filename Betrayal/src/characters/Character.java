package characters;

import itemCards.ItemCard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

import actions.Action;
import actions.DisplayEventCardsAction;
import actions.DisplayItemCardsAction;
import actions.DisplayOmenCardsAction;
import actions.EndTurnAction;
import actions.MoveAction;

import omenCards.OmenCard;
import pathFinding.PathFinding;
import rooms.Room;
import rooms.Room.Relative_Direction;
import Game.Game;
import Game.Player;
import eventCards.EventCard;

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
	private Set<Room> statRoomsThisCharacterHasEndedTurnIn;
	
	private int movementCounter;
	
	public Character(Character_Name name, ICharacterType type, IStats stats) {
		this.name = name;
		this.type = type;
		this.stats = stats;
		this.statRoomsThisCharacterHasEndedTurnIn = new HashSet<Room>();
		
		type.setCharacter(this);
		stats.setCharacter(this);
		
		this.movementCounter = this.getCurrentSpeed();
	}
		
	public void askForAction() {
		Action chosenAction = type.askForAction();
		chosenAction.perform(this);
	}
	
	public void addRoomToStatRoomsEndedTurnIn(Room oneTimeStatAlteringRoom) {
		this.statRoomsThisCharacterHasEndedTurnIn.add(oneTimeStatAlteringRoom);
	}
	
	public boolean hasEndedTurnInRoom(Room oneTimeStatAlteringRoom) {
		return this.statRoomsThisCharacterHasEndedTurnIn.contains(oneTimeStatAlteringRoom);
	}
	
	public ArrayList<Action> getPossibleActions() {
		ArrayList<Action> possibleActions = new ArrayList<Action>();
		
		if (this.movementCounter > 0){
			for (Relative_Direction absoluteExitDirection : this.getCurrentRoom().getAbsoluteExits()) {
				possibleActions.add(new MoveAction(absoluteExitDirection));
			}
		}
		
		Set<Action> roomActions = this.getCurrentRoom().getRoomActions();
		for(Action a : roomActions){
			if (a.canPerform(this)){
				possibleActions.add(a);
			}
		}
		
		if (Game.getInstance().getCurrentCharacter() == this) {
			possibleActions.add(new EndTurnAction());
		}
		
		DisplayItemCardsAction displayItems = new DisplayItemCardsAction();
		if (displayItems.canPerform(this)) possibleActions.add(displayItems);
		
		DisplayOmenCardsAction displayOmens = new DisplayOmenCardsAction();
		if (displayOmens.canPerform(this)) possibleActions.add(displayOmens);
		
		DisplayEventCardsAction displayEvents = new DisplayEventCardsAction();
		if (displayEvents.canPerform(this)) possibleActions.add(displayEvents);
		
		
		return possibleActions;
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

	public void endTurn() {
		Game.getInstance().endCharacterTurn();
	}
	
	public void endMovement() {
		this.movementCounter = 1; //1 so that when it gets decremented it goes to 0
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
		
		//Decrement the movement counter
		this.movementCounter--;
		
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
	
	public void incrementTrait(Trait traitBeingIncremented, int amount) {
		switch(traitBeingIncremented) {
		case KNOWLEDGE:
			incrementKnowledge(amount);
			break;
		case MIGHT:
			incrementMight(amount);
			break;
		case SANITY:
			incrementSanity(amount);
			break;
		case SPEED:
			incrementSpeed(amount);
			break;
		}
	}
	
	public void decrementTrait(Trait traitBeingDecremented, int amount) {
		switch(traitBeingDecremented) {
		case KNOWLEDGE:
			decrementKnowledge(amount);
			break;
		case MIGHT:
			decrementMight(amount);
			break;
		case SANITY:
			decrementSanity(amount);
			break;
		case SPEED:
			decrementSpeed(amount);
			break;
		}
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
		PathFinding path = new PathFinding();
		
		return path.getNearestCharacterTo(this);
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
		}
		return traitAmount;

	}

	public boolean isAffectedByBlessing() {
		return type.isAffectedByBlessing();
	}

	public boolean isAffectedByDrip() {
		return type.isAffectedByDrip();
	}

	public boolean isAffectedBySmoke() {
		return type.isAffectedBySmoke();
	}
	
	public void attack(Character defendingCharacter){
		//TODO: Allow players to choose items they can attack with.
		//TODO: Allow players to attack with the trait of the specified item.
		//TODO: Defending players defend with the same stat they are being attacked with.
		//TODO: If a monster does not have a certain stat, they cannot be attacked with that stat.
		int attackRollResult = Game.getInstance().rollDice(this.getCurrentMight());
		int defendRollResult = Game.getInstance().rollDice(defendingCharacter.getCurrentMight());
		int damageTakenByDefendingCharacter = attackRollResult - defendRollResult;
		if (damageTakenByDefendingCharacter <= 0) {
			// Character took no damage, we're done.
			return;
		} else if (damageTakenByDefendingCharacter >= 2 && Game.getInstance().askToStealAnItem()) {
			// Attacker chose to steal an item instead of inflicting damage.
			// TODO: Only allow stealable item cards
			ItemCard cardBeingStolen = Game.getInstance().chooseItemCard(defendingCharacter);
			defendingCharacter.removeItemCard(cardBeingStolen);
			this.addItemCard(cardBeingStolen);
			return;
		} else {
			// Defender is taking damage.
			//TODO: Sliding scale of damage for Physical and Mental attacks.
			defendingCharacter.decrementTrait(Trait.MIGHT, damageTakenByDefendingCharacter);
			return;
		}
	}
	
	public void resetMovementCounter() {
		this.movementCounter = this.getCurrentSpeed();
	}
	
	public int getMovesLeft() {
		return this.movementCounter;
	}
	
	public String toString() {
		return this.getName();
	}
	
}
