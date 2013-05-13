package rooms;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import javax.swing.JOptionPane;

import tiles.ActionAddingTile;
import tiles.ITraitRollModifyingTile;
import Game.Game;
import actions.Action;
import characters.Character;
import characters.Trait;

public abstract class Room {
	protected final RoomName name;
	protected Room_Orientation orientation;
	protected Set<Relative_Direction> exits;
	protected Set<Floor_Name> floorsAllowedOn;
	protected Map<Relative_Direction, Integer> windows;
	protected Location currentLocation;
	protected Set<ITraitRollModifyingTile> traitRollModifyingTilesInRoom;
	protected Set<ActionAddingTile> actionAddingTilesInRoom;
	protected Set<Action> roomActions;
	
	protected Room upwardsRoom = null;
	protected Room downwardsRoom = null;
	//TODO: Rooms need to be able to hold items!
	
	protected Relative_Direction sideOfSecretStairs;
	protected Relative_Direction sideOfWallSwitch;
	protected Relative_Direction sideBelowCollapsedRoom;
	protected Relative_Direction sideOfSecretPassage;

	public enum Room_Orientation {NORTH, EAST, SOUTH, WEST};  // Room rotations are defined which way the TOP of the card is pointing. NORTH is "normal", where text on the card is readable
	public enum Relative_Direction {NORTH, EAST, SOUTH, WEST, UP, DOWN};  // Exit directions are relative to a NORTH orientation. For example, the Mystic Elevator ALWAYS has a NORTH exit
	public enum Floor_Name {UPPER, GROUND, BASEMENT};

	public Room (RoomName name, Set<Relative_Direction> exits, Set<Floor_Name> floorsAllowedOn, Map<Relative_Direction, Integer> windows) {
		this.name = name;
		this.exits = exits;
		this.floorsAllowedOn = floorsAllowedOn;
		this.windows = windows;
		
		this.roomActions = new HashSet<Action>();
		this.traitRollModifyingTilesInRoom = new HashSet<ITraitRollModifyingTile>();
		this.actionAddingTilesInRoom = new HashSet<ActionAddingTile>();

		// Add the room to the room deck!
		//		Game.getInstance().addToRoomDeck(this);
	}

	public String getName() {
		return ResourceBundle.getBundle("rooms/RoomsBundle", Game.getInstance().getLocale()).getString(this.name+"-Name");
	}
	
	public RoomName getNameEnum() {
		return this.name;
	}
	
	public Set<Action> getRoomActions() {
		return this.roomActions;
	}
	
	public void addRoomAction(Action actionToAddToRoom) {
		this.roomActions.add(actionToAddToRoom);
	}
	
	public void removeRoomAction(Action actionToRemoveFromRoom) {
		this.roomActions.remove(actionToRemoveFromRoom);
	}
	
	public void addUpwardExit(Room roomConnectingTo) {
		this.exits.add(Relative_Direction.UP);
		this.upwardsRoom = roomConnectingTo;
	}
	
	public void addDownwardExit(Room roomConnectingTo) {
		this.exits.add(Relative_Direction.DOWN);
		this.downwardsRoom = roomConnectingTo;
	}
	
	public boolean isBarrierRoom() {
		return false;
	}
	
	public void addActionAddingTile(ActionAddingTile tileToBeAdded) {
		this.actionAddingTilesInRoom.add(tileToBeAdded);
	}
	
	public void removeActionAddingTile(ActionAddingTile tileToBeRemoved) {
		this.actionAddingTilesInRoom.remove(tileToBeRemoved);
	}
	
	public void addTraitRollModifyingTile(ITraitRollModifyingTile tileToBeAdded) {
		this.traitRollModifyingTilesInRoom.add(tileToBeAdded);
	}
	
	public void removeTraitRollModifyingTile(ITraitRollModifyingTile tileToBeRemoved) {
		this.traitRollModifyingTilesInRoom.remove(tileToBeRemoved);
	}

	public void flipCard() {
		// EventRooms and the like implement this method to get a card and make it happen
	}
	
	protected boolean testTraitAndDecrementOnLeavingRoom(Character characterLeavingRoom, Trait traitBeingTestedAgainst, int targetResult, Trait traitDecrementedIfFailed) {
		int rollResult = characterLeavingRoom.getTraitRoll(traitBeingTestedAgainst);
		boolean doesCharacterStillWantToLeaveTheRoom = true;
		if (rollResult < targetResult) {
			doesCharacterStillWantToLeaveTheRoom = (Game.getInstance().makeYesNoDialogAndGetResult("FailedRollTitle", "FailedRollMessage") == JOptionPane.YES_OPTION);
			if (doesCharacterStillWantToLeaveTheRoom) {
				characterLeavingRoom.decrementTrait(traitDecrementedIfFailed, 1);
			} else {
				characterLeavingRoom.endMovement();
			}
		}
		return doesCharacterStillWantToLeaveTheRoom;
	}


	public Location getLocation() {
		return this.currentLocation;
	}

	public void setPlacement(Room_Orientation orientationOfRoom, Location locationRoomWillBePlaced) { 
		if (!this.floorsAllowedOn.contains(locationRoomWillBePlaced.getFloor())) {									   
			throw new RuntimeException(String.format("The %s is not allowed on the %s floor", this.getName(), locationRoomWillBePlaced.getFloor().toString()));
		}
		if (!locationRoomWillBePlaced.equals(this.currentLocation)) {
			Room roomAtLocation = Game.getInstance().getRoomAtLocation(locationRoomWillBePlaced);
			if (roomAtLocation != null) {
				throw new RuntimeException(String.format("The %s is already at that location", roomAtLocation.getName()));
			}
		}
		Game.getInstance().addRoomToMap(this);

		this.orientation = orientationOfRoom;
		this.currentLocation = locationRoomWillBePlaced;		
	}

	private Room getRoomFromDirection(Relative_Direction directionChecking) {
		/* Returns the room in the given direction, regardless of door connections */
		return Game.getInstance().getRoomAtLocation(this.getLocationOfRoomAtExit(directionChecking));
	}

	public Room getRoomFromExit(Relative_Direction exitDirection) {
		return getExitMap().get(exitDirection);
	}

	public Room getRoomFromExitAbsoluteDirection(Relative_Direction exitDirection){
		return this.getRoomFromExit(this.convertAbsoluteDirectionToRoomRelativeDirection(exitDirection));
	}
	
	private Relative_Direction convertRoomRelativeDirectionToAbsoluteDirection(Relative_Direction direction) {
		switch(this.orientation) {
		case NORTH:
			return direction;
		case SOUTH:
			switch(direction) {
			case NORTH:
				return Relative_Direction.SOUTH;
			case EAST:
				return Relative_Direction.WEST;
			case SOUTH:
				return Relative_Direction.NORTH;
			case WEST:
				return Relative_Direction.EAST;
			default:
				return direction;
			}
		case EAST:
			switch(direction) {
			case NORTH:
				return Relative_Direction.EAST;
			case EAST:
				return Relative_Direction.SOUTH;
			case SOUTH:
				return Relative_Direction.WEST;
			case WEST:
				return Relative_Direction.NORTH;
			default:
				return direction;
			}
		case WEST:
			switch(direction) {
			case NORTH:
				return Relative_Direction.WEST;
			case EAST:
				return Relative_Direction.NORTH;
			case SOUTH:
				return Relative_Direction.EAST;
			case WEST:
				return Relative_Direction.SOUTH;
			default:
				return direction;
			}
		}
		return direction;
	}

	public Relative_Direction convertAbsoluteDirectionToRoomRelativeDirection(Relative_Direction dir){
		switch (this.orientation){
			case NORTH:
				return dir;
			case SOUTH:
				switch (dir){
					case NORTH:
						return Relative_Direction.SOUTH;
					case SOUTH:
						return Relative_Direction.NORTH;
					case EAST:
						return Relative_Direction.WEST;
					case WEST:
						return Relative_Direction.EAST;
					default:
						return dir;
						//Things that aren't actually directions but are in the direction enum anyways
				}
			case EAST:
				switch (dir){
					case NORTH:
						return Relative_Direction.WEST;
					case SOUTH:
						return Relative_Direction.EAST;
					case EAST:
						return Relative_Direction.NORTH;
					case WEST:
						return Relative_Direction.SOUTH;
					default:
						return dir;
						//Things that aren't actually directions but are in the direction enum anyways
 
				}
			case WEST:
				switch (dir){
					case NORTH:
						return Relative_Direction.EAST;
					case SOUTH:
						return Relative_Direction.WEST;
					case EAST:
						return Relative_Direction.SOUTH;
					case WEST:
						return Relative_Direction.NORTH;
					default:
						return dir;
						//Things that aren't actually directions but are in the direction enum anyways, even though they shouldn't be
 
				}
			default:
				//How the fuck did you get here....
				return dir;
		}
	}

	private HashMap<Relative_Direction, Room> getExitMap() {
		HashMap<Relative_Direction, Room> exitMap = new HashMap<Relative_Direction, Room>();
		for (Relative_Direction exitDirection : this.getExits()) {
			Location exitLocation = this.getLocationOfRoomAtExit(exitDirection);
			Room roomAtExit = Game.getInstance().getRoomAtLocation(exitLocation);
			if (roomAtExit != null && roomAtExit.getExitCoordinatesMap().containsValue(currentLocation)) {
				exitMap.put(exitDirection, roomAtExit);
			}
		}
		return exitMap;
	}

	private HashMap<Relative_Direction, Location> getExitCoordinatesMap() {
		HashMap<Relative_Direction, Location> exitCoordinatesMap = new HashMap<Relative_Direction, Location>();
		for (Relative_Direction exitDirection : this.getExits()) {
			Location exitCoordinates = this.getLocationOfRoomAtExit(exitDirection);
			exitCoordinatesMap.put(exitDirection, exitCoordinates);
		}
		return exitCoordinatesMap;
	}

	public Floor_Name getFloor() {
		return this.currentLocation.getFloor();
	}

	public Set<Relative_Direction> getExits() {
		return this.exits;
	}
	
	public Set<Relative_Direction> getAbsoluteExits() {
		HashSet<Relative_Direction> absoluteExits = new HashSet<Relative_Direction>();
		for (Relative_Direction exit : this.exits) {
			absoluteExits.add(this.convertRoomRelativeDirectionToAbsoluteDirection(exit));
		}
		return absoluteExits;
	}


	public Room_Orientation getOrientation() {
		return this.orientation;
	}

	public int getExternalWindows() {
		int numExternalWindows = 0;
		for (Relative_Direction direction : this.windows.keySet()) {
			if (this.getRoomFromDirection(direction) == null) {
				numExternalWindows += this.windows.get(direction);
			}
		}
		return numExternalWindows;
	}

	public void endTurnInRoom(Character characterEndingTurn) {
		// only rooms that have ending actions implement this 
	}

	public void leaveRoomInAbsoluteDirection(Character characterLeavingRoom, Relative_Direction exitAttemptingToLeaveBy) {
		Room nextRoom = this.getRoomFromExitAbsoluteDirection(exitAttemptingToLeaveBy);
		characterLeavingRoom.enterRoomGoingInAbsoluteDirection(nextRoom, exitAttemptingToLeaveBy);
	}

	public void enterRoomGoingInAbsoluteDirection(Character characterEnteringRoom, Relative_Direction directionMovingWhenEnteringRoom) {
		Relative_Direction sideOfRoomCharacterIsOn;
		switch (directionMovingWhenEnteringRoom){
		case NORTH:
			sideOfRoomCharacterIsOn = this.convertAbsoluteDirectionToRoomRelativeDirection(Relative_Direction.SOUTH);
			break;
		case SOUTH:
			sideOfRoomCharacterIsOn = this.convertAbsoluteDirectionToRoomRelativeDirection(Relative_Direction.NORTH);
			break;
		case EAST:
			sideOfRoomCharacterIsOn = this.convertAbsoluteDirectionToRoomRelativeDirection(Relative_Direction.WEST);
			break;
		case WEST:
			sideOfRoomCharacterIsOn = this.convertAbsoluteDirectionToRoomRelativeDirection(Relative_Direction.EAST);
			break;
		default:
			sideOfRoomCharacterIsOn = directionMovingWhenEnteringRoom;
			break;
		}
		characterEnteringRoom.setSideOfRoom(sideOfRoomCharacterIsOn);

	}


	private Location getLocationOfRoomAtExit(Relative_Direction usingExit) {

		Location locationOfNewRoom = null;

		switch (usingExit) {
		case NORTH:
			switch(this.getOrientation()) {
			case NORTH:
				locationOfNewRoom = this.currentLocation.getFloorLocationToNorth();
				break;
			case EAST:
				locationOfNewRoom = this.currentLocation.getFloorLocationToEast();
				break;
			case SOUTH:
				locationOfNewRoom = this.currentLocation.getFloorLocationToSouth();
				break;
			case WEST:
				locationOfNewRoom = this.currentLocation.getFloorLocationToWest();
				break;
			}
			break;
		case EAST:
			switch (this.getOrientation()) {
			case NORTH:
				locationOfNewRoom = this.currentLocation.getFloorLocationToEast();
				break;
			case EAST:
				locationOfNewRoom = this.currentLocation.getFloorLocationToSouth();
				break;
			case SOUTH:
				locationOfNewRoom = this.currentLocation.getFloorLocationToWest();
				break;
			default:  // case WEST
				locationOfNewRoom = this.currentLocation.getFloorLocationToNorth();
				break;
			}
			break;
		case SOUTH:
			switch (this.getOrientation()) {
			case NORTH:
				locationOfNewRoom = this.currentLocation.getFloorLocationToSouth();
				break;
			case EAST:
				locationOfNewRoom = this.currentLocation.getFloorLocationToWest();
				break;
			case SOUTH:
				locationOfNewRoom = this.currentLocation.getFloorLocationToNorth();
				break;
			default: //case WEST
				locationOfNewRoom = this.currentLocation.getFloorLocationToEast();
				break;
			}
			break;
		case WEST:
			switch (this.getOrientation()) {
			case NORTH:
				locationOfNewRoom = this.currentLocation.getFloorLocationToWest();
				break;
			case EAST:
				locationOfNewRoom = this.currentLocation.getFloorLocationToNorth();
				break;
			case SOUTH:
				locationOfNewRoom = this.currentLocation.getFloorLocationToEast();
				break;
			default:  // case WEST
				locationOfNewRoom = this.currentLocation.getFloorLocationToSouth();
				break;
			}
			break;
		case UP:
			locationOfNewRoom = this.upwardsRoom == null ? null : this.upwardsRoom.getLocation();
			break;
		case DOWN:
			locationOfNewRoom = this.downwardsRoom == null? null : this.downwardsRoom.getLocation();
			break;
		}
		return locationOfNewRoom;
	}



	@Override
	public boolean equals(Object other) {
		if (other instanceof Room) {
			Room otherRoom = (Room) other;
			return (this.getNameEnum().equals(otherRoom.getNameEnum()) && this.exits.equals(otherRoom.exits) && this.floorsAllowedOn.equals(otherRoom.floorsAllowedOn) && this.windows.equals(otherRoom.windows));
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int prime = 31;
		int result = 1;
		result = prime * result + (this.name== null? 0 : name.hashCode());
		result = prime * result + (this.floorsAllowedOn.hashCode());
		result = prime * result + (this.windows.hashCode());
		return result;
	}

	public int getTraitRollModifier(Character characterMakingRoll) {
		int modifier = 0;
		for (ITraitRollModifyingTile tile : this.traitRollModifyingTilesInRoom) {
				modifier += tile.getModifierForCharacter(characterMakingRoll);
			}
		return modifier;
	}
}