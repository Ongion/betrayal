package rooms;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import Game.Game;
import characters.Explorer;
import floors.Location;

public abstract class Room {
	protected final String name;
	protected Room_Orientation orientation;
	protected final Set<Relative_Direction> exits;
	protected Set<Floor_Name> floorsAllowedOn;
	protected Map<Relative_Direction, Integer> windows;
	protected Location currentLocation;
	
	
	protected Room otherEndOfSecretStairs = null;
	protected Room otherEndOfWallSwitch = null;
	
	public enum Room_Orientation {NORTH, EAST, SOUTH, WEST};  // Room rotations are defined which way the TOP of the card is pointing. NORTH is "normal", where text on the card is readable
	public enum Relative_Direction {NORTH, EAST, SOUTH, WEST, SECRETSTAIRS, WALLSWITCH};  // Exit directions are relative to a NORTH orientation. For example, the Mystic Elevator ALWAYS has a NORTH exit
	public enum Floor_Name {UPPER, GROUND, BASEMENT};
	
	public Room (String name, Set<Relative_Direction> exits, Set<Floor_Name> floorsAllowedOn, Map<Relative_Direction, Integer> windows) {
		this.name = name;
		this.exits = exits;
		this.floorsAllowedOn = floorsAllowedOn;
		this.windows = windows;
		
		// Add the room to the room deck!
//		Game.getInstance().addToRoomDeck(this);
	}
	
	public String getName() {
		return this.name;
	}
	
	public boolean hasConnection() {
		return !this.getExitMap().isEmpty();
	}
	
	public void addSecretStairs(Room roomConnectingTo) {
		this.exits.add(Relative_Direction.SECRETSTAIRS);
		this.otherEndOfSecretStairs = roomConnectingTo;
	}
	
//	public void setHasSecretStairs(boolean newHasStairs) {
//		this.hasSecretStairs = newHasStairs;
//	}
//	
//	public boolean getHasSecretStairs() {
//		return this.hasSecretStairs;
//	}
//	
//	public Room getExitThroughSecretStairs() {
//		if (!this.hasSecretStairs) {
//			throw new RuntimeException(String.format("Room %s doesn't have secret stairs!", this.getName()));
//		}
//		return this.otherEndOfSecretStairs;
//	}
//	
//	public void addSecretStairsToRoom(Room roomConnectingTo) {
//		this.setHasSecretStairs(true);
//		this.otherEndOfSecretStairs = roomConnectingTo;
//		roomConnectingTo.addSecretStairsFromRoom(this);
//	}
//	
//	private void addSecretStairsFromRoom(Room roomConnectingFrom) {
//		this.setHasSecretStairs(true);
//		this.otherEndOfSecretStairs = roomConnectingFrom;
//	}
	
	public void flipCard() {
		// EventRooms and the like implement this method to get a card and make it happen
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
		return Game.getInstance().getRoomAtLocation(this.getLocationOfRoomAtExit(directionChecking));
	}
		
	public Room getRoomFromExit(Relative_Direction exitDirection) {
		return getExitMap().get(exitDirection);
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
	
	public void endTurnInRoom(Explorer characterEndingTurn) {
		// only rooms that have ending actions implement this 
	}
	
	public void leavingRoom(Explorer characterLeavingRoom, Relative_Direction exitAttemptingToLeaveBy) {
		//only rooms that have room-leaving actions implement this
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
		case SECRETSTAIRS:
			locationOfNewRoom = this.otherEndOfSecretStairs.getLocation();
			break;
		case WALLSWITCH:
			locationOfNewRoom = this.otherEndOfWallSwitch.getLocation();
		}
		return locationOfNewRoom;
	}

	
	
	@Override
	public boolean equals(Object other) {
		if (other instanceof Room) {
			Room otherRoom = (Room) other;
			return (this.name.equals(otherRoom.getName()) && this.exits.equals(otherRoom.exits) && this.floorsAllowedOn.equals(otherRoom.floorsAllowedOn) && this.windows.equals(otherRoom.windows));
		} else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		int prime = 31;
		int result = 1;
		result = prime * result + (this.name== null? 0 : name.hashCode());
		result = prime * result + (this.exits.hashCode());
		result = prime * result + (this.floorsAllowedOn.hashCode());
		result = prime * result + (this.windows.hashCode());
		return result;
	}


	
	
}
