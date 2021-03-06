package Game;

import itemCards.AdrenalineShot;
import itemCards.AmuletOfAges;
import itemCards.AngelFeather;
import itemCards.Armor;
import itemCards.Axe;
import itemCards.Bell;
import itemCards.BloodDagger;
import itemCards.Bottle;
import itemCards.Candle;
import itemCards.DarkDice;
import itemCards.Dynamite;
import itemCards.HealingSalve;
import itemCards.Idol;
import itemCards.ItemCard;
import itemCards.LuckyStone;
import itemCards.MedicalKit;
import itemCards.MusicBox;
import itemCards.PickpocketsGloves;
import itemCards.PuzzleBox;
import itemCards.RabbitsFoot;
import itemCards.Revolver;
import itemCards.SacrificialDagger;
import itemCards.SmellingSalts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import omenCards.Bite;
import omenCards.Book;
import omenCards.CrystalBall;
import omenCards.Dog;
import omenCards.Girl;
import omenCards.HolySymbol;
import omenCards.Madman;
import omenCards.Mask;
import omenCards.Medallion;
import omenCards.OmenCard;
import omenCards.Ring;
import omenCards.Skull;
import omenCards.Spear;
import omenCards.SpiritBoard;
import roomGUI.RoomFrame;
import rooms.Location;
import rooms.Room;
import rooms.Room.Floor_Name;
import rooms.Room.Relative_Direction;
import rooms.Room.Room_Orientation;
import rooms.RoomFactory;
import rooms.RoomName;
import actionGUI.ActionFrame;
import actions.Action;
import characters.Character;
import characters.Trait;
import eventCards.*;

public class Game {
	
	private Locale locale = new Locale("en", "US");
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
	private Trait traitForAction = null;
	
	private static Game INSTANCE = null;
	
	public enum Deck {
		ROOM, EVENT, ITEM, OMEN
	};
	
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
	
	public void addStartingRooms() {
		// Add starting rooms to the map
		RoomFactory rooms = new RoomFactory();
		rooms.makeRoom(RoomName.ENTRANCEHALL).setPlacement(Room_Orientation.NORTH, new Location(Floor_Name.GROUND, 0, 0));
		rooms.makeRoom(RoomName.FOYER).setPlacement(Room_Orientation.NORTH, new Location(Floor_Name.GROUND, 0, 1));
		Room grandstaircase = rooms.makeRoom(RoomName.GRANDSTAIRCASE);
		rooms.makeRoom(RoomName.BASEMENTLANDING).setPlacement(Room_Orientation.NORTH, new Location(Floor_Name.BASEMENT, 0, 0));
		Room upperlanding = rooms.makeRoom(RoomName.UPPERLANDING);
		
		grandstaircase.setPlacement(Room_Orientation.NORTH, new Location(Floor_Name.GROUND, 0, 2));
		upperlanding.setPlacement(Room_Orientation.NORTH, new Location(Floor_Name.UPPER, 0, 0));
		
		grandstaircase.addUpwardExit(upperlanding);
		upperlanding.addDownwardExit(grandstaircase);
	}
	
	public Trait getTraitForAction(){
		return this.traitForAction;
	}
	
	public void setTraitForAction(Trait trait){
		this.traitForAction = trait;
	}

	public static Game getInstance() {
		if (INSTANCE == null) {
			Game.resetGame();
		}
		return INSTANCE;
	}
	
	public static void resetGame() {
		INSTANCE = new Game();
		INSTANCE.addStartingRooms();
		
		INSTANCE.resetDecks();
		
		Collections.shuffle(INSTANCE.itemDeck);
		Collections.shuffle(INSTANCE.omenDeck);
		Collections.shuffle(INSTANCE.eventDeck);
		Collections.shuffle(INSTANCE.roomDeck);
		
		//TODO delete
		RoomFactory rooms = new RoomFactory();
		INSTANCE.roomDeck.add(rooms.makeRoom(RoomName.LIBRARY));
		
	}
	
	public void resetDecks() {
		
		RoomFactory rooms = new RoomFactory();
		
		this.roomDeck.clear();
		for (RoomName name :RoomName.values()){
			if (name == RoomName.FOYER || name == RoomName.ENTRANCEHALL || name == RoomName.GRANDSTAIRCASE || name == RoomName.UPPERLANDING || name == RoomName.BASEMENTLANDING || name == RoomName.CATACOMBS || name == RoomName.TOWER || name == RoomName.CHASM)
				continue;//Can't add starting rooms to the deck.
			this.roomDeck.add(rooms.makeRoom(name));
		}
		
		Locale enLocale = Game.getInstance().getLocale();
		
		//Add Item Cards
		itemDeck.add(new AngelFeather(enLocale));
		itemDeck.add(new AdrenalineShot(enLocale));
		itemDeck.add(new Revolver(enLocale));
		itemDeck.add(new PuzzleBox(enLocale));
		itemDeck.add(new RabbitsFoot(enLocale));
		itemDeck.add(new MedicalKit(enLocale));
		itemDeck.add(new Bottle(enLocale));
		itemDeck.add(new LuckyStone(enLocale));
		itemDeck.add(new SacrificialDagger(enLocale));
		itemDeck.add(new MusicBox(enLocale));
		itemDeck.add(new Bell(enLocale));
		itemDeck.add(new HealingSalve(enLocale));
		itemDeck.add(new Armor(enLocale));
		itemDeck.add(new AmuletOfAges(enLocale));
		itemDeck.add(new Candle(enLocale));
		itemDeck.add(new Dynamite(enLocale));
		itemDeck.add(new PickpocketsGloves(enLocale));
		itemDeck.add(new Axe(enLocale));
		itemDeck.add(new SmellingSalts(enLocale));
		itemDeck.add(new DarkDice(enLocale));
		itemDeck.add(new BloodDagger(enLocale));
		itemDeck.add(new Idol(enLocale));
		
		//Add Omen Cards
		omenDeck.add(new CrystalBall(enLocale));
		omenDeck.add(new Book(enLocale));
		omenDeck.add(new Ring(enLocale));
		omenDeck.add(new Madman(enLocale));
		omenDeck.add(new Spear(enLocale));
		omenDeck.add(new SpiritBoard(enLocale));
		omenDeck.add(new Mask(enLocale));
		omenDeck.add(new Medallion(enLocale));
		omenDeck.add(new Girl(enLocale));
		omenDeck.add(new Bite(enLocale));
		omenDeck.add(new Skull(enLocale));
		omenDeck.add(new HolySymbol(enLocale));
		omenDeck.add(new Dog(enLocale));
		
		
		//Add Event Cards
		eventDeck.add(new Rotten(enLocale));
		eventDeck.add(new TheVoice(enLocale));
		eventDeck.add(new Mirror2(enLocale));
		eventDeck.add(new NightView(enLocale));
		eventDeck.add(new SomethingSlimy(enLocale));
		eventDeck.add(new CreepyCrawlies(enLocale));
		eventDeck.add(new Silence(enLocale));
		eventDeck.add(new MistsFromTheWalls(enLocale));
		eventDeck.add(new HideousShriek(enLocale));
		eventDeck.add(new SomethingHidden(enLocale));
		eventDeck.add(new Footsteps(enLocale));
		eventDeck.add(new Spider(enLocale));
		eventDeck.add(new HangedMen(enLocale));
		eventDeck.add(new BurningMan(enLocale));
		eventDeck.add(new PhoneCall(enLocale));
		eventDeck.add(new AngryBeing(enLocale));
		eventDeck.add(new DisquietingSounds(enLocale));
		eventDeck.add(new JonahsTurn(enLocale));
		eventDeck.add(new Debris(enLocale));
		eventDeck.add(new Mirror(enLocale));
		eventDeck.add(new Funeral(enLocale));
		eventDeck.add(new Possession(enLocale));
		
		
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
//		if(this.currentCharacter < players.size() - 1){
//			this.currentCharacter ++;
//		} else {
//			this.currentCharacter = 0;
//		}
		
		this.currentCharacter ++;
		
		if (this.currentCharacter >= characters.size()){
			this.currentCharacter = 0;
		}
		
		this.getCurrentCharacter().resetMovementCounter();
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
	
	public ArrayList<Character> getCharacters(){
		return characters;
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
	
	public Locale getLocale() {
		return this.locale;
	}
	
	public void setLocale(Locale l) {
		this.locale = l;
		
		this.updateFrames();
	}
	
	// Begin UI stuff
	///CLOVER:OFF
	public int makeYesNoDialogAndGetResult(String titleBundleString, String messageBundleString) {
		ResourceBundle dialogBoxBundle = ResourceBundle.getBundle("Game/DialogBoxBundle", this.getLocale());
		String confirmationBoxTitle = dialogBoxBundle.getString(titleBundleString);
		String confirmationBoxMessage = dialogBoxBundle.getString(messageBundleString);
		int confirmationBoxResult = JOptionPane.CLOSED_OPTION;
		while (confirmationBoxResult == JOptionPane.CLOSED_OPTION) {
			confirmationBoxResult = JOptionPane.showConfirmDialog(null, confirmationBoxMessage, confirmationBoxTitle, JOptionPane.YES_NO_OPTION);
		}
		return confirmationBoxResult;
	}
	
	public Trait chooseAMentalTrait() {
		ResourceBundle dialogBoxBundle = ResourceBundle.getBundle("Game/DialogBoxBundle", this.getLocale());
		String localizedSanity = dialogBoxBundle.getString("SanityTrait");
		String localizedKnowledge = dialogBoxBundle.getString("KnowledgeTrait");
		String localizedMessage = dialogBoxBundle.getString("MentalTraitChoiceMessage");
		Object[] options = {localizedSanity, localizedKnowledge};
		
		int dialogResult = JOptionPane.CLOSED_OPTION;
		while (dialogResult == JOptionPane.CLOSED_OPTION) {
			dialogResult = JOptionPane.showOptionDialog(null, localizedMessage, localizedMessage, JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		}
		if (dialogResult == 0) { // User selected Sanity
			return Trait.SANITY;
		} else { // User selected Knowledge
			return Trait.KNOWLEDGE;
		}
	}
	
	public Trait chooseAPhysicalTrait() {
		ResourceBundle dialogBoxBundle = ResourceBundle.getBundle("Game/DialogBoxBundle", this.getLocale());
		String localizedMight = dialogBoxBundle.getString("MightTrait");
		String localizedSpeed = dialogBoxBundle.getString("SpeedTrait");
		String localizedMessage = dialogBoxBundle.getString("PhysicalTraitChoiceMessage");
		Object[] options = {localizedSpeed, localizedMight};
		
		int dialogResult = JOptionPane.CLOSED_OPTION;
		while (dialogResult == JOptionPane.CLOSED_OPTION) {
			dialogResult = JOptionPane.showOptionDialog(null, localizedMessage, localizedMessage, JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		}
		if (dialogResult == 0) { // User selected Speed
			return Trait.SPEED;
		} else { // User selected Might
			return Trait.MIGHT;
		}

	}
	
	public Trait chooseATrait() {
		ResourceBundle dialogBoxBundle = ResourceBundle.getBundle("Game/DialogBoxBundle", this.getLocale());
		String localizedSanity = dialogBoxBundle.getString("SanityTrait");
		String localizedKnowledge = dialogBoxBundle.getString("KnowledgeTrait");
		String localizedMight = dialogBoxBundle.getString("MightTrait");
		String localizedSpeed = dialogBoxBundle.getString("SpeedTrait");
		String localizedMessage = dialogBoxBundle.getString("TraitChoiceMessage");
		Object[] options = {localizedSanity, localizedKnowledge, localizedMight, localizedSpeed};
		
		int dialogResult = JOptionPane.CLOSED_OPTION;
		while (dialogResult == JOptionPane.CLOSED_OPTION) {
			dialogResult = JOptionPane.showOptionDialog(null, localizedMessage, localizedMessage, JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		}
		if (dialogResult == 0) { // User selected Sanity
			return Trait.SANITY;
		} else if (dialogResult == 1){ // User selected Knowledge
			return Trait.KNOWLEDGE;
		} else if ( dialogResult == 2){ // User selected Might
			return Trait.MIGHT;
		} else { // User selected Speed
			return Trait.SPEED; 
		}
	}
	
	public void chooseOrientaionToAddRoomAndAddIt(Room roomToAdd, Room adjacentRoom, Location l){
		int numExits = roomToAdd.getExits().size();
		
		Room_Orientation directionOfAdjacentExit = null;
		
		//Determine which direction an exit needs to be in.
		if (adjacentRoom.getLocation().equals(l.getFloorLocationToEast())){
			directionOfAdjacentExit = Room_Orientation.EAST;
		} else if (adjacentRoom.getLocation().equals(l.getFloorLocationToWest())){
			directionOfAdjacentExit = Room_Orientation.WEST;
		} else if (adjacentRoom.getLocation().equals(l.getFloorLocationToNorth())){
			directionOfAdjacentExit = Room_Orientation.NORTH;
		} else if (adjacentRoom.getLocation().equals(l.getFloorLocationToSouth())){
			directionOfAdjacentExit = Room_Orientation.SOUTH;
		}
		
		Object[] options = new Object[numExits];
		
		int count = 0;
		for(Relative_Direction dir : roomToAdd.getExits()){
			if (dir == Relative_Direction.UP || dir == Relative_Direction.DOWN) continue;
			switch (dir){
				case NORTH:
					options[count] = directionOfAdjacentExit;
					break;
				case SOUTH:
					switch (directionOfAdjacentExit) {
						case NORTH:
							options[count] = Room_Orientation.SOUTH;
							break;
						case SOUTH:
							options[count] = Room_Orientation.NORTH;
							break;
						case EAST:
							options[count] = Room_Orientation.WEST;
							break;
						case WEST:
							options[count] = Room_Orientation.EAST;
							break;
					}
					break;
				case EAST:
					switch (directionOfAdjacentExit) {
						case NORTH:
							options[count] = Room_Orientation.WEST;
							break;
						case EAST:
							options[count] = Room_Orientation.NORTH;
							break;
						case SOUTH:
							options[count] = Room_Orientation.EAST;
							break;
						case WEST:
							options[count] = Room_Orientation.SOUTH;
							break;	
					}
					break;
				case WEST:
					switch (directionOfAdjacentExit) {
						case NORTH:
							options[count] = Room_Orientation.EAST;
							break;
						case EAST:
							options[count] = Room_Orientation.SOUTH;
							break;
						case SOUTH:
							options[count] = Room_Orientation.WEST;
							break;
						case WEST:
							options[count] = Room_Orientation.NORTH;
							break;	
					}
					break;
			}
			
			
			count++;
		}
		
		// TODO Localize
		String message = "Choose the orientation for the new room.";
		
		int dialogResult = JOptionPane.CLOSED_OPTION;
		while (dialogResult == JOptionPane.CLOSED_OPTION) {
			dialogResult = JOptionPane.showOptionDialog(null, message, message, JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		}
		
		Room_Orientation orientationForRoom = (Room_Orientation) options[dialogResult];
		
		roomToAdd.setPlacement(orientationForRoom, l);
		
		//TODO Ben delete this too
    	Game.getInstance().updateFrames();
		
	}
	
		
	public boolean attemptToFree() {
		ResourceBundle dialogBoxBundle = ResourceBundle.getBundle("Game/DialogBoxBundle", this.getLocale());
		String localizedYes = dialogBoxBundle.getString("Yes");
		String localizedNo = dialogBoxBundle.getString("No");
		String localizedMessage = dialogBoxBundle.getString("attemptToFree");
		Object[] options = {localizedYes, localizedNo};
		
		int dialogResult = JOptionPane.CLOSED_OPTION;
		while (dialogResult == JOptionPane.CLOSED_OPTION) {
			dialogResult = JOptionPane.showOptionDialog(null, localizedMessage, localizedMessage, JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		}
		if (dialogResult == 0) { // User selected Yes
			return true;
		} else { // User selected No
			return false; 
		}
	}
	
	public boolean attemptRoll() {
		ResourceBundle dialogBoxBundle = ResourceBundle.getBundle("Game/DialogBoxBundle", this.getLocale());
		String localizedYes = dialogBoxBundle.getString("Yes");
		String localizedNo = dialogBoxBundle.getString("No");
		String localizedMessage = dialogBoxBundle.getString("attemptRoll");
		Object[] options = {localizedYes, localizedNo};
		
		int dialogResult = JOptionPane.CLOSED_OPTION;
		while (dialogResult == JOptionPane.CLOSED_OPTION) {
			dialogResult = JOptionPane.showOptionDialog(null, localizedMessage, localizedMessage, JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		}
		if (dialogResult == 0) { // User selected Yes
			return true;
		} else { // User selected No
			return false; 
		}
	}
	
	public Trait chooseSpeedOrSanity() {
		ResourceBundle dialogBoxBundle = ResourceBundle.getBundle("Game/DialogBoxBundle", this.getLocale());
		String localizedSanity = dialogBoxBundle.getString("SanityTrait");
		String localizedSpeed = dialogBoxBundle.getString("SpeedTrait");
		String localizedMessage = dialogBoxBundle.getString("TraitChoiceMessage");
		Object[] options = {localizedSanity, localizedSpeed};
		
		int dialogResult = JOptionPane.CLOSED_OPTION;
		while (dialogResult == JOptionPane.CLOSED_OPTION) {
			dialogResult = JOptionPane.showOptionDialog(null, localizedMessage, localizedMessage, JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		}
		if (dialogResult == 0) { // User selected Sanity
			return Trait.SANITY;
		} else { // User selected Speed
			return Trait.SPEED; 
		}
	}
	
	public RoomName chooseGraveyardOrCrypt() {
		ResourceBundle dialogBoxBundle = ResourceBundle.getBundle("Game/DialogBoxBundle", this.getLocale());
		String localizedGraveyard = dialogBoxBundle.getString("Graveyard");
		String localizedCrypt = dialogBoxBundle.getString("Crypt");
		String localizedMessage = dialogBoxBundle.getString("RoomChoiceMessage");
		Object[] options = {localizedGraveyard, localizedCrypt};
		
		int dialogResult = JOptionPane.CLOSED_OPTION;
		while (dialogResult == JOptionPane.CLOSED_OPTION) {
			dialogResult = JOptionPane.showOptionDialog(null, localizedMessage, localizedMessage, JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		}
		if (dialogResult == 0) {
			return RoomName.GRAVEYARD;
		} else {
			return RoomName.CRYPT; 
		}
	}
	
	public ItemCard chooseItemCard(Character characterItemIsChosenFrom) {
		ResourceBundle dialogBoxBundle = ResourceBundle.getBundle("Game/DialogBoxBundle", this.getLocale());
		String localizedMessage = dialogBoxBundle.getString("ItemChoiceMessage");
		Object[] options = characterItemIsChosenFrom.getItemHand().toArray();
		
		int dialogResult = JOptionPane.CLOSED_OPTION;
		while (dialogResult == JOptionPane.CLOSED_OPTION) {
			dialogResult = JOptionPane.showOptionDialog(null, localizedMessage, localizedMessage, JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		}
		return (ItemCard) options[dialogResult];
	}
	
	public Action chooseAnAction(Character characterMakingAction) {
		ArrayList<Action> possibleActions = characterMakingAction.getPossibleActions();		
		Object[] options = possibleActions.toArray();
		int dialogResult = JOptionPane.CLOSED_OPTION;
		while (dialogResult == JOptionPane.CLOSED_OPTION) {
			dialogResult = JOptionPane.showOptionDialog(null, "Choose an exit.", "Exit Chooser", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		}
		return (Action) options[dialogResult];
	}

	///CLOVER:ON

	public Room getRoomByRoomName(RoomName nameOfRoomWanted) {
		for (Room roomChecking : mapRooms) {
			if (roomChecking.getNameEnum().equals(nameOfRoomWanted)) {
				return roomChecking;
			}
		}
		// Guess we CAN get here actually. But that's still ok. Just don't assume it won't be null unless it's a starting room.
		return null;
	}

	public boolean askToStealAnItem() {
		int dialogResult = JOptionPane.CLOSED_OPTION;
		while (dialogResult == JOptionPane.CLOSED_OPTION) {
			//TODO: I18N
			dialogResult = JOptionPane.showOptionDialog(null, "Do you want to steal an item?", null, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, JOptionPane.NO_OPTION);
		}
		return dialogResult == JOptionPane.YES_OPTION;
	}
	
	//TODO Ben delete from here down
	
	private RoomFrame rf;
	private ActionFrame actionFrame;
	
	public RoomFrame getRoomFrame() {
		return this.rf;
	}
	
	public ActionFrame getActionFrame() {
		return this.actionFrame;
	}
	
	public void createAndDisplayFrames(){
		//Display Rooms
		rf = new RoomFrame();
		rf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		rf.display();
		
		actionFrame = new ActionFrame();
		actionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		actionFrame.display();
	}
	
	public void updateFrames(){
		
		this.rf.update();
		
		this.actionFrame.update();
		
		this.rf.repaint();
		this.actionFrame.repaint();
	}

}
