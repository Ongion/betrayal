package rooms;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import Game.Game;
import characters.Character;

import floors.Floor;
import floors.Floor.FloorName;
import floors.FloorLocation;

public abstract class Room {
	protected final String name;
	protected Room_Orientation orientation;
	protected final Set<Room_Direction> doorExits;
	protected Set<FloorName> floorsAllowedOn;
	protected Map<Room_Direction, Integer> windows;
	protected Game game;
	protected Floor currentFloor;
	protected FloorLocation currentLocation;
	
	protected boolean hasSecretStairs = false;
	protected Room otherEndOfSecretStairs = null;
	
	public enum Room_Orientation {NORTH, EAST, SOUTH, WEST};  // Room rotations are defined which way the TOP of the card is pointing. NORTH is "normal", where text on the card is readable
	public enum Room_Direction {NORTH, EAST, SOUTH, WEST};  // Room directions are relative to a NORTH orientation. For example, the Mystic Elevator ALWAYS has a southern exit
	
	
	public Room (String name, Room_Orientation orientation, Set<Room_Direction> doorExits, Map<Room_Direction, Integer> windows) {
		this.name = name;
		this.orientation = orientation;
		this.doorExits = doorExits;
		this.windows = windows;
		this.game = Game.getInstance();
		
		// Add the room to the room deck!
		this.game.getRoomDeck().add(this);
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setHasSecretStairs(boolean newHasStairs) {
		this.hasSecretStairs = newHasStairs;
	}
	
	public boolean getHasSecretStairs() {
		return this.hasSecretStairs;
	}
	
	public Room getExitThroughSecretStairs() {
		if (!this.hasSecretStairs) {
			throw new RuntimeException(String.format("Room %s doesn't have secret stairs!", this.getName()));
		}
		return this.otherEndOfSecretStairs;
	}
	
	public void addSecretStairsToRoom(Room roomConnectingTo) {
		this.setHasSecretStairs(true);
		this.otherEndOfSecretStairs = roomConnectingTo;
		roomConnectingTo.addSecretStairsFromRoom(this);
	}
	
	public void addSecretStairsFromRoom(Room roomConnectingFrom) {
		this.setHasSecretStairs(true);
		this.otherEndOfSecretStairs = roomConnectingFrom;
	}
	
	public void flipCard() {
		// EventRooms and the like implement this method to get a card and make it happen
	}
	
	public void setFloor(Floor floorRoomWillBeOn) {
		this.currentFloor = floorRoomWillBeOn;
	}
	
	public FloorLocation getLocation() {
		return this.currentLocation;
	}
	
	public void setLocation(FloorLocation locationOfRoom) {
		this.currentLocation = locationOfRoom;
	}
	
	public Set<FloorLocation> getDoorExitLocations(FloorLocation locationTestingFrom) {
		Set<FloorLocation> locations = new HashSet<FloorLocation>();
		for (Room_Direction exitDirection : this.doorExits) {
			locations.add(locationTestingFrom.getLocationOfRoomAtExit(exitDirection, this.getOrientation()));
		}
		return locations;
	}
	
	public Floor getFloor() {
		return this.currentFloor;
	}
		
	public void setOrientation(Room_Orientation newOrientation) {
		this.orientation = newOrientation;
	}
	
	public Set<Room_Direction> getDoorExits() {
		return this.doorExits;
	}
	
	public Set<FloorLocation> getDoorExitLocations() {
		if (this.getLocation() == null) {
			throw new RuntimeException("This tile hasn't been added to the board yet, and therefore has no location!");
		}
		return this.getDoorExitLocations(this.getLocation());
	}

	
	public Room_Orientation getOrientation() {
		return this.orientation;
	}
	
	public Map<Room_Direction, Integer> getWindows() {
		return this.windows;
	}
	
	public void endTurnInRoom(Character characterEndingTurn) {
		// only rooms that have ending actions implement this 
	}
	
	public void leavingRoom(Character characterLeavingROom) {
		//only rooms that have room-leaving actions implement this
	}
	
	
	@Override
	public boolean equals(Object other) {
		if (other instanceof Room) {
			Room otherRoom = (Room) other;
			return (this.name.equals(otherRoom.getName()) && this.orientation.equals(otherRoom.getOrientation()) && this.doorExits.equals(otherRoom.getDoorExits()) && this.windows.equals(otherRoom.getWindows()));
		} else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		int prime = 31;
		int result = 1;
		result = prime * result + (this.name== null? 0 : name.hashCode());
		result = prime * result + (this.orientation.ordinal());
		return result;
	}

	
	
}
