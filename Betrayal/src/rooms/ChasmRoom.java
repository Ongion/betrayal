package rooms;

import java.util.Map;
import java.util.Set;

import rooms.Room.Relative_Direction;
import Game.Game;
import characters.Explorer;
import characters.Character;

public class ChasmRoom extends NormalRoom {

	public ChasmRoom(String name, Set<Relative_Direction> doorExits, Set<Floor_Name> floorsAllowedOn) {
		super(name, doorExits, floorsAllowedOn);
	}
	
	@Override
	public void leavingRoom(Character characterLeavingRoom, Relative_Direction exitAttemptingToLeaveBy) {
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

}
