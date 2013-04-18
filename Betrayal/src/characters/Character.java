package characters;

import itemCards.ItemCard;

import java.util.ArrayList;
import java.util.ResourceBundle;

import omenCards.OmenCard;
import eventCards.EventCard;
import rooms.Room;
import rooms.Room.Relative_Direction;
import Game.Game;
import Game.Player;

public abstract class Character {
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

	public enum Trait {
		KNOWLEDGE, SANITY, MIGHT, SPEED
	};
	
	private ICharacterType type;

	protected ArrayList<EventCard> eventHand = new ArrayList<EventCard>();
	protected ArrayList<OmenCard> omenHand = new ArrayList<OmenCard>();
	protected ArrayList<ItemCard> itemHand = new ArrayList<ItemCard>();
	
	public Character(Character_Name name) {
		this.name = name;
	}

	public String getName() {
		return ResourceBundle.getBundle("characters.CharacterBundle_"+this.name.toString(), Game.getInstance().getLocale()).getString("name");
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



	
}
