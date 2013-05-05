package rooms;

import java.util.HashMap;
import java.util.HashSet;

import javax.swing.JOptionPane;

import actions.JumpDownFromGalleryToBallroomAction;
import actions.OpenVaultAction;

import rooms.Room.Floor_Name;
import rooms.Room.Relative_Direction;
import Game.Game;
import characters.Character;
import characters.Trait;

public class RoomFactory {

	public RoomFactory() {}
	
	public Room makeRoom(RoomName nameOfRoom) {
		HashSet<Relative_Direction> roomExits = new HashSet<Relative_Direction>();
		HashSet<Floor_Name> roomFloors = new HashSet<Floor_Name>();
		HashMap<Relative_Direction,Integer> roomWindows = new HashMap<Relative_Direction, Integer>();
		Room room = null;
		switch(nameOfRoom) {
		case GARDENS:
			roomExits.add(Relative_Direction.NORTH);
			roomExits.add(Relative_Direction.SOUTH);
			roomFloors.add(Floor_Name.GROUND);
			room = new EventRoom(nameOfRoom, roomExits, roomFloors);
			break;
		case ORGANROOM:
			roomExits.add(Relative_Direction.SOUTH);
			roomExits.add(Relative_Direction.WEST);
			roomFloors.add(Floor_Name.UPPER);
			roomFloors.add(Floor_Name.GROUND);
			roomFloors.add(Floor_Name.BASEMENT);
			room = new EventRoom(nameOfRoom, roomExits, roomFloors);
			break;
		case DININGROOM:
			roomExits.add(Relative_Direction.NORTH);
			roomExits.add(Relative_Direction.EAST);
			roomFloors.add(Floor_Name.GROUND);
			roomWindows.put(Relative_Direction.WEST, 2);
			room = new OmenRoom(nameOfRoom, roomExits, roomFloors, roomWindows);
			break;
		case ENTRANCEHALL:
			roomExits.add(Relative_Direction.EAST);
			roomExits.add(Relative_Direction.WEST);
			roomExits.add(Relative_Direction.NORTH);
			roomFloors.add(Floor_Name.GROUND);
			room = new NormalRoom(nameOfRoom, roomExits, roomFloors);
			break;
		case FOYER:
			roomExits.add(Relative_Direction.EAST);
			roomExits.add(Relative_Direction.WEST);
			roomExits.add(Relative_Direction.NORTH);
			roomExits.add(Relative_Direction.SOUTH);
			roomFloors.add(Floor_Name.GROUND);
			room = new NormalRoom(nameOfRoom, roomExits, roomFloors);
			break;
		case GRANDSTAIRCASE:
			roomExits.add(Relative_Direction.SOUTH);
			roomExits.add(Relative_Direction.UP);
			roomFloors.add(Floor_Name.GROUND);
			roomWindows.put(Relative_Direction.WEST, 2);
			room = new NormalRoom(nameOfRoom, roomExits, roomFloors, roomWindows);
			break;
		case JUNKROOM:
			roomExits.add(Relative_Direction.NORTH);
			roomExits.add(Relative_Direction.EAST);
			roomExits.add(Relative_Direction.WEST);
			roomExits.add(Relative_Direction.SOUTH);
			roomFloors.add(Floor_Name.UPPER);
			roomFloors.add(Floor_Name.GROUND);
			roomFloors.add(Floor_Name.BASEMENT);
			room = new OmenRoom(nameOfRoom, roomExits, roomFloors) {
				public void leaveRoomInAbsoluteDirection(Character characterLeavingRoom, Relative_Direction exitAttemptingToLeaveBy) { 
					/* 
					 * When exiting, you must attempt a Might roll of 3+
					 * If you fail, lose 1 Speed (but continue moving). 
					 */
					if (testTraitAndDecrementOnLeavingRoom(characterLeavingRoom, Trait.MIGHT, 3, Trait.SPEED)) {
						super.leaveRoomInAbsoluteDirection(characterLeavingRoom, exitAttemptingToLeaveBy);
					}
				}
			};
			break;
		case BASEMENTLANDING:
			roomExits.add(Relative_Direction.NORTH);
			roomExits.add(Relative_Direction.EAST);
			roomExits.add(Relative_Direction.SOUTH);
			roomExits.add(Relative_Direction.WEST);
			roomExits.add(Relative_Direction.UP);
			roomFloors.add(Floor_Name.BASEMENT);
			room = new NormalRoom(nameOfRoom, roomExits, roomFloors);
			break;
		case CATACOMBS:
			roomExits.add(Relative_Direction.NORTH);
			roomExits.add(Relative_Direction.SOUTH);
			roomFloors.add(Floor_Name.BASEMENT);
			room = new OmenRoom(nameOfRoom, roomExits, roomFloors) {
				public void leaveRoomInAbsoluteDirection(Character characterLeavingRoom, Relative_Direction exitAttemptingToLeaveBy) {
					/* 
					 * When exiting, you must attempt a Sanity roll of 6+ to cross
					 * If you fail, you stop moving. 
					 */
					
					if (!characterLeavingRoom.getSideOfRoom().equals(exitAttemptingToLeaveBy)) {
						int diceToRoll = characterLeavingRoom.getCurrentSanity();
						int TARGET_RESULT = 6;
						int rollResult = Game.getInstance().rollDice(diceToRoll);
						System.out.println(String.format("Rolled %d dice and got a %d", diceToRoll, rollResult));
						if (rollResult < TARGET_RESULT) {
							characterLeavingRoom.endMovement();
							System.out.println(String.format("%s had to stop moving.", characterLeavingRoom.getName()));
						} else {
							System.out.println(String.format("%s made it across.", characterLeavingRoom.getName()));
						}
					}
				}
				
				public boolean isBarrierRoom() {
					return true;
				}
			};
			break;
		case CHASM:
			roomExits.add(Relative_Direction.EAST);
			roomExits.add(Relative_Direction.WEST);
			roomFloors.add(Floor_Name.BASEMENT);
			room = new NormalRoom(nameOfRoom, roomExits, roomFloors) {
				public void leaveRoomInAbsoluteDirection(Character characterLeavingRoom, Relative_Direction exitAttemptingToLeaveBy) {
					/* 
					 * When exiting, you must attempt a Speed roll of 3+ to cross
					 * If you fail, you stop moving. 
					 */
					
					if (!characterLeavingRoom.getSideOfRoom().equals(exitAttemptingToLeaveBy)) {
						int diceToRoll = characterLeavingRoom.getCurrentSpeed();
						int TARGET_RESULT = 3;
						int rollResult = Game.getInstance().rollDice(diceToRoll);
						System.out.println(String.format("Rolled %d dice and got a %d", diceToRoll, rollResult));
						if (rollResult < TARGET_RESULT) {
							characterLeavingRoom.endMovement();
							System.out.println(String.format("%s had to stop moving.", characterLeavingRoom.getName()));
						} else {
							System.out.println(String.format("%s made it across.", characterLeavingRoom.getName()));
						}
					}
				}
				
				public boolean isBarrierRoom() {
					return true;
				}
			};
			break;
		case PENTAGRAMCHAMBER:
			roomExits.add(Relative_Direction.EAST);
			roomFloors.add(Floor_Name.BASEMENT);
			room = new OmenRoom(nameOfRoom, roomExits, roomFloors) {
				public void leaveRoomInAbsoluteDirection(Character characterLeavingRoom, Relative_Direction exitAttemptingToLeaveBy) { 
					/* 
					 * When exiting, you must attempt a Knowledge roll of 4+
					 * If you fail, lose 1 Sanity (but continue moving). 
					 */
					if (testTraitAndDecrementOnLeavingRoom(characterLeavingRoom, Trait.KNOWLEDGE, 4, Trait.SANITY)) {
						super.leaveRoomInAbsoluteDirection(characterLeavingRoom, exitAttemptingToLeaveBy);
					}
				}
			};
			break;
		case CREAKYHALLWAY:
			roomExits.add(Relative_Direction.NORTH);
			roomExits.add(Relative_Direction.EAST);
			roomExits.add(Relative_Direction.SOUTH);
			roomExits.add(Relative_Direction.WEST);
			roomFloors.add(Floor_Name.UPPER);
			roomFloors.add(Floor_Name.GROUND);
			roomFloors.add(Floor_Name.BASEMENT);
			room = new NormalRoom(nameOfRoom, roomExits, roomFloors);
			break;
		case SERVANTSQUARTERS:
			roomExits.add(Relative_Direction.NORTH);
			roomExits.add(Relative_Direction.EAST);
			roomExits.add(Relative_Direction.SOUTH);
			roomExits.add(Relative_Direction.WEST);
			roomFloors.add(Floor_Name.UPPER);
			roomFloors.add(Floor_Name.BASEMENT);
			room = new OmenRoom(nameOfRoom, roomExits, roomFloors);
			break;
		case MASTERBEDROOM:
			roomExits.add(Relative_Direction.NORTH);
			roomExits.add(Relative_Direction.WEST);
			roomFloors.add(Floor_Name.UPPER);
			roomWindows.put(Relative_Direction.SOUTH, 2);
			room = new OmenRoom(nameOfRoom, roomExits, roomFloors, roomWindows);
			break;
		case BEDROOM:
			roomExits.add(Relative_Direction.EAST);
			roomExits.add(Relative_Direction.WEST);
			roomFloors.add(Floor_Name.UPPER);
			roomWindows.put(Relative_Direction.SOUTH, 1);
			room = new EventRoom(nameOfRoom, roomExits, roomFloors, roomWindows);
			break;
		case DUSTYHALLWAY:
			roomExits.add(Relative_Direction.NORTH);
			roomExits.add(Relative_Direction.EAST);
			roomExits.add(Relative_Direction.SOUTH);
			roomExits.add(Relative_Direction.WEST);
			roomFloors.add(Floor_Name.UPPER);
			roomFloors.add(Floor_Name.GROUND);
			roomFloors.add(Floor_Name.BASEMENT);
			room = new NormalRoom(nameOfRoom, roomExits, roomFloors);
			break;
		case UNDERGROUNDLAKE:
			roomExits.add(Relative_Direction.NORTH);
			roomExits.add(Relative_Direction.EAST);
			roomFloors.add(Floor_Name.BASEMENT);
			room = new EventRoom(nameOfRoom, roomExits, roomFloors);
			break;
		case STATUARYCORRIDOR:
			roomExits.add(Relative_Direction.NORTH);
			roomExits.add(Relative_Direction.SOUTH);
			roomFloors.add(Floor_Name.UPPER);
			roomFloors.add(Floor_Name.GROUND);
			roomFloors.add(Floor_Name.BASEMENT);
			room = new EventRoom(nameOfRoom, roomExits, roomFloors);
			break;
		case STOREROOM:
			roomExits.add(Relative_Direction.NORTH);
			roomFloors.add(Floor_Name.UPPER);
			roomFloors.add(Floor_Name.BASEMENT);
			room = new ItemRoom(nameOfRoom, roomExits, roomFloors);
			break;
		case BLOODYROOM:
			roomExits.add(Relative_Direction.NORTH);
			roomExits.add(Relative_Direction.EAST);
			roomExits.add(Relative_Direction.SOUTH);
			roomExits.add(Relative_Direction.WEST);
			roomFloors.add(Floor_Name.UPPER);
			roomFloors.add(Floor_Name.GROUND);
			room = new ItemRoom(nameOfRoom, roomExits, roomFloors);
			break;
		case WINECELLAR:
			roomExits.add(Relative_Direction.NORTH);
			roomExits.add(Relative_Direction.SOUTH);
			roomFloors.add(Floor_Name.BASEMENT);
			room = new ItemRoom(nameOfRoom, roomExits, roomFloors);
			break;
		case VAULT:
			roomExits.add(Relative_Direction.NORTH);
			roomFloors.add(Floor_Name.UPPER);
			roomFloors.add(Floor_Name.BASEMENT);
			room = new EventRoom(nameOfRoom, roomExits, roomFloors);
			room.addRoomAction(new OpenVaultAction(room));
			break;
		case UPPERLANDING:
			roomExits.add(Relative_Direction.NORTH);
			roomExits.add(Relative_Direction.EAST);
			roomExits.add(Relative_Direction.SOUTH);
			roomExits.add(Relative_Direction.WEST);
			roomExits.add(Relative_Direction.DOWN);
			roomFloors.add(Floor_Name.UPPER);
			room = new NormalRoom(nameOfRoom, roomExits, roomFloors);
			break;
		case GRAVEYARD:
			roomExits.add(Relative_Direction.SOUTH);
			roomFloors.add(Floor_Name.GROUND);
			room = new EventRoom(nameOfRoom, roomExits, roomFloors) {
				public void leaveRoomInAbsoluteDirection(Character characterLeavingRoom, Relative_Direction exitAttemptingToLeaveBy) {
					/* 
					 * When exiting, you must attempt a Sanity roll of 4+.
					 * If you fail, you lose 1 Knowledge (but continue moving) 
					 */
					if (testTraitAndDecrementOnLeavingRoom(characterLeavingRoom, Trait.SANITY, 4, Trait.KNOWLEDGE)) {
						super.leaveRoomInAbsoluteDirection(characterLeavingRoom, exitAttemptingToLeaveBy);
					}
				}
			};
			break;
		case PATIO:
			roomExits.add(Relative_Direction.NORTH);
			roomExits.add(Relative_Direction.WEST);
			roomExits.add(Relative_Direction.SOUTH);
			roomFloors.add(Floor_Name.GROUND);
			room = new EventRoom(nameOfRoom, roomExits, roomFloors);
			break;
		case BALCONY:
			roomExits.add(Relative_Direction.NORTH);
			roomExits.add(Relative_Direction.SOUTH);
			roomFloors.add(Floor_Name.UPPER);
			room = new OmenRoom(nameOfRoom, roomExits, roomFloors);
			break;
		case TOWER:
			roomExits.add(Relative_Direction.EAST);
			roomExits.add(Relative_Direction.WEST);
			roomFloors.add(Floor_Name.UPPER);
			room = new EventRoom(nameOfRoom, roomExits, roomFloors) {
				public void leaveRoomInAbsoluteDirection(Character characterLeavingRoom, Relative_Direction exitAttemptingToLeaveBy) {
					/* 
					 * When exiting, you must attempt a Might roll of 3+ to cross
					 * If you fail, you stop moving. 
					 */
					
					if (!characterLeavingRoom.getSideOfRoom().equals(exitAttemptingToLeaveBy)) {
						int diceToRoll = characterLeavingRoom.getCurrentMight();
						int TARGET_RESULT = 3;
						int rollResult = Game.getInstance().rollDice(diceToRoll);
						System.out.println(String.format("Rolled %d dice and got a %d", diceToRoll, rollResult));
						if (rollResult < TARGET_RESULT) {
							characterLeavingRoom.endMovement();
							System.out.println(String.format("%s had to stop moving.", characterLeavingRoom.getName()));
						} else {
							System.out.println(String.format("%s made it across.", characterLeavingRoom.getName()));
						}
					}
				}
				
				public boolean isBarrierRoom() {
					return true;
				}
			};
			break;
		case GALLERY:
			roomExits.add(Relative_Direction.NORTH);
			roomExits.add(Relative_Direction.SOUTH);
			roomFloors.add(Floor_Name.UPPER);
			room = new OmenRoom(nameOfRoom, roomExits, roomFloors);
			room.addRoomAction(new JumpDownFromGalleryToBallroomAction());
			break;
		case BALLROOM:
			roomExits.add(Relative_Direction.NORTH);
			roomExits.add(Relative_Direction.EAST);
			roomExits.add(Relative_Direction.SOUTH);
			roomExits.add(Relative_Direction.WEST);
			roomFloors.add(Floor_Name.GROUND);
			room = new EventRoom(nameOfRoom, roomExits, roomFloors);
			break;
		case STAIRSFROMBASEMENT:
			roomExits.add(Relative_Direction.SOUTH);
			roomExits.add(Relative_Direction.UP);
			roomFloors.add(Floor_Name.GROUND);
			room = new NormalRoom(nameOfRoom, roomExits, roomFloors) {
				public void flipCard() {
					this.addUpwardExit(Game.getInstance().getRoomByRoomName(RoomName.FOYER));
					Game.getInstance().getRoomByRoomName(RoomName.FOYER).addDownwardExit(this);
				}
			};
			break;
		case ATTIC:
			roomExits.add(Relative_Direction.SOUTH);
			roomFloors.add(Floor_Name.UPPER);
			room = new EventRoom(nameOfRoom, roomExits, roomFloors) {
				public void leaveRoomInAbsoluteDirection(Character characterLeavingRoom, Relative_Direction exitAttemptingToLeaveBy) {
					/* 
					 * When exiting, you must attempt a Speed roll of 3+.
					 * If you fail, you lose 1 Might (but continue moving) 
					 */
					if (testTraitAndDecrementOnLeavingRoom(characterLeavingRoom, Trait.SPEED, 3, Trait.MIGHT)) {
						super.leaveRoomInAbsoluteDirection(characterLeavingRoom, exitAttemptingToLeaveBy);
					}
				}
			};
			break;
		case GAMEROOM:
			roomExits.add(Relative_Direction.NORTH);
			roomExits.add(Relative_Direction.EAST);
			roomExits.add(Relative_Direction.SOUTH);
			roomFloors.add(Floor_Name.UPPER);
			roomFloors.add(Floor_Name.GROUND);
			roomFloors.add(Floor_Name.BASEMENT);
			room = new EventRoom(nameOfRoom, roomExits, roomFloors);
			break;
		case CONSERVATORY:
			roomExits.add(Relative_Direction.NORTH);
			roomFloors.add(Floor_Name.UPPER);
			roomFloors.add(Floor_Name.GROUND);
			room = new EventRoom(nameOfRoom, roomExits, roomFloors);
			break;
		case CHARREDROOM:
			roomExits.add(Relative_Direction.NORTH);
			roomExits.add(Relative_Direction.EAST);
			roomExits.add(Relative_Direction.SOUTH);
			roomExits.add(Relative_Direction.WEST);
			roomFloors.add(Floor_Name.UPPER);
			roomFloors.add(Floor_Name.GROUND);
			room = new OmenRoom(nameOfRoom, roomExits, roomFloors);
			break;
		case ABANDONEDROOM:
			roomExits.add(Relative_Direction.NORTH);
			roomExits.add(Relative_Direction.EAST);
			roomExits.add(Relative_Direction.SOUTH);
			roomExits.add(Relative_Direction.WEST);
			roomFloors.add(Floor_Name.UPPER);
			roomFloors.add(Floor_Name.GROUND);
			room = new OmenRoom(nameOfRoom, roomExits, roomFloors);
			break;
		case KITCHEN:
			roomExits.add(Relative_Direction.NORTH);
			roomExits.add(Relative_Direction.EAST);
			roomFloors.add(Floor_Name.GROUND);
			roomFloors.add(Floor_Name.BASEMENT);
			room = new OmenRoom(nameOfRoom, roomExits, roomFloors);
			break;
		case RESEARCHLABORATORY:
			roomExits.add(Relative_Direction.NORTH);
			roomExits.add(Relative_Direction.SOUTH);
			roomFloors.add(Floor_Name.UPPER);
			roomFloors.add(Floor_Name.BASEMENT);
			room = new EventRoom(nameOfRoom, roomExits, roomFloors);
			break;
		case OPERATINGLABORATORY:
			roomExits.add(Relative_Direction.SOUTH);
			roomExits.add(Relative_Direction.EAST);
			roomFloors.add(Floor_Name.UPPER);
			roomFloors.add(Floor_Name.BASEMENT);
			room = new EventRoom(nameOfRoom, roomExits, roomFloors);
			break;
			
		}
		return room;
	}
	

}
